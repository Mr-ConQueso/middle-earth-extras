package net.mrconqueso.middleearthextras.world.structure.gen.moria;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.structure.SimpleStructurePiece;
import net.minecraft.structure.StructurePiecesCollector;
import net.minecraft.structure.StructureTemplateManager;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.structure.Structure;
import net.minecraft.world.gen.structure.StructureType;
import net.mrconqueso.middleearthextras.MiddleEarthExtras;
import net.mrconqueso.middleearthextras.util.WorldStructureData;
import net.mrconqueso.middleearthextras.world.structure.ModStructureTypes;

import java.util.List;
import java.util.Optional;

public class MoriaGateStructure extends Structure {

    public static final MapCodec<MoriaGateStructure> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            Structure.configCodecBuilder(instance),
            Codec.BOOL.fieldOf("is_west_gate").orElse(true).forGetter(s -> s.isWestGate)
    ).apply(instance, MoriaGateStructure::new));

    private final boolean isWestGate;

    public MoriaGateStructure(Structure.Config config, boolean isWestGate) {
        super(config);
        this.isWestGate = isWestGate;
    }

    @Override
    public Optional<StructurePosition> getStructurePosition(Context context) {
        // 1. Find MY position (The Gate)
        // We use the chunk center as the "Ideal" spot, then refine with slope detection.
        // Since AdaptivePlacement put us in this chunk, we assume this chunk is the best candidate nearby.
        int chunkX = context.chunkPos().getStartX();
        int chunkZ = context.chunkPos().getStartZ();

        BlockPos myPos = findBestGatePosInChunk(context, chunkX, chunkZ);
        BlockRotation myRotation = calculateRotation(context, myPos);

        // --- SAVE POSITION ---
        if (context.world() instanceof ServerWorld serverWorld) {
             String gateName = isWestGate ? "moria_west_gate" : "moria_east_gate";
             WorldStructureData.get(serverWorld).setPosition(gateName, myPos);
        }

        return Optional.of(new StructurePosition(myPos, builder -> {
            generateMoriaSegment(builder, context, myPos, myRotation);
        }));
    }

    private void generateMoriaSegment(StructurePiecesCollector builder, Context context, BlockPos myPos, BlockRotation myRotation) {
        // 1. Determine "Other Gate" position
        // We assume the other gate is at a fixed relative distance for the sake of the pathfinder target.
        // In a real scenario, you'd scan for the other structure, but that's expensive.
        // We use a "Lore Coordinate" approach.
        // E.g. West is ~ -1000, East is ~ 1000.

        BlockPos targetPos;
        if (this.isWestGate) {
            // We are West, looking for East
            targetPos = new BlockPos(myPos.getX() + 2000, myPos.getY(), myPos.getZ());
            // Ideally refine 'targetPos' Y using heightmap at that location
            int targetY = getHeight(context, targetPos.getX(), targetPos.getZ());
            targetPos = new BlockPos(targetPos.getX(), targetY, targetPos.getZ());

            // Generate First Half (0.0 -> 0.5)
            generatePath(builder, context, myPos, targetPos, 0.0, 0.5);
        } else {
            // We are East, looking for West
            targetPos = new BlockPos(myPos.getX() - 2000, myPos.getY(), myPos.getZ());
            int targetY = getHeight(context, targetPos.getX(), targetPos.getZ());
            targetPos = new BlockPos(targetPos.getX(), targetY, targetPos.getZ());

            // Generate Second Half (0.5 -> 1.0)
            // Note: pass targetPos (West) as start, myPos (East) as end to match West's logic
            generatePath(builder, context, targetPos, myPos, 0.5, 1.0);
        }

        // 2. Add THE GATE itself
        StructureTemplateManager manager = context.structureTemplateManager();
        Identifier template = Identifier.of(MiddleEarthExtras.MOD_ID, isWestGate ? "moria/west_gate" : "moria/east_gate");
        builder.addPiece(new MoriaPiece(manager, template, myPos, myRotation));
    }

    private void generatePath(StructurePiecesCollector builder, Context context, BlockPos start, BlockPos end, double minFraction, double maxFraction) {
        long seed = context.seed() + start.asLong() + end.asLong(); // Consistent seed
        List<MoriaPathfinder.MoriaNode> nodes = MoriaPathfinder.calculatePathSegment(start, end, seed, minFraction, maxFraction);

        StructureTemplateManager manager = context.structureTemplateManager();
        for (MoriaPathfinder.MoriaNode node : nodes) {
            Identifier templateId = Identifier.of(MiddleEarthExtras.MOD_ID, "moria/" + node.templateName());
            builder.addPiece(new MoriaPiece(manager, templateId, node.pos(), BlockRotation.NONE));
        }
    }

    // --- Helper Logic ---

    private BlockPos findBestGatePosInChunk(Context context, int x, int z) {
        // Simple implementation: Use the center of the chunk at surface height
        int y = getHeight(context, x + 8, z + 8);
        return new BlockPos(x + 8, y, z + 8);
    }

    private BlockRotation calculateRotation(Context context, BlockPos pos) {
        int x = pos.getX();
        int z = pos.getZ();

        int yNorth = getHeight(context, x, z - 10);
        int ySouth = getHeight(context, x, z + 10);
        int yWest  = getHeight(context, x - 10, z);
        int yEast  = getHeight(context, x + 10, z);
        int yCenter = pos.getY();

        // Face towards the mountain (Highest point)
        int highest = yCenter;
        BlockRotation rotation = BlockRotation.NONE;

        if (yNorth > highest) { rotation = BlockRotation.NONE; highest = yNorth; } // Face North
        if (ySouth > highest) { rotation = BlockRotation.CLOCKWISE_180; highest = ySouth; }
        if (yWest > highest)  { rotation = BlockRotation.COUNTERCLOCKWISE_90; highest = yWest; }
        if (yEast > highest)  { rotation = BlockRotation.CLOCKWISE_90; highest = yEast; }

        return rotation;
    }

    private int getHeight(Context context, int x, int z) {
        return context.chunkGenerator().getHeight(x, z, Heightmap.Type.WORLD_SURFACE_WG, context.world(), context.noiseConfig());
    }

    @Override
    public StructureType<?> getType() {
        return ModStructureTypes.MORIA_GATE;
    }

    public static class MoriaPiece extends SimpleStructurePiece {
        public MoriaPiece(StructureTemplateManager manager, Identifier template, BlockPos pos, BlockRotation rotation) {
            super(ModStructureTypes.MORIA_PIECE, 0, manager, template, String.valueOf(template), new net.minecraft.structure.StructurePlacementData().setRotation(rotation), pos);
        }

        public MoriaPiece(net.minecraft.structure.StructureContext context, NbtCompound nbt) {
            super(ModStructureTypes.MORIA_PIECE, nbt, context.structureTemplateManager(), (id) -> {
                // Try to recover rotation from NBT or default
                return new net.minecraft.structure.StructurePlacementData();
            });
        }

        @Override
        protected void handleMetadata(String metadata, BlockPos pos, net.minecraft.world.ServerWorldAccess world, Random random, BlockBox boundingBox) {}
    }
}