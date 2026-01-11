package net.mrconqueso.middleearthextras.entity.custom;

import net.jukoz.me.entity.beasts.AbstractBeastEntity;
import net.jukoz.me.entity.deer.DeerEntity;
import net.jukoz.me.entity.dwarves.longbeards.LongbeardDwarfEntity;
import net.jukoz.me.entity.elves.galadhrim.GaladhrimElfEntity;
import net.jukoz.me.entity.goals.*;
import net.jukoz.me.entity.hobbits.shire.ShireHobbitEntity;
import net.jukoz.me.entity.humans.bandit.BanditHumanEntity;
import net.jukoz.me.entity.humans.gondor.GondorHumanEntity;
import net.jukoz.me.entity.humans.rohan.RohanHumanEntity;
import net.jukoz.me.entity.pheasant.PheasantEntity;
import net.jukoz.me.resources.datas.Disposition;
import net.jukoz.me.resources.datas.RaceType;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.mrconqueso.middleearthextras.entity.ModEntities;
import net.mrconqueso.middleearthextras.item.ModGeneralItems;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.DoubleSupplier;
import java.util.function.IntUnaryOperator;

public class FellBeastEntity extends AbstractBeastEntity {
    private static final float MIN_MOVEMENT_SPEED_BONUS = (float) FellBeastEntity.getChildMovementSpeedBonus(() -> 0.0);
    private static final float MAX_MOVEMENT_SPEED_BONUS = (float)FellBeastEntity.getChildMovementSpeedBonus(() -> 1.0);
    private static final float MIN_JUMP_STRENGTH_BONUS = (float)FellBeastEntity.getChildJumpStrengthBonus(() -> 0.0);
    private static final float MAX_JUMP_STRENGTH_BONUS = (float)FellBeastEntity.getChildJumpStrengthBonus(() -> 1.0);
    private static final float MIN_HEALTH_BONUS = FellBeastEntity.getChildHealthBonus(max -> 0);
    private static final float MAX_HEALTH_BONUS = FellBeastEntity.getChildHealthBonus(max -> max - 1);
    private static final int IDLE_LENGTH = 40;
    private static final EntityDimensions BABY_BASE_DIMENSIONS = ModEntities.FELL_BEAST.getDimensions().scaled(0.5f);
    private static final Ingredient TEMPTING_INGREDIENT = Ingredient.fromTag(ItemTags.GOAT_FOOD);

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationCooldown = 0;

    public FellBeastEntity(EntityType<? extends FellBeastEntity> entityType, World world) {
        super(entityType, world);
        this.idleAnimationTimeout = IDLE_LENGTH;
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
    protected void initAttributes(Random random) {
        this.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).setBaseValue(this.getChildHealthBonus(random::nextInt));
        this.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED).setBaseValue(this.getChildMovementSpeedBonus(random::nextDouble));
        this.getAttributeInstance(EntityAttributes.GENERIC_JUMP_STRENGTH).setBaseValue(this.getChildJumpStrengthBonus(random::nextDouble));
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(2, new BeastSitGoal(this));
        this.goalSelector.add(3, new MeleeAttackGoal(this, 2, false));
        this.goalSelector.add(5, new AnimalMateGoal(this, 1.5));
        this.goalSelector.add(6, new TemptGoal(this, 1.0, TEMPTING_INGREDIENT, false));
        this.goalSelector.add(7, new WanderAroundFarGoal(this, 1.0));
        this.goalSelector.add(8, new LookAtEntityGoal(this, PlayerEntity.class, 6.0f));
        this.goalSelector.add(9, new LookAroundGoal(this));
        this.targetSelector.add(3, new BeastRevengeGoal(this, new Class[0]).setGroupRevenge());
        this.targetSelector.add(4, new BeastTargetPlayerGoal(this, this.getDisposition()));
        this.targetSelector.add(5, new BeastActiveTargetGoal<>(this, GaladhrimElfEntity.class, true));
        this.targetSelector.add(6, new BeastActiveTargetGoal<>(this, LongbeardDwarfEntity.class, true));
        this.targetSelector.add(7, new BeastActiveTargetGoal<>(this, GondorHumanEntity.class, true));
        this.targetSelector.add(8, new BeastActiveTargetGoal<>(this, RohanHumanEntity.class, true));
        this.targetSelector.add(9, new BeastActiveTargetGoal<>(this, BanditHumanEntity.class, true));
        this.targetSelector.add(10, new BeastActiveTargetGoal<>(this, ShireHobbitEntity.class, true));
        this.targetSelector.add(11, new BeastActiveTargetGoal<>(this, SheepEntity.class, true));
        this.targetSelector.add(12, new BeastActiveTargetGoal<>(this, GoatEntity.class, true));
        this.targetSelector.add(13, new BeastActiveTargetGoal<>(this, DeerEntity.class, true));
        this.targetSelector.add(14, new BeastActiveTargetGoal<>(this, PheasantEntity.class, true));
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 18)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 1)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 20)
                .add(EntityAttributes.GENERIC_JUMP_STRENGTH, 0.55f);
    }

    protected static float getChildHealthBonus(IntUnaryOperator randomIntGetter) {
        return 20.0f + (float)randomIntGetter.applyAsInt(8) + (float)randomIntGetter.applyAsInt(9);
    }

    protected static double getChildJumpStrengthBonus(DoubleSupplier randomDoubleGetter) {
        return (double)0.8f + randomDoubleGetter.getAsDouble() * 0.2 + randomDoubleGetter.getAsDouble() * 0.2 + randomDoubleGetter.getAsDouble() * 0.2;
    }

    protected static double getChildMovementSpeedBonus(DoubleSupplier randomDoubleGetter) {
        return ((double)0.4f + randomDoubleGetter.getAsDouble() * 0.2 + randomDoubleGetter.getAsDouble() * 0.2 + randomDoubleGetter.getAsDouble() * 0.2) * 0.25;
    }

    @Override
    protected Disposition getDisposition() {
        return Disposition.EVIL;
    }

    @Override
    protected List<RaceType> getRaceType() {
        return List.of(RaceType.ORC);
    }

    @Override
    protected void setChildAttributes(PassiveEntity other, AbstractHorseEntity child) {
        this.setChildAttribute(other, child, EntityAttributes.GENERIC_MAX_HEALTH, MIN_HEALTH_BONUS, MAX_HEALTH_BONUS);
        this.setChildAttribute(other, child, EntityAttributes.GENERIC_JUMP_STRENGTH, MIN_JUMP_STRENGTH_BONUS, MAX_JUMP_STRENGTH_BONUS);
        this.setChildAttribute(other, child, EntityAttributes.GENERIC_MOVEMENT_SPEED, MIN_MOVEMENT_SPEED_BONUS, MAX_MOVEMENT_SPEED_BONUS);
    }

    @Override
    public EntityDimensions getBaseDimensions(EntityPose pose) {
        return this.isBaby() ? BABY_BASE_DIMENSIONS : super.getBaseDimensions(pose);
    }

    @Override
    protected void setupAnimationStates() {
        super.setupAnimationStates();
        if (this.idleAnimationCooldown <= 0) {
            this.idleAnimationCooldown = IDLE_LENGTH;
            this.idleAnimationState.start(this.age);
        } else {
            --this.idleAnimationCooldown;
        }
    }

    @Override
    public void tick() {
        super.tick();
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.isOf(Items.ROTTEN_FLESH);
    }

    @Override
    public @Nullable PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return ModEntities.FELL_BEAST.create(world);
    }

    @Override
    protected boolean isMountable() {
        return true;
    }

    @Override
    protected boolean isTamable() {
        return this.isMountable();
    }

    @Override
    public boolean canBreedWith(AnimalEntity other) {
        return other instanceof FellBeastEntity;
    }

    @Override
    public boolean isHorseArmor(ItemStack stack) {
//        return stack.isIn(TagKey.of(RegistryKeys.ITEM, Identifier.of(MiddleEarth.MOD_ID, "broadhoof_goat_armor")));
        return false;
    }

    @Override
    public boolean canUseSlot(EquipmentSlot slot) {
        return true;
    }

    /* ------------ SOUNDS ------------ */

    @Override
    protected @Nullable SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_PARROT_AMBIENT;
    }

    @Override
    protected @Nullable SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_ALLAY_HURT;
    }

    @Override
    protected @Nullable SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_PANDA_DEATH;
    }

    /* ------------ RIDING ------------ */

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        boolean bl;
        boolean bl2 = bl = !this.isBaby() && this.isTame() && player.shouldCancelInteraction();
        if (this.hasPassengers() || bl2) {
            return super.interactMob(player, hand);
        }
        ItemStack itemStack = player.getStackInHand(hand);
        if (!itemStack.isEmpty()) {
            if (this.isBreedingItem(itemStack)) {
                return this.interactHorse(player, itemStack);
            }
            if (!this.isTame()) {
                this.playAngrySound();
                return ActionResult.success(this.getWorld().isClient);
            }
        }
        return super.interactMob(player, hand);
    }

    @Override
    protected Vec3d getPassengerAttachmentPos(Entity passenger, EntityDimensions dimensions, float scaleFactor) {
        // Calculate saddle position based on model pivots (in pixels converted to blocks / 16.0):
        // Body pivot Y: -30.8338, Saddle pivot Y: -10.5755 -> Total Height from ground: 41.4093 pixels
        // Body pivot Z: 4.9048, Saddle pivot Z: -10.755 -> Total Z offset: -5.8502 pixels

        double yOffset = 0.25;
        double zOffset = -0.365;

        return super.getPassengerAttachmentPos(passenger, dimensions, scaleFactor)
                .add(new Vec3d(
                        0.0,
                        yOffset * (double)scaleFactor,
                        zOffset * (double)scaleFactor)
                        .rotateY(-this.getYaw() * ((float)Math.PI / 180)));
    }

    public static boolean isValidNaturalSpawn(EntityType<? extends AnimalEntity> type, WorldAccess world, SpawnReason spawnReason, BlockPos pos, Random random) {
//        return world.getBlockState(pos.down()).isIn(BlockTags.ANIMALS_SPAWNABLE_ON) && bl;
        return true;
    }
}
