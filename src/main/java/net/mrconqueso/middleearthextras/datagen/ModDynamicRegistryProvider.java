package net.mrconqueso.middleearthextras.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.registry.RegistryWrapper;
import net.mrconqueso.middleearthextras.resources.ModFactions;
import net.mrconqueso.middleearthextras.resources.ModNpcs;
import net.mrconqueso.middleearthextras.resources.ModRaces;

import java.util.concurrent.CompletableFuture;

public class ModDynamicRegistryProvider extends FabricDynamicRegistryProvider {
    public ModDynamicRegistryProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup registries, Entries entries) {
        // We don't need to do anything here because the entries are already added
        // to the RegistryWrapper.WrapperLookup via the RegistryBuilder in the main generator class.
        // The parent class automatically walks through the registry wrapper and generates files
        // for all entries that match the mod ID.

        // However, if the registries are "me:factions", standard filtering might exclude them.
        // We can explicitly add them here if needed, but usually, strict filtering is the issue.

        // IMPORTANT: Verify that 'entries' actually contains your data.
        // If this provider runs, it confirms the registries are present.

        // Actually, for foreign registries, we might need to explicitly tell it to include them
        // by verifying the registry keys exist in the lookup.

        entries.addAll(registries.getWrapperOrThrow(ModFactions.MOD_FACTION_KEY));
        entries.addAll(registries.getWrapperOrThrow(ModNpcs.MOD_NPC_KEY));
        entries.addAll(registries.getWrapperOrThrow(ModRaces.MOD_RACE_KEY));
    }

    @Override
    public String getName() {
        return "Middle Earth Extras Dynamic Registries";
    }
}