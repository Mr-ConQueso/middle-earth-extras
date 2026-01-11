package net.mrconqueso.middleearthextras.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.VerticallyAttachableBlockItem;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.mrconqueso.middleearthextras.MiddleEarthExtras;
import net.mrconqueso.middleearthextras.block.ModBlocks;
import net.mrconqueso.middleearthextras.item.dataComponents.ModFoodComponents;
import net.mrconqueso.middleearthextras.item.items.MagicPipeItem;

import java.util.List;

public class ModGeneralItems {

    public static final Item MAGIC_PIPE = registerItem("magic_pipe",
            new MagicPipeItem(new Item.Settings().maxCount(1), 50));

    public static final Item DAMP_TORCH = registerItemNoGroup("damp_torch",
            new VerticallyAttachableBlockItem(ModBlocks.DAMP_TORCH, ModBlocks.WALL_DAMP_TORCH, new Item.Settings(), Direction.DOWN));


    private static Item registerItem(String name, Item item) {
        ModItemGroups.MISC_CONTENTS.add(item.getDefaultStack());
        return Registry.register(Registries.ITEM, Identifier.of(MiddleEarthExtras.MOD_ID, name), item);
    }

    private static Item registerItemNoGroup(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(MiddleEarthExtras.MOD_ID, name), item);
    }

    public static void registerModItems() {
        MiddleEarthExtras.LOGGER.info("Registering General Items for " + MiddleEarthExtras.MOD_ID);
    }
}
