package net.alexandra.malechia.block.custom;

import net.alexandra.malechia.block.ModBlocks;
import net.minecraft.block.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.random.RandomGenerator;
import net.minecraft.world.BlockView;

public class BushBlock extends AzaleaBlock {
	public static final EtherealSaplingGenerator ETHEREAL_GENERATOR = new EtherealSaplingGenerator();

	public BushBlock(Settings settings) {
		super(settings);
	}

	@Override
	protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
			return floor.isOf(ModBlocks.ETHEREAL_STONE.get()) || super.canPlantOnTop(floor, world, pos);
	}

	@Override
	public boolean isFertilizable(BlockView world, BlockPos pos, BlockState state, boolean isClient) {
		return true;
	}

	@Override
	public void grow(ServerWorld world, RandomGenerator random, BlockPos pos, BlockState state) {
			ETHEREAL_GENERATOR.generate(world, world.getChunkManager().getChunkGenerator(), pos, state, random);
	}
}
