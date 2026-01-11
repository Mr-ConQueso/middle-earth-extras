package net.mrconqueso.middleearthextras.util;

import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtList;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.PersistentState;
import net.mrconqueso.middleearthextras.MiddleEarthExtras;

import java.util.HashMap;
import java.util.Map;

public class WorldStructureData extends PersistentState {
    private static final String DATA_ID = MiddleEarthExtras.MOD_ID + "_structures";

    // Map of Structure Identifier (e.g. "mount_doom_gate") -> BlockPos
    private final Map<String, BlockPos> structurePositions = new HashMap<>();

    public static WorldStructureData get(ServerWorld world) {
        // We typically store this on the Overworld (or the dimension the structures are in)
        // For simplicity, we'll get it from the world passed in.
        return world.getPersistentStateManager().getOrCreate(
                new Type<>(WorldStructureData::new, WorldStructureData::load, null),
                DATA_ID
        );
    }

    public WorldStructureData() {
        super();
    }

    public static WorldStructureData load(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        WorldStructureData data = new WorldStructureData();
        NbtList list = nbt.getList("Structures", NbtElement.COMPOUND_TYPE);
        for (int i = 0; i < list.size(); i++) {
            NbtCompound entry = list.getCompound(i);
            String name = entry.getString("Name");
            int x = entry.getInt("X");
            int y = entry.getInt("Y");
            int z = entry.getInt("Z");
            data.structurePositions.put(name, new BlockPos(x, y, z));
        }
        return data;
    }

    @Override
    public NbtCompound writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        NbtList list = new NbtList();
        for (Map.Entry<String, BlockPos> entry : structurePositions.entrySet()) {
            NbtCompound tag = new NbtCompound();
            tag.putString("Name", entry.getKey());
            tag.putInt("X", entry.getValue().getX());
            tag.putInt("Y", entry.getValue().getY());
            tag.putInt("Z", entry.getValue().getZ());
            list.add(tag);
        }
        nbt.put("Structures", list);
        return nbt;
    }

    public void setPosition(String structureName, BlockPos pos) {
        this.structurePositions.put(structureName, pos);
        this.markDirty();
    }

    public BlockPos getPosition(String structureName) {
        return this.structurePositions.get(structureName);
    }

    public java.util.Set<String> getStructureNames() {
        return this.structurePositions.keySet();
    }
}