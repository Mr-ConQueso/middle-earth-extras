package net.mrconqueso.middleearthextras.item;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.mrconqueso.middleearthextras.MiddleEarthExtras;

public class ModToolItems {


    private static Item registerItem(String name, Item item) {
        ModItemGroups.MISC_CONTENTS.add(item.getDefaultStack());
        return Registry.register(Registries.ITEM, Identifier.of(MiddleEarthExtras.MOD_ID, name), item);
    }

    public static void registerModItems() {
        MiddleEarthExtras.LOGGER.info("Registering Tool Items for " + MiddleEarthExtras.MOD_ID);
    }
}
