package net.alexandra.malechia.item.custom;

import dev.architectury.event.events.client.ClientTickEvent;
import net.alexandra.malechia.dimension.ModDimensions;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.TeleportTarget;
import net.minecraft.world.World;
import net.minecraft.world.border.WorldBorder;
import net.minecraft.world.dimension.DimensionType;
import org.jetbrains.annotations.Nullable;
import org.quiltmc.qsl.worldgen.dimension.api.QuiltDimensions;

import java.util.List;

import static net.alexandra.malechia.util.TestKeybinds.keyBinding;

public class EtherealTeleporterItem extends ToolItem {
    public static ItemStack stack;
    public static String destination = "ethereal_core";
    public static TooltipContext tooltipContext;
    public EtherealTeleporterItem(ToolMaterial material, Settings settings) {
        super(material, settings);
    }

    @Environment(EnvType.CLIENT)
    public void keybindUse(World world) {
        ClientTickEvent.CLIENT_POST.register(instance -> {
            if (this instanceof CustomizableTeleporterItem && keyBinding.isPressed()) {
                if (destination.equals("overworld")) {
                    destination = "end";
                    setStringNBT(stack);
                } else if (destination.equals("end")) {
                    destination = "ethereal_core";
                    setStringNBT(stack);
                } else if (destination.equals("ethereal_core") && world.getRegistryKey() != ModDimensions.ETHEREAL_CORE_DIMENSION_KEY) {
                    destination = "overworld";
                    setStringNBT(stack);
                } else if (destination.equals("ethereal_core")) {
                    destination = "overworld";// temporary
                    setStringNBT(stack);
                }
            }
        });
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        stack = user.getStackInHand(hand);
        if(world != null && world.getServer() != null) {
            MinecraftServer minecraftserver = world.getServer();
            keybindUse(world);
            if (this instanceof CustomizableTeleporterItem) {
                switch (destination) {
                    case "overworld" -> {
                        RegistryKey<World> destinationoverworld = user.world.getRegistryKey() == World.NETHER
                                ? World.OVERWORLD : World.NETHER;
                        ServerWorld destinationWorld = minecraftserver.getWorld(destinationoverworld);
                        if (user.canUsePortals() && destinationWorld != null) {
                            user.moveToWorld(destinationWorld);
                        }
                    }
                    case "end" -> {
                        RegistryKey<World> destinationend = user.world.getRegistryKey() == World.END
                                ? World.OVERWORLD : World.END;
                        ServerWorld destinationWorld = minecraftserver.getWorld(destinationend);
                        if (user.canUsePortals() && destinationWorld != null) {
                            user.moveToWorld(destinationWorld);
                        }
                    }
                    case "ethereal_core" -> {
                        RegistryKey<World> destinationcore = user.world.getRegistryKey() == ModDimensions.ETHEREAL_CORE_DIMENSION_KEY
                                ? World.OVERWORLD : ModDimensions.ETHEREAL_CORE_DIMENSION_KEY;
                        ServerWorld destinationWorld = minecraftserver.getWorld(destinationcore);
                        if (user.canUsePortals() && user.isCreative() || user.getNextLevelExperience() >= 70 || stack.getNbt().getBoolean("canUse") && destinationWorld != null) {
                            setNBT(stack);
                            WorldBorder worldBorder = destinationWorld.getWorldBorder();
                            double d = DimensionType.getCoordinateScaleFactor(world.getDimension(), destinationWorld.getDimension());
                            BlockPos blockPos = worldBorder.method_39538(user.getX() * d, user.getY(), user.getZ() * d);
                            QuiltDimensions.teleport(user, destinationWorld, new TeleportTarget(
                                    new Vec3d((double)blockPos.getX() + 0.5, (double)blockPos.getY(), (double)blockPos.getZ() + 0.5), user.getVelocity(), user.getYaw(), user.getPitch()
                            ));
                        }
                    }
                }
            } else {
                RegistryKey<World> destinationcore = user.world.getRegistryKey() == ModDimensions.ETHEREAL_CORE_DIMENSION_KEY
                        ? World.OVERWORLD : ModDimensions.ETHEREAL_CORE_DIMENSION_KEY;
                ServerWorld destinationWorld = minecraftserver.getWorld(destinationcore);
                if (user.canUsePortals() && user.isCreative() || user.getNextLevelExperience() >= 70 || stack.getNbt().getBoolean("canUse") && destinationWorld != null) {
                    setNBT(stack);
                    WorldBorder worldBorder = destinationWorld.getWorldBorder();
                    double d = DimensionType.getCoordinateScaleFactor(world.getDimension(), destinationWorld.getDimension());
                    BlockPos blockPos = worldBorder.method_39538(user.getX() * d, user.getY(), user.getZ() * d);
                    QuiltDimensions.teleport(user, destinationWorld, new TeleportTarget(
                            new Vec3d((double)blockPos.getX() + 0.5, (double)blockPos.getY(), (double)blockPos.getZ() + 0.5), user.getVelocity(), user.getYaw(), user.getPitch()
                    ));
                }
            }
        }
        return super.use(world, user, hand);
    }
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltipContext = context;
        if(this instanceof CustomizableTeleporterItem) {
            tooltip.add(Text.literal("Press X to change the destination").formatted(Formatting.AQUA));
            tooltip.add(Text.literal(destination).formatted(Formatting.RED));
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
    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(tooltipContext != null && entity.isPlayer()){
            stack.getTooltip((PlayerEntity) entity, tooltipContext);
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }
}
