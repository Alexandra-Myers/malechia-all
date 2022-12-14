package net.alexandra.malechia.block;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.alexandra.malechia.block.custom.BushBlock;
import net.alexandra.malechia.item.ModItemGroups;
import net.alexandra.malechia.registry.ModRegistries;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;

import java.util.function.Supplier;

import static net.alexandra.malechia.MalechiaMod.MOD_ID;

public class ModBlocks extends ModRegistries {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(MOD_ID, Registry.BLOCK_KEY);
    public static final DeferredRegister<Item> BLOCK_ITEMS = DeferredRegister.create(MOD_ID, Registry.ITEM_KEY);
    public static final Supplier<Block> ETHEREAL_BUSH = registerBlock("ethereal_bush",
            new BushBlock(Block.Settings.copy(Blocks.AZALEA).nonOpaque()), ModItemGroups.MALECHIA_BLOCKS);
    public static final RegistrySupplier<Block> ETHEREAL_LOG = registerBlock("ethereal_log",
            new PillarBlock(Block.Settings.copy(Blocks.CRIMSON_STEM).strength(4.0f).requiresTool()), ModItemGroups.MALECHIA_BLOCKS);
    public static final RegistrySupplier<Block> ETHEREAL_WOOD = registerBlock("ethereal_wood",
            new PillarBlock(Block.Settings.copy(Blocks.CRIMSON_HYPHAE).strength(4.0f).requiresTool()), ModItemGroups.MALECHIA_BLOCKS);
    public static final RegistrySupplier<Block> STRIPPED_ETHEREAL_LOG = registerBlock("stripped_ethereal_log",
            new PillarBlock(Block.Settings.copy(Blocks.STRIPPED_CRIMSON_STEM).strength(4.0f).requiresTool()), ModItemGroups.MALECHIA_BLOCKS);
    public static final RegistrySupplier<Block> STRIPPED_ETHEREAL_WOOD = registerBlock("stripped_ethereal_wood",
            new PillarBlock(Block.Settings.copy(Blocks.STRIPPED_CRIMSON_HYPHAE).strength(4.0f).requiresTool()), ModItemGroups.MALECHIA_BLOCKS);
    public static final RegistrySupplier<Block> FIERY_ETHEREAL_LOG = registerBlock("fiery_ethereal_log",
            new PillarBlock(Block.Settings.copy(Blocks.CRIMSON_STEM).strength(4.0f).requiresTool()), ModItemGroups.MALECHIA_BLOCKS);
    public static final RegistrySupplier<Block> FIERY_ETHEREAL_WOOD = registerBlock("fiery_ethereal_wood",
            new PillarBlock(Block.Settings.copy(Blocks.CRIMSON_HYPHAE).strength(4.0f).requiresTool()), ModItemGroups.MALECHIA_BLOCKS);
    public static final RegistrySupplier<Block> STRIPPED_FIERY_ETHEREAL_LOG = registerBlock("stripped_fiery_ethereal_log",
            new PillarBlock(Block.Settings.copy(Blocks.STRIPPED_CRIMSON_STEM).strength(4.0f).requiresTool()), ModItemGroups.MALECHIA_BLOCKS);
    public static final RegistrySupplier<Block> STRIPPED_FIERY_ETHEREAL_WOOD = registerBlock("stripped_fiery_ethereal_wood",
            new PillarBlock(Block.Settings.copy(Blocks.STRIPPED_CRIMSON_HYPHAE).strength(4.0f).requiresTool()), ModItemGroups.MALECHIA_BLOCKS);
    public static final RegistrySupplier<Block> INFINITY_ETHEREAL_LOG = registerBlock("infinity_ethereal_log",
            new PillarBlock(Block.Settings.copy(Blocks.CRIMSON_STEM).strength(4.0f).requiresTool()), ModItemGroups.MALECHIA_BLOCKS);
    public static final RegistrySupplier<Block> INFINITY_ETHEREAL_WOOD = registerBlock("infinity_ethereal_wood",
            new PillarBlock(Block.Settings.copy(Blocks.CRIMSON_HYPHAE).strength(4.0f).requiresTool()), ModItemGroups.MALECHIA_BLOCKS);
    public static final RegistrySupplier<Block> STRIPPED_INFINITY_ETHEREAL_LOG = registerBlock("stripped_infinity_ethereal_log",
            new PillarBlock(Block.Settings.copy(Blocks.STRIPPED_CRIMSON_STEM).strength(4.0f).requiresTool()), ModItemGroups.MALECHIA_BLOCKS);
    public static final RegistrySupplier<Block> STRIPPED_INFINITY_ETHEREAL_WOOD = registerBlock("stripped_infinity_ethereal_wood",
            new PillarBlock(Block.Settings.copy(Blocks.STRIPPED_CRIMSON_HYPHAE).strength(4.0f).requiresTool()), ModItemGroups.MALECHIA_BLOCKS);
    public static final RegistrySupplier<Block> INFINITY_STAINED_GLASS = registerBlock("infinity_stained_glass",
            new StainedGlassBlock(DyeColor.CYAN, Block.Settings.copy(Blocks.GLASS).strength(3.0f).nonOpaque()), ModItemGroups.MALECHIA_BLOCKS);
    public static final RegistrySupplier<Block> PURE_ETHEREAL_CRYSTAL_BLOCK = registerBlock("pure_ethereal_crystal_block",
            new StainedGlassBlock(DyeColor.WHITE,Block.Settings.copy(Blocks.BEDROCK).strength(-1.0f).nonOpaque().sounds(BlockSoundGroup.AMETHYST_BLOCK)), ModItemGroups.MALECHIA_BLOCKS);
    public static final RegistrySupplier<Block> ETHEREAL_STONE = registerBlock("ethereal_stone",
            new Block(Block.Settings.copy(Blocks.DEEPSLATE).strength(8.0f).requiresTool()), ModItemGroups.MALECHIA_BLOCKS);
    public static final RegistrySupplier<Block> ETHEREAL_LEAVES = registerBlock("ethereal_leaves",
            new LeavesBlock(Block.Settings.copy(Blocks.AZALEA_LEAVES).nonOpaque()), ModItemGroups.MALECHIA_BLOCKS);
    public static final RegistrySupplier<Block> ETHEREAL_PLANKS = registerBlock("ethereal_planks",
            new Block(Block.Settings.copy(Blocks.CRIMSON_PLANKS).strength(6.0f).requiresTool()), ModItemGroups.MALECHIA_BLOCKS);
    public static final RegistrySupplier<Block> FIERY_ETHEREAL_PLANKS = registerBlock("fiery_ethereal_planks",
            new Block(Block.Settings.copy(Blocks.CRIMSON_PLANKS).strength(6.0f).requiresTool()), ModItemGroups.MALECHIA_BLOCKS);
    public static final RegistrySupplier<Block> INFINITY_ETHEREAL_PLANKS = registerBlock("infinity_ethereal_planks",
            new Block(Block.Settings.copy(Blocks.CRIMSON_PLANKS).strength(6.0f).requiresTool()), ModItemGroups.MALECHIA_BLOCKS);
    public static final RegistrySupplier<Block> QUARITE_ORE = registerBlock("quarite_ore",
            new ExperienceDroppingBlock(Block.Settings.of(Material.STONE).strength(20f).requiresTool(),
                    UniformIntProvider.create(2, 6)), ModItemGroups.MALECHIA_BLOCKS);
    public static final RegistrySupplier<Block> MYCRONIUM_ORE = registerBlock("mycronium_ore",
            new ExperienceDroppingBlock(Block.Settings.of(Material.STONE).strength(20f).requiresTool(),
                    UniformIntProvider.create(2, 6)), ModItemGroups.MALECHIA_BLOCKS);;
    public static final RegistrySupplier<Block> DEEPSLATE_MYCRONIUM_ORE = registerBlock("deepslate_mycronium_ore",
            new ExperienceDroppingBlock(Block.Settings.of(Material.STONE).strength(20f).requiresTool(),
                    UniformIntProvider.create(2, 6)), ModItemGroups.MALECHIA_BLOCKS);
    public static final RegistrySupplier<Block> AURAUM_ORE = registerBlock("auraum_ore",
            new ExperienceDroppingBlock(Block.Settings.of(Material.STONE).strength(20f).requiresTool(),
                    UniformIntProvider.create(2, 6)), ModItemGroups.MALECHIA_BLOCKS);
    public static final RegistrySupplier<Block> LOCRONITE_ORE = registerBlock("locronite_ore",
            new ExperienceDroppingBlock(Block.Settings.of(Material.STONE).strength(20f).requiresTool(),
                    UniformIntProvider.create(2, 6)), ModItemGroups.MALECHIA_BLOCKS);
    public static final RegistrySupplier<Block> DEEPSLATE_LOCRONITE_ORE = registerBlock("deepslate_locronite_ore",
            new ExperienceDroppingBlock(Block.Settings.of(Material.STONE).strength(30f).requiresTool(),
                    UniformIntProvider.create(2, 6)), ModItemGroups.MALECHIA_BLOCKS);
    public static final RegistrySupplier<Block> ALOTIC_ORE = registerBlock("alotic_ore",
            new ExperienceDroppingBlock(Block.Settings.of(Material.STONE).strength(20f).requiresTool(),
                    UniformIntProvider.create(2, 6)), ModItemGroups.MALECHIA_BLOCKS);
    public static final RegistrySupplier<Block> ERETH_ORE = registerBlock("ereth_ore",
            new ExperienceDroppingBlock(Block.Settings.of(Material.STONE).strength(20f).requiresTool(),
                    UniformIntProvider.create(2, 6)), ModItemGroups.MALECHIA_BLOCKS);
    public static final RegistrySupplier<Block> DEEPSLATE_ERETH_ORE = registerBlock("deepslate_ereth_ore",
            new ExperienceDroppingBlock(Block.Settings.of(Material.STONE).strength(30f).requiresTool(),
                    UniformIntProvider.create(2, 6)), ModItemGroups.MALECHIA_BLOCKS);
    public static final RegistrySupplier<Block> CHRYON_ORE = registerBlock("chryon_ore",
            new ExperienceDroppingBlock(Block.Settings.of(Material.STONE).strength(20f).requiresTool(),
                    UniformIntProvider.create(2, 6)), ModItemGroups.MALECHIA_BLOCKS);
    public static final RegistrySupplier<Block> HALORIUM_ORE = registerBlock("halorium_ore",
            new ExperienceDroppingBlock(Block.Settings.of(Material.STONE).strength(20f).requiresTool(),
                    UniformIntProvider.create(2, 6)), ModItemGroups.MALECHIA_BLOCKS);
    public static final RegistrySupplier<Block> DEEPSLATE_HALORIUM_ORE = registerBlock("deepslate_halorium_ore",
            new ExperienceDroppingBlock(Block.Settings.of(Material.STONE).strength(30f).requiresTool(),
                    UniformIntProvider.create(2, 6)), ModItemGroups.MALECHIA_BLOCKS);
    public static final RegistrySupplier<Block> LITRIUM_ORE = registerBlock("litrium_ore",
            new ExperienceDroppingBlock(Block.Settings.of(Material.STONE).strength(20f).requiresTool(),
                    UniformIntProvider.create(2, 6)), ModItemGroups.MALECHIA_BLOCKS);
    public static final RegistrySupplier<Block> DEEPSLATE_LITRIUM_ORE = registerBlock("deepslate_litrium_ore",
            new ExperienceDroppingBlock(Block.Settings.of(Material.STONE).strength(30f).requiresTool(),
                    UniformIntProvider.create(2, 6)), ModItemGroups.MALECHIA_BLOCKS);
    public static final RegistrySupplier<Block> ALLIAN_ORE = registerBlock("allian_ore",
            new ExperienceDroppingBlock(Block.Settings.of(Material.STONE).strength(20f).requiresTool(),
                    UniformIntProvider.create(6, 10)), ModItemGroups.MALECHIA_BLOCKS);
    public static final RegistrySupplier<Block> MALECHIA_BLOCK = registerBlock("malechia_block",
            new Block(Block.Settings.of(Material.METAL).strength(100f).requiresTool().luminance(value -> 15)), ModItemGroups.MALECHIA_BLOCKS);
    public static final RegistrySupplier<Block> BOSS_ESSENCE_IRON_BLOCK = registerBlock("boss_essence_iron_block",
            new Block(Block.Settings.of(Material.METAL).strength(50f).requiresTool().luminance(value -> 4)), ModItemGroups.MALECHIA_BLOCKS);
    protected static RegistrySupplier<Block> registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return BLOCKS.register( new Identifier(MOD_ID, name), () -> block);
    }
    protected static RegistrySupplier<Block> registerBlockWithoutItem(String name, Block block) {
        return BLOCKS.register( new Identifier(MOD_ID, name), () -> block);
    }

    private static RegistrySupplier<Item> registerBlockItem(String name, Block block, ItemGroup group) {
        return BLOCK_ITEMS.register( new Identifier(MOD_ID, name), () -> new BlockItem(block, new Item.Settings().group(group)));
    }
    public static void init() {
        BLOCKS.register();
        BLOCK_ITEMS.register();
    }
}
