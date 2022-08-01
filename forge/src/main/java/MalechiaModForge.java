import dev.architectury.platform.forge.EventBuses;
import net.alexandra.malechia.MalechiaMod;
import net.alexandra.malechia.block.ModBlocks;
import net.alexandra.malechia.forge.util.MalechiaModelPredicateProvider;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderLayers;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
//import thedarkcolour.kotlinforforge.forge.ForgeKt;

import static net.alexandra.malechia.MalechiaMod.LOGGER;
import static net.alexandra.malechia.MalechiaMod.MOD_ID;

@Mod(MOD_ID)
public class MalechiaModForge {
    public MalechiaModForge() {
        MinecraftForge.EVENT_BUS.register(this);
        // Submit our event bus to let architectury register our content on the right time
//        EventBuses.registerModEventBus(MOD_ID, ForgeKt.getMOD_BUS());
        EventBuses.registerModEventBus(MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
    }
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            RenderLayers.setRenderLayer(ModBlocks.INFINITY_STAINED_GLASS.get(), RenderLayer.getTranslucent());
            RenderLayers.setRenderLayer(ModBlocks.PURE_ETHEREAL_CRYSTAL_BLOCK.get(), RenderLayer.getTranslucent());
            RenderLayers.setRenderLayer(ModBlocks.ETHEREAL_BUSH.get(), RenderLayer.getCutout());
            RenderLayers.setRenderLayer(ModBlocks.ETHEREAL_LEAVES.get(), RenderLayer.getCutout());
            MalechiaModelPredicateProvider.registerModModels();
            LOGGER.info("Initializing client...");
        }
    }
}
