package net.alexandra.malechia.dimension;

import net.alexandra.malechia.MalechiaMod;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

public class ModDimensions {
    public static final RegistryKey<World> ETHEREAL_CORE_DIMENSION_KEY = RegistryKey.of(Registry.WORLD_KEY,
            new Identifier(MalechiaMod.MOD_ID, "ethereal_core"));
    public static final RegistryKey<DimensionType> ETHEREAL_CORE_TYPE_KEY = RegistryKey.of(Registry.DIMENSION_TYPE_KEY,
            ETHEREAL_CORE_DIMENSION_KEY.getValue());


    public static void register() {
        MalechiaMod.LOGGER.debug("Registering ModDimensions for " + MalechiaMod.MOD_ID);
    }
}
