package tterrag.stoneLamp.common.item;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import tterrag.stoneLamp.StoneLamps;
import tterrag.stoneLamp.common.block.ModBlock;
import tterrag.stoneLamp.common.config.ConfigKeys;
import tterrag.stoneLamp.common.lib.Reference;
import cpw.mods.fml.common.Loader;

public class ItemConnector extends Item
{

	public static String[] colors = new String[] { "Black", "Red", "Green", "Brown", "Blue", "Purple", "Cyan", "Light Gray", "Gray", "Pink", "Lime", "Yellow", "Light Blue", "Magenta", "Orange", "White" };

	public ItemConnector()
	{
		super();
		setUnlocalizedName(ModItem.CONNECTOR_UNLOC_NAME);
		setCreativeTab(StoneLamps.tabStoneLamp);
	}

	private IIcon icon;

	@Override
	public void registerIcons(IIconRegister par1IconRegister)
	{
		icon = par1IconRegister.registerIcon(Reference.MOD_TEXTUREPATH + ":wand");
	};

	@Override
	public IIcon getIcon(ItemStack stack, int pass)
	{
		return icon;
	}

	@Override
	public IIcon getIconFromDamage(int par1)
	{
		return icon;
	}

	@Override
	public boolean isFull3D()
	{
		return true;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
	{
		System.out.println(Loader.isModLoaded("tahgMod") && !player.isSneaking() && !world.isRemote);
		if (!world.isRemote && !player.isSneaking())
		{
			Block block = world.getBlock(x, y, z);
			if (!ConfigKeys.allowColorChangeWithWand && (block == ModBlock.lamp || block == ModBlock.emptyLamp))
			{
				world.setBlockMetadataWithNotify(x, y, z, stack.getItemDamage(), 3);
			}
			else if (ConfigKeys.allowColorChangeWithWand && (block == ModBlock.lamp || block == ModBlock.emptyLamp || block == ModBlock.coloredLamp || block == ModBlock.emptyColoredLamp))
			{
				world.setBlockMetadataWithNotify(x, y, z, stack.getItemDamage(), 3);
			}
			if (Loader.isModLoaded("tahgMod"))
			{
				Class c;
				System.out.println("SNEAKING: " + player.isSneaking());
				try
				{
					c = Class.forName("com.tterrag.mod.block.ModBlock");

					if (c != null && c.getField("FANCY_CT_STONE_ID").get(c) == world.getBlock(x, y, z))
					{
						world.setBlockMetadataWithNotify(x, y, z, stack.getItemDamage(), 3);
					}
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
			return true;
		}
		else return false;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		if (player.isSneaking())
		{
			if (ConfigKeys.maxChannel > 15) ConfigKeys.maxChannel = 15;
			if (stack.getItemDamage() < ConfigKeys.maxChannel)
				stack.setItemDamage(stack.getItemDamage() + 1);
			else stack.setItemDamage(0);

			if (world.isRemote && !ConfigKeys.allowColorChangeWithWand)
				player.addChatMessage(new ChatComponentText("Channel: " + stack.getItemDamage()));
			else if (world.isRemote && ConfigKeys.allowColorChangeWithWand)
			{
				player.addChatMessage(new ChatComponentText("Channel " + stack.getItemDamage() + ", Color: " + colors[stack.getItemDamage()]));
			}
		}
		return stack;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		if (!ConfigKeys.allowColorChangeWithWand)
		{
			par3List.add("Can be used to disconnect same-type");
			par3List.add("lamps from others.");
		}
		else if (ConfigKeys.allowColorChangeWithWand)
		{
			par3List.add("Can be used to disconnect same-type");
			par3List.add("lamps from others, and change the");
			par3List.add("color of colored lamps.");
		}
	}
}
