package tk.inlcraft.elements;

import java.util.List;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.*;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.util.StatCollector;
import tk.inlcraft.elements.gui.*;
import net.minecraft.block.*;

@Mod(modid="elements", name="Elements", version="Build 1")



public class mod_Elements {
	public static Block blockTest;
	public static Block blockTestWithGUI;
	public static Item itemTest;
	public static CreativeTabs CreativeTab;
	
	public static final String MODID = "elements"; 
	public static final String VERSION = "Build 1";
	
	@Instance(MODID)
	public static mod_Elements instance;
	
	@SidedProxy(
	clientSide = "tk.inlcraft.elements.ElementsClientProxy",
	serverSide = "tk.inlcraft.elements.ElementsCommonProxy"
	)
	
	public static ElementsCommonProxy proxy;
	
	@EventHandler
	public void preLoad(FMLPreInitializationEvent event)

	{
//				Following is/are creativeTab(s).
				CreativeTab = new CreativeTab("elements");
//				Following is/are block(s).
//										(ID(?),Material,UnlocalizedName,StepSoundType)
				blockTest = new BaseBlock(1000, Material.rock,  "blocktest",    Block.soundTypeStone);
//				Following is/are item(s).
//									(ID(?),UnlocalizedName)
				itemTest = new BaseItem (20000, "itemtest","H2O");
				
				
				

		GameRegistry.registerItem(itemTest, itemTest.getUnlocalizedName().substring(5));
		StatCollector.translateToLocal("itemGroup.elements");
		StatCollector.translateToLocal("tile.blocktest.name");
		StatCollector.translateToLocal("item.itemtest.name");
		
	};

	@EventHandler

	public void load(FMLInitializationEvent event)

	{
		System.out.println("Starting Elements Build 1 by Lambda");
		System.out.println("Offical website:https://inlcraft.tk");
		System.out.println("INLCraft 2013-2016,All rights reserved.");
		
		
	}

	 

	@EventHandler

	public void postLoad(FMLPostInitializationEvent event)

	{
		System.gc();
		blockTestWithGUI = new BlockWithGUI(Material.rock)
				.setBlockTextureName(MODID + ":" + "blocktestwithgui")
		        .setBlockName("blocktestwithgui").setCreativeTab(mod_Elements.CreativeTab);
		        GameRegistry.registerBlock(blockTestWithGUI, "blocktestwithgui");
		        GameRegistry.registerTileEntity(TileEntityBlockGUI.class, "TileEntityBlockTestWithGUI");
		 
		        NetworkRegistry.INSTANCE.registerGuiHandler(this, proxy);
	}

}
