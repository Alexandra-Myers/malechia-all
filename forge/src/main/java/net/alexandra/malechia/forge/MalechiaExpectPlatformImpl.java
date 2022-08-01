package net.alexandra.malechia.forge;

import net.alexandra.malechia.MalechiaExpectPlatform;
import net.minecraftforge.fml.loading.FMLPaths;

import java.nio.file.Path;

public class MalechiaExpectPlatformImpl {
    public static Path getConfigDirectory() {
        return FMLPaths.CONFIGDIR.get();
    }
}
