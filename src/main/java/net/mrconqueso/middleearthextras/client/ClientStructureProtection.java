package net.mrconqueso.middleearthextras.client;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.Set;

/**
 * Client-side structure protection state.
 * Synced from the server to prevent mining animation on protected blocks.
 */
public class ClientStructureProtection {

    private static boolean inProtectedStructure = false;
    private static final Set<Long> playerPlacedBlocks = new HashSet<>();
    @Nullable
    private static TagKey<Block> protectedBlocksTag = null;
    @Nullable
    private static TagKey<Block> breakableBlocksTag = null;

    public static void update(boolean protected_, Set<Long> placedBlocks,
                              @Nullable TagKey<Block> protectedTag, @Nullable TagKey<Block> breakableTag) {
        inProtectedStructure = protected_;
        playerPlacedBlocks.clear();
        playerPlacedBlocks.addAll(placedBlocks);
        protectedBlocksTag = protectedTag;
        breakableBlocksTag = breakableTag;
    }

    /**
     * Checks if a block at the given position is protected.
     * @param pos The block position
     * @param state The block state at that position
     * @return true if the block is protected and cannot be broken
     */
    public static boolean isBlockProtected(BlockPos pos, BlockState state) {
        if (!inProtectedStructure) {
            return false;
        }
        
        // Player-placed blocks can always be broken
        if (playerPlacedBlocks.contains(pos.asLong())) {
            return false;
        }
        
        // Check if block is breakable based on tags
        return !isBlockBreakable(state);
    }

    /**
     * Checks if a block state is breakable based on the synced tags.
     * @param state The block state to check
     * @return true if the block can be broken
     */
    private static boolean isBlockBreakable(BlockState state) {
        // If protected blocks tag is set, check if block is in it (protected = not breakable)
        if (protectedBlocksTag != null) {
            return !state.isIn(protectedBlocksTag);
        }
        
        // If breakable blocks tag is set, check if block is in it
        if (breakableBlocksTag != null) {
            return state.isIn(breakableBlocksTag);
        }
        
        // Default: all blocks are protected when in protected structure
        return false;
    }

    public static boolean isInProtectedStructure() {
        return inProtectedStructure;
    }

    public static void reset() {
        inProtectedStructure = false;
        playerPlacedBlocks.clear();
        protectedBlocksTag = null;
        breakableBlocksTag = null;
    }
}