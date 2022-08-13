package net.alexandra.malechia.world.gen;


import dev.architectury.registry.level.biome.BiomeModifications;
import net.alexandra.malechia.block.ModBlocks;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Holder;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.feature.util.ConfiguredFeatureUtil;
import net.minecraft.world.gen.feature.util.PlacedFeatureUtil;
import net.minecraft.world.gen.foliage.RandomSpreadFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.BendingTrunkPlacer;

import java.util.List;

import static net.alexandra.malechia.MalechiaMod.MOD_ID;
import static net.alexandra.malechia.world.biome.MalechiaBuiltinBiomes.ETHEREAL_CORE;
import static net.minecraft.world.gen.feature.VegetationPlacedFeatures.treePlacementModifiers;

public class ModTreeGeneration {
    public static Holder<ConfiguredFeature<TreeFeatureConfig, ?>> ETHEREAL_TREE;
    public static Holder<PlacedFeature> ETHEREAL_TREE_CHECKED;
    public static Holder<ConfiguredFeature<RandomFeatureConfig, ?>> ETHEREAL_TREES;
    public static Holder<PlacedFeature> ETHEREAL_TREE_PLACED;
    public static void generateTrees() {
        ETHEREAL_TREE = ConfiguredFeatureUtil.register(MOD_ID + ":ethereal_tree", Feature.TREE,
                new TreeFeatureConfig.Builder(
                        BlockStateProvider.of(ModBlocks.ETHEREAL_LOG.get()),
                        new BendingTrunkPlacer(4, 2, 0, 3, UniformIntProvider.create(1, 2)),
                        BlockStateProvider.of(ModBlocks.ETHEREAL_LEAVES.get()),
                        new RandomSpreadFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), ConstantIntProvider.create(2), 50),
                        new TwoLayersFeatureSize(1, 0, 1)
                )
                        .dirtProvider(BlockStateProvider.of(ModBlocks.ETHEREAL_STONE.get()))
                        .forceDirt()
                        .build());
        ETHEREAL_TREE_CHECKED = PlacedFeatureUtil.register(MOD_ID + ":ethereal_tree_checked", ETHEREAL_TREE,
                PlacedFeatureUtil.createWouldSurvivePlacementModifier(ModBlocks.ETHEREAL_BUSH.get()));
        ETHEREAL_TREES = ConfiguredFeatureUtil.register(MOD_ID + ":ethereal_trees", Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(List.of(new WeightedPlacedFeature(ETHEREAL_TREE_CHECKED, 0.6F)), ETHEREAL_TREE_CHECKED)
        );
        ETHEREAL_TREE_PLACED = PlacedFeatureUtil.register(MOD_ID + ":ethereal_tree_placed", ETHEREAL_TREES, treePlacementModifiers(PlacedFeatureUtil.createCountExtraModifier(1,0.5f, 2)));

        BiomeModifications.addProperties((ctx, mutable) -> {
            if (ctx.hasTag(TagKey.of(ETHEREAL_CORE.getRegistryKey(), ETHEREAL_CORE.getId()))) {
                mutable.getGenerationProperties().addFeature(GenerationStep.Feature.UNDERGROUND_ORES, ETHEREAL_TREE_PLACED);
            }
        });
    }
}
