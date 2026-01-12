package net.mrconqueso.middleearthextras.mixin.client.mirror;

import net.minecraft.client.render.Camera;
import net.minecraft.client.render.WorldRenderer;
import net.mrconqueso.middleearthextras.client.render.PalantirReflector;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(WorldRenderer.class)
abstract class WorldRendererMixin {
    @Redirect(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/Camera;isThirdPerson()Z"))
    public boolean palantir$renderThirdPerson(Camera instance) {
        // Allows seeing the player model when looking through the Palantir (if looking back at self)
        return instance.isThirdPerson() || PalantirReflector.isDrawing();
    }
}
