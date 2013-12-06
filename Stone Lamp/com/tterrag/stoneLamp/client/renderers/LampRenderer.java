package tterrag.stoneLamp.client.renderers;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;

import org.apache.commons.lang3.ArrayUtils;
import org.lwjgl.opengl.GL11;

import tterrag.stoneLamp.common.api.BaseBlockRenderer;
import tterrag.stoneLamp.common.block.BlockLamp;
import tterrag.stoneLamp.common.block.ModBlock;

public class LampRenderer extends BaseBlockRenderer {
    
    private static LampRenderer INSTANCE = new LampRenderer();

    public static LampRenderer instance() {
        return INSTANCE;
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess blockAccess, int x, int y, int z, Block rawBlock, int modelId, RenderBlocks renderer) {
        Tessellator tessellator = Tessellator.instance;
        BlockLamp block = ((BlockLamp) rawBlock);        
                
        tessellator.setColorOpaque_I(block.getBlockColor(blockAccess.getBlockMetadata(x, y, z)));
        
        int brightness = block.getMixedBrightnessForBlock(blockAccess, x, y, z);
        int id = block.blockID;
        if (id == ModBlock.coloredLamp.blockID || id == ModBlock.lamp.blockID)
        	tessellator.setBrightness(brightness);// + renderer.brightnessBottomLeft + renderer.brightnessBottomRight + renderer.brightnessTopLeft + renderer.brightnessTopRight + block.getLightValue(blockAccess, x, y, z));
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
        
        
        return true;
    }
    
    protected static void renderAsItem(Block block, int metadata, RenderBlocks renderer, Icon icon) {
        Tessellator tessellator = Tessellator.instance;
        GL11.glTranslatef(-0.5F, -0.5F, -0.5F); // Set angled view
        tessellator.startDrawingQuads();

        // Y-
        tessellator.setColorOpaque_I(((BlockLamp) block).getBlockColorWithDarkness(metadata));
        tessellator.setNormal(0.0F, -1.0F, 0.0F);
        renderer.renderFaceYNeg(block, 0, 0, 0, icon);

        // Y+
        tessellator.setColorOpaque_I(((BlockLamp) block).getBlockColorWithDarkness(metadata));
        tessellator.setNormal(0.0F, 1.0F, 0.0F);
        renderer.renderFaceYPos(block, 0, 0, 0, icon);

        // X+
        tessellator.setColorOpaque_I(((BlockLamp) block).getBlockColorWithDarkness(metadata));
        tessellator.setNormal(0.0F, 0.0F, -1.0F);
        renderer.renderFaceXPos(block, 0, 0, 0, icon);

        // X-
        tessellator.setColorOpaque_I(((BlockLamp) block).getBlockColorWithDarkness(metadata));
        tessellator.setNormal(0.0F, 0.0F, 1.0F);
        renderer.renderFaceXNeg(block, 0, 0, 0, icon);

        // Z-
        tessellator.setColorOpaque_I(((BlockLamp) block).getBlockColorWithDarkness(metadata));
        tessellator.setNormal(-1.0F, 0.0F, 0.0F);
        renderer.renderFaceZNeg(block, 0, 0, 0, icon);

        // Z+
        tessellator.setColorOpaque_I(((BlockLamp) block).getBlockColorWithDarkness(metadata));
        tessellator.setNormal(1.0F, 0.0F, 0.0F);
        renderer.renderFaceZPos(block, 0, 0, 0, icon);

        GL11.glTranslatef(0.5F, 0.5F, 0.5F); // Reset angled view
        tessellator.draw();
    }
    
    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {
        //renderer.setOverrideBlockTexture(BlockLamp.icons[13]);
        renderAsItem(block,metadata,renderer,BlockLamp.icons[13]);
        //renderer.renderBlockAsItem(Block.glass, ((BlockLamp) block).getBlockColor(metadata), 1);
        //Tessellator tessellator = Tessellator.instance;
        //if (block.blockID == BlockIds.COLOREDLAMP_ID || block.blockID == BlockIds.EMPTYCOLOREDLAMP_ID)
            //tessellator.setColorOpaque_I(((BlockLamp) block).getBlockColor(metadata));

        //renderer.clearOverrideBlockTexture();
    }
    
    private Icon[] getIcons() {
        return ArrayUtils.remove(BlockLamp.icons, BlockLamp.icons.length - 1);
    }

    public Icon[] getIconsToDraw(IBlockAccess blockAccess, int x, int y, int z, Block block, int side) {
        boolean up = false, down = false, left = false, right = false, upLeft = false, upRight = false, downLeft = false, downRight = false;
        int id = block.blockID;
        int meta = blockAccess.getBlockMetadata(x, y, z);

        Icon[] iconsToDraw = new Icon[12];
        int index = 0;

        Icon[] allIcons = getIcons();

        switch (side) {
            case 0:
                up = id == blockAccess.getBlockId(x, y, z - 1) && meta == blockAccess.getBlockMetadata(x, y, z - 1);
                down = id == blockAccess.getBlockId(x, y, z + 1) && meta == blockAccess.getBlockMetadata(x, y, z + 1);
                left = id == blockAccess.getBlockId(x - 1, y, z) && meta == blockAccess.getBlockMetadata(x - 1, y, z);
                right = id == blockAccess.getBlockId(x + 1, y, z) && meta == blockAccess.getBlockMetadata(x + 1, y, z);
                upLeft = id == blockAccess.getBlockId(x - 1, y, z - 1) && meta == blockAccess.getBlockMetadata(x - 1, y, z - 1);
                upRight = id == blockAccess.getBlockId(x + 1, y, z - 1) && meta == blockAccess.getBlockMetadata(x + 1, y, z - 1);
                downLeft = id == blockAccess.getBlockId(x - 1, y, z + 1) && meta == blockAccess.getBlockMetadata(x - 1, y, z + 1);
                downRight = id == blockAccess.getBlockId(x + 1, y, z + 1) && meta == blockAccess.getBlockMetadata(x + 1, y, z + 1);
                break;
            case 1:
                up = id == blockAccess.getBlockId(x, y, z - 1) && meta == blockAccess.getBlockMetadata(x, y, z - 1);
                down = id == blockAccess.getBlockId(x, y, z + 1) && meta == blockAccess.getBlockMetadata(x, y, z + 1);
                left = id == blockAccess.getBlockId(x - 1, y, z) && meta == blockAccess.getBlockMetadata(x - 1, y, z);
                right = id == blockAccess.getBlockId(x + 1, y, z) && meta == blockAccess.getBlockMetadata(x + 1, y, z);
                upLeft = id == blockAccess.getBlockId(x - 1, y, z - 1) && meta == blockAccess.getBlockMetadata(x - 1, y, z - 1);
                upRight = id == blockAccess.getBlockId(x + 1, y, z - 1) && meta == blockAccess.getBlockMetadata(x + 1, y, z - 1);
                downLeft = id == blockAccess.getBlockId(x - 1, y, z + 1) && meta == blockAccess.getBlockMetadata(x - 1, y, z + 1);
                downRight = id == blockAccess.getBlockId(x + 1, y, z + 1) && meta == blockAccess.getBlockMetadata(x + 1, y, z + 1);
                break;
            case 2:
                up = id == blockAccess.getBlockId(x, y + 1, z) && meta == blockAccess.getBlockMetadata(x, y + 1, z);
                down = id == blockAccess.getBlockId(x, y - 1, z) && meta == blockAccess.getBlockMetadata(x, y - 1, z);
                left = id == blockAccess.getBlockId(x, y, z - 1) && meta == blockAccess.getBlockMetadata(x, y, z - 1);
                right = id == blockAccess.getBlockId(x, y, z + 1) && meta == blockAccess.getBlockMetadata(x, y, z + 1);
                upLeft = id == blockAccess.getBlockId(x, y + 1, z - 1) && meta == blockAccess.getBlockMetadata(x, y + 1, z - 1);
                upRight = id == blockAccess.getBlockId(x, y + 1, z + 1) && meta == blockAccess.getBlockMetadata(x, y + 1, z + 1);
                downLeft = id == blockAccess.getBlockId(x, y - 1, z - 1) && meta == blockAccess.getBlockMetadata(x, y - 1, z - 1);
                downRight = id == blockAccess.getBlockId(x, y - 1, z + 1) && meta == blockAccess.getBlockMetadata(x, y - 1, z + 1);
                break;
            case 3:
                up = id == blockAccess.getBlockId(x, y + 1, z) && meta == blockAccess.getBlockMetadata(x, y + 1, z);
                down = id == blockAccess.getBlockId(x, y - 1, z) && meta == blockAccess.getBlockMetadata(x, y - 1, z);
                left = id == blockAccess.getBlockId(x, y, z + 1) && meta == blockAccess.getBlockMetadata(x, y, z + 1);
                right = id == blockAccess.getBlockId(x, y, z - 1) && meta == blockAccess.getBlockMetadata(x, y, z - 1);
                upLeft = id == blockAccess.getBlockId(x, y + 1, z + 1) && meta == blockAccess.getBlockMetadata(x, y + 1, z + 1);
                upRight = id == blockAccess.getBlockId(x, y + 1, z - 1) && meta == blockAccess.getBlockMetadata(x, y + 1, z - 1);
                downLeft = id == blockAccess.getBlockId(x, y - 1, z + 1) && meta == blockAccess.getBlockMetadata(x, y - 1, z + 1);
                downRight = id == blockAccess.getBlockId(x, y - 1, z - 1) && meta == blockAccess.getBlockMetadata(x, y - 1, z - 1);
                break;
            case 4:
                up = id == blockAccess.getBlockId(x, y + 1, z) && meta == blockAccess.getBlockMetadata(x, y + 1, z);
                down = id == blockAccess.getBlockId(x, y - 1, z) && meta == blockAccess.getBlockMetadata(x, y - 1, z);
                left = id == blockAccess.getBlockId(x + 1, y, z) && meta == blockAccess.getBlockMetadata(x + 1, y, z);
                right = id == blockAccess.getBlockId(x - 1, y, z) && meta == blockAccess.getBlockMetadata(x - 1, y, z);
                upLeft = id == blockAccess.getBlockId(x + 1, y + 1, z) && meta == blockAccess.getBlockMetadata(x + 1, y + 1, z);
                upRight = id == blockAccess.getBlockId(x - 1, y + 1, z) && meta == blockAccess.getBlockMetadata(x - 1, y + 1, z);
                downLeft = id == blockAccess.getBlockId(x + 1, y - 1, z) && meta == blockAccess.getBlockMetadata(x + 1, y - 1, z);
                downRight = id == blockAccess.getBlockId(x - 1, y - 1, z) && meta == blockAccess.getBlockMetadata(x - 1, y - 1, z);
                break;
            case 5:
                up = id == blockAccess.getBlockId(x, y + 1, z) && meta == blockAccess.getBlockMetadata(x, y + 1, z);
                down = id == blockAccess.getBlockId(x, y - 1, z) && meta == blockAccess.getBlockMetadata(x, y - 1, z);
                left = id == blockAccess.getBlockId(x - 1, y, z) && meta == blockAccess.getBlockMetadata(x - 1, y, z);
                right = id == blockAccess.getBlockId(x + 1, y, z) && meta == blockAccess.getBlockMetadata(x + 1, y, z);
                upLeft = id == blockAccess.getBlockId(x - 1, y + 1, z) && meta == blockAccess.getBlockMetadata(x - 1, y + 1, z);
                upRight = id == blockAccess.getBlockId(x + 1, y + 1, z) && meta == blockAccess.getBlockMetadata(x + 1, y + 1, z);
                downLeft = id == blockAccess.getBlockId(x - 1, y - 1, z) && meta == blockAccess.getBlockMetadata(x - 1, y - 1, z);
                downRight = id == blockAccess.getBlockId(x + 1, y - 1, z) && meta == blockAccess.getBlockMetadata(x + 1, y - 1, z);
                break;
        }
        if (!up) {
            iconsToDraw[index] = allIcons[0];
            index++;
        }
        if (!right) {
            iconsToDraw[index] = allIcons[1];
            index++;
        }
        if (!down) {
            iconsToDraw[index] = allIcons[2];
            index++;
        }
        if (!left) {
            iconsToDraw[index] = allIcons[3];
            index++;
        }
        if (!upLeft && (up && left)) {
            iconsToDraw[index] = allIcons[4];
            index++;
        }
        if (!downLeft && (down && left)) {
            iconsToDraw[index] = allIcons[5];
            index++;
        }
        if (!downRight && (down && right)) {
            iconsToDraw[index] = allIcons[6];
            index++;
        }
        if (!upRight && (up && right)) {
            iconsToDraw[index] = allIcons[7];
            index++;
        }
        if (!up && !left) {
            iconsToDraw[index] = allIcons[8];
            index++;
        }
        if (!down && !left) {
            iconsToDraw[index] = allIcons[9];
            index++;
        }
        if (!down && !right) {
            iconsToDraw[index] = allIcons[10];
            index++;
        }
        if (!up && !right) {
            iconsToDraw[index] = allIcons[11];
            index++;
        }
        return iconsToDraw;
    }
}
