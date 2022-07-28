package net.alexandra.malechia.world.biome;

import com.google.common.base.Suppliers;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.Registries;
import net.alexandra.malechia.MalechiaMod;
import net.minecraft.block.Block;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.*;

import java.util.function.Supplier;

public class MalechiaBuiltinBiomes {
    public static final Supplier<Registries> REGISTRIES = Suppliers.memoize(() -> Registries.get(MalechiaMod.MOD_ID));
    public static final Registrar<Biome> biomes = REGISTRIES.get().get(Registry.BIOME_KEY);
    private static void register(String name, Biome biome) {
        biomes.register(new Identifier(MalechiaMod.MOD_ID,name), () -> biome);
    }

    static {
        MalechiaBuiltinBiomes.register("the_core", EtherealBiomeCreator.createEtherealCore());
    }

    public static void registerModBiomes() {
    }
}
