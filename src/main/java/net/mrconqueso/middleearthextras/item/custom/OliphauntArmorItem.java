package net.mrconqueso.middleearthextras.item.custom;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.registry.entry.RegistryEntry;

public class OliphauntArmorItem extends ArmorItem {
    public OliphauntArmorItem(RegistryEntry<ArmorMaterial> material, Settings settings) {
        super(material, Type.BODY, settings);
    }
}
