package net.mrconqueso.middleearthextras.resources.datas.npcs.pools;

import net.jukoz.me.item.utils.armor.capes.ModCapes;
import net.jukoz.me.resources.datas.npcs.NpcData;
import net.jukoz.me.resources.datas.npcs.data.NpcGearData;
import net.jukoz.me.resources.datas.npcs.data.NpcGearItemData;
import net.jukoz.me.resources.datas.npcs.data.NpcGearSlotData;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.mrconqueso.middleearthextras.MiddleEarthExtras;
import net.mrconqueso.middleearthextras.item.ModEquipmentItems;
import net.mrconqueso.middleearthextras.item.ModWeaponItems;
import net.mrconqueso.middleearthextras.resources.ModRaces;

import java.util.List;

public class BeorningNpcDataPool {
    private final static String FACTION_BASE = "beorning.";
    private static List<Integer> allColors;
    private static final int DARK = 0x302b28;
    private static final int DARK_BROWN = 0x655147;
    public final static NpcData HARADRIM_SOLDIER;
    public final static NpcData HARADRIM_SCOUT;
    public final static NpcData HARADRIM_VETERAN;
    public final static NpcData HARADRIM_BERSERKER;
    public final static NpcData HARADRIM_LEADER;

    public static List<NpcData> fetchAll() {
        return List.of(
                HARADRIM_SOLDIER,
                HARADRIM_SCOUT,
                HARADRIM_VETERAN,
                HARADRIM_BERSERKER,
                HARADRIM_LEADER
        );
    }

    static {
        allColors = List.of(DARK, DARK_BROWN);

        HARADRIM_SOLDIER = new NpcData(Identifier.of(MiddleEarthExtras.MOD_ID, FACTION_BASE + "soldier"), ModRaces.BEORNING, List.of(
                NpcGearData.create()
                        .add(EquipmentSlot.HEAD, NpcGearSlotData.create()
                                .add(NpcGearItemData.create(ModEquipmentItems.HARADRIM_HELMET))
                        )
                        .add(EquipmentSlot.CHEST, NpcGearSlotData.create()
                                .add(NpcGearItemData.create(ModEquipmentItems.HARADRIM_CHESTPLATE))
                                .add(NpcGearItemData.create(ModEquipmentItems.HARADRIM_CHESTPLATE).withCape(ModCapes.ORCISH_CAPE))
                        )
                        .add(EquipmentSlot.LEGS, NpcGearSlotData.create()
                                .add(NpcGearItemData.create(ModEquipmentItems.HARADRIM_LEGGINGS))
                        )
                        .add(EquipmentSlot.FEET, NpcGearSlotData.create(NpcGearItemData.create(ModEquipmentItems.HARADRIM_BOOTS)))
                        .add(EquipmentSlot.MAINHAND, NpcGearSlotData.create()
                                .add(NpcGearItemData.create(net.jukoz.me.item.ModWeaponItems.ISENGARD_ORC_WARBLADE))
                                .add(NpcGearItemData.create(Items.AIR).withWeight(10))
                        )
                        .add(EquipmentSlot.OFFHAND, NpcGearSlotData.create()
                                .add(NpcGearItemData.create(ModWeaponItems.HARADRIM_SHIELD))
                                .add(NpcGearItemData.create(Items.AIR).withWeight(3))
                        )
        ));

        HARADRIM_SCOUT = new NpcData(Identifier.of(MiddleEarthExtras.MOD_ID, FACTION_BASE + "scout"), ModRaces.BEORNING, List.of(
                NpcGearData.create()
                        .add(EquipmentSlot.HEAD, NpcGearSlotData.create()
                                .add(NpcGearItemData.create(ModEquipmentItems.HARADRIM_HELMET))
                        )
                        .add(EquipmentSlot.CHEST, NpcGearSlotData.create()
                                .add(NpcGearItemData.create(ModEquipmentItems.HARADRIM_CHESTPLATE))
                                .add(NpcGearItemData.create(ModEquipmentItems.HARADRIM_CHESTPLATE).withCape(ModCapes.ORCISH_CAPE))
                        )
                        .add(EquipmentSlot.LEGS, NpcGearSlotData.create()
                                .add(NpcGearItemData.create(ModEquipmentItems.HARADRIM_LEGGINGS))
                        )
                        .add(EquipmentSlot.FEET, NpcGearSlotData.create(NpcGearItemData.create(ModEquipmentItems.HARADRIM_BOOTS)))
                        .add(EquipmentSlot.MAINHAND, NpcGearSlotData.create()
                                .add(NpcGearItemData.create(net.jukoz.me.item.ModWeaponItems.ISENGARD_ORC_WARBLADE))
                                .add(NpcGearItemData.create(Items.AIR).withWeight(10))
                        )
                        .add(EquipmentSlot.OFFHAND, NpcGearSlotData.create()
                                .add(NpcGearItemData.create(ModWeaponItems.HARADRIM_SHIELD))
                                .add(NpcGearItemData.create(Items.AIR).withWeight(3))
                        )
        ));

        HARADRIM_VETERAN = new NpcData(Identifier.of(MiddleEarthExtras.MOD_ID, FACTION_BASE + "veteran"), ModRaces.BEORNING, List.of(
                NpcGearData.create()
                        .add(EquipmentSlot.HEAD, NpcGearSlotData.create()
                                .add(NpcGearItemData.create(ModEquipmentItems.HARADRIM_HELMET))
                        )
                        .add(EquipmentSlot.CHEST, NpcGearSlotData.create()
                                .add(NpcGearItemData.create(ModEquipmentItems.HARADRIM_CHESTPLATE))
                                .add(NpcGearItemData.create(ModEquipmentItems.HARADRIM_CHESTPLATE).withCape(ModCapes.ORCISH_CAPE))
                        )
                        .add(EquipmentSlot.LEGS, NpcGearSlotData.create()
                                .add(NpcGearItemData.create(ModEquipmentItems.HARADRIM_LEGGINGS))
                        )
                        .add(EquipmentSlot.FEET, NpcGearSlotData.create(NpcGearItemData.create(ModEquipmentItems.HARADRIM_BOOTS)))
                        .add(EquipmentSlot.MAINHAND, NpcGearSlotData.create()
                                .add(NpcGearItemData.create(net.jukoz.me.item.ModWeaponItems.ISENGARD_ORC_WARBLADE))
                                .add(NpcGearItemData.create(Items.AIR).withWeight(10))
                        )
                        .add(EquipmentSlot.OFFHAND, NpcGearSlotData.create()
                                .add(NpcGearItemData.create(ModWeaponItems.HARADRIM_SHIELD))
                                .add(NpcGearItemData.create(Items.AIR).withWeight(3))
                        )
        ));


        HARADRIM_BERSERKER = new NpcData(Identifier.of(MiddleEarthExtras.MOD_ID, FACTION_BASE + "berserker"), ModRaces.BEORNING, List.of(
                NpcGearData.create()
                        .add(EquipmentSlot.HEAD, NpcGearSlotData.create()
                                .add(NpcGearItemData.create(ModEquipmentItems.HARADRIM_HELMET))
                        )
                        .add(EquipmentSlot.CHEST, NpcGearSlotData.create()
                                .add(NpcGearItemData.create(ModEquipmentItems.HARADRIM_CHESTPLATE))
                                .add(NpcGearItemData.create(ModEquipmentItems.HARADRIM_CHESTPLATE).withCape(ModCapes.ORCISH_CAPE))
                        )
                        .add(EquipmentSlot.LEGS, NpcGearSlotData.create()
                                .add(NpcGearItemData.create(ModEquipmentItems.HARADRIM_LEGGINGS))
                        )
                        .add(EquipmentSlot.FEET, NpcGearSlotData.create(NpcGearItemData.create(ModEquipmentItems.HARADRIM_BOOTS)))
                        .add(EquipmentSlot.MAINHAND, NpcGearSlotData.create()
                                .add(NpcGearItemData.create(net.jukoz.me.item.ModWeaponItems.ISENGARD_ORC_WARBLADE))
                                .add(NpcGearItemData.create(Items.AIR).withWeight(10))
                        )
                        .add(EquipmentSlot.OFFHAND, NpcGearSlotData.create()
                                .add(NpcGearItemData.create(ModWeaponItems.HARADRIM_SHIELD))
                                .add(NpcGearItemData.create(Items.AIR).withWeight(3))
                        )
        ));

        HARADRIM_LEADER = new NpcData(Identifier.of(MiddleEarthExtras.MOD_ID, FACTION_BASE + "leader"), ModRaces.BEORNING, List.of(
                NpcGearData.create()
                        .add(EquipmentSlot.HEAD, NpcGearSlotData.create()
                                .add(NpcGearItemData.create(ModEquipmentItems.HARADRIM_HELMET))
                        )
                        .add(EquipmentSlot.CHEST, NpcGearSlotData.create()
                                .add(NpcGearItemData.create(ModEquipmentItems.HARADRIM_CHESTPLATE))
                                .add(NpcGearItemData.create(ModEquipmentItems.HARADRIM_CHESTPLATE).withCape(ModCapes.ORCISH_CAPE))
                        )
                        .add(EquipmentSlot.LEGS, NpcGearSlotData.create()
                                .add(NpcGearItemData.create(ModEquipmentItems.HARADRIM_LEGGINGS))
                        )
                        .add(EquipmentSlot.FEET, NpcGearSlotData.create(NpcGearItemData.create(ModEquipmentItems.HARADRIM_BOOTS)))
                        .add(EquipmentSlot.MAINHAND, NpcGearSlotData.create()
                                .add(NpcGearItemData.create(net.jukoz.me.item.ModWeaponItems.ISENGARD_ORC_WARBLADE))
                                .add(NpcGearItemData.create(Items.AIR).withWeight(10))
                        )
                        .add(EquipmentSlot.OFFHAND, NpcGearSlotData.create()
                                .add(NpcGearItemData.create(ModWeaponItems.HARADRIM_SHIELD))
                                .add(NpcGearItemData.create(Items.AIR).withWeight(3))
                        )
        ));
    }
}
