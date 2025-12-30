package net.mrconqueso.middleearthextras.entity.client.beorning_human;

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
import net.mrconqueso.middleearthextras.entity.custom.BeorningHumanEntity;
import net.mrconqueso.middleearthextras.entity.custom.BeorningVariant;

import java.util.Map;

public class BeorningHumanRenderer extends BipedEntityRenderer<BeorningHumanEntity, BeorningHumanModel<BeorningHumanEntity>> {
    private static final String PATH = "textures/entity/beorning/human/";

    public BeorningHumanRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new BeorningHumanModel<>(ctx.getPart(ModEntityModelLayers.HUMAN)), 0.5f);
        this.addFeature(new ArmorFeatureRenderer<>(this, new BeorningHumanModel(ctx.getPart(EntityModelLayers.PLAYER_INNER_ARMOR)),
                new BeorningHumanModel(ctx.getPart(EntityModelLayers.PLAYER_OUTER_ARMOR)), ctx.getModelManager()));

    }

    @Override
    public Identifier getTexture(BeorningHumanEntity entity) {
        return Identifier.of(MiddleEarthExtras.MOD_ID, LOCATION_BY_VARIANT.get(entity.getVariant()));
    }

    public static final Map<BeorningVariant, String> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(BeorningVariant.class), (resourceLocation) -> {
                resourceLocation.put(BeorningVariant.DEFAULT,
                        PATH + "beorning1.png");
                resourceLocation.put(BeorningVariant.ORCHID,
                        PATH + "beorning2.png");
            });

    @Override
    public void render(BeorningHumanEntity entity, float entityYaw, float partialTick, MatrixStack poseStack,
                       VertexConsumerProvider bufferSource, int packedLight) {

        if (this.isShaking(entity)) {
            entityYaw += (float)(Math.cos((double)entity.age * 3.25) * Math.PI * 0.4F);
        }

        poseStack.scale(0.95f, 0.95f, 0.95f);
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }

    protected boolean isShaking(BeorningHumanEntity entity) {
        return entity.isShaking();
    }
}