package net.alexandra.malechia.item;

import net.alexandra.malechia.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroups {
	public static final ItemGroup[] MALECHIA_GROUPS = new ItemGroup[17];

	public static final ItemGroup MALECHIA_MISC = new ItemGroup(12, "malechia_misc") {
		@Override
		public ItemStack createIcon() {
			return new ItemStack(ModItems.MALECHIA_INGOT.get());
		}
	};
	public static final ItemGroup MALECHIA_BLOCKS = new ItemGroup(13, "malechia_blocks") {
		@Override
		public ItemStack createIcon() {
			return new ItemStack(ModBlocks.PURE_ETHEREAL_CRYSTAL_BLOCK.get());
		}
	};
	public static final ItemGroup MALECHIA_COMBAT = new ItemGroup(14, "malechia_combat") {
		@Override
		public ItemStack createIcon() {
			return new ItemStack(ModItems.BOSS_ESSENCE_IRON_SWORD.get());
		}
	};
	public static final ItemGroup MALECHIA_TOOLS = new ItemGroup(15, "malechia_tools") {
		@Override
		public ItemStack createIcon() {
			return new ItemStack(ModItems.MALECHIA_AXE.get());
		}
	};
	public static final ItemGroup MALECHIA_BREWING = new ItemGroup(16, "malechia_brewing") {
		@Override
		public ItemStack createIcon() {
			return new ItemStack(ModItems.BOSS_ESSENCE.get());
		}
	};
}
