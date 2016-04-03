package tk.inlcraft.elements.gui;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.*;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityBlockGUI extends TileEntity implements IInventory{

	public int tableBurnTime = 0;
	public int maxBurnTime = 0;
	
	private ItemStack stack[] = new ItemStack[3];

	@Override
	public void updateEntity() {
		super.updateEntity();
		if(!this.worldObj.isRemote)
		    // 判断燃烧时间
			if (tableBurnTime > 0) {
				// 取得修复的物品
				ItemStack repairItem = getStackInSlot(0);
				// 取得修复好的物品
				ItemStack outputItem = getStackInSlot(1);
				// 确定开始修复的条件之一：修复物品槽不为空，已修复物品槽为空
				if (repairItem != null && outputItem == null) {
					// 判断被修复的物品是否为工具或武器
					if (repairItem.getItem() == Items.iron_sword || repairItem.getItem() == Items.stone_sword || 
							repairItem.getItem() == Items.golden_sword || repairItem.getItem() == Items.diamond_sword || 
							repairItem.getItem() instanceof ItemArmor) {
						//System.out.println("can repair");
						// 判断物品是否要修理
						if (repairItem.getItemDamage() > 0) {
							// 修复物品
							repairItem.setItemDamage(repairItem.getItemDamage() - 1);
						} else {
							setInventorySlotContents(1, repairItem);
							setInventorySlotContents(0, null);
						}
					}
				}
				// 减少燃烧时间
				tableBurnTime -= 1;
			} else // 没有燃料的情况下
			{
				// 如果有被修复的物品
				if (getStackInSlot(0) != null) {
					// 取得燃料槽的物品
					ItemStack burnItem = getStackInSlot(2);
					// 取得物品的燃烧值
					int getBurnTime = getItemBurnTime(burnItem);
					// 判断物品是否能燃烧
					if (getBurnTime > 0) {
						maxBurnTime = getBurnTime;
						tableBurnTime = getBurnTime;
						// 如果燃烧物品为岩浆桶
						if (burnItem.getItem() == Items.lava_bucket) {
							// 取得空桶
							setInventorySlotContents(2, new ItemStack(Items.bucket,
									1));
						} else {
							// 其他物品就减少
							if (burnItem.stackSize - 1 > 0) {
								burnItem.stackSize--;
								setInventorySlotContents(2, burnItem);
							} else {
								setInventorySlotContents(2, null);
							}
						}
					}
				}
			}
		System.out.println("GUI is running!");
	}

	@Override
	public int getSizeInventory() {
		// TODO Auto-generated method stub
		return stack.length;
	}

	@Override
	public ItemStack getStackInSlot(int var1) {
		// TODO Auto-generated method stub
		return stack[var1];
	}

	@Override
	public ItemStack decrStackSize(int par1, int par2) {
		// TODO Auto-generated method stub
		if (this.stack[par1] != null) {
			ItemStack var3;
			if (this.stack[par1].stackSize <= par2) {
				var3 = this.stack[par1];
				this.stack[par1] = null;
				return var3;
			} else {
				var3 = this.stack[par1].splitStack(par2);
				if (this.stack[par1].stackSize == 0) {
					this.stack[par1] = null;
				}
				return var3;
			}
		} else {
			return null;
		}
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int p_70304_1_) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setInventorySlotContents(int var1, ItemStack var2) {
		// TODO Auto-generated method stub
		stack[var1] = var2;
	}

	@Override
	public String getInventoryName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasCustomInventoryName() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		// TODO Auto-generated method stub
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer p_70300_1_) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void openInventory() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeInventory() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_) {
		// TODO Auto-generated method stub
		return false;
	}

	public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readFromNBT(par1NBTTagCompound);
        NBTTagList var2 = par1NBTTagCompound.getTagList("Items", 10);
        this.stack = new ItemStack[this.getSizeInventory()];
        for (int var3 = 0; var3 < var2.tagCount(); ++var3)
        {
            NBTTagCompound var4 = (NBTTagCompound)var2.getCompoundTagAt(var3);
            byte var5 = var4.getByte("Slot");
            if (var5 >= 0 && var5 < this.stack.length)
            {
                this.stack[var5] = ItemStack.loadItemStackFromNBT(var4);
            }
        }
        this.tableBurnTime = par1NBTTagCompound.getShort("tableBurnTime");
        this.maxBurnTime = par1NBTTagCompound.getShort("maxBurnTime");
    }
 
    public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setShort("tableBurnTime", (short)this.tableBurnTime);
        par1NBTTagCompound.setShort("maxBurnTime", (short)this.maxBurnTime);
        NBTTagList var2 = new NBTTagList();
        for (int var3 = 0; var3 < this.stack.length; ++var3)
        {
            if (this.stack[var3] != null)
            {
                NBTTagCompound var4 = new NBTTagCompound();
                var4.setByte("Slot", (byte)var3);
                this.stack[var3].writeToNBT(var4);
                var2.appendTag(var4);
            }
        }
        par1NBTTagCompound.setTag("Items", var2);
    }
    public static int getItemBurnTime(ItemStack p_145952_0_)
    {
        if (p_145952_0_ == null)
        {
            return 0;
        }
        else
        {
            Item item = p_145952_0_.getItem();
 
            if (item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.air)
            {
                Block block = Block.getBlockFromItem(item);
 
                if (block == Blocks.wooden_slab)
                {
                    return 150;
                }
 
                if (block.getMaterial() == Material.wood)
                {
                    return 300;
                }
 
                if (block == Blocks.coal_block)
                {
                    return 16000;
                }
            }
 
            if (item instanceof ItemTool && ((ItemTool)item).getToolMaterialName().equals("WOOD")) return 200;
            if (item instanceof ItemSword && ((ItemSword)item).getToolMaterialName().equals("WOOD")) return 200;
            if (item instanceof ItemHoe && ((ItemHoe)item).getToolMaterialName().equals("WOOD")) return 200;
            if (item == Items.stick) return 100;
            if (item == Items.coal) return 1600;
            if (item == Items.lava_bucket) return 20000;
            if (item == Item.getItemFromBlock(Blocks.sapling)) return 100;
            if (item == Items.blaze_rod) return 2400;
            return GameRegistry.getFuelValue(p_145952_0_);
        }
    }
}
