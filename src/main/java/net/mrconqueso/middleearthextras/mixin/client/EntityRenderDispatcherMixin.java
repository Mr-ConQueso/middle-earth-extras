package net.mrconqueso.middleearthextras.mixin.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.WorldView;
import net.mrconqueso.middleearthextras.effect.ModEffects;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityRenderDispatcher.class)
public class EntityRenderDispatcherMixin {

    @Inject(method = "renderShadow", at = @At("HEAD"), cancellable = true)
    private static void cancelShadowIfWraith(MatrixStack matrices, VertexConsumerProvider vertexConsumers, Entity entity, float opacity, float tickDelta, WorldView world, float radius, CallbackInfo ci) {
        if (entity instanceof LivingEntity living && living.hasStatusEffect(ModEffects.UNSEEN_FORM)) {
            MinecraftClient client = MinecraftClient.getInstance();
            // 1. If the viewer (us) is a normal human, we see NOTHING (No shadow).
            if (client.player == null || !client.player.hasStatusEffect(ModEffects.UNSEEN_FORM)) {
                ci.cancel();
                return;
            }

            // 2. If the viewer IS a Wraith, they can see other Wraiths' shadows.
            // OPTIONAL: Cancel the shadow ONLY if it is the player's own shadow.
            // This gives a "floating/ghostly" feel to the player without making them invisible.
            if (entity == client.player) {
                ci.cancel();
            }
        }
    }
}