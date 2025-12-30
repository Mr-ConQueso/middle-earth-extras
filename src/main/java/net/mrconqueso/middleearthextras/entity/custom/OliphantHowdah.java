package net.mrconqueso.middleearthextras.entity.custom;

import net.minecraft.entity.Entity;
import nordmods.primitive_multipart_entities.common.entity.EntityPart;

public class OliphantHowdah extends EntityPart {

    public OliphantHowdah(Entity owner, float width, float height) {
        super(owner, width, height);
    }

    @Override
    public boolean isCollidable() {
        return true;
    }

    @Override
    public boolean canHit() {
        return false;
    }
}
