package net.mrconqueso.middleearthextras;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
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
import net.mrconqueso.middleearthextras.screen.ModScreenHandlers;
import net.mrconqueso.middleearthextras.screen.custom.OliphauntScreen;

public class MiddleEarthExtrasClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        initializeEntityModels();
        initializeScreens();
        ModEntityModelLayers.registerModEntityModelLayers();
    }

    private void initializeScreens() {
        HandledScreens.register(ModScreenHandlers.OLIPHAUNT_SCREEN_HANDLER, OliphauntScreen::new);
    }

    private void initializeEntityModels() {

        EntityModelLayerRegistry.registerModelLayer(FellBeastModel.FELL_BEAST, FellBeastModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.FELL_BEAST, FellBeastRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(OliphauntModel.OLIPHAUNT, OliphauntModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(OliphauntModel.OLIPHAUNT_ARMOR, OliphauntModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.OLIPHAUNT, OliphauntRenderer::new);

        EntityRendererRegistry.register(ModEntities.HARADRIM, HaradrimHumanRenderer::new);

        EntityRendererRegistry.register(ModEntities.BEORNING_HUMAN, BeorningHumanRenderer::new);
        EntityRendererRegistry.register(ModEntities.BEORNING_BEAR, BeorningBearRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(EntModel.ENT, EntModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.ENT, EntRenderer::new);
    }
}
