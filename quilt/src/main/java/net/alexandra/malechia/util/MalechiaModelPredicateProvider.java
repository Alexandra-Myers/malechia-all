package net.alexandra.malechia.util;

import net.alexandra.malechia.item.ModItems;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

public class MalechiaModelPredicateProvider {
    public static void registerModModels() {
        registerBow(ModItems.MALECHIA_BOW.get());
        registerBow(ModItems.ENHANCED_MALECHIA_BOW.get());
		registerMonado(ModItems.MONADO_1.get());
    }

    private static void registerBow(Item bow) {
        ModelPredicateProviderRegistry.register(bow, new Identifier("pull"),
                (stack, world, entity, seed) -> {
                    if (entity == null) {
                        return 0.0f;
                    }
                    if (entity.getActiveItem() != stack) {
                        return 0.0f;
                    }
                    return (float)(stack.getMaxUseTime() - entity.getItemUseTimeLeft()) / 20.0f;
                });

        ModelPredicateProviderRegistry.register(bow, new Identifier("pulling"),
                (stack, world, entity, seed) -> entity != null && entity.isUsingItem()
                        && entity.getActiveItem() == stack ? 1.0f : 0.0f);
    }
	private static void registerMonado(Item monado) {
		ModelPredicateProviderRegistry.register(monado, new Identifier("active"),
				(stack, world, entity, seed) -> entity != null && stack.getNbt().getBoolean("isActive") ? 1.0f : 0.0f);
	}
}
