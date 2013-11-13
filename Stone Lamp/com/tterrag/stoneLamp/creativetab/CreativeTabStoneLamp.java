package tterrag.stoneLamp.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import tterrag.stoneLamp.block.ModBlock;
import tterrag.stoneLamp.lib.Reference;

public class CreativeTabStoneLamp extends CreativeTabs {
	
	public CreativeTabStoneLamp(int id)
	{
		super(id, Reference.TAB_NAME);
	}
	
	@Override
	public int getTabIconItemIndex() {
		return ModBlock.LAMP_ID;
	}
	
	@Override
	public String getTabLabel() {
		return Reference.TAB_NAME;
	}
}
