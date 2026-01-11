package net.mrconqueso.middleearthextras.item;

import net.jukoz.me.datageneration.content.models.SimpleDyeableItemModel;
import net.jukoz.me.item.items.armor.CustomBootsItem;
import net.jukoz.me.item.items.armor.CustomChestplateItem;
import net.jukoz.me.item.items.armor.CustomHelmetItem;
import net.jukoz.me.item.items.armor.CustomLeggingsItem;
import net.jukoz.me.item.utils.ModItemGroups;
import net.jukoz.me.item.utils.armor.ModArmorMaterials;
import net.jukoz.me.utils.ModFactions;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.mrconqueso.middleearthextras.MiddleEarthExtras;
import net.mrconqueso.middleearthextras.datagen.content.models.SimpleItemModel;
import net.mrconqueso.middleearthextras.item.items.OliphauntArmorItem;

import static net.jukoz.me.item.ModEquipmentItems.*;

public class ModEquipmentItems {

    public static final Item HARADRIM_HELMET = registerArmorPiece("haradrim_helmet", new CustomHelmetItem(ModArmorMaterials.BRONZE_T1, new Item.Settings(), ModFactions.MORDOR));
    public static final Item HARADRIM_LEGGINGS = registerArmorPiece("haradrim_leggings", new CustomLeggingsItem(ModArmorMaterials.BRONZE_T1, new Item.Settings(), ModFactions.MORDOR));
    public static final Item HARADRIM_CHESTPLATE = registerArmorPiece("haradrim_chestplate", new CustomChestplateItem(ModArmorMaterials.BRONZE_T1, new Item.Settings(), ModFactions.MORDOR));
    public static final Item HARADRIM_BOOTS = registerArmorPiece("haradrim_boots", new CustomBootsItem(ModArmorMaterials.BRONZE_T1, new Item.Settings(), ModFactions.MORDOR));

    public static final Item NAZGUL_HELMET = registerArmorPiece("nazgul_helmet", new CustomHelmetItem(ModArmorMaterials.STEEL_T5, new Item.Settings(), ModFactions.MORDOR));
    public static final Item NAZGUL_LEGGINGS = registerArmorPiece("nazgul_leggings", new CustomLeggingsItem(ModArmorMaterials.STEEL_T5, new Item.Settings(), ModFactions.MORDOR));
    public static final Item NAZGUL_CHESTPLATE = registerArmorPiece("nazgul_chestplate", new CustomChestplateItem(ModArmorMaterials.STEEL_T5, new Item.Settings(), ModFactions.MORDOR));
    public static final Item NAZGUL_BOOTS = registerArmorPiece("nazgul_boots", new CustomBootsItem(ModArmorMaterials.STEEL_T5, new Item.Settings(), ModFactions.MORDOR));

    public static final Item OLIPHAUNT_ARMOR = registerItem("oliphaunt_armor",
            new OliphauntArmorItem(ArmorMaterials.IRON, new Item.Settings().maxCount(1)));


    private static Item registerArmorPiece(String name, Item item) {
        ModItemGroups.EQUIPMENT_CONTENTS.add(item.getDefaultStack());
        SimpleItemModel.items.add(item);
        switch (item) {
            case CustomHelmetItem helmetItem -> armorPiecesListHelmets.add(helmetItem);
            case CustomChestplateItem chestplateItem -> armorPiecesListChestplates.add(chestplateItem);
            case CustomLeggingsItem leggingsItem -> armorPiecesListLeggings.add(leggingsItem);
            case CustomBootsItem bootsItem -> armorPiecesListBoots.add(bootsItem);
            default -> throw new IllegalStateException("Unexpected value: " + String.valueOf(item));
        }

        return (Item) Registry.register(Registries.ITEM, Identifier.of(MiddleEarthExtras.MOD_ID, name), item);
    }

    private static Item registerItem(String name, Item item) {
        ModItemGroups.EQUIPMENT_CONTENTS.add(item.getDefaultStack());
        SimpleItemModel.items.add(item);
        return Registry.register(Registries.ITEM, Identifier.of(MiddleEarthExtras.MOD_ID, name), item);
    }

    public static void registerModItems() {
        MiddleEarthExtras.LOGGER.info("Registering Equipment Items for " + MiddleEarthExtras.MOD_ID);
    }
}
