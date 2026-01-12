package net.mrconqueso.middleearthextras.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtOps;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.GlobalPos;
import net.minecraft.util.math.Vec3d;
import net.mrconqueso.middleearthextras.block.ModBlockEntities;
import net.mrconqueso.middleearthextras.entity.ModEntities;
import net.mrconqueso.middleearthextras.entity.misc.PalantirViewEntity;
import org.jetbrains.annotations.Nullable;

public class PalantirBlockEntity extends BlockEntity {

    // For Feature A: Store the position of the linked Palantir
    @Nullable
    private GlobalPos linkedPalantirPos;

    public PalantirBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.PALANTIR, pos, state);
    }

    public void link(GlobalPos pos) {
        this.linkedPalantirPos = pos;
        this.markDirty();
        // Sync to client immediately upon linking
        if (world instanceof ServerWorld) {
            ((ServerWorld) world).getChunkManager().markForUpdate(getPos());
        }
    }
    
    public GlobalPos getLinkedPos() {
        return this.linkedPalantirPos;
    }

    @Override
    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registryLookup) {
        return createNbt(registryLookup);
    }

    @Nullable
    @Override
    public BlockEntityUpdateS2CPacket toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    public void usePalantir(ServerPlayerEntity player) {
        if (this.world == null) return;

        ServerWorld targetLevel = (ServerWorld) this.world;
        Vec3d pivotPos = Vec3d.ofCenter(this.pos);
        Vec3d initialPos = pivotPos.add(0, 1.5, 0);
        boolean singleMode = true;

        // FEATURE A: If linked, look from the other stone
        if (linkedPalantirPos != null) {
            // GlobalPos is now a Record: use .dimension() instead of .getDimension()
            ServerWorld otherLevel = player.getServer().getWorld(linkedPalantirPos.dimension());
            if (otherLevel != null) {
                targetLevel = otherLevel;
                // GlobalPos is now a Record: use .pos() instead of .getPos()
                pivotPos = Vec3d.ofCenter(linkedPalantirPos.pos());
                initialPos = pivotPos.add(0, 1.5, 0);
                singleMode = false;
            }
        }

        // Create the view entity
        PalantirViewEntity viewEntity = ModEntities.PALANTIR_VIEW.create(targetLevel);
        if (viewEntity != null) {
            // Yarn 1.21: setPosition takes (x, y, z)
            viewEntity.setPosition(initialPos.x, initialPos.y, initialPos.z);

            // Yarn 1.21: setYaw / setPitch
            viewEntity.setYaw(player.getYaw());
            viewEntity.setPitch(player.getPitch());
            
            viewEntity.setSingleMode(singleMode, pivotPos);

            // Yarn 1.21: spawnEntity
            targetLevel.spawnEntity(viewEntity);
            viewEntity.startPossession(player);
        }
    }

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        if (linkedPalantirPos != null) {
            GlobalPos.CODEC.encodeStart(NbtOps.INSTANCE, linkedPalantirPos)
                    .resultOrPartial(err -> {})
                    .ifPresent(tag -> nbt.put("LinkedPalantirPos", tag));
        }
    }

    @Override
    public void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt, registryLookup);
        if (nbt.contains("LinkedPalantirPos")) {
            GlobalPos.CODEC.parse(NbtOps.INSTANCE, nbt.get("LinkedPalantirPos"))
                    .resultOrPartial(err -> {})
                    .ifPresent(pos -> this.linkedPalantirPos = pos);
        }
    }
}