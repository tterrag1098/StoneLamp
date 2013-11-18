package tterrag.stoneLamp.client;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import tterrag.stoneLamp.block.BlockLamp;
import tterrag.stoneLamp.block.ModBlock;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class ColoredLampRenderer implements ISimpleBlockRenderingHandler {

	static int renderPass;

	  @Override
	  public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {
	    
	    renderer.setOverrideBlockTexture(BlockLamp.icons[13]);
	    renderer.renderBlockAsItem(Block.glass, 0, 1);
		Tessellator tessellator = Tessellator.instance;
		if (block.blockID == ModBlock.COLOREDLAMP_ID || block.blockID == ModBlock.EMPTYCOLOREDLAMP_ID)
	    	tessellator.setColorOpaque_I(((BlockLamp)block).getBlockColor(metadata));
	    renderer.clearOverrideBlockTexture();
	  }

	  @Override
	  public boolean shouldRender3DInInventory() {
	    return true;
	  }

	  @Override
	  public int getRenderId() {
	    return BlockLamp.renderId;
	  }

	@Override
	public boolean renderWorldBlock(IBlockAccess blockAccess, int x, int y,
			int z, Block rawBlock, int modelId, RenderBlocks renderer) {
		if (modelId == getRenderId()) {
			System.out.println(blockAccess.getBlockId(x, y, z));
			int id = blockAccess.getBlockId(x, y, z);
			int brightness = rawBlock.getMixedBrightnessForBlock(blockAccess,
					x, y, z);

			Tessellator tessellator = Tessellator.instance;
			tessellator.setColorOpaque_I(((BlockLamp)rawBlock).getBlockColor(blockAccess.getBlockMetadata(x, y, z)));
			tessellator.setBrightness(brightness);
			
			BlockLamp block = ((BlockLamp) rawBlock);

			renderer.renderFaceYNeg(block, x, y, z, BlockLamp.icons[12]);
			renderer.renderFaceYPos(block, x, y, z, BlockLamp.icons[12]);
			renderer.renderFaceXNeg(block, x, y, z, BlockLamp.icons[12]);
			renderer.renderFaceXPos(block, x, y, z, BlockLamp.icons[12]);
			renderer.renderFaceZNeg(block, x, y, z, BlockLamp.icons[12]);
			renderer.renderFaceZPos(block, x, y, z, BlockLamp.icons[12]);	

			for (Icon icon : getIconsToDraw(blockAccess, x, y, z, block, 0))
				if (icon != null)
					renderer.renderFaceYNeg(block, x, y, z, icon);
			for (Icon icon : getIconsToDraw(blockAccess, x, y, z, block, 1))
				if (icon != null)
					renderer.renderFaceYPos(block, x, y, z, icon);
			for (Icon icon : getIconsToDraw(blockAccess, x, y, z, block, 2))
				if (icon != null)
					renderer.renderFaceXNeg(block, x, y, z, icon);
			for (Icon icon : getIconsToDraw(blockAccess, x, y, z, block, 3))
				if (icon != null)
					renderer.renderFaceXPos(block, x, y, z, icon);
			for (Icon icon : getIconsToDraw(blockAccess, x, y, z, block, 4))
				if (icon != null)
					renderer.renderFaceZNeg(block, x, y, z, icon);
			for (Icon icon : getIconsToDraw(blockAccess, x, y, z, block, 5))
				if (icon != null)
					renderer.renderFaceZPos(block, x, y, z, icon);
			
			block.getRenderColor(0);
			}
		return true;
	}

	  private Icon[] getIcons()
	  {
		  Icon[] allIcons = BlockLamp.icons;
		  Icon[] newIcons = new Icon[12];
		  for (int i = 0; i < 12; i++)
			  newIcons[i] = allIcons[i];
		  return newIcons;
	  }
	  
	  public Icon[] getIconsToDraw(IBlockAccess blockAccess, int x, int y, int z, Block block, int side)
	  {
		  boolean up = false, down = false, left = false, right = false, upLeft = false, upRight = false, downLeft = false, downRight = false;
		  int id = block.blockID;

		Icon[] iconsToDraw = new Icon[12];
		int index = 0;
		
		Icon[] allIcons = getIcons();
		
		switch (side) {
		case 0:
			up = id == blockAccess.getBlockId(x, y, z - 1);
			down = id == blockAccess.getBlockId(x, y, z + 1);
			left = id == blockAccess.getBlockId(x - 1, y, z);
			right = id == blockAccess.getBlockId(x + 1, y, z);
			upLeft = id == blockAccess.getBlockId(x - 1, y, z - 1);
			upRight = id == blockAccess.getBlockId(x + 1, y, z - 1);
			downLeft = id == blockAccess.getBlockId(x - 1, y, z + 1);
			downRight = id == blockAccess.getBlockId(x + 1, y, z + 1);
			break;
		case 1:
			up = id == blockAccess.getBlockId(x, y, z - 1);
			down = id == blockAccess.getBlockId(x, y, z + 1);
			left = id == blockAccess.getBlockId(x - 1, y, z);
			right = id == blockAccess.getBlockId(x + 1, y, z);
			upLeft = id == blockAccess.getBlockId(x - 1, y, z - 1);
			upRight = id == blockAccess.getBlockId(x + 1, y, z - 1);
			downLeft = id == blockAccess.getBlockId(x - 1, y, z + 1);
			downRight = id == blockAccess.getBlockId(x + 1, y, z + 1);
			break;
		case 2:
			up = id == blockAccess.getBlockId(x, y + 1, z);
			down = id == blockAccess.getBlockId(x, y - 1, z);
			left = id == blockAccess.getBlockId(x, y, z - 1);
			right = id == blockAccess.getBlockId(x, y, z + 1);
			upLeft = id == blockAccess.getBlockId(x, y + 1, z - 1);
			upRight = id == blockAccess.getBlockId(x, y + 1, z + 1);
			downLeft = id == blockAccess.getBlockId(x, y - 1, z - 1);
			downRight = id == blockAccess.getBlockId(x, y - 1, z + 1);
			break;
		case 3:
			up = id == blockAccess.getBlockId(x, y + 1, z);
			down = id == blockAccess.getBlockId(x, y - 1, z);
			left = id == blockAccess.getBlockId(x, y, z + 1);
			right = id == blockAccess.getBlockId(x, y, z - 1);
			upLeft = id == blockAccess.getBlockId(x, y + 1, z + 1);
			upRight = id == blockAccess.getBlockId(x, y + 1, z - 1);
			downLeft = id == blockAccess.getBlockId(x, y - 1, z + 1);
			downRight = id == blockAccess.getBlockId(x, y - 1, z - 1);
			break;
		case 4:
			up = id == blockAccess.getBlockId(x, y + 1, z);
			down = id == blockAccess.getBlockId(x, y - 1, z);
			left = id == blockAccess.getBlockId(x + 1, y, z);
			right = id == blockAccess.getBlockId(x - 1, y, z);
			upLeft = id == blockAccess.getBlockId(x + 1, y + 1, z);
			upRight = id == blockAccess.getBlockId(x - 1, y + 1, z);
			downLeft = id == blockAccess.getBlockId(x + 1, y - 1, z);
			downRight = id == blockAccess.getBlockId(x - 1, y - 1, z);
			break;
		case 5:
			up = id == blockAccess.getBlockId(x, y + 1, z);
			down = id == blockAccess.getBlockId(x, y - 1, z);
			left = id == blockAccess.getBlockId(x - 1, y, z);
			right = id == blockAccess.getBlockId(x + 1, y, z);
			upLeft = id == blockAccess.getBlockId(x - 1, y + 1, z);
			upRight = id == blockAccess.getBlockId(x + 1, y + 1, z);
			downLeft = id == blockAccess.getBlockId(x - 1, y - 1, z);
			downRight = id == blockAccess.getBlockId(x + 1, y - 1, z);
			break;
		}
		if (!up)
		{
			iconsToDraw[index] = allIcons[0];
			index++;
		}
		if (!right)
		{
			iconsToDraw[index] = allIcons[1];
			index++;
		}
		if (!down)
		{
			iconsToDraw[index] = allIcons[2];
			index++;
		}
		if (!left)
		{
			iconsToDraw[index] = allIcons[3];
			index++;
		}
		if (!upLeft && (up && left))
		{
			iconsToDraw[index] = allIcons[4];
			index++;
		}
		if (!downLeft && (down && left))
		{
			iconsToDraw[index] = allIcons[5];
			index++;
		}
		if (!downRight && (down && right))
		{
			iconsToDraw[index] = allIcons[6];
			index++;
		}
		if (!upRight && (up && right))
		{
			iconsToDraw[index] = allIcons[7];
			index++;
		}
		if (!up && !left)
		{
			iconsToDraw[index] = allIcons[8];
			index++;
		}
		if (!down && !left)
		{
			iconsToDraw[index] = allIcons[9];
			index++;
		}
		if (!down && !right)
		{
			iconsToDraw[index] = allIcons[10];
			index++;
		}
		if (!up && !right)
		{
			iconsToDraw[index] = allIcons[11];
			index++;
		}
		return iconsToDraw; 
	  }
}
