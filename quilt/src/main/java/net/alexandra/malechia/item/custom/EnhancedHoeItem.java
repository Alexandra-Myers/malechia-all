package net.alexandra.malechia.item.custom;

import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.world.World;

public class EnhancedHoeItem extends HoeItem {
    public final int MULTIPLIER;
    public EnhancedHoeItem(ToolMaterial toolMaterial, int i, float f, int levelMultiplier, Settings settings) {
        super(toolMaterial, i, f, settings);
        MULTIPLIER = levelMultiplier;
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return false;
    }

    @Override
    public void onCraft(ItemStack stack, World world, PlayerEntity player) {
        super.onCraft(stack, world, player);
        stack.addEnchantment(Enchantments.FORTUNE, 5*MULTIPLIER);
        stack.addEnchantment(Enchantments.EFFICIENCY, 10*MULTIPLIER);
        stack.addEnchantment(Enchantments.UNBREAKING, 10*MULTIPLIER);
        stack.addEnchantment(Enchantments.MENDING, 1*MULTIPLIER);
    }
}
