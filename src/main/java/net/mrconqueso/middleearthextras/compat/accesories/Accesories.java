package net.mrconqueso.middleearthextras.compat.accesories;

import io.wispforest.accessories.api.AccessoriesAPI;
import io.wispforest.accessories.api.AccessoriesCapability;
import io.wispforest.accessories.api.Accessory;
import io.wispforest.accessories.api.client.AccessoriesRendererRegistry;
import io.wispforest.accessories.api.slot.SlotReference;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.mrconqueso.middleearthextras.item.rings.RingItem;

public class Accesories implements Accessory {
    public static void init() {
        Registries.ITEM.stream()
                .filter(item -> item instanceof RingItem)
                .forEach(item -> AccessoriesAPI.registerAccessory(item, new Accesories()));
    }

    @Environment(EnvType.CLIENT)
    public static void initClient() {
        Registries.ITEM.stream()
                .filter(holder -> holder instanceof RingItem)
                .forEach(holder -> AccessoriesRendererRegistry.registerRenderer(holder, RingAccesoryRenderer::new));
    }

    @Override
    public boolean canEquip(ItemStack stack, SlotReference reference) {
        var capability = AccessoriesCapability.get(reference.entity());
        return capability == null || !capability.isAnotherEquipped(stack, reference, stack.getItem());
    }

    @Override
    public boolean canEquipFromUse(ItemStack stack) {
        return true;
    }

    @Override
    public void tick(ItemStack stack, SlotReference reference) {
        if (stack.getItem() instanceof RingItem ringItem) {
            ringItem.tickRing(stack, reference.entity());
        }
    }

    @Override
    public void onUnequip(ItemStack stack, SlotReference reference) {
        Accessory.super.onUnequip(stack, reference);
        if (stack.getItem() instanceof RingItem ringItem) {
            ringItem.unequipRing(stack, reference.entity());
        }
    }
}