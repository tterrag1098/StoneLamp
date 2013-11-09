package tterrag.stoneLamp;

import tterrag.stoneLamp.block.ModBlock;
import tterrag.stoneLamp.config.ConfigKeys;
import tterrag.stoneLamp.item.ModItem;
import tterrag.stoneLamp.lib.Reference;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class AkivarMod {

	@Instance(Reference.MOD_ID)
	public static AkivarMod instance;

	@PreInit
	public void preInit(FMLPreInitializationEvent event) {
		ModBlock.init();
		if (ConfigKeys.allowDebugItem)
			ModItem.init();
	}

	@Init
	public void init(FMLInitializationEvent event) {
		ModBlock.addNames();
		ModBlock.addRecipes();
		if (ConfigKeys.allowDebugItem)
			ModItem.addNames();
	}

	@PostInit
	public void postInit(FMLPostInitializationEvent event) {

	}
}
