package net.alexandra.malechia.registry;

import com.google.common.base.Suppliers;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.Registries;
import dev.architectury.registry.registries.RegistrySupplier;
import net.alexandra.malechia.MalechiaMod;
import net.alexandra.malechia.block.custom.BushBlock;
import net.alexandra.malechia.block.custom.EtherealGrassBlock;
import net.alexandra.malechia.effects.BossPower;
import net.alexandra.malechia.effects.NoClip;
import net.alexandra.malechia.effects.Protected;
import net.alexandra.malechia.effects.WeakArmour;
import net.alexandra.malechia.enchantments.AutoSmelt;
import net.alexandra.malechia.enchantments.HerosEdge;
import net.alexandra.malechia.item.*;
import net.alexandra.malechia.item.custom.*;
import net.alexandra.malechia.item.custom.HoeItem;
import net.alexandra.malechia.world.biome.EtherealBiomeCreator;
import net.minecraft.block.*;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;

import java.util.function.Supplier;

import static net.alexandra.malechia.MalechiaMod.MOD_ID;

public class ModRegistries {
    public static final Supplier<Registries> REGISTRIES = Suppliers.memoize(() -> Registries.get(MOD_ID));
    public static final Registrar<Item> ITEMS = REGISTRIES.get().get(Registry.ITEM_KEY);
    public static final Registrar<Block> BLOCKS = REGISTRIES.get().get(Registry.BLOCK_KEY);
    public static final Registrar<StatusEffect> EFFECTS = REGISTRIES.get().get(Registry.MOB_EFFECT_KEY);
    public static final Registrar<Enchantment> ENCHANTMENT = REGISTRIES.get().get(Registry.ENCHANTMENT_KEY);
    public static final Registrar<Biome> BIOMES = REGISTRIES.get().get(Registry.BIOME_KEY);
    public static final RegistrySupplier<StatusEffect> BOSS_POWER = registerEffect("boss_power", new BossPower().addAttributeModifier(EntityAttributes.GENERIC_ATTACK_DAMAGE, "648D7064-6A60-4F59-8ABE-C2C23A6DD7A0", 0.0D, EntityAttributeModifier.Operation.ADDITION).addAttributeModifier(EntityAttributes.GENERIC_ATTACK_SPEED, "AF8B6E3F-3328-4C0A-AA36-5BA2BB9DBEF4", 0.10000000149011612D, EntityAttributeModifier.Operation.MULTIPLY_TOTAL).addAttributeModifier(EntityAttributes.GENERIC_LUCK, "AF8B6E3F-3328-4C0A-AA36-5BA2BB9DBEF4", 0.10000000149011612D, EntityAttributeModifier.Operation.MULTIPLY_TOTAL).addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, "91AEAA56-376B-4498-935B-2F7F68070636", 0.07500000298023224D, EntityAttributeModifier.Operation.MULTIPLY_TOTAL).addAttributeModifier(EntityAttributes.GENERIC_MAX_HEALTH, "5D6F0BA2-1186-46AC-B896-C61C5CEE99CD", 4.0D, EntityAttributeModifier.Operation.ADDITION).addAttributeModifier(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, "5D6F0BA2-1186-46AC-B896-C61C5CEE99CD", 4.0D, EntityAttributeModifier.Operation.ADDITION).addAttributeModifier(EntityAttributes.GENERIC_ARMOR_TOUGHNESS, "5D6F0BA2-1186-46AC-B896-C61C5CEE99CD", 2.0D, EntityAttributeModifier.Operation.ADDITION).addAttributeModifier(EntityAttributes.GENERIC_ARMOR, "5D6F0BA2-1186-46AC-B896-C61C5CEE99CD", 1.6D, EntityAttributeModifier.Operation.ADDITION));
    public static final RegistrySupplier<StatusEffect> NOCLIP = registerEffect("no_clip", new NoClip());
    public static final RegistrySupplier<StatusEffect> PROTECTED = registerEffect("protected", new Protected().addAttributeModifier(EntityAttributes.GENERIC_ARMOR, "5D6F0BA2-1186-46AC-B896-C61C5CEE99CD", 2D, EntityAttributeModifier.Operation.ADDITION));
    public static final RegistrySupplier<StatusEffect> WEAK_ARMOUR = registerEffect("weak_armour", new WeakArmour().addAttributeModifier(EntityAttributes.GENERIC_ARMOR, "5D6F0BA2-1186-46AC-B896-C61C5CEE99CD", -2D, EntityAttributeModifier.Operation.ADDITION));


    private static RegistrySupplier<StatusEffect> registerEffect(String name, StatusEffect effect) {
        return EFFECTS.register(new Identifier(MalechiaMod.MOD_ID, name), () -> effect);
    }

    public static final RegistrySupplier<Item> BOSS_ESSENCE = registerItem("boss_essence",
            new BOSS_ESSENCE(new Item.Settings().rarity(Rarity.EPIC).food(MalechiaFoodComponents.BOSS_ESSENCE).maxCount(1).group(ModItemGroups.MALECHIA_BREWING)));
    public static final RegistrySupplier<Item> QUARITE = registerItem("quarite",
            new Item(new Item.Settings().group(ModItemGroups.MALECHIA_MISC)));
    public static final RegistrySupplier<Item> MYCRONIUM_ORB = registerItem("mycronium_orb",
            new Item(new Item.Settings().group(ModItemGroups.MALECHIA_MISC)));
    public static final RegistrySupplier<Item> MYCRONITE_INGOT = registerItem("mycronite_ingot",
            new Item(new Item.Settings().group(ModItemGroups.MALECHIA_MISC)));
    public static final RegistrySupplier<Item> AURAUM_CRYSTAL = registerItem("auraum_crystal",
            new Item(new Item.Settings().group(ModItemGroups.MALECHIA_MISC)));
    public static final RegistrySupplier<Item> LOCRONITE_DUST = registerItem("locronite_dust",
            new Item(new Item.Settings().group(ModItemGroups.MALECHIA_MISC)));
    public static final RegistrySupplier<Item> LOCRONITE_INGOT = registerItem("locronite_ingot",
            new Item(new Item.Settings().group(ModItemGroups.MALECHIA_MISC)));
    public static final RegistrySupplier<Item> ALOTIC_CRYSTAL = registerItem("alotic_crystal",
            new Item(new Item.Settings().group(ModItemGroups.MALECHIA_MISC)));
    public static final RegistrySupplier<Item> RAW_ERETH = registerItem("raw_ereth",
            new Item(new Item.Settings().group(ModItemGroups.MALECHIA_MISC)));
    public static final RegistrySupplier<Item> ERETH_INGOT = registerItem("ereth_ingot",
            new Item(new Item.Settings().group(ModItemGroups.MALECHIA_MISC)));
    public static final RegistrySupplier<Item> CHRYON = registerItem("chryon",
            new Item(new Item.Settings().group(ModItemGroups.MALECHIA_MISC)));
    public static final RegistrySupplier<Item> HALORIUM = registerItem("halorium",
            new Item(new Item.Settings().group(ModItemGroups.MALECHIA_MISC)));
    public static final RegistrySupplier<Item> HALOTIC_INGOT = registerItem("halotic_ingot",
            new Item(new Item.Settings().group(ModItemGroups.MALECHIA_MISC)));
    public static final RegistrySupplier<Item> LITRIUM_DUST = registerItem("litrium_dust",
            new Item(new Item.Settings().group(ModItemGroups.MALECHIA_MISC)));
    public static final RegistrySupplier<Item> LITRIUM_INGOT = registerItem("litrium_ingot",
            new Item(new Item.Settings().group(ModItemGroups.MALECHIA_MISC)));
    public static final RegistrySupplier<Item> RAW_ALLIA = registerItem("raw_allia",
            new Item(new Item.Settings().group(ModItemGroups.MALECHIA_MISC)));
    public static final RegistrySupplier<Item> ALLIAN_INGOT = registerItem("allian_ingot",
            new Item(new Item.Settings().group(ModItemGroups.MALECHIA_MISC)));
    public static final RegistrySupplier<Item> MALECHIA_INGOT = registerItem("malechia_ingot",
            new Item(new Item.Settings().group(ModItemGroups.MALECHIA_MISC)));
    public static final RegistrySupplier<Item> BOSS_ESSENCE_IRON_INGOT = registerItem("boss_essence_iron_ingot",
            new Item(new Item.Settings().rarity(Rarity.EPIC).group(ModItemGroups.MALECHIA_MISC)));
    public static final RegistrySupplier<ToolItem> BOSS_ESSENCE_IRON_SWORD = registerToolItem("boss_essence_iron_sword",
            new SwordItem(MalechiaToolMaterials.BOSS, 3, -2.4F, new Item.Settings().rarity(Rarity.UNCOMMON).fireproof().group(ModItemGroups.MALECHIA_COMBAT)));
    public static final RegistrySupplier<ToolItem> BOSS_ESSENCE_IRON_SHOVEL = registerToolItem("boss_essence_iron_shovel",
            new ShovelItem(MalechiaToolMaterials.BOSS, 2.5F, -2.5F, new Item.Settings().rarity(Rarity.UNCOMMON).fireproof().group(ModItemGroups.MALECHIA_TOOLS)));
    public static final RegistrySupplier<ToolItem> BOSS_ESSENCE_IRON_PICKAXE = registerToolItem("boss_essence_iron_pickaxe",
            new net.alexandra.malechia.item.custom.PickaxeItem(MalechiaToolMaterials.BOSS, 2, -2.3F, new Item.Settings().rarity(Rarity.UNCOMMON).fireproof().group(ModItemGroups.MALECHIA_TOOLS)));
    public static final RegistrySupplier<ToolItem> BOSS_ESSENCE_IRON_AXE = registerToolItem("boss_essence_iron_axe",
            new net.alexandra.malechia.item.custom.AxeItem(MalechiaToolMaterials.BOSS,4, -3.0F,  new Item.Settings().rarity(Rarity.UNCOMMON).fireproof().group(ModItemGroups.MALECHIA_TOOLS)));
    public static final RegistrySupplier<ToolItem> BOSS_ESSENCE_IRON_HOE = registerToolItem("boss_essence_iron_hoe",
            new net.alexandra.malechia.item.custom.HoeItem(MalechiaToolMaterials.BOSS, 1, 0F, new Item.Settings().rarity(Rarity.UNCOMMON).fireproof().group(ModItemGroups.MALECHIA_TOOLS)));
    public static final RegistrySupplier<Item>BOSS_ESSENCE_NETHER_STAR = registerItem("boss_essence_nether_star",
            new NetherStarItem(new Item.Settings().rarity(Rarity.EPIC).group(ModItemGroups.MALECHIA_MISC)));
    public static final RegistrySupplier<Item> NETHERITE_SCRAP_NUGGET = registerItem("netherite_scrap_nugget",
            new Item(new Item.Settings().group(ModItemGroups.MALECHIA_MISC)));
    public static final RegistrySupplier<Item> NETHERITE_NUGGET = registerItem("netherite_nugget",
            new Item(new Item.Settings().group(ModItemGroups.MALECHIA_MISC)));
    public static final RegistrySupplier<Item> UNIFIER = registerItem("unifier",
            new NetherStarItem(new Item.Settings().rarity(Rarity.EPIC).group(ModItemGroups.MALECHIA_MISC)));
    public static final RegistrySupplier<Item> COMBINER = registerItem("combiner",
            new Item(new Item.Settings().rarity(Rarity.UNCOMMON).group(ModItemGroups.MALECHIA_MISC)));
    public static final RegistrySupplier<ToolItem> MALECHIA_SWORD = registerToolItem("malechia_sword",
            new SwordItem(MalechiaToolMaterials.MALECHIA, 3, -2F, new Item.Settings().rarity(Rarity.RARE).fireproof().group(ModItemGroups.MALECHIA_COMBAT)));
    public static final RegistrySupplier<ToolItem> MALECHIA_SHOVEL = registerToolItem("malechia_shovel",
            new ShovelItem(MalechiaToolMaterials.MALECHIA, 2.5F, -2.5F, new Item.Settings().rarity(Rarity.RARE).fireproof().group(ModItemGroups.MALECHIA_TOOLS)));
    public static final RegistrySupplier<ToolItem> MALECHIA_PICKAXE = registerToolItem("malechia_pickaxe",
            new net.alexandra.malechia.item.custom.PickaxeItem(MalechiaToolMaterials.MALECHIA, 2, -2.3F, new Item.Settings().rarity(Rarity.RARE).fireproof().group(ModItemGroups.MALECHIA_TOOLS)));
    public static final RegistrySupplier<ToolItem> MALECHIA_AXE = registerToolItem("malechia_axe",
            new net.alexandra.malechia.item.custom.AxeItem(MalechiaToolMaterials.MALECHIA, 4, -2.7F,  new Item.Settings().rarity(Rarity.RARE).fireproof().group(ModItemGroups.MALECHIA_TOOLS)));
    public static final RegistrySupplier<ToolItem> MALECHIA_HOE = registerToolItem("malechia_hoe",
            new net.alexandra.malechia.item.custom.HoeItem(MalechiaToolMaterials.MALECHIA, 1, 1F, new Item.Settings().rarity(Rarity.RARE).fireproof().group(ModItemGroups.MALECHIA_TOOLS)));
    public static final RegistrySupplier<ArmorItem> MALECHIA_HELMET = registerArmorItem("malechia_helmet",
            new MalechiaArmorItem(MalechiaArmorMaterials.MALECHIA, EquipmentSlot.HEAD, new Item.Settings().rarity(Rarity.RARE).fireproof().group(ModItemGroups.MALECHIA_COMBAT)));
    public static final RegistrySupplier<ArmorItem> MALECHIA_CHESTPLATE = registerArmorItem("malechia_chestplate",
            new ArmorItem(MalechiaArmorMaterials.MALECHIA, EquipmentSlot.CHEST, new Item.Settings().rarity(Rarity.RARE).fireproof().group(ModItemGroups.MALECHIA_COMBAT)));
    public static final RegistrySupplier<ArmorItem> MALECHIA_LEGGINGS = registerArmorItem("malechia_leggings",
            new ArmorItem(MalechiaArmorMaterials.MALECHIA, EquipmentSlot.LEGS, new Item.Settings().rarity(Rarity.RARE).fireproof().group(ModItemGroups.MALECHIA_COMBAT)));
    public static final RegistrySupplier<ArmorItem> MALECHIA_BOOTS = registerArmorItem("malechia_boots",
            new ArmorItem(MalechiaArmorMaterials.MALECHIA, EquipmentSlot.FEET, new Item.Settings().rarity(Rarity.RARE).fireproof().group(ModItemGroups.MALECHIA_COMBAT)));
    public static final RegistrySupplier<MalechiaBowItem> MALECHIA_BOW = registerMalechiaBowItem("malechia_bow",
            new MalechiaBowItem(new Item.Settings().group(ModItemGroups.MALECHIA_COMBAT).rarity(Rarity.RARE).maxDamage(5000)));
    public static final RegistrySupplier<Item> EMPOWERED_STICK = registerItem("empowered_stick",
            new DebugStickItem(new Item.Settings().fireproof().rarity(Rarity.EPIC).group(ModItemGroups.MALECHIA_TOOLS)));
    public static final RegistrySupplier<ToolItem> SPRUCE_SWORD = registerToolItem("spruce_sword",
            new SwordItem(ToolMaterials.WOOD, 3, -2.4F, new Item.Settings().group(ItemGroup.COMBAT)));
    public static final RegistrySupplier<ToolItem> BIRCH_SWORD = registerToolItem("birch_sword",
            new SwordItem(ToolMaterials.WOOD, 3, -2.4F, new Item.Settings().group(ItemGroup.COMBAT)));
    public static final RegistrySupplier<ToolItem> JUNGLE_SWORD = registerToolItem("jungle_sword",
            new SwordItem(ToolMaterials.WOOD, 3, -2.4F, new Item.Settings().group(ItemGroup.COMBAT)));
    public static final RegistrySupplier<ToolItem> ACACIA_SWORD = registerToolItem("acacia_sword",
            new SwordItem(ToolMaterials.WOOD, 3, -2.4F, new Item.Settings().group(ItemGroup.COMBAT)));
    public static final RegistrySupplier<ToolItem> DARK_OAK_SWORD = registerToolItem("dark_oak_sword",
            new SwordItem(ToolMaterials.WOOD, 3, -2.4F, new Item.Settings().group(ItemGroup.COMBAT)));
    public static final RegistrySupplier<ToolItem> CRIMSON_SWORD = registerToolItem("crimson_sword",
            new SwordItem(ToolMaterials.WOOD, 3, -2.4F, new Item.Settings().fireproof().group(ItemGroup.COMBAT)));
    public static final RegistrySupplier<ToolItem> WARPED_SWORD = registerToolItem("warped_sword",
            new SwordItem(ToolMaterials.WOOD, 3, -2.4F, new Item.Settings().fireproof().group(ItemGroup.COMBAT)));
    public static final RegistrySupplier<ToolItem> SPRUCE_SHOVEL = registerToolItem("spruce_shovel",
            new ShovelItem(ToolMaterials.WOOD, 1.5F, -3.0F, (new Item.Settings()).group(ItemGroup.TOOLS)));
    public static final RegistrySupplier<ToolItem> BIRCH_SHOVEL = registerToolItem("birch_shovel",
            new ShovelItem(ToolMaterials.WOOD, 1.5F, -3.0F, (new Item.Settings()).group(ItemGroup.TOOLS)));
    public static final RegistrySupplier<ToolItem> JUNGLE_SHOVEL = registerToolItem("jungle_shovel",
            new ShovelItem(ToolMaterials.WOOD, 1.5F, -3.0F, (new Item.Settings()).group(ItemGroup.TOOLS)));
    public static final RegistrySupplier<ToolItem> SPRUCE_PICKAXE = registerToolItem("spruce_pickaxe",
            new net.alexandra.malechia.item.custom.PickaxeItem(ToolMaterials.WOOD, 1, -2.8F, (new Item.Settings()).group(ItemGroup.TOOLS)));
    public static final RegistrySupplier<ToolItem> BIRCH_PICKAXE = registerToolItem("birch_pickaxe",
            new net.alexandra.malechia.item.custom.PickaxeItem(ToolMaterials.WOOD, 1, -2.8F, (new Item.Settings()).group(ItemGroup.TOOLS)));
    public static final RegistrySupplier<ToolItem> JUNGLE_PICKAXE = registerToolItem("jungle_pickaxe",
            new net.alexandra.malechia.item.custom.PickaxeItem(ToolMaterials.WOOD, 1, -2.8F, (new Item.Settings()).group(ItemGroup.TOOLS)));
    public static final RegistrySupplier<ToolItem> SPRUCE_AXE = registerToolItem("spruce_axe",
            new net.alexandra.malechia.item.custom.AxeItem( ToolMaterials.WOOD,6, 6.0F,  (new Item.Settings()).group(ItemGroup.TOOLS)));
    public static final RegistrySupplier<ToolItem> BIRCH_AXE = registerToolItem("birch_axe",
            new net.alexandra.malechia.item.custom.AxeItem( ToolMaterials.WOOD,6, 6.0F,  (new Item.Settings()).group(ItemGroup.TOOLS)));
    public static final RegistrySupplier<ToolItem> JUNGLE_AXE = registerToolItem("jungle_axe",
            new net.alexandra.malechia.item.custom.AxeItem( ToolMaterials.WOOD,6, 6.0F,  (new Item.Settings()).group(ItemGroup.TOOLS)));
    public static final RegistrySupplier<ToolItem> SPRUCE_HOE = registerToolItem("spruce_hoe",
            new net.alexandra.malechia.item.custom.HoeItem(ToolMaterials.WOOD, 0, -3.0F, (new Item.Settings()).group(ItemGroup.TOOLS)));
    public static final RegistrySupplier<ToolItem> BIRCH_HOE = registerToolItem("birch_hoe",
            new net.alexandra.malechia.item.custom.HoeItem(ToolMaterials.WOOD, 0, -3.0F, (new Item.Settings()).group(ItemGroup.TOOLS)));
    public static final RegistrySupplier<ToolItem> JUNGLE_HOE = registerToolItem("jungle_hoe",
            new HoeItem(ToolMaterials.WOOD, 0, -3.0F, (new Item.Settings()).group(ItemGroup.TOOLS)));
    public static final RegistrySupplier<ToolItem> NO_CLIP_ITEM = registerToolItem("no_clip",
            new NO_CLIP_ITEM(MalechiaToolMaterials.BOSS, new Item.Settings().maxCount(1).maxDamage(512).rarity(Rarity.EPIC).fireproof().group(ModItemGroups.MALECHIA_TOOLS)));
    public static final RegistrySupplier<ToolItem> MONADO_1 = registerToolItem("monado_1",
            new MonadoItem(MalechiaToolMaterials.UNKNOWN, 0, 1, new Item.Settings().rarity(Rarity.RARE).fireproof().group(ModItemGroups.MALECHIA_COMBAT)));
    public static final RegistrySupplier<ToolItem> ETHEREAL_TELEPORTER = registerToolItem("ethereal_teleporter",
            new EtherealTeleporterItem(MalechiaToolMaterials.MALECHIA, new Item.Settings().rarity(Rarity.RARE).fireproof().group(ModItemGroups.MALECHIA_COMBAT)));
    private static RegistrySupplier<Item> registerItem(String name, Item item) {
        return ITEMS.register( new Identifier(MalechiaMod.MOD_ID, name), () -> item);
    }
    private static RegistrySupplier<ToolItem> registerToolItem(String name, ToolItem item) {
        return ITEMS.register(new Identifier(MalechiaMod.MOD_ID, name), () -> item);
    }
    private static RegistrySupplier<ArmorItem> registerArmorItem(String name, ArmorItem item) {
        return ITEMS.register(new Identifier(MalechiaMod.MOD_ID, name), () -> item);
    }
    private static RegistrySupplier<BowItem> registerBowItem(String name, BowItem item) {
        return ITEMS.register(new Identifier(MalechiaMod.MOD_ID, name), () -> item);
    }
    private static RegistrySupplier<MalechiaBowItem> registerMalechiaBowItem(String name, MalechiaBowItem item) {
        return ITEMS.register(new Identifier(MalechiaMod.MOD_ID, name), () -> item);
    }
    public static final RegistrySupplier<Block> ETHEREAL_BUSH = registerBlock("ethereal_bush",
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
    public static final RegistrySupplier<Block> ETHEREAL_DIRT = registerBlock("ethereal_dirt",
            new Block(Block.Settings.copy(Blocks.DIRT).strength(4.0f).requiresTool()), ModItemGroups.MALECHIA_BLOCKS);
    public static final RegistrySupplier<Block> ETHEREAL_GRASS_BLOCK = registerBlock("ethereal_grass_block",
            new EtherealGrassBlock(Block.Settings.copy(Blocks.GRASS_BLOCK).strength(4.0f).requiresTool()), ModItemGroups.MALECHIA_BLOCKS);
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
        return BLOCKS.register( new Identifier(MalechiaMod.MOD_ID, name), () -> block);
    }
    protected static RegistrySupplier<Block> registerBlockWithoutItem(String name, Block block) {
        return BLOCKS.register( new Identifier(MalechiaMod.MOD_ID, name), () -> block);
    }

    private static RegistrySupplier<Item> registerBlockItem(String name, Block block, ItemGroup group) {
        return ITEMS.register( new Identifier(MalechiaMod.MOD_ID, name), () -> new BlockItem(block, new Item.Settings().group(group)));
    }
    public static final RegistrySupplier<Enchantment> HEROS_EDGE = registerEnchantment("heros_edge",
            new HerosEdge());
    public static final RegistrySupplier<Enchantment> AUTOSMELT = registerEnchantment("autosmelt",
            new AutoSmelt());


    private static RegistrySupplier<Enchantment> registerEnchantment(String path, Enchantment enchantment) {
        return ENCHANTMENT.register(new Identifier(MalechiaMod.MOD_ID, path), () -> enchantment);
    }
    public static final RegistrySupplier<Biome> ETHEREAL_CORE = register("the_core", EtherealBiomeCreator.createEtherealCore());
    private static RegistrySupplier<Biome> register(String name, Biome biome) {
        return BIOMES.register(new Identifier(MalechiaMod.MOD_ID,name), () -> biome);
    }
    public static void initialize() {
    }
}
