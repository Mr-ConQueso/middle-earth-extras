package net.mrconqueso.middleearthextras.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.jukoz.me.item.items.shields.CustomShieldItem;
import net.jukoz.me.item.utils.ModItemGroups;
import net.jukoz.me.item.utils.ModShieldTypes;
import net.jukoz.me.utils.ModFactions;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.mrconqueso.middleearthextras.MiddleEarthExtras;
import net.mrconqueso.middleearthextras.entity.ModEntities;
import net.mrconqueso.middleearthextras.item.custom.ChiselItem;
import net.mrconqueso.middleearthextras.item.custom.OliphauntArmorItem;

import java.util.ArrayList;
import java.util.List;

public class ModItems {

    public static List<Item> shields = new ArrayList<>();

    public static final Item PINK_GARNET = registerItem("pink_garnet", new Item(new Item.Settings()));
    public static final Item RAW_PINK_GARNET = registerItem("raw_pink_garnet", new Item(new Item.Settings()));

    public static final Item CHISEL = registerItem("chisel", new ChiselItem(new Item.Settings().maxDamage(32)));
    public static final Item CAULIFLOWER = registerItem("cauliflower", new Item(new Item.Settings().food(ModFoodComponents.CAULIFLOWER)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.middle-earth-extras.cauliflower.tooltip"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });

    public static final Item STARLIGHT_ASHES = registerItem("starlight_ashes", new Item(new Item.Settings()));

    public static final Item FELL_BEAST_SPAWN_EGG = registerItem("fell_beast_spawn_egg",
            new SpawnEggItem(ModEntities.FELL_BEAST, 0x57737a, 0x263938, new Item.Settings()));

    public static final Item OLIPHAUNT_SPAWN_EGG = registerItem("oliphaunt_spawn_egg",
            new SpawnEggItem(ModEntities.OLIPHAUNT, 0x919191, 0xbd4a34, new Item.Settings()));

    public static final Item HARADRIM_SPAWN_EGG = registerItem("haradrim_spawn_egg",
            new SpawnEggItem(ModEntities.HARADRIM, 0xbd4a34, 0xe59220, new Item.Settings()));

    public static final Item BEORNING_SPAWN_EGG = registerItem("beorning_spawn_egg",
            new SpawnEggItem(ModEntities.BEORNING_HUMAN, 0x5c3f2c, 0xfcd6b8, new Item.Settings()));

    public static final Item ENT_SPAWN_EGG = registerItem("ent_spawn_egg",
            new SpawnEggItem(ModEntities.ENT, 0x564629, 0x95a835, new Item.Settings()));


    public static final Item OLIPHAUNT_ARMOR = registerItem("oliphaunt_armor",
            new OliphauntArmorItem(ArmorMaterials.IRON, new Item.Settings().maxCount(1)));

    public static final Item OAKEN_SHIELD = registerItem("oaken_shield",
            new ShieldItem(new Item.Settings().maxCount(1)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(MiddleEarthExtras.MOD_ID, name), item);
    }

    private static Item registerShield(String name, Item item) {
        ModItemGroups.WEAPONS_CONTENTS.add(item.getDefaultStack());
        shields.add(item);
        return Registry.register(Registries.ITEM, Identifier.of(MiddleEarthExtras.MOD_ID, name), item);
    }

    public static void registerModItems() {
        MiddleEarthExtras.LOGGER.info("Registering Mod Items for " + MiddleEarthExtras.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(PINK_GARNET);
            entries.add(RAW_PINK_GARNET);
        });
    }
}