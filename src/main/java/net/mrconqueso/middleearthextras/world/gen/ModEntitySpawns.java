package net.mrconqueso.middleearthextras.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnLocationTypes;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.BiomeKeys;
import net.mrconqueso.middleearthextras.entity.ModEntities;

public class ModEntitySpawns {

    public static void AddSpawns() {
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.DESERT, BiomeKeys.BADLANDS),
                SpawnGroup.MONSTER, ModEntities.FELL_BEAST, 30, 1, 2);

        SpawnRestriction.register(ModEntities.FELL_BEAST, SpawnLocationTypes.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);
    }
}
