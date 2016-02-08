package tk.inlcraft.elements;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import tk.inlcraft.elements.gui.ContainerBlockGUI;
import tk.inlcraft.elements.gui.TileEntityBlockGUI;

public class ElementsCommonProxy implements IGuiHandler{
	

    public void preInit() {}

    



    public void init() {}

    


    public void postInit() {}





    @Override 
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
    { 
	    switch(ID) {
	    case 10:
		    return new ContainerBlockGUI(player.inventory, (TileEntityBlockGUI)player.worldObj.getTileEntity(x, y, z));
	    }
	    return null;
    }





	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		// TODO Auto-generated method stub
		return null;
	}

}
