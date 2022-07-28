package net.alexandra.malechia.mixin;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MiningToolItem;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.function.Consumer;

@Mixin(MiningToolItem.class)
public class MiningToolMixin {
	@Redirect(method = "postHit",
			at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;damage(ILnet/minecraft/entity/LivingEntity;Ljava/util/function/Consumer;)V"))
	public <T extends LivingEntity> void damage(ItemStack instance, int amount, T entity, Consumer<T> breakCallback) {
		if (!entity.world.isClient && (!(entity instanceof PlayerEntity) || !((PlayerEntity)entity).getAbilities().creativeMode)) {
			if (instance.isDamageable()) {
				if((Object) this instanceof AxeItem) {
					if (instance.damage(1, entity.getRandom(), entity instanceof ServerPlayerEntity ? (ServerPlayerEntity) entity : null)) {
						breakCallback.accept(entity);
						Item item = instance.getItem();
						instance.decrement(1);
						if (entity instanceof PlayerEntity) {
							((PlayerEntity) entity).incrementStat(Stats.BROKEN.getOrCreateStat(item));
						}

						instance.setDamage(0);
					}
				}else{
					if (instance.damage(amount, entity.getRandom(), entity instanceof ServerPlayerEntity ? (ServerPlayerEntity) entity : null)) {
						breakCallback.accept(entity);
						Item item = instance.getItem();
						instance.decrement(1);
						if (entity instanceof PlayerEntity) {
							((PlayerEntity) entity).incrementStat(Stats.BROKEN.getOrCreateStat(item));
						}

						instance.setDamage(0);
					}
				}
			}
		}
	}
}
