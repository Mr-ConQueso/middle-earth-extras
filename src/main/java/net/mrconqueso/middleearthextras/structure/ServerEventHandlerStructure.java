package net.mrconqueso.middleearthextras.structure;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.block.BlockState;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

/**
 * Handles all structure-related events using Fabric API callbacks.
 * Port of AStages ServerEventHandlerStructure to Fabric 1.21.1.
 */
public class ServerEventHandlerStructure {
    private ServerEventHandlerStructure() {}

    public static void register() {
        // Register server tick for player structure tracking
        ServerTickEvents.END_SERVER_TICK.register(PlayerStructureTracker::onServerTick);

        // Clean up on player disconnect
        ServerPlayConnectionEvents.DISCONNECT.register((handler, server) ->
                PlayerStructureTracker.onPlayerDisconnect(handler.getPlayer())
        );

        // Block breaking is now handled by ServerPlayerInteractionManagerMixin
        // to prevent mining animation from even starting (bedrock-like behavior)

        // Block interaction (right-click)
        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
            if (world.isClient()) return ActionResult.PASS;
            if (!(player instanceof ServerPlayerEntity serverPlayer)) return ActionResult.PASS;

            return onBlockInteract(serverPlayer, hitResult.getBlockPos(), world.getBlockState(hitResult.getBlockPos()));
        });

        // Entity attack
        AttackEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
            if (world.isClient()) return ActionResult.PASS;
            if (!(player instanceof ServerPlayerEntity serverPlayer)) return ActionResult.PASS;

            return onEntityAttack(serverPlayer, entity.getType());
        });
    }

    /**
     * Handle block interaction (right-click)
     */
    private static ActionResult onBlockInteract(ServerPlayerEntity player, BlockPos pos, BlockState state) {
        if (!(player.getWorld() instanceof ServerWorld serverWorld)) return ActionResult.PASS;

        for (var structureInfo : PlayerStructureTracker.getStructures(player)) {
            Identifier structureId = structureInfo.structureId();
            String instanceKey = structureInfo.instanceKey();

            StructurePlacementState placementState = StructurePlacementState.get(serverWorld);

            if (placementState.isUnlocked(instanceKey)) {
                continue;
            }

            AStructureManager.StructureRestriction restriction = AStructureManager.getRestriction(structureId);
            if (restriction == null) {
                continue;
            }

            if (restriction.isInteractionsDisabled()) {
                if (!restriction.isBlockInteractable(state)) {
                    player.sendMessage(Text.translatable("message.betweenlands.structure.cannot_interact"), true);
                    return ActionResult.FAIL;
                }
            }
        }

        return ActionResult.PASS;
    }

    /**
     * Handle entity attack
     */
    private static ActionResult onEntityAttack(ServerPlayerEntity player, net.minecraft.entity.EntityType<?> entityType) {
        if (!(player.getWorld() instanceof ServerWorld serverWorld)) return ActionResult.PASS;

        for (var structureInfo : PlayerStructureTracker.getStructures(player)) {
            Identifier structureId = structureInfo.structureId();
            String instanceKey = structureInfo.instanceKey();

            StructurePlacementState placementState = StructurePlacementState.get(serverWorld);

            if (placementState.isUnlocked(instanceKey)) {
                continue;
            }

            AStructureManager.StructureRestriction restriction = AStructureManager.getRestriction(structureId);
            if (restriction == null) {
                continue;
            }

            if (restriction.isAttackingDisabled()) {
                if (!restriction.isEntityTargetable(entityType)) {
                    player.sendMessage(Text.translatable("message.betweenlands.structure.cannot_attack"), true);
                    return ActionResult.FAIL;
                }
            }
        }

        return ActionResult.PASS;
    }
}