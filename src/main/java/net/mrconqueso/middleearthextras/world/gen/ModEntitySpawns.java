package net.mrconqueso.middleearthextras.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.jukoz.me.world.biomes.MEBiomeKeys;
import net.jukoz.me.world.biomes.surface.ModBiomes;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnLocationTypes;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.Monster;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.BiomeKeys;
import net.mrconqueso.middleearthextras.entity.ModEntities;
import net.mrconqueso.middleearthextras.entity.custom.FellBeastEntity;
import net.mrconqueso.middleearthextras.entity.custom.HaradrimEntity;

public class ModEntitySpawns {

    public static void AddSpawns() {
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(MEBiomeKeys.FANGORN),
                SpawnGroup.CREATURE, ModEntities.ENT, 30, 1, 2);
        SpawnRestriction.register(ModEntities.ENT, SpawnLocationTypes.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(MEBiomeKeys.HARAD, MEBiomeKeys.UMBAR),
                SpawnGroup.MONSTER, ModEntities.HARADRIM, 30, 1, 2);
        SpawnRestriction.register(ModEntities.HARADRIM, SpawnLocationTypes.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HaradrimEntity::isValidNaturalSpawn);
    }
}
