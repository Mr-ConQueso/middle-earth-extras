package net.mrconqueso.middleearthextras.mixin.client;

import net.minecraft.client.sound.Source;
import net.mrconqueso.middleearthextras.client.WraithAudioManager;
import org.lwjgl.openal.AL10;
import org.lwjgl.openal.AL11;
import org.lwjgl.openal.EXTEfx;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Source.class)
public class SourceMixin {


    // Shadow the actual field name from Source.java
    @Final
    @Shadow private int pointer;

    // We track the last state to avoid calling OpenAL every single tick if nothing changed
    @Unique
    private boolean wasWraith = false;

    // Inject into tick to update currently playing sounds dynamically
    @Inject(method = "tick", at = @At("HEAD"))
    private void updateWraithEffects(CallbackInfo ci) {
        // Optimization: Only update if the state changed or if it's the first tick
        // But for robustness, we can update every tick or check a dirty flag in WraithAudioManager.
        // For now, let's just check the current mode.
        
        boolean isWraith = WraithAudioManager.isWraithMode();
        
        // You might want to optimize this to only run if (isWraith != wasWraith) 
        // BUT OpenAL state might get reset by other things, so setting it every tick is safer for now.
        
        if (isWraith) {
            // Apply Low Pass Filter
            AL10.alSourcei(this.pointer, EXTEfx.AL_DIRECT_FILTER, WraithAudioManager.getLowPassFilter());
            // Apply Reverb to Aux Slot 0
            AL11.alSource3i(this.pointer, EXTEfx.AL_AUXILIARY_SEND_FILTER, WraithAudioManager.getEffectSlot(), 0, EXTEfx.AL_FILTER_NULL);
        } else if (wasWraith) { 
            // Only reset if we were previously in wraith mode to save JNI calls
            AL10.alSourcei(this.pointer, EXTEfx.AL_DIRECT_FILTER, EXTEfx.AL_FILTER_NULL);
            AL11.alSource3i(this.pointer, EXTEfx.AL_AUXILIARY_SEND_FILTER, EXTEfx.AL_EFFECTSLOT_NULL, 0, EXTEfx.AL_FILTER_NULL);
        }
        
        this.wasWraith = isWraith;
    }
    
    // Keep the injection in 'play' to catch sounds the moment they start
    @Inject(method = "play", at = @At("HEAD"))
    private void onPlay(CallbackInfo ci) {
        if (WraithAudioManager.isWraithMode()) {
            AL10.alSourcei(this.pointer, EXTEfx.AL_DIRECT_FILTER, WraithAudioManager.getLowPassFilter());
            AL11.alSource3i(this.pointer, EXTEfx.AL_AUXILIARY_SEND_FILTER, WraithAudioManager.getEffectSlot(), 0, EXTEfx.AL_FILTER_NULL);
            this.wasWraith = true;
        } else {
             this.wasWraith = false;
        }
    }
}