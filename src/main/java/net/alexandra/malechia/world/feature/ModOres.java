package net.alexandra.malechia.world.feature;

import dev.architectury.event.events.common.LifecycleEvent;
import net.alexandra.malechia.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.tag.BiomeTags;
import net.minecraft.util.Holder;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.util.ConfiguredFeatureUtil;
import net.minecraft.world.gen.feature.util.PlacedFeatureUtil;
import org.quiltmc.qsl.worldgen.biome.api.BiomeModifications;
import org.quiltmc.qsl.worldgen.biome.api.BiomeSelectors;

import java.util.List;

import static net.alexandra.malechia.MalechiaMod.MOD_ID;
import static net.minecraft.world.gen.feature.OreConfiguredFeatures.*;

public class ModOres {
    public static final RuleTest END_STONE = new BlockMatchRuleTest(Blocks.END_STONE);

    private static List<PlacementModifier> orePlacementModifiers(PlacementModifier firstModifier, PlacementModifier secondModifier) {
        return List.of(firstModifier, InSquarePlacementModifier.getInstance(), secondModifier, BiomePlacementModifier.getInstance());
    }

    private static List<PlacementModifier> commonOrePlacementModifiers(int count, PlacementModifier modifier) {
        return orePlacementModifiers(CountPlacementModifier.create(count), modifier);
    }

    private static List<PlacementModifier> rareOrePlacementModifiers(int chance, PlacementModifier modifier) {
        return orePlacementModifiers(RarityFilterPlacementModifier.create(chance), modifier);
    }
    public static void initialize() {
        LifecycleEvent.SETUP.register(() -> {
            Holder<ConfiguredFeature<OreFeatureConfig, ?>> ALLIAN_ORE = ConfiguredFeatureUtil.register(MOD_ID + ":allian_ore", Feature.ORE,
                    new OreFeatureConfig(END_STONE, ModBlocks.ALLIAN_ORE.get().getDefaultState(), 4, 0.6f));
            Holder<PlacedFeature> ALLIAN_ORE_PLACED = PlacedFeatureUtil.register(MOD_ID + ":allian_ore_placed", ALLIAN_ORE,
                    rareOrePlacementModifiers(10, PlacedFeatureUtil.TEN_ABOVE_AND_BELOW_RANGE));
            BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES,
                    RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                            ALLIAN_ORE_PLACED.getKey().get().getValue()));
            Holder<ConfiguredFeature<OreFeatureConfig, ?>> ALOTIC_ORE = ConfiguredFeatureUtil.register(MOD_ID + ":alotic_ore", Feature.ORE,
                    new OreFeatureConfig( NETHERRACK, ModBlocks.ALOTIC_ORE.get().getDefaultState(), 8));
            Holder<PlacedFeature> ALOTIC_ORE_PLACED = PlacedFeatureUtil.register(MOD_ID + ":alotic_ore_placed", ALOTIC_ORE,
                    commonOrePlacementModifiers(10, PlacedFeatureUtil.TEN_ABOVE_AND_BELOW_RANGE));
            BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Feature.UNDERGROUND_ORES,
                    RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                            ALOTIC_ORE_PLACED.getKey().get().getValue()));
            Holder<ConfiguredFeature<OreFeatureConfig, ?>> AURAUM_ORE = ConfiguredFeatureUtil.register(MOD_ID + ":auraum_ore", Feature.ORE,
                    new OreFeatureConfig(NETHERRACK, ModBlocks.AURAUM_ORE.get().getDefaultState(), 4, 0.2f));
            Holder<PlacedFeature> AURAUM_ORE_PLACED = PlacedFeatureUtil.register(MOD_ID + ":auraum_ore_placed", AURAUM_ORE,
                    rareOrePlacementModifiers(10, PlacedFeatureUtil.TEN_ABOVE_AND_BELOW_RANGE));
            BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Feature.UNDERGROUND_ORES,
                    RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                            AURAUM_ORE_PLACED.getKey().get().getValue()));
            Holder<ConfiguredFeature<OreFeatureConfig, ?>> CHRYON_ORE = ConfiguredFeatureUtil.register(MOD_ID + ":chryon_ore", Feature.ORE,
                    new OreFeatureConfig(END_STONE, ModBlocks.CHRYON_ORE.get().getDefaultState(), 6, 0.2f));
            Holder<PlacedFeature> CHRYON_ORE_PLACED = PlacedFeatureUtil.register(MOD_ID + ":chryon_ore_placed", CHRYON_ORE,
                    rareOrePlacementModifiers(10, PlacedFeatureUtil.TEN_ABOVE_AND_BELOW_RANGE));
            BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES,
                    RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                            CHRYON_ORE_PLACED.getKey().get().getValue()));
            Holder<ConfiguredFeature<OreFeatureConfig, ?>> QUARITE_ORE = ConfiguredFeatureUtil.register(MOD_ID + ":quarite_ore", Feature.ORE,
                    new OreFeatureConfig(END_STONE, ModBlocks.QUARITE_ORE.get().getDefaultState(), 6, 0.2f));
            Holder<PlacedFeature> QUARITE_ORE_PLACED = PlacedFeatureUtil.register(MOD_ID + ":quarite_ore_placed", QUARITE_ORE,
                    rareOrePlacementModifiers(10, PlacedFeatureUtil.TEN_ABOVE_AND_BELOW_RANGE));
            BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
                    RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                            QUARITE_ORE_PLACED.getKey().get().getValue()));
            final List<OreFeatureConfig.Target> LITRIUM_ORES = List.of(
                    OreFeatureConfig.createTarget(STONE_ORE_REPLACEABLES, ModBlocks.LITRIUM_ORE.get().getDefaultState()), OreFeatureConfig.createTarget(DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_LITRIUM_ORE.get().getDefaultState()));
            Holder<ConfiguredFeature<OreFeatureConfig, ?>> LITRIUM_ORE = ConfiguredFeatureUtil.register(MOD_ID + ":litrium_ore", Feature.ORE,
                    new OreFeatureConfig( LITRIUM_ORES, 8));
            Holder<PlacedFeature> LITRIUM_ORE_PLACED = PlacedFeatureUtil.register(MOD_ID + ":litrium_ore_placed", LITRIUM_ORE,
                    commonOrePlacementModifiers(10, HeightRangePlacementModifier.createUniform(YOffset.getBottom(), YOffset.fixed(72))));
            BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
                    RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                            LITRIUM_ORE_PLACED.getKey().get().getValue()));
            final List<OreFeatureConfig.Target> HALORIUM_ORES = List.of(
                    OreFeatureConfig.createTarget(STONE_ORE_REPLACEABLES, ModBlocks.HALORIUM_ORE.get().getDefaultState()), OreFeatureConfig.createTarget(DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_HALORIUM_ORE.get().getDefaultState()));
            Holder<ConfiguredFeature<OreFeatureConfig, ?>> HALORIUM_ORE = ConfiguredFeatureUtil.register(MOD_ID + ":halorium_ore", Feature.ORE,
                    new OreFeatureConfig( HALORIUM_ORES, 8));
            Holder<PlacedFeature> HALORIUM_ORE_PLACED = PlacedFeatureUtil.register(MOD_ID + ":halorium_ore_placed", HALORIUM_ORE,
                    commonOrePlacementModifiers(10, HeightRangePlacementModifier.createUniform(YOffset.getBottom(), YOffset.fixed(72))));
            BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
                    RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                            HALORIUM_ORE_PLACED.getKey().get().getValue()));
            final List<OreFeatureConfig.Target> ERETH_ORES = List.of(
                    OreFeatureConfig.createTarget(STONE_ORE_REPLACEABLES, ModBlocks.ERETH_ORE.get().getDefaultState()), OreFeatureConfig.createTarget(DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_ERETH_ORE.get().getDefaultState()));
            Holder<ConfiguredFeature<OreFeatureConfig, ?>> ERETH_ORE = ConfiguredFeatureUtil.register(MOD_ID + ":ereth_ore", Feature.ORE,
                    new OreFeatureConfig( ERETH_ORES, 8));
            Holder<PlacedFeature> ERETH_ORE_PLACED = PlacedFeatureUtil.register(MOD_ID + ":ereth_ore_placed", ERETH_ORE,
                    commonOrePlacementModifiers(10, HeightRangePlacementModifier.createUniform(YOffset.getBottom(), YOffset.fixed(72))));
            BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
                    RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                            ERETH_ORE_PLACED.getKey().get().getValue()));
            final List<OreFeatureConfig.Target> LOCRONITE_ORES = List.of(
                    OreFeatureConfig.createTarget(STONE_ORE_REPLACEABLES, ModBlocks.LOCRONITE_ORE.get().getDefaultState()), OreFeatureConfig.createTarget(DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_LOCRONITE_ORE.get().getDefaultState()));
            Holder<ConfiguredFeature<OreFeatureConfig, ?>> LOCRONITE_ORE = ConfiguredFeatureUtil.register(MOD_ID + ":locronite_ore", Feature.ORE,
                    new OreFeatureConfig( LOCRONITE_ORES, 8));
            Holder<PlacedFeature> LOCRONITE_ORE_PLACED = PlacedFeatureUtil.register(MOD_ID + ":locronite_ore_placed", LOCRONITE_ORE,
                    commonOrePlacementModifiers(10, HeightRangePlacementModifier.createUniform(YOffset.getBottom(), YOffset.fixed(72))));
            BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
                    RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                            LOCRONITE_ORE_PLACED.getKey().get().getValue()));
            final List<OreFeatureConfig.Target> MYCRONIUM_ORES = List.of(
                    OreFeatureConfig.createTarget(STONE_ORE_REPLACEABLES, ModBlocks.MYCRONIUM_ORE.get().getDefaultState()), OreFeatureConfig.createTarget(DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_MYCRONIUM_ORE.get().getDefaultState()));
            Holder<ConfiguredFeature<OreFeatureConfig, ?>> MYCRONIUM_ORE = ConfiguredFeatureUtil.register(MOD_ID + ":mycronium_ore", Feature.ORE,
                    new OreFeatureConfig( MYCRONIUM_ORES, 8));
            Holder<PlacedFeature> MYCRONIUM_ORE_PLACED = PlacedFeatureUtil.register(MOD_ID + ":mycronium_ore_placed", MYCRONIUM_ORE,
                    commonOrePlacementModifiers(10, HeightRangePlacementModifier.createUniform(YOffset.getBottom(), YOffset.fixed(72))));
            BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
                    RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                            MYCRONIUM_ORE_PLACED.getKey().get().getValue()));
        });
    }
}
