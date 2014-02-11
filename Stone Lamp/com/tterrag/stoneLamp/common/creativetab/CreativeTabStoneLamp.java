package tterrag.stoneLamp.common.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import tterrag.stoneLamp.common.block.BlockInfo;
import tterrag.stoneLamp.common.block.ModBlock;
import tterrag.stoneLamp.common.lib.Reference;

public class CreativeTabStoneLamp extends CreativeTabs {
	
	public CreativeTabStoneLamp(int id)
	{
		super(id, Reference.TAB_NAME);
	}
	
	@Override
	public String getTabLabel() {
		return Reference.TAB_NAME;
	}

	@Override
	public Item getTabIconItem()
	{
		return ModBlock.lamp.getItem(null, 0, 0, 0);
	}
}
