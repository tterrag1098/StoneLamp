package tterrag.stoneLamp.common.config;

import java.io.File;

import net.minecraftforge.common.Configuration;
import tterrag.stoneLamp.common.block.BlockInfo;
import tterrag.stoneLamp.common.item.ModItem;

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
		BlockInfo.LAMP_ID = config.getBlock(BlockInfo.LAMP_UNLOC_NAME, BlockInfo.LAMP_DEFAULT).getInt();
		BlockInfo.EMPTYLAMP_ID = config.getBlock(BlockInfo.EMPTYLAMP_UNLOC_NAME, BlockInfo.EMPTYLAMP_DEFAULT).getInt();
		BlockInfo.COLOREDLAMP_ID = config.getBlock(BlockInfo.COLOREDLAMP_UNLOC_NAME, BlockInfo.COLOREDLAMP_DEFAULT).getInt();
		BlockInfo.EMPTYCOLOREDLAMP_ID = config.getBlock(BlockInfo.EMPTYCOLOREDLAMP_UNLOC_NAME, BlockInfo.EMPTYCOLOREDLAMP_DEFAULT).getInt();
		
		/**
		 * Other configs
		 */
		ConfigKeys.allowConnectedTextures = config.get("Options", ConfigKeys.ALLOW_CON_TEXTURES_KEY, true).getBoolean(true);
		ConfigKeys.maxChannel = config.get("Options", ConfigKeys.MAX_CHANNEL_KEY, 15, "Leave this at 15 if \nallow_color_changing_with_wand \nis set to true!").getInt();
		ConfigKeys.allowColorChangeWithWand = config.get("Options", ConfigKeys.ALLOW_COLOR_CHANGE_KEY, false, "Allows color of lamps to be \nchanged in-world with the wand.").getBoolean(false);
		ConfigKeys.allowNewRenderer = config.get("Options", ConfigKeys.ALLOW_NEW_RENDERER_KEY, false, "\nThis renderer fixes missing \ncorners, but comes with some \nstrange lighting issues. WIP").getBoolean(false);
		config.save();
	}
}
