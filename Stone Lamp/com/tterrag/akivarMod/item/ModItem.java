package tterrag.akivarMod.item;

import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModItem {
	
	public static String TEXTURE_LOC = "akivarmod";
	
	public static int CONNECTOR_ID = 24242;
	public static final String CONNECTOR_KEY = "connector";
	public static final String CONNECTOR_UNLOC_NAME = "textureConnector";
	public static final String CONNECTOR_LOC_NAME = "Texture Connector";
	
	public static Item textureConnector;
	
	public static void init()
	{
		textureConnector = new ItemConnector(CONNECTOR_ID);
	}
	
	public static void addRecipes()
	{		 

	}
	
	public static void addNames()
	{
		LanguageRegistry.addName(textureConnector, CONNECTOR_LOC_NAME);
	}
}
