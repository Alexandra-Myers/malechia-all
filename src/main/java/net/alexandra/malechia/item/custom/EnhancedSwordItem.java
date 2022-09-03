package net.alexandra.malechia.item.custom;

import net.alexandra.malechia.enchantments.ModEnchantments;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.world.World;

public class EnhancedSwordItem extends SwordItem {
    public final int MULTIPLIER;
    public EnhancedSwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, int levelMultiplier, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
        MULTIPLIER = levelMultiplier;
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return false;
    }

    @Override
    public void onCraft(ItemStack stack, World world, PlayerEntity player) {
        super.onCraft(stack, world, player);
        stack.addEnchantment(Enchantments.SHARPNESS, 10*MULTIPLIER);
        stack.addEnchantment(Enchantments.SWEEPING, 5*MULTIPLIER);
        stack.addEnchantment(ModEnchantments.HEROS_EDGE.get(), 1*MULTIPLIER);
        stack.addEnchantment(Enchantments.LOOTING, 5*MULTIPLIER);
        stack.addEnchantment(Enchantments.FIRE_ASPECT, 2*MULTIPLIER);
        stack.addEnchantment(Enchantments.UNBREAKING, 10*MULTIPLIER);
        stack.addEnchantment(Enchantments.MENDING, 1*MULTIPLIER);
    }
}
