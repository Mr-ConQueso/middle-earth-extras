package net.mrconqueso.middleearthextras.mixin.client.mirror;

import net.minecraft.client.render.GameRenderer;
import net.mrconqueso.middleearthextras.client.render.PalantirReflector;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
abstract class GameRendererMixin {
    @Inject(method = "onResized", at = @At("HEAD"))
    private void palantir$onResized(int width, int height, CallbackInfo ci) {
        PalantirReflector.onResize(width, height);
    }
}
