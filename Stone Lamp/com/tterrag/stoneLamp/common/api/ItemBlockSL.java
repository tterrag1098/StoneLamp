package tterrag.stoneLamp.common.api;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public abstract class ItemBlockSL extends ItemBlock {

    public ItemBlockSL(Block block) {
        super(block);
        this.setHasSubtypes(true);
    }

    public int getMetadata(int meta) {
        return meta;
    }
}