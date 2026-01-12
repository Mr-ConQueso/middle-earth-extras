package net.mrconqueso.middleearthextras.mixin.client;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.Mouse;
import net.minecraft.entity.Entity;
import net.mrconqueso.middleearthextras.entity.misc.PalantirViewEntity;
import net.mrconqueso.middleearthextras.network.PalantirNetwork;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Mouse.class)
public class MouseMixin {
    @Inject(method = "onMouseScroll", at = @At("HEAD"), cancellable = true)
    private void interceptPalantirScroll(long window, double horizontal, double vertical, CallbackInfo ci) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.player != null) {
            Entity cameraEntity = client.getCameraEntity();
            
            // Check if we are currently viewing through a PalantirViewEntity
            if (cameraEntity instanceof PalantirViewEntity viewEntity) {
                // ALWAYS Cancel normal hotbar scrolling when using Palantir
                ci.cancel();

                // Only send zoom packets if in Single Mode (Telescope)
                if (viewEntity.isSingleMode()) {
                     // Send packet to server to update zoom
                     // Vertical scroll is usually +/- 1.0
                     ClientPlayNetworking.send(new PalantirNetwork.PalantirZoomPayload((float) vertical));
                }
            }
        }
    }
}