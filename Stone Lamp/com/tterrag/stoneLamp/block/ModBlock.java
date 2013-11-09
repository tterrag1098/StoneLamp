package tterrag.stoneLamp.block;

import mods.tinker.tconstruct.common.TContent;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModBlock {
	
	public static final String LAMP_UNLOC_NAME = "stoneLamp";
	public static final String EMPTYLAMP_UNLOC_NAME = "emptyLamp";
	public static final String LAMP_LOC_NAME = "Stone Lamp";
	public static final String EMPTYLAMP_LOC_NAME = "Empty Stone Lamp";
	
	public static final int LAMP_DEFAULT = 2999;
	public static final int EMPTYLAMP_DEFAULT = 2998;
	
	public static int LAMP_ID;
	public static int EMPTYLAMP_ID;
	
	public static Block lamp;
	public static Block emptyLamp;
	
	public static void init()
	{
		lamp = new BlockLamp(LAMP_ID, 0.9F, "blockLamp");
		GameRegistry.registerBlock(lamp, "blockLamp");

		emptyLamp = new BlockLamp(EMPTYLAMP_ID, 0.0F, "blockEmptyLamp");
		GameRegistry.registerBlock(emptyLamp, "blockEmptyLamp");
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
	}
	
	public static void addNames()
	{
		LanguageRegistry.addName(lamp, "Stone Lamp");
		LanguageRegistry.addName(emptyLamp, "Empty Stone Lamp");
	}

}
