package com.fpghoti.classicswords.item;

import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_12_R1.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_12_R1.NBTTagCompound;
import net.minecraft.server.v1_12_R1.NBTTagDouble;
import net.minecraft.server.v1_12_R1.NBTTagInt;
import net.minecraft.server.v1_12_R1.NBTTagList;
import net.minecraft.server.v1_12_R1.NBTTagString;

public class CItem {
	
	public static void givecDiamondSword(Player p, Boolean hold){
	    ItemStack csword = new ItemStack(Material.SHIELD, 1, (short)1);
        ItemMeta meta = csword.getItemMeta();
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.setDisplayName("Classic Diamond Sword");
        csword.setItemMeta(meta);
	    net.minecraft.server.v1_12_R1.ItemStack nmsStack = CraftItemStack.asNMSCopy(csword);
	    NBTTagCompound compound = (nmsStack.hasTag()) ? nmsStack.getTag() : new NBTTagCompound();
	    NBTTagList modifiers = new NBTTagList();
	    NBTTagCompound damage = new NBTTagCompound();
	    
	    
	    
	    damage.set("AttributeName", new NBTTagString("generic.attackDamage"));
	    damage.set("Name", new NBTTagString("generic.attackDamage"));
	    damage.set("Amount", new NBTTagInt(7));
	    damage.set("Operation", new NBTTagInt(0));
	    damage.set("UUIDLeast", new NBTTagInt(894654));
	    damage.set("UUIDMost", new NBTTagInt(2872));
	    damage.set("Slot", new NBTTagString("mainhand"));
	    
	    NBTTagCompound atspeed = new NBTTagCompound();
	    
	    
	    
	    atspeed.set("AttributeName", new NBTTagString("generic.attackSpeed"));
	    atspeed.set("Name", new NBTTagString("generic.attackSpeed"));
	    atspeed.set("Amount", new NBTTagDouble(1021.6));
	    atspeed.set("Operation", new NBTTagInt(0));
	    atspeed.set("UUIDLeast", new NBTTagInt(894654));
	    atspeed.set("UUIDMost", new NBTTagInt(2872));
	    atspeed.set("Slot", new NBTTagString("mainhand"));
	    
	    modifiers.add(damage);
	    modifiers.add(atspeed);
	    compound.set("AttributeModifiers", modifiers);
	    nmsStack.setTag(compound);
	    csword = CraftItemStack.asBukkitCopy(nmsStack);
	    
	    
        
        
        if(hold){
        	p.getInventory().setItemInMainHand(csword);
        }else{
        	p.sendMessage(ChatColor.AQUA + "Spawning in a cSword...");
        	p.getInventory().addItem(csword);
        }
	}
	public static void givecWoodSword(Player p, Boolean hold){
	    ItemStack csword = new ItemStack(Material.SHIELD, 1, (short)2);
        ItemMeta meta = csword.getItemMeta();
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.setDisplayName("Classic Wood Sword");
        csword.setItemMeta(meta);
	    net.minecraft.server.v1_12_R1.ItemStack nmsStack = CraftItemStack.asNMSCopy(csword);
	    NBTTagCompound compound = (nmsStack.hasTag()) ? nmsStack.getTag() : new NBTTagCompound();
	    NBTTagList modifiers = new NBTTagList();
	    NBTTagCompound damage = new NBTTagCompound();
	    
	    
	    
	    damage.set("AttributeName", new NBTTagString("generic.attackDamage"));
	    damage.set("Name", new NBTTagString("generic.attackDamage"));
	    damage.set("Amount", new NBTTagInt(4));
	    damage.set("Operation", new NBTTagInt(0));
	    damage.set("UUIDLeast", new NBTTagInt(894654));
	    damage.set("UUIDMost", new NBTTagInt(2872));
	    damage.set("Slot", new NBTTagString("mainhand"));
	    
 NBTTagCompound atspeed = new NBTTagCompound();
	    
	    
	    
	    atspeed.set("AttributeName", new NBTTagString("generic.attackSpeed"));
	    atspeed.set("Name", new NBTTagString("generic.attackSpeed"));
	    atspeed.set("Amount", new NBTTagDouble(1021.6));
	    atspeed.set("Operation", new NBTTagInt(0));
	    atspeed.set("UUIDLeast", new NBTTagInt(894654));
	    atspeed.set("UUIDMost", new NBTTagInt(2872));
	    atspeed.set("Slot", new NBTTagString("mainhand"));
	    
	    modifiers.add(damage);
	    modifiers.add(atspeed);
	    compound.set("AttributeModifiers", modifiers);
	    nmsStack.setTag(compound);
	    csword = CraftItemStack.asBukkitCopy(nmsStack);
	    
	    
        
        
        if(hold){
        	p.getInventory().setItemInMainHand(csword);
        }else{
        	p.sendMessage(ChatColor.AQUA + "Spawning in a cSword...");
        	p.getInventory().addItem(csword);
        }
	}
	public static void givecStoneSword(Player p, Boolean hold){
	    ItemStack csword = new ItemStack(Material.SHIELD, 1, (short)3);
        ItemMeta meta = csword.getItemMeta();
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.setDisplayName("Classic Stone Sword");
        csword.setItemMeta(meta);
	    net.minecraft.server.v1_12_R1.ItemStack nmsStack = CraftItemStack.asNMSCopy(csword);
	    NBTTagCompound compound = (nmsStack.hasTag()) ? nmsStack.getTag() : new NBTTagCompound();
	    NBTTagList modifiers = new NBTTagList();
	    NBTTagCompound damage = new NBTTagCompound();
	    
	    
	    
	    damage.set("AttributeName", new NBTTagString("generic.attackDamage"));
	    damage.set("Name", new NBTTagString("generic.attackDamage"));
	    damage.set("Amount", new NBTTagInt(5));
	    damage.set("Operation", new NBTTagInt(0));
	    damage.set("UUIDLeast", new NBTTagInt(894654));
	    damage.set("UUIDMost", new NBTTagInt(2872));
	    damage.set("Slot", new NBTTagString("mainhand"));
	    
 NBTTagCompound atspeed = new NBTTagCompound();
	    
	    
	    
	    atspeed.set("AttributeName", new NBTTagString("generic.attackSpeed"));
	    atspeed.set("Name", new NBTTagString("generic.attackSpeed"));
	    atspeed.set("Amount", new NBTTagDouble(1021.6));
	    atspeed.set("Operation", new NBTTagInt(0));
	    atspeed.set("UUIDLeast", new NBTTagInt(894654));
	    atspeed.set("UUIDMost", new NBTTagInt(2872));
	    atspeed.set("Slot", new NBTTagString("mainhand"));
	    
	    modifiers.add(damage);
	    modifiers.add(atspeed);
	    compound.set("AttributeModifiers", modifiers);
	    nmsStack.setTag(compound);
	    csword = CraftItemStack.asBukkitCopy(nmsStack);
	    
	    
        
        
        if(hold){
        	p.getInventory().setItemInMainHand(csword);
        }else{
        	p.sendMessage(ChatColor.AQUA + "Spawning in a cSword...");
        	p.getInventory().addItem(csword);
        }
	}
	public static void givecIronSword(Player p, Boolean hold){
	    ItemStack csword = new ItemStack(Material.SHIELD, 1, (short)4);
        ItemMeta meta = csword.getItemMeta();
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.setDisplayName("Classic Iron Sword");
        csword.setItemMeta(meta);
	    net.minecraft.server.v1_12_R1.ItemStack nmsStack = CraftItemStack.asNMSCopy(csword);
	    NBTTagCompound compound = (nmsStack.hasTag()) ? nmsStack.getTag() : new NBTTagCompound();
	    NBTTagList modifiers = new NBTTagList();
	    NBTTagCompound damage = new NBTTagCompound();
	    
	    
	    
	    damage.set("AttributeName", new NBTTagString("generic.attackDamage"));
	    damage.set("Name", new NBTTagString("generic.attackDamage"));
	    damage.set("Amount", new NBTTagInt(6));
	    damage.set("Operation", new NBTTagInt(0));
	    damage.set("UUIDLeast", new NBTTagInt(894654));
	    damage.set("UUIDMost", new NBTTagInt(2872));
	    damage.set("Slot", new NBTTagString("mainhand"));
	    
 NBTTagCompound atspeed = new NBTTagCompound();
	    
	    
	    
	    atspeed.set("AttributeName", new NBTTagString("generic.attackSpeed"));
	    atspeed.set("Name", new NBTTagString("generic.attackSpeed"));
	    atspeed.set("Amount", new NBTTagDouble(1021.6));
	    atspeed.set("Operation", new NBTTagInt(0));
	    atspeed.set("UUIDLeast", new NBTTagInt(894654));
	    atspeed.set("UUIDMost", new NBTTagInt(2872));
	    atspeed.set("Slot", new NBTTagString("mainhand"));
	    
	    modifiers.add(damage);
	    modifiers.add(atspeed);
	    compound.set("AttributeModifiers", modifiers);
	    nmsStack.setTag(compound);
	    csword = CraftItemStack.asBukkitCopy(nmsStack);
	    
	    
        
        
        if(hold){
        	p.getInventory().setItemInMainHand(csword);
        }else{
        	p.sendMessage(ChatColor.AQUA + "Spawning in a cSword...");
        	p.getInventory().addItem(csword);
        }
	}
	public static void givecGoldSword(Player p, Boolean hold){
	    ItemStack csword = new ItemStack(Material.SHIELD, 1, (short)5);
        ItemMeta meta = csword.getItemMeta();
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.setDisplayName("Classic Gold Sword");
        csword.setItemMeta(meta);
	    net.minecraft.server.v1_12_R1.ItemStack nmsStack = CraftItemStack.asNMSCopy(csword);
	    NBTTagCompound compound = (nmsStack.hasTag()) ? nmsStack.getTag() : new NBTTagCompound();
	    NBTTagList modifiers = new NBTTagList();
	    NBTTagCompound damage = new NBTTagCompound();
	    
	    
	    
	    damage.set("AttributeName", new NBTTagString("generic.attackDamage"));
	    damage.set("Name", new NBTTagString("generic.attackDamage"));
	    damage.set("Amount", new NBTTagInt(4));
	    damage.set("Operation", new NBTTagInt(0));
	    damage.set("UUIDLeast", new NBTTagInt(894654));
	    damage.set("UUIDMost", new NBTTagInt(2872));
	    damage.set("Slot", new NBTTagString("mainhand"));
	    
 NBTTagCompound atspeed = new NBTTagCompound();
	    
	    
	    
	    atspeed.set("AttributeName", new NBTTagString("generic.attackSpeed"));
	    atspeed.set("Name", new NBTTagString("generic.attackSpeed"));
	    atspeed.set("Amount", new NBTTagDouble(1021.6));
	    atspeed.set("Operation", new NBTTagInt(0));
	    atspeed.set("UUIDLeast", new NBTTagInt(894654));
	    atspeed.set("UUIDMost", new NBTTagInt(2872));
	    atspeed.set("Slot", new NBTTagString("mainhand"));
	    
	    modifiers.add(damage);
	    modifiers.add(atspeed);
	    compound.set("AttributeModifiers", modifiers);
	    nmsStack.setTag(compound);
	    csword = CraftItemStack.asBukkitCopy(nmsStack);
	    
	    
        
        
        if(hold){
        	p.getInventory().setItemInMainHand(csword);
        }else{
        	p.sendMessage(ChatColor.AQUA + "Spawning in a cSword...");
        	p.getInventory().addItem(csword);
        }
	}
}
