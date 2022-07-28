package net.alexandra.malechia;


import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(MalechiaMod.MOD_ID)
public class MalechiaModForge {
    public MalechiaModForge() {
        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(MalechiaMod.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        MalechiaMod.init();
    }
    private void clientSetup(final FMLClientSetupEvent event) {
        
    }
}
