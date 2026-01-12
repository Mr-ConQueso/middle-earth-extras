package net.mrconqueso.middleearthextras.mixin.client.mirror;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.Framebuffer;
import net.mrconqueso.middleearthextras.client.render.PalantirReflector;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MinecraftClient.class)
abstract class MinecraftClientMixin {
    @Inject(method = "getFramebuffer", at = @At("HEAD"), cancellable = true)
    public void palantir$getFramebuffer(CallbackInfoReturnable<Framebuffer> cir) {
        if (PalantirReflector.isDrawing()) {
            Framebuffer fb = PalantirReflector.getFramebuffer();
            if (fb != null) cir.setReturnValue(fb);
        }
    }
}
