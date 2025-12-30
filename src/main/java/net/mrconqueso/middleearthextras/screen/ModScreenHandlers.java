package net.mrconqueso.middleearthextras.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.Uuids;
import net.mrconqueso.middleearthextras.MiddleEarthExtras;
import net.mrconqueso.middleearthextras.screen.custom.OliphauntScreenHandler;

public class ModScreenHandlers {

    public static final ScreenHandlerType<OliphauntScreenHandler> OLIPHAUNT_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, Identifier.of(MiddleEarthExtras.MOD_ID, "oliphaunt_screen_handler"),
                    new ExtendedScreenHandlerType<>(OliphauntScreenHandler::create, Uuids.PACKET_CODEC));

    public static void registerScreenHandlers() {
        MiddleEarthExtras.LOGGER.info("Registering screen handlers for: " + MiddleEarthExtras.MOD_ID);
    }
}
