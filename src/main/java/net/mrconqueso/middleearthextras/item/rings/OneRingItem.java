package net.mrconqueso.middleearthextras.item.rings;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;
import net.mrconqueso.middleearthextras.effect.ModEffects;

public class OneRingItem extends RingItem {
    public OneRingItem(Settings settings) {
        super(settings);
    }

    @Override
    public void tickRing(ItemStack stack, LivingEntity entity) {
        var instance = new StatusEffectInstance(ModEffects.UNSEEN_FORM, 20, 0, false, false, false);
        entity.addStatusEffect(instance);
    }

    @Override
    public void unequipRing(ItemStack stack, LivingEntity livingEntity) {
        livingEntity.removeStatusEffect(ModEffects.UNSEEN_FORM);
    }
}
