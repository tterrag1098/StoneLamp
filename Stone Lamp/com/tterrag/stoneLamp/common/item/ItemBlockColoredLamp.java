package tterrag.stoneLamp.common.item;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import tterrag.stoneLamp.common.api.ItemBlockSL;

public class ItemBlockColoredLamp extends ItemBlockSL
{

	public ItemBlockColoredLamp(Block block)
	{
		super(block);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		if (par1ItemStack != null) par3List.add("\u00A7o" + ItemConnector.colors[par1ItemStack.getItemDamage()]);
	}
}
