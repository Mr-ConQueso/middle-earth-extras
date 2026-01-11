package net.mrconqueso.middleearthextras.client;

import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;

import java.util.function.Predicate;

public class ClientBiomeBlender {

    /**
     * Calculates a blend factor (0.0 to 1.0) representing how many blocks in the blend radius match the predicate.
     * Respects the vanilla Biome Blend Radius setting.
     *
     * @param world     The world to sample.
     * @param center    The center position (usually the player).
     * @param predicate The condition to check for (e.g., is this a Dark Biome?).
     * @return A float from 0.0 (none match) to 1.0 (all match).
     */
    public static float getBlendFactor(World world, BlockPos center, Predicate<RegistryEntry<Biome>> predicate) {
        // Use vanilla Biome Blend setting (ranges from 0 to 7 usually)
        int radius = 18;

        if (radius == 0) {
            return predicate.test(world.getBiome(center)) ? 1.0f : 0.0f;
        }

        int sampleCount = 0;
        int matchCount = 0;
        BlockPos.Mutable mutablePos = new BlockPos.Mutable();

        // Sample a square area around the player.
        // This is a simplified version of vanilla BiomeColor blending which uses 3D noise sampling.
        // For lightmap transitions, a 2D-ish check at the player's height is sufficient and performant.
        for (int x = -radius; x <= radius; x++) {
            for (int z = -radius; z <= radius; z++) {
                mutablePos.set(center.getX() + x, center.getY(), center.getZ() + z);

                if (predicate.test(world.getBiome(mutablePos))) {
                    matchCount++;
                }
                sampleCount++;
            }
        }

        return (float) matchCount / sampleCount;
    }
}