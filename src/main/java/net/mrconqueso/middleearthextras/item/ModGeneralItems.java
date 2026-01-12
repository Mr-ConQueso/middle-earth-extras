package net.mrconqueso.middleearthextras.item;

import net.minecraft.item.Item;
import net.minecraft.item.VerticallyAttachableBlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.mrconqueso.middleearthextras.MiddleEarthExtras;
import net.mrconqueso.middleearthextras.block.ModBlocks;
import net.mrconqueso.middleearthextras.datagen.content.models.SimpleItemModel;
import net.mrconqueso.middleearthextras.item.items.MagicPipeItem;
import net.mrconqueso.middleearthextras.item.items.MagicStone;

public class ModGeneralItems {

    public static final Item MAGIC_PIPE = register2DInventoryItem("magic_pipe",
            new MagicPipeItem(new Item.Settings().maxCount(1), 50));

    public static final Item DAMP_TORCH = registerItemNoGroup("damp_torch",
            new VerticallyAttachableBlockItem(ModBlocks.DAMP_TORCH, ModBlocks.WALL_DAMP_TORCH, new Item.Settings(), Direction.DOWN));

    public static final Item ADAMANT_GEM = registerItem("adamant_gem",
            new Item(new Item.Settings()));
    public static final Item BLACK_ADAMANT = registerItem("black_adamant",
            new Item(new Item.Settings()));

    public static final Item MAGIC_STONE = registerItem("magic_stone",
            new MagicStone(new Item.Settings()));

    private static Item register2DInventoryItem(String name, Item item) {
        ModItemGroups.MISC_CONTENTS.add(item.getDefaultStack());
        return Registry.register(Registries.ITEM, Identifier.of(MiddleEarthExtras.MOD_ID, name), item);
    }

    private static Item registerItem(String name, Item item) {
        ModItemGroups.MISC_CONTENTS.add(item.getDefaultStack());
        SimpleItemModel.items.add(item);
        return Registry.register(Registries.ITEM, Identifier.of(MiddleEarthExtras.MOD_ID, name), item);
    }

    private static Item registerItemNoGroup(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(MiddleEarthExtras.MOD_ID, name), item);
    }

    public static void registerModItems() {
        MiddleEarthExtras.LOGGER.info("Registering General Items for " + MiddleEarthExtras.MOD_ID);
    }
}
