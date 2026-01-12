package net.mrconqueso.middleearthextras.entity.misc;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ChunkTicketType;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.mrconqueso.middleearthextras.network.PalantirNetwork;
import net.mrconqueso.middleearthextras.util.PossessesCamera;

import java.util.Comparator;
import java.util.Optional;
import java.util.UUID;

public class PalantirViewEntity extends Entity implements PossessesCamera {

    private static final TrackedData<Optional<UUID>> USING_PLAYER_ID = DataTracker.registerData(PalantirViewEntity.class, TrackedDataHandlerRegistry.OPTIONAL_UUID);
    private static final int LOAD_DISTANCE = 4;

    private static final ChunkTicketType<ChunkPos> PALANTIR_TICKET = ChunkTicketType.create("palantir_view", Comparator.comparingLong(ChunkPos::toLong), 40);

    public boolean hasTakenFullControl;
    private boolean stopPossession = false;

    public PalantirViewEntity(EntityType<?> type, World world) {
        super(type, world);
        this.noClip = true;
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        builder.add(USING_PLAYER_ID, Optional.empty());
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
        ServerPlayNetworking.send(player, new PalantirNetwork.PalantirSyncPayload(this.getId(), true));
    }

    @Override
    public void remove(RemovalReason reason) {
        if (!getWorld().isClient && getUsingPlayer() instanceof ServerPlayerEntity player) {
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