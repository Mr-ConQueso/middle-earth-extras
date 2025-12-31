package net.mrconqueso.middleearthextras;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.mrconqueso.middleearthextras.block.ModBlocks;
import net.mrconqueso.middleearthextras.command.FreeAreaCommand;
import net.mrconqueso.middleearthextras.entity.ModEntities;
import net.mrconqueso.middleearthextras.entity.custom.*;
import net.mrconqueso.middleearthextras.item.ModItemGroups;
import net.mrconqueso.middleearthextras.item.ModItems;
import net.mrconqueso.middleearthextras.network.StructureProtectionSyncPayload;
import net.mrconqueso.middleearthextras.screen.ModScreenHandlers;
import net.mrconqueso.middleearthextras.structure.AStructureManager;
import net.mrconqueso.middleearthextras.structure.ServerEventHandlerStructure;
import net.mrconqueso.middleearthextras.world.gen.ModWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MiddleEarthExtras implements ModInitializer {
    public static final String MOD_ID = "middle-earth-extras";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

        ModWorldGeneration.generateWorldGen();

        ModEntities.registerModEntities();
        initializeEntities();

        initializeScreens();

		FuelRegistry.INSTANCE.add(ModItems.STARLIGHT_ASHES, 600);

        ServerEventHandlerStructure.register();
        registerStructureRestrictions();

        CommandRegistrationCallback.EVENT.register(FreeAreaCommand::register);

        PayloadTypeRegistry.playS2C().register(StructureProtectionSyncPayload.ID, StructureProtectionSyncPayload.CODEC);

    }

    private void registerStructureRestrictions() {
        // Example: Wight Fortress protection
        AStructureManager.registerRestriction(
                Identifier.of(MOD_ID, "tower"),
                new AStructureManager.StructureRestriction()
                        .setBlockBreakingDisabled(true)
                        .setBlockPlacingDisabled(false)  // Allow placing
                        .setExplosionsAffectBlocks(false)
                        .setProtectedBlocks(BlockTags.PLANKS)
        );

        AStructureManager.registerRestriction(
                Identifier.of("minecraft", "pillager_outpost"),
                new AStructureManager.StructureRestriction()
                        .setBlockBreakingDisabled(true)
                        .setBlockPlacingDisabled(false)  // Allow placing
                        .setExplosionsAffectBlocks(false)
                        .setProtectedBlocks(BlockTags.PLANKS)
        );

        // Add more structures as needed...
    }

    private void initializeScreens() {
        ModScreenHandlers.registerScreenHandlers();
    }

    private void initializeEntities() {
        FabricDefaultAttributeRegistry.register(ModEntities.FELL_BEAST, FellBeastEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.OLIPHAUNT, OliphauntEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.HARADRIM, HaradrimEntity.setKnightAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.BEORNING_HUMAN, BeorningHumanEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.BEORNING_BEAR, BeorningBearEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.ENT, EntEntity.setAttributes());
    }
}