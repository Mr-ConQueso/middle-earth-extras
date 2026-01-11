package net.mrconqueso.middleearthextras.mixin;

import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import net.mrconqueso.middleearthextras.world.structure.protection.AStructureManager;
import net.mrconqueso.middleearthextras.world.structure.protection.AStructureUtils;
import net.mrconqueso.middleearthextras.world.structure.protection.StructurePlacementState;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(Explosion.class)
public class ExplosionMixin {

    @Shadow @Final private World world;

    @Inject(method = "affectWorld", at = @At("HEAD"))
    private void onAffectWorld(boolean particles, CallbackInfo ci) {
        if (!(world instanceof ServerWorld serverWorld)) return;

        Explosion explosion = (Explosion) (Object) this;
        List<BlockPos> affectedBlocks = explosion.getAffectedBlocks();

        // Check each affected block
        affectedBlocks.removeIf(pos -> {
            var structureIds = AStructureUtils.getStructuresAt(serverWorld, pos);

            for (var structureId : structureIds) {
                AStructureManager.StructureRestriction restriction = AStructureManager.getRestriction(structureId);
                if (restriction == null) continue;

                String instanceKey = AStructureUtils.getStructureInstanceKey(serverWorld, pos, structureId);
                StructurePlacementState placementState = StructurePlacementState.get(serverWorld);

                if (placementState.isUnlocked(instanceKey)) continue;

                // Check if explosions can affect blocks
                if (!restriction.canExplosionsAffectBlocks()) {
                    // Player-placed blocks can still be destroyed
                    if (!placementState.isPlacedByPlayer(instanceKey, pos)) {
                        return true; // Remove from affected list (protect)
                    }
                }
            }
            return false;
        });
    }
}