package net.mrconqueso.middleearthextras.entity.custom;

import net.jukoz.me.entity.NpcEntity;
import net.jukoz.me.entity.humans.bandit.BanditHumanEntity;
import net.jukoz.me.entity.orcs.wild.WildGoblinEntity;
import net.jukoz.me.resources.MiddleEarthRaces;
import net.jukoz.me.resources.datas.npcs.data.NpcRank;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.RangedAttackMob;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.Items;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.mrconqueso.middleearthextras.resources.ModFactions;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HaradrimEntity extends NpcEntity implements RangedAttackMob {
    public HaradrimEntity(EntityType<? extends HaradrimEntity> entityType, World world) {
        super(entityType, world);
        String name = this.getDefaultName().toString();
        if(name.contains("militia")){
            this.setRank(NpcRank.MILITIA);
            this.setBow(Items.BOW);
        } else if (name.contains("soldier")) {
            this.setRank(NpcRank.SOLDIER);
            this.setBow(Items.BOW);
        }else if (name.contains("chieftain")) {
            this.setRank(NpcRank.KNIGHT);
        }
    }

    @Override
    protected Identifier getFactionId() {
        return ModFactions.HARADRIM.getId();
    }

    @Override
    protected Identifier getRaceId() { return MiddleEarthRaces.HUMAN.getId(); }

    @Override
    public NpcRank getRank() {
        return NpcRank.LEADER;
    }

    @Nullable
    @Override
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData) {
        entityData = super.initialize(world, difficulty, spawnReason, entityData);
        Random random = world.getRandom();
        this.initEquipment(random, difficulty);
        return entityData;
    }

    public static DefaultAttributeContainer.Builder setSoldierAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25f)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 20.0)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 1.5)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 32.0)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2.0);
    }
    public static DefaultAttributeContainer.Builder setKnightAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25f)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 22.0)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 1.5)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 32.0)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2.5);
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
        if(source.getAttacker() instanceof BanditHumanEntity){
            return;
        }
        super.applyDamage(source, amount);
    }

    public HaradrimVariant getVariant() {
        return HaradrimVariant.byId(this.getId());
    }

    public Entity getPlatform() {
        if (this.getVehicle() != null) return null;

        List<Entity> nearby = this.getWorld().getOtherEntities(this, this.getBoundingBox().expand(0.5, 2.0, 0.5));
        for (Entity e : nearby) {
            if (e instanceof OliphantHowdah ) return e;
        }
        return null;
    }

    public static boolean isValidNaturalSpawn(EntityType<? extends NpcEntity> type, WorldAccess world, SpawnReason spawnReason, BlockPos pos, Random random) {
        boolean bl = SpawnReason.isTrialSpawner(spawnReason);
        return world.getBlockState(pos.down()).isIn(BlockTags.ANIMALS_SPAWNABLE_ON) && bl;
    }
}
