package net.alexandra.malechia.item.custom;

import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.world.World;

public class EnhancedShovelItem extends ShovelItem {
    public final int MULTIPLIER;
    public EnhancedShovelItem(ToolMaterial material, float attackDamage, float attackSpeed, int levelMultiplier, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
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
