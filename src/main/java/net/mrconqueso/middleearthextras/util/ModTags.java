package net.mrconqueso.middleearthextras.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.mrconqueso.middleearthextras.MiddleEarthExtras;

public class ModTags {
    public static class Blocks {

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(MiddleEarthExtras.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> RING_ITEMS = createTag("ring_items");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(MiddleEarthExtras.MOD_ID, name));
        }
    }

    public static class Biomes {
        public static final TagKey<Biome> DARK_BIOMES = createTag("dark_biomes");

        private static TagKey<Biome> createTag(String name) {
            return TagKey.of(RegistryKeys.BIOME, Identifier.of(MiddleEarthExtras.MOD_ID, name));
        }
    }
}
