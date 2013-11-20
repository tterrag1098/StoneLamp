package tterrag.stoneLamp.common.api;

import net.minecraft.item.ItemBlock;

public abstract class ItemBlockSL extends ItemBlock {

    public ItemBlockSL(int par1) {
        super(par1);
        this.setHasSubtypes(true);
    }

    public int getMetadata(int meta) {
        return meta;
    }
}