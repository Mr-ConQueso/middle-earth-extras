package net.mrconqueso.middleearthextras.mixin.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.mrconqueso.middleearthextras.effect.ModEffects;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntityRenderer.class)
public class PlayerEntityRendererMixin {
    @Inject(method = "render", at = @At("HEAD"), cancellable = true)
    private void cancelRenderIfWraith(AbstractClientPlayerEntity player, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, CallbackInfo ci) {
        if (player.hasStatusEffect(ModEffects.UNSEEN_FORM)) {
            // Check if the viewer (us) also has the effect.
            // If we have the effect, we CAN see the target (don't cancel).
            // If we don't have the effect, we CANNOT see the target (cancel).
            
            MinecraftClient client = MinecraftClient.getInstance();
            if (client.player == null || !client.player.hasStatusEffect(ModEffects.UNSEEN_FORM)) {
                // Cancel the entire render of the player model
                // This hides skin, armor, and items.
                ci.cancel();
            }
        }
    }
}
