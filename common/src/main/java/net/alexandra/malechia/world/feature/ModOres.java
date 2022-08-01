package net.alexandra.malechia.world.feature;

import com.google.common.base.Suppliers;
import dev.architectury.event.events.common.LifecycleEvent;
import dev.architectury.registry.level.biome.BiomeModifications;
import net.alexandra.malechia.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.tag.BiomeTags;
import net.minecraft.util.Holder;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.HeightRangePlacementModifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.util.ConfiguredFeatureUtil;
import net.minecraft.world.gen.feature.util.PlacedFeatureUtil;

import java.util.List;
import java.util.function.Supplier;

import static net.alexandra.malechia.MalechiaMod.MOD_ID;
import static net.alexandra.malechia.world.feature.ModOreFeatures.commonOrePlacementModifiers;
import static net.alexandra.malechia.world.feature.ModOreFeatures.rareOrePlacementModifiers;
import static net.minecraft.world.gen.feature.OreConfiguredFeatures.*;

public class ModOres {
    public static final RuleTest END_STONE = new BlockMatchRuleTest(Blocks.END_STONE);
    public static void initialize() {
        LifecycleEvent.SETUP.register(() -> {
            Holder<ConfiguredFeature<OreFeatureConfig, ?>> ALLIAN_ORE = ConfiguredFeatureUtil.register(MOD_ID + ":allian_ore", Feature.ORE,
                    new OreFeatureConfig(END_STONE, ModBlocks.ALLIAN_ORE.get().getDefaultState(), 4, 0.6f));
            Holder<PlacedFeature> ALLIAN_ORE_PLACED = PlacedFeatureUtil.register(MOD_ID + ":allian_ore_placed", ALLIAN_ORE,
                    rareOrePlacementModifiers(6, HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-80), YOffset.aboveBottom(100))));
            registerEndOre(ALLIAN_ORE_PLACED);
            Holder<ConfiguredFeature<OreFeatureConfig, ?>> ALOTIC_ORE = ConfiguredFeatureUtil.register(MOD_ID + ":alotic_ore", Feature.ORE,
                    new OreFeatureConfig( NETHERRACK, ModBlocks.ALOTIC_ORE.get().getDefaultState(), 8));
            Holder<PlacedFeature> ALOTIC_ORE_PLACED = PlacedFeatureUtil.register(MOD_ID + ":alotic_ore_placed", ALOTIC_ORE,
                    commonOrePlacementModifiers(6, HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-64), YOffset.aboveBottom(80))));
            registerNetherOre(ALOTIC_ORE_PLACED);
            Holder<ConfiguredFeature<OreFeatureConfig, ?>> AURAUM_ORE = ConfiguredFeatureUtil.register(MOD_ID + ":auraum_ore", Feature.ORE,
                    new OreFeatureConfig(NETHERRACK, ModBlocks.AURAUM_ORE.get().getDefaultState(), 4, 0.2f));
            Holder<PlacedFeature> AURAUM_ORE_PLACED = PlacedFeatureUtil.register(MOD_ID + ":auraum_ore_placed", AURAUM_ORE,
                    rareOrePlacementModifiers(6, HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-16), YOffset.aboveBottom(100))));
            registerNetherOre(AURAUM_ORE_PLACED);
            Holder<ConfiguredFeature<OreFeatureConfig, ?>> CHRYON_ORE = ConfiguredFeatureUtil.register(MOD_ID + ":chryon_ore", Feature.ORE,
                    new OreFeatureConfig(END_STONE, ModBlocks.CHRYON_ORE.get().getDefaultState(), 6, 0.2f));
            Holder<PlacedFeature> CHRYON_ORE_PLACED = PlacedFeatureUtil.register(MOD_ID + ":chryon_ore_placed", CHRYON_ORE,
                    rareOrePlacementModifiers(6, HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-32), YOffset.aboveBottom(100))));
            registerEndOre(CHRYON_ORE_PLACED);
            Holder<ConfiguredFeature<OreFeatureConfig, ?>> QUARITE_ORE = ConfiguredFeatureUtil.register(MOD_ID + ":quarite_ore", Feature.ORE,
                    new OreFeatureConfig(END_STONE, ModBlocks.QUARITE_ORE.get().getDefaultState(), 6, 0.2f));
            Holder<PlacedFeature> QUARITE_ORE_PLACED = PlacedFeatureUtil.register(MOD_ID + ":quarite_ore_placed", QUARITE_ORE,
                    rareOrePlacementModifiers(6, HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-16), YOffset.aboveBottom(100))));
            registerEndOre(QUARITE_ORE_PLACED);
            final List<OreFeatureConfig.Target> LITRIUM_ORES = List.of(
                    OreFeatureConfig.createTarget(STONE_ORE_REPLACEABLES, ModBlocks.LITRIUM_ORE.get().getDefaultState()), OreFeatureConfig.createTarget(DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_LITRIUM_ORE.get().getDefaultState()));
            Holder<ConfiguredFeature<OreFeatureConfig, ?>> LITRIUM_ORE = ConfiguredFeatureUtil.register(MOD_ID + ":litrium_ore", Feature.ORE,
                    new OreFeatureConfig( LITRIUM_ORES, 8));
            Holder<PlacedFeature> LITRIUM_ORE_PLACED = PlacedFeatureUtil.register(MOD_ID + ":litrium_ore_placed", LITRIUM_ORE,
                    commonOrePlacementModifiers(6, HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-64), YOffset.aboveBottom(80))));
            registerOverworldOre(LITRIUM_ORE_PLACED);
            final List<OreFeatureConfig.Target> HALORIUM_ORES = List.of(
                    OreFeatureConfig.createTarget(STONE_ORE_REPLACEABLES, ModBlocks.HALORIUM_ORE.get().getDefaultState()), OreFeatureConfig.createTarget(DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_HALORIUM_ORE.get().getDefaultState()));
            Holder<ConfiguredFeature<OreFeatureConfig, ?>> HALORIUM_ORE = ConfiguredFeatureUtil.register(MOD_ID + ":halorium_ore", Feature.ORE,
                    new OreFeatureConfig( HALORIUM_ORES, 8));
            Holder<PlacedFeature> HALORIUM_ORE_PLACED = PlacedFeatureUtil.register(MOD_ID + ":halorium_ore_placed", HALORIUM_ORE,
                    commonOrePlacementModifiers(6, HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-64), YOffset.aboveBottom(80))));
            registerOverworldOre(HALORIUM_ORE_PLACED);
            final List<OreFeatureConfig.Target> ERETH_ORES = List.of(
                    OreFeatureConfig.createTarget(STONE_ORE_REPLACEABLES, ModBlocks.ERETH_ORE.get().getDefaultState()), OreFeatureConfig.createTarget(DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_ERETH_ORE.get().getDefaultState()));
            Holder<ConfiguredFeature<OreFeatureConfig, ?>> ERETH_ORE = ConfiguredFeatureUtil.register(MOD_ID + ":ereth_ore", Feature.ORE,
                    new OreFeatureConfig( ERETH_ORES, 8));
            Holder<PlacedFeature> ERETH_ORE_PLACED = PlacedFeatureUtil.register(MOD_ID + ":ereth_ore_placed", ERETH_ORE,
                    commonOrePlacementModifiers(6, HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-64), YOffset.aboveBottom(80))));
            registerOverworldOre(ERETH_ORE_PLACED);
            final List<OreFeatureConfig.Target> LOCRONITE_ORES = List.of(
                    OreFeatureConfig.createTarget(STONE_ORE_REPLACEABLES, ModBlocks.LOCRONITE_ORE.get().getDefaultState()), OreFeatureConfig.createTarget(DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_LOCRONITE_ORE.get().getDefaultState()));
            Holder<ConfiguredFeature<OreFeatureConfig, ?>> LOCRONITE_ORE = ConfiguredFeatureUtil.register(MOD_ID + ":locronite_ore", Feature.ORE,
                    new OreFeatureConfig( LOCRONITE_ORES, 8));
            Holder<PlacedFeature> LOCRONITE_ORE_PLACED = PlacedFeatureUtil.register(MOD_ID + ":locronite_ore_placed", LOCRONITE_ORE,
                    commonOrePlacementModifiers(6, HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-64), YOffset.aboveBottom(80))));
            registerOverworldOre(LOCRONITE_ORE_PLACED);
            final List<OreFeatureConfig.Target> MYCRONIUM_ORES = List.of(
                    OreFeatureConfig.createTarget(STONE_ORE_REPLACEABLES, ModBlocks.MYCRONIUM_ORE.get().getDefaultState()), OreFeatureConfig.createTarget(DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_MYCRONIUM_ORE.get().getDefaultState()));
            Holder<ConfiguredFeature<OreFeatureConfig, ?>> MYCRONIUM_ORE = ConfiguredFeatureUtil.register(MOD_ID + ":mycronium_ore", Feature.ORE,
                    new OreFeatureConfig( MYCRONIUM_ORES, 8));
            Holder<PlacedFeature> MYCRONIUM_ORE_PLACED = PlacedFeatureUtil.register(MOD_ID + ":mycronium_ore_placed", MYCRONIUM_ORE,
                    commonOrePlacementModifiers(6, HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-64), YOffset.aboveBottom(80))));
            registerOverworldOre(MYCRONIUM_ORE_PLACED);
        });
    }
    public static void registerOverworldOre(Holder<PlacedFeature> feature){
        BiomeModifications.addProperties((ctx, mutable) -> {
            if (ctx.hasTag(BiomeTags.IS_OVERWORLD)) {
                mutable.getGenerationProperties().addFeature(GenerationStep.Feature.UNDERGROUND_ORES, feature);
            }
        });
    }
    public static void registerNetherOre(Holder<PlacedFeature> feature){
        BiomeModifications.addProperties((ctx, mutable) -> {
            if (ctx.hasTag(BiomeTags.IS_NETHER)) {
                mutable.getGenerationProperties().addFeature(GenerationStep.Feature.UNDERGROUND_ORES, feature);
            }
        });
    }
    public static void registerEndOre(Holder<PlacedFeature> feature){
        BiomeModifications.addProperties((ctx, mutable) -> {
            if (ctx.hasTag(BiomeTags.IS_END)) {
                mutable.getGenerationProperties().addFeature(GenerationStep.Feature.UNDERGROUND_ORES, feature);
            }
        });
    }
}
