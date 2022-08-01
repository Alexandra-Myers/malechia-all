package net.alexandra.malechia.fabric;

import net.alexandra.malechia.MalechiaExpectPlatform;
import org.quiltmc.loader.api.QuiltLoader;

import java.nio.file.Path;

public class MalechiaExpectPlatformImpl {
    public static Path getConfigDirectory() {
        return QuiltLoader.getConfigDir();
    }
}
