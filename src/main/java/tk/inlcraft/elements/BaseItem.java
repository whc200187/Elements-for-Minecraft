package tk.inlcraft.elements;

import java.util.List;

import net.minecraft.entity.player.*;
import net.minecraft.item.*;

public class BaseItem extends Item{
	
	String ChemicalFormula;
	
	public BaseItem(int par1,String UnlocalizedName,String tip) {
		String Texture="Elements:"+UnlocalizedName;
		setUnlocalizedName(UnlocalizedName);
		this.setTextureName(Texture);
		this.setCreativeTab(mod_Elements.CreativeTab);
		ChemicalFormula=tip;
	}
	
	@Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List List, boolean par4) 
	{
	List.add(ChemicalFormula);
		
	}
}
