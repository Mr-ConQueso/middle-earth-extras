package net.mrconqueso.middleearthextras.client.lightmap;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.mrconqueso.middleearthextras.client.ClientBiomeBlender;
import net.mrconqueso.middleearthextras.util.ModTags;

public class Darkness {
    private static final double DARK_NETHER_FOG = 0.5;
    private static final double DARK_END_FOG = 0.0;

    public static double darkNetherFog() {
        return DARK_NETHER_FOG;
    }

    public static double darkEndFog() {
        return DARK_END_FOG;
    }

    public static boolean enabled = false;
    // Stores the current blend factor (0.0 = Vanilla, 1.0 = Full Darkness)
    public static float currentFactor = 0.0f;
    private static final float[][] LUMINANCE = new float[16][16];

    public static int darken(int c, int blockIndex, int skyIndex) {
        final float lTarget = LUMINANCE[blockIndex][skyIndex];
        final float r = (c & 0xFF) / 255f;
        final float g = ((c >> 8) & 0xFF) / 255f;
        final float b = ((c >> 16) & 0xFF) / 255f;
        final float l = luminance(r, g, b);
        
        // Calculate the darken multiplier 'f'
        final float f = l > 0 ? Math.min(1, lTarget / l) : 0;

        // Interpolate 'f' with 1.0 (no change) based on the blend factor
        // If currentFactor is 1.0, we use 'f' (full darkness).
        // If currentFactor is 0.0, we use 1.0 (no darkness).
        final float blendedF = 1.0f + (f - 1.0f) * currentFactor;

        return blendedF >= 0.999f ? c : 0xFF000000 | Math.round(blendedF * r * 255) | (Math.round(blendedF * g * 255) << 8) | (Math.round(blendedF * b * 255) << 16);
    }

    public static float luminance(float r, float g, float b) {
        return r * 0.2126f + g * 0.7152f + b * 0.0722f;
    }

    public static void updateLuminance(float tickDelta, MinecraftClient client, GameRenderer worldRenderer, float prevFlicker) {
        final ClientWorld world = client.world;

        if (world != null && client.player != null) {
            // Calculate blend factor using the reusable blender
            currentFactor = ClientBiomeBlender.getBlendFactor(world, client.player.getBlockPos(),
                    (biome) -> biome.isIn(ModTags.Biomes.DARK_BIOMES));

            // If factor is negligible, disable the effect to save performance
            if (currentFactor <= 0.001f || client.player.hasStatusEffect(StatusEffects.NIGHT_VISION) ||
                    (client.player.hasStatusEffect(StatusEffects.CONDUIT_POWER)) ||
                    world.getLightningTicksLeft() > 0) {
                enabled = false;
                return;
            } else {
                enabled = true;
            }

            final float dimSkyFactor = Darkness.skyFactor(world);
            // getSkyBrightness(delta) returns the brightness of the sky (0-1), similar to old getSkyDarken logic context
            final float ambient = world.getSkyBrightness(1.0F);
            final DimensionType dim = world.getDimension();
            // Since we are enabled, we are effectively in a "Dark" state
            final boolean blockAmbient = false;

            for (int skyIndex = 0; skyIndex < 16; ++skyIndex) {
                float skyFactor = 1f - skyIndex / 15f;
                skyFactor = 1 - skyFactor * skyFactor * skyFactor * skyFactor;
                skyFactor *= dimSkyFactor;

                float min = skyFactor * 0.05f;
                final float rawAmbient = ambient * skyFactor;
                final float minAmbient = rawAmbient * (1 - min) + min;
                final float skyBase = LightmapTextureManager.getBrightness(dim, skyIndex) * minAmbient;

                min = 0.35f * skyFactor;
                float skyRed = skyBase * (rawAmbient * (1 - min) + min);
                float skyGreen = skyBase * (rawAmbient * (1 - min) + min);
                float skyBlue = skyBase;

                // Removed worldRenderer.getDarkenWorldAmount check as it's not standard in modern Yarn mappings
                // and usually refers to demo screen darkening or specific effects not essential here.

                for (int blockIndex = 0; blockIndex < 16; ++blockIndex) {
                    float blockFactor = 1f;

                    if (!blockAmbient) {
                        blockFactor = 1f - blockIndex / 15f;
                        blockFactor = 1 - blockFactor * blockFactor * blockFactor * blockFactor;
                    }

                    final float blockBase = blockFactor * LightmapTextureManager.getBrightness(dim, blockIndex) * (prevFlicker * 0.1F + 1.5F);
                    min = 0.4f * blockFactor;
                    final float blockGreen = blockBase * ((blockBase * (1 - min) + min) * (1 - min) + min);
                    final float blockBlue = blockBase * (blockBase * blockBase * (1 - min) + min);

                    float red = skyRed + blockBase;
                    float green = skyGreen + blockGreen;
                    float blue = skyBlue + blockBlue;

                    final float f = Math.max(skyFactor, blockFactor);
                    min = 0.03f * f;
                    red = red * (0.99F - min) + min;
                    green = green * (0.99F - min) + min;
                    blue = blue * (0.99F - min) + min;

                    if (world.getRegistryKey() == World.END) {
                        red = skyFactor * 0.22F + blockBase * 0.75f;
                        green = skyFactor * 0.28F + blockGreen * 0.75f;
                        blue = skyFactor * 0.25F + blockBlue * 0.75f;
                    }

                    if (red > 1.0F) red = 1.0F;
                    if (green > 1.0F) green = 1.0F;
                    if (blue > 1.0F) blue = 1.0F;

                    final float gamma = client.options.getGamma().getValue().floatValue() * f;
                    float invRed = 1.0F - red;
                    float invGreen = 1.0F - green;
                    float invBlue = 1.0F - blue;
                    invRed = 1.0F - invRed * invRed * invRed * invRed;
                    invGreen = 1.0F - invGreen * invGreen * invGreen * invGreen;
                    invBlue = 1.0F - invBlue * invBlue * invBlue * invBlue;
                    red = red * (1.0F - gamma) + invRed * gamma;
                    green = green * (1.0F - gamma) + invGreen * gamma;
                    blue = blue * (1.0F - gamma) + invBlue * gamma;

                    min = 0.03f * f;
                    red = red * (0.99F - min) + min;
                    green = green * (0.99F - min) + min;
                    blue = blue * (0.99F - min) + min;

                    if (red > 1.0F) red = 1.0F;
                    if (green > 1.0F) green = 1.0F;
                    if (blue > 1.0F) blue = 1.0F;
                    if (red < 0.0F) red = 0.0F;
                    if (green < 0.0F) green = 0.0F;
                    if (blue < 0.0F) blue = 0.0F;

                    LUMINANCE[blockIndex][skyIndex] = Darkness.luminance(red, green, blue);
                }
            }
        }
    }

    private static float skyFactor(ClientWorld world) {
        if (world.getDimension().hasSkyLight()) {
            final float angle = world.getSkyAngle(0);

            if (angle > 0.25f && angle < 0.75f) {
                final float oldWeight = Math.max(0, (Math.abs(angle - 0.5f) - 0.2f)) * 20;
                final float moon = world.getMoonSize();
                return MathHelper.lerp(oldWeight * oldWeight * oldWeight, moon * moon, 1f);
            } else {
                return 1;
            }
        } else {
            return 0;
        }
    }
}