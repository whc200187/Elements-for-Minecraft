package tk.inlcraft.elements.gui;

import net.minecraft.tileentity.TileEntity;

public class TileEntityBlockGUI extends TileEntity{

	
	
	@Override
	public void updateEntity() {
		super.updateEntity();
		System.out.println("GUI is running!");
	}

}
