package net.mrconqueso.middleearthextras.entity.client.oliphaunt;

import com.google.common.collect.Maps;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.mrconqueso.middleearthextras.MiddleEarthExtras;
import net.mrconqueso.middleearthextras.entity.custom.OliphauntEntity;
import net.mrconqueso.middleearthextras.entity.custom.OliphauntVariant;

import java.util.Map;

public class OliphauntRenderer extends MobEntityRenderer<OliphauntEntity, OliphauntModel<OliphauntEntity>> {

    private static final float SHADOW_RADIUS = 12.5f;

    private static final Map<OliphauntVariant, Identifier> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(OliphauntVariant.class), map -> {
                map.put(OliphauntVariant.DEFAULT,
                        Identifier.of(MiddleEarthExtras.MOD_ID, "textures/entity/oliphaunt/oliphaunt.png"));
                map.put(OliphauntVariant.ORCHID,
                        Identifier.of(MiddleEarthExtras.MOD_ID, "textures/entity/oliphaunt/oliphaunt.png"));
            });

    public OliphauntRenderer(EntityRendererFactory.Context context) {
        super(context, new OliphauntModel<>(context.getPart(OliphauntModel.OLIPHAUNT)), SHADOW_RADIUS);
        this.addFeature(new OliphauntArmorFeatureRenderer(this, context.getModelLoader()));
    }

    @Override
    public Identifier getTexture(OliphauntEntity entity) {
        if (entity.isSaddled()) {
            return Identifier.of(MiddleEarthExtras.MOD_ID, "textures/entity/oliphaunt/oliphaunt.png");
        } else {
            return LOCATION_BY_VARIANT.get(entity.getVariant());
        }
    }

    @Override
    public void render(OliphauntEntity livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.push();

        if (livingEntity.isBaby()) {
            matrixStack.scale(0.3F, 0.3F, 0.3F);
        } else {
            matrixStack.scale(1F, 1F, 1F);
        }

        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
        matrixStack.pop();
    }
}
