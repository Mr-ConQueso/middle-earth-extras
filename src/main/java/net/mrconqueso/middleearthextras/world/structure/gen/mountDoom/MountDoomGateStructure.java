package net.mrconqueso.middleearthextras.world.structure.gen.mountDoom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.jukoz.me.world.biomes.MEBiomeKeys;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.structure.SimpleStructurePiece;
import net.minecraft.structure.StructurePiecesCollector;
import net.minecraft.structure.StructureTemplateManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.structure.Structure;
import net.minecraft.world.gen.structure.StructureType;
import net.mrconqueso.middleearthextras.MiddleEarthExtras;
import net.mrconqueso.middleearthextras.util.WorldStructureData;
import net.mrconqueso.middleearthextras.world.structure.ModStructureTypes;

import java.util.Optional;

public class MountDoomGateStructure extends Structure {

    public static final MapCodec<MountDoomGateStructure> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            Structure.configCodecBuilder(instance),
            Codec.INT.fieldOf("volcano_center_x").forGetter(s -> s.volcanoCenterX),
            Codec.INT.fieldOf("volcano_center_y").forGetter(s -> s.volcanoCenterY),
            Codec.INT.fieldOf("volcano_center_z").forGetter(s -> s.volcanoCenterZ),
            Direction.CODEC.fieldOf("direction").forGetter(s -> s.direction)
    ).apply(instance, MountDoomGateStructure::new));

    // Configured in JSON or Code
    private final int volcanoCenterX;
    private final int volcanoCenterY;
    private final int volcanoCenterZ;
    private final Direction direction;
    private final int bridgeStartRadius = 30; // Distance from center where Bridge starts

    public MountDoomGateStructure(Structure.Config config, int vX, int vY, int vZ, Direction direction) {
        super(config);
        this.volcanoCenterX = vX;
        this.volcanoCenterY = vY;
        this.volcanoCenterZ = vZ;
        this.direction = direction;
    }

    @Override
    public Optional<StructurePosition> getStructurePosition(Context context) {
        // 1. Calculate Start Point based on logic
        // Start at Center
        BlockPos centerPos = new BlockPos(volcanoCenterX, volcanoCenterY, volcanoCenterZ);
        
        // Move 50 blocks in direction
        BlockPos searchPos = centerPos.offset(direction, 50);

        // Raycast forward until sky access
        // We use a safety limit to prevent infinite loops
        int limit = 200; 
        BlockPos finalPos = null;

        for (int i = 0; i < limit; i++) {
            // Check for sky access
            // We check if the block at searchPos sees the sky (or rather, if there are no blocks above it)
            // Heightmap WORLD_SURFACE_WG gives the Y of the highest block.
            // If the highest block is BELOW our search Y, then we have sky access at searchPos.Y
            
            int surfaceY = context.chunkGenerator().getHeight(searchPos.getX(), searchPos.getZ(), Heightmap.Type.WORLD_SURFACE_WG, context.world(), context.noiseConfig());
            
            // If surface is below us, we have clear view to sky
            if (surfaceY < searchPos.getY()) {
                finalPos = searchPos;
                break;
            }

            // Move forward
            searchPos = searchPos.offset(direction, 1);
        }

        if (finalPos == null) {
            return Optional.empty(); // Could not find a valid spot
        }

        BlockPos startPos = finalPos;

        // --- SAVE POSITION ---
        // This runs during generation on the server.
        // We need to cast World to ServerWorld safely, or handle it being other types (though it should be ServerWorld during gen)
        if (context.world() instanceof ServerWorld serverWorld) {
             WorldStructureData.get(serverWorld).setPosition("mount_doom_gate", startPos);
        }

        return Optional.of(new StructurePosition(startPos, builder -> {
            generateTunnel(builder, context, startPos);
        }));
    }

    private void generateTunnel(StructurePiecesCollector builder, Context context, BlockPos startPos) {
        BlockPos currentPos = startPos;
        // Direction is now passed in constructor, but we need the facing towards center for the pieces
        // If we are looking OUT from center to find start, then 'direction' is AWAY from center.
        // So facing towards center is opposite.
        Direction facing = direction.getOpposite();

        // Define Templates
        Identifier TUNNEL = Identifier.of(MiddleEarthExtras.MOD_ID, "mount_doom/tunnel_segment");

        Identifier BRIDGE = Identifier.of(MiddleEarthExtras.MOD_ID, "mount_doom/bridge_segment");
        Identifier END   = Identifier.of(MiddleEarthExtras.MOD_ID, "mount_doom/platform_end");

        boolean reachedVolcanoInterior = false;
        int safetyLimit = 100; // Prevent infinite loops

        while (!reachedVolcanoInterior && safetyLimit-- > 0) {
            // Check if we hit AIR or the specific biome
            boolean isAir = context.chunkGenerator().getHeight(currentPos.getX(), currentPos.getZ(), Heightmap.Type.WORLD_SURFACE_WG, context.world(), context.noiseConfig()) < currentPos.getY();
            boolean isPitBiome = context.biomeSource().getBiome(currentPos.getX(), currentPos.getY(), currentPos.getZ(), context.noiseConfig().getMultiNoiseSampler()).matchesKey(MEBiomeKeys.MOUNT_DOOM_PIT);

            if (isAir || isPitBiome) {
                break;
            }

            // 1. Math Check: Are we inside the "Bridge Radius"?
            double distSq = currentPos.getSquaredDistance(volcanoCenterX, currentPos.getY(), volcanoCenterZ);

            if (distSq <= (bridgeStartRadius * bridgeStartRadius)) {
                // WE ARE INSIDE! Switch to Bridge
                reachedVolcanoInterior = true;

                // Add the Bridge
                builder.addPiece(new MountDoomPiece(context.structureTemplateManager(), BRIDGE, currentPos, facing));

                // Advance pos to end of bridge to place the final platform
                BlockPos endPos = movePos(currentPos, facing, 20); // Assuming bridge is 20 blocks long
                builder.addPiece(new MountDoomPiece(context.structureTemplateManager(), END, endPos, facing));

            } else {
                // STILL OUTSIDE: Place Tunnel
                builder.addPiece(new MountDoomPiece(context.structureTemplateManager(), TUNNEL, currentPos, facing));

                // Move forward by the length of the tunnel piece (e.g., 10 blocks)
                currentPos = movePos(currentPos, facing, 10);
            }
        }
    }

    private BlockPos movePos(BlockPos pos, Direction dir, int amount) {
        return pos.offset(dir, amount);
    }

    @Override
    public StructureType<?> getType() {
        return ModStructureTypes.MOUNT_DOOM_GATE;
    }

    public static class MountDoomPiece extends SimpleStructurePiece {
        public MountDoomPiece(StructureTemplateManager manager, Identifier template, BlockPos pos, Direction orientation) {
            super(ModStructureTypes.MORIA_PIECE, 0, manager, template, String.valueOf(template), new net.minecraft.structure.StructurePlacementData().setRotation(net.minecraft.util.BlockRotation.NONE), pos);
        }

        public MountDoomPiece(net.minecraft.structure.StructureContext context, NbtCompound nbt) {
            super(ModStructureTypes.MORIA_PIECE, nbt, context.structureTemplateManager(), (id) -> {
                return new net.minecraft.structure.StructurePlacementData();
            });
        }

        @Override
        protected void handleMetadata(String metadata, BlockPos pos, net.minecraft.world.ServerWorldAccess world, Random random, BlockBox boundingBox) {}
    }
}