package tterrag.stoneLamp;

import net.minecraft.creativetab.CreativeTabs;
import tterrag.stoneLamp.block.ModBlock;
import tterrag.stoneLamp.config.ConfigHandler;
import tterrag.stoneLamp.config.ConfigKeys;
import tterrag.stoneLamp.creativetab.CreativeTabStoneLamp;
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
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class AkivarMod {

	@Instance(Reference.MOD_ID)
	public static AkivarMod instance;
	
	public static CreativeTabs tabStoneLamp = new CreativeTabStoneLamp(CreativeTabs.getNextID());

	@PreInit
	public void preInit(FMLPreInitializationEvent event) {
		
		ConfigHandler.init(event.getSuggestedConfigurationFile());
		
		ModBlock.init();
		if (ConfigKeys.allowDebugItem)
			ModItem.init();
		
		LanguageRegistry.instance().addStringLocalization("itemGroup." + Reference.TAB_NAME, "en_US", Reference.TAB_LOC_NAME);
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
