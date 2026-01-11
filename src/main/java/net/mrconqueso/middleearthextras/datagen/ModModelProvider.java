package net.mrconqueso.middleearthextras.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.jukoz.me.datageneration.content.CustomItemModels;
import net.minecraft.data.client.*;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.mrconqueso.middleearthextras.MiddleEarthExtras;
import net.mrconqueso.middleearthextras.block.ModBlocks;
import net.mrconqueso.middleearthextras.datagen.content.models.SimpleItemModel;
import net.mrconqueso.middleearthextras.datagen.content.models.SimpleRingModel;
import net.mrconqueso.middleearthextras.datagen.content.models.SimpleSpawnEggModel;
import net.mrconqueso.middleearthextras.item.ModGeneralItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

        generateTorch(blockStateModelGenerator);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

        itemModelGenerator.register(ModGeneralItems.MAGIC_PIPE, "_inventory", Models.HANDHELD);

        for (Item item : SimpleItemModel.items) {
            if (Registries.ITEM.getId(item).equals(Registries.ITEM.getDefaultId())) {
                MiddleEarthExtras.LOGGER.warn("Skipping model generation for unregistered simple item: " + item);
                continue;
            }
            itemModelGenerator.register(item, Models.GENERATED);
        }

        for (Item item : SimpleRingModel.items) {
            if (Registries.ITEM.getId(item).equals(Registries.ITEM.getDefaultId())) {
                MiddleEarthExtras.LOGGER.warn("Skipping model generation for unregistered ring item: " + item);
                continue;
            }
            registerRingModel(itemModelGenerator, item);
        }

        for (Item item : SimpleSpawnEggModel.items) {
            if (Registries.ITEM.getId(item).equals(Registries.ITEM.getDefaultId())) {
                MiddleEarthExtras.LOGGER.warn("Skipping model generation for unregistered egg item: " + item);
                continue;
            }
            itemModelGenerator.register(item, CustomItemModels.TEMPLATE_SPAWN_EGG);
        }
    }

    private void registerRingModel(ItemModelGenerator itemModelGenerator, Item ring) {
        Identifier id = Registries.ITEM.getId(ring);
        Models.GENERATED.upload(ModelIds.getItemModelId(ring),
                TextureMap.layer0(Identifier.of(MiddleEarthExtras.MOD_ID,
                        "item/rings/ring_" + id.getPath())),
                itemModelGenerator.writer);
    }

    private void generateTorch(BlockStateModelGenerator blockStateModelGenerator) {
        Identifier vanillaTorchModel = Identifier.ofVanilla("block/torch");
        Identifier vanillaWallTorchModel = Identifier.ofVanilla("block/wall_torch");

        blockStateModelGenerator.blockStateCollector.accept(
                VariantsBlockStateSupplier.create(ModBlocks.WALL_DAMP_TORCH)
                        .coordinate(BlockStateVariantMap.create(Properties.HORIZONTAL_FACING)
                                        .register(Direction.NORTH, BlockStateVariant.create().put(VariantSettings.MODEL, vanillaWallTorchModel).put(VariantSettings.Y, VariantSettings.Rotation.R270))
                                        .register(Direction.EAST, BlockStateVariant.create().put(VariantSettings.MODEL, vanillaWallTorchModel).put(VariantSettings.Y, VariantSettings.Rotation.R0))
                                        .register(Direction.SOUTH, BlockStateVariant.create().put(VariantSettings.MODEL, vanillaWallTorchModel).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                                        .register(Direction.WEST, BlockStateVariant.create().put(VariantSettings.MODEL, vanillaWallTorchModel).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                        )
        );

        blockStateModelGenerator.blockStateCollector.accept(
                VariantsBlockStateSupplier.create(ModBlocks.DAMP_TORCH, BlockStateVariant.create().put(VariantSettings.MODEL, vanillaTorchModel))
        );

        blockStateModelGenerator.registerParentedItemModel(ModBlocks.DAMP_TORCH, Identifier.ofVanilla("item/torch"));
    }
}
