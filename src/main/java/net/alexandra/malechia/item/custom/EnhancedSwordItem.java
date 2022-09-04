package net.alexandra.malechia.item.custom;

import net.alexandra.atlas.atlas_combat.extensions.IItemStack;
import net.alexandra.malechia.enchantments.ModEnchantments;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
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
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);
        if(((IItemStack)(Object)stack).getEnchantmentLevel(Enchantments.SHARPNESS) != 0
                && ((IItemStack)(Object)stack).getEnchantmentLevel(Enchantments.SWEEPING) != 0
                && ((IItemStack)(Object)stack).getEnchantmentLevel(ModEnchantments.HEROS_EDGE.get()) != 0
                && ((IItemStack)(Object)stack).getEnchantmentLevel(Enchantments.LOOTING) != 0
                && ((IItemStack)(Object)stack).getEnchantmentLevel(Enchantments.FIRE_ASPECT) != 0
                && ((IItemStack)(Object)stack).getEnchantmentLevel(Enchantments.UNBREAKING) != 0
                && ((IItemStack)(Object)stack).getEnchantmentLevel(Enchantments.MENDING) != 0) {
            stack.addEnchantment(Enchantments.SHARPNESS, 10*MULTIPLIER);
            stack.addEnchantment(Enchantments.SWEEPING, 5*MULTIPLIER);
            stack.addEnchantment(ModEnchantments.HEROS_EDGE.get(), 1*MULTIPLIER);
            stack.addEnchantment(Enchantments.LOOTING, 5*MULTIPLIER);
            stack.addEnchantment(Enchantments.FIRE_ASPECT, 2*MULTIPLIER);
            stack.addEnchantment(Enchantments.UNBREAKING, 10*MULTIPLIER);
            stack.addEnchantment(Enchantments.MENDING, 1*MULTIPLIER);
        }
    }
}
