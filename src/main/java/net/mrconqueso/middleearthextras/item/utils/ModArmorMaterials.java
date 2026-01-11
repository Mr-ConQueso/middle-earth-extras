package net.mrconqueso.middleearthextras.item.utils;

import net.jukoz.me.item.ModResourceItems;
import net.jukoz.me.item.utils.armor.ExtendedArmorMaterial;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.mrconqueso.middleearthextras.MiddleEarthExtras;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class ModArmorMaterials {

    public static final ExtendedArmorMaterial BRONZE_T1 = registerArmor("straw_t1",net.jukoz.me.item.utils.armor.ModArmorMaterials.Tiers.BASIC, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, ModResourceItems.STRAW);

    private static ExtendedArmorMaterial registerArmor(String name, net.jukoz.me.item.utils.armor.ModArmorMaterials.Tiers tier, RegistryEntry<SoundEvent> equipSound, Item repairIngredient) {
        EnumMap<ArmorItem.Type, Integer> map = new EnumMap(ArmorItem.Type.class);
        float toughness;
        float knockbackResistance;
        int enchantability;
        int durabilityMultiplier;
        switch (tier.ordinal()) {
            case 0:
                map.put(ArmorItem.Type.BOOTS, 1);
                map.put(ArmorItem.Type.LEGGINGS, 1);
                map.put(ArmorItem.Type.CHESTPLATE, 1);
                map.put(ArmorItem.Type.HELMET, 1);
                map.put(ArmorItem.Type.BODY, 1);
                durabilityMultiplier = 5;
                toughness = 0.0F;
                knockbackResistance = 0.0F;
                enchantability = 10;
                break;
            case 1:
                map.put(ArmorItem.Type.BOOTS, 1);
                map.put(ArmorItem.Type.LEGGINGS, 2);
                map.put(ArmorItem.Type.CHESTPLATE, 3);
                map.put(ArmorItem.Type.HELMET, 1);
                map.put(ArmorItem.Type.BODY, 4);
                durabilityMultiplier = 7;
                toughness = 0.0F;
                knockbackResistance = 0.0F;
                enchantability = 10;
                break;
            case 2:
                map.put(ArmorItem.Type.BOOTS, 1);
                map.put(ArmorItem.Type.LEGGINGS, 3);
                map.put(ArmorItem.Type.CHESTPLATE, 4);
                map.put(ArmorItem.Type.HELMET, 1);
                map.put(ArmorItem.Type.BODY, 5);
                durabilityMultiplier = 11;
                toughness = 0.0F;
                knockbackResistance = 0.0F;
                enchantability = 10;
                break;
            case 3:
                map.put(ArmorItem.Type.BOOTS, 2);
                map.put(ArmorItem.Type.LEGGINGS, 4);
                map.put(ArmorItem.Type.CHESTPLATE, 5);
                map.put(ArmorItem.Type.HELMET, 2);
                map.put(ArmorItem.Type.BODY, 6);
                durabilityMultiplier = 15;
                toughness = 0.5F;
                knockbackResistance = 0.0F;
                enchantability = 10;
                break;
            case 4:
                map.put(ArmorItem.Type.BOOTS, 2);
                map.put(ArmorItem.Type.LEGGINGS, 5);
                map.put(ArmorItem.Type.CHESTPLATE, 6);
                map.put(ArmorItem.Type.HELMET, 2);
                map.put(ArmorItem.Type.BODY, 8);
                durabilityMultiplier = 25;
                toughness = 1.0F;
                knockbackResistance = 0.1F;
                enchantability = 10;
                break;
            case 5:
                map.put(ArmorItem.Type.BOOTS, 3);
                map.put(ArmorItem.Type.LEGGINGS, 6);
                map.put(ArmorItem.Type.CHESTPLATE, 7);
                map.put(ArmorItem.Type.HELMET, 3);
                map.put(ArmorItem.Type.BODY, 10);
                durabilityMultiplier = 35;
                toughness = 2.0F;
                knockbackResistance = 0.1F;
                enchantability = 10;
                break;
            default:
                map.put(ArmorItem.Type.BOOTS, 1);
                map.put(ArmorItem.Type.LEGGINGS, 2);
                map.put(ArmorItem.Type.CHESTPLATE, 3);
                map.put(ArmorItem.Type.HELMET, 1);
                map.put(ArmorItem.Type.BODY, 3);
                durabilityMultiplier = 5;
                toughness = 0.0F;
                knockbackResistance = 0.0F;
                enchantability = 1;
        }

        return register(name, map, durabilityMultiplier, enchantability, equipSound, toughness, knockbackResistance, () -> Ingredient.ofItems(new ItemConvertible[]{repairIngredient}), tier);
    }

    private static ExtendedArmorMaterial register(String name, EnumMap<ArmorItem.Type, Integer> defense, int durabilityMultiplier, int enchantability, RegistryEntry<SoundEvent> equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient, net.jukoz.me.item.utils.armor.ModArmorMaterials.Tiers tier) {
        EnumMap<ArmorItem.Type, Integer> enumMap = new EnumMap(ArmorItem.Type.class);

        for(ArmorItem.Type type : ArmorItem.Type.values()) {
            enumMap.put(type, (Integer)defense.get(type));
        }

        ArmorMaterial material = new ArmorMaterial(enumMap, enchantability, equipSound, repairIngredient, (List)null, toughness, knockbackResistance);
        return new ExtendedArmorMaterial(Registry.registerReference(Registries.ARMOR_MATERIAL, Identifier.of("me", name), material), durabilityMultiplier, tier);
    }

    private static RegistryEntry<ArmorMaterial> registerMountArmor(String id, net.jukoz.me.item.utils.armor.ModArmorMaterials.Tiers tier, RegistryEntry<SoundEvent> equipSound, Item repairIngredient) {
        EnumMap<ArmorItem.Type, Integer> map = new EnumMap(ArmorItem.Type.class);
        float toughness = 0.0F;
        float knockbackResistance = 0.0F;
        int enchantability = 0;
        switch (tier.ordinal()) {
            case 2:
                map.put(ArmorItem.Type.BOOTS, 1);
                map.put(ArmorItem.Type.LEGGINGS, 3);
                map.put(ArmorItem.Type.CHESTPLATE, 4);
                map.put(ArmorItem.Type.HELMET, 1);
                map.put(ArmorItem.Type.BODY, 4);
                int durabilityMultiplier = 11;
                toughness = 0.0F;
                knockbackResistance = 0.0F;
                enchantability = 10;
                break;
            case 3:
                map.put(ArmorItem.Type.BOOTS, 2);
                map.put(ArmorItem.Type.LEGGINGS, 4);
                map.put(ArmorItem.Type.CHESTPLATE, 5);
                map.put(ArmorItem.Type.HELMET, 2);
                map.put(ArmorItem.Type.BODY, 6);
                durabilityMultiplier = 15;
                toughness = 0.5F;
                knockbackResistance = 0.0F;
                enchantability = 10;
            case 4:
            default:
                break;
            case 5:
                map.put(ArmorItem.Type.BOOTS, 3);
                map.put(ArmorItem.Type.LEGGINGS, 6);
                map.put(ArmorItem.Type.CHESTPLATE, 7);
                map.put(ArmorItem.Type.HELMET, 3);
                map.put(ArmorItem.Type.BODY, 10);
                durabilityMultiplier = 35;
                toughness = 2.0F;
                knockbackResistance = 0.1F;
                enchantability = 10;
        }

        return Registry.registerReference(Registries.ARMOR_MATERIAL, Identifier.of(MiddleEarthExtras.MOD_ID, id), new ArmorMaterial(map, enchantability, equipSound, () -> Ingredient.ofItems(new ItemConvertible[]{repairIngredient}), (List)null, toughness, knockbackResistance));
    }
}
