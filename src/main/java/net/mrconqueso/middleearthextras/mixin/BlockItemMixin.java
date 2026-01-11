package net.mrconqueso.middleearthextras.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.mrconqueso.middleearthextras.block.ModBlocks;
import net.mrconqueso.middleearthextras.util.ModTags;
import net.mrconqueso.middleearthextras.world.structure.protection.AStructureManager;
import net.mrconqueso.middleearthextras.world.structure.protection.AStructureUtils;
import net.mrconqueso.middleearthextras.world.structure.protection.PlayerStructureTracker;
import net.mrconqueso.middleearthextras.world.structure.protection.StructurePlacementState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockItem.class)
public abstract class BlockItemMixin {

    @Inject(method = "place(Lnet/minecraft/item/ItemPlacementContext;)Lnet/minecraft/util/ActionResult;",
            at = @At("RETURN"))
    private void onBlockPlaced(ItemPlacementContext context, CallbackInfoReturnable<ActionResult> cir) {
        if (cir.getReturnValue() != ActionResult.SUCCESS && cir.getReturnValue() != ActionResult.CONSUME) {
            return;
        }

        if (!(context.getPlayer() instanceof ServerPlayerEntity player)) return;
        if (!(context.getWorld() instanceof ServerWorld serverWorld)) return;

        BlockPos pos = context.getBlockPos();

        // Get structures at the placed block position
        var structureIds = AStructureUtils.getStructuresAt(serverWorld, pos);

        for (var structureId : structureIds) {
            AStructureManager.StructureRestriction restriction = AStructureManager.getRestriction(structureId);

            // Only track if this structure type has restrictions
            if (restriction != null) {
                String instanceKey = AStructureUtils.getStructureInstanceKey(serverWorld, pos, structureId);
                StructurePlacementState placementState = StructurePlacementState.get(serverWorld);

                // Don't track if already unlocked
                if (!placementState.isUnlocked(instanceKey)) {
                    placementState.addPlacedByPlayer(instanceKey, pos);
                    PlayerStructureTracker.syncToClient(player);
                }
            }
        }
    }

    @Shadow
    public abstract Block getBlock();

    @Inject(method = "place", at = @At("HEAD"), cancellable = true)
    public void place(ItemPlacementContext context, CallbackInfoReturnable<ActionResult> cir) {
        if (context.getWorld().getBiome(context.getBlockPos()).isIn(ModTags.Biomes.DARK_BIOMES)) {
            if (this.getBlock() == Blocks.TORCH) {
                // Use the DAMP_TORCH item instead
                // We cast the block to Item (assuming it has one registered) and invoke useOnBlock
                // Since context is ItemPlacementContext which extends ItemUsageContext, this is valid.
                cir.setReturnValue(ModBlocks.DAMP_TORCH.asItem().useOnBlock(context));
            }
        }
    }
}