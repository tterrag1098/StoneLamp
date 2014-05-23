package tterrag.stoneLamp.common.block;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import tterrag.stoneLamp.common.item.ItemBlockColoredLamp;
import tterrag.stoneLamp.common.item.ModItem;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlock
{
	public static Block lamp;
	public static Block emptyLamp;
	public static Block coloredLamp;
	public static Block emptyColoredLamp;

	public static void init()
	{
		lamp = new BlockLamp(0.9F, "blockLamp");
		GameRegistry.registerBlock(lamp, "blockLamp");

		emptyLamp = new BlockLamp(0.0F, "blockEmptyLamp");
		GameRegistry.registerBlock(emptyLamp, "blockEmptyLamp");

		coloredLamp = new BlockColoredLamp(0.9F, BlockInfo.COLOREDLAMP_UNLOC_NAME);
		GameRegistry.registerBlock(coloredLamp, ItemBlockColoredLamp.class, BlockInfo.COLOREDLAMP_UNLOC_NAME);

		emptyColoredLamp = new BlockColoredLamp(0.0F, BlockInfo.EMPTYCOLOREDLAMP_UNLOC_NAME);
		GameRegistry.registerBlock(emptyColoredLamp, ItemBlockColoredLamp.class, BlockInfo.EMPTYCOLOREDLAMP_UNLOC_NAME);
	}

	public static void addRecipes()
	{
		GameRegistry.addRecipe(new ItemStack(ModBlock.emptyLamp), new Object[] { "CPC", "P P", "CPC",

		'C', Blocks.cobblestone, 'P', Blocks.glass_pane, });

		GameRegistry.addRecipe(new ItemStack(ModBlock.lamp), new Object[] { "CPC", "PTP", "CPC",

		'C', Blocks.cobblestone, 'P', Blocks.glass_pane, 'T', Blocks.torch });

		GameRegistry.addShapelessRecipe(new ItemStack(ModBlock.lamp), new Object[] { ModBlock.emptyLamp, Blocks.torch });

		/*
		 * //TODO Tcon compat if (Loader.isModLoaded("TConstruct")) { try {
		 * GameRegistry.addRecipe(new ItemStack(ModBlock.lamp), new Object[]{
		 * "CPC", "PTP", "CPC",
		 * 
		 * 'C', Block.cobblestone, 'P', Block.thinGlass, 'T',
		 * TContent.stoneTorch });
		 * 
		 * GameRegistry.addShapelessRecipe(new ItemStack(ModBlock.lamp), new
		 * Object[] {ModBlock.emptyLamp, TContent.stoneTorch}); }
		 * catch(NoClassDefFoundError e) {
		 * System.out.println("DANGIT TCON STOP CHANGING PACKAGES"); }
		 * 
		 * }
		 */

		for (int i = 0; i < 16; i++)
		{
			GameRegistry.addShapelessRecipe(new ItemStack(coloredLamp, 1, i), new Object[] { new ItemStack(emptyColoredLamp, 1, i), Blocks.torch });
			GameRegistry.addShapelessRecipe(new ItemStack(lamp), new Object[] { new ItemStack(coloredLamp, 1, i), Items.water_bucket });
			GameRegistry.addShapelessRecipe(new ItemStack(emptyLamp), new Object[] { new ItemStack(emptyColoredLamp, 1, i), Items.water_bucket });
			GameRegistry.addShapelessRecipe(new ItemStack(coloredLamp, 1, i), new Object[] { lamp, new ItemStack(Items.dye, 1, i) });
			GameRegistry.addShapelessRecipe(new ItemStack(emptyColoredLamp, 1, i), new Object[] { emptyLamp, new ItemStack(Items.dye, 1, i) });
			for (int j = 0; j < 16; j++)
			{
				GameRegistry.addShapelessRecipe(new ItemStack(coloredLamp, 1, i), new Object[] { new ItemStack(coloredLamp, 1, j), new ItemStack(Items.dye, 1, i) });
				GameRegistry.addShapelessRecipe(new ItemStack(emptyColoredLamp, 1, i), new Object[] { new ItemStack(emptyColoredLamp, 1, j), new ItemStack(Items.dye, 1, i) });
			}
			GameRegistry.addRecipe(new ItemStack(ModItem.textureConnector), new Object[] { "  L", " S ", "S  ",

			'L', new ItemStack(emptyColoredLamp, 1, i), 'S', Items.stick });
		}
		GameRegistry.addRecipe(new ItemStack(ModItem.textureConnector), new Object[] { "  L", " S ", "S  ",

		'L', emptyLamp, 'S', Items.stick });
	}
}
