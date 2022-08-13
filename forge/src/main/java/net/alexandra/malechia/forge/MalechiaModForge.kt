package net.alexandra.malechia.forge

import dev.architectury.platform.forge.EventBuses
import net.alexandra.malechia.MalechiaMod
import net.alexandra.malechia.MalechiaMod.MOD_ID
import net.alexandra.malechia.block.ModBlocks
import net.alexandra.malechia.forge.util.MalechiaModelPredicateProvider
import net.minecraft.client.MinecraftClient
import net.minecraft.client.render.RenderLayer
import net.minecraft.client.render.RenderLayers
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import thedarkcolour.kotlinforforge.forge.MOD_BUS
import thedarkcolour.kotlinforforge.forge.runForDist

@Mod(MOD_ID)
@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
object MalechiaModForge {

    // the logger for our mod
    val LOGGER: Logger = LogManager.getLogger(MOD_ID)

    init {
        EventBuses.registerModEventBus(MOD_ID, MOD_BUS)
//        LOGGER.info("Malechia Forge is starting!")
        net.alexandra.malechia.MalechiaMod.init()

        // Register the KDeferredRegister to the mod-specific event bus

        val obj = runForDist(
            clientTarget = {
                MOD_BUS.addListener(::onClientSetup)
                MinecraftClient.getInstance()
            },
            serverTarget = {
                MOD_BUS.addListener(::onServerSetup)
                "test"
            })

        println(obj)
    }

    /**
     * This is used for initializing client specific
     * things such as renderers and keymaps
     * Fired on the mod specific event bus.
     */
    private fun onClientSetup(event: FMLClientSetupEvent) {
        RenderLayers.setRenderLayer(net.alexandra.malechia.block.ModBlocks.INFINITY_STAINED_GLASS.get(), RenderLayer.getTranslucent())
        RenderLayers.setRenderLayer(net.alexandra.malechia.block.ModBlocks.PURE_ETHEREAL_CRYSTAL_BLOCK.get(), RenderLayer.getTranslucent())
        RenderLayers.setRenderLayer(net.alexandra.malechia.block.ModBlocks.ETHEREAL_BUSH.get(), RenderLayer.getCutout())
        RenderLayers.setRenderLayer(net.alexandra.malechia.block.ModBlocks.ETHEREAL_LEAVES.get(), RenderLayer.getCutout())
        MalechiaModelPredicateProvider.registerModModels()
    }

    /**
     * Fired on the global Forge bus.
     */
    private fun onServerSetup(event: FMLDedicatedServerSetupEvent) {
    }
}