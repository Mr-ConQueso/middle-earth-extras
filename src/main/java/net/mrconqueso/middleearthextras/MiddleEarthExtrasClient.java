package net.mrconqueso.middleearthextras;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.rendering.v1.ArmorRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.CoreShaderRegistrationCallback;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.util.Identifier;
import net.mrconqueso.middleearthextras.block.ModBlocks;
import net.mrconqueso.middleearthextras.client.ClientStructureProtection;
import net.mrconqueso.middleearthextras.client.ScreenshakeManager;
import net.mrconqueso.middleearthextras.client.WraithShaderHandler;
import net.mrconqueso.middleearthextras.client.armor.renderer.*;
import net.mrconqueso.middleearthextras.client.render.ModInternalShaders;
import net.mrconqueso.middleearthextras.compat.Mods;
import net.mrconqueso.middleearthextras.compat.accesories.Accesories;
import net.mrconqueso.middleearthextras.compat.lambdynlights_api.LambDynLights;
import net.mrconqueso.middleearthextras.compat.trinkets.Trinkets;
import net.mrconqueso.middleearthextras.entity.ModEntities;
import net.mrconqueso.middleearthextras.entity.client.ModEntityModelLayers;
import net.mrconqueso.middleearthextras.entity.client.beorning_bear.BeorningBearRenderer;
import net.mrconqueso.middleearthextras.entity.client.beorning_human.BeorningHumanRenderer;
import net.mrconqueso.middleearthextras.entity.client.ent.EntModel;
import net.mrconqueso.middleearthextras.entity.client.ent.EntRenderer;
import net.mrconqueso.middleearthextras.entity.client.fellbeast.FellBeastModel;
import net.mrconqueso.middleearthextras.entity.client.fellbeast.FellBeastRenderer;
import net.mrconqueso.middleearthextras.entity.client.haradrim.HaradrimHumanRenderer;
import net.mrconqueso.middleearthextras.entity.client.oliphaunt.OliphauntModel;
import net.mrconqueso.middleearthextras.entity.client.oliphaunt.OliphauntRenderer;
import net.mrconqueso.middleearthextras.entity.client.ringwraith.RingWraithHumanRenderer;
import net.mrconqueso.middleearthextras.entity.projectile.smoke.SmokeBoatProjectileModel;
import net.mrconqueso.middleearthextras.entity.projectile.smoke.SmokeBoatProjectileRenderer;
import net.mrconqueso.middleearthextras.item.ModEquipmentItems;
import net.mrconqueso.middleearthextras.item.utils.ModModelPredicateProvider;
import net.mrconqueso.middleearthextras.keybind.ModKeyBinds;
import net.mrconqueso.middleearthextras.network.ScreenshakePayload;
import net.mrconqueso.middleearthextras.network.StructureProtectionSyncPayload;
import net.mrconqueso.middleearthextras.screen.ModScreenHandlers;
import net.mrconqueso.middleearthextras.screen.custom.OliphauntScreen;

public class MiddleEarthExtrasClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        initEntityModels();
        initScreens();
        initBlockRenderers();

        initArmors();

        ModEntityModelLayers.registerModEntityModelLayers();
        ModModelPredicateProvider.registerAllPredicates();

        ModKeyBinds.registerKeyBinds();

        initCompat();

        initNetworking();

        WraithShaderHandler.register();
        initShaders();
    }

    private static void initArmors() {

        ModEquipmentItems.modArmorPiecesListHelmets.forEach(armor -> {
            ArmorRenderer.register(new ModHelmetArmorRenderer(), armor.asItem());
        });
        ModEquipmentItems.modArmorPiecesListChestplates.forEach(armor -> {
            ArmorRenderer.register(new ModChestplateArmorRenderer(), armor.asItem());
        });
        ModEquipmentItems.modArmorPiecesListLeggings.forEach(armor -> {
            ArmorRenderer.register(new ModLeggingsArmorRenderer(), armor.asItem());
        });
        ModEquipmentItems.modArmorPiecesListBoots.forEach(armor -> {
            ArmorRenderer.register(new ModBootsArmorRenderer(), armor.asItem());
        });

        ModEquipmentItems.modHoods.forEach(hood -> {
            ArmorRenderer.register(new ModHoodRenderer(), hood);
        });
        ModEquipmentItems.modCapes.forEach(cape -> {
            ArmorRenderer.register(new ModCapeRenderer(), cape);
        });
    }

    private static void initShaders() {
        CoreShaderRegistrationCallback.EVENT.register(context -> {
            context.register(
                    Identifier.of(MiddleEarthExtras.MOD_ID, "wraith_sway"),
                    VertexFormats.POSITION_COLOR_TEXTURE_OVERLAY_LIGHT_NORMAL,
                    program -> ModInternalShaders.setRenderTypeWraithSwayShader(program)
            );
        });
    }

    private static void initBlockRenderers() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DAMP_TORCH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WALL_DAMP_TORCH, RenderLayer.getCutout());
    }

    private static void initNetworking() {
        ClientPlayNetworking.registerGlobalReceiver(StructureProtectionSyncPayload.ID, (payload, context) -> {
            context.client().execute(() -> {
                ClientStructureProtection.update(
                        payload.inProtectedStructure(),
                        payload.playerPlacedBlocks(),
                        payload.protectedBlocksTag(),
                        payload.breakableBlocksTag()
                );
            });
        });

        ClientPlayNetworking.registerGlobalReceiver(ScreenshakePayload.ID, (payload, context) -> {
            context.client().execute(() -> {
                ScreenshakeManager.startShake(payload.intensity(), payload.duration());
            });
        });

        ClientTickEvents.END_CLIENT_TICK.register(minecraftClient -> {
            if (minecraftClient.world != null) {
                ScreenshakeManager.tick(minecraftClient.world);
            }
        });
    }

    @SuppressWarnings("Convert2MethodRef") // may cause class loading issues if changed
    private static void initCompat() {
        Mods.TRINKETS.executeIfInstalled(() -> () -> Trinkets.initClient());
        Mods.ACCESSORIES.executeIfInstalled(() -> () -> Accesories.initClient());
        Mods.LAMBDYNLIGHTS_API.executeIfInstalled(() -> () -> LambDynLights.initClient());
    }

    private void initScreens() {
        HandledScreens.register(ModScreenHandlers.OLIPHAUNT_SCREEN_HANDLER, OliphauntScreen::new);
    }

    private void initEntityModels() {

        EntityModelLayerRegistry.registerModelLayer(FellBeastModel.FELL_BEAST, FellBeastModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.FELL_BEAST, FellBeastRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(OliphauntModel.OLIPHAUNT, OliphauntModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(OliphauntModel.OLIPHAUNT_ARMOR, OliphauntModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.OLIPHAUNT, OliphauntRenderer::new);

        EntityRendererRegistry.register(ModEntities.HARADRIM, HaradrimHumanRenderer::new);

        EntityRendererRegistry.register(ModEntities.RING_WRAITH, RingWraithHumanRenderer::new);

        EntityRendererRegistry.register(ModEntities.BEORNING_HUMAN, BeorningHumanRenderer::new);
        EntityRendererRegistry.register(ModEntities.BEORNING_BEAR, BeorningBearRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(EntModel.ENT, EntModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.ENT, EntRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(SmokeBoatProjectileModel.SMOKE_BOAT, SmokeBoatProjectileModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.SMOKE_BOAT_PROJECTILE, SmokeBoatProjectileRenderer::new);
    }
}
