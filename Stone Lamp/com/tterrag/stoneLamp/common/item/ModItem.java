package tterrag.stoneLamp.common.item;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import tterrag.stoneLamp.common.block.ModBlock;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModItem {
	
	public static String TEXTURE_LOC = "akivarmod";
	
	public static final String CONNECTOR_KEY = "connector";
	public static final String CONNECTOR_UNLOC_NAME = "textureConnectorWand";
	public static final String CONNECTOR_LOC_NAME = "Texture Connector Wand";

	
	public static Item textureConnector;
	
	public static void init()
	{
		textureConnector = new ItemConnector();
		GameRegistry.registerItem(textureConnector, CONNECTOR_UNLOC_NAME);
	}
	
	public static void addRecipes()
	{		 
		GameRegistry.addRecipe(new ItemStack(textureConnector), new Object[]{
			"  L",
			" S ",
			"S  ",
			
			'L', ModBlock.emptyLamp,
			'S', Items.stick
		});
	}
}
