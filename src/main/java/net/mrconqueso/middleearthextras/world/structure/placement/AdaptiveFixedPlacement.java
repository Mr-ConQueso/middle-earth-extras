package net.mrconqueso.middleearthextras.world.structure.placement;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.gen.chunk.placement.StructurePlacement;
import net.minecraft.world.gen.chunk.placement.StructurePlacementCalculator;
import net.minecraft.world.gen.chunk.placement.StructurePlacementType;
import net.mrconqueso.middleearthextras.world.structure.ModStructurePlacementTypes;

import java.util.Optional;

public class AdaptiveFixedPlacement extends StructurePlacement {

    public static final MapCodec<AdaptiveFixedPlacement> CODEC = RecordCodecBuilder.mapCodec(instance ->
            buildCodec(instance).and(instance.group(
                    Codec.INT.fieldOf("target_x").forGetter(p -> p.targetX),
                    Codec.INT.fieldOf("target_z").forGetter(p -> p.targetZ),
                    Codec.INT.fieldOf("radius").forGetter(p -> p.radius)
            )).apply(instance, AdaptiveFixedPlacement::new)
    );

    private final int targetX;
    private final int targetZ;
    private final int radius;

    public AdaptiveFixedPlacement(Vec3i locateOffset, FrequencyReductionMethod frequencyReductionMethod, float frequency, int salt, Optional<ExclusionZone> exclusionZone, int targetX, int targetZ, int radius) {
        super(locateOffset, frequencyReductionMethod, frequency, salt, exclusionZone);
        this.targetX = targetX;
        this.targetZ = targetZ;
        this.radius = radius;
    }

    @Override
    protected boolean isStartChunk(StructurePlacementCalculator calculator, int chunkX, int chunkZ) {
        // 1. Quick Fail: Am I way outside the radius?
        ChunkPos targetChunk = new ChunkPos(new BlockPos(targetX, 0, targetZ));
        int dist = Math.max(Math.abs(chunkX - targetChunk.x), Math.abs(chunkZ - targetChunk.z)); // Chebyshev distance (square radius)
        if (dist > radius) return false;

        // 2. The Heavy Lifting: Find the "King" of the radius
        // We calculate the best spot deterministically. Since this code runs for every chunk,
        // they will all agree on who the winner is.
        // NOTE: Previous implementation tried to use ChunkGenerator to sample height, but it is not available here.
        // We fallback to distance-based selection for now.
        ChunkPos bestChunk = findBestChunkInRadius(targetChunk);

        // 3. Am I the winner?
        return chunkX == bestChunk.x && chunkZ == bestChunk.z;
    }

    private ChunkPos findBestChunkInRadius(ChunkPos center) {
        ChunkPos bestPos = center;
        double bestScore = -1.0;

        // Iterate area around the center
        for (int dx = -radius; dx <= radius; dx++) {
            for (int dz = -radius; dz <= radius; dz++) {
                int cx = center.x + dx;
                int cz = center.z + dz;

                // --- SCORING LOGIC ---
                // Without access to ChunkGenerator, we cannot sample world height efficiently here.
                // We will prioritize chunks closer to the center.
                // You can add deterministic noise-based randomization here if needed using a fixed seed.

                double dist = Math.sqrt(dx*dx + dz*dz);
                // Inverse distance score: closer is better
                double finalScore = 1000.0 - dist;

                if (finalScore > bestScore) {
                    bestScore = finalScore;
                    bestPos = new ChunkPos(cx, cz);
                }
            }
        }
        return bestPos;
    }

    @Override
    public StructurePlacementType<?> getType() {
        return ModStructurePlacementTypes.ADAPTIVE_FIXED;
    }
}