package net.alexandra.malechia.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.GameMode;

public class NoClip extends StatusEffect {
	public GameMode mode;

	public NoClip() {
		super(StatusEffectType.BENEFICIAL, 0x98D982);
	}
	public boolean canApplyUpdateEffect(int duration, int amplifier) {
		return true;
	}
	public void applyUpdateEffect(LivingEntity entity, int amplifier) {
	}
	public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
		if(entity.isPlayer()){
			ServerPlayerEntity user = (ServerPlayerEntity) entity;
			this.mode = user.interactionManager.getGameMode();
			user.changeGameMode(GameMode.SPECTATOR);
		}
		super.onApplied(entity, attributes, amplifier);
	}
	public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
		super.onRemoved(entity, attributes, amplifier);
		if(entity.isPlayer()){
			ServerPlayerEntity user = (ServerPlayerEntity) entity;
			if(mode == null){
				user.changeGameMode(GameMode.SURVIVAL);
				return;
			}
			user.changeGameMode(this.mode);
		}
	}
}
