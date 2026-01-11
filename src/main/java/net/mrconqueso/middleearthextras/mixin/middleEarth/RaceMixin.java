package net.mrconqueso.middleearthextras.mixin.middleEarth;

import net.jukoz.me.MiddleEarth;
import net.jukoz.me.resources.datas.races.Race;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.mrconqueso.middleearthextras.MiddleEarthExtras;
import net.mrconqueso.middleearthextras.entity.ModEntities;
import net.mrconqueso.middleearthextras.entity.custom.BeorningHumanEntity;
import net.mrconqueso.middleearthextras.entity.custom.EntEntity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Race.class)
public class RaceMixin {
    @Shadow
    @Final
    private Identifier id;
    @Unique
    private String customRaceType;

    @Inject(method = "getModel", at = @At("HEAD"), cancellable = true, remap = false)
    public void getCustomModel(World world, CallbackInfoReturnable<LivingEntity> cir) {
        MobEntity entity = null;
        if (this.id.equals(Identifier.of(MiddleEarthExtras.MOD_ID, "beorning"))) {
            entity = new BeorningHumanEntity(ModEntities.BEORNING_HUMAN, world);
        } else if (this.id.equals(Identifier.of(MiddleEarthExtras.MOD_ID, "ent"))) {
            entity = new EntEntity(ModEntities.ENT, world);
        }

        if (entity != null) {
            entity.setAiDisabled(true);
            cir.setReturnValue(entity);
        }
    }
}