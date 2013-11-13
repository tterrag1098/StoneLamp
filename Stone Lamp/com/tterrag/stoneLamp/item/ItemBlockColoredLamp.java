package tterrag.stoneLamp.item;

import net.minecraft.item.ItemBlock;

public class ItemBlockColoredLamp extends ItemBlock {

	public ItemBlockColoredLamp(int par1) {
		super(par1);
		this.setHasSubtypes(true);
	}

	@Override
	public int getMetadata(int damageValue) {
		return damageValue;
	}
}
