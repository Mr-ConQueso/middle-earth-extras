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

public class AdaptiveRotatedFixedPlacement extends StructurePlacement {

    public static final MapCodec<AdaptiveRotatedFixedPlacement> CODEC = RecordCodecBuilder.mapCodec(instance ->
            buildCodec(instance).and(instance.group(
                    Codec.INT.fieldOf("target_x").forGetter(p -> p.targetX),
                    Codec.INT.fieldOf("target_z").forGetter(p -> p.targetZ),
                    Codec.INT.fieldOf("radius").forGetter(p -> p.radius)
            )).apply(instance, AdaptiveRotatedFixedPlacement::new)
    );

    private final int targetX;
    private final int targetZ;
    private final int radius;

    // Constructor required by Codec
    public AdaptiveRotatedFixedPlacement(Vec3i locateOffset, FrequencyReductionMethod frequencyReductionMethod, float frequency, int salt, Optional<ExclusionZone> exclusionZone, int targetX, int targetZ, int radius) {
        super(locateOffset, frequencyReductionMethod, frequency, salt, exclusionZone);
        this.targetX = targetX;
        this.targetZ = targetZ;
        this.radius = radius;
    }

    @Override
    protected boolean isStartChunk(StructurePlacementCalculator calculator, int chunkX, int chunkZ) {
        // A. Filter: Is this chunk even close?
        ChunkPos targetChunk = new ChunkPos(new BlockPos(targetX, 0, targetZ));
        int dist = Math.max(Math.abs(chunkX - targetChunk.x), Math.abs(chunkZ - targetChunk.z));
        if (dist > radius) return false;

        // B. Simulation: Find the BEST chunk in the radius
        // NOTE: Previous implementation tried to use ChunkGenerator to sample height, but it is not available here.
        // We fallback to distance-based selection.
        ChunkPos bestChunk = findBestChunk(targetChunk);

        // C. Check: Am I the winner?
        return chunkX == bestChunk.x && chunkZ == bestChunk.z;
    }

    private ChunkPos findBestChunk(ChunkPos center) {
        ChunkPos bestPos = center;
        double bestScore = -1.0;

        for (int dx = -radius; dx <= radius; dx++) {
            for (int dz = -radius; dz <= radius; dz++) {
                int cx = center.x + dx;
                int cz = center.z + dz;

                // --- SCORING: Distance Priority ---
                // Without access to ChunkGenerator in the placement phase, we cannot check for slopes.
                // We fallback to picking the closest chunk to the target, effectively centering it.
                // If randomized placement is needed, use a Random with a seed derived from cx, cz.
                
                double dist = Math.sqrt(dx*dx + dz*dz);
                double score = 1000.0 - dist;

                if (score > bestScore) {
                    bestScore = score;
                    bestPos = new ChunkPos(cx, cz);
                }
            }
        }
        return bestPos;
    }

    @Override
    public StructurePlacementType<?> getType() {
        return ModStructurePlacementTypes.ADAPTIVE_ROTATED_FIXED;
    }
}