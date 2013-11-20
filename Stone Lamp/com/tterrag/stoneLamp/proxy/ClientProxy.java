package tterrag.stoneLamp.proxy;

import tterrag.stoneLamp.client.renderers.LampRenderer;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy{

    @Override
    public void runClientSide(){
        setupRenderers();
    }
    
    private void setupRenderers(){
        RenderingRegistry.registerBlockHandler(LampRenderer.instance());
    }
    
}
