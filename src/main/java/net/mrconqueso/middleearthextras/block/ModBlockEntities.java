package net.mrconqueso.middleearthextras.block;

import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.mrconqueso.middleearthextras.MiddleEarthExtras;
import net.mrconqueso.middleearthextras.block.entity.PalantirBlockEntity;

public class ModBlockEntities {

    public static final BlockEntityType<PalantirBlockEntity> PALANTIR = Registry.register(Registries.BLOCK_ENTITY_TYPE,
            Identifier.of(MiddleEarthExtras.MOD_ID, "palantir"), BlockEntityType.Builder.create(
                    PalantirBlockEntity::new, ModBlocks.PALANTIR).build(null));

    public static void registerModBlockEntities() {
        MiddleEarthExtras.LOGGER.info("Registering Mod BlockEntities for " + MiddleEarthExtras.MOD_ID);
    }
}
