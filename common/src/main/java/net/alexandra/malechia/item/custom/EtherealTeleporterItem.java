package net.alexandra.malechia.item.custom;

import com.mojang.blaze3d.platform.InputUtil;
import dev.architectury.event.events.client.ClientTickEvent;
import dev.architectury.registry.client.keymappings.KeyMappingRegistry;
import net.alexandra.malechia.MalechiaMod;
import net.alexandra.malechia.dimension.ModDimensions;
import net.alexandra.malechia.util.InventoryUtil;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.client.option.KeyBind;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.Packet;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.minecraft.world.level.ServerWorldProperties;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.glfw.GLFW;

import java.util.List;

public class EtherealTeleporterItem extends ToolItem {
    public static ItemStack stack;
    public static String destination = "ethereal_core";
    public EtherealTeleporterItem(ToolMaterial material, Settings settings) {
        super(material, settings);
    }

    @Environment(EnvType.CLIENT)
    public void keybindUse(World world) {
        var mapping = new KeyBind("key.malechia.changedestination", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_X, "category.malechia-use");
        KeyMappingRegistry.register(mapping);
        ClientTickEvent.CLIENT_POST.register(instance -> {
            if(this instanceof CustomizableTeleporterItem && mapping.isPressed()) {
                if(destination == "overworld") {
                    destination = "end";
                    setStringNBT(stack);
                }else if(destination == "end"){
                    destination = "ethereal_core";
                    setStringNBT(stack);
                }else if(destination == "ethereal_core" && world.getRegistryKey() != ModDimensions.ETHEREAL_CORE_DIMENSION_KEY){
                    destination = "overworld";
                    setStringNBT(stack);
                }else if(destination == "ethereal_core"){
                    destination = "overworld";// temporary
                    setStringNBT(stack);
                }
            }
        });
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        stack = user.getStackInHand(hand);
        keybindUse(world);
        if(this instanceof CustomizableTeleporterItem) {
            if (destination == "overworld") {
                if (world.getRegistryKey() == ServerWorld.OVERWORLD) {
                    user.moveToWorld(world.getServer().getWorld(ServerWorld.NETHER));
                } else {
                    if (user.canUsePortals()) {
                        user.moveToWorld(world.getServer().getWorld(ServerWorld.OVERWORLD));
                    }
                }
            } else if (destination == "end") {
                if (world.getRegistryKey() == ServerWorld.END) {
                    user.moveToWorld(world.getServer().getWorld(ServerWorld.OVERWORLD));
                } else {
                    if (user.canUsePortals()) {
                        user.moveToWorld(world.getServer().getWorld(ServerWorld.END));
                    }
                }
            } else if (destination == "ethereal_core") {
                if (world.getRegistryKey() == ModDimensions.ETHEREAL_CORE_DIMENSION_KEY) {
                    user.moveToWorld(world.getServer().getWorld(ServerWorld.OVERWORLD));
                } else {
                    if (user.canUsePortals() && user.isCreative() || user.getNextLevelExperience() >= 70 || stack.getNbt().getBoolean("canUse")) {
                        user.moveToWorld(world.getServer().getWorld(ModDimensions.ETHEREAL_CORE_DIMENSION_KEY));
                    }
                }
            }
        }else {
            if (world.getRegistryKey() == ModDimensions.ETHEREAL_CORE_DIMENSION_KEY) {
                user.moveToWorld(world.getServer().getWorld(ServerWorld.OVERWORLD));
            } else {
                if (user.canUsePortals() && user.isCreative() || user.getNextLevelExperience() >= 70 || stack.getNbt().getBoolean("canUse")) {
                    user.moveToWorld(world.getServer().getWorld(ModDimensions.ETHEREAL_CORE_DIMENSION_KEY));
                }
            }
        }
        return super.use(world, user, hand);
    }
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(this instanceof CustomizableTeleporterItem) {
            if (destination == "overworld") {
                if (world.getRegistryKey() == ServerWorld.OVERWORLD) {
                    tooltip.add(Text.literal("Right-Click to go to the Nether").formatted(Formatting.DARK_AQUA));
                } else {
                    PlayerEntity user = (PlayerEntity) stack.getEntityHolder();
                    if (user.canUsePortals()) {
                        tooltip.add(Text.literal("Right-Click to return to the Overworld").formatted(Formatting.GREEN));
                    }else{
                        tooltip.add(Text.literal("Cannot return.").formatted(Formatting.RED));
                    }
                }
            } else if (destination == "end") {
                if (world.getRegistryKey() == ServerWorld.END) {
                    tooltip.add(Text.literal("Right-Click to return to the Overworld").formatted(Formatting.GREEN));
                } else {
                    PlayerEntity user = (PlayerEntity) stack.getEntityHolder();
                    if (user.canUsePortals()) {
                        tooltip.add(Text.literal("Right-Click to enter the End").formatted(Formatting.DARK_AQUA));
                    } else {
                        tooltip.add(Text.literal("Cannot use.").formatted(Formatting.RED));
                    }
                }
            } else if (destination == "ethereal_core") {
                if (world.getRegistryKey() == ModDimensions.ETHEREAL_CORE_DIMENSION_KEY) {
                    tooltip.add(Text.literal("Right-Click to return to the Overworld").formatted(Formatting.GREEN));
                } else {
                    PlayerEntity user = (PlayerEntity) stack.getEntityHolder();
                    if (user.canUsePortals() && user.isCreative() || user.getNextLevelExperience() >= 70 || stack.getNbt().getBoolean("canUse")) {
                        tooltip.add(Text.literal("Right-Click to enter the Ethereal Realm").formatted(Formatting.DARK_AQUA));
                        setNBT(stack);
                    } else {
                        tooltip.add(Text.literal("Cannot use yet.").formatted(Formatting.DARK_RED));
                    }
                }
            }
        }else{
            if (world.getRegistryKey() == ModDimensions.ETHEREAL_CORE_DIMENSION_KEY) {
                tooltip.add(Text.literal("Right-Click to return to the Overworld").formatted(Formatting.GREEN));
            } else if (stack.getEntityHolder().isPlayer()) {
                PlayerEntity user = (PlayerEntity) stack.getEntityHolder();
                if (user.canUsePortals() && user.isCreative() || user.getNextLevelExperience() >= 70 || stack.getNbt().getBoolean("canUse")) {
                    tooltip.add(Text.literal("Right-Click to enter the Ethereal Realm").formatted(Formatting.DARK_AQUA));
                    setNBT(stack);
                } else {
                    tooltip.add(Text.literal("Cannot use yet.").formatted(Formatting.DARK_RED));
                }
            }
        }
        super.appendTooltip(stack, world, tooltip, context);
    }
    private void setNBT(ItemStack itemStack) {
        NbtCompound nbtData = new NbtCompound();
        nbtData.putBoolean("canUse", true);

        itemStack.setNbt(nbtData);
    }
    private void setStringNBT(ItemStack itemStack) {
        NbtCompound nbtData = new NbtCompound();
        nbtData.putString("destination", destination);

        itemStack.setNbt(nbtData);

    }
}
