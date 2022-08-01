package net.alexandra.malechia.mixin;

import net.alexandra.malechia.block.ModBlocks;
import net.alexandra.malechia.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.ComposterBlock;
import net.minecraft.item.ItemConvertible;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Consumer;

@Mixin(ComposterBlock.class)
public class ComposterBlockMixin {
    @Shadow
    public static void registerCompostableItem(float levelIncreaseChance, ItemConvertible item) {}
}
