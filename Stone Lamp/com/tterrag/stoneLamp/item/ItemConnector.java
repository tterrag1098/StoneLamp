package tterrag.stoneLamp.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import tterrag.stoneLamp.AkivarMod;
import tterrag.stoneLamp.block.ModBlock;
import tterrag.stoneLamp.config.ConfigKeys;

public class ItemConnector extends Item {

	public static String[] colors = new String[] { "Black", "Red", "Green",
			"Brown", "Blue", "Purple", "Cyan", "Light Gray", "Gray", "Pink",
			"Lime", "Yellow", "Light Blue", "Magenta", "Orange", "White" };

	public ItemConnector(int id) {
		super(id);
		setUnlocalizedName(ModItem.CONNECTOR_UNLOC_NAME);
		setCreativeTab(AkivarMod.tabStoneLamp);
	}

	private Icon icon;

	public void registerIcons(
			net.minecraft.client.renderer.texture.IconRegister par1IconRegister) {
		icon = par1IconRegister.registerIcon("akivarmod:wand");
	};

	@Override
	public Icon getIcon(ItemStack stack, int pass) {
		return icon;
	}

	@Override
	public Icon getIconFromDamage(int par1) {
		return icon;
	}

	@Override
	public boolean isFull3D() {
		return true;
	}

	@Override
	public boolean onItemUseFirst(ItemStack stack, EntityPlayer player,
			World world, int x, int y, int z, int side, float hitX, float hitY,
			float hitZ) {
		if (!world.isRemote && !player.isSneaking()) {
			int id = world.getBlockId(x, y, z);
			if (!ConfigKeys.allowColorChangeWithWand
					&& (id == ModBlock.LAMP_ID || id == ModBlock.EMPTYLAMP_ID)) {
				world.setBlockMetadataWithNotify(x, y, z,
						stack.getItemDamage(), 3);
			} else if (ConfigKeys.allowColorChangeWithWand
					&& (id == ModBlock.LAMP_ID || id == ModBlock.EMPTYLAMP_ID
							|| id == ModBlock.COLOREDLAMP_ID || id == ModBlock.EMPTYCOLOREDLAMP_ID)) {
				world.setBlockMetadataWithNotify(x, y, z,
						stack.getItemDamage(), 3);
			}
		}

		return super.onItemUseFirst(stack, player, world, x, y, z, side, hitX,
				hitY, hitZ);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world,
			EntityPlayer player) {
		if (player.isSneaking()) {
			if (ConfigKeys.maxChannel > 15)
				ConfigKeys.maxChannel = 15;
			if (stack.getItemDamage() < ConfigKeys.maxChannel)
				stack.setItemDamage(stack.getItemDamage() + 1);
			else
				stack.setItemDamage(0);

			if (world.isRemote && !ConfigKeys.allowColorChangeWithWand)
				player.addChatMessage("Channel: " + stack.getItemDamage());
			else if (world.isRemote && ConfigKeys.allowColorChangeWithWand) {
				player.addChatMessage("Channel " + stack.getItemDamage()
						+ ", Color: " + colors[stack.getItemDamage()]);
			}
		}
		return stack;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void addInformation(ItemStack par1ItemStack,
			EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		if (!ConfigKeys.allowColorChangeWithWand) {
			par3List.add("Can be used to disconnect same-type");
			par3List.add("lamps from others.");
		} else if (ConfigKeys.allowColorChangeWithWand) {
			par3List.add("Can be used to disconnect same-type");
			par3List.add("lamps from others, and change the");
			par3List.add("color of colored lamps.");
		}
	}
}
