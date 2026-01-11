package net.mrconqueso.middleearthextras.mixin.client.lightmap;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.entity.Entity;
import net.mrconqueso.middleearthextras.client.WraithShaderHandler;
import net.mrconqueso.middleearthextras.client.lightmap.Darkness;
import net.mrconqueso.middleearthextras.client.lightmap.LightmapAccess;
import net.mrconqueso.middleearthextras.effect.ModEffects;
import net.mrconqueso.middleearthextras.mixin.client.GameRendererAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
@Environment(EnvType.CLIENT)
public class MixinGameRenderer {
    @Shadow
    private MinecraftClient client;

    @Shadow
    private LightmapTextureManager lightmapTextureManager;

    @Inject(method = "renderWorld", at = @At(value = "HEAD"))
    private void onRenderLevel(RenderTickCounter tickCounter, CallbackInfo ci) {
        final LightmapAccess lightmap = (LightmapAccess) lightmapTextureManager;

        if (lightmap.darkness_isDirty()) {
            client.getProfiler().push("lightTex");

            // RenderTickCounter provides the tick delta (partial ticks)
            Darkness.updateLuminance(tickCounter.getTickDelta(true), client, (GameRenderer) (Object) this,
                    lightmap.darkness_prevFlicker());

            client.getProfiler().pop();
        }
    }
}