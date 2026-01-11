package net.mrconqueso.middleearthextras.compat;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import java.util.Locale;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * For compatibility with and without another mod present, we have to define load conditions of the specific code
 */
public enum Mods {
    TRINKETS,
    ACCESSORIES,
    MODMENU,
    EMI,
    LAMBDYNLIGHTS_API;

    private final String id;
    private final boolean loaded;

    Mods() {
        id = name().toLowerCase(Locale.ROOT);
        loaded = FabricLoader.getInstance().isModLoaded(id);
    }

    /**
     * @return the mod id
     */
    public String id() {
        return id;
    }

    public Identifier rl(String path) {
        return Identifier.of(id, path);
    }

    public Block getBlock(String id) {
        return Registries.BLOCK.get(rl(id));
    }

    public Item getItem(String id) {
        return Registries.ITEM.get(rl(id));
    }

    public boolean contains(ItemConvertible entry) {
        if (!isLoaded())
            return false;
        Item asItem = entry.asItem();
        return asItem != null && Registries.ITEM.getId(asItem)
                .getNamespace()
                .equals(id);
    }

    /**
     * @return a boolean of whether the mod is loaded or not based on mod id
     */
    public boolean isLoaded() {
        return loaded;
    }

    /**
     * Simple hook to run code if a mod is installed
     *
     * @param toRun will be run only if the mod is loaded
     * @return Optional.empty() if the mod is not loaded, otherwise an Optional of the return value of the given supplier
     */
    public <T> Optional<T> runIfInstalled(Supplier<Supplier<T>> toRun) {
        if (isLoaded())
            return Optional.of(toRun.get().get());
        return Optional.empty();
    }

    /**
     * Simple hook to execute code if a mod is installed
     *
     * @param toExecute will be executed only if the mod is loaded
     */
    public void executeIfInstalled(Supplier<Runnable> toExecute) {
        if (isLoaded()) {
            toExecute.get().run();
        }
    }
}