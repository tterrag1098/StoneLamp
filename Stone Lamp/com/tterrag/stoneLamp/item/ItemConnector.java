package tterrag.stoneLamp.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import tterrag.stoneLamp.block.ModBlock;
import tterrag.stoneLamp.config.ConfigKeys;

public class ItemConnector extends Item {

	private boolean wasUsedOnBlock = false;

	public ItemConnector(int id) {
		super(id);
		setUnlocalizedName(ModItem.CONNECTOR_UNLOC_NAME);
		setCreativeTab(CreativeTabs.tabTools);
		setHasSubtypes(true);
	}

	@Override
	public boolean onItemUseFirst(ItemStack stack, EntityPlayer player,
			World world, int x, int y, int z, int side, float hitX, float hitY,
			float hitZ) {
		if (!world.isRemote && !player.isSneaking()) {
			int id = world.getBlockId(x, y, z);
			if (id == ModBlock.LAMP_ID || id == ModBlock.EMPTYLAMP_ID || id == ModBlock.COLOREDLAMP_ID) {
				world.setBlockMetadataWithNotify(x, y, z,
						stack.getItemDamage(), 3);
			}
		}
		return super.onItemUseFirst(stack, player, world, x, y, z, side, hitX,
				hitY, hitZ);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world,
			EntityPlayer player) {
		if (player.isSneaking()) {
			if (ConfigKeys.maxChannel > 15)
				ConfigKeys.maxChannel = 15;
			if (stack.getItemDamage() < ConfigKeys.maxChannel)
				stack.setItemDamage(stack.getItemDamage() + 1);
			else
				stack.setItemDamage(0);

			if (world.isRemote)
				player.addChatMessage("Channel: " + stack.getItemDamage());
		}
		return stack;
	}
}
