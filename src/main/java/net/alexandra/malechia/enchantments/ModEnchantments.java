package net.alexandra.malechia.enchantments;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.alexandra.malechia.registry.ModRegistries;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static net.alexandra.malechia.MalechiaMod.MOD_ID;

public class ModEnchantments extends ModRegistries {
    public static final DeferredRegister<Enchantment> ENCHANTMENT = DeferredRegister.create(MOD_ID, Registry.ENCHANTMENT_KEY);
    public static final RegistrySupplier<Enchantment> HEROS_EDGE = registerEnchantment("heros_edge",
            new HerosEdge());
    public static final RegistrySupplier<Enchantment> AUTOSMELT = registerEnchantment("autosmelt",
            new AutoSmelt());
    protected static RegistrySupplier<Enchantment> registerEnchantment(String path, Enchantment enchantment) {
        return ENCHANTMENT.register(new Identifier(MOD_ID, path), () -> enchantment);
    }
    public static void init(){
        ENCHANTMENT.register();
    }
}
