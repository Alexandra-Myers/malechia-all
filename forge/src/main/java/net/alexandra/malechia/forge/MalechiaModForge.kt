package net.alexandra.malechia.forge

import dev.architectury.platform.forge.EventBuses
import net.alexandra.malechia.MalechiaMod
import net.alexandra.malechia.block.ModBlocks
import net.alexandra.malechia.forge.util.MalechiaModelPredicateProvider
import net.minecraft.client.MinecraftClient
import net.minecraft.client.render.RenderLayer
import net.minecraft.client.render.RenderLayers
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent
import org.apache.logging.log4j.Level
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import thedarkcolour.kotlinforforge.forge.MOD_BUS
import thedarkcolour.kotlinforforge.forge.runForDist

@Mod(MalechiaModForge.ID)
object MalechiaModForge {
    const val ID: String = "malechia"

    // the logger for our mod
    val LOGGER: Logger = LogManager.getLogger(ID)

    init {
        LOGGER.log(Level.INFO, "Hello world!")
        EventBuses.registerModEventBus("malechia", MOD_BUS)
        LOGGER.info("Malechia Forge is starting!")
        MalechiaMod.init()

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
        RenderLayers.setRenderLayer(ModBlocks.INFINITY_STAINED_GLASS.get(), RenderLayer.getTranslucent())
        RenderLayers.setRenderLayer(ModBlocks.PURE_ETHEREAL_CRYSTAL_BLOCK.get(), RenderLayer.getTranslucent())
        RenderLayers.setRenderLayer(ModBlocks.ETHEREAL_BUSH.get(), RenderLayer.getCutout())
        RenderLayers.setRenderLayer(ModBlocks.ETHEREAL_LEAVES.get(), RenderLayer.getCutout())
        MalechiaModelPredicateProvider.registerModModels()
        LOGGER.log(Level.INFO, "Initializing client...")
    }

    /**
     * Fired on the global Forge bus.
     */
    private fun onServerSetup(event: FMLDedicatedServerSetupEvent) {
        LOGGER.log(Level.INFO, "Server starting...")
    }
}