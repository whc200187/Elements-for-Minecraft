package tk.inlcraft.elements;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import tk.inlcraft.elements.gui.Rendering;
import tk.inlcraft.elements.gui.TileEntityBlockGUI;

public class ElementsClientProxy extends ElementsCommonProxy{
	public void preInit() {

        super.preInit();

    }

    

    public void init() {

        super.init();

    }

    

    public void postInit() {

        super.postInit();

    }
    @Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		// TODO Auto-generated method stub
		switch(ID) {
		case 10:
			return new Rendering(player.inventory, (TileEntityBlockGUI)player.worldObj.getTileEntity(x, y, z));
		}
		return null;
        }
}
