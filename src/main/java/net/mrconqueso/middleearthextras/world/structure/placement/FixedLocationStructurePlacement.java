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

public class FixedLocationStructurePlacement extends StructurePlacement {

    public static final MapCodec<FixedLocationStructurePlacement> CODEC = RecordCodecBuilder.mapCodec(instance ->
            buildCodec(instance).and(instance.group(
                    Codec.INT.fieldOf("target_x").forGetter(p -> p.x),
                    Codec.INT.fieldOf("target_z").forGetter(p -> p.z)
            )).apply(instance, FixedLocationStructurePlacement::new)
    );

    private final int x;
    private final int z;

    // Constructor used by the Codec
    public FixedLocationStructurePlacement(Vec3i locateOffset, FrequencyReductionMethod frequencyReductionMethod, float frequency, int salt, Optional<ExclusionZone> exclusionZone, int x, int z) {
        super(locateOffset, frequencyReductionMethod, frequency, salt, exclusionZone);
        this.x = x;
        this.z = z;
    }

    // Helper constructor for code-based registration
    public FixedLocationStructurePlacement(int x, int z) {
        // Defaults for salt/frequency as they don't matter for fixed placement
        this(Vec3i.ZERO, FrequencyReductionMethod.DEFAULT, 1.0f, 0, Optional.empty(), x, z);
    }

    public int getX() { return x; }
    public int getZ() { return z; }


    @Override
    protected boolean isStartChunk(StructurePlacementCalculator calculator, int chunkX, int chunkZ) {
        // 1. Convert our target Block X/Z to Chunk X/Z
        ChunkPos targetChunk = new ChunkPos(new BlockPos(this.x, 0, this.z));

        // 2. Return TRUE only if the current chunk matches the target chunk
        return chunkX == targetChunk.x && chunkZ == targetChunk.z;
    }

    @Override
    public StructurePlacementType<?> getType() {
        return ModStructurePlacementTypes.FIXED; // We will register this next
    }
}