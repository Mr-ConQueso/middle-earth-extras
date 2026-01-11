package net.mrconqueso.middleearthextras.client;

import net.minecraft.client.MinecraftClient;
import org.lwjgl.openal.*;
import net.mrconqueso.middleearthextras.effect.ModEffects;

public class WraithAudioManager {

    private static int effectSlot = 0;
    private static int reverbEffect = 0;
    private static int lowPassFilter = 0;
    private static boolean isInitialized = false;
    private static boolean wasActive = false;

    public static void init() {
        // 1. Create Auxiliary Effect Slot
        effectSlot = EXTEfx.alGenAuxiliaryEffectSlots();
        EXTEfx.alAuxiliaryEffectSloti(effectSlot, EXTEfx.AL_EFFECTSLOT_AUXILIARY_SEND_AUTO, AL10.AL_TRUE);

        // 2. Create Reverb Effect
        reverbEffect = EXTEfx.alGenEffects();
        EXTEfx.alEffecti(reverbEffect, EXTEfx.AL_EFFECT_TYPE, EXTEfx.AL_EFFECT_EAXREVERB);
        // Configure for "Ghostly" sound (High decay, low density)
        EXTEfx.alEffectf(reverbEffect, EXTEfx.AL_EAXREVERB_DECAY_TIME, 2.5f);
        EXTEfx.alEffectf(reverbEffect, EXTEfx.AL_EAXREVERB_DENSITY, 0.2f);
        EXTEfx.alEffectf(reverbEffect, EXTEfx.AL_EAXREVERB_GAIN, 0.8f);

        // 3. Create Low Pass Filter (Muffle)
        lowPassFilter = EXTEfx.alGenFilters();
        EXTEfx.alFilteri(lowPassFilter, EXTEfx.AL_FILTER_TYPE, EXTEfx.AL_FILTER_LOWPASS);
        EXTEfx.alFilterf(lowPassFilter, EXTEfx.AL_LOWPASS_GAIN, 1.0f); // Volume
        EXTEfx.alFilterf(lowPassFilter, EXTEfx.AL_LOWPASS_GAINHF, 0.1f); // Cutoff High Frequencies (Muffled)

        isInitialized = true;
    }

    public static void tick() {
        if (!isInitialized) return;

        MinecraftClient client = MinecraftClient.getInstance();
        if (client.player == null) return;

        boolean isActive = client.player.hasStatusEffect(ModEffects.UNSEEN_FORM);

        if (isActive != wasActive) {
            if (isActive) {
                enableWraithAudio();
            } else {
                disableWraithAudio();
            }
            wasActive = isActive;
        }
    }

    private static void enableWraithAudio() {
        // Load the Reverb into the Slot
        EXTEfx.alAuxiliaryEffectSloti(effectSlot, EXTEfx.AL_EFFECTSLOT_EFFECT, reverbEffect);

        // This is the tricky part: We need to tell the Listener (Player) or Sources to use this.
        // Minecraft doesn't easily let us set Global Filters.
        // STRATEGY: We apply the Direct Filter to the Context or Listener via the SoundSystem Mixin.
    }

    private static void disableWraithAudio() {
        // Reset slot
        EXTEfx.alAuxiliaryEffectSloti(effectSlot, EXTEfx.AL_EFFECTSLOT_EFFECT, EXTEfx.AL_EFFECT_NULL);
    }

    // Accessors for the Mixin
    public static int getLowPassFilter() { return lowPassFilter; }
    public static int getEffectSlot() { return effectSlot; }
    public static boolean isWraithMode() { return wasActive; }
}
