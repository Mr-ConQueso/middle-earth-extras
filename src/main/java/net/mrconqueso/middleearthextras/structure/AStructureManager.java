package net.mrconqueso.middleearthextras.structure;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Manages which structures have restrictions and what those restrictions are.
 * This is a simplified version - you can expand it with config/datapack support.
 */
public class AStructureManager {
    private AStructureManager() {}

    private static final Map<Identifier, StructureRestriction> RESTRICTIONS = new HashMap<>();

    public static void registerRestriction(Identifier structureId, StructureRestriction restriction) {
        RESTRICTIONS.put(structureId, restriction);
    }

    public static void removeRestriction(Identifier structureId) {
        RESTRICTIONS.remove(structureId);
    }

    @Nullable
    public static StructureRestriction getRestriction(Identifier structureId) {
        return RESTRICTIONS.get(structureId);
    }

    public static boolean hasRestriction(Identifier structureId) {
        return RESTRICTIONS.containsKey(structureId);
    }

    public static void clear() {
        RESTRICTIONS.clear();
    }

    public static boolean isBlockProtectedServer(BlockPos pos, BlockState state, ServerPlayerEntity player, ServerWorld world) {
        for (var structureInfo : PlayerStructureTracker.getStructures(player)) {
            Identifier structureId = structureInfo.structureId();
            String instanceKey = structureInfo.instanceKey();

            StructurePlacementState placementState = StructurePlacementState.get(world);

            // Check if this instance is unlocked (boss defeated)
            if (placementState.isUnlocked(instanceKey)) {
                continue;
            }

            // If player placed this block, allow breaking
            if (placementState.isPlacedByPlayer(instanceKey, pos)) {
                continue;
            }

            // Get restriction for this structure type
            AStructureManager.StructureRestriction restriction = AStructureManager.getRestriction(structureId);
            if (restriction == null) {
                continue;
            }

            // Check if breaking is disabled and block is not whitelisted
            if (restriction.isBlockBreakingDisabled() && !restriction.isBlockBreakable(state)) {
                return true; // Block is protected
            }
        }
        return false;
    }

    /**
     * Defines what is restricted in a structure
     */
    public static class StructureRestriction {
        private boolean blockBreakingDisabled = true;
        private boolean blockPlacingDisabled = false;
        private boolean interactionsDisabled = false;
        private boolean attackingDisabled = false;
        private boolean explosionsAffectBlocks = false;
        private boolean explosionsAffectEntities = true;

        // Whitelist/blacklist for specific blocks/entities
        private TagKey<Block> breakableBlocks;
        private TagKey<Block> protectedBlocks;
        private TagKey<Block> placeableBlocks;
        private TagKey<Block> interactableBlocks;
        private Set<Identifier> targetableEntities = Set.of();

        public boolean isBlockBreakingDisabled() {
            return blockBreakingDisabled;
        }

        public StructureRestriction setBlockBreakingDisabled(boolean disabled) {
            this.blockBreakingDisabled = disabled;
            return this;
        }

        public boolean isBlockPlacingDisabled() {
            return blockPlacingDisabled;
        }

        public StructureRestriction setBlockPlacingDisabled(boolean disabled) {
            this.blockPlacingDisabled = disabled;
            return this;
        }

        public boolean isInteractionsDisabled() {
            return interactionsDisabled;
        }

        public StructureRestriction setInteractionsDisabled(boolean disabled) {
            this.interactionsDisabled = disabled;
            return this;
        }

        public boolean isAttackingDisabled() {
            return attackingDisabled;
        }

        public StructureRestriction setAttackingDisabled(boolean disabled) {
            this.attackingDisabled = disabled;
            return this;
        }

        public boolean canExplosionsAffectBlocks() {
            return explosionsAffectBlocks;
        }

        public StructureRestriction setExplosionsAffectBlocks(boolean affect) {
            this.explosionsAffectBlocks = affect;
            return this;
        }

        public boolean canExplosionsAffectEntities() {
            return explosionsAffectEntities;
        }

        public StructureRestriction setExplosionsAffectEntities(boolean affect) {
            this.explosionsAffectEntities = affect;
            return this;
        }

        public boolean isBlockBreakable(BlockState state) {
            if (protectedBlocks == null) {
                return state.isIn(breakableBlocks);
            } else {
                return !state.isIn(protectedBlocks);
            }
        }

        public StructureRestriction setBreakableBlocks(TagKey<Block> blocks) {
            this.breakableBlocks = blocks;
            return this;
        }

        public StructureRestriction setProtectedBlocks(TagKey<Block> blocks) {
            this.protectedBlocks = blocks;
            return this;
        }

        public TagKey<Block> getProtectedBlocks() {
            return this.protectedBlocks;
        }

        public TagKey<Block> getBreakableBlocks() {
            return this.breakableBlocks;
        }

        public boolean isBlockPlaceable(BlockState state) {
            if (placeableBlocks != null) {
                return state.isIn(placeableBlocks);
            }
            return true;
        }

        public StructureRestriction setPlaceableBlocks(TagKey<Block> blocks) {
            this.placeableBlocks = blocks;
            return this;
        }

        public boolean isBlockInteractable(BlockState state) {
            if (interactableBlocks != null) {
                return state.isIn(interactableBlocks);
            }
            return true;
        }

        public StructureRestriction setInteractableBlocks(TagKey<Block> blocks) {
            this.interactableBlocks = blocks;
            return this;
        }

        public boolean isEntityTargetable(EntityType<?> type) {
            if (targetableEntities.isEmpty()) return true;
            Identifier entityId = net.minecraft.registry.Registries.ENTITY_TYPE.getId(type);
            return targetableEntities.contains(entityId);
        }

        public StructureRestriction setTargetableEntities(Set<Identifier> entities) {
            this.targetableEntities = entities;
            return this;
        }
    }
}