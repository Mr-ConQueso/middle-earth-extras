package net.mrconqueso.middleearthextras.mixin.client.middleEarth;

import net.jukoz.me.entity.beasts.trolls.petrified.PetrifiedTrollEntity;
import net.jukoz.me.entity.beasts.trolls.petrified.PetrifiedTrollRenderer;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PetrifiedTrollRenderer.class)
public class PetrifiedTrollRendererMixin {

    @Unique
    private static final Identifier TEXTURE_HIGH = Identifier.of("me", "textures/entities/trolls/stone/petrified_stone_troll.png");
    @Unique
    private static final Identifier TEXTURE_MEDIUM = Identifier.of("me", "textures/entities/trolls/stone/petrified_stone_troll_cracked.png");
    @Unique
    private static final Identifier TEXTURE_LOW = Identifier.of("me", "textures/entities/trolls/stone/petrified_stone_troll_broken.png");

    @Inject(method = "getTexture(Lnet/jukoz/me/entity/beasts/trolls/petrified/PetrifiedTrollEntity;)Lnet/minecraft/util/Identifier;", at = @At("HEAD"), cancellable = true)
    private void injectGetTexture(PetrifiedTrollEntity entity, CallbackInfoReturnable<Identifier> cir) {
        float health = entity.getHealth();
        float maxHealth = entity.getMaxHealth();
        float ratio = health / maxHealth;

        if (ratio < 0.5f) {
            cir.setReturnValue(TEXTURE_LOW);
        } else if (ratio < 0.8f) {
            cir.setReturnValue(TEXTURE_MEDIUM);
        } else {
            cir.setReturnValue(TEXTURE_HIGH);
        }
    }
}