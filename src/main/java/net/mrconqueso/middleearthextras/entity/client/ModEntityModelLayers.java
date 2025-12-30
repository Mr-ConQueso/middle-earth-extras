package net.mrconqueso.middleearthextras.entity.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import net.mrconqueso.middleearthextras.MiddleEarthExtras;

@Environment(value= EnvType.CLIENT)
public final class ModEntityModelLayers {
    private static final String MAIN = "main";
    public static final EntityModelLayer HUMAN = ModEntityModelLayers.registerEntityModelLayer("human", HumanModel.getTexturedModelData(Dilation.NONE));

    /**
     * The modelData is used to know the UV map to use for the 3D model
     * **/
    private static EntityModelLayer registerEntityModelLayer(String registryName, TexturedModelData modelData) {
        EntityModelLayer entityModelLayer = new EntityModelLayer(Identifier.of(MiddleEarthExtras.MOD_ID, registryName), MAIN);
        EntityModelLayerRegistry.registerModelLayer(entityModelLayer, () -> modelData);
        return entityModelLayer;
    }

    public static void registerModEntityModelLayers() {
        MiddleEarthExtras.LOGGER.info("Registering Mod Layers for " + MiddleEarthExtras.MOD_ID);
    }
}