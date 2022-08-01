package net.alexandra.malechia.item;

import dev.architectury.hooks.item.tool.AxeItemHooks;
import net.alexandra.malechia.block.ModBlocks;

public class BlockInteractions {
    private BlockInteractions() {

    }

    public static void init() {
        AxeItemHooks.addStrippable(ModBlocks.ETHEREAL_LOG.get(), ModBlocks.STRIPPED_ETHEREAL_LOG.get());
        AxeItemHooks.addStrippable(ModBlocks.ETHEREAL_WOOD.get(), ModBlocks.STRIPPED_ETHEREAL_WOOD.get());
        AxeItemHooks.addStrippable(ModBlocks.FIERY_ETHEREAL_LOG.get(), ModBlocks.STRIPPED_FIERY_ETHEREAL_LOG.get());
        AxeItemHooks.addStrippable(ModBlocks.FIERY_ETHEREAL_WOOD.get(), ModBlocks.STRIPPED_FIERY_ETHEREAL_WOOD.get());
        AxeItemHooks.addStrippable(ModBlocks.INFINITY_ETHEREAL_LOG.get(), ModBlocks.STRIPPED_INFINITY_ETHEREAL_LOG.get());
        AxeItemHooks.addStrippable(ModBlocks.INFINITY_ETHEREAL_WOOD.get(), ModBlocks.STRIPPED_INFINITY_ETHEREAL_WOOD.get());
    }
}
