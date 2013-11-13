package tterrag.stoneLamp.client;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.IBlockAccess;
import tterrag.stoneLamp.block.BlockLamp;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class ColoredLampRenderer implements ISimpleBlockRenderingHandler {

	public static int renderID;
	
	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID,
			RenderBlocks renderer) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z,
			Block block, int modelID, RenderBlocks renderer) {
		if (modelID == renderID) {
			return RenderColoredLamp(block, x, y, z, renderer);
		}
		return false;
	}

	public boolean RenderColoredLamp(Block block, int i, int j, int k,
			RenderBlocks renderblocks) {
		System.out.println("Test");
		block.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		renderblocks.renderStandardBlock(block, i, j, k);
		renderblocks.overrideBlockTexture = BlockLamp.icons[0];
		
		Tessellator tesselator = Tessellator.instance;
		tesselator.setColorOpaque(255, 255, 0);
		
		renderblocks.overrideBlockTexture = null;
		return true;
	}

	@Override
	public boolean shouldRender3DInInventory() {
		return true;
	}

	@Override
	public int getRenderId() {
		return renderID;
	}

}
