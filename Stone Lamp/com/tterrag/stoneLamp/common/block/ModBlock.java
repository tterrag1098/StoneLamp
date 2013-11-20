package tterrag.stoneLamp.common.block;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import tconstruct.common.TContent;
import tterrag.stoneLamp.common.item.ItemBlockColoredLamp;
import tterrag.stoneLamp.common.item.ModItem;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModBlock {
	
	public static Block lamp;
	public static Block emptyLamp;
	public static Block coloredLamp;
	public static Block emptyColoredLamp;
	
	public static void init()
	{
		lamp = new BlockLamp(BlockInfo.LAMP_ID, 0.9F, "blockLamp");
		GameRegistry.registerBlock(lamp, "blockLamp");

		emptyLamp = new BlockLamp(BlockInfo.EMPTYLAMP_ID, 0.0F, "blockEmptyLamp");
		GameRegistry.registerBlock(emptyLamp, "blockEmptyLamp");
		
		coloredLamp = new BlockColoredLamp(BlockInfo.COLOREDLAMP_ID, 0.9F, BlockInfo.COLOREDLAMP_UNLOC_NAME);
		GameRegistry.registerBlock(coloredLamp, ItemBlockColoredLamp.class, BlockInfo.COLOREDLAMP_UNLOC_NAME);
		
		emptyColoredLamp = new BlockColoredLamp(BlockInfo.EMPTYCOLOREDLAMP_ID, 0.0F, BlockInfo.EMPTYCOLOREDLAMP_UNLOC_NAME);
		GameRegistry.registerBlock(emptyColoredLamp, ItemBlockColoredLamp.class, BlockInfo.EMPTYCOLOREDLAMP_UNLOC_NAME);
	}
	
	public static void addRecipes()
	{		 
		GameRegistry.addRecipe(new ItemStack(ModBlock.emptyLamp), new Object[] {
				"CPC",
				"P P",
				"CPC",
			
				'C', Block.cobblestone,
				'P', Block.thinGlass,
		});
		
		GameRegistry.addRecipe(new ItemStack(ModBlock.lamp), new Object[]{
				"CPC",
				"PTP",
				"CPC",
				
				'C', Block.cobblestone,
				'P', Block.thinGlass,
				'T', Block.torchWood
		});
		
		GameRegistry.addShapelessRecipe(new ItemStack(ModBlock.lamp), new Object[]
				{ModBlock.emptyLamp, Block.torchWood});
		
		if (Loader.isModLoaded("TConstruct"))
		{
			GameRegistry.addRecipe(new ItemStack(ModBlock.lamp), new Object[]{
					"CPC",
					"PTP",
					"CPC",
					
					'C', Block.cobblestone,
					'P', Block.thinGlass,
					'T', TContent.stoneTorch			
			});
			
			GameRegistry.addShapelessRecipe(new ItemStack(ModBlock.lamp), new Object[]
					{ModBlock.emptyLamp, TContent.stoneTorch});
					
		}
		
		
		
		for (int i = 0; i < 16; i++)
		{
			GameRegistry.addShapelessRecipe(new ItemStack(coloredLamp, 1, i), new Object[]
					{new ItemStack(emptyColoredLamp, 1, i), Block.torchWood}
			);
			GameRegistry.addShapelessRecipe(new ItemStack(lamp), new Object[]
					{new ItemStack(coloredLamp, 1, i), Item.bucketWater}
			);
			GameRegistry.addShapelessRecipe(new ItemStack(emptyLamp), new Object[]
					{new ItemStack(emptyColoredLamp, 1, i), Item.bucketWater}
			);
			GameRegistry.addShapelessRecipe(new ItemStack(coloredLamp, 1, i), new Object[]
					{lamp, new ItemStack(Item.dyePowder, 1, i)}
			);
			GameRegistry.addShapelessRecipe(new ItemStack(emptyColoredLamp, 1, i), new Object[]
					{emptyLamp, new ItemStack(Item.dyePowder, 1, i)}
			);
			for (int j = 0; j < 16; j++)
			{
				GameRegistry.addShapelessRecipe(new ItemStack(coloredLamp, 1, i), new Object[]
						{new ItemStack(coloredLamp, 1, j), new ItemStack(Item.dyePowder, 1, i)}
				);
				GameRegistry.addShapelessRecipe(new ItemStack(emptyColoredLamp, 1, i), new Object[]
						{new ItemStack(emptyColoredLamp, 1, j), new ItemStack(Item.dyePowder, 1, i)}
				);
			}
			GameRegistry.addRecipe(new ItemStack(ModItem.textureConnector), new Object[]{
				"  L",
				" S ",
				"S  ",
				
				'L', new ItemStack(emptyColoredLamp, 1, i),
				'S', Item.stick
			});
		}
		GameRegistry.addRecipe(new ItemStack(ModItem.textureConnector), new Object[]{
			"  L",
			" S ",
			"S  ",
			
			'L', emptyLamp,
			'S', Item.stick
		});
	}
	
	public static void addNames()
	{
		LanguageRegistry.addName(lamp, "Stone Lamp");
		LanguageRegistry.addName(emptyLamp, "Empty Stone Lamp");
		LanguageRegistry.addName(coloredLamp, BlockInfo.COLOREDLAMP_LOC_NAME);
		LanguageRegistry.addName(emptyColoredLamp, BlockInfo.EMPTYCOLOREDLAMP_LOC_NAME);
	}

}
