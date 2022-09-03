package net.alexandra.malechia;

import dev.architectury.utils.Env;
import dev.architectury.utils.EnvExecutor;
import net.alexandra.malechia.block.ModBlocks;
import net.alexandra.malechia.dimension.ModDimensions;
import net.alexandra.malechia.effects.ModEffects;
import net.alexandra.malechia.enchantments.ModEnchantments;
import net.alexandra.malechia.item.ModItems;
import net.alexandra.malechia.registry.ComposterRegistry;
import net.alexandra.malechia.util.TestKeybinds;
import net.alexandra.malechia.world.biome.MalechiaBuiltinBiomes;
import net.alexandra.malechia.world.gen.ModWorldGen;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MalechiaMod {
    public static final String MOD_ID = "malechia";
    public static final Logger LOGGER = LoggerFactory.getLogger("malechia");
    // We can use this if we don't want to use DeferredRegister
    // Registering a new creative tab
    
    public static void init() {
        EnvExecutor.runInEnv(Env.CLIENT, () -> MalechiaMod.Client::initializeClient);
    }
    @Environment(EnvType.CLIENT)
    public static class Client {
        @Environment(EnvType.CLIENT)
        public static void initializeClient() {
        }
    }
}
