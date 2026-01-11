package net.mrconqueso.middleearthextras.mixin;

import net.jukoz.me.entity.beasts.trolls.petrified.PetrifiedTrollEntity;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameMode;
import net.minecraft.world.World;
import net.mrconqueso.middleearthextras.client.ClientStructureProtection;
import net.mrconqueso.middleearthextras.world.structure.protection.AStructureManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin {

    @Inject(method = "isBlockBreakingRestricted", at = @At("HEAD"), cancellable = true)
    private void isBlockBreakingRestricted(World world, BlockPos pos, GameMode gameMode, CallbackInfoReturnable<Boolean> cir) {
        if (gameMode.isCreative()) return;

        PlayerEntity self = (PlayerEntity) (Object) this;
        BlockState state = world.getBlockState(pos);

        // Server-side check
        if (world instanceof ServerWorld serverWorld && self instanceof ServerPlayerEntity serverPlayer) {
            if (AStructureManager.isBlockProtectedServer(pos, state, serverPlayer, serverWorld)) {
                cir.setReturnValue(true);
            }
        }

        // Client-side check using synced state
        if (world.isClient()) {
            if (ClientStructureProtection.isBlockProtected(pos, state)) {
                cir.setReturnValue(true);
            }
        }
    }

    /**
     * Intercepts attacks on Petrified Trolls to suppress the "Strong Attack" (swoosh) sound and Crit particles.
     * We cancel the standard attack logic entirely and manually trigger the damage logic.
     */
    @Inject(method = "attack", at = @At("HEAD"), cancellable = true)
    public void attack(Entity target, CallbackInfo ci) {
        if (target instanceof PetrifiedTrollEntity) {
            PlayerEntity player = (PlayerEntity) (Object) this;

            if (!player.getWorld().isClient) {
                target.damage(player.getDamageSources().playerAttack(player), 1.0f);
            }
            ci.cancel();
        }
    }
}