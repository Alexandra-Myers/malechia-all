package net.alexandra.malechia.tag;

import com.google.common.base.Suppliers;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.Registries;
import net.alexandra.malechia.MalechiaMod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tag.BlockTags;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.function.Supplier;

public class MalechiaBlockTags {
    public static final TagKey<Block> ETHEREAL_GRASS = MalechiaBlockTags.register("ethereal_grass");

    public MalechiaBlockTags() {
    }

    public static TagKey<Block> register(String id) {
        return TagKey.of(Registry.BLOCK_KEY, new Identifier(id));
    }
    public static void registerModBlockTags() {
    }
}
