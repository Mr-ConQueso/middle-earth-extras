package net.mrconqueso.middleearthextras.item;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.mrconqueso.middleearthextras.MiddleEarthExtras;
import net.mrconqueso.middleearthextras.item.rings.OneRingItem;
import net.mrconqueso.middleearthextras.item.rings.RingItem;

public class ModRingItems {
    public static final Item THE_ONE = registerItemGenerated("the_one",
            new OneRingItem(new Item.Settings().maxCount(1)));

    public static final Item NARYA = registerItemGenerated("narya",
            new RingItem(new Item.Settings().maxCount(1)));
    public static final Item NENYA = registerItemGenerated("nenya",
            new RingItem(new Item.Settings().maxCount(1)));
    public static final Item VILYA = registerItemGenerated("vilya",
            new RingItem(new Item.Settings().maxCount(1)));

    public static final Item THROR = registerItemGenerated("thror",
            new RingItem(new Item.Settings().maxCount(1)));
    public static final Item BARAZ = registerItemGenerated("baraz",
            new RingItem(new Item.Settings().maxCount(1)));
    public static final Item BURIN = registerItemGenerated("burin",
            new RingItem(new Item.Settings().maxCount(1)));
    public static final Item FARIN = registerItemGenerated("farin",
            new RingItem(new Item.Settings().maxCount(1)));
    public static final Item KHAIN = registerItemGenerated("khain",
            new RingItem(new Item.Settings().maxCount(1)));
    public static final Item KHIBIL = registerItemGenerated("khibil",
            new RingItem(new Item.Settings().maxCount(1)));
    public static final Item THULIN = registerItemGenerated("thulin",
            new RingItem(new Item.Settings().maxCount(1)));

    public static final Item ADUNAPHEL = registerItemGenerated("adunaphel",
            new RingItem(new Item.Settings().maxCount(1)));
    public static final Item AKHORAHIL = registerItemGenerated("akhorahil",
            new RingItem(new Item.Settings().maxCount(1)));
    public static final Item HOARMURATH = registerItemGenerated("hoarmurath",
            new RingItem(new Item.Settings().maxCount(1)));
    public static final Item JIINDUR = registerItemGenerated("jiindur",
            new RingItem(new Item.Settings().maxCount(1)));
    public static final Item KHAMUL = registerItemGenerated("khamul",
            new RingItem(new Item.Settings().maxCount(1)));
    public static final Item MURAZOR = registerItemGenerated("murazor",
            new RingItem(new Item.Settings().maxCount(1)));
    public static final Item REN = registerItemGenerated("ren",
            new RingItem(new Item.Settings().maxCount(1)));
    public static final Item UVATHA = registerItemGenerated("uvatha",
            new RingItem(new Item.Settings().maxCount(1)));
    public static final Item ZIMIL = registerItemGenerated("zimil",
            new RingItem(new Item.Settings().maxCount(1)));

    private static Item registerItemGenerated(String name, Item item) {
        ModItemGroups.RINGS_CONTENTS.add(item.getDefaultStack());
        // SimpleRingModel.items.add(item);
        return Registry.register(Registries.ITEM, Identifier.of(MiddleEarthExtras.MOD_ID, name), item);
    }

    public static void registerModItems() {
        MiddleEarthExtras.LOGGER.info("Registering Ring Items for " + MiddleEarthExtras.MOD_ID);
    }
}