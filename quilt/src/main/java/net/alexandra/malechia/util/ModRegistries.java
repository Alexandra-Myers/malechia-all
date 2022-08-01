package net.alexandra.malechia.util;

import net.alexandra.malechia.block.QuiltOnlyBlocks;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;

public class ModRegistries {
    public static void registerModStuffs() {
        registerStrippables();
    }

    private static void registerStrippables() {
        StrippableBlockRegistry.register(QuiltOnlyBlocks.ETHEREAL_LOG.get(), QuiltOnlyBlocks.STRIPPED_ETHEREAL_LOG.get());
        StrippableBlockRegistry.register(QuiltOnlyBlocks.ETHEREAL_WOOD.get(), QuiltOnlyBlocks.STRIPPED_ETHEREAL_WOOD.get());
        StrippableBlockRegistry.register(QuiltOnlyBlocks.FIERY_ETHEREAL_LOG.get(), QuiltOnlyBlocks.STRIPPED_FIERY_ETHEREAL_LOG.get());
        StrippableBlockRegistry.register(QuiltOnlyBlocks.FIERY_ETHEREAL_WOOD.get(), QuiltOnlyBlocks.STRIPPED_FIERY_ETHEREAL_WOOD.get());
        StrippableBlockRegistry.register(QuiltOnlyBlocks.INFINITY_ETHEREAL_LOG.get(), QuiltOnlyBlocks.STRIPPED_INFINITY_ETHEREAL_LOG.get());
        StrippableBlockRegistry.register(QuiltOnlyBlocks.INFINITY_ETHEREAL_WOOD.get(), QuiltOnlyBlocks.STRIPPED_INFINITY_ETHEREAL_WOOD.get());
    }

}