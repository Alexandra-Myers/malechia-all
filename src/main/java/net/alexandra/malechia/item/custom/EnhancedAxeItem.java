package net.alexandra.malechia.item.custom;

import net.alexandra.atlas.atlas_combat.AtlasCombat;
import net.alexandra.atlas.atlas_combat.extensions.IItemStack;
import net.alexandra.malechia.enchantments.ModEnchantments;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.world.World;

public class EnhancedAxeItem extends AxeItem {
    public final int MULTIPLIER;
    public EnhancedAxeItem(ToolMaterial toolMaterial, float f, float g, int levelMultiplier, Settings settings) {
        super(toolMaterial, f, g, settings);
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
                && EnchantmentHelper.getLevel(AtlasCombat.CLEAVING_ENCHANTMENT, stack) == 0
                && EnchantmentHelper.getLevel(Enchantments.EFFICIENCY, stack) == 0
                && EnchantmentHelper.getLevel(Enchantments.SWEEPING, stack) == 0
                && EnchantmentHelper.getLevel(ModEnchantments.HEROS_EDGE.get(), stack) == 0
                && EnchantmentHelper.getLevel(Enchantments.UNBREAKING, stack) == 0
                && EnchantmentHelper.getLevel(Enchantments.MENDING, stack) == 0) {
            stack.addEnchantment(AtlasCombat.CLEAVING_ENCHANTMENT, 5 * MULTIPLIER);
            stack.addEnchantment(Enchantments.EFFICIENCY, 10 * MULTIPLIER);
            stack.addEnchantment(Enchantments.SWEEPING, 5 * MULTIPLIER);
            stack.addEnchantment(ModEnchantments.HEROS_EDGE.get(), 1 * MULTIPLIER);
            stack.addEnchantment(Enchantments.UNBREAKING, 10 * MULTIPLIER);
            stack.addEnchantment(Enchantments.MENDING, 1 * MULTIPLIER);
        }
    }
}
