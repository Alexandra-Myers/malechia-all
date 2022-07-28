package net.alexandra.malechia.block.custom.forgeports;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.*;
import org.jetbrains.annotations.Nullable;

public interface IBlock {
    public default Block self() {
        return (Block)this;
    }
    @Nullable
    default BlockState getToolModifiedState(BlockState state, ItemUsageContext context, ToolAction toolAction, boolean simulate) {
        ItemStack itemStack = context.getStack();
        return null;
    }
}
