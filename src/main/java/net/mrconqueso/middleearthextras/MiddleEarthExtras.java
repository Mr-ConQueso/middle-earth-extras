package net.mrconqueso.middleearthextras;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.mrconqueso.middleearthextras.block.ModBlocks;
import net.mrconqueso.middleearthextras.entity.ModEntities;
import net.mrconqueso.middleearthextras.entity.custom.*;
import net.mrconqueso.middleearthextras.item.ModItemGroups;
import net.mrconqueso.middleearthextras.item.ModItems;
import net.mrconqueso.middleearthextras.screen.ModScreenHandlers;
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
    }
}