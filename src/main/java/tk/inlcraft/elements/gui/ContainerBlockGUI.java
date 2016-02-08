package tk.inlcraft.elements.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;

public class ContainerBlockGUI extends Container{

	public ContainerBlockGUI(InventoryPlayer inventory, TileEntityBlockGUI tileEntity) {
		
	}

	@Override
	public boolean canInteractWith(EntityPlayer p_75145_1_) {

		return true;
	}

}
