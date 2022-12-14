package net.alexandra.malechia.item.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.alexandra.atlas.atlas_combat.item.NewAttributes;
import net.alexandra.atlas.atlas_combat.item.WeaponType;
import net.alexandra.malechia.util.InventoryUtil;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.tag.BlockTags;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MonadoItem extends ToolItem {
	private final float attackDamage;
	private final float activeAttackBoost;
	private Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;
	public EntityAttributeModifier modifier;
	public static ItemStack stack;
	public static boolean isActive = false;
	public ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder2 = ImmutableMultimap.builder();
	public ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();

	public MonadoItem(ToolMaterial toolMaterial, int i, int tier, Settings settings) {
		super(toolMaterial, settings);
		this.activeAttackBoost = tier*0.5f;
		this.attackDamage = (float)i + toolMaterial.getAttackDamage() + 10;
		this.modifier = new EntityAttributeModifier(WeaponType.BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", (double)this.attackDamage, EntityAttributeModifier.Operation.ADDITION);
		builder.put(
				EntityAttributes.GENERIC_ATTACK_DAMAGE,
				modifier
		);
		builder.put(
				EntityAttributes.GENERIC_ATTACK_SPEED,
				new EntityAttributeModifier(WeaponType.BASE_ATTACK_SPEED_UUID, "Weapon modifier", (double)1.0, EntityAttributeModifier.Operation.ADDITION)
		);
		builder.put(
				NewAttributes.ATTACK_REACH,
				new EntityAttributeModifier(WeaponType.BASE_ATTACK_REACH_UUID, "Weapon modifier", (double)1.0, EntityAttributeModifier.Operation.ADDITION)
		);
		builder2.put(
				EntityAttributes.GENERIC_ATTACK_DAMAGE,
			     new EntityAttributeModifier(modifier.getId(), modifier.getName(), (double)attackDamage+100*activeAttackBoost, modifier.getOperation())
		);
		builder2.put(
				EntityAttributes.GENERIC_ATTACK_SPEED,
				new EntityAttributeModifier(WeaponType.BASE_ATTACK_SPEED_UUID, "Weapon modifier", (double)2.0, EntityAttributeModifier.Operation.ADDITION)
		);
		builder2.put(
				NewAttributes.ATTACK_REACH,
				new EntityAttributeModifier(WeaponType.BASE_ATTACK_REACH_UUID, "Weapon modifier", (double)1.5, EntityAttributeModifier.Operation.ADDITION)
		);
		this.attributeModifiers = builder.build();
	}

	@Override
	public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
		tooltip.add(Text.literal("Right-Click to activate the Monado").formatted(Formatting.RED));
		super.appendTooltip(stack, world, tooltip, context);
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		stack = user.getStackInHand(hand);
		if(isActive != stack.getNbt().getBoolean("isActive")){
			isActive = stack.getNbt().getBoolean("isActive");
			if(!isActive){
				isActive = true;
				if(InventoryUtil.hasPlayerStackInInventory(user, stack.getItem())) {
					setNBT(stack);
				}
				attributeModifiers = builder2.build();
			}else {
				isActive = false;
				if(InventoryUtil.hasPlayerStackInInventory(user, stack.getItem())) {
					setNBT(stack);
				}
				attributeModifiers = builder.build();
			}
		}else {
			if(!isActive){
				isActive = true;
				if(InventoryUtil.hasPlayerStackInInventory(user, stack.getItem())) {
					setNBT(stack);
				}
				attributeModifiers = builder2.build();
			}else {
				isActive = false;
				if(InventoryUtil.hasPlayerStackInInventory(user, stack.getItem())) {
					setNBT(stack);
				}
				attributeModifiers = builder.build();
			}
		}
		return super.use(world, user, hand);
	}
	private void setNBT(ItemStack itemStack) {
		NbtCompound nbtData = new NbtCompound();
		nbtData.putBoolean("isActive", isActive);

		itemStack.setNbt(nbtData);
	}
	@Override
	public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity miner) {
		return !miner.isCreative();
	}

	@Override
	public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
		if (state.isOf(Blocks.COBWEB)) {
			return 15.0F;
		} else {
			Material material = state.getMaterial();
			return material != Material.PLANT && material != Material.REPLACEABLE_PLANT && !state.isIn(BlockTags.LEAVES) && material != Material.GOURD ? 1.0F : 1.5F;
		}
	}
	@Override
	public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
		return slot == EquipmentSlot.MAINHAND ? this.attributeModifiers : super.getAttributeModifiers(slot);
	}
}
