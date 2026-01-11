package net.mrconqueso.middleearthextras.item;

import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.mrconqueso.middleearthextras.MiddleEarthExtras;
import net.mrconqueso.middleearthextras.datagen.content.models.SimpleSpawnEggModel;
import net.mrconqueso.middleearthextras.entity.ModEntities;

public class ModEggItems {
    public static final Item FELL_BEAST_SPAWN_EGG = registerItem("fell_beast_spawn_egg",
            new SpawnEggItem(ModEntities.FELL_BEAST, 0x57737a, 0x263938, new Item.Settings()));

    public static final Item OLIPHAUNT_SPAWN_EGG = registerItem("oliphaunt_spawn_egg",
            new SpawnEggItem(ModEntities.OLIPHAUNT, 0x919191, 0xbd4a34, new Item.Settings()));

    public static final Item HARADRIM_SPAWN_EGG = registerItem("haradrim_spawn_egg",
            new SpawnEggItem(ModEntities.HARADRIM, 0xbd4a34, 0xe59220, new Item.Settings()));

    public static final Item NAZGUL_SPAWN_EGG = registerItem("nazgul_spawn_egg",
            new SpawnEggItem(ModEntities.RING_WRAITH, 0xbd4a34, 0xe59220, new Item.Settings()));

    public static final Item BEORNING_SPAWN_EGG = registerItem("beorning_spawn_egg",
            new SpawnEggItem(ModEntities.BEORNING_HUMAN, 0x5c3f2c, 0xfcd6b8, new Item.Settings()));

    public static final Item ENT_SPAWN_EGG = registerItem("ent_spawn_egg",
            new SpawnEggItem(ModEntities.ENT, 0x564629, 0x95a835, new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        ModItemGroups.SPAWN_EGGS_CONTENTS.add(item.getDefaultStack());
        SimpleSpawnEggModel.items.add(item);
        return Registry.register(Registries.ITEM, Identifier.of(MiddleEarthExtras.MOD_ID, name), item);
    }

    public static void registerModItems() {
        MiddleEarthExtras.LOGGER.info("Registering Spawn Egg Items for " + MiddleEarthExtras.MOD_ID);
    }
}
