package tterrag.stoneLamp.common.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import tterrag.stoneLamp.common.block.BlockInfo;
import tterrag.stoneLamp.common.lib.Reference;

public class CreativeTabStoneLamp extends CreativeTabs {
	
	public CreativeTabStoneLamp(int id)
	{
		super(id, Reference.TAB_NAME);
	}
	
	@Override
	public int getTabIconItemIndex() {
		return BlockInfo.LAMP_ID;
	}
	
	@Override
	public String getTabLabel() {
		return Reference.TAB_NAME;
	}
}
