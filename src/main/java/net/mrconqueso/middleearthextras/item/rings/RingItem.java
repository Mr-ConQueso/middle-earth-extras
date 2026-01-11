package net.mrconqueso.middleearthextras.item.rings;

import net.minecraft.block.DispenserBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import net.mrconqueso.middleearthextras.compat.Mods;

public class RingItem extends Item {

    public RingItem(Settings settings) {
        super(settings);
        DispenserBlock.registerBehavior(this, ArmorItem.DISPENSER_BEHAVIOR);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);

        if (entity instanceof PlayerEntity player){
            if (!Mods.TRINKETS.isLoaded() && !Mods.ACCESSORIES.isLoaded()) {
                if (player.getMainHandStack().isOf(this) || player.getOffHandStack().isOf(this)){
                    this.tickRing(stack, player);
                }
            }
        } else if (entity instanceof LivingEntity livingEntity) {
            if (livingEntity.getMainHandStack().isOf(this) || livingEntity.getOffHandStack().isOf(this)){
                this.tickRing(stack, livingEntity);
            }
        }
    }

    public void tickRing(ItemStack stack, LivingEntity livingEntity) {

        if (!(livingEntity instanceof PlayerEntity player)) return;
        player.sendMessage(Text.literal("Ring ticked!"), true);
    }

    public void unequipRing(ItemStack stack, LivingEntity livingEntity) {

    }
}
