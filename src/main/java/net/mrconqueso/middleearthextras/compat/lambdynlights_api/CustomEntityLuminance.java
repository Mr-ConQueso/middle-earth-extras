package net.mrconqueso.middleearthextras.compat.lambdynlights_api;


import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import dev.lambdaurora.lambdynlights.api.entity.luminance.EntityLuminance;
import dev.lambdaurora.lambdynlights.api.item.ItemLightSourceManager;
import net.minecraft.entity.Entity;
import org.jetbrains.annotations.Range;

public record CustomEntityLuminance(boolean invert) implements EntityLuminance {
    // The Codec of this entity luminance provider,
    // this describes how to parse the JSON file.
    public static final MapCodec<CustomEntityLuminance> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(
                    Codec.BOOL.fieldOf("invert").forGetter(CustomEntityLuminance::invert)
            ).apply(instance, CustomEntityLuminance::new)
    );

    public EntityLuminance.Type type() {
        // This is the registered type of this entity luminance provider.
        // We will modify the initializer to reflect this.
        return LambDynLights.CUSTOM_ENTITY_LUMINANCE;
    }

    @Override
    public @Range(from = 0, to = 15) int getLuminance(
            ItemLightSourceManager itemLightSourceManager,
            Entity entity
    ) {
        // Here we compute the luminance the given entity should emit.
        // We also have access to the item light source manager,
        // in case our luminance depends on the luminance of an item.
        boolean isNight = this.invert ? entity.getWorld().isDay() : entity.getWorld().isNight();

        return isNight ? 10 : 0;
    }
}
