package net.alexandra.malechia.item.custom;

import net.alexandra.malechia.effects.ModEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class NO_CLIP_ITEM extends ToolItem {
    public NO_CLIP_ITEM(ToolMaterial material, Settings settings) {
        super(material, settings);
    }

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		ItemStack itemStack = user.getStackInHand(hand);
		user.getItemCooldownManager().set(this, 2000);
		if(!user.isSpectator()){
			user.addStatusEffect(new StatusEffectInstance(ModEffects.NOCLIP.get(), 400 * 2));
			itemStack.damage(1, user, p -> p.sendToolBreakStatus(hand));
		}
		return TypedActionResult.success(itemStack, world.isClient());
	}
}
