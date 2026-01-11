package net.mrconqueso.middleearthextras.mixin.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Environment(EnvType.CLIENT)
@Mixin(GameRenderer.class)
public interface GameRendererAccessor {
    // This annotation tells Mixin: "Find the method named 'loadPostProcessor' and let me call it."
    @Invoker("loadPostProcessor")
    void invokeLoadPostProcessor(Identifier id);
}