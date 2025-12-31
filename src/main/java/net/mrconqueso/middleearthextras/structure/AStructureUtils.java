package net.mrconqueso.middleearthextras.structure;

import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.structure.StructureStart;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkSectionPos;
import net.minecraft.world.gen.structure.Structure;

import java.util.ArrayList;
import java.util.List;

public class AStructureUtils {

    /**
     * Returns true if the player is inside any structure (list not empty)
     */
    public static boolean isInsideStructure(ServerPlayerEntity player, List<Identifier> structures) {
        return !structures.isEmpty();
    }

    /**
     * Get all structure IDs at a given position
     */
    public static List<Identifier> getStructuresAt(ServerWorld world, BlockPos pos) {
        List<Identifier> result = new ArrayList<>();

        var structureAccessor = world.getStructureAccessor();
        var structureRegistry = world.getRegistryManager().get(RegistryKeys.STRUCTURE);
        
        // Iterate over all registered structures and check if the position is within them
        for (var entry : structureRegistry.getEntrySet()) {
            Structure structure = entry.getValue();
            StructureStart start = structureAccessor.getStructureStart(
                    ChunkSectionPos.from(pos), structure, world.getChunk(pos)
            );

            BlockBox bb;
            if (start != null) {
                bb = start.getBoundingBox();
                bb.expand(
                        Math.round(bb.getDimensions().getX() * 0.5f),
                        Math.round(bb.getDimensions().getY() * 0.5f),
                        Math.round(bb.getDimensions().getZ() * 0.5f));
            }
            else {
                continue;
            }
            
            if (start.hasChildren() && bb.contains(pos)) {
                Identifier id = entry.getKey().getValue();
                result.add(id);
            }
        }

        return result;
    }

    /**
     * Get structure instance key for a position (structure ID + bounding box origin for uniqueness)
     */
    public static String getStructureInstanceKey(ServerWorld world, BlockPos pos, Identifier structureId) {
        var structureAccessor = world.getStructureAccessor();
        var structureRegistry = world.getRegistryManager().get(RegistryKeys.STRUCTURE);
        Structure structure = structureRegistry.get(structureId);

        if (structure != null) {
            StructureStart start = structureAccessor.getStructureStart(
                    ChunkSectionPos.from(pos), structure, world.getChunk(pos)
            );
            if (start != null && start.hasChildren()) {
                // Use bounding box min corner as instance identifier
                var bb = start.getBoundingBox();
                return structureId.toString() + "@" + bb.getMinX() + "," + bb.getMinY() + "," + bb.getMinZ();
            }
        }

        // Fallback: just use structure ID (type-based)
        return structureId.toString();
    }
}