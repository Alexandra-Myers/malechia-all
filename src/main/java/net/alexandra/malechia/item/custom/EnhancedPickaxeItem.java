package net.alexandra.malechia.item.custom;

import net.alexandra.atlas.atlas_combat.extensions.IItemStack;
import net.alexandra.malechia.enchantments.ModEnchantments;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
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
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);
        if(stack != null
                && EnchantmentHelper.getLevel(Enchantments.FORTUNE, stack) == 0
                && EnchantmentHelper.getLevel(Enchantments.EFFICIENCY, stack) == 0
                && EnchantmentHelper.getLevel(ModEnchantments.AUTOSMELT.get(), stack) == 0
                && EnchantmentHelper.getLevel(Enchantments.UNBREAKING, stack) == 0
                && EnchantmentHelper.getLevel(Enchantments.MENDING, stack) == 0) {
            stack.addEnchantment(Enchantments.FORTUNE, 5*MULTIPLIER);
            stack.addEnchantment(Enchantments.EFFICIENCY, 10*MULTIPLIER);
            stack.addEnchantment(ModEnchantments.AUTOSMELT.get(), 1*MULTIPLIER);
            stack.addEnchantment(Enchantments.UNBREAKING, 10*MULTIPLIER);
            stack.addEnchantment(Enchantments.MENDING, 1*MULTIPLIER);
        }
    }
}
