package net.mrconqueso.middleearthextras.entity.projectile.smoke;

import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;
import net.mrconqueso.middleearthextras.MiddleEarthExtras;

public class SmokeBoatProjectileRenderer extends EntityRenderer<SmokeBoatProjectileEntity> {
    protected SmokeBoatProjectileModel model;
    private final Identifier TEXTURE = Identifier.of(MiddleEarthExtras.MOD_ID, "textures/entity/projectiles/smoke_boat_projectile.png");

    public SmokeBoatProjectileRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
        model = new SmokeBoatProjectileModel(ctx.getPart(SmokeBoatProjectileModel.SMOKE_BOAT));
    }

    @Override
    public Identifier getTexture(SmokeBoatProjectileEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(SmokeBoatProjectileEntity livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.push();

        matrixStack.scale(0.12f, 0.12f, 0.12f);
        matrixStack.multiply(RotationAxis.POSITIVE_X.rotationDegrees(180.0F));

        VertexConsumer vertexConsumer = ItemRenderer.getDirectItemGlintConsumer(vertexConsumerProvider, this.model.getLayer(TEXTURE), false, false);
        this.model.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV);

        matrixStack.pop();

        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
