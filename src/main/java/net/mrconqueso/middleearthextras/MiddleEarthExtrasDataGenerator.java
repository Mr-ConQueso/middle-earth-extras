package net.mrconqueso.middleearthextras;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.mrconqueso.middleearthextras.datagen.*;
import net.mrconqueso.middleearthextras.resources.ModFactions;
import net.mrconqueso.middleearthextras.resources.ModNpcs;
import net.mrconqueso.middleearthextras.resources.ModRaces;

public class MiddleEarthExtrasDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModItemTagProvider::new);
		pack.addProvider(ModBiomeTagProvider::new);
		pack.addProvider(ModLootTableProvider::new);
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModRecipeProvider::new);

		pack.addProvider(ModDynamicRegistryProvider::new);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		DataGeneratorEntrypoint.super.buildRegistry(registryBuilder);

		registryBuilder.addRegistry(ModFactions.MOD_FACTION_KEY, ModFactions::bootstrap);
		registryBuilder.addRegistry(ModNpcs.MOD_NPC_KEY, ModNpcs::bootstrap);
		registryBuilder.addRegistry(ModRaces.MOD_RACE_KEY, ModRaces::bootstrap);
	}
}
