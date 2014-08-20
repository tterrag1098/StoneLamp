package tterrag.stoneLamp.common.config;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class ConfigHandler
{

	public static void init(File file)
	{
		Configuration config = new Configuration(file);

		config.load();

		/**
		 * Other configs
		 */
		ConfigKeys.allowConnectedTextures = config.get("Options", ConfigKeys.ALLOW_CON_TEXTURES_KEY, true).getBoolean(true);
		ConfigKeys.maxChannel = config.get("Options", ConfigKeys.MAX_CHANNEL_KEY, 15, "Leave this at 15 if \nallow_color_changing_with_wand \nis set to true!").getInt();
		ConfigKeys.allowColorChangeWithWand = config.get("Options", ConfigKeys.ALLOW_COLOR_CHANGE_KEY, false, "Allows color of lamps to be \nchanged in-world with the wand.").getBoolean(false);
		ConfigKeys.allowNewRenderer = config.get("Options", ConfigKeys.ALLOW_NEW_RENDERER_KEY, true, "\nThis renderer fixes missing \ncorners, but comes with some \nstrange lighting issues.").getBoolean(true);
		config.save();
	}
}
