package net.mrconqueso.middleearthextras.entity.ai;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.mob.MobEntity;
import net.mrconqueso.middleearthextras.entity.custom.HaradrimEntity;

import java.util.EnumSet;

public class StayOnPlatformGoal extends Goal {
    private final MobEntity mob;
    private final double maxRadius;

    public StayOnPlatformGoal(MobEntity mob, double maxRadius) {
        this.mob = mob;
        this.maxRadius = maxRadius;
        this.setControls(EnumSet.of(Control.MOVE));
    }

    @Override
    public boolean canStart() {
        Entity platform = ((HaradrimEntity)mob).getPlatform();
        if (platform == null) return false;

        // Check distance (ignoring Y for simplicity, or include it if needed)
        double distSq = mob.squaredDistanceTo(platform.getX(), mob.getY(), platform.getZ());
        return distSq > (maxRadius * maxRadius);
    }

    @Override
    public void start() {
        Entity platform = ((HaradrimEntity)mob).getPlatform();
        if (platform != null) {
            // Force move to the center of the platform
            this.mob.getNavigation().startMovingTo(platform.getX(), platform.getY() + 1, platform.getZ(), 1.3);
        }
    }

    @Override
    public boolean shouldContinue() {
        // Continue running until we are safely back within 50% of the radius
        Entity platform = ((HaradrimEntity)mob).getPlatform();
        if (platform == null) return false;

        double distSq = mob.squaredDistanceTo(platform.getX(), mob.getY(), platform.getZ());
        return distSq > (maxRadius * 0.5 * maxRadius * 0.5);
    }
}
