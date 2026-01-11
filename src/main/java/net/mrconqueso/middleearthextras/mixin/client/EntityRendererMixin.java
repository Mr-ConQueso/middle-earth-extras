package net.mrconqueso.middleearthextras.mixin.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.entity.LivingEntity;
import net.mrconqueso.middleearthextras.client.render.ModRenderLayers;
import net.mrconqueso.middleearthextras.effect.ModEffects;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntityRenderer.class)
public abstract class EntityRendererMixin<T extends LivingEntity, M extends net.minecraft.client.render.entity.model.EntityModel<T>> extends EntityRenderer<T> {

    protected EntityRendererMixin(EntityRendererFactory.Context ctx) {
        super(ctx);
    }

    @Inject(method = "getRenderLayer", at = @At("HEAD"), cancellable = true)
    private void injectWraithShader(T entity, boolean showBody, boolean translucent, boolean showOutline, CallbackInfoReturnable<RenderLayer> cir) {
        MinecraftClient client = MinecraftClient.getInstance();

        // Check if the client player (us) has the UNSEEN_FORM effect
        if (client.player != null && client.player.hasStatusEffect(ModEffects.UNSEEN_FORM)) {
            // Apply the sway shader to all entities seen by the player in this state
            // We use the entity's original texture
            cir.setReturnValue(ModRenderLayers.getWraithSway(this.getTexture(entity)));
        }
    }
}