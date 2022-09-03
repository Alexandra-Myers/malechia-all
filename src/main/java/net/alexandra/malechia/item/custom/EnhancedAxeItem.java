package net.alexandra.malechia.item.custom;

import net.alexandra.atlas.atlas_combat.AtlasCombat;
import net.alexandra.malechia.enchantments.ModEnchantments;
import net.minecraft.enchantment.Enchantments;
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
    public void onCraft(ItemStack stack, World world, PlayerEntity player) {
        super.onCraft(stack, world, player);
        stack.addEnchantment(AtlasCombat.CLEAVING_ENCHANTMENT, 5*MULTIPLIER);
        stack.addEnchantment(Enchantments.EFFICIENCY, 10*MULTIPLIER);
        stack.addEnchantment(Enchantments.SWEEPING, 5*MULTIPLIER);
        stack.addEnchantment(ModEnchantments.HEROS_EDGE.get(), 1*MULTIPLIER);
        stack.addEnchantment(Enchantments.UNBREAKING, 10*MULTIPLIER);
        stack.addEnchantment(Enchantments.MENDING, 1*MULTIPLIER);
    }
}
