package tterrag.stoneLamp.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import tterrag.stoneLamp.AkivarMod;
import tterrag.stoneLamp.config.ConfigKeys;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockLamp extends Block {
	
	public BlockLamp(int id, float lightValue, String unlocName) {
		super(id, Material.glass);
		setLightValue(lightValue);
		setUnlocalizedName(unlocName);
		setCreativeTab(AkivarMod.tabStoneLamp);
		setHardness(0.6F);
	}

	@SideOnly(Side.CLIENT)
	private Icon icon;
	
	@Override
	public int onBlockPlaced(World world, int x, int y, int z,
			int par5, float par6, float par7, float par8, int par9) {
		
		for (int i = -1; i <= 1; i++)
			for (int j = -1; j <=1; j++)
				world.markBlockForRenderUpdate(x + i, y, z + i);
		
		return super.onBlockPlaced(world, x, y, z, par5, par6, par7, par8,
				par9);
	}
	
	/** 
	 * @author fuj1n (from here down)
	 */
	public static Icon[] icons = new Icon[16];
	protected String folder;

	/**
	 * This is checked to see if the texture should connect to this block
	 * @param par2 x
	 * @param par3 y
	 * @param par4 z
	 * @param par5 ID this block is asking to connect to (may be 0 if there is no block)
	 * @param par6 Metadata of the block this block is trying to connect to
	 * @return true if should connect
	 */
	public boolean shouldConnectToBlock (IBlockAccess par1IBlockAccess, int x, int y, int z, int par5, int par6)
	{
		return par5 == this.blockID && par1IBlockAccess.getBlockMetadata(x, y, z) == par6;
	}

	@Override
	public Icon getBlockTexture (IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
	{
		return getConnectedBlockTexture(par1IBlockAccess, par2, par3, par4, par5, icons);
	}

	public Icon getConnectedBlockTexture (IBlockAccess block, int x, int y, int z, int side, Icon[] icons)
	{
		boolean isOpenUp = false, isOpenDown = false, isOpenLeft = false, isOpenRight = false;

		if (!ConfigKeys.allowConnectedTextures)
			return icons[0];
		
		switch (side)
		{
		case 0:
			if (shouldConnectToBlock(block, x, y, z, block.getBlockId(x - 1, y, z), block.getBlockMetadata(x - 1, y, z)))
			{
				isOpenDown = true;
			}

			if (shouldConnectToBlock(block, x, y, z, block.getBlockId(x + 1, y, z), block.getBlockMetadata(x + 1, y, z)))
			{
				isOpenUp = true;
			}

			if (shouldConnectToBlock(block, x, y, z, block.getBlockId(x, y, z - 1), block.getBlockMetadata(x, y, z - 1)))
			{
				isOpenLeft = true;
			}

			if (shouldConnectToBlock(block, x, y, z, block.getBlockId(x, y, z + 1), block.getBlockMetadata(x, y, z + 1)))
			{
				isOpenRight = true;
			}
			
			if (isOpenUp && isOpenDown && isOpenLeft && isOpenRight)
			{
				return icons[15];
			}
			else if (isOpenUp && isOpenDown && isOpenLeft)
			{
				return icons[11];
			}
			else if (isOpenUp && isOpenDown && isOpenRight)
			{
				return icons[12];
			}
			else if (isOpenUp && isOpenLeft && isOpenRight)
			{
				return icons[13];
			}
			else if (isOpenDown && isOpenLeft && isOpenRight)
			{
				return icons[14];
			}
			else if (isOpenDown && isOpenUp)
			{
				return icons[5];
			}
			else if (isOpenLeft && isOpenRight)
			{
				return icons[6];
			}
			else if (isOpenDown && isOpenLeft)
			{
				return icons[8];
			}
			else if (isOpenDown && isOpenRight)
			{
				return icons[10];
			}
			else if (isOpenUp && isOpenLeft)
			{
				return icons[7];
			}
			else if (isOpenUp && isOpenRight)
			{
				return icons[9];
			}
			else if (isOpenDown)
			{
				return icons[3];
			}
			else if (isOpenUp)
			{
				return icons[4];
			}
			else if (isOpenLeft)
			{
				return icons[2];
			}
			else if (isOpenRight)
			{
				return icons[1];
			}
			break;
		case 1:
			if (shouldConnectToBlock(block, x, y, z, block.getBlockId(x - 1, y, z), block.getBlockMetadata(x - 1, y, z)))
			{
				isOpenDown = true;
			}

			if (shouldConnectToBlock(block, x, y, z, block.getBlockId(x + 1, y, z), block.getBlockMetadata(x + 1, y, z)))
			{
				isOpenUp = true;
			}

			if (shouldConnectToBlock(block, x, y, z, block.getBlockId(x, y, z - 1), block.getBlockMetadata(x, y, z - 1)))
			{
				isOpenLeft = true;
			}

			if (shouldConnectToBlock(block, x, y, z, block.getBlockId(x, y, z + 1), block.getBlockMetadata(x, y, z + 1)))
			{
				isOpenRight = true;
			}

			if (isOpenUp && isOpenDown && isOpenLeft && isOpenRight)
			{
				return icons[15];
			}
			else if (isOpenUp && isOpenDown && isOpenLeft)
			{
				return icons[11];
			}
			else if (isOpenUp && isOpenDown && isOpenRight)
			{
				return icons[12];
			}
			else if (isOpenUp && isOpenLeft && isOpenRight)
			{
				return icons[13];
			}
			else if (isOpenDown && isOpenLeft && isOpenRight)
			{
				return icons[14];
			}
			else if (isOpenDown && isOpenUp)
			{
				return icons[5];
			}
			else if (isOpenLeft && isOpenRight)
			{
				return icons[6];
			}
			else if (isOpenDown && isOpenLeft)
			{
				return icons[8];
			}
			else if (isOpenDown && isOpenRight)
			{
				return icons[10];
			}
			else if (isOpenUp && isOpenLeft)
			{
				return icons[7];
			}
			else if (isOpenUp && isOpenRight)
			{
				return icons[9];
			}
			else if (isOpenDown)
			{
				return icons[3];
			}
			else if (isOpenUp)
			{
				return icons[4];
			}
			else if (isOpenLeft)
			{
				return icons[2];
			}
			else if (isOpenRight)
			{
				return icons[1];
			}
			break;
		case 2:
			if (shouldConnectToBlock(block, x, y, z, block.getBlockId(x, y - 1, z), block.getBlockMetadata(x, y - 1, z)))
			{
				isOpenDown = true;
			}

			if (shouldConnectToBlock(block, x, y, z, block.getBlockId(x, y + 1, z), block.getBlockMetadata(x, y + 1, z)))
			{
				isOpenUp = true;
			}

			if (shouldConnectToBlock(block, x, y, z, block.getBlockId(x - 1, y, z), block.getBlockMetadata(x - 1, y, z)))
			{
				isOpenLeft = true;
			}

			if (shouldConnectToBlock(block, x, y, z, block.getBlockId(x + 1, y, z), block.getBlockMetadata(x + 1, y, z)))
			{
				isOpenRight = true;
			}

			if (isOpenUp && isOpenDown && isOpenLeft && isOpenRight)
			{
				return icons[15];
			}
			else if (isOpenUp && isOpenDown && isOpenLeft)
			{
				return icons[13];
			}
			else if (isOpenUp && isOpenDown && isOpenRight)
			{
				return icons[14];
			}
			else if (isOpenUp && isOpenLeft && isOpenRight)
			{
				return icons[11];
			}
			else if (isOpenDown && isOpenLeft && isOpenRight)
			{
				return icons[12];
			}
			else if (isOpenDown && isOpenUp)
			{
				return icons[6];
			}
			else if (isOpenLeft && isOpenRight)
			{
				return icons[5];
			}
			else if (isOpenDown && isOpenLeft)
			{
				return icons[9];
			}
			else if (isOpenDown && isOpenRight)
			{
				return icons[10];
			}
			else if (isOpenUp && isOpenLeft)
			{
				return icons[7];
			}
			else if (isOpenUp && isOpenRight)
			{
				return icons[8];
			}
			else if (isOpenDown)
			{
				return icons[1];
			}
			else if (isOpenUp)
			{
				return icons[2];
			}
			else if (isOpenLeft)
			{
				return icons[4];
			}
			else if (isOpenRight)
			{
				return icons[3];
			}
			break;
		case 3:
			if (shouldConnectToBlock(block, x, y, z, block.getBlockId(x, y - 1, z), block.getBlockMetadata(x, y - 1, z)))
			{
				isOpenDown = true;
			}

			if (shouldConnectToBlock(block, x, y, z, block.getBlockId(x, y + 1, z), block.getBlockMetadata(x, y + 1, z)))
			{
				isOpenUp = true;
			}

			if (shouldConnectToBlock(block, x, y, z, block.getBlockId(x - 1, y, z), block.getBlockMetadata(x - 1, y, z)))
			{
				isOpenLeft = true;
			}

			if (shouldConnectToBlock(block, x, y, z, block.getBlockId(x + 1, y, z), block.getBlockMetadata(x + 1, y, z)))
			{
				isOpenRight = true;
			}

			if (isOpenUp && isOpenDown && isOpenLeft && isOpenRight)
			{
				return icons[15];
			}
			else if (isOpenUp && isOpenDown && isOpenLeft)
			{
				return icons[14];
			}
			else if (isOpenUp && isOpenDown && isOpenRight)
			{
				return icons[13];
			}
			else if (isOpenUp && isOpenLeft && isOpenRight)
			{
				return icons[11];
			}
			else if (isOpenDown && isOpenLeft && isOpenRight)
			{
				return icons[12];
			}
			else if (isOpenDown && isOpenUp)
			{
				return icons[6];
			}
			else if (isOpenLeft && isOpenRight)
			{
				return icons[5];
			}
			else if (isOpenDown && isOpenLeft)
			{
				return icons[10];
			}
			else if (isOpenDown && isOpenRight)
			{
				return icons[9];
			}
			else if (isOpenUp && isOpenLeft)
			{
				return icons[8];
			}
			else if (isOpenUp && isOpenRight)
			{
				return icons[7];
			}
			else if (isOpenDown)
			{
				return icons[1];
			}
			else if (isOpenUp)
			{
				return icons[2];
			}
			else if (isOpenLeft)
			{
				return icons[3];
			}
			else if (isOpenRight)
			{
				return icons[4];
			}
			break;
		case 4:
			if (shouldConnectToBlock(block, x, y, z, block.getBlockId(x, y - 1, z), block.getBlockMetadata(x, y - 1, z)))
			{
				isOpenDown = true;
			}

			if (shouldConnectToBlock(block, x, y, z, block.getBlockId(x, y + 1, z), block.getBlockMetadata(x, y + 1, z)))
			{
				isOpenUp = true;
			}

			if (shouldConnectToBlock(block, x, y, z, block.getBlockId(x, y, z - 1), block.getBlockMetadata(x, y, z - 1)))
			{
				isOpenLeft = true;
			}

			if (shouldConnectToBlock(block, x, y, z, block.getBlockId(x, y, z + 1), block.getBlockMetadata(x, y, z + 1)))
			{
				isOpenRight = true;
			}

			if (isOpenUp && isOpenDown && isOpenLeft && isOpenRight)
			{
				return icons[15];
			}
			else if (isOpenUp && isOpenDown && isOpenLeft)
			{
				return icons[14];
			}
			else if (isOpenUp && isOpenDown && isOpenRight)
			{
				return icons[13];
			}
			else if (isOpenUp && isOpenLeft && isOpenRight)
			{
				return icons[11];
			}
			else if (isOpenDown && isOpenLeft && isOpenRight)
			{
				return icons[12];
			}
			else if (isOpenDown && isOpenUp)
			{
				return icons[6];
			}
			else if (isOpenLeft && isOpenRight)
			{
				return icons[5];
			}
			else if (isOpenDown && isOpenLeft)
			{
				return icons[10];
			}
			else if (isOpenDown && isOpenRight)
			{
				return icons[9];
			}
			else if (isOpenUp && isOpenLeft)
			{
				return icons[8];
			}
			else if (isOpenUp && isOpenRight)
			{
				return icons[7];
			}
			else if (isOpenDown)
			{
				return icons[1];
			}
			else if (isOpenUp)
			{
				return icons[2];
			}
			else if (isOpenLeft)
			{
				return icons[3];
			}
			else if (isOpenRight)
			{
				return icons[4];
			}
			break;
		case 5:
			if (shouldConnectToBlock(block, x, y, z, block.getBlockId(x, y - 1, z), block.getBlockMetadata(x, y - 1, z)))
			{
				isOpenDown = true;
			}

			if (shouldConnectToBlock(block, x, y, z, block.getBlockId(x, y + 1, z), block.getBlockMetadata(x, y + 1, z)))
			{
				isOpenUp = true;
			}

			if (shouldConnectToBlock(block, x, y, z, block.getBlockId(x, y, z - 1), block.getBlockMetadata(x, y, z - 1)))
			{
				isOpenLeft = true;
			}

			if (shouldConnectToBlock(block, x, y, z, block.getBlockId(x, y, z + 1), block.getBlockMetadata(x, y, z + 1)))
			{
				isOpenRight = true;
			}

			if (isOpenUp && isOpenDown && isOpenLeft && isOpenRight)
			{
				return icons[15];
			}
			else if (isOpenUp && isOpenDown && isOpenLeft)
			{
				return icons[13];
			}
			else if (isOpenUp && isOpenDown && isOpenRight)
			{
				return icons[14];
			}
			else if (isOpenUp && isOpenLeft && isOpenRight)
			{
				return icons[11];
			}
			else if (isOpenDown && isOpenLeft && isOpenRight)
			{
				return icons[12];
			}
			else if (isOpenDown && isOpenUp)
			{
				return icons[6];
			}
			else if (isOpenLeft && isOpenRight)
			{
				return icons[5];
			}
			else if (isOpenDown && isOpenLeft)
			{
				return icons[9];
			}
			else if (isOpenDown && isOpenRight)
			{
				return icons[10];
			}
			else if (isOpenUp && isOpenLeft)
			{
				return icons[7];
			}
			else if (isOpenUp && isOpenRight)
			{
				return icons[8];
			}
			else if (isOpenDown)
			{
				return icons[1];
			}
			else if (isOpenUp)
			{
				return icons[2];
			}
			else if (isOpenLeft)
			{
				return icons[4];
			}
			else if (isOpenRight)
			{
				return icons[3];
			}
			break;
		}

		return icons[0];
	}

	@Override
	public Icon getIcon (int par1, int par2)
	{
		return icons[0];
	}

	@Override
	public void registerIcons (IconRegister par1IconRegister)
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

	@Override
	public boolean canPlaceTorchOnTop (World world, int x, int y, int z)
	{
		return true;
	}
}
