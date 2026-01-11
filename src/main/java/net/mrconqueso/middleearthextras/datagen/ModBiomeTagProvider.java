package net.mrconqueso.middleearthextras.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.jukoz.me.world.biomes.MEBiomeKeys;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.world.biome.Biome;
import net.mrconqueso.middleearthextras.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBiomeTagProvider extends FabricTagProvider<Biome> {
    public ModBiomeTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, RegistryKeys.BIOME, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModTags.Biomes.DARK_BIOMES)
                .add(MEBiomeKeys.UDUN)
                .add(MEBiomeKeys.EPHEL_DUATH_BASE)
                .add(MEBiomeKeys.EPHEL_DUATH)
                .add(MEBiomeKeys.EPHEL_DUATH_PEAKS)
                .add(MEBiomeKeys.MORDOR)
                .add(MEBiomeKeys.GORGOROTH)
                .add(MEBiomeKeys.GORGOROTH_DELTA)
                .add(MEBiomeKeys.GORGOROTH_ASHEN_WOODS)
                .add(MEBiomeKeys.MOUNT_DOOM)
                .add(MEBiomeKeys.MOUNT_DOOM_PIT)
                .add(MEBiomeKeys.MORGUL_VALE)
                .add(MEBiomeKeys.MORGUL_RIVER)
                .add(MEBiomeKeys.MORGUL_FOREST);
    }
}
