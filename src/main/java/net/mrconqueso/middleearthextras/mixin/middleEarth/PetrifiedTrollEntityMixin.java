package net.mrconqueso.middleearthextras.mixin.middleEarth;

import net.jukoz.me.entity.beasts.trolls.petrified.PetrifiedTrollEntity;
import net.jukoz.me.item.items.CustomSpawnEggItem;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PetrifiedTrollEntity.class)
public abstract class PetrifiedTrollEntityMixin extends MobEntity {

    @Unique
    private long lastHit;

    protected PetrifiedTrollEntityMixin(EntityType<? extends MobEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "damage", at = @At("HEAD"), cancellable = true)
    public void damage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        if (this.getWorld().isClient || this.isRemoved()) {
            cir.setReturnValue(false);
            return;
        }

        if (source.isIn(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            this.dismantle(source);
            cir.setReturnValue(false);
            return;
        }

        if (this.isInvulnerableTo(source) || this.isInvisible()) {
            cir.setReturnValue(false);
            return;
        }

        if (source.isIn(DamageTypeTags.IS_EXPLOSION)) {
            this.dismantle(source);
            cir.setReturnValue(false);
            return;
        }

        boolean isDirectArrow = source.getSource() instanceof PersistentProjectileEntity;
        boolean isPierceArrow = isDirectArrow && ((PersistentProjectileEntity) source.getSource()).getPierceLevel() > 0;

        Entity attacker = source.getAttacker();
        boolean isPlayer = attacker instanceof PlayerEntity;

        if (!isPlayer && !isDirectArrow) {
            cir.setReturnValue(false);
            return;
        }

        if (attacker instanceof PlayerEntity player) {
            if (!player.getAbilities().allowModifyWorld) {
                cir.setReturnValue(false);
                return;
            }

            if (player.isCreative()) {
                this.dismantle(null);
                cir.setReturnValue(isPierceArrow);
                return;
            }

            ItemStack mainHandStack = player.getMainHandStack();
            if (mainHandStack.getItem() instanceof PickaxeItem) {
                this.causeDamage(source, 10.0f);
                cir.setReturnValue(false);
                return;
            }
        }

        // 8. If not broken by the above (e.g. punched by hand or non-pierce arrow), do the "Wobble" effect
        long time = this.getWorld().getTime();
        if (time - this.lastHit > 5L && !isDirectArrow) {
            this.getWorld().sendEntityStatus(this, (byte) 32); // 32 = Armor Stand Wobble
            this.emitGameEvent(GameEvent.ENTITY_DAMAGE, source.getAttacker());
            this.lastHit = time;
        } else {
            // If it was an arrow or frequent hit that didn't break it
            // For arrows, we might want to break if they are projectiles, but usually statues are hard
            // Original code dismantled on arrows. Let's stick to only Pickaxe/Creative breaking for now based on your prompt.
            // If you want arrows to break it, uncomment:
            // this.dismantle(source);
        }
    }

    @Override
    public void handleStatus(byte status) {
        if (status == 2) {
            return;
        }
        else {
            super.handleStatus(status);
        }
    }

    @Unique
    private void showBreakingParticles() {
        if (this.getWorld() instanceof ServerWorld serverLevel) {
            serverLevel.spawnParticles(new BlockStateParticleEffect(ParticleTypes.BLOCK, Blocks.STONE.getDefaultState()),
                    this.getX(), this.getY() + 1, this.getZ(),
                    25, this.getWidth() / 4.0F, this.getHeight() / 4.0F, this.getWidth() / 4.0F, 0.05);
        }
    }

    @Unique
    private void causeDamage(DamageSource damageSource, float amount) {
        float f = this.getHealth();
        f -= amount;
        if (f <= 0.5F) {
            this.dismantle(damageSource);
        } else {
            this.setHealth(f);
            this.emitGameEvent(GameEvent.ENTITY_DAMAGE, damageSource.getAttacker());
        }
    }

    @Unique
    public void dismantle(@Nullable DamageSource source) {
        if (source != null) {
            this.dropStack(this.getPickBlockStack());
        }
        this.showBreakingParticles();
        this.playBrokenSound();
        this.remove(Entity.RemovalReason.KILLED);
        this.emitGameEvent(GameEvent.ENTITY_DIE);
    }

    @Unique
    private void playBrokenSound() {
        this.getWorld().playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.BLOCK_STONE_BREAK, this.getSoundCategory(), 1.0F, 1.0F);
    }

    @Override
    public void kill() {
        dismantle(this.getDamageSources().generic());
    }

    @Override
    public boolean isCollidable() {
        return true;
    }

    @Override
    public boolean handleAttack(Entity attacker) {
        return attacker instanceof PlayerEntity p && !this.getWorld().canPlayerModifyAt(p, this.getBlockPos());
    }

    @Override
    protected boolean shouldDropLoot() {
        return false;
    }

    @Override
    public void onDamaged(DamageSource damageSource) {
        super.onDamaged(damageSource);
    }
}