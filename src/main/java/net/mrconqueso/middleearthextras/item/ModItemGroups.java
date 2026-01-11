package net.mrconqueso.middleearthextras.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.mrconqueso.middleearthextras.MiddleEarthExtras;

import java.util.LinkedList;
import java.util.List;

public class ModItemGroups {

    public static final List<ItemStack> RINGS_CONTENTS = new LinkedList<>();
    public static final ItemGroup RINGS = FabricItemGroup.builder()
            .displayName(Text.translatable("itemgroup." + MiddleEarthExtras.MOD_ID + ".rings"))
            .icon(() -> new ItemStack(ModRingItems.THE_ONE))
            .entries((displayContext, entries) -> {
                for (ItemStack item : RINGS_CONTENTS) {
                    entries.add(item);
                }
            })
            .build();

    public static final List<ItemStack> SPAWN_EGGS_CONTENTS = new LinkedList<>();
    public static final ItemGroup SPAWN_EGGS = FabricItemGroup.builder()
            .displayName(Text.translatable("itemgroup." + MiddleEarthExtras.MOD_ID + ".spawn_eggs"))
            .icon(() -> new ItemStack(ModEggItems.BEORNING_SPAWN_EGG))
            .entries((displayContext, entries) -> {
                for (ItemStack item : SPAWN_EGGS_CONTENTS) {
                    entries.add(item);
                }
            })
            .build();

    public static final List<ItemStack> MISC_CONTENTS = new LinkedList<>();
    public static final ItemGroup MISC = FabricItemGroup.builder()
            .displayName(Text.translatable("itemgroup." + MiddleEarthExtras.MOD_ID + ".misc"))
            .icon(() -> new ItemStack(ModEggItems.BEORNING_SPAWN_EGG))
            .entries((displayContext, entries) -> {
                for (ItemStack item : MISC_CONTENTS) {
                    entries.add(item);
                }
            })
            .build();

    public static void registerItemGroups() {

        Registry.register(Registries.ITEM_GROUP, Identifier.of(MiddleEarthExtras.MOD_ID, "ring_items"), RINGS);
        Registry.register(Registries.ITEM_GROUP, Identifier.of(MiddleEarthExtras.MOD_ID, "spawn_egg_items"), SPAWN_EGGS);
        Registry.register(Registries.ITEM_GROUP, Identifier.of(MiddleEarthExtras.MOD_ID, "misc"), MISC);

        MiddleEarthExtras.LOGGER.info("Registering Item Groups for " + MiddleEarthExtras.MOD_ID);
    }
}
