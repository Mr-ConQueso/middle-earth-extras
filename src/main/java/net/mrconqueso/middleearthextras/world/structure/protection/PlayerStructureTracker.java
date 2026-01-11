package net.mrconqueso.middleearthextras.world.structure.protection;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.mrconqueso.middleearthextras.network.StructureProtectionSyncPayload;

import java.util.*;

/**
 * Tracks which structures each player is currently inside.
 * Updated periodically (every N ticks) for performance.
 */
public class PlayerStructureTracker {
    private PlayerStructureTracker() {}

    // playerUUID -> list of structure instance keys the player is inside
    private static final Map<UUID, List<StructureInstanceInfo>> playerStructures = new HashMap<>();

    private static int tickCounter = 0;
    private static final int UPDATE_INTERVAL = 20; // Update every 20 ticks (1 second)

    public record StructureInstanceInfo(Identifier structureId, String instanceKey) {}

    /**
     * Get structures the player is currently inside
     */
    public static List<StructureInstanceInfo> getStructures(ServerPlayerEntity player) {
        return playerStructures.getOrDefault(player.getUuid(), List.of());
    }

    public static List<StructureInstanceInfo> getStructures(ClientPlayerEntity player) {
        return playerStructures.getOrDefault(player.getUuid(), List.of());
    }

    /**
     * Called every server tick to update player structure tracking
     */
    public static void onServerTick(MinecraftServer server) {
        tickCounter++;
        if (tickCounter < UPDATE_INTERVAL) return;
        tickCounter = 0;

        for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
            updatePlayerStructures(player);
        }
    }

    private static void updatePlayerStructures(ServerPlayerEntity player) {
        if (!(player.getWorld() instanceof ServerWorld serverWorld)) return;

        List<StructureInstanceInfo> newList = new ArrayList<>();
        List<Identifier> structureIds = AStructureUtils.getStructuresAt(serverWorld, player.getBlockPos());

        for (Identifier structureId : structureIds) {
            String instanceKey = AStructureUtils.getStructureInstanceKey(serverWorld, player.getBlockPos(), structureId);
            newList.add(new StructureInstanceInfo(structureId, instanceKey));

            player.sendMessage(Text.literal("Structure: " + structureId.toString()), false);
        }

        playerStructures.put(player.getUuid(), newList);
        syncToClient(player);
    }

    public static void syncToClient(ServerPlayerEntity player) {
        ServerWorld world = player.getServerWorld();
        boolean isInProtectedStructure = false;
        Set<Long> playerPlacedBlocks = new HashSet<>();
        AStructureManager.StructureRestriction restriction = null;

        for (var structureInfo : getStructures(player)) {
            Identifier structureId = structureInfo.structureId();
            String instanceKey = structureInfo.instanceKey();
            restriction = AStructureManager.getRestriction(structureId);

            StructurePlacementState placementState = StructurePlacementState.get(world);

            if (!placementState.isUnlocked(instanceKey)) {
                if (restriction != null && restriction.isBlockBreakingDisabled()) {
                    isInProtectedStructure = true;
                    // Collect player-placed blocks for this instance
                    playerPlacedBlocks.addAll(placementState.getPlacedBlocksForInstance(instanceKey));
                }
            }
        }

        if (restriction == null) {
            ServerPlayNetworking.send(player, new StructureProtectionSyncPayload(false, playerPlacedBlocks, null, null));
            return;
        }
        ServerPlayNetworking.send(player, new StructureProtectionSyncPayload(isInProtectedStructure, playerPlacedBlocks, restriction.getProtectedBlocks(), restriction.getBreakableBlocks()));
    }

    /**
     * Called when a player disconnects to clean up
     */
    public static void onPlayerDisconnect(ServerPlayerEntity player) {
        playerStructures.remove(player.getUuid());
    }

    /**
     * Clear all tracking data (e.g., on server stop)
     */
    public static void clear() {
        playerStructures.clear();
        tickCounter = 0;
    }
}