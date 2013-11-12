package tterrag.stoneLamp.block;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;


public class BlockColoredLamp extends BlockLamp{
	
	private int meta;
	private int color;
	
	public BlockColoredLamp(int id, float lightValue, String unlocName)
	{
		super(id, lightValue, unlocName);
		this.meta = 0;
		this.color = 0;
	}
	
	@Override
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs,
			List par3List) {
		for (int i = 0; i <= 15; i++)
		{
			par3List.add(new ItemStack(this.blockID, 0, i));
		}
	}
	
	@Override
	public Icon getIcon(int par1, int par2) {
		return icons[0];
	}

	@Override
	public void onBlockAdded(World par1World, int par2, int par3, int par4) {
		par1World.setBlockMetadataWithNotify(par2, par3, par4, color, 3);
		super.onBlockAdded(par1World, par2, par3, par4);
	}
	
	@Override
	public int getBlockColor() {
		switch(color)
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
			return (180 << 16) | (180 << 8) | 180;
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
			return (255 << 16) | (255 << 8) | 255;
		default:
			return (24 << 16) | (24 << 8) | 24;
		}
	}
	
	@Override
	public int colorMultiplier(IBlockAccess par1iBlockAccess, int par2,
		int par3, int par4) {
		meta = par1iBlockAccess.getBlockMetadata(par2, par3, par4);
		color = meta;
		switch(meta)
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
			return (180 << 16) | (180 << 8) | 180;
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
			return (255 << 16) | (255 << 8) | 255;
		default:
			return (24 << 16) | (24 << 8) | 24;
		}
	}
	
	@Override
	public int damageDropped(int par1) {
		return par1;
	}
	
	@Override
	public int getRenderColor(int par1) {
		color = par1;
		return getBlockColor();	
	}
}
