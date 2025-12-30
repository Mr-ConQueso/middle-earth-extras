package net.mrconqueso.middleearthextras.entity.client.haradrim;

import com.google.common.collect.Maps;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.mrconqueso.middleearthextras.MiddleEarthExtras;
import net.mrconqueso.middleearthextras.entity.client.ModEntityModelLayers;
import net.mrconqueso.middleearthextras.entity.custom.HaradrimEntity;
import net.mrconqueso.middleearthextras.entity.custom.HaradrimVariant;

import java.util.Map;

public class HaradrimHumanRenderer extends BipedEntityRenderer<HaradrimEntity, HaradrimHumanModel<HaradrimEntity>> {
    private static final String PATH = "textures/entity/human/haradrim/";

    public HaradrimHumanRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new HaradrimHumanModel<>(ctx.getPart(ModEntityModelLayers.HUMAN)), 0.5f);
        this.addFeature(new ArmorFeatureRenderer<>(this, new HaradrimHumanModel(ctx.getPart(EntityModelLayers.PLAYER_INNER_ARMOR)),
                new HaradrimHumanModel(ctx.getPart(EntityModelLayers.PLAYER_OUTER_ARMOR)), ctx.getModelManager()));

    }

    @Override
    public Identifier getTexture(HaradrimEntity entity) {
        return Identifier.of(MiddleEarthExtras.MOD_ID, LOCATION_BY_VARIANT.get(entity.getVariant()));
    }

    public static final Map<HaradrimVariant, String> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(HaradrimVariant.class), (resourceLocation) -> {
                resourceLocation.put(HaradrimVariant.DEFAULT,
                        PATH + "haradrim1.png");
                resourceLocation.put(HaradrimVariant.ORCHID,
                        PATH + "haradrim2.png");
            });

    @Override
    public void render(HaradrimEntity entity, float entityYaw, float partialTick, MatrixStack poseStack,
                       VertexConsumerProvider bufferSource, int packedLight) {

        poseStack.scale(0.95f, 0.95f, 0.95f);
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}