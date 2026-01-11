package net.mrconqueso.middleearthextras.mixin.client;

import net.minecraft.client.sound.SoundSystem;
import net.mrconqueso.middleearthextras.client.WraithAudioManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SoundSystem.class)
public class SoundSystemMixin {
    @Inject(method = "start", at = @At("TAIL"))
    private void initWraithAudio(CallbackInfo ci) {
        WraithAudioManager.init();
    }
}
