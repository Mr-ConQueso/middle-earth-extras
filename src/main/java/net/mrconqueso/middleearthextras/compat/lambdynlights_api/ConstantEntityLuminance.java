package net.mrconqueso.middleearthextras.compat.lambdynlights_api;

import dev.lambdaurora.lambdynlights.api.entity.luminance.EntityLuminance;
import dev.lambdaurora.lambdynlights.api.item.ItemLightSourceManager;
import net.minecraft.entity.Entity;
import org.jetbrains.annotations.Range;

public final class ConstantEntityLuminance implements EntityLuminance {
    // The singleton instance.
    public static final ConstantEntityLuminance INSTANCE = new ConstantEntityLuminance();

    private ConstantEntityLuminance() {}

    public EntityLuminance.Type type() {
        // This is the registered type of this entity luminance provider.
        return LambDynLights.CONSTANT;
    }

    @Override
    public @Range(from = 0, to = 15) int getLuminance(
            ItemLightSourceManager itemLightSourceManager,
            Entity entity
    ) {
        return 5;
    }
}
