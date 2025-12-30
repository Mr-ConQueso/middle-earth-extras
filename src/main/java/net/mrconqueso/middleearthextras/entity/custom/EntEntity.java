package net.mrconqueso.middleearthextras.entity.custom;

import net.jukoz.me.resources.datas.Disposition;
import net.jukoz.me.resources.datas.RaceType;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Util;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class EntEntity extends AnimalEntity {
    private static final TrackedData<Integer> VARIANT = DataTracker.registerData(EntEntity.class, TrackedDataHandlerRegistry.INTEGER);

    private static final int IDLE_LENGTH = 80;
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationCooldown = 0;

    public EntEntity(EntityType<? extends EntEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder setAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.2)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 50.0d)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 0.4d)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 1.0d)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 38.0d)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 4.0d)
                .add(EntityAttributes.GENERIC_STEP_HEIGHT, 1.15d)
                .add(EntityAttributes.GENERIC_SAFE_FALL_DISTANCE, 9.0d)
                .add(EntityAttributes.GENERIC_JUMP_STRENGTH, 1);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(3, new MeleeAttackGoal(this, 2.5, false));
        this.goalSelector.add(7, new WanderAroundFarGoal(this, 1.0));
        this.goalSelector.add(8, new LookAtEntityGoal(this, PlayerEntity.class, 6.0f));
        this.goalSelector.add(9, new LookAroundGoal(this));
        this.targetSelector.add(1, new RevengeGoal(this));
    }

    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(VARIANT, 0);
    }

    @Override
    public void tick() {
        super.tick();
        setupAnimationStates();
    }

    protected void setupAnimationStates() {
        if (this.idleAnimationCooldown <= 0) {
            this.idleAnimationCooldown = IDLE_LENGTH;
            this.idleAnimationState.start(this.age);
        } else {
            --this.idleAnimationCooldown;
        }
    }

    protected Disposition getDisposition(){
        return Disposition.GOOD;
    }

    protected List<RaceType> getRaceType() {
        return List.of(RaceType.HUMAN, RaceType.ELF);
    }

    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason,
                                 @Nullable EntityData entityData) {
        EntVariant variant = Util.getRandom(EntVariant.values(), this.random);
        setVariant(variant);
        return super.initialize(world, difficulty, spawnReason, entityData);
    }

    @Override
    public @Nullable PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }

    public EntVariant getVariant() {
        return EntVariant.byId(this.getTypeVariant() & 255);
    }

    private int getTypeVariant() {
        return this.dataTracker.get(VARIANT);
    }

    private void setVariant(EntVariant variant) {
        this.dataTracker.set(VARIANT, variant.getId() & 255);
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return false;
    }
}
