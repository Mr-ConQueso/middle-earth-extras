package net.mrconqueso.middleearthextras.world.structure;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.chunk.placement.StructurePlacementType;
import net.mrconqueso.middleearthextras.MiddleEarthExtras;
import net.mrconqueso.middleearthextras.world.structure.placement.AdaptiveFixedPlacement;
import net.mrconqueso.middleearthextras.world.structure.placement.AdaptiveRotatedFixedPlacement;
import net.mrconqueso.middleearthextras.world.structure.placement.FixedLocationStructurePlacement;

public class ModStructurePlacementTypes {
    public static StructurePlacementType<FixedLocationStructurePlacement> FIXED;
    public static StructurePlacementType<AdaptiveFixedPlacement> ADAPTIVE_FIXED;
    public static StructurePlacementType<AdaptiveRotatedFixedPlacement> ADAPTIVE_ROTATED_FIXED;

    public static void register() {
        FIXED = Registry.register(
                Registries.STRUCTURE_PLACEMENT,
                Identifier.of(MiddleEarthExtras.MOD_ID, "fixed"),
                () -> FixedLocationStructurePlacement.CODEC
        );

        ADAPTIVE_FIXED = Registry.register(
                Registries.STRUCTURE_PLACEMENT,
                Identifier.of(MiddleEarthExtras.MOD_ID, "afixed"),
                () -> AdaptiveFixedPlacement.CODEC
        );

        ADAPTIVE_ROTATED_FIXED = Registry.register(
                Registries.STRUCTURE_PLACEMENT,
                Identifier.of(MiddleEarthExtras.MOD_ID, "arfixed"),
                () -> AdaptiveRotatedFixedPlacement.CODEC
        );

        registerPlacementTypes();
    }

    public static void registerPlacementTypes() {
        MiddleEarthExtras.LOGGER.info("Registering Placement Types for " + MiddleEarthExtras.MOD_ID);
    }
}