package net.mrconqueso.middleearthextras.compat.trinkets;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.Trinket;
import dev.emi.trinkets.api.TrinketComponent;
import dev.emi.trinkets.api.TrinketsApi;
import dev.emi.trinkets.api.client.TrinketRendererRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.mrconqueso.middleearthextras.item.rings.RingItem;

import java.util.Optional;

public class Trinkets implements Trinket {
    public static void init() {
        Registries.ITEM.stream()
                .filter(item -> item instanceof RingItem)
                .forEach(item -> TrinketsApi.registerTrinket(item, new Trinkets()));
    }

    @Environment(EnvType.CLIENT)
    public static void initClient() {
        Registries.ITEM.stream()
                .filter(item -> item instanceof RingItem)
                .forEach(item -> TrinketRendererRegistry.registerRenderer(item, new RingTrinketRenderer()));
    }

    @Override
    public boolean canEquip(ItemStack stack, SlotReference slot, LivingEntity entity) {
        Optional<TrinketComponent> component = TrinketsApi.getTrinketComponent(entity);
        if (component.isPresent()) {
            if (component.get().isEquipped(stack.getItem())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean canEquipFromUse(ItemStack stack, LivingEntity entity) {
        return true;
    }

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        if (stack.getItem() instanceof RingItem ringItem) {
            ringItem.tickRing(stack, entity);
        }
    }

    @Override
    public void onUnequip(ItemStack stack, SlotReference slot, LivingEntity entity) {
        Trinket.super.onUnequip(stack, slot, entity);
        if (stack.getItem() instanceof RingItem ringItem) {
            ringItem.unequipRing(stack, entity);
        }
    }
}