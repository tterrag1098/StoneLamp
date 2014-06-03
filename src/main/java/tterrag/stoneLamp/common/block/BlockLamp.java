package tterrag.stoneLamp.common.block;

import java.util.List;

import javax.swing.Icon;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import tterrag.stoneLamp.AkivarMod;
import tterrag.stoneLamp.client.renderers.LampRenderer;
import tterrag.stoneLamp.common.config.ConfigKeys;
import tterrag.stoneLamp.common.item.ModItem;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockLamp extends Block
{

	private float lightVal;

	public BlockLamp(float lightValue, String unlocName)
	{
		super(Material.glass);
		setLightLevel(lightValue);
		lightVal = lightValue;
		setCreativeTab(AkivarMod.tabStoneLamp);
		setHardness(0.6F);
		setBlockName(unlocName);
	}

	@SideOnly(Side.CLIENT)
	private Icon icon;

	@Override
	public int onBlockPlaced(World world, int x, int y, int z, int par5, float par6, float par7, float par8, int par9)
	{

		for (int i = -1; i <= 1; i++)
			for (int j = -1; j <= 1; j++)
				world.markBlockForUpdate(x + i, y, z + i);

		return super.onBlockPlaced(world, x, y, z, par5, par6, par7, par8, par9);
	}

	/** Begin fuj1n (Tcon) code **/

	public static IIcon[] icons = new IIcon[16];
	protected String folder;

	/**
	 * This is checked to see if the texture should connect to this block
	 * 
	 * @param par2
	 *            x
	 * @param par3
	 *            y
	 * @param par4
	 *            z
	 * @param par5
	 *            ID this block is asking to connect to (may be 0 if there is no
	 *            block)
	 * @param par6
	 *            Metadata of the block this block is trying to connect to
	 * @return true if should connect
	 */
	public boolean shouldConnectToBlock(IBlockAccess par1IBlockAccess, int x, int y, int z, Block par5, int par6)
	{
		return par5 == this && par1IBlockAccess.getBlockMetadata(x, y, z) == par6;
	}

	@Override
	public IIcon getIcon(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int p_149673_5_)
	{
		return getConnectedBlockTexture(par1IBlockAccess, par2, par3, par4, p_149673_5_, icons);
	}

	public IIcon getConnectedBlockTexture(IBlockAccess block, int x, int y, int z, int side, IIcon[] icons2)
	{
		boolean isOpenUp = false, isOpenDown = false, isOpenLeft = false, isOpenRight = false;

		if (!ConfigKeys.allowConnectedTextures) return icons2[0];

		switch (side)
		{
		case 0:
			if (shouldConnectToBlock(block, x, y, z, block.getBlock(x - 1, y, z), block.getBlockMetadata(x - 1, y, z)))
			{
				isOpenDown = true;
			}

			if (shouldConnectToBlock(block, x, y, z, block.getBlock(x + 1, y, z), block.getBlockMetadata(x + 1, y, z)))
			{
				isOpenUp = true;
			}

			if (shouldConnectToBlock(block, x, y, z, block.getBlock(x, y, z - 1), block.getBlockMetadata(x, y, z - 1)))
			{
				isOpenLeft = true;
			}

			if (shouldConnectToBlock(block, x, y, z, block.getBlock(x, y, z + 1), block.getBlockMetadata(x, y, z + 1)))
			{
				isOpenRight = true;
			}

			if (isOpenUp && isOpenDown && isOpenLeft && isOpenRight)
			{
				return icons2[15];
			}
			else if (isOpenUp && isOpenDown && isOpenLeft)
			{
				return icons2[11];
			}
			else if (isOpenUp && isOpenDown && isOpenRight)
			{
				return icons2[12];
			}
			else if (isOpenUp && isOpenLeft && isOpenRight)
			{
				return icons2[13];
			}
			else if (isOpenDown && isOpenLeft && isOpenRight)
			{
				return icons2[14];
			}
			else if (isOpenDown && isOpenUp)
			{
				return icons2[5];
			}
			else if (isOpenLeft && isOpenRight)
			{
				return icons2[6];
			}
			else if (isOpenDown && isOpenLeft)
			{
				return icons2[8];
			}
			else if (isOpenDown && isOpenRight)
			{
				return icons2[10];
			}
			else if (isOpenUp && isOpenLeft)
			{
				return icons2[7];
			}
			else if (isOpenUp && isOpenRight)
			{
				return icons2[9];
			}
			else if (isOpenDown)
			{
				return icons2[3];
			}
			else if (isOpenUp)
			{
				return icons2[4];
			}
			else if (isOpenLeft)
			{
				return icons2[2];
			}
			else if (isOpenRight)
			{
				return icons2[1];
			}
			break;
		case 1:
			if (shouldConnectToBlock(block, x, y, z, block.getBlock(x - 1, y, z), block.getBlockMetadata(x - 1, y, z)))
			{
				isOpenDown = true;
			}

			if (shouldConnectToBlock(block, x, y, z, block.getBlock(x + 1, y, z), block.getBlockMetadata(x + 1, y, z)))
			{
				isOpenUp = true;
			}

			if (shouldConnectToBlock(block, x, y, z, block.getBlock(x, y, z - 1), block.getBlockMetadata(x, y, z - 1)))
			{
				isOpenLeft = true;
			}

			if (shouldConnectToBlock(block, x, y, z, block.getBlock(x, y, z + 1), block.getBlockMetadata(x, y, z + 1)))
			{
				isOpenRight = true;
			}

			if (isOpenUp && isOpenDown && isOpenLeft && isOpenRight)
			{
				return icons2[15];
			}
			else if (isOpenUp && isOpenDown && isOpenLeft)
			{
				return icons2[11];
			}
			else if (isOpenUp && isOpenDown && isOpenRight)
			{
				return icons2[12];
			}
			else if (isOpenUp && isOpenLeft && isOpenRight)
			{
				return icons2[13];
			}
			else if (isOpenDown && isOpenLeft && isOpenRight)
			{
				return icons2[14];
			}
			else if (isOpenDown && isOpenUp)
			{
				return icons2[5];
			}
			else if (isOpenLeft && isOpenRight)
			{
				return icons2[6];
			}
			else if (isOpenDown && isOpenLeft)
			{
				return icons2[8];
			}
			else if (isOpenDown && isOpenRight)
			{
				return icons2[10];
			}
			else if (isOpenUp && isOpenLeft)
			{
				return icons2[7];
			}
			else if (isOpenUp && isOpenRight)
			{
				return icons2[9];
			}
			else if (isOpenDown)
			{
				return icons2[3];
			}
			else if (isOpenUp)
			{
				return icons2[4];
			}
			else if (isOpenLeft)
			{
				return icons2[2];
			}
			else if (isOpenRight)
			{
				return icons2[1];
			}
			break;
		case 2:
			if (shouldConnectToBlock(block, x, y, z, block.getBlock(x, y - 1, z), block.getBlockMetadata(x, y - 1, z)))
			{
				isOpenDown = true;
			}

			if (shouldConnectToBlock(block, x, y, z, block.getBlock(x, y + 1, z), block.getBlockMetadata(x, y + 1, z)))
			{
				isOpenUp = true;
			}

			if (shouldConnectToBlock(block, x, y, z, block.getBlock(x - 1, y, z), block.getBlockMetadata(x - 1, y, z)))
			{
				isOpenLeft = true;
			}

			if (shouldConnectToBlock(block, x, y, z, block.getBlock(x + 1, y, z), block.getBlockMetadata(x + 1, y, z)))
			{
				isOpenRight = true;
			}

			if (isOpenUp && isOpenDown && isOpenLeft && isOpenRight)
			{
				return icons2[15];
			}
			else if (isOpenUp && isOpenDown && isOpenLeft)
			{
				return icons2[13];
			}
			else if (isOpenUp && isOpenDown && isOpenRight)
			{
				return icons2[14];
			}
			else if (isOpenUp && isOpenLeft && isOpenRight)
			{
				return icons2[11];
			}
			else if (isOpenDown && isOpenLeft && isOpenRight)
			{
				return icons2[12];
			}
			else if (isOpenDown && isOpenUp)
			{
				return icons2[6];
			}
			else if (isOpenLeft && isOpenRight)
			{
				return icons2[5];
			}
			else if (isOpenDown && isOpenLeft)
			{
				return icons2[9];
			}
			else if (isOpenDown && isOpenRight)
			{
				return icons2[10];
			}
			else if (isOpenUp && isOpenLeft)
			{
				return icons2[7];
			}
			else if (isOpenUp && isOpenRight)
			{
				return icons2[8];
			}
			else if (isOpenDown)
			{
				return icons2[1];
			}
			else if (isOpenUp)
			{
				return icons2[2];
			}
			else if (isOpenLeft)
			{
				return icons2[4];
			}
			else if (isOpenRight)
			{
				return icons2[3];
			}
			break;
		case 3:
			if (shouldConnectToBlock(block, x, y, z, block.getBlock(x, y - 1, z), block.getBlockMetadata(x, y - 1, z)))
			{
				isOpenDown = true;
			}

			if (shouldConnectToBlock(block, x, y, z, block.getBlock(x, y + 1, z), block.getBlockMetadata(x, y + 1, z)))
			{
				isOpenUp = true;
			}

			if (shouldConnectToBlock(block, x, y, z, block.getBlock(x - 1, y, z), block.getBlockMetadata(x - 1, y, z)))
			{
				isOpenLeft = true;
			}

			if (shouldConnectToBlock(block, x, y, z, block.getBlock(x + 1, y, z), block.getBlockMetadata(x + 1, y, z)))
			{
				isOpenRight = true;
			}

			if (isOpenUp && isOpenDown && isOpenLeft && isOpenRight)
			{
				return icons2[15];
			}
			else if (isOpenUp && isOpenDown && isOpenLeft)
			{
				return icons2[14];
			}
			else if (isOpenUp && isOpenDown && isOpenRight)
			{
				return icons2[13];
			}
			else if (isOpenUp && isOpenLeft && isOpenRight)
			{
				return icons2[11];
			}
			else if (isOpenDown && isOpenLeft && isOpenRight)
			{
				return icons2[12];
			}
			else if (isOpenDown && isOpenUp)
			{
				return icons2[6];
			}
			else if (isOpenLeft && isOpenRight)
			{
				return icons2[5];
			}
			else if (isOpenDown && isOpenLeft)
			{
				return icons2[10];
			}
			else if (isOpenDown && isOpenRight)
			{
				return icons2[9];
			}
			else if (isOpenUp && isOpenLeft)
			{
				return icons2[8];
			}
			else if (isOpenUp && isOpenRight)
			{
				return icons2[7];
			}
			else if (isOpenDown)
			{
				return icons2[1];
			}
			else if (isOpenUp)
			{
				return icons2[2];
			}
			else if (isOpenLeft)
			{
				return icons2[3];
			}
			else if (isOpenRight)
			{
				return icons2[4];
			}
			break;
		case 4:
			if (shouldConnectToBlock(block, x, y, z, block.getBlock(x, y - 1, z), block.getBlockMetadata(x, y - 1, z)))
			{
				isOpenDown = true;
			}

			if (shouldConnectToBlock(block, x, y, z, block.getBlock(x, y + 1, z), block.getBlockMetadata(x, y + 1, z)))
			{
				isOpenUp = true;
			}

			if (shouldConnectToBlock(block, x, y, z, block.getBlock(x, y, z - 1), block.getBlockMetadata(x, y, z - 1)))
			{
				isOpenLeft = true;
			}

			if (shouldConnectToBlock(block, x, y, z, block.getBlock(x, y, z + 1), block.getBlockMetadata(x, y, z + 1)))
			{
				isOpenRight = true;
			}

			if (isOpenUp && isOpenDown && isOpenLeft && isOpenRight)
			{
				return icons2[15];
			}
			else if (isOpenUp && isOpenDown && isOpenLeft)
			{
				return icons2[14];
			}
			else if (isOpenUp && isOpenDown && isOpenRight)
			{
				return icons2[13];
			}
			else if (isOpenUp && isOpenLeft && isOpenRight)
			{
				return icons2[11];
			}
			else if (isOpenDown && isOpenLeft && isOpenRight)
			{
				return icons2[12];
			}
			else if (isOpenDown && isOpenUp)
			{
				return icons2[6];
			}
			else if (isOpenLeft && isOpenRight)
			{
				return icons2[5];
			}
			else if (isOpenDown && isOpenLeft)
			{
				return icons2[10];
			}
			else if (isOpenDown && isOpenRight)
			{
				return icons2[9];
			}
			else if (isOpenUp && isOpenLeft)
			{
				return icons2[8];
			}
			else if (isOpenUp && isOpenRight)
			{
				return icons2[7];
			}
			else if (isOpenDown)
			{
				return icons2[1];
			}
			else if (isOpenUp)
			{
				return icons2[2];
			}
			else if (isOpenLeft)
			{
				return icons2[3];
			}
			else if (isOpenRight)
			{
				return icons2[4];
			}
			break;
		case 5:
			if (shouldConnectToBlock(block, x, y, z, block.getBlock(x, y - 1, z), block.getBlockMetadata(x, y - 1, z)))
			{
				isOpenDown = true;
			}

			if (shouldConnectToBlock(block, x, y, z, block.getBlock(x, y + 1, z), block.getBlockMetadata(x, y + 1, z)))
			{
				isOpenUp = true;
			}

			if (shouldConnectToBlock(block, x, y, z, block.getBlock(x, y, z - 1), block.getBlockMetadata(x, y, z - 1)))
			{
				isOpenLeft = true;
			}

			if (shouldConnectToBlock(block, x, y, z, block.getBlock(x, y, z + 1), block.getBlockMetadata(x, y, z + 1)))
			{
				isOpenRight = true;
			}

			if (isOpenUp && isOpenDown && isOpenLeft && isOpenRight)
			{
				return icons2[15];
			}
			else if (isOpenUp && isOpenDown && isOpenLeft)
			{
				return icons2[13];
			}
			else if (isOpenUp && isOpenDown && isOpenRight)
			{
				return icons2[14];
			}
			else if (isOpenUp && isOpenLeft && isOpenRight)
			{
				return icons2[11];
			}
			else if (isOpenDown && isOpenLeft && isOpenRight)
			{
				return icons2[12];
			}
			else if (isOpenDown && isOpenUp)
			{
				return icons2[6];
			}
			else if (isOpenLeft && isOpenRight)
			{
				return icons2[5];
			}
			else if (isOpenDown && isOpenLeft)
			{
				return icons2[9];
			}
			else if (isOpenDown && isOpenRight)
			{
				return icons2[10];
			}
			else if (isOpenUp && isOpenLeft)
			{
				return icons2[7];
			}
			else if (isOpenUp && isOpenRight)
			{
				return icons2[8];
			}
			else if (isOpenDown)
			{
				return icons2[1];
			}
			else if (isOpenUp)
			{
				return icons2[2];
			}
			else if (isOpenLeft)
			{
				return icons2[4];
			}
			else if (isOpenRight)
			{
				return icons2[3];
			}
			break;
		}

		return icons2[0];
	}

	/** End fuj1n code **/

	@Override
	public IIcon getIcon(int par1, int par2)
	{
		return icons[ConfigKeys.allowNewRenderer ? 13 : 0];
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List list)
	{
		list.add(new ItemStack(this, 1, 0));
	}

	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
		if (ConfigKeys.allowNewRenderer)
		{
			icons[0] = par1IconRegister.registerIcon("akivarmod:topBorder");
			icons[1] = par1IconRegister.registerIcon("akivarmod:rightBorder");
			icons[2] = par1IconRegister.registerIcon("akivarmod:bottomBorder");
			icons[3] = par1IconRegister.registerIcon("akivarmod:leftBorder");
			icons[4] = par1IconRegister.registerIcon("akivarmod:topLeftCorner");
			icons[5] = par1IconRegister.registerIcon("akivarmod:bottomLeftCorner");
			icons[6] = par1IconRegister.registerIcon("akivarmod:bottomRightCorner");
			icons[7] = par1IconRegister.registerIcon("akivarmod:topRightCorner");
			icons[8] = par1IconRegister.registerIcon("akivarmod:topLeftCornerClosed");
			icons[9] = par1IconRegister.registerIcon("akivarmod:bottomLeftCornerClosed");
			icons[10] = par1IconRegister.registerIcon("akivarmod:bottomRightCornerClosed");
			icons[11] = par1IconRegister.registerIcon("akivarmod:topRightCornerClosed");
			icons[12] = par1IconRegister.registerIcon("akivarmod:lamp_full");
			icons[13] = par1IconRegister.registerIcon("akivarmod:lamp");
			// icons[14] = par1IconRegister.registerIcon("akivarmod:lamp");
			// icons[15] = par1IconRegister.registerIcon("akivarmod:lamp");
		}
		else
		{
			icons[0] = par1IconRegister.registerIcon("akivarmod:lamp");
			icons[1] = par1IconRegister.registerIcon("akivarmod:lamp_d");
			icons[2] = par1IconRegister.registerIcon("akivarmod:lamp_u");
			icons[3] = par1IconRegister.registerIcon("akivarmod:lamp_l");
			icons[4] = par1IconRegister.registerIcon("akivarmod:lamp_r");
			icons[5] = par1IconRegister.registerIcon("akivarmod:lamp_h");
			icons[6] = par1IconRegister.registerIcon("akivarmod:lamp_v");
			icons[7] = par1IconRegister.registerIcon("akivarmod:lamp_ur");
			icons[8] = par1IconRegister.registerIcon("akivarmod:lamp_dr");
			icons[9] = par1IconRegister.registerIcon("akivarmod:lamp_ul");
			icons[10] = par1IconRegister.registerIcon("akivarmod:lamp_dl");
			icons[11] = par1IconRegister.registerIcon("akivarmod:lamp_di");
			icons[12] = par1IconRegister.registerIcon("akivarmod:lamp_ui");
			icons[13] = par1IconRegister.registerIcon("akivarmod:lamp_li");
			icons[14] = par1IconRegister.registerIcon("akivarmod:lamp_ri");
			icons[15] = par1IconRegister.registerIcon("akivarmod:lamp_full");
		}
	}

	@Override
	public boolean canPlaceTorchOnTop(World world, int x, int y, int z)
	{
		return true;
	}

	@Override
	public int getBlockColor()
	{
		if (lightVal == 0.0F)
		{
			return (180 << 16) | (180 << 8) | 180;
		}
		else
		{
			return (255 << 16) | (255 << 8) | 255;
		}
	}

	public int getBlockColor(int metadata)
	{
		if (this == ModBlock.coloredLamp || this == ModBlock.emptyColoredLamp)
		{
			switch (metadata)
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
		return (0xffffff);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getRenderColor(int metadata)
	{
		return getBlockColor(metadata);
	}

	@Override
	public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player)
	{
		if (!world.isRemote && player.inventory.getCurrentItem() != null && player.inventory.getCurrentItem().getItem() == ModItem.textureConnector && (this == ModBlock.coloredLamp || this == ModBlock.lamp) && player.isSneaking())
		{
			Block block = world.getBlock(x, y, z) == ModBlock.coloredLamp ? ModBlock.emptyColoredLamp : ModBlock.emptyLamp;
			int meta = world.getBlockMetadata(x, y, z);
			world.setBlock(x, y, z, block);
			world.setBlockMetadataWithNotify(x, y, z, meta, 3);
			if (!player.inventory.addItemStackToInventory(new ItemStack(Blocks.torch, 1))) player.dropItem(Item.getItemFromBlock(Blocks.torch), 1);
		}
		super.onBlockClicked(world, x, y, z, player);
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
	{
		if (player.inventory.getCurrentItem() == null) return super.onBlockActivated(world, x, y, z, player, par6, par7, par8, par9);
		if (player.inventory.getCurrentItem() != null && player.inventory.getCurrentItem().getItem() == Item.getItemFromBlock(Blocks.torch) && (this == ModBlock.emptyColoredLamp || this == ModBlock.emptyLamp) && !player.isSneaking())
		{
			Block block = world.getBlock(x, y, z) == ModBlock.emptyColoredLamp ? ModBlock.coloredLamp : ModBlock.lamp;
			int meta = world.getBlockMetadata(x, y, z);
			world.setBlock(x, y, z, block);
			world.setBlockMetadataWithNotify(x, y, z, meta, 3);
			player.inventory.getCurrentItem().stackSize--;
			return true;
		}/*
		 * // TODO Tcon compat else if (Loader.isModLoaded("TConstruct") &&
		 * player.inventory.getCurrentItem() != null &&
		 * player.inventory.getCurrentItem().itemID ==
		 * TContent.stoneTorch.blockID && (this.blockID ==
		 * BlockInfo.EMPTYCOLOREDLAMP_ID || this.blockID ==
		 * BlockInfo.EMPTYLAMP_ID) && !player.isSneaking()) { Block block=
		 * world.getBlock(x, y, z) == ModBlock.emptyColoredLamp ?
		 * ModBlock.coloredLamp : ModBlock.lamp; int meta =
		 * world.getBlockMetadata(x, y, z); world.setBlock(x, y, z, block);
		 * world.setBlockMetadataWithNotify(x, y, z, meta, 3);
		 * player.inventory.getCurrentItem().stackSize--; return true; }
		 */
		else if (player.inventory.getCurrentItem().getItem() == Items.water_bucket || player.inventory.getCurrentItem().getItem() == Items.bucket)
			return true;
		else return super.onBlockActivated(world, x, y, z, player, par6, par7, par8, par9);
	}

	@Override
	public boolean isSideSolid(IBlockAccess world, int x, int y, int z, ForgeDirection side)
	{
		return true;
	}

	@Override
	public int getRenderType()
	{
		return ConfigKeys.allowNewRenderer ? LampRenderer.instance().getRenderId() : super.getRenderType();
	}

	public int getBlockColorWithDarkness(int metadata)
	{
		if (this != ModBlock.emptyColoredLamp && this != ModBlock.emptyLamp)
			return getBlockColor(metadata);
		else if (this == ModBlock.emptyLamp)
			return (180 << 16) | (180 << 8) | 180;
		else switch (metadata)
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
}
