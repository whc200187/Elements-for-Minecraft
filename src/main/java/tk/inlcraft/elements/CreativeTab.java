package tk.inlcraft.elements;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class CreativeTab extends CreativeTabs {

	public CreativeTab(String lable,Item Icon) {
		super(lable);
		Icon=icon;
	}
	
	Item icon;
	
	@Override
	public Item getTabIconItem() {
		
		return icon;
	}

}
