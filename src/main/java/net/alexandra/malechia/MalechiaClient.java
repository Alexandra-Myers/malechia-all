package net.alexandra.malechia;

import net.alexandra.malechia.block.ModBlocks;
import net.alexandra.malechia.block.QuiltOnlyBlocks;
import net.alexandra.malechia.util.MalechiaModelPredicateProvider;
import net.alexandra.malechia.util.TestKeybinds;
import net.minecraft.client.render.RenderLayer;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;
import org.quiltmc.qsl.block.extensions.api.client.BlockRenderLayerMap;

public class MalechiaClient implements ClientModInitializer {

	@Override
	public void onInitializeClient(ModContainer mod) {
		BlockRenderLayerMap.put(RenderLayer.getTranslucent(), ModBlocks.INFINITY_STAINED_GLASS.get());
		BlockRenderLayerMap.put(RenderLayer.getTranslucent(), ModBlocks.PURE_ETHEREAL_CRYSTAL_BLOCK.get());
		BlockRenderLayerMap.put(RenderLayer.getCutout(), QuiltOnlyBlocks.ETHEREAL_BUSH.get());
		BlockRenderLayerMap.put(RenderLayer.getCutout(), ModBlocks.ETHEREAL_LEAVES.get());
		MalechiaModelPredicateProvider.registerModModels();
		TestKeybinds.initialize();
	}
}
