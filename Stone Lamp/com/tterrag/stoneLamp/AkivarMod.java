package tterrag.stoneLamp;

import net.minecraft.creativetab.CreativeTabs;
import tterrag.stoneLamp.common.block.ModBlock;
import tterrag.stoneLamp.common.config.ConfigHandler;
import tterrag.stoneLamp.common.config.ConfigKeys;
import tterrag.stoneLamp.common.creativetab.CreativeTabStoneLamp;
import tterrag.stoneLamp.common.item.ModItem;
import tterrag.stoneLamp.common.lib.Reference;
import tterrag.stoneLamp.proxy.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class AkivarMod {

	@Instance(Reference.MOD_ID)
	public static AkivarMod instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;
	
	public static CreativeTabs tabStoneLamp = new CreativeTabStoneLamp(CreativeTabs.getNextID());

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		
		ConfigHandler.init(event.getSuggestedConfigurationFile());
		
		ModBlock.init();
		if (ConfigKeys.allowDebugItem)
			ModItem.init();
		
		proxy.runClientSide();
		proxy.initSounds();
		proxy.initRenderers();
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		ModBlock.addRecipes();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {

	}
}
