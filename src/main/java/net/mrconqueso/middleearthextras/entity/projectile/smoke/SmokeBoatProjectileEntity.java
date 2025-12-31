package net.mrconqueso.middleearthextras.entity.projectile.smoke;

import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.mrconqueso.middleearthextras.utils.ModCollisionUtils;

public class SmokeBoatProjectileEntity extends ProjectileEntity {
    public final AnimationState idleAnimationState = new AnimationState();
    private static final int IDLE_LENGTH = 120;
    private int idleAnimationCooldown = 0;

    public static final int MAX_LIFESPAN_TICKS = 40;

    private static final double INITIAL_SPEED = 0.5;
    private static final double ENTITY_BOX_EXPANSION = 1.0;
    private static final float ENTITY_COLLISION_MARGIN = 0.3F;

    private transient boolean isFadingOut = false;

    public SmokeBoatProjectileEntity(
            EntityType<? extends ProjectileEntity> type, World world) {
        super(type, world);
        this.setNoGravity(true);
    }

    public SmokeBoatProjectileEntity(
            EntityType<? extends ProjectileEntity> type, World world, LivingEntity owner) {
        this(type, world);
        this.setOwner(owner);
        this.setPosition(owner.getX(), owner.getEyeY() - 0.1, owner.getZ());

        Vec3d velocity = owner.getRotationVec(1.0F).normalize().multiply(INITIAL_SPEED);
        this.setVelocity(velocity);
    }

    @Override
    public void tick() {
        super.tick();
        this.checkCollision();
        this.checkLifespan();
        if (this.getWorld().isClient) {
            this.setupAnimationStates();
        }
    }

    protected void setupAnimationStates() {
        if (this.idleAnimationCooldown <= 0) {
            this.idleAnimationCooldown = IDLE_LENGTH;
            this.idleAnimationState.start(this.age);
        } else {
            --this.idleAnimationCooldown;
        }
    }

    @Override
    protected void onEntityHit(EntityHitResult hitResult) {
        super.onEntityHit(hitResult);
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        this.triggerFadeOut();
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        // Not needed yet
    }

    @Override
    protected void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
    }

    @Override
    protected void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
    }

    private void checkLifespan() {
        if (this.age >= MAX_LIFESPAN_TICKS) {
            this.discard();
        }
    }

    private void triggerFadeOut() {
        if (isFadingOut) return;

        isFadingOut = true;
        this.age = MAX_LIFESPAN_TICKS - 3;

        this.setVelocity(Vec3d.ZERO);
        this.setPosition(this.getX(), this.getY(), this.getZ());
    }

    private void checkCollision() {
        if (isFadingOut) return;

        // Simplified collision checks
        if (checkEntityCollision() || getBlockCollision()) {
            return;
        }

        this.move(MovementType.SELF, this.getVelocity());
    }

    private boolean checkEntityCollision() {
        Vec3d start = this.getPos();
        Vec3d end = this.getPos().add(this.getVelocity());

        // Get entity collision result
        EntityHitResult hit = ProjectileUtil.getEntityCollision(this.getWorld(),
                this,
                start,
                end,
                this.getBoundingBox().stretch(this.getVelocity()).expand(ENTITY_BOX_EXPANSION),
                this::canHit,
                ENTITY_COLLISION_MARGIN);

        if (hit != null) {
            this.setPosition(hit.getPos());
            this.onCollision(hit);
            return true;
        }

        return false;
    }

    private boolean getBlockCollision() {
        return ModCollisionUtils.checkBlockFanCollision(this.getWorld(),
                this.getBoundingBox(),
                this.getVelocity(),
                this,
                this::onCollision);
    }
}
