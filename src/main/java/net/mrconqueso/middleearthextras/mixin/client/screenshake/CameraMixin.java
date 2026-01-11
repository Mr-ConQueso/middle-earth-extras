package net.mrconqueso.middleearthextras.mixin.client.screenshake;

import net.minecraft.client.render.Camera;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.BlockView;
import net.mrconqueso.middleearthextras.client.ScreenshakeManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Camera.class)
public class CameraMixin {
    @Unique
    private double cs$origX = 0.0;
    @Unique
    private double cs$origY = 0.0;
    @Unique
    private double cs$origZ = 0.0;
    @Unique
    private boolean cs$appliedThisUpdate = false;
    @Unique
    private double cs$totalY = 0.0;

    @Inject(method = "update", at = @At("HEAD"))
    private void camerashake$head(BlockView area, Entity focusedEntity, boolean thirdPerson, boolean inverseView, float tickDelta, CallbackInfo ci) {
        Camera self = (Camera) (Object) this;
        Vec3d pos = self.getPos();
        this.cs$origX = pos.x;
        this.cs$origY = pos.y;
        this.cs$origZ = pos.z;
        this.cs$appliedThisUpdate = false;

        if (!ScreenshakeManager.isActive() && !ScreenshakeManager.isDebugForce()) {
            this.cs$totalY = 0.0;
        }
    }

    @Inject(method = "update", at = @At("TAIL"))
    private void camerashake$tail(BlockView area, Entity focusedEntity, boolean thirdPerson, boolean inverseView, float tickDelta, CallbackInfo ci) {
        this.applyShakeOnce();
    }

    @Unique
    private void applyShakeOnce() {
        if (!this.cs$appliedThisUpdate) {
            boolean active = ScreenshakeManager.isActive() || ScreenshakeManager.isDebugForce();
            if (active) {
                float dx = ScreenshakeManager.isDebugForce() ? 0.8F : ScreenshakeManager.getOffsetX();
                float dy = ScreenshakeManager.isDebugForce() ? 0.6F : ScreenshakeManager.getOffsetY();
                float dz = ScreenshakeManager.isDebugForce() ? 0.5F : ScreenshakeManager.getOffsetZ();

                Camera self = (Camera) (Object) this;

                // Convert yaw and pitch to radians
                double yawRad = Math.toRadians(self.getYaw()) + Math.PI;
                double pitchRad = Math.toRadians(self.getPitch());

                double cosPitch = Math.cos(pitchRad);
                double sinPitch = Math.sin(pitchRad);
                double sinYaw = Math.sin(yawRad);
                double cosYaw = Math.cos(yawRad);

                // Calculate forward/up/side vectors based on rotation
                double fx = sinYaw * cosPitch;
                double fy = -sinPitch;
                double fz = cosYaw * cosPitch;

                Vec3d base = self.getPos();

                // Calculate shake shifts
                double shiftX = dx + dz * fx;
                double desiredY = dy + dz * fy;
                double shiftZ = dz * fz;

                double prevTotal = this.cs$totalY;
                double newTotal = prevTotal + desiredY;

                // Clamp the vertical shake to avoid excessive movement
                if (newTotal > 0.3) {
                    newTotal = 0.3;
                }
                if (newTotal < -0.3) {
                    newTotal = -0.3;
                }

                double appliedY = newTotal - prevTotal;
                this.cs$totalY = newTotal;

                ((CameraAccessor) self).invokeSetPos(base.x + shiftX, base.y + appliedY, base.z + shiftZ);
                this.cs$appliedThisUpdate = true;
            }
        }
    }
}