package tk.inlcraft.elements.gui;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import tk.inlcraft.elements.mod_Elements;

public class BlockWithGUI extends BlockContainer {

	public BlockWithGUI(Material p_i45386_1_) {
		super(p_i45386_1_);

	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {

		return null;
	}

	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3,
            int par4, EntityPlayer par5EntityPlayer, int par6, float par7,
            float par8, float par9) {

		par5EntityPlayer.openGui(mod_Elements.instance, 10, par1World, par2, par3, par4);
		return true;
	}
}
