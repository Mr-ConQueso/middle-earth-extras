package net.mrconqueso.middleearthextras.entity.custom;

import net.jukoz.me.MiddleEarth;
import net.jukoz.me.entity.NpcEntity;
import net.jukoz.me.entity.orcs.wild.WildGoblinEntity;
import net.jukoz.me.item.ModEquipmentItems;
import net.jukoz.me.item.ModWeaponItems;
import net.jukoz.me.resources.MiddleEarthFactions;
import net.jukoz.me.resources.MiddleEarthRaces;
import net.jukoz.me.resources.datas.npcs.NpcData;
import net.jukoz.me.resources.datas.npcs.NpcUtil;
import net.jukoz.me.resources.datas.npcs.data.NpcGearData;
import net.jukoz.me.resources.datas.npcs.data.NpcGearItemData;
import net.jukoz.me.resources.datas.npcs.data.NpcGearSlotData;
import net.jukoz.me.resources.datas.npcs.data.NpcRank;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.mrconqueso.middleearthextras.MiddleEarthExtras;
import net.mrconqueso.middleearthextras.effect.ModEffects;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class RingWraithEntity extends NpcEntity implements IWraithEntity {
    public RingWraithEntity(EntityType<? extends RingWraithEntity> entityType, World world) {
        super(entityType, world);
        String name = this.getDefaultName().toString();
        if (name.contains("chieftain")) {
            this.setRank(NpcRank.LEADER);
        }
    }

    private static final float GENERIC_FOLLOW_DISTANCE = 32.0f;

    private static final NpcData HARADRIM_SOLDIER = new NpcData(Identifier.of(MiddleEarthExtras.MOD_ID, "nazgul"), MiddleEarthRaces.HUMAN, List.of(
            NpcGearData.create()
            .add(EquipmentSlot.HEAD, NpcGearSlotData.create()
                .add(NpcGearItemData.create(ModEquipmentItems.NAZGUL_HOOD))
            )
            .add(EquipmentSlot.CHEST, NpcGearSlotData.create()
                .add(NpcGearItemData.create(ModEquipmentItems.NAZGUL_ROBES))
            )
            .add(EquipmentSlot.LEGS, NpcGearSlotData.create()
                .add(NpcGearItemData.create(ModEquipmentItems.RINGWRAITH_LEGGINGS))
            )
            .add(EquipmentSlot.FEET, NpcGearSlotData.create(NpcGearItemData.create(ModEquipmentItems.RINGWRAITH_BOOTS)))
            .add(EquipmentSlot.MAINHAND, NpcGearSlotData.create()
                .add(NpcGearItemData.create(ModWeaponItems.MORGUL_KNIFE))
            )
            .add(EquipmentSlot.OFFHAND, NpcGearSlotData.create()
                .add(NpcGearItemData.create(Items.AIR).withWeight(3))
            )
    ));

    @Override
    protected Identifier getFactionId() {
        return MiddleEarthFactions.MORDOR.getId();
    }
    @Override
    protected Identifier getRaceId() { return MiddleEarthRaces.HUMAN.getId(); }
    @Nullable
    @Override
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData) {
        entityData = super.initialize(world, difficulty, spawnReason, entityData);
        Random random = world.getRandom();
        this.initEquipment(random, difficulty);
        return entityData;
    }

    public static DefaultAttributeContainer.Builder setKnightAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25f)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 22.0)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 1.5)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 128.0)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2.5);
    }

    @Override
    public boolean canTarget(LivingEntity target) {
        if (target instanceof PlayerEntity player) {
            if (player.isCreative() || player.isSpectator()) return false;
            return player.hasStatusEffect(ModEffects.UNSEEN_FORM);
        } else {
            double distance = this.squaredDistanceTo(target);
            return distance <= GENERIC_FOLLOW_DISTANCE;
        }
    }

    @Override
    protected void initEquipment(Random random, LocalDifficulty localDifficulty) {
//        this.equipStack(EquipmentSlot.HEAD, ModEquipmentItems.NAZGUL_HOOD.getDefaultStack());
//        this.equipStack(EquipmentSlot.CHEST, ModEquipmentItems.NAZGUL_ROBES.getDefaultStack());
//        this.equipStack(EquipmentSlot.LEGS, ModEquipmentItems.RINGWRAITH_LEGGINGS.getDefaultStack());
//        this.equipStack(EquipmentSlot.FEET, ModEquipmentItems.RINGWRAITH_BOOTS.getDefaultStack());
//        this.equipStack(EquipmentSlot.MAINHAND, ModWeaponItems.MORGUL_KNIFE.getDefaultStack());

        NpcGearData gearData = HARADRIM_SOLDIER.getGear();
        NpcUtil.equipAll(this, gearData);
    }

    @Override
    protected void initGoals() {
        super.initGoals();
        int index = 4;
        index = initNeutralTargetSelector(index);
        this.targetSelector.add(++index, new ActiveTargetGoal<>(this, WildGoblinEntity.class, true));
    }

    @Override
    protected void applyDamage(DamageSource source, float amount) {
        if(source.getAttacker() instanceof RingWraithEntity){
            return;
        }
        super.applyDamage(source, amount);
    }
}
