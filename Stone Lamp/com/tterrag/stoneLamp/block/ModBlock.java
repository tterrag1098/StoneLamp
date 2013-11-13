package tterrag.stoneLamp.block;

import mods.tinker.tconstruct.common.TContent;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import tterrag.stoneLamp.item.ItemBlockColoredLamp;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModBlock {
	
	public static final String LAMP_UNLOC_NAME = "stoneLamp";
	public static final String EMPTYLAMP_UNLOC_NAME = "emptyLamp";
	public static final String COLOREDLAMP_UNLOC_NAME = "coloredLamp";
	public static final String EMPTYCOLOREDLAMP_UNLOC_NAME = "emptyColoredLamp";
	public static final String LAMP_LOC_NAME = "Stone Lamp";
	public static final String EMPTYLAMP_LOC_NAME = "Empty Stone Lamp";
	public static final String COLOREDLAMP_LOC_NAME = "Colored Stone Lamp";
	public static final String EMPTYCOLOREDLAMP_LOC_NAME = "Empty Colored Stone Lamp";
	
	public static final int LAMP_DEFAULT = 2999;
	public static final int EMPTYLAMP_DEFAULT = 2998;
	public static final int COLOREDLAMP_DEFAULT = 2997;
	public static final int EMPTYCOLOREDLAMP_DEFAULT = 2996;
	
	public static int LAMP_ID;
	public static int EMPTYLAMP_ID;
	public static int COLOREDLAMP_ID = 2997;
	public static int EMPTYCOLOREDLAMP_ID = 2996;
	
	public static Block lamp;
	public static Block emptyLamp;
	public static Block coloredLamp;
	public static Block emptyColoredLamp;
	
	public static void init()
	{
		lamp = new BlockLamp(LAMP_ID, 0.9F, "blockLamp");
		GameRegistry.registerBlock(lamp, "blockLamp");

		emptyLamp = new BlockLamp(EMPTYLAMP_ID, 0.0F, "blockEmptyLamp");
		GameRegistry.registerBlock(emptyLamp, "blockEmptyLamp");
		
		coloredLamp = new BlockColoredLamp(COLOREDLAMP_ID, 0.9F, COLOREDLAMP_UNLOC_NAME);
		GameRegistry.registerBlock(coloredLamp, ItemBlockColoredLamp.class, COLOREDLAMP_UNLOC_NAME);
		
		emptyColoredLamp = new BlockColoredLamp(EMPTYCOLOREDLAMP_ID, 0.0F, EMPTYCOLOREDLAMP_UNLOC_NAME);
		GameRegistry.registerBlock(emptyColoredLamp, ItemBlockColoredLamp.class, EMPTYCOLOREDLAMP_UNLOC_NAME);
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
			
		}
	}
	
	public static void addNames()
	{
		LanguageRegistry.addName(lamp, "Stone Lamp");
		LanguageRegistry.addName(emptyLamp, "Empty Stone Lamp");
		LanguageRegistry.addName(coloredLamp, COLOREDLAMP_LOC_NAME);
		LanguageRegistry.addName(emptyColoredLamp, EMPTYCOLOREDLAMP_LOC_NAME);
	}

}
