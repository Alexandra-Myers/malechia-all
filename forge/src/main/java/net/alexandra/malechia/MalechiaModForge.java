package net.alexandra.malechia;


import dev.architectury.platform.forge.EventBuses;
import net.alexandra.malechia.block.ModBlocks;
import net.alexandra.malechia.util.MalechiaModelPredicateProvider;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderLayers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(MalechiaMod.MOD_ID)
public class MalechiaModForge {
    public MalechiaModForge() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(MalechiaMod.MOD_ID, eventBus);
        MalechiaMod.init();
        eventBus.addListener(this::clientSetup);
    }
    private void clientSetup(final FMLClientSetupEvent event) {
        RenderLayers.setRenderLayer(ModBlocks.INFINITY_STAINED_GLASS.get(), RenderLayer.getTranslucent());
        RenderLayers.setRenderLayer(ModBlocks.PURE_ETHEREAL_CRYSTAL_BLOCK.get(), RenderLayer.getTranslucent());
        RenderLayers.setRenderLayer(ModBlocks.ETHEREAL_BUSH.get(), RenderLayer.getCutout());
        RenderLayers.setRenderLayer(ModBlocks.ETHEREAL_LEAVES.get(), RenderLayer.getCutout());
        MalechiaModelPredicateProvider.registerModModels();
    }
}
