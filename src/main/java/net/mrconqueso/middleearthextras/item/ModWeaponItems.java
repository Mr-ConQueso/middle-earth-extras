package net.mrconqueso.middleearthextras.item;

import net.jukoz.me.item.items.shields.CustomBannerShieldItem;
import net.jukoz.me.item.utils.ModItemGroups;
import net.jukoz.me.item.utils.ModShieldTypes;
import net.jukoz.me.utils.ModFactions;
import net.minecraft.item.Item;
import net.minecraft.item.ShieldItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.mrconqueso.middleearthextras.MiddleEarthExtras;

import java.util.ArrayList;
import java.util.List;

public class ModWeaponItems {

    public static List<Item> modShields = new ArrayList();

    public static final Item OAKEN_SHIELD = registerShield("oaken_shield",
            new ShieldItem(new Item.Settings().maxCount(1)));

    public static final Item HARADRIM_SHIELD = registerShield("haradrim_shield", new CustomBannerShieldItem(ModShieldTypes.MEDIUM_SHIELD, ModFactions.NONE));


    private static Item registerShield(String name, Item item) {
        ModItemGroups.WEAPONS_CONTENTS.add(item.getDefaultStack());
        modShields.add(item);
        return (Item) Registry.register(Registries.ITEM, Identifier.of(MiddleEarthExtras.MOD_ID, name), item);
    }

    public static void registerModItems() {
        MiddleEarthExtras.LOGGER.info("Registering Weapon Items for " + MiddleEarthExtras.MOD_ID);
    }
}
