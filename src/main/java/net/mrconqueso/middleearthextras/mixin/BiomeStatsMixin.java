package net.mrconqueso.middleearthextras.mixin;

import net.jukoz.me.world.biomes.MEBiomeKeys;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.HungerManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.mrconqueso.middleearthextras.util.ModTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class BiomeStatsMixin extends LivingEntity {

    @Shadow
    public abstract HungerManager getHungerManager();

    protected BiomeStatsMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "tick", at = @At("TAIL"))
    private void applyBiomeEffects(CallbackInfo ci) {
        if (this.getWorld().isClient) return; // Server side only

        // Run this check once per second (20 ticks) to save performance
        if (this.age % 20 != 0) return;

        RegistryEntry<Biome> biome = this.getWorld().getBiome(this.getBlockPos());

        // --- LÓRIEN (Sanctuary) ---
        if (biome.matchesKey(MEBiomeKeys.LOTHLORIEN)) {
            // 1. Freeze Hunger: Simply add back whatever exhaustion was added
            // Or better: Explicitly set exhaustion to 0 if not sprinting
            this.getHungerManager().setExhaustion(0.0f);

            // 2. Fast Regen: Manually heal
            if (this.getHealth() < this.getMaxHealth()) {
                this.heal(1.0f); // Heals half a heart every second
            }
        }

        // --- MORDOR (Oppression) ---
        else if (biome.isIn(ModTags.Biomes.DARK_BIOMES)) {
            // 1. Drain Hunger
            this.getHungerManager().addExhaustion(0.5f); // Drains food bar slowly

            // 2. Stop Natural Regen
            // You can prevent healing by canceling the regen logic in HungerManager
            // or just applying a hidden "wither-like" logic if food is low.
        }
    }
}
