package net.mrconqueso.middleearthextras.item.utils;

import net.jukoz.me.item.items.PipeItem;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.mrconqueso.middleearthextras.item.ModGeneralItems;

public class ModModelPredicateProvider {

    public static void registerAllPredicates(){
        registerPipeModels();
    }

    private static void registerPipeModels() {
        registerPipeModel(ModGeneralItems.MAGIC_PIPE);
    }

    private static void registerPipeModel(Item pipe){
        ModelPredicateProviderRegistry.register(pipe, Identifier.of("smoking"),
                (stack, world, entity, seed) -> {
                    if (stack.getItem() instanceof PipeItem pipeItem) {
                        return pipeItem.isSmoking() ? 1.0F : 0.0F;
                    }
                    return 0.0F;
                });
    }
}
