package net.mrconqueso.middleearthextras.util;

import net.minecraft.entity.Entity;

public interface PossessesCamera {
    void onPossessionKeyPacket(Entity keyPresser, int type);
}