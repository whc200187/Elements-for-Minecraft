package tk.inlcraft.elements;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BaseBlock extends Block{

	public BaseBlock(int par1, Material par2Material,String UnlocalizedName,SoundType stepsound) {
		super(par2Material);
		String Texture="elements:"+UnlocalizedName;
		
		this.setBlockName(UnlocalizedName);
		this.setBlockTextureName(Texture);
		this.setHardness(1.5f); 
		this.setResistance(10.0f);
		this.setStepSound(stepsound); 
		this.setCreativeTab(mod_Elements.CreativeTab); 
		GameRegistry.registerBlock(this, UnlocalizedName);
	}

}
