package net.alexandra.malechia.registry;

import net.alexandra.malechia.block.ModBlocks;
import net.alexandra.malechia.item.ModItems;
import net.alexandra.malechia.mixin.ComposterBlockMixin;

public class ComposterRegistry {
    public static void init() {
        ComposterBlockMixin.registerCompostableItem(0.3f, ModBlocks.ETHEREAL_LEAVES.get());
        ComposterBlockMixin.registerCompostableItem(0.65f, ModBlocks.ETHEREAL_BUSH.get());
        ComposterBlockMixin.registerCompostableItem(1.0f, ModItems.BOSS_ESSENCE.get());
    }
}
