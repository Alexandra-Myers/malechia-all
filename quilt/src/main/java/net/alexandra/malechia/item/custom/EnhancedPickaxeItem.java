package net.alexandra.malechia.item.custom;

import net.alexandra.malechia.enchantments.ModEnchantments;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.world.World;

public class EnhancedPickaxeItem extends PickaxeItem {
    public final int MULTIPLIER;
    public EnhancedPickaxeItem(ToolMaterial toolMaterial, int i, float f, int levelMultiplier, Settings settings) {
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
        stack.addEnchantment(ModEnchantments.AUTOSMELT.get(), 1*MULTIPLIER);
        stack.addEnchantment(Enchantments.UNBREAKING, 10*MULTIPLIER);
        stack.addEnchantment(Enchantments.MENDING, 1*MULTIPLIER);
    }
}
