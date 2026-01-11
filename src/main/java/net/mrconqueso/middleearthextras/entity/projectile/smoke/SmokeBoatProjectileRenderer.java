package net.mrconqueso.middleearthextras.entity.projectile.smoke;

import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import net.mrconqueso.middleearthextras.MiddleEarthExtras;

public class SmokeBoatProjectileRenderer extends EntityRenderer<SmokeBoatProjectileEntity> {
    protected SmokeBoatProjectileModel model;
    private final Identifier TEXTURE = Identifier.of(MiddleEarthExtras.MOD_ID, "textures/entity/projectiles/smoke_boat_projectile.png");

    private static final int FADE_IN_DURATION = 10;
    private static final int FADE_OUT_DURATION = 30;

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

        int color = calculateColorWithAlpha(livingEntity, g);

        RenderLayer renderLayer = RenderLayer.getEntityTranslucent(TEXTURE);
        VertexConsumer vertexConsumer = vertexConsumerProvider.getBuffer(renderLayer);

        this.model.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, color);
        matrixStack.pop();

        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    /**
     * Calculates the packed ARGB color with alpha for fade in/out effect.
     * @param entity The smoke boat entity
     * @param tickDelta Partial tick for smooth interpolation
     * @return Packed ARGB color (0xAARRGGBB format)
     */
    private int calculateColorWithAlpha(SmokeBoatProjectileEntity entity, float tickDelta) {
        float age = entity.age + tickDelta;
        int maxLifespan = SmokeBoatProjectileEntity.MAX_LIFESPAN_TICKS;

        float alpha;

        if (age < FADE_IN_DURATION) {
            // Fade in: 0 -> 1 over FADE_IN_DURATION ticks
            alpha = age / FADE_IN_DURATION;
        } else if (age > maxLifespan - FADE_OUT_DURATION) {
            // Fade out: 1 -> 0 over FADE_OUT_DURATION ticks
            alpha = (maxLifespan - age) / FADE_OUT_DURATION;
        } else {
            // Fully visible
            alpha = 1.0f;
        }

        // Clamp between 0 and 1, then convert to int (0-255)
        int alphaInt = (int) (MathHelper.clamp(alpha, 0.0f, 1.0f) * 255);

        // Pack ARGB: white color (255, 255, 255) with calculated alpha
        return (alphaInt << 24) | (255 << 16) | (255 << 8) | 255;
    }
}
