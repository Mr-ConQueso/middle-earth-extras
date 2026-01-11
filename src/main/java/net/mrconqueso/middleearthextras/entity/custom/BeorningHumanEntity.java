package net.mrconqueso.middleearthextras.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.mrconqueso.middleearthextras.entity.ModEntities;
import net.mrconqueso.middleearthextras.item.ModEggItems;
import org.jetbrains.annotations.Nullable;

public class BeorningHumanEntity extends AbstractBeorningEntity {
    public BeorningHumanEntity(EntityType<? extends BeorningHumanEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 18)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 1)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 20)
                .add(EntityAttributes.GENERIC_JUMP_STRENGTH, 0.55f);
    }

    @Override
    public @Nullable ItemStack getPickBlockStack() {
        return new ItemStack(ModEggItems.BEORNING_SPAWN_EGG);
    }

    @Override
    public void tick() {
        super.tick();

        if (!this.getWorld().isClient) {

            if (this.rage >= 100) {
                this.setConverting(true);
            }

            if (this.isConverting()) {
                this.conversionTime++;
                this.getNavigation().stop();

                if (this.conversionTime >= TOTAL_CONVERSION_TIME) {
                    this.transform(ModEntities.BEORNING_BEAR);
                }
            }
        }
    }
}
