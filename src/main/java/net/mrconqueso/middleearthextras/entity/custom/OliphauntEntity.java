package net.mrconqueso.middleearthextras.entity.custom;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.jukoz.me.entity.beasts.AbstractBeastEntity;
import net.jukoz.me.entity.goals.BeastRevengeGoal;
import net.jukoz.me.entity.goals.BeastSitGoal;
import net.jukoz.me.entity.goals.ChargeAttackGoal;
import net.jukoz.me.resources.datas.Disposition;
import net.jukoz.me.resources.datas.RaceType;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AbstractHorseEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.InventoryChangedListener;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.Util;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.mrconqueso.middleearthextras.MiddleEarthExtras;
import net.mrconqueso.middleearthextras.client.ScreenshakeManager;
import net.mrconqueso.middleearthextras.entity.ModEntities;
import net.mrconqueso.middleearthextras.entity.client.oliphaunt.OliphauntRenderer;
import net.mrconqueso.middleearthextras.item.items.OliphauntArmorItem;
import net.mrconqueso.middleearthextras.network.ScreenshakePayload;
import net.mrconqueso.middleearthextras.screen.custom.OliphauntScreenHandler;
import nordmods.primitive_multipart_entities.common.entity.EntityPart;
import nordmods.primitive_multipart_entities.common.entity.MultipartEntity;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.DoubleSupplier;
import java.util.function.IntUnaryOperator;

public class OliphauntEntity extends AbstractBeastEntity implements InventoryChangedListener, RideableInventory, MultipartEntity {
    private static final int IDLE_LENGTH = 40;
    private static final float MIN_MOVEMENT_SPEED_BONUS = (float) OliphauntEntity.getChildMovementSpeedBonus(() -> 0.0);
    private static final float MAX_MOVEMENT_SPEED_BONUS = (float)OliphauntEntity.getChildMovementSpeedBonus(() -> 1.0);
    private static final float MIN_JUMP_STRENGTH_BONUS = (float)OliphauntEntity.getChildJumpStrengthBonus(() -> 0.0);
    private static final float MAX_JUMP_STRENGTH_BONUS = (float)OliphauntEntity.getChildJumpStrengthBonus(() -> 1.0);
    private static final float MIN_HEALTH_BONUS = OliphauntEntity.getChildHealthBonus(max -> 0);
    private static final float MAX_HEALTH_BONUS = OliphauntEntity.getChildHealthBonus(max -> max - 1);
    private static final Ingredient TEMPTING_INGREDIENT = Ingredient.fromTag(ItemTags.GOAT_FOOD);
    private static final EntityDimensions BABY_BASE_DIMENSIONS = ModEntities.OLIPHAUNT.getDimensions().scaled(0.3f);

    private final OliphantHowdah platform_1 = new OliphantHowdah(this, 8f, 1f);
    private final OliphantHowdah platform_2 = new OliphantHowdah(this, 6f, 0.75f);
    private final OliphantHowdah platform_3 = new OliphantHowdah(this, 5f, 0.5f);
    private final OliphantHowdah[] parts = new OliphantHowdah[]{platform_1, platform_2, platform_3};

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationCooldown = 0;

    public static final TrackedData<Boolean> HAS_TIER_1_CHEST =
            DataTracker.registerData(OliphauntEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    public static final TrackedData<Boolean> HAS_TIER_2_CHEST =
            DataTracker.registerData(OliphauntEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    public static final TrackedData<Boolean> HAS_TIER_3_CHEST =
            DataTracker.registerData(OliphauntEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    private final Map<Integer, String> events = new HashMap<>();
    {
        events.put(4, "stomp");
    }
    private float currentFrame;
    private float previousFrame;

    protected SimpleInventory inventory;

    private final int TIER_1_CHEST_SLOT = 2;
    private final int TIER_2_CHEST_SLOT = 3;
    private final int TIER_3_CHEST_SLOT = 4;

    private static final TrackedData<Integer> DATA_ID_TYPE_VARIANT =
            DataTracker.registerData(OliphauntEntity.class, TrackedDataHandlerRegistry.INTEGER);

    public OliphauntEntity(EntityType<? extends OliphauntEntity> entityType, World world) {
        super(entityType, world);
        this.createInventory();
        this.ignoreCameraFrustum = true;
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
        this.goalSelector.add(3, new MeleeAttackGoal(this, 2.5, false));
        this.goalSelector.add(4, new ChargeAttackGoal(this, null, maxChargeCooldown()));
        this.goalSelector.add(5, new AnimalMateGoal(this, 1.5));
        this.goalSelector.add(6, new TemptGoal(this, 1.0, TEMPTING_INGREDIENT, false));
        this.goalSelector.add(7, new WanderAroundFarGoal(this, 1.0));
        this.goalSelector.add(8, new LookAtEntityGoal(this, PlayerEntity.class, 6.0f));
        this.goalSelector.add(9, new LookAroundGoal(this));
        this.targetSelector.add(1, new BeastRevengeGoal(this, new Class[0]).setGroupRevenge());
    }

    @Override
    protected void setupAnimationStates() {
        if (this.idleAnimationCooldown <= 0) {
            this.idleAnimationCooldown = IDLE_LENGTH;
            this.idleAnimationState.start(this.age);
        } else {
            --this.idleAnimationCooldown;
        }
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
        return List.of(RaceType.HUMAN);
    }

    @Override
    public void tick() {
        super.tick();

        this.previousFrame = this.currentFrame;
        this.currentFrame += this.speed;

        // Check for events skipped over during this tick (e.g., if we went from frame 14.5 to 15.5)
        for (Map.Entry<Integer, String> entry : events.entrySet()) {
            int triggerFrame = entry.getKey();
            if (previousFrame < triggerFrame && currentFrame >= triggerFrame) {
                handleEvent(entry.getValue());
            }
        }
    }

    @Override
    public void tickMovement() {
        super.tickMovement();

        if (this.isAlive()) {
            // float startYaw = this.bodyYaw;
            // float localYawDelta = this.bodyYaw - startYaw;
            // this.moveSiegeTowerPassengersWithRotation(localYawDelta);
            this.moveSiegeTowerPassengers(this.platform_1);
            this.moveSiegeTowerPassengers(this.platform_2);
            this.moveSiegeTowerPassengers(this.platform_3);
        }

        this.movePart(this.platform_1, 0, 14.5, 1);
        this.movePart(this.platform_2, 0, 18.5, 0.5);
        this.movePart(this.platform_3, 0, 22.5, 0.75);
    }

    protected void moveSiegeTowerPassengersWithRotation(OliphantHowdah part, float yawDelta) {
        if (part == null) return;

        // 2. Calculate Translation Delta (Movement Change)
        double dx = this.getX() - this.prevX;
        double dy = this.getY() - this.prevY;
        double dz = this.getZ() - this.prevZ;

        // Optimization: If no movement or rotation happened, skip logic
        if (dx == 0 && dy == 0 && dz == 0 && yawDelta == 0) return;

        // 3. Define the scan area (slightly above the tower platform)
        Box platformBox = part.getBoundingBox().expand(0.0, 0.5, 0.0);
        List<Entity> passengers = this.getWorld().getOtherEntities(this, platformBox);

        for (Entity passenger : passengers) {
            if (this.hasPassenger(passenger)) continue; // Skip the actual driver

            // --- THE ROTATION MATH ---

            // A. Get passenger position relative to the Mûmakil's PREVIOUS position
            // This vector represents "Where was the player standing relative to the center?"
            Vec3d relativePos = new Vec3d(
                    passenger.getX() - this.prevX,
                    passenger.getY() - this.prevY,
                    passenger.getZ() - this.prevZ
            );

            // B. Rotate that vector by the Yaw Delta
            // Note: Minecraft uses radians for rotation methods.
            // We negate the angle because Minecraft yaw is inverted compared to standard trig.
            Vec3d rotatedRelPos = relativePos.rotateY((float) Math.toRadians(-yawDelta));

            // C. Calculate the final absolute position
            // New Pos = Current Mûmakil Center + Rotated Relative Vector
            double newX = this.getX() + rotatedRelPos.x;
            double newY = this.getY() + rotatedRelPos.y; // Usually Y doesn't rotate, but this keeps relative height
            double newZ = this.getZ() + rotatedRelPos.z;

            // 4. Update the passenger
            // We set their position directly.
            passenger.setPosition(newX, newY, newZ);
            // passenger.move(MovementType.SELF, new Vec3d(dx, dy, dz));
        }
    }

    protected void moveSiegeTowerPassengers(OliphantHowdah part) {
        // 1. Get the Siege Tower Part (Assuming you have a reference to it)
        if (part == null) return;

        // 2. Calculate the Mûmakil's movement since the last tick
        // We use the difference between current pos and previous pos
        double dx = this.getX() - this.prevX;
        double dy = this.getY() - this.prevY;
        double dz = this.getZ() - this.prevZ;

        // If we haven't moved, no need to update passengers
        if (dx == 0 && dy == 0 && dz == 0) return;

        // 3. Define the Check Box
        // We check slightly above the siege tower hitbox (e.g., 0.5 blocks up)
        // to catch entities standing on it.
        Box platformBox = part.getBoundingBox().expand(0.0, 0.5, 0.0);

        // 4. Get all entities standing on the platform
        // exclude 'this' (the mumakil) to avoid self-collision issues
        List<Entity> passengers = this.getWorld().getOtherEntities(this, platformBox);

        for (Entity passenger : passengers) {
            // IMPORTANT: Skip the driver if they are technically "riding" via mount
            if (this.hasPassenger(passenger)) continue;

            // Skip entities that are shifting (sneaking) if you want a mechanic to "dismount"
            // by crouching, otherwise keep them stuck.

            // 5. Apply the movement
            // We add the Mûmakil's delta to the passenger's position.
            // This keeps them relative to the platform.
//            passenger.setPosition(passenger.getX() + dx, passenger.getY() + dy, passenger.getZ() + dz);
            passenger.move(MovementType.SELF, new Vec3d(dx, dy, dz));

            // Optional: Update client-side position interpolation if needed for smoothness
            // mainly relevant if the entity is a player.
            if (passenger instanceof ServerPlayerEntity) {
                // Sometimes necessary to force a packet update if the movement is jittery
                // ((ServerPlayerEntity) passenger).networkHandler.requestTeleport(...);
                // But try simple setPosition first.
            }
        }
    }

    @Override
    public void updatePassengerPosition(Entity passenger, PositionUpdater positionUpdater) {
//        if (this.getWorld().isClient) {
//            var client = net.minecraft.client.MinecraftClient.getInstance();
//            var renderer = client.getEntityRenderDispatcher().getRenderer(this);
//
//            if (renderer instanceof OliphauntRenderer oliphauntRenderer) {
//                var model = oliphauntRenderer.getModel();
//                Vec3d seatPos = model.getSeatPosition(this, 1.0f);
//                positionUpdater.accept(passenger, seatPos.x, seatPos.y, seatPos.z);
//                return;
//            }
//        }
//        super.updatePassengerPosition(passenger, positionUpdater);
        // Or if you know the Mûmakil is tall:
        positionUpdater.accept(passenger, this.getX(), this.getY() + 12.0, this.getZ());
    }

    private void movePart(OliphantHowdah part, double dx, double dy, double dz) {
        Vec3d offset = new Vec3d(dx, dy, dz).rotateY(-this.bodyYaw * ((float)Math.PI / 180F));
        part.setRelativePos(offset.x, offset.y, offset.z);
        part.tick();
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

    private void handleEvent(String eventId) {
        if (eventId.equals("stomp")) {
            // 1. Play Sound
            this.playSound(SoundEvents.ENTITY_RAVAGER_STEP, 1.0f, 1.0f);
            // Server-side: Send shake packets to all nearby players
            float maxRadius = 32.0f;
            float maxIntensity = 1.0f;
            int duration = 40;

            // Get all players within the radius
            List<ServerPlayerEntity> nearbyPlayers = this.getWorld().getEntitiesByClass(
                    ServerPlayerEntity.class,
                    this.getBoundingBox().expand(maxRadius),
                    player -> this.distanceTo(player) <= maxRadius
            );

            for (ServerPlayerEntity player : nearbyPlayers) {
                float distance = this.distanceTo(player);
                // Linear falloff: 1.0 at 0 distance, 0.0 at maxRadius
                float intensity = MathHelper.lerp(distance / maxRadius, maxIntensity, 0.0f);

                if (intensity > 0) {
                    ServerPlayNetworking.send(player, new ScreenshakePayload(intensity, duration));
                }
            }
        }
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
        return other instanceof OliphauntEntity;
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.isIn(ItemTags.GOAT_FOOD);
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

    @Override
    public @Nullable PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        OliphauntEntity baby = ModEntities.OLIPHAUNT.create(world);

        OliphauntVariant variant = Util.getRandom(OliphauntVariant.values(), this.random);
        assert baby != null;
        baby.setVariant(variant);

        return baby;
    }

    /* ------------ VARIANT ------------ */
    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(DATA_ID_TYPE_VARIANT, 0);

        builder.add(HAS_TIER_1_CHEST, false);
        builder.add(HAS_TIER_2_CHEST, false);
        builder.add(HAS_TIER_3_CHEST, false);
    }

    public OliphauntVariant getVariant(){
        return OliphauntVariant.byId(this.getTypeVariant() & 255);
    }

    private int getTypeVariant() {
        return this.dataTracker.get(DATA_ID_TYPE_VARIANT);
    }

    private void setVariant(OliphauntVariant variant) {
        this.dataTracker.set(DATA_ID_TYPE_VARIANT, variant.getId() & 255);
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putInt("Variant", this.getTypeVariant());

        NbtList listtag =  new NbtList();
        for (int x = 0; x < this.inventory.size(); x++) {
            ItemStack itemStack = this.inventory.getStack(x);
            if (!itemStack.isEmpty()) {
                NbtCompound compound = new NbtCompound();
                compound.putByte("Slot", (byte) x);
                listtag.add(itemStack.encode(this.getRegistryManager(), compound));
            }
        }
        nbt.put("Items", listtag);
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.dataTracker.set(DATA_ID_TYPE_VARIANT, nbt.getInt("Variant"));

        this.createInventory();
        NbtList listtag = nbt.getList("Items", 10);
        for (int x = 0; x < listtag.size(); x++) {
            NbtCompound compound = listtag.getCompound(x);
            int j = compound.getByte("Slot") & 255;
            if (j < this.inventory.size()) {
                this.inventory.setStack(j, ItemStack.fromNbt(this.getRegistryManager(), compound).orElse(ItemStack.EMPTY));
            }
        }
    }

    @Override
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData) {

        OliphauntVariant variant = Util.getRandom(OliphauntVariant.values(), this.random);
        setVariant(variant);


        HaradrimEntity haradrimEntity = ModEntities.HARADRIM.create(this.getWorld());
        if (haradrimEntity != null) {
            haradrimEntity.refreshPositionAndAngles(this.getX(), this.getY(), this.getZ(), this.getYaw(), 0.0F);
            haradrimEntity.initialize(world, difficulty, spawnReason, null);
            haradrimEntity.startRiding(this);
        }

        return super.initialize(world, difficulty, spawnReason, entityData);
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
        ItemStack itemStack = player.getStackInHand(hand);
        Item item = itemStack.getItem();

        boolean bl;
        boolean bl2 = bl = !this.isBaby() && this.isTame() && player.shouldCancelInteraction();
        if (this.hasPassengers() || bl2) {
            return super.interactMob(player, hand);
        }
        if (!itemStack.isEmpty()) {
            if (this.isBreedingItem(itemStack)) {
                return this.interactHorse(player, itemStack);
            }
            if (!this.isTame()) {
                this.playAngrySound();
                return ActionResult.success(this.getWorld().isClient);
            }
        }

        if (isTame() && hand == Hand.MAIN_HAND && !isBreedingItem(itemStack) && !player.shouldCancelInteraction()) {

        } else if (this.isTame()) {
            this.openInventory(player);
            return ActionResult.success(this.getWorld().isClient);
        }

        return super.interactMob(player, hand);
    }

    @Override
    protected Vec3d getPassengerAttachmentPos(Entity passenger, EntityDimensions dimensions, float scaleFactor) {
        return new Vec3d(
                0.0,
                16.3 * (double)scaleFactor,
                7.8 * (double)scaleFactor)
                .rotateY(-this.getYaw() * ((float)Math.PI / 180));
    }

    @Override
    public EntityPart[] getParts() {
        return parts;
    }

    /* ------------ INVENTORY ------------ */
    @Override
    public void onInventoryChanged(Inventory sender) {
        if (sender.getStack(TIER_1_CHEST_SLOT).isOf(Items.CHEST) && !hasTier1Chest()) {
            setChest(TIER_1_CHEST_SLOT, true);
        }
        if (sender.getStack(TIER_2_CHEST_SLOT).isOf(Items.CHEST) && !hasTier2Chest()) {
            setChest(TIER_2_CHEST_SLOT, true);
        }
        if (sender.getStack(TIER_3_CHEST_SLOT).isOf(Items.CHEST) && !hasTier3Chest()) {
            setChest(TIER_3_CHEST_SLOT, true);
        }

        if (!sender.getStack(TIER_1_CHEST_SLOT).isOf(Items.CHEST) && hasTier1Chest()) {
            setChest(TIER_1_CHEST_SLOT, false);
            dropChestInventory(TIER_1_CHEST_SLOT);
        }
        if (!sender.getStack(TIER_2_CHEST_SLOT).isOf(Items.CHEST) && hasTier2Chest()) {
            setChest(TIER_2_CHEST_SLOT, false);
            dropChestInventory(TIER_2_CHEST_SLOT);
        }
        if (!sender.getStack(TIER_3_CHEST_SLOT).isOf(Items.CHEST) && hasTier3Chest()) {
            setChest(TIER_3_CHEST_SLOT, false);
            dropChestInventory(TIER_3_CHEST_SLOT);
        }

        if (sender.getStack(0).getItem() instanceof OliphauntArmorItem) {
            equipBodyArmor(sender.getStack(0));
        }
        if (sender.getStack(0).isEmpty() && isWearingBodyArmor()) {
            equipBodyArmor(ItemStack.EMPTY);
        }
    }

    private void setChest(int slot, boolean chested) {
        if (slot == TIER_1_CHEST_SLOT) {
            this.dataTracker.set(HAS_TIER_1_CHEST, chested);
        } else if (slot == TIER_2_CHEST_SLOT) {
            this.dataTracker.set(HAS_TIER_2_CHEST, chested);
        } else if (slot == TIER_3_CHEST_SLOT) {
            this.dataTracker.set(HAS_TIER_3_CHEST, chested);
        } else {
            MiddleEarthExtras.LOGGER.error("Can't give chest to a slot that doesn't exist");
        }
    }

    private void dropChestInventory(int slot) {
        if (slot == TIER_1_CHEST_SLOT) {
            ItemScatterer.spawn(this.getWorld(), this.getX(), this.getY() + 1, this.getZ(), inventory.removeStack(5, 64));
            ItemScatterer.spawn(this.getWorld(), this.getX(), this.getY() + 1, this.getZ(), inventory.removeStack(6, 64));
            ItemScatterer.spawn(this.getWorld(), this.getX(), this.getY() + 1, this.getZ(), inventory.removeStack(7, 64));
            ItemScatterer.spawn(this.getWorld(), this.getX(), this.getY() + 1, this.getZ(), inventory.removeStack(8, 64));
        }

        if (slot == TIER_2_CHEST_SLOT) {
            ItemScatterer.spawn(this.getWorld(), this.getX(), this.getY() + 1, this.getZ(), inventory.removeStack(9, 64));
            ItemScatterer.spawn(this.getWorld(), this.getX(), this.getY() + 1, this.getZ(), inventory.removeStack(10, 64));
            ItemScatterer.spawn(this.getWorld(), this.getX(), this.getY() + 1, this.getZ(), inventory.removeStack(11, 64));
            ItemScatterer.spawn(this.getWorld(), this.getX(), this.getY() + 1, this.getZ(), inventory.removeStack(12, 64));
        }

        if (slot == TIER_3_CHEST_SLOT) {
            ItemScatterer.spawn(this.getWorld(), this.getX(), this.getY() + 1, this.getZ(), inventory.removeStack(13, 64));
            ItemScatterer.spawn(this.getWorld(), this.getX(), this.getY() + 1, this.getZ(), inventory.removeStack(14, 64));
            ItemScatterer.spawn(this.getWorld(), this.getX(), this.getY() + 1, this.getZ(), inventory.removeStack(15, 64));
            ItemScatterer.spawn(this.getWorld(), this.getX(), this.getY() + 1, this.getZ(), inventory.removeStack(16, 64));
        }
    }

    public boolean hasTier1Chest() {
        return this.dataTracker.get(HAS_TIER_1_CHEST);
    }

    public boolean hasTier2Chest() {
        return this.dataTracker.get(HAS_TIER_2_CHEST);
    }

    public boolean hasTier3Chest() {
        return this.dataTracker.get(HAS_TIER_3_CHEST);
    }

    private void createInventory() {
        SimpleInventory simpleInventory = this.inventory;
        this.inventory = new SimpleInventory(this.getEntityInventorySize());
        if (simpleInventory != null) {
            simpleInventory.removeListener(this);
            int i = Math.min(simpleInventory.size(), this.inventory.size());
            for (int j = 0; j < i; ++j ) {
                ItemStack itemStack = simpleInventory.getStack(j);
                if (itemStack.isEmpty()) continue;
                this.inventory.setStack(j, itemStack.copy());
            }
        }
        this.inventory.addListener(this);
    }

    public final int getEntityInventorySize() {
        return getEntityInventorySize(4);
    }

    public static int getEntityInventorySize(int columns) {
        return columns * 3 + 5;
    }

    public boolean areInventoriesDifferent(Inventory inventory) {
        return this.inventory != inventory;
    }

    public boolean hasArmorOn() {
        return isWearingBodyArmor();
    }

    @Override
    protected void applyDamage(DamageSource source, float amount) {
        if (!this.canArmorAbsorb(source)) {
            super.applyDamage(source, amount);
        } else {
            ItemStack itemStack = this.getBodyArmor();
            itemStack.damage(MathHelper.ceil(amount), this, EquipmentSlot.BODY);

            if (itemStack.getItem() instanceof OliphauntArmorItem armorItem) {
                int damageReduction = armorItem.getProtection() / 2;
                super.applyDamage(source, Math.max(0, amount - damageReduction));
            }
        }
    }

    public boolean canArmorAbsorb(DamageSource damageSource) {
        return this.hasArmorOn() && !damageSource.isIn(DamageTypeTags.BYPASSES_ARMOR);
    }

    @Override
    public void openInventory(PlayerEntity player) {
        if(!this.getWorld().isClient() && isTame()) {
            ServerPlayerEntity serverPlayer = (ServerPlayerEntity) player;
            if (serverPlayer.currentScreenHandler != serverPlayer.playerScreenHandler) {
                serverPlayer.closeHandledScreen();
            }

            serverPlayer.openHandledScreen(new ExtendedScreenHandlerFactory<UUID>() {
                @Nullable
                @Override
                public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
                    return new OliphauntScreenHandler(syncId, playerInventory, OliphauntEntity.this.inventory, OliphauntEntity.this, 4);
                }

                @Override
                public Text getDisplayName() {
                    return Text.literal("Warturtle");
                }

                @Override
                public UUID getScreenOpeningData(ServerPlayerEntity player) {
                    return OliphauntEntity.this.getUuid();
                }
            });
        }
    }
}
