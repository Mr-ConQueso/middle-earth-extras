package net.mrconqueso.middleearthextras.compat.jade;

import net.jukoz.me.entity.beasts.trolls.petrified.PetrifiedTrollEntity;
import net.minecraft.util.Identifier;
import net.mrconqueso.middleearthextras.MiddleEarthExtras;
import snownee.jade.api.EntityAccessor;
import snownee.jade.api.IEntityComponentProvider;
import snownee.jade.api.ITooltip;
import snownee.jade.api.config.IPluginConfig;

public enum PetrifiedTrollComponentProvider implements IEntityComponentProvider {
    INSTANCE;

    @Override
    public void appendTooltip(ITooltip tooltip, EntityAccessor accessor, IPluginConfig config) {
        if (accessor.getEntity() instanceof PetrifiedTrollEntity) {
            tooltip.remove(Identifier.of("jade", "mob_health"));
        }
    }

    @Override
    public Identifier getUid() {
        return Identifier.of(MiddleEarthExtras.MOD_ID, "petrified_troll_entity");
    }
}