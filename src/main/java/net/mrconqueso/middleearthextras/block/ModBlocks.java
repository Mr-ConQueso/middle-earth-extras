package net.mrconqueso.middleearthextras.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.mrconqueso.middleearthextras.MiddleEarthExtras;
import net.mrconqueso.middleearthextras.block.custom.DampTorchBlock;
import net.mrconqueso.middleearthextras.block.custom.PalantirBlock;
import net.mrconqueso.middleearthextras.block.custom.WallDampTorchBlock;
import net.mrconqueso.middleearthextras.datagen.content.models.SimpleBlockItemModel;

public class ModBlocks {

    public static final Block DAMP_TORCH = registerOnlyBlock("damp_torch",
            new DampTorchBlock(AbstractBlock.Settings.copy(Blocks.TORCH).luminance((state) -> 10).dropsLike(Blocks.TORCH)));
    public static final Block WALL_DAMP_TORCH = registerOnlyBlock("wall_damp_torch",
            new WallDampTorchBlock(AbstractBlock.Settings.copy(Blocks.WALL_TORCH).luminance((state) -> 10).dropsLike(Blocks.TORCH)));

    public static final Block PALANTIR = registerBlockWithItem("palantir",
            new PalantirBlock(AbstractBlock.Settings.copy(Blocks.OBSIDIAN).luminance((state) -> 5)));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(MiddleEarthExtras.MOD_ID, name), block);
    }

    private static Block registerOnlyBlock(String name, Block block) {
        return Registry.register(Registries.BLOCK, Identifier.of(MiddleEarthExtras.MOD_ID, name), block);
    }

    private static Block registerBlockWithItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(MiddleEarthExtras.MOD_ID, name), new BlockItem(block, new Item.Settings()));
        SimpleBlockItemModel.blockItems.add(block.asItem());
        return Registry.register(Registries.BLOCK, Identifier.of(MiddleEarthExtras.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(MiddleEarthExtras.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        MiddleEarthExtras.LOGGER.info("Registering Mod Blocks for " + MiddleEarthExtras.MOD_ID);
    }
}
