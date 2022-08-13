package net.alexandra.malechia.util;

import com.mojang.blaze3d.platform.InputUtil;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBind;
import org.lwjgl.glfw.GLFW;

public class TestKeybinds {
    public static KeyBind keyBinding;
    @Environment(EnvType.CLIENT)
    public static void initialize() {
        keyBinding = KeyBindingHelper.registerKeyBinding(new KeyBind(
                "key.malechia.destination", // The translation key of the keybinding's name
                InputUtil.Type.KEYSYM, // The type of the keybinding, KEYSYM for keyboard, MOUSE for mouse.
                GLFW.GLFW_KEY_X, // The keycode of the key
                "category.malechia.teleporter" // The translation key of the keybinding's category.
        ));
    }

}