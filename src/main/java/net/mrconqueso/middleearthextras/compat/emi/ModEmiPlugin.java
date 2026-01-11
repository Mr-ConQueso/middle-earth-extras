package net.mrconqueso.middleearthextras.compat.emi;

import dev.emi.emi.api.EmiPlugin;
import dev.emi.emi.api.EmiRegistry;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.input.RecipeInput;

public class ModEmiPlugin implements EmiPlugin {
    @Override
    public void register(EmiRegistry emiRegistry) {

    }

    public static void init() {

    }

    private static <C extends RecipeInput, T extends Recipe<C>> Iterable<T> getRecipes(EmiRegistry registry, RecipeType<T> type) {
        return registry.getRecipeManager().listAllOfType(type).stream().map(e -> e.value())::iterator;
    }
}
