package net.mrconqueso.middleearthextras.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.mrconqueso.middleearthextras.MiddleEarthExtras;

public class ModEffects {

    public static final RegistryEntry<StatusEffect> UNSEEN_FORM = registerStatusEffect("unseen_form",
            new UnseenFormEffect(StatusEffectCategory.NEUTRAL, 0x00000));

    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect effect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(MiddleEarthExtras.MOD_ID, name), effect);
    }

    public static void registerEffects() {
        MiddleEarthExtras.LOGGER.info("Registering mod effects for: " + MiddleEarthExtras.MOD_ID);
    }
}
