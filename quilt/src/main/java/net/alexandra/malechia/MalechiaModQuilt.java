package net.alexandra.malechia;

import net.alexandra.malechia.block.ModBlocks;
import net.alexandra.malechia.block.QuiltOnlyBlocks;
import net.alexandra.malechia.dimension.ModDimensions;
import net.alexandra.malechia.effects.ModEffects;
import net.alexandra.malechia.enchantments.ModEnchantments;
import net.alexandra.malechia.item.ModItems;
import net.alexandra.malechia.tag.MalechiaBlockTags;
import net.alexandra.malechia.util.ModRegistries;
import net.alexandra.malechia.world.biome.MalechiaBuiltinBiomes;
import net.alexandra.malechia.world.gen.ModWorldGen;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MalechiaModQuilt implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = MalechiaMod.MOD_ID;
	public static final Logger LOGGER = MalechiaMod.LOGGER;

	@Override
	public void onInitialize(ModContainer mod) {
		MalechiaMod.init();
		LOGGER.info("Malechia Quilt is starting!");
		QuiltOnlyBlocks.registerQuiltBlocks();
		CustomPortalBuilder.beginPortal()
				.frameBlock(ModBlocks.PURE_ETHEREAL_CRYSTAL_BLOCK.get())
				.flatPortal()
				.onlyLightInOverworld()
				.lightWithItem(Items.DRAGON_BREATH)
				.destDimID(new Identifier(ModDimensions.ETHEREAL_CORE_DIMENSION_KEY.getValue().getNamespace()+ModDimensions.ETHEREAL_CORE_DIMENSION_KEY.getValue().getPath()))
				.tintColor(0, 197, 255)
				.registerPortal();
		ModRegistries.registerModStuffs();
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
	}
}
