package net.alexandra.malechia.item;

import com.google.common.base.Suppliers;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.Registries;
import dev.architectury.registry.registries.RegistrySupplier;
import net.alexandra.malechia.MalechiaMod;
import net.alexandra.malechia.item.custom.*;
import net.alexandra.malechia.item.custom.AxeItem;
import net.alexandra.malechia.item.custom.HoeItem;
import net.alexandra.malechia.item.custom.PickaxeItem;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

import java.util.function.Supplier;

public class ModItems {
    public static final Supplier<Registries> REGISTRIES = Suppliers.memoize(() -> Registries.get(MalechiaMod.MOD_ID));
    public static final Registrar<Item> items = REGISTRIES.get().get(Registry.ITEM_KEY);
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
            new PickaxeItem(MalechiaToolMaterials.BOSS, 2, -2.3F, new Item.Settings().rarity(Rarity.UNCOMMON).fireproof().group(ModItemGroups.MALECHIA_TOOLS)));
    public static final RegistrySupplier<ToolItem> BOSS_ESSENCE_IRON_AXE = registerToolItem("boss_essence_iron_axe",
            new AxeItem(MalechiaToolMaterials.BOSS,4, -3.0F,  new Item.Settings().rarity(Rarity.UNCOMMON).fireproof().group(ModItemGroups.MALECHIA_TOOLS)));
    public static final RegistrySupplier<ToolItem> BOSS_ESSENCE_IRON_HOE = registerToolItem("boss_essence_iron_hoe",
            new HoeItem(MalechiaToolMaterials.BOSS, 1, 0F, new Item.Settings().rarity(Rarity.UNCOMMON).fireproof().group(ModItemGroups.MALECHIA_TOOLS)));
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
            new PickaxeItem(MalechiaToolMaterials.MALECHIA, 2, -2.3F, new Item.Settings().rarity(Rarity.RARE).fireproof().group(ModItemGroups.MALECHIA_TOOLS)));
    public static final RegistrySupplier<ToolItem> MALECHIA_AXE = registerToolItem("malechia_axe",
            new AxeItem(MalechiaToolMaterials.MALECHIA, 4, -2.7F,  new Item.Settings().rarity(Rarity.RARE).fireproof().group(ModItemGroups.MALECHIA_TOOLS)));
    public static final RegistrySupplier<ToolItem> MALECHIA_HOE = registerToolItem("malechia_hoe",
            new HoeItem(MalechiaToolMaterials.MALECHIA, 1, 1F, new Item.Settings().rarity(Rarity.RARE).fireproof().group(ModItemGroups.MALECHIA_TOOLS)));
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
            new PickaxeItem(ToolMaterials.WOOD, 1, -2.8F, (new Item.Settings()).group(ItemGroup.TOOLS)));
    public static final RegistrySupplier<ToolItem> BIRCH_PICKAXE = registerToolItem("birch_pickaxe",
            new PickaxeItem(ToolMaterials.WOOD, 1, -2.8F, (new Item.Settings()).group(ItemGroup.TOOLS)));
    public static final RegistrySupplier<ToolItem> JUNGLE_PICKAXE = registerToolItem("jungle_pickaxe",
            new PickaxeItem(ToolMaterials.WOOD, 1, -2.8F, (new Item.Settings()).group(ItemGroup.TOOLS)));
    public static final RegistrySupplier<ToolItem> SPRUCE_AXE = registerToolItem("spruce_axe",
            new AxeItem( ToolMaterials.WOOD,6, 6.0F,  (new Item.Settings()).group(ItemGroup.TOOLS)));
    public static final RegistrySupplier<ToolItem> BIRCH_AXE = registerToolItem("birch_axe",
            new AxeItem( ToolMaterials.WOOD,6, 6.0F,  (new Item.Settings()).group(ItemGroup.TOOLS)));
    public static final RegistrySupplier<ToolItem> JUNGLE_AXE = registerToolItem("jungle_axe",
            new AxeItem( ToolMaterials.WOOD,6, 6.0F,  (new Item.Settings()).group(ItemGroup.TOOLS)));
    public static final RegistrySupplier<ToolItem> SPRUCE_HOE = registerToolItem("spruce_hoe",
            new HoeItem(ToolMaterials.WOOD, 0, -3.0F, (new Item.Settings()).group(ItemGroup.TOOLS)));
    public static final RegistrySupplier<ToolItem> BIRCH_HOE = registerToolItem("birch_hoe",
            new HoeItem(ToolMaterials.WOOD, 0, -3.0F, (new Item.Settings()).group(ItemGroup.TOOLS)));
    public static final RegistrySupplier<ToolItem> JUNGLE_HOE = registerToolItem("jungle_hoe",
            new HoeItem(ToolMaterials.WOOD, 0, -3.0F, (new Item.Settings()).group(ItemGroup.TOOLS)));
    public static final RegistrySupplier<ToolItem> NO_CLIP_ITEM = registerToolItem("no_clip",
            new NO_CLIP_ITEM(MalechiaToolMaterials.BOSS, new Item.Settings().maxCount(1).maxDamage(512).rarity(Rarity.EPIC).fireproof().group(ModItemGroups.MALECHIA_TOOLS)));
	public static final RegistrySupplier<ToolItem> MONADO_1 = registerToolItem("monado_1",
			new MonadoItem(MalechiaToolMaterials.UNKNOWN, 0, 1, new Item.Settings().rarity(Rarity.RARE).fireproof().group(ModItemGroups.MALECHIA_COMBAT)));

    private static RegistrySupplier<Item> registerItem(String name, Item item) {
           return items.register( new Identifier(MalechiaMod.MOD_ID, name), () -> item);
    }
    private static RegistrySupplier<ToolItem> registerToolItem(String name, ToolItem item) {
        return items.register(new Identifier(MalechiaMod.MOD_ID, name), () -> item);
    }
    private static RegistrySupplier<ArmorItem> registerArmorItem(String name, ArmorItem item) {
        return items.register(new Identifier(MalechiaMod.MOD_ID, name), () -> item);
    }
    private static RegistrySupplier<BowItem> registerBowItem(String name, BowItem item) {
        return items.register(new Identifier(MalechiaMod.MOD_ID, name), () -> item);
    }
    private static RegistrySupplier<MalechiaBowItem> registerMalechiaBowItem(String name, MalechiaBowItem item) {
        return items.register(new Identifier(MalechiaMod.MOD_ID, name), () -> item);
    }

    public static void registerModItems() {
    }

}
