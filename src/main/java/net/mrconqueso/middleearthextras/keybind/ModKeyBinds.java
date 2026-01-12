package net.mrconqueso.middleearthextras.keybind;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.mrconqueso.middleearthextras.MiddleEarthExtras;
import net.mrconqueso.middleearthextras.entity.misc.PalantirViewEntity;
import net.mrconqueso.middleearthextras.network.PalantirNetwork;
import net.mrconqueso.middleearthextras.network.ScreenshakePayload;
import org.lwjgl.glfw.GLFW;

public class ModKeyBinds {
    public static final KeyBinding K_KEYBIND = KeyBindingHelper.registerKeyBinding(
            new KeyBinding("key.middle-earth-extras.k", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_K,
                    "key.middle-earth-extras.category")
        );

    public static void registerKeyBinds() {
        ClientTickEvents.END_CLIENT_TICK.register(minecraftClient -> {
            while (K_KEYBIND.wasPressed()) {
                ClientPlayNetworking.send(new ScreenshakePayload(1.0f, 40));
            }
        });

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player != null && client.getCameraEntity() instanceof PalantirViewEntity palantirView) {
                // Check if we are the one controlling it
                if (client.player.getUuid().equals(palantirView.getUsingPlayerUUID())) {
                    if (client.options.sneakKey.isPressed()) {
                        ClientPlayNetworking.send(new PalantirNetwork.PalantirExitPayload(palantirView.getId()));
                    }
                }
            }
        });

        MiddleEarthExtras.LOGGER.info("Registering Mod Key Binds for " + MiddleEarthExtras.MOD_ID);
    }
}
