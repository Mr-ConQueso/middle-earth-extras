package net.mrconqueso.middleearthextras.entity.client.ent;

import com.google.common.collect.Maps;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.mrconqueso.middleearthextras.MiddleEarthExtras;
import net.mrconqueso.middleearthextras.entity.custom.EntEntity;
import net.mrconqueso.middleearthextras.entity.custom.EntVariant;

import java.util.Map;

public class EntRenderer extends MobEntityRenderer<EntEntity, EntModel<EntEntity>> {

    private static final float SHADOW_RADIUS = 0.75f;

    private static final String PATH = "textures/entity/ent/";
    private static final Map<EntVariant, Identifier> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(EntVariant.class), map -> {
                map.put(EntVariant.OAK,
                        Identifier.of(MiddleEarthExtras.MOD_ID, PATH + "ent1.png"));
                map.put(EntVariant.SPRUCE,
                        Identifier.of(MiddleEarthExtras.MOD_ID, PATH + "ent2.png"));
            });

    public EntRenderer(EntityRendererFactory.Context context) {
        super(context, new EntModel<>(context.getPart(EntModel.ENT)), SHADOW_RADIUS);
    }

    @Override
    public Identifier getTexture(EntEntity entity) {
        return LOCATION_BY_VARIANT.get(entity.getVariant());
    }

    @Override
    public void render(EntEntity livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.push();

        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
        matrixStack.pop();
    }
}
