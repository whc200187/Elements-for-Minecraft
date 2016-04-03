package tk.inlcraft.elements;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;

public class BaseItem extends Item{
	
	String ChemicalFormula;
	
	public BaseItem(int par1,String UnlocalizedName,String tip,CreativeTabs CreativeTabs) {
		String Texture="Elements:"+UnlocalizedName;
		setUnlocalizedName(UnlocalizedName);
		this.setTextureName(Texture);
		this.setCreativeTab(CreativeTabs);
		ChemicalFormula=tip;
	}
	
	@Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List List, boolean par4) 
	{
	List.add(ChemicalFormula);
		
	}
}
