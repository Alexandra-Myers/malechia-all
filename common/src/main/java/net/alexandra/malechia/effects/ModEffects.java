package net.alexandra.malechia.effects;

import com.google.common.base.Suppliers;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.Registries;
import dev.architectury.registry.registries.RegistrySupplier;
import net.alexandra.malechia.MalechiaMod;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.function.Supplier;

public class ModEffects {
    public static final Supplier<Registries> REGISTRIES = Suppliers.memoize(() -> Registries.get(MalechiaMod.MOD_ID));
    public static final Registrar<StatusEffect> effects = REGISTRIES.get().get(Registry.MOB_EFFECT_KEY);
    public static final RegistrySupplier<StatusEffect> BOSS_POWER = registerEffect("boss_power", new BossPower().addAttributeModifier(EntityAttributes.GENERIC_ATTACK_DAMAGE, "648D7064-6A60-4F59-8ABE-C2C23A6DD7A0", 0.0D, EntityAttributeModifier.Operation.ADDITION).addAttributeModifier(EntityAttributes.GENERIC_ATTACK_SPEED, "AF8B6E3F-3328-4C0A-AA36-5BA2BB9DBEF4", 0.10000000149011612D, EntityAttributeModifier.Operation.MULTIPLY_TOTAL).addAttributeModifier(EntityAttributes.GENERIC_LUCK, "AF8B6E3F-3328-4C0A-AA36-5BA2BB9DBEF4", 0.10000000149011612D, EntityAttributeModifier.Operation.MULTIPLY_TOTAL).addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, "91AEAA56-376B-4498-935B-2F7F68070636", 0.07500000298023224D, EntityAttributeModifier.Operation.MULTIPLY_TOTAL).addAttributeModifier(EntityAttributes.GENERIC_MAX_HEALTH, "5D6F0BA2-1186-46AC-B896-C61C5CEE99CD", 4.0D, EntityAttributeModifier.Operation.ADDITION).addAttributeModifier(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, "5D6F0BA2-1186-46AC-B896-C61C5CEE99CD", 4.0D, EntityAttributeModifier.Operation.ADDITION).addAttributeModifier(EntityAttributes.GENERIC_ARMOR_TOUGHNESS, "5D6F0BA2-1186-46AC-B896-C61C5CEE99CD", 2.0D, EntityAttributeModifier.Operation.ADDITION).addAttributeModifier(EntityAttributes.GENERIC_ARMOR, "5D6F0BA2-1186-46AC-B896-C61C5CEE99CD", 1.6D, EntityAttributeModifier.Operation.ADDITION));
	public static final RegistrySupplier<StatusEffect> NOCLIP = registerEffect("no_clip", new NoClip());
	public static final RegistrySupplier<StatusEffect> PROTECTED = registerEffect("protected", new Protected().addAttributeModifier(EntityAttributes.GENERIC_ARMOR, "5D6F0BA2-1186-46AC-B896-C61C5CEE99CD", 2D, EntityAttributeModifier.Operation.ADDITION));
    public static final RegistrySupplier<StatusEffect> WEAK_ARMOUR = registerEffect("weak_armour", new WeakArmour().addAttributeModifier(EntityAttributes.GENERIC_ARMOR, "5D6F0BA2-1186-46AC-B896-C61C5CEE99CD", -2D, EntityAttributeModifier.Operation.ADDITION));

    private static RegistrySupplier<StatusEffect> registerEffect(String name, StatusEffect effect) {
        return effects.register(new Identifier(MalechiaMod.MOD_ID, name), () -> effect);
    }

    public static void registerModEffects() {
    }
}
