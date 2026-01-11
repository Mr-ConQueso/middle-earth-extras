package net.mrconqueso.middleearthextras.compat.lambdynlights_api;

import dev.lambdaurora.lambdynlights.api.DynamicLightsInitializer;
import dev.lambdaurora.lambdynlights.api.entity.luminance.EntityLuminance;
import dev.lambdaurora.lambdynlights.api.item.ItemLightSourceManager;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.jukoz.me.block.ModDecorativeBlocks;
import net.jukoz.me.item.ModResourceItems;
import net.minecraft.util.Identifier;
import net.mrconqueso.middleearthextras.MiddleEarthExtras;

public class LambDynLights implements DynamicLightsInitializer {

    public static final EntityLuminance.Type CUSTOM_ENTITY_LUMINANCE
            = EntityLuminance.Type.register(
            Identifier.of(MiddleEarthExtras.MOD_ID, "custom"),
            CustomEntityLuminance.CODEC
    );

    public static final EntityLuminance.Type CONSTANT
            = EntityLuminance.Type.registerSimple(
            Identifier.of(MiddleEarthExtras.MOD_ID, "constant"),
            ConstantEntityLuminance.INSTANCE
    );

    @Environment(EnvType.CLIENT)
    public static void initClient() {

    }

    @Override
    public void onInitializeDynamicLights(ItemLightSourceManager itemLightSourceManager) {
            itemLightSourceManager.onRegisterEvent().register(context -> {
                context.register(ModResourceItems.STARLIGHT_PHIAL, 15);
                context.register(ModResourceItems.LIT_PINECONE, 8);
                context.register(ModDecorativeBlocks.CANDLE_HEAP, 10);
                context.register(ModDecorativeBlocks.DWARVEN_LANTERN, 15);
                context.register(ModDecorativeBlocks.CRYSTAL_LAMP, 15);
                context.register(ModDecorativeBlocks.SILVER_LANTERN, 15);
                context.register(ModDecorativeBlocks.ELVEN_LANTERN, 15);
                context.register(ModResourceItems.MITHRIL_NUGGET, 3);
                context.register(ModResourceItems.MITHRIL_INGOT, 5);
                context.register(ModResourceItems.RAW_MITHRIL, 4);
        });
    }
}