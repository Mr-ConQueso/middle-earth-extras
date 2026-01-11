package net.mrconqueso.middleearthextras;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.jukoz.me.resources.MiddleEarthFactions;
import net.jukoz.me.resources.MiddleEarthNpcs;
import net.jukoz.me.resources.MiddleEarthRaces;
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
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		DataGeneratorEntrypoint.super.buildRegistry(registryBuilder);

		registryBuilder.addRegistry(MiddleEarthFactions.FACTION_KEY, ModFactions::bootstrap);
		registryBuilder.addRegistry(MiddleEarthNpcs.NPC_KEY, ModNpcs::bootstrap);
		registryBuilder.addRegistry(MiddleEarthRaces.RACE_KEY, ModRaces::bootstrap);
	}
}
