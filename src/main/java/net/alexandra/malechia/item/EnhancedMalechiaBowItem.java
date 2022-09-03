package net.alexandra.malechia.item;

import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EnhancedMalechiaBowItem extends MalechiaBowItem{
    public final int MULTIPLIER;
    public EnhancedMalechiaBowItem(int levelMultiplier, Settings settings) {
        super(settings);
        MULTIPLIER = levelMultiplier;
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return false;
    }

    @Override
    public void onCraft(ItemStack stack, World world, PlayerEntity player) {
        super.onCraft(stack, world, player);
        stack.addEnchantment(Enchantments.POWER, 10*MULTIPLIER);
        stack.addEnchantment(Enchantments.PUNCH, 5*MULTIPLIER);
        stack.addEnchantment(Enchantments.FLAME, 2*MULTIPLIER);
        stack.addEnchantment(Enchantments.UNBREAKING, 10*MULTIPLIER);
        stack.addEnchantment(Enchantments.MENDING, 1*MULTIPLIER);
    }
}
