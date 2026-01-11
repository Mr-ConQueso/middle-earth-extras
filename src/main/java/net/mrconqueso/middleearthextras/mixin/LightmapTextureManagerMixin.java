package net.mrconqueso.middleearthextras.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import com.llamalad7.mixinextras.sugar.ref.LocalRef;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.LightmapTextureManager;
import net.mrconqueso.middleearthextras.util.ModTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LightmapTextureManager.class)
public class LightmapTextureManagerMixin {

    @Inject(method = "update", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/texture/NativeImage;setColor(III)V"))
    private void darkeningLogic(float delta, CallbackInfo ci, @Local(ordinal = 0) LocalRef<Integer> ambientLight, @Local(ordinal = 1) int blockLight) {
        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        if (player == null) return;

        // 1. Biome Check
        if (player.getWorld().getBiome(player.getBlockPos()).isIn(ModTags.Biomes.DARK_BIOMES)) {

            // 2. The "Flicker" Math
            // Use world time to create a sine wave or random noise
            float flicker = (float) (Math.sin(player.getWorld().getTime() * 0.5) * 0.1);

            // 3. Darken the Lightmap
            // The game mixes Sky Light (ambient) and Block Light.
            // We want to crush the Block Light values so torches look dim.

            // This is pseudo-code for the logic you insert into the lightmap loop
            // You effectively multiply the calculated brightness by 0.5 (Dim) + flicker
        }
    }
}
