package net.mrconqueso.middleearthextras.entity.client.fellbeast;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.mrconqueso.middleearthextras.MiddleEarthExtras;
import net.mrconqueso.middleearthextras.entity.custom.FellBeastEntity;

public class FellBeastRenderer extends MobEntityRenderer<FellBeastEntity, FellBeastModel<FellBeastEntity>> {

    private static final float SHADOW_RADIUS = 0.75f;

    public FellBeastRenderer(EntityRendererFactory.Context context) {
        super(context, new FellBeastModel<>(context.getPart(FellBeastModel.FELL_BEAST)), SHADOW_RADIUS);
    }

    @Override
    public Identifier getTexture(FellBeastEntity entity) {
        if (entity.isSaddled()) {
            return Identifier.of(MiddleEarthExtras.MOD_ID, "textures/entity/fell_beast/fell_beast_saddled.png");
        } else {
            return Identifier.of(MiddleEarthExtras.MOD_ID, "textures/entity/fell_beast/fell_beast.png");
        }
    }

    @Override
    public void render(FellBeastEntity livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.push();

        if (livingEntity.isBaby()) {
            matrixStack.scale(0.6F, 0.6F, 0.6F);
        } else {
            matrixStack.scale(1.8F, 1.8F, 1.8F);
        }

        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
        matrixStack.pop();
    }
}
