package net.alexandra.malechia.item;

import dev.architectury.registry.CreativeTabRegistry;
import net.alexandra.malechia.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

import static net.alexandra.malechia.MalechiaMod.MOD_ID;

public class ModItemGroups {
	public static final ItemGroup MALECHIA_MISC = CreativeTabRegistry.create( new Identifier(MOD_ID, "misc"),
			() -> new ItemStack(ModItems.MALECHIA_INGOT.get()));
	public static final ItemGroup MALECHIA_BLOCKS = CreativeTabRegistry.create( new Identifier(MOD_ID, "blocks"),
			() -> new ItemStack(ModBlocks.PURE_ETHEREAL_CRYSTAL_BLOCK.get()));
	public static final ItemGroup MALECHIA_COMBAT = CreativeTabRegistry.create( new Identifier(MOD_ID, "combat"),
			() -> new ItemStack(ModItems.BOSS_ESSENCE_IRON_SWORD.get()));
	public static final ItemGroup MALECHIA_TOOLS = CreativeTabRegistry.create( new Identifier(MOD_ID, "tools"),
			() -> new ItemStack(ModItems.MALECHIA_AXE.get()));
	public static final ItemGroup MALECHIA_BREWING = CreativeTabRegistry.create( new Identifier(MOD_ID, "brewing"),
			() -> new ItemStack(ModItems.BOSS_ESSENCE.get()));
}
