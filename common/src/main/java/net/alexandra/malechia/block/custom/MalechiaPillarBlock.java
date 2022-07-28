package net.alexandra.malechia.block.custom;

import net.alexandra.malechia.block.ModBlocks;
import net.alexandra.malechia.block.custom.forgeports.IBlock;
import net.alexandra.malechia.block.custom.forgeports.ToolAction;
import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemUsageContext;
import org.jetbrains.annotations.Nullable;

public class MalechiaPillarBlock extends PillarBlock implements IBlock {
    public MalechiaPillarBlock(Settings settings) {
        super(settings);
    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, ItemUsageContext context, ToolAction toolAction, boolean simulate) {
        if(context.getStack().getItem() instanceof AxeItem) {
            if(state.isOf(ModBlocks.ETHEREAL_LOG.get())) {
                return ModBlocks.STRIPPED_ETHEREAL_LOG.get().getDefaultState().with(AXIS, state.get(AXIS));
            }
            if(state.isOf(ModBlocks.ETHEREAL_WOOD.get())) {
                return ModBlocks.STRIPPED_ETHEREAL_WOOD.get().getDefaultState().with(AXIS, state.get(AXIS));
            }
            if(state.isOf(ModBlocks.FIERY_ETHEREAL_LOG.get())) {
                return ModBlocks.STRIPPED_FIERY_ETHEREAL_LOG.get().getDefaultState().with(AXIS, state.get(AXIS));
            }
            if(state.isOf(ModBlocks.FIERY_ETHEREAL_WOOD.get())) {
                return ModBlocks.STRIPPED_FIERY_ETHEREAL_WOOD.get().getDefaultState().with(AXIS, state.get(AXIS));
            }
            if(state.isOf(ModBlocks.INFINITY_ETHEREAL_LOG.get())) {
                return ModBlocks.STRIPPED_INFINITY_ETHEREAL_LOG.get().getDefaultState().with(AXIS, state.get(AXIS));
            }
            if(state.isOf(ModBlocks.INFINITY_ETHEREAL_WOOD.get())) {
                return ModBlocks.STRIPPED_INFINITY_ETHEREAL_WOOD.get().getDefaultState().with(AXIS, state.get(AXIS));
            }
        }
        return IBlock.super.getToolModifiedState(state, context, toolAction, simulate);
    }
}
