package tterrag.stoneLamp.common.block;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import tterrag.stoneLamp.common.config.ConfigKeys;

public class BlockColoredLamp extends BlockLamp
{
	private int color;
	private float lightVal;

	public BlockColoredLamp(float lightValue, String unlocName)
	{
		super(lightValue, unlocName);
		lightVal = lightValue;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void getSubBlocks(Item Item, CreativeTabs creativeTab, List list)
	{
		for (int i = 0; i <= 15; i++)
		{
			list.add(new ItemStack(this, 1, i));
		}
	}

	@Override
	public int getBlockColor()
	{
		if (ConfigKeys.allowNewRenderer) return super.getBlockColor();

		if (lightVal == 0.9F)
		{
			switch (color)
			{
			case 0:
				return (12 << 16) | (12 << 8) | 12;
			case 1:
				return (255 << 16) | (24 << 8) | 24;
			case 2:
				return (24 << 16) | (255 << 8) | 24;
			case 3:
				return (76 << 16) | (48 << 8) | 40;
			case 4:
				return (24 << 16) | (24 << 8) | 255;
			case 5:
				return (150 << 16) | (48 << 8) | 255;
			case 6:
				return (32 << 16) | (124 << 8) | 196;
			case 7:
				return (160 << 16) | (160 << 8) | 150;
			case 8:
				return (80 << 16) | (80 << 8) | 80;
			case 9:
				return (255 << 16) | (110 << 8) | 255;
			case 10:
				return (105 << 16) | (206 << 8) | 64;
			case 11:
				return (255 << 16) | (255 << 8) | 24;
			case 12:
				return (120 << 16) | (200 << 8) | 255;
			case 13:
				return (255 << 16) | (24 << 8) | 255;
			case 14:
				return (255 << 16) | (125 << 8) | 24;
			case 15:
			default:
				return (255 << 16) | (255 << 8) | 255;
			}
		}
		else switch (color)
		{
		case 0:
			return (10 << 16) | (10 << 8) | 10;
		case 1:
			return (150 << 16) | (10 << 8) | 10;
		case 2:
			return (10 << 16) | (150 << 8) | 10;
		case 3:
			return (50 << 16) | (30 << 8) | 20;
		case 4:
			return (10 << 16) | (10 << 8) | 150;
		case 5:
			return (120 << 16) | (20 << 8) | 150;
		case 6:
			return (15 << 16) | (90 << 8) | 140;
		case 7:
			return (140 << 16) | (140 << 8) | 140;
		case 8:
			return (60 << 16) | (60 << 8) | 60;
		case 9:
			return (200 << 16) | (80 << 8) | 200;
		case 10:
			return (80 << 16) | (170 << 8) | 40;
		case 11:
			return (150 << 16) | (150 << 8) | 10;
		case 12:
			return (80 << 16) | (150 << 8) | 190;
		case 13:
			return (160 << 16) | (10 << 8) | 160;
		case 14:
			return (180 << 16) | (80 << 8) | 10;
		case 15:
			return (200 << 16) | (200 << 8) | 200;
		default:
			return (200 << 16) | (200 << 8) | 200;
		}
	}

	@Override
	public int colorMultiplier(IBlockAccess par1iBlockAccess, int par2, int par3, int par4)
	{
		if (ConfigKeys.allowNewRenderer) return super.colorMultiplier(par1iBlockAccess, par2, par3, par4);

		color = par1iBlockAccess.getBlockMetadata(par2, par3, par4);
		switch (color)
		{
		case 0:
			return (12 << 16) | (12 << 8) | 12;
		case 1:
			return (255 << 16) | (24 << 8) | 24;
		case 2:
			return (24 << 16) | (255 << 8) | 24;
		case 3:
			return (76 << 16) | (48 << 8) | 40;
		case 4:
			return (24 << 16) | (24 << 8) | 255;
		case 5:
			return (150 << 16) | (48 << 8) | 255;
		case 6:
			return (32 << 16) | (124 << 8) | 196;
		case 7:
			return (160 << 16) | (160 << 8) | 160;
		case 8:
			return (80 << 16) | (80 << 8) | 80;
		case 9:
			return (255 << 16) | (110 << 8) | 255;
		case 10:
			return (105 << 16) | (206 << 8) | 64;
		case 11:
			return (255 << 16) | (255 << 8) | 24;
		case 12:
			return (120 << 16) | (200 << 8) | 255;
		case 13:
			return (255 << 16) | (24 << 8) | 255;
		case 14:
			return (255 << 16) | (125 << 8) | 24;
		case 15:
			return (200 << 16) | (200 << 8) | 200;
		default:
			return (200 << 16) | (200 << 8) | 200;
		}
	}

	@Override
	public int damageDropped(int par1)
	{
		return par1;
	}

	@Override
	public int getRenderColor(int par1)
	{
		color = par1;
		return getBlockColor();
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
	{
		Item item = null;
		if (player.inventory.getCurrentItem() != null)
			item = player.inventory.getCurrentItem().getItem();
		else return super.onBlockActivated(world, x, y, z, player, par6, par7, par8, par9);
		if (item == Items.dye && player.inventory.getCurrentItem().getItemDamage() != world.getBlockMetadata(x, y, z))
		{
			world.setBlockMetadataWithNotify(x, y, z, player.inventory.getCurrentItem().getItemDamage(), 3);
			if (!player.capabilities.isCreativeMode) player.inventory.getCurrentItem().stackSize--;
		}
		else if (item == Items.water_bucket)
		{
			world.setBlock(x, y, z, world.getBlock(x, y, z) == ModBlock.coloredLamp ? ModBlock.lamp : ModBlock.emptyLamp);
			if (!player.capabilities.isCreativeMode) player.inventory.mainInventory[player.inventory.currentItem] = new ItemStack(player.inventory.getCurrentItem().getItem().getContainerItem());
		}
		return super.onBlockActivated(world, x, y, z, player, par6, par7, par8, par9);
	}

}
