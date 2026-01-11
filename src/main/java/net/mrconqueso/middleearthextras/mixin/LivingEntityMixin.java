package net.mrconqueso.middleearthextras.mixin;

import net.jukoz.me.entity.barrow_wights.BarrowWightEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.mrconqueso.middleearthextras.effect.ModEffects;
import net.mrconqueso.middleearthextras.entity.custom.IWraithEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {

    @Inject(method = "canTarget(Lnet/minecraft/entity/LivingEntity;)Z", at = @At("HEAD"), cancellable = true)
    private void modifyWraithTargeting(LivingEntity target, CallbackInfoReturnable<Boolean> cir) {
        if (target instanceof PlayerEntity player && player.hasStatusEffect(ModEffects.UNSEEN_FORM)) {
            LivingEntity self = (LivingEntity)(Object)this;
            if (player.isCreative() || player.isSpectator()) return;

            // 1. If I am a Wraith/Nazgûl -> ALWAYS TARGET
            if (self instanceof IWraithEntity) {
                cir.setReturnValue(true);
                return;
            }

            // 2. If I am a normal mob -> NEVER TARGET
            // (Unless I have 'True Sight' like a Dragon or Balrog)
            if (!(self instanceof EnderDragonEntity)) {
                cir.setReturnValue(false);
            }
        }
    }
}
