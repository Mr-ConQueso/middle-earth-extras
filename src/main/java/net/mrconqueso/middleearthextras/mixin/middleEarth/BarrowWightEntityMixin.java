package net.mrconqueso.middleearthextras.mixin.middleEarth;

import net.jukoz.me.entity.barrow_wights.BarrowWightEntity;
import net.mrconqueso.middleearthextras.entity.custom.IWraithEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(BarrowWightEntity.class)
public abstract class BarrowWightEntityMixin implements IWraithEntity {
}