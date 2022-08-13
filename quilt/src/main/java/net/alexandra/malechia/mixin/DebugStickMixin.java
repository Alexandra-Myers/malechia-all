package net.alexandra.malechia.mixin;

import net.alexandra.malechia.item.ModItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.DebugStickItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(DebugStickItem.class)
public class DebugStickMixin {
	@Redirect(method = "use(Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/block/BlockState;Lnet/minecraft/world/WorldAccess;Lnet/minecraft/util/math/BlockPos;ZLnet/minecraft/item/ItemStack;)Z",
			at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;isCreativeLevelTwoOp()Z"))
	private boolean valid(PlayerEntity instance) {
			return instance.getActiveItem().isOf(ModItems.EMPOWERED_STICK.get()) || instance.getAbilities().creativeMode && instance.getPermissionLevel() >= 2;
	}
}
