package net.alexandra.malechia.tag;

import com.google.common.base.Suppliers;
import dev.architectury.event.events.common.BlockEvent;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.Registries;
import net.alexandra.malechia.MalechiaMod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.tag.BlockTags;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.function.Supplier;

import static net.alexandra.malechia.MalechiaMod.MOD_ID;

public class MalechiaBlockTags {
    public static TagKey<Block> ETHEREAL_GRASS;
    public static void initialize() {
        // This will not be present, but it should return an empty tag
        // This will act like a normal tag, we have emerald block here
        ETHEREAL_GRASS = TagKey.of(Registry.BLOCK_KEY, new Identifier(MOD_ID, "ethereal_grass"));
    }
}
