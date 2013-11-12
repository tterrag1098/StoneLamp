package tterrag.stoneLamp.config;

import java.io.File;

import net.minecraftforge.common.Configuration;
import tterrag.stoneLamp.block.ModBlock;
import tterrag.stoneLamp.item.ModItem;

public class ConfigHandler {
	
	public static void init(File file) 
	{
		Configuration config = new Configuration(file);
		
		config.load();
				
		/**
		 * Item ID configs
		 */
		ModItem.CONNECTOR_ID = config.getItem(ModItem.CONNECTOR_UNLOC_NAME , ModItem.CONNECTOR_DEFAULT).getInt() - 256;
		
		/**
		 * Block ID configs
		 */
		ModBlock.LAMP_ID = config.getBlock(ModBlock.LAMP_UNLOC_NAME, ModBlock.LAMP_DEFAULT).getInt();
		ModBlock.EMPTYLAMP_ID = config.getBlock(ModBlock.EMPTYLAMP_UNLOC_NAME, ModBlock.EMPTYLAMP_DEFAULT).getInt();
		
		/**
		 * Other configs
		 */
		ConfigKeys.allowConnectedTextures = config.get("Options", ConfigKeys.ALLOW_CON_TEXTURES_KEY, true).getBoolean(true);
		ConfigKeys.allowDebugItem = config.get("Options", ConfigKeys.ALLOW_DEBUG_KEY, true).getBoolean(true);
		ConfigKeys.maxChannel = config.get("Options", ConfigKeys.MAX_CHANNEL_KEY, 15).getInt();
		
		config.save();
	}
}
