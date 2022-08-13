package net.alexandra.malechia.world.biome;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.alexandra.malechia.registry.ModRegistries;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.*;

import static net.alexandra.malechia.MalechiaMod.MOD_ID;

public class MalechiaBuiltinBiomes extends ModRegistries {
    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(MOD_ID, Registry.BIOME_KEY);
    public static final RegistrySupplier<Biome> ETHEREAL_CORE = register("the_core", EtherealBiomeCreator.createEtherealCore());
    protected static RegistrySupplier<Biome> register(String name, Biome biome) {
        return BIOMES.register(new Identifier(MOD_ID,name), () -> biome);
    }
    public static void init() {
        BIOMES.register();
    }
}
