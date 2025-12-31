package net.mrconqueso.middleearthextras.structure;

import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.nbt.NbtLong;
import net.minecraft.nbt.NbtString;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.PersistentState;
import net.minecraft.world.PersistentStateManager;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Stores blocks placed by players inside structure instances.
 * Key insight: any block inside a structure that is NOT in this set is considered "structure-owned" (protected).
 */
public class StructurePlacementState extends PersistentState {
    private static final String DATA_NAME = "middle_earth_structure_placements";

    // structureInstanceKey -> Set of packed BlockPos (player-placed blocks)
    private final Map<String, LongOpenHashSet> placedByPlayer = new HashMap<>();

    // structureInstanceKey -> unlocked (boss defeated, etc.)
    private final Set<String> unlockedInstances = new HashSet<>();

    public StructurePlacementState() {
    }

    // --- Player Placed Block Tracking ---

    public boolean isPlacedByPlayer(String structureInstanceKey, BlockPos pos) {
        LongOpenHashSet set = placedByPlayer.get(structureInstanceKey);
        return set != null && set.contains(pos.asLong());
    }

    public void addPlacedByPlayer(String structureInstanceKey, BlockPos pos) {
        placedByPlayer.computeIfAbsent(structureInstanceKey, k -> new LongOpenHashSet())
                .add(pos.asLong());
        markDirty();
    }

    public void removePlacedByPlayer(String structureInstanceKey, BlockPos pos) {
        LongOpenHashSet set = placedByPlayer.get(structureInstanceKey);
        if (set != null) {
            if (set.remove(pos.asLong())) {
                if (set.isEmpty()) {
                    placedByPlayer.remove(structureInstanceKey);
                }
                markDirty();
            }
        }
    }

    /**
     * Get all player-placed block positions for an instance (as packed longs)
     */
    public Set<Long> getPlacedBlocksForInstance(String structureInstanceKey) {
        LongOpenHashSet set = placedByPlayer.get(structureInstanceKey);
        if (set == null) {
            return Set.of();
        }
        return new HashSet<>(set);
    }

    // --- Instance Unlock State ---

    public boolean isUnlocked(String structureInstanceKey) {
        return unlockedInstances.contains(structureInstanceKey);
    }

    public void unlockInstance(String structureInstanceKey) {
        if (unlockedInstances.add(structureInstanceKey)) {
            // Optionally clear placed-by-player data for this instance
            placedByPlayer.remove(structureInstanceKey);
            markDirty();
        }
    }

    public void lockInstance(String structureInstanceKey) {
        if (unlockedInstances.remove(structureInstanceKey)) {
            markDirty();
        }
    }

    // --- Serialization ---

    @Override
    public NbtCompound writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        // Save placed blocks
        NbtCompound placedNbt = new NbtCompound();
        for (Map.Entry<String, LongOpenHashSet> entry : placedByPlayer.entrySet()) {
            NbtList positionList = new NbtList();
            for (long pos : entry.getValue()) {
                positionList.add(NbtLong.of(pos));
            }
            placedNbt.put(entry.getKey(), positionList);
        }
        nbt.put("PlacedByPlayer", placedNbt);

        // Save unlocked instances
        NbtList unlockedList = new NbtList();
        for (String key : unlockedInstances) {
            unlockedList.add(NbtString.of(key));
        }
        nbt.put("UnlockedInstances", unlockedList);

        return nbt;
    }

    public static StructurePlacementState readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        StructurePlacementState state = new StructurePlacementState();

        // Load placed blocks
        if (nbt.contains("PlacedByPlayer")) {
            NbtCompound placedNbt = nbt.getCompound("PlacedByPlayer");
            for (String key : placedNbt.getKeys()) {
                NbtList positionList = placedNbt.getList(key, NbtLong.LONG_TYPE);
                LongOpenHashSet positions = new LongOpenHashSet();
                for (int i = 0; i < positionList.size(); i++) {
                    positions.add(((NbtLong) positionList.get(i)).longValue());
                }
                state.placedByPlayer.put(key, positions);
            }
        }

        // Load unlocked instances
        if (nbt.contains("UnlockedInstances")) {
            NbtList unlockedList = nbt.getList("UnlockedInstances", NbtString.STRING_TYPE);
            for (int i = 0; i < unlockedList.size(); i++) {
                state.unlockedInstances.add(unlockedList.getString(i));
            }
        }

        return state;
    }

    // --- Access ---

    private static final Type<StructurePlacementState> TYPE = new Type<>(
            StructurePlacementState::new,
            StructurePlacementState::readNbt,
            null // DataFixTypes - null for no data fixing
    );

    public static StructurePlacementState get(ServerWorld world) {
        PersistentStateManager manager = world.getPersistentStateManager();
        return manager.getOrCreate(TYPE, DATA_NAME);
    }
}