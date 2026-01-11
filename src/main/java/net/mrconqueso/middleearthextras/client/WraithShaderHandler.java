package net.mrconqueso.middleearthextras.client;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.Identifier;
import net.mrconqueso.middleearthextras.MiddleEarthExtras;
import net.mrconqueso.middleearthextras.effect.ModEffects;
import net.mrconqueso.middleearthextras.mixin.client.GameRendererAccessor;

public class WraithShaderHandler {

    public static final Identifier WRAITH_SHADER = Identifier.of(MiddleEarthExtras.MOD_ID, "shaders/post/wraith_vision.json");
    private static boolean wasEffectActive = false;

    public static void register() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player == null || client.world == null) return;

            boolean hasEffect = client.player.hasStatusEffect(ModEffects.UNSEEN_FORM);

            // Fix: Check if any post processor is currently active.
            // checking '== string' caused the error because getPostProcessor() returns an Object.
            boolean isShaderActive = client.gameRenderer.getPostProcessor() != null;

            if (hasEffect) {
                // If the player has the effect but the shader is missing (e.g. pressed F5), re-enable it.
                if (!isShaderActive) {
                    enableShader(client);
                }
            } else if (wasEffectActive) {
                // Only disable if we previously had the effect (to avoid disabling other mod's shaders unexpectedly)
                disableShader(client);
            }

            wasEffectActive = hasEffect;
        });
    }

    private static void enableShader(MinecraftClient client) {
        if (client.gameRenderer != null) {
            ((GameRendererAccessor) client.gameRenderer).invokeLoadPostProcessor(WRAITH_SHADER);
        }
    }

    private static void disableShader(MinecraftClient client) {
        if (client.gameRenderer != null) {
            client.gameRenderer.disablePostProcessor();
        }
    }
}