package tterrag.stoneLamp.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import tterrag.stoneLamp.block.ModBlock;

public class ItemConnector extends Item{
	
	public ItemConnector(int id)
	{
		super(id);
		setUnlocalizedName(ModItem.CONNECTOR_UNLOC_NAME);
		setCreativeTab(CreativeTabs.tabTools);
	}
	
	@Override
	public boolean onItemUseFirst(ItemStack stack, EntityPlayer player,
			World world, int x, int y, int z, int side, float hitX, float hitY,
			float hitZ) {
		int id = world.getBlockId(x, y, z);
		if (id == ModBlock.LAMP_ID || id == ModBlock.EMPTYLAMP_ID)
		{
			switch (side)
			{
			case 0:
			case 1:
				for (int i = -1; i <= 1; i++)
					for (int j = -1; j <=1; j++)
					{
						world.markBlockForRenderUpdate(x + i, y, z + i);
					}
				break;
			case 2:
			case 3:
				for (int i = -1; i <= 1; i++)
					for (int j = -1; j <=1; j++)
					{
						world.markBlockForRenderUpdate(x + i, y + i, z);
					}
				break;
			case 4:
			case 5:
				for (int i = -1; i <= 1; i++)
					for (int j = -1; j <=1; j++)
					{
						world.markBlockForRenderUpdate(x, y + i, z + i);
					}
				break;
			}
		}
		return super.onItemUseFirst(stack, player, world, x, y, z, side, hitX, hitY, hitZ);
	}
}
