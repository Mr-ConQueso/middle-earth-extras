package net.mrconqueso.middleearthextras;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.mrconqueso.middleearthextras.block.ModBlocks;
import net.mrconqueso.middleearthextras.command.FreeAreaCommand;
import net.mrconqueso.middleearthextras.command.StructurePosCommand;
import net.mrconqueso.middleearthextras.compat.Mods;
import net.mrconqueso.middleearthextras.compat.accesories.Accesories;
import net.mrconqueso.middleearthextras.compat.emi.ModEmiPlugin;
import net.mrconqueso.middleearthextras.compat.trinkets.Trinkets;
import net.mrconqueso.middleearthextras.effect.ModEffects;
import net.mrconqueso.middleearthextras.entity.ModEntities;
import net.mrconqueso.middleearthextras.entity.custom.*;
import net.mrconqueso.middleearthextras.item.*;
import net.mrconqueso.middleearthextras.network.ScreenshakePayload;
import net.mrconqueso.middleearthextras.network.StructureProtectionSyncPayload;
import net.mrconqueso.middleearthextras.resources.ModFactions;
import net.mrconqueso.middleearthextras.resources.ModNpcs;
import net.mrconqueso.middleearthextras.resources.ModRaces;
import net.mrconqueso.middleearthextras.screen.ModScreenHandlers;
import net.mrconqueso.middleearthextras.world.gen.ModWorldGeneration;
import net.mrconqueso.middleearthextras.world.structure.ModStructurePlacementTypes;
import net.mrconqueso.middleearthextras.world.structure.ModStructureTypes;
import net.mrconqueso.middleearthextras.world.structure.protection.AStructureManager;
import net.mrconqueso.middleearthextras.world.structure.protection.ServerEventHandlerStructure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MiddleEarthExtras implements ModInitializer {
    public static final String MOD_ID = "middle-earth-extras";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

        ModItemGroups.registerItemGroups();

        ModRingItems.registerModItems();
        ModEggItems.registerModItems();
        ModGeneralItems.registerModItems();
        ModToolItems.registerModItems();
        ModWeaponItems.registerModItems();
        ModEquipmentItems.registerModItems();

		ModBlocks.registerModBlocks();
        initModFuels();

        ModFactions.register();
        ModNpcs.register();
        ModRaces.register();

        ModEffects.registerEffects();

        ModStructurePlacementTypes.register();
        ModStructureTypes.register();

        ModWorldGeneration.generateWorldGen();

        ModEntities.registerModEntities();
        initEntities();

        initCompat();

        initScreens();

        ServerEventHandlerStructure.register();
        registerStructureRestrictions();

        initCommands();
        initNetworking();
    }

    private static void initCommands() {
        CommandRegistrationCallback.EVENT.register(FreeAreaCommand::register);
        CommandRegistrationCallback.EVENT.register(StructurePosCommand::register);
    }

    private static void initNetworking() {
        PayloadTypeRegistry.playS2C().register(StructureProtectionSyncPayload.ID, StructureProtectionSyncPayload.CODEC);
        PayloadTypeRegistry.playS2C().register(ScreenshakePayload.ID, ScreenshakePayload.CODEC);
        PayloadTypeRegistry.playC2S().register(ScreenshakePayload.ID, ScreenshakePayload.CODEC);

        ServerPlayNetworking.registerGlobalReceiver(ScreenshakePayload.ID, (payload, context) -> {
            context.server().execute(() -> {
                ServerPlayNetworking.send(context.player(), payload);
            });
        });
    }

    private static void initModFuels() {
        // FuelRegistry.INSTANCE.add(ModGeneralItems.STARLIGHT_ASHES, 600);
    }

    @SuppressWarnings("Convert2MethodRef") // may cause class loading issues if changed
    private static void initCompat() {
        Mods.TRINKETS.executeIfInstalled(() -> Trinkets::init);
        Mods.ACCESSORIES.executeIfInstalled(() -> Accesories::init);
        Mods.EMI.executeIfInstalled(() -> ModEmiPlugin::init);
    }

    private void registerStructureRestrictions() {
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
    }

    private void initScreens() {
        ModScreenHandlers.registerScreenHandlers();
    }

    private void initEntities() {
        FabricDefaultAttributeRegistry.register(ModEntities.FELL_BEAST, FellBeastEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.OLIPHAUNT, OliphauntEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.HARADRIM, HaradrimEntity.setKnightAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.RING_WRAITH, RingWraithEntity.setKnightAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.BEORNING_HUMAN, BeorningHumanEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.BEORNING_BEAR, BeorningBearEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.ENT, EntEntity.setAttributes());
    }
}