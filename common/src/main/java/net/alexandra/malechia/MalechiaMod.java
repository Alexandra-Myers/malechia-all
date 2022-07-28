package net.alexandra.malechia;

import net.alexandra.malechia.block.ModBlocks;
import net.alexandra.malechia.effects.ModEffects;
import net.alexandra.malechia.enchantments.ModEnchantments;
import net.alexandra.malechia.item.ModItems;
import net.alexandra.malechia.tag.MalechiaBlockTags;
import net.alexandra.malechia.util.ModRegistries;
import net.alexandra.malechia.world.biome.MalechiaBuiltinBiomes;
import net.alexandra.malechia.world.feature.ModConfiguredFeatures;
import net.alexandra.malechia.world.feature.ModTreeConfiguredFeatures;

public class MalechiaMod {
    public static final String MOD_ID = "malechia";
    // We can use this if we don't want to use DeferredRegister
    // Registering a new creative tab
    
    public static void init() {
        ModTreeConfiguredFeatures.registerConfiguredFeatures();
        ModConfiguredFeatures.registerConfiguredFeatures();
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        MalechiaBlockTags.registerModBlockTags();
        ModEnchantments.registerModEnchantments();
        ModEffects.registerModEffects();
        ModRegistries.registerModStuffs();
        MalechiaBuiltinBiomes.registerModBiomes();
        System.out.println(MalechiaExpectPlatform.getConfigDirectory().toAbsolutePath().normalize().toString());
    }
}
