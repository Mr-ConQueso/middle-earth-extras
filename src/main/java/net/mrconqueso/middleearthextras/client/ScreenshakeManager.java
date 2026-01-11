package net.mrconqueso.middleearthextras.client;

import net.minecraft.client.world.ClientWorld;

import java.util.concurrent.ThreadLocalRandom;

public class ScreenshakeManager {
    private static float intensity = 0.0F;
    private static int timeLeft = 0;
    private static float offsetX = 0.0F;
    private static float offsetY = 0.0F;
    private static float offsetZ = 0.0F;
    private static volatile boolean debugForce = false;

    public static void startShake(float newIntensity, int durationTicks) {
        if (!(newIntensity <= 0.0F) && durationTicks > 0) {
            intensity = newIntensity;
            timeLeft = durationTicks;
            System.out.println("[CameraShake] startShake: intensity=" + newIntensity + " duration=" + durationTicks);
        }
    }

    public static void tick(ClientWorld client) {
        if (timeLeft > 0) {
            float range = 2.0F * intensity;
            ThreadLocalRandom rnd = ThreadLocalRandom.current();
            offsetX = (rnd.nextFloat() - 0.5F) * range;
            offsetY = (rnd.nextFloat() - 0.5F) * range;
            offsetZ = (rnd.nextFloat() - 0.5F) * range;
            --timeLeft;
            if (timeLeft == 0) {
                offsetX = 0.0F;
                offsetY = 0.0F;
                offsetZ = 0.0F;
                intensity = 0.0F;
                System.out.println("[CameraShake] finished");
            }
        }

    }

    public static boolean isActive() {
        return timeLeft > 0;
    }

    public static float getOffsetX() {
        return offsetX;
    }

    public static float getOffsetY() {
        return offsetY;
    }

    public static float getOffsetZ() {
        return offsetZ;
    }

    public static float getIntensity() {
        return intensity;
    }

    public static void setDebugForce(boolean value) {
        debugForce = value;
        System.out.println("[CameraShake] debugForce=" + value);
    }

    public static boolean isDebugForce() {
        return debugForce;
    }
}