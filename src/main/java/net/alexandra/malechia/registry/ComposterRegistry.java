package net.alexandra.malechia.registry;

import net.alexandra.malechia.block.ModBlocks;
import net.alexandra.malechia.item.ModItems;
import net.minecraft.block.ComposterBlock;

public class ComposterRegistry {
    public static void init() {
        ComposterBlock.registerCompostableItem(0.3f, ModBlocks.ETHEREAL_LEAVES.get());
        ComposterBlock.registerCompostableItem(0.65f, ModBlocks.ETHEREAL_BUSH.get());
        ComposterBlock.registerCompostableItem(1.0f, ModItems.BOSS_ESSENCE.get());
    }
}
