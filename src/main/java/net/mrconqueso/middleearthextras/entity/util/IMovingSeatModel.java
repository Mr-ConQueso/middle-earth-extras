package net.mrconqueso.middleearthextras.entity.util;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;

public interface IMovingSeatModel {
    public Vec3d getSeatPosition(Entity entity, float partialTick);
}
