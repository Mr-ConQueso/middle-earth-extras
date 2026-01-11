package net.mrconqueso.middleearthextras.resources;

import net.jukoz.me.MiddleEarth;
import net.jukoz.me.resources.datas.Disposition;
import net.jukoz.me.resources.datas.FactionType;
import net.jukoz.me.resources.datas.factions.Faction;
import net.jukoz.me.resources.datas.factions.data.BannerData;
import net.jukoz.me.resources.datas.factions.data.SpawnData;
import net.jukoz.me.resources.datas.factions.data.SpawnDataHandler;
import net.jukoz.me.resources.datas.npcs.data.NpcRank;
import net.minecraft.block.entity.BannerPatterns;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.mrconqueso.middleearthextras.MiddleEarthExtras;
import net.mrconqueso.middleearthextras.resources.datas.npcs.pools.BeorningNpcDataPool;
import net.mrconqueso.middleearthextras.resources.datas.npcs.pools.HaradrimNpcDataPool;
import org.joml.Vector2d;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class ModFactions {

    public static final RegistryKey<Registry<Faction>> MOD_FACTION_KEY = RegistryKey.ofRegistry(Identifier.of(MiddleEarth.MOD_ID, "factions"));

    public final static Faction HARADRIM;
    public final static Faction BEORNINGS;

    public static void register(){
        MiddleEarthExtras.LOGGER.info("Registering Dynamic Factions for " + MiddleEarthExtras.MOD_ID);
    }

    public static void bootstrap(Registerable<Faction> context) {
        RegistryEntryLookup<Faction> factionRegistryEntryLookup = context.getRegistryLookup(MOD_FACTION_KEY);

        register(context, factionRegistryEntryLookup, HARADRIM);
        register(context, factionRegistryEntryLookup, BEORNINGS);
    }
    private static Faction register(Registerable<Faction> context, RegistryEntryLookup<Faction> factionRegistryEntryLookup, Faction faction) {
        RegistryKey<Faction> factionRegistryKey = of(faction.getName());
        String name = factionRegistryKey.getValue().getPath();
        RegistryKey<Faction> factionKey = RegistryKey.of(MOD_FACTION_KEY,Identifier.of(MiddleEarthExtras.MOD_ID, name));

        Optional<RegistryEntry.Reference<Faction>> optionalFaction = factionRegistryEntryLookup.getOptional(factionRegistryKey);
        optionalFaction.ifPresent(biomeReference -> context.register(factionKey, faction));

        return faction;
    }

    private static RegistryKey<Faction> of(String name) {
        return RegistryKey.of(MOD_FACTION_KEY, Identifier.of(MiddleEarthExtras.MOD_ID, name));
    }

    static {
        //region [HARADRIM]
        HARADRIM = new Faction("middle-earth-extras:haradrim", true, Disposition.EVIL, FactionType.FACTION, null,null,
                new HashMap<>(){{
                    put(NpcRank.CIVILIAN, List.of(
                            HaradrimNpcDataPool.HARADRIM_SCOUT
                    ));
                    put(NpcRank.MILITIA, List.of(
                            HaradrimNpcDataPool.HARADRIM_SCOUT
                    ));
                    put(NpcRank.SOLDIER, List.of(
                            HaradrimNpcDataPool.HARADRIM_SOLDIER
                    ));
                    put(NpcRank.KNIGHT, List.of(
                            HaradrimNpcDataPool.HARADRIM_BERSERKER
                    ));
                    put(NpcRank.VETERAN, List.of(
                            HaradrimNpcDataPool.HARADRIM_VETERAN
                    ));
                    put(NpcRank.LEADER, List.of(
                            HaradrimNpcDataPool.HARADRIM_LEADER
                    ));
                }},
                new BannerData(DyeColor.BLACK, List.of(
                        new BannerData.BannerPatternWithColor(BannerPatterns.GRADIENT_UP, DyeColor.GRAY),
                        new BannerData.BannerPatternWithColor(BannerPatterns.CROSS, DyeColor.RED),
                        new BannerData.BannerPatternWithColor(BannerPatterns.SKULL, DyeColor.WHITE)
                )),
                new SpawnDataHandler(List.of(
                        new SpawnData(Identifier.of(MiddleEarthExtras.MOD_ID, "harondor.umbar"),  new Vector2d(1573, 2465))
                )), List.of(), List.of()
        );
        //endregion

        //region [HARADRIM]
        BEORNINGS = new Faction("middle-earth-extras:beornings", true, Disposition.GOOD, FactionType.FACTION, null,null,
                new HashMap<>(){{
                    put(NpcRank.CIVILIAN, List.of(
                            BeorningNpcDataPool.HARADRIM_SCOUT
                    ));
                    put(NpcRank.MILITIA, List.of(
                            BeorningNpcDataPool.HARADRIM_SCOUT
                    ));
                    put(NpcRank.SOLDIER, List.of(
                            BeorningNpcDataPool.HARADRIM_SOLDIER
                    ));
                    put(NpcRank.KNIGHT, List.of(
                            BeorningNpcDataPool.HARADRIM_BERSERKER
                    ));
                    put(NpcRank.VETERAN, List.of(
                            BeorningNpcDataPool.HARADRIM_VETERAN
                    ));
                    put(NpcRank.LEADER, List.of(
                            BeorningNpcDataPool.HARADRIM_LEADER
                    ));
                }},
                new BannerData(DyeColor.BLACK, List.of(
                        new BannerData.BannerPatternWithColor(BannerPatterns.GRADIENT_UP, DyeColor.GRAY),
                        new BannerData.BannerPatternWithColor(BannerPatterns.CROSS, DyeColor.RED),
                        new BannerData.BannerPatternWithColor(BannerPatterns.SKULL, DyeColor.WHITE)
                )),
                new SpawnDataHandler(List.of(
                        new SpawnData(Identifier.of(MiddleEarthExtras.MOD_ID, "mirkwood.carrock"),  new Vector2d(1698, 845))
                )), List.of(), List.of()
        );
        //endregion
    }
}

