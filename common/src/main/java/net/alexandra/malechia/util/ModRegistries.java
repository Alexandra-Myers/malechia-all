package net.alexandra.malechia.util;

import dev.architectury.injectables.annotations.PlatformOnly;
import net.alexandra.malechia.block.ModBlocks;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;

public class ModRegistries {
    public static void registerModStuffs() {
        registerStrippables();
    }

    @PlatformOnly("Quilt")
    private static void registerStrippables() {
        StrippableBlockRegistry.register(ModBlocks.ETHEREAL_LOG.get(), ModBlocks.STRIPPED_ETHEREAL_LOG.get());
        StrippableBlockRegistry.register(ModBlocks.ETHEREAL_WOOD.get(), ModBlocks.STRIPPED_ETHEREAL_WOOD.get());
        StrippableBlockRegistry.register(ModBlocks.FIERY_ETHEREAL_LOG.get(), ModBlocks.STRIPPED_FIERY_ETHEREAL_LOG.get());
        StrippableBlockRegistry.register(ModBlocks.FIERY_ETHEREAL_WOOD.get(), ModBlocks.STRIPPED_FIERY_ETHEREAL_WOOD.get());
        StrippableBlockRegistry.register(ModBlocks.INFINITY_ETHEREAL_LOG.get(), ModBlocks.STRIPPED_INFINITY_ETHEREAL_LOG.get());
        StrippableBlockRegistry.register(ModBlocks.INFINITY_ETHEREAL_WOOD.get(), ModBlocks.STRIPPED_INFINITY_ETHEREAL_WOOD.get());
    }

}