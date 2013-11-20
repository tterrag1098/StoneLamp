package tterrag.stoneLamp.common.item;

import java.util.List;

import tterrag.stoneLamp.common.api.ItemBlockSL;
import tterrag.stoneLamp.common.block.BlockLamp;
import tterrag.stoneLamp.common.block.ModBlock;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class ItemBlockColoredLamp extends ItemBlockSL {

	public ItemBlockColoredLamp(int par1) {
		super(par1);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void addInformation(ItemStack par1ItemStack,
			EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		if (par1ItemStack != null)
			par3List.add("\u00A7o"
					+ ItemConnector.colors[par1ItemStack.getItemDamage()]);
	}

}
