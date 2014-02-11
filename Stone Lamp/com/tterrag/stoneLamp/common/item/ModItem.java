package tterrag.stoneLamp.common.item;

import net.minecraft.item.Item;
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
	}
	
	public static void addRecipes()
	{		 

	}
	
	public static void addNames()
	{
		LanguageRegistry.addName(textureConnector, CONNECTOR_LOC_NAME);
	}
}
