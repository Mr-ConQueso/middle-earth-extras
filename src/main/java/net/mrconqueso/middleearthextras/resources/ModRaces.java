package net.mrconqueso.middleearthextras.resources;

import net.jukoz.me.MiddleEarth;
import net.jukoz.me.resources.datas.RaceType;
import net.jukoz.me.resources.datas.races.Race;
import net.jukoz.me.resources.datas.races.data.AttributeData;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.mrconqueso.middleearthextras.MiddleEarthExtras;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import static net.jukoz.me.resources.MiddleEarthRaces.RACE_KEY;

public class ModRaces {
    public static final Race BEORNING;
    public static final Race ENT;

    public static void register() {
        MiddleEarthExtras.LOGGER.info("Registering Dynamic Races for " + MiddleEarthExtras.MOD_ID);
    }

    public static void bootstrap(Registerable<Race> context) {
        RegistryEntryLookup<Race> raceRegistryEntryLookup = context.getRegistryLookup(RACE_KEY);

        register(context, raceRegistryEntryLookup, BEORNING);
        register(context, raceRegistryEntryLookup, ENT);
    }

    private static Race register(Registerable<Race> context, RegistryEntryLookup<Race> raceRegistryEntryLookup, Race race) {
        RegistryKey<Race> raceRegistryKey = of(race.getId().getPath());
        String name = raceRegistryKey.getValue().getPath();
        RegistryKey<Race> newRace = RegistryKey.of(RACE_KEY, Identifier.of(MiddleEarth.MOD_ID, name));
        Optional<RegistryEntry.Reference<Race>> optionalRace = raceRegistryEntryLookup.getOptional(raceRegistryKey);
        optionalRace.ifPresent((raceReference) -> context.register(newRace, race));
        return race;
    }

    private static RegistryKey<Race> of(String name) {
        return RegistryKey.of(RACE_KEY, Identifier.of(MiddleEarth.MOD_ID, name));
    }

    static {
        BEORNING = new Race(Identifier.of(MiddleEarth.MOD_ID, "beorning"), RaceType.NONE, new AttributeData(new HashMap<RegistryEntry<EntityAttribute>, Double>() {
            {
                this.put(EntityAttributes.GENERIC_SCALE, (double)1.0F);
                this.put(EntityAttributes.GENERIC_MAX_HEALTH, (double)22.0F);
                this.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, (double)1.0F);
                this.put(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE, (double)3.0F);
                this.put(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.09);
                this.put(EntityAttributes.GENERIC_BURNING_TIME, 0.7);
            }
        }), List.of(), List.of());

        ENT = new Race(Identifier.of(MiddleEarth.MOD_ID, "ent"), RaceType.NONE, new AttributeData(new HashMap<RegistryEntry<EntityAttribute>, Double>() {
            {
                this.put(EntityAttributes.GENERIC_SCALE, (double)1.0F);
                this.put(EntityAttributes.GENERIC_MAX_HEALTH, (double)22.0F);
                this.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, (double)1.0F);
                this.put(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE, (double)3.0F);
                this.put(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.09);
                this.put(EntityAttributes.GENERIC_BURNING_TIME, 0.7);
            }
        }), List.of(), List.of());
    }
}