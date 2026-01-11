package net.mrconqueso.middleearthextras.entity.custom;

import net.jukoz.me.entity.NpcEntity;
import net.jukoz.me.entity.humans.dale.DaleHumanEntity;
import net.jukoz.me.resources.MiddleEarthFactions;
import net.jukoz.me.resources.MiddleEarthRaces;
import net.jukoz.me.resources.datas.npcs.data.NpcRank;
import net.minecraft.entity.*;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.mrconqueso.middleearthextras.resources.ModFactions;
import net.mrconqueso.middleearthextras.resources.ModRaces;
import org.jetbrains.annotations.Nullable;

public class AbstractBeorningEntity extends NpcEntity {

    protected static final int TOTAL_CONVERSION_TIME = 50;
    protected static final int RAGE_DECAY = 100;
    protected static final int RAGE_MODIFY = 30;

    protected static final TrackedData<Boolean> CONVERTING = DataTracker.registerData(AbstractBeorningEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    public static final String BEORNING_CONVERSION_TIME_KEY = "BeorningConversionTime";
    public static final String RAGE_KEY = "Rage";
    protected int rage = 0;
    protected int rageDecayCooldown = 0;

    protected int conversionTime = 0;

    protected static final TrackedData<Integer> DATA_ID_TYPE_VARIANT =
            DataTracker.registerData(AbstractBeorningEntity.class, TrackedDataHandlerRegistry.INTEGER);

    protected AbstractBeorningEntity(EntityType<? extends AbstractBeorningEntity> entityType, World world) {
        super(entityType, world);
        String name = this.getDefaultName().toString();
        if(name.contains("militia")){
            this.setRank(NpcRank.MILITIA);
        } else if (name.contains("soldier")) {
            this.setRank(NpcRank.SOLDIER);
        } else if (name.contains("knight")) {
            this.setRank(NpcRank.KNIGHT);
        } else if (name.contains("veteran")) {
            this.setRank(NpcRank.VETERAN);
        } else if (name.contains("leader")) {
            this.setRank(NpcRank.LEADER);
        }
    }

    @Override
    protected Identifier getFactionId() {
        return ModFactions.BEORNINGS.getId();
    }
    @Override
    protected Identifier getRaceId() { return ModRaces.BEORNING.getId(); }
    @Nullable
    @Override
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData) {
        entityData = super.initialize(world, difficulty, spawnReason, entityData);
        Random random = world.getRandom();
        this.initEquipment(random, difficulty);
        BeorningVariant variant = Util.getRandom(BeorningVariant.values(), this.random);
        setVariant(variant);
        return entityData;
    }

    /* ------------ RAGE ------------ */
    @Override
    public void tick() {
        super.tick();
        if (!this.getWorld().isClient) {
            if (this.rageDecayCooldown > 0) {
                this.rageDecayCooldown--;
            }

            if (this.age % RAGE_MODIFY == 0) {
                if (this.getTarget() != null && this.rage < 100) {
                    this.rage++;
                } else if (this.getTarget() == null && this.rage > 0 && this.rageDecayCooldown <= 0) {
                    this.rage--;
                }
            }

            this.setCustomName(Text.literal("Rage: " + this.rage));
            this.setCustomNameVisible(true);
        }
    }

    protected void setRage(int rage) {
        if (rage - this.rage >= 5) {
            this.rageDecayCooldown = RAGE_DECAY;
        }
        this.rage = rage;
    }

    @Override
    public boolean damage(DamageSource source, float amount) {
        boolean damaged = super.damage(source, amount);
        if (damaged && !this.getWorld().isClient && this.rage + 10 <= 100) {
            this.rage += 10;
            this.rageDecayCooldown = RAGE_DECAY;
        }
        return damaged;
    }

    @Override
    protected void initGoals() {
        super.initGoals();
        int index = 4;
        index = initGoodTargetSelector(index);
    }
    @Override
    protected void applyDamage(DamageSource source, float amount) {
        if(source.getAttacker() instanceof DaleHumanEntity){
            return;
        }
        super.applyDamage(source, amount);
    }

    /* ------------ TRANSFORMATION ------------ */
    public boolean isConverting() {
        return this.getDataTracker().get(CONVERTING);
    }

    public void setConverting(boolean converting) {
        this.dataTracker.set(CONVERTING, converting);
    }

    public boolean isShaking() {
        return this.isConverting();
    }

    protected void setConversionTime(int time) {
        this.conversionTime = time;
        this.setConverting(true);
    }

    protected <T extends MobEntity> void transform(EntityType<T> entityType) {
        if (this.getWorld().isClient) return;

        ServerWorld world = (ServerWorld) this.getWorld();

        this.convertTo(entityType, true);
        world.spawnParticles(ParticleTypes.LARGE_SMOKE, this.getX(), this.getY() + 1, this.getZ(), 20, 0.5, 0.5, 0.5, 0.05);
    }

    @Override
    public <T extends MobEntity> T convertTo(EntityType<T> entityType, boolean keepEquipment) {
        if (this.isRemoved()) {
            return null;
        } else {
            T mobEntity = entityType.create(this.getWorld());
            if (mobEntity == null) {
                return null;
            } else {
                mobEntity.copyPositionAndRotation(this);
                mobEntity.setBaby(this.isBaby());
                mobEntity.setAiDisabled(this.isAiDisabled());
                if (this.hasCustomName()) {
                    mobEntity.setCustomName(this.getCustomName());
                    mobEntity.setCustomNameVisible(this.isCustomNameVisible());
                }

                if (this.isPersistent()) {
                    mobEntity.setPersistent();
                }

                mobEntity.setInvulnerable(this.isInvulnerable());
                if (keepEquipment) {
                    mobEntity.setCanPickUpLoot(this.canPickUpLoot());

                    for (EquipmentSlot equipmentSlot : EquipmentSlot.values()) {
                        ItemStack itemStack = this.getEquippedStack(equipmentSlot);
                        if (!itemStack.isEmpty()) {
                            mobEntity.equipStack(equipmentSlot, itemStack.copyAndEmpty());
                            mobEntity.setEquipmentDropChance(equipmentSlot, this.getDropChance(equipmentSlot));
                        }
                    }
                }

                if (mobEntity instanceof AbstractBeorningEntity beorningEntity) {
                    beorningEntity.setVariant(this.getVariant());
                }

                this.getWorld().spawnEntity(mobEntity);
                if (this.hasVehicle()) {
                    Entity entity = this.getVehicle();
                    this.stopRiding();
                    mobEntity.startRiding(entity, true);
                }

                this.discard();
                return mobEntity;
            }
        }
    }

    /* ------------ VARIANT ------------ */
    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(DATA_ID_TYPE_VARIANT, 0);
        builder.add(CONVERTING, false);
    }

    public BeorningVariant getVariant(){
        return BeorningVariant.byId(this.getTypeVariant() & 255);
    }

    protected int getTypeVariant() {
        return this.dataTracker.get(DATA_ID_TYPE_VARIANT);
    }

    protected void setVariant(BeorningVariant variant) {
        this.dataTracker.set(DATA_ID_TYPE_VARIANT, variant.getId() & 255);
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putInt("Variant", this.getTypeVariant());
        nbt.putInt(BEORNING_CONVERSION_TIME_KEY, this.isConverting() ? this.conversionTime : -1);
        nbt.putInt(RAGE_KEY, this.rage);
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.dataTracker.set(DATA_ID_TYPE_VARIANT, nbt.getInt("Variant"));
        if (nbt.contains(BEORNING_CONVERSION_TIME_KEY, NbtElement.NUMBER_TYPE) && nbt.getInt(BEORNING_CONVERSION_TIME_KEY) > -1) {
            this.setConversionTime(nbt.getInt(BEORNING_CONVERSION_TIME_KEY));
        }
        if (nbt.contains(RAGE_KEY, NbtElement.NUMBER_TYPE)) {
            this.setRage(nbt.getInt(RAGE_KEY));
        }
    }
}
