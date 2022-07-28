package net.alexandra.malechia.block.custom;

import net.alexandra.malechia.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.GrassBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.random.RandomGenerator;
import net.minecraft.world.WorldView;

public class EtherealGrassBlock extends GrassBlock {
	public EtherealGrassBlock(Settings settings) {
		super(settings);
	}
	public static boolean canSpread(BlockState state, WorldView world, BlockPos pos) {
		return canSurvive(state, world, pos);
	}
	@Override
	public void randomTick(BlockState state, ServerWorld world, BlockPos pos, RandomGenerator random) {
			if (!canSurvive(state, world, pos)) {
				world.setBlockState(pos, ModBlocks.ETHEREAL_DIRT.get().getDefaultState());
			} else {
				if (world.getLightLevel(pos.up()) >= 9) {
					BlockState blockState = ModBlocks.ETHEREAL_GRASS_BLOCK.get().getDefaultState();

					for (int i = 0; i < 4; ++i) {
						BlockPos blockPos = pos.add(random.nextInt(3) - 1, random.nextInt(5) - 3, random.nextInt(3) - 1);
						if (world.getBlockState(blockPos).isOf(ModBlocks.ETHEREAL_DIRT.get()) && canSpread(blockState, world, blockPos)) {
							world.setBlockState(blockPos, blockState.with(SNOWY, Boolean.valueOf(world.getBlockState(blockPos.up()).isOf(Blocks.SNOW))));
						}
					}
				}

			}
	}
}
