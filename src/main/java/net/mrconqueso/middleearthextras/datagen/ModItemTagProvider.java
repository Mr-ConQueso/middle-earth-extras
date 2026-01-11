package net.mrconqueso.middleearthextras.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.mrconqueso.middleearthextras.datagen.content.models.SimpleRingModel;
import net.mrconqueso.middleearthextras.item.ModGeneralItems;
import net.mrconqueso.middleearthextras.item.ModRingItems;
import net.mrconqueso.middleearthextras.util.ModTags;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
//        getOrCreateTagBuilder(ModTags.Items.TRANSFORMABLE_ITEMS)
//                .add(ModGeneralItems.PINK_GARNET)
//                .add(ModGeneralItems.RAW_PINK_GARNET);

        FabricTagBuilder builder = getOrCreateTagBuilder(ModTags.Items.RING_ITEMS);
        for (Item item : SimpleRingModel.items) {
            builder.add(item);
        }
    }
}
