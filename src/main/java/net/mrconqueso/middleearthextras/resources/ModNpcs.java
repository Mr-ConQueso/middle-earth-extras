package net.mrconqueso.middleearthextras.resources;

import net.jukoz.me.MiddleEarth;
import net.jukoz.me.resources.datas.npcs.NpcData;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.mrconqueso.middleearthextras.MiddleEarthExtras;
import net.mrconqueso.middleearthextras.resources.datas.npcs.pools.BeorningNpcDataPool;
import net.mrconqueso.middleearthextras.resources.datas.npcs.pools.HaradrimNpcDataPool;

import java.util.List;
import java.util.Optional;

public class ModNpcs {

    public static final RegistryKey<Registry<NpcData>> MOD_NPC_KEY = RegistryKey.ofRegistry(Identifier.of(MiddleEarth.MOD_ID, "npcs"));

    public static void register() {
        MiddleEarthExtras.LOGGER.info("Registering Dynamic Npcs for " + MiddleEarthExtras.MOD_ID);
    }

    public static void bootstrap(Registerable<NpcData> context) {
        RegistryEntryLookup<NpcData> npcRegistryEntryLookup = context.getRegistryLookup(MOD_NPC_KEY);

        registerAll(context, npcRegistryEntryLookup, HaradrimNpcDataPool.fetchAll());
        registerAll(context, npcRegistryEntryLookup, BeorningNpcDataPool.fetchAll());
    }

    private static void registerAll(Registerable<NpcData> context, RegistryEntryLookup<NpcData> npcRegistryEntryLookup, List<NpcData> npcDatas) {
        for(NpcData data : npcDatas) {
            register(context, npcRegistryEntryLookup, data);
        }
    }

    public static NpcData register(Registerable<NpcData> context, RegistryEntryLookup<NpcData> npcRegistryEntryLookup, NpcData npcData) {
        RegistryKey<NpcData> npcRegistryKey = of(npcData.getName());
        String name = npcRegistryKey.getValue().getPath();
        RegistryKey<NpcData> npcKey = RegistryKey.of(MOD_NPC_KEY, Identifier.of(MiddleEarthExtras.MOD_ID, name));
        Optional<RegistryEntry.Reference<NpcData>> optionalNpc = npcRegistryEntryLookup.getOptional(npcRegistryKey);
        optionalNpc.ifPresent((npcReference) -> context.register(npcKey, npcData));
        return npcData;
    }

    private static RegistryKey<NpcData> of(String name) {
        return RegistryKey.of(MOD_NPC_KEY, Identifier.of(MiddleEarthExtras.MOD_ID, name));
    }
}