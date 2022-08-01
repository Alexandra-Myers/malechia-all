package net.alexandra.malechia.util;

import com.mojang.blaze3d.platform.InputUtil;
import dev.architectury.event.events.client.ClientTickEvent;
import dev.architectury.registry.client.keymappings.KeyMappingRegistry;
import net.alexandra.malechia.MalechiaMod;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.option.KeyBind;
import net.minecraft.client.resource.language.I18n;
import org.lwjgl.glfw.GLFW;

public class TestKeybinds {
    @Environment(EnvType.CLIENT)
    public static void initialize() {
    }
}