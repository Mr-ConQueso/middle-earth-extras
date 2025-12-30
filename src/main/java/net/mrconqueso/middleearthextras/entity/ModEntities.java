package net.mrconqueso.middleearthextras.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.mrconqueso.middleearthextras.MiddleEarthExtras;
import net.mrconqueso.middleearthextras.entity.custom.*;

public class ModEntities {

    public static final EntityType<FellBeastEntity> FELL_BEAST = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(MiddleEarthExtras.MOD_ID, "fell_beast"),
            EntityType.Builder.create(FellBeastEntity::new, SpawnGroup.MONSTER)
                    .dimensions(4.5F, 4.5F)
                    .eyeHeight(1.74F)
                    .passengerAttachments(2.0125F)
                    .vehicleAttachment(-0.7F)
                    .maxTrackingRange(8).build());

    public static final EntityType<OliphauntEntity> OLIPHAUNT = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(MiddleEarthExtras.MOD_ID, "oliphaunt"),
            EntityType.Builder.create(OliphauntEntity::new, SpawnGroup.CREATURE)
                    .dimensions(10F, 14F)
                    .eyeHeight(11.5f)
                    .maxTrackingRange(32).build());

    public static final EntityType<HaradrimEntity> HARADRIM = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(MiddleEarthExtras.MOD_ID, "haradrim"),
            EntityType.Builder.create(HaradrimEntity::new, SpawnGroup.MONSTER)
                    .dimensions(0.6F, 1.95F)
                    .eyeHeight(1.74F)
                    .passengerAttachments(2.0125F)
                    .vehicleAttachment(-0.7F)
                    .maxTrackingRange(128).build());

    public static final EntityType<BeorningHumanEntity> BEORNING_HUMAN = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(MiddleEarthExtras.MOD_ID, "beorning_human"),
            EntityType.Builder.create(BeorningHumanEntity::new, SpawnGroup.MONSTER)
                    .dimensions(0.6F, 1.95F)
                    .eyeHeight(1.74F)
                    .passengerAttachments(2.0125F)
                    .vehicleAttachment(-0.7F)
                    .maxTrackingRange(128).build());

    public static final EntityType<BeorningBearEntity> BEORNING_BEAR = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(MiddleEarthExtras.MOD_ID, "beorning_bear"),
            EntityType.Builder.create(BeorningBearEntity::new, SpawnGroup.MONSTER)
                    .dimensions(0.6F, 1.95F)
                    .eyeHeight(1.74F)
                    .passengerAttachments(2.0125F)
                    .vehicleAttachment(-0.7F)
                    .maxTrackingRange(8).build());

    public static void registerModEntities() {
        MiddleEarthExtras.LOGGER.info("Registering Mod Entities for " + MiddleEarthExtras.MOD_ID);
    }
}
