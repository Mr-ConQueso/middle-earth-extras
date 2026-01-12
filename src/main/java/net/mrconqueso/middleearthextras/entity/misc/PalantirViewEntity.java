package net.mrconqueso.middleearthextras.entity.misc;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ChunkTicketType;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.mrconqueso.middleearthextras.network.PalantirNetwork;
import net.mrconqueso.middleearthextras.util.PossessesCamera;
import org.joml.Vector3f;

import java.util.Comparator;
import java.util.Optional;
import java.util.UUID;

public class PalantirViewEntity extends Entity implements PossessesCamera {

    private static final TrackedData<Optional<UUID>> USING_PLAYER_ID = DataTracker.registerData(PalantirViewEntity.class, TrackedDataHandlerRegistry.OPTIONAL_UUID);
    // Add tracked data for single mode and pivot position so client knows
    private static final TrackedData<Boolean> SINGLE_MODE = DataTracker.registerData(PalantirViewEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    // We can't track Vec3d directly easily, let's track Vector3f or just 3 floats? 
    // Simplified: Track Vector3f
    private static final TrackedData<Vector3f> PIVOT_POS = DataTracker.registerData(PalantirViewEntity.class, TrackedDataHandlerRegistry.VECTOR3F);

    private static final int LOAD_DISTANCE = 4;

    private static final ChunkTicketType<ChunkPos> PALANTIR_TICKET = ChunkTicketType.create("palantir_view", Comparator.comparingLong(ChunkPos::toLong), 40);

    public boolean hasTakenFullControl;
    private boolean stopPossession = false;
    
    private double currentZoom = 0.5; // Server-side zoom state

    public PalantirViewEntity(EntityType<?> type, World world) {
        super(type, world);
        this.noClip = true;
    }

    public void setSingleMode(boolean singleMode, Vec3d pivotPos) {
        this.dataTracker.set(SINGLE_MODE, singleMode);
        this.dataTracker.set(PIVOT_POS, pivotPos.toVector3f());
        this.currentZoom = 0.5;
    }
    
    public boolean isSingleMode() {
        return this.dataTracker.get(SINGLE_MODE);
    }
    
    public Vec3d getPivotPos() {
        return new Vec3d(this.dataTracker.get(PIVOT_POS));
    }

    public void updateZoom(float delta) {
        // Invert delta because usually scroll up (positive) means zoom in (get closer = smaller distance)
        // But here we are adding to currentZoom which is distance from pivot.
        // So scroll up (+1) -> we want distance to decrease -> subtract.
        this.currentZoom -= delta * 1.5; 
        this.currentZoom = Math.max(0.5, Math.min(this.currentZoom, 20.0)); // Clamp distance
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        builder.add(USING_PLAYER_ID, Optional.empty());
        builder.add(SINGLE_MODE, false);
        builder.add(PIVOT_POS, new Vector3f());
    }

    @Override
    public void tick() {
        super.tick();

        Entity user = getUsingPlayer();

        if (!getWorld().isClient()) {
            // Server Side Logic
            if (user == null || !user.isAlive() || stopPossession) {
                this.discard();
                return;
            }

            if (user instanceof ServerPlayerEntity serverPlayer) {
                serverPlayer.setVelocity(0, 0, 0);
                serverPlayer.velocityModified = true;

                loadChunksAround((ServerWorld) getWorld());

                // Synced Mode Logic: Look from the other stone (fixed position, rotation control)
                if (!this.isSingleMode()) {
                    // Sync rotation with player so they can look around
                    this.setYaw(serverPlayer.getYaw());
                    this.setPitch(serverPlayer.getPitch());
                    
                    // Ensure position stays at the pivot (other palantir center + offset)
                    // We set this initially, but force it here to prevent drift or weirdness
                    Vec3d fixedPos = this.getPivotPos().add(0, 1.5, 0);
                    this.setPosition(fixedPos);
                }
                // Single Mode Logic: Telescope behavior
                else {
                    // Sync rotation with player
                    this.setYaw(serverPlayer.getYaw());
                    this.setPitch(serverPlayer.getPitch());

                    // Update Position based on Pivot + Rotation * Zoom
                    // Offset y by 1.5 to be at "eye level" of the block center
                    Vec3d eyePivot = this.getPivotPos().add(0, 1.5, 0);
                    Vec3d lookDir = Vec3d.fromPolar(this.getPitch(), this.getYaw());
                    Vec3d newPos = eyePivot.add(lookDir.multiply(this.currentZoom));
                
                    this.setPosition(newPos);
                }

                if (serverPlayer.isSneaking()) {
                    this.stopPossession = true;
                }
            }
        }
        // Client side logic is handled in MiddleEarthExtrasClient via TickEvents
    }

    @Override
    protected void readCustomDataFromNbt(NbtCompound nbt) { }

    @Override
    protected void writeCustomDataToNbt(NbtCompound nbt) { }

    private void loadChunksAround(ServerWorld serverLevel) {
        ChunkPos center = this.getChunkPos();
        for (int x = -LOAD_DISTANCE; x <= LOAD_DISTANCE; x++) {
            for (int z = -LOAD_DISTANCE; z <= LOAD_DISTANCE; z++) {
                ChunkPos pos = new ChunkPos(center.x + x, center.z + z);
                serverLevel.getChunkManager().addTicket(PALANTIR_TICKET, pos, 2, pos);
            }
        }
    }

    @Override
    public void onPossessionKeyPacket(Entity keyPresser, int type) {
        if (keyPresser.equals(getUsingPlayer())) {
            this.stopPossession = true;
        }
    }

    public void startPossession(ServerPlayerEntity player) {
        this.setUsingPlayerUUID(player.getUuid());

        // Force the client to track this entity immediately.
        player.networkHandler.sendPacket(new EntitySpawnS2CPacket(this, 0, this.getBlockPos()));

        // Update the server-side camera entity as well
        player.setCameraEntity(this);

        ServerPlayNetworking.send(player, new PalantirNetwork.PalantirSyncPayload(this.getId(), true));
    }

    @Override
    public void remove(RemovalReason reason) {
        if (!getWorld().isClient && getUsingPlayer() instanceof ServerPlayerEntity player) {
            player.setCameraEntity(player);
            ServerPlayNetworking.send(player, new PalantirNetwork.PalantirSyncPayload(this.getId(), false));
        }
        super.remove(reason);
    }

    public void setUsingPlayerUUID(UUID uuid) { this.dataTracker.set(USING_PLAYER_ID, Optional.ofNullable(uuid)); }
    public UUID getUsingPlayerUUID() { return this.dataTracker.get(USING_PLAYER_ID).orElse(null); }

    public Entity getUsingPlayer() {
        UUID id = getUsingPlayerUUID();
        return id == null ? null : (getWorld().isClient ? getWorld().getPlayerByUuid(id) : getWorld().getServer().getPlayerManager().getPlayer(id));
    }
}