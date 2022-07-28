package net.alexandra.malechia.enchantments;

import com.google.common.base.Suppliers;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.Registries;
import dev.architectury.registry.registries.RegistrySupplier;
import net.alexandra.malechia.MalechiaMod;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.function.Supplier;

public class ModEnchantments{
    public static final Supplier<Registries> REGISTRIES = Suppliers.memoize(() -> Registries.get(MalechiaMod.MOD_ID));
    public static final Registrar<Enchantment> enchant = REGISTRIES.get().get(Registry.ENCHANTMENT);
    public static final RegistrySupplier<Enchantment> HEROS_EDGE = registerEnchantment("heros_edge",
            new HerosEdge());
    public static final RegistrySupplier<Enchantment> AUTOSMELT = registerEnchantment("autosmelt",
            new AutoSmelt());


    private static RegistrySupplier<Enchantment> registerEnchantment(String path, Enchantment enchantment) {
        return enchant.register(new Identifier(MalechiaMod.MOD_ID, path), () -> enchantment);
    }

    public static void registerModEnchantments() {
    }
}
