package net.mrconqueso.middleearthextras.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.mrconqueso.middleearthextras.MiddleEarthExtras;
import net.mrconqueso.middleearthextras.entity.custom.*;
import net.mrconqueso.middleearthextras.entity.misc.PalantirViewEntity;
import net.mrconqueso.middleearthextras.entity.projectile.smoke.SmokeBoatProjectileEntity;

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

    public static final EntityType<RingWraithEntity> RING_WRAITH = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(MiddleEarthExtras.MOD_ID, "ring_wraith"),
            EntityType.Builder.create(RingWraithEntity::new, SpawnGroup.MONSTER)
                    .dimensions(0.6F, 1.95F)
                    .eyeHeight(1.74F)
                    .passengerAttachments(2.0125F)
                    .vehicleAttachment(-0.7F)
                    .maxTrackingRange(128).build());

    public static final EntityType<BeorningHumanEntity> BEORNING_HUMAN = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(MiddleEarthExtras.MOD_ID, "beorning_human"),
            EntityType.Builder.create(BeorningHumanEntity::new, SpawnGroup.CREATURE)
                    .dimensions(0.6F, 1.95F)
                    .eyeHeight(1.74F)
                    .passengerAttachments(2.0125F)
                    .vehicleAttachment(-0.7F)
                    .maxTrackingRange(128).build());

    public static final EntityType<BeorningBearEntity> BEORNING_BEAR = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(MiddleEarthExtras.MOD_ID, "beorning_bear"),
            EntityType.Builder.create(BeorningBearEntity::new, SpawnGroup.CREATURE)
                    .dimensions(0.6F, 1.95F)
                    .eyeHeight(1.74F)
                    .passengerAttachments(2.0125F)
                    .vehicleAttachment(-0.7F)
                    .maxTrackingRange(8).build());

    public static final EntityType<EntEntity> ENT = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(MiddleEarthExtras.MOD_ID, "ent"),
            EntityType.Builder.create(EntEntity::new, SpawnGroup.CREATURE)
                    .dimensions(2.25F, 7.5F)
                    .eyeHeight(5.4F)
                    .maxTrackingRange(8).build());

    public static final EntityType<SmokeBoatProjectileEntity> SMOKE_BOAT_PROJECTILE = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(MiddleEarthExtras.MOD_ID, "smoke_boat_projectile"),
            EntityType.Builder.<SmokeBoatProjectileEntity>create(SmokeBoatProjectileEntity::new, SpawnGroup.MISC)
                    .dimensions(0.5F, 0.5F)
                    .eyeHeight(0.5F)
                    .maxTrackingRange(1).build());

    public static final EntityType<PalantirViewEntity> PALANTIR_VIEW = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(MiddleEarthExtras.MOD_ID, "palantir_view"),
            EntityType.Builder.create(PalantirViewEntity::new, SpawnGroup.MISC)
                    .dimensions(0.5F, 0.5F)
                    .eyeHeight(0.5F)
                    .maxTrackingRange(256).build());

    public static void registerModEntities() {
        MiddleEarthExtras.LOGGER.info("Registering Mod Entities for " + MiddleEarthExtras.MOD_ID);
    }
}
