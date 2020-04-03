package com.fpghoti.classicswords.item;

import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_15_R1.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_15_R1.NBTTagCompound;
import net.minecraft.server.v1_15_R1.NBTTagList;

public class CItemManager {

	public static void givecDiamondSword(Player p, Boolean hold){
		ItemStack csword = new ItemStack(Material.SHIELD, 1);
		ItemMeta meta = csword.getItemMeta();
		((Damageable)meta).setDamage(1);
		meta.setUnbreakable(true);
		meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		meta.setDisplayName("Classic Diamond Sword");
		csword.setItemMeta(meta);
		net.minecraft.server.v1_15_R1.ItemStack nmsStack = CraftItemStack.asNMSCopy(csword);
		NBTTagCompound compound = (nmsStack.hasTag()) ? nmsStack.getTag() : new NBTTagCompound();
		NBTTagList modifiers = new NBTTagList();
		NBTTagCompound damage = new NBTTagCompound();



		damage.set("AttributeName", SetAttributes.nbtString("generic.attackDamage"));
		damage.set("Name", SetAttributes.nbtString("generic.attackDamage"));
		damage.set("Amount", SetAttributes.nbtInt(7));
		damage.set("Operation", SetAttributes.nbtInt(0));
		damage.set("UUIDLeast", SetAttributes.nbtInt(894654));
		damage.set("UUIDMost", SetAttributes.nbtInt(2872));
		damage.set("Slot", SetAttributes.nbtString("mainhand"));

		NBTTagCompound atspeed = new NBTTagCompound();



		atspeed.set("AttributeName", SetAttributes.nbtString("generic.attackSpeed"));
		atspeed.set("Name", SetAttributes.nbtString("generic.attackSpeed"));
		atspeed.set("Amount", SetAttributes.nbtDouble(1021.6));
		atspeed.set("Operation", SetAttributes.nbtInt(0));
		atspeed.set("UUIDLeast", SetAttributes.nbtInt(894654));
		atspeed.set("UUIDMost", SetAttributes.nbtInt(2872));
		atspeed.set("Slot", SetAttributes.nbtString("mainhand"));

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
		ItemStack csword = new ItemStack(Material.SHIELD, 1);
		ItemMeta meta = csword.getItemMeta();
		((Damageable)meta).setDamage(2);
		meta.setUnbreakable(true);
		meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		meta.setDisplayName("Classic Wood Sword");
		csword.setItemMeta(meta);
		net.minecraft.server.v1_15_R1.ItemStack nmsStack = CraftItemStack.asNMSCopy(csword);
		NBTTagCompound compound = (nmsStack.hasTag()) ? nmsStack.getTag() : new NBTTagCompound();
		NBTTagList modifiers = new NBTTagList();
		NBTTagCompound damage = new NBTTagCompound();



		damage.set("AttributeName", SetAttributes.nbtString("generic.attackDamage"));
		damage.set("Name", SetAttributes.nbtString("generic.attackDamage"));
		damage.set("Amount", SetAttributes.nbtInt(4));
		damage.set("Operation", SetAttributes.nbtInt(0));
		damage.set("UUIDLeast", SetAttributes.nbtInt(894654));
		damage.set("UUIDMost", SetAttributes.nbtInt(2872));
		damage.set("Slot", SetAttributes.nbtString("mainhand"));

		NBTTagCompound atspeed = new NBTTagCompound();



		atspeed.set("AttributeName", SetAttributes.nbtString("generic.attackSpeed"));
		atspeed.set("Name", SetAttributes.nbtString("generic.attackSpeed"));
		atspeed.set("Amount", SetAttributes.nbtDouble(1021.6));
		atspeed.set("Operation", SetAttributes.nbtInt(0));
		atspeed.set("UUIDLeast", SetAttributes.nbtInt(894654));
		atspeed.set("UUIDMost", SetAttributes.nbtInt(2872));
		atspeed.set("Slot", SetAttributes.nbtString("mainhand"));

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
		ItemStack csword = new ItemStack(Material.SHIELD, 1);
		ItemMeta meta = csword.getItemMeta();
		((Damageable)meta).setDamage(3);
		meta.setUnbreakable(true);
		meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		meta.setDisplayName("Classic Stone Sword");
		csword.setItemMeta(meta);
		net.minecraft.server.v1_15_R1.ItemStack nmsStack = CraftItemStack.asNMSCopy(csword);
		NBTTagCompound compound = (nmsStack.hasTag()) ? nmsStack.getTag() : new NBTTagCompound();
		NBTTagList modifiers = new NBTTagList();
		NBTTagCompound damage = new NBTTagCompound();



		damage.set("AttributeName", SetAttributes.nbtString("generic.attackDamage"));
		damage.set("Name", SetAttributes.nbtString("generic.attackDamage"));
		damage.set("Amount", SetAttributes.nbtInt(5));
		damage.set("Operation", SetAttributes.nbtInt(0));
		damage.set("UUIDLeast", SetAttributes.nbtInt(894654));
		damage.set("UUIDMost", SetAttributes.nbtInt(2872));
		damage.set("Slot", SetAttributes.nbtString("mainhand"));

		NBTTagCompound atspeed = new NBTTagCompound();



		atspeed.set("AttributeName", SetAttributes.nbtString("generic.attackSpeed"));
		atspeed.set("Name", SetAttributes.nbtString("generic.attackSpeed"));
		atspeed.set("Amount", SetAttributes.nbtDouble(1021.6));
		atspeed.set("Operation", SetAttributes.nbtInt(0));
		atspeed.set("UUIDLeast", SetAttributes.nbtInt(894654));
		atspeed.set("UUIDMost", SetAttributes.nbtInt(2872));
		atspeed.set("Slot", SetAttributes.nbtString("mainhand"));

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
		ItemStack csword = new ItemStack(Material.SHIELD, 1);
		ItemMeta meta = csword.getItemMeta();
		((Damageable)meta).setDamage(4);
		meta.setUnbreakable(true);
		meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		meta.setDisplayName("Classic Iron Sword");
		csword.setItemMeta(meta);
		net.minecraft.server.v1_15_R1.ItemStack nmsStack = CraftItemStack.asNMSCopy(csword);
		NBTTagCompound compound = (nmsStack.hasTag()) ? nmsStack.getTag() : new NBTTagCompound();
		NBTTagList modifiers = new NBTTagList();
		NBTTagCompound damage = new NBTTagCompound();



		damage.set("AttributeName", SetAttributes.nbtString("generic.attackDamage"));
		damage.set("Name", SetAttributes.nbtString("generic.attackDamage"));
		damage.set("Amount", SetAttributes.nbtInt(6));
		damage.set("Operation", SetAttributes.nbtInt(0));
		damage.set("UUIDLeast", SetAttributes.nbtInt(894654));
		damage.set("UUIDMost", SetAttributes.nbtInt(2872));
		damage.set("Slot", SetAttributes.nbtString("mainhand"));

		NBTTagCompound atspeed = new NBTTagCompound();



		atspeed.set("AttributeName", SetAttributes.nbtString("generic.attackSpeed"));
		atspeed.set("Name", SetAttributes.nbtString("generic.attackSpeed"));
		atspeed.set("Amount", SetAttributes.nbtDouble(1021.6));
		atspeed.set("Operation", SetAttributes.nbtInt(0));
		atspeed.set("UUIDLeast", SetAttributes.nbtInt(894654));
		atspeed.set("UUIDMost", SetAttributes.nbtInt(2872));
		atspeed.set("Slot", SetAttributes.nbtString("mainhand"));

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
		ItemStack csword = new ItemStack(Material.SHIELD, 1);
		ItemMeta meta = csword.getItemMeta();
		((Damageable)meta).setDamage(5);
		meta.setUnbreakable(true);
		meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		meta.setDisplayName("Classic Gold Sword");
		csword.setItemMeta(meta);
		net.minecraft.server.v1_15_R1.ItemStack nmsStack = CraftItemStack.asNMSCopy(csword);
		NBTTagCompound compound = (nmsStack.hasTag()) ? nmsStack.getTag() : new NBTTagCompound();
		NBTTagList modifiers = new NBTTagList();
		NBTTagCompound damage = new NBTTagCompound();



		damage.set("AttributeName", SetAttributes.nbtString("generic.attackDamage"));
		damage.set("Name", SetAttributes.nbtString("generic.attackDamage"));
		damage.set("Amount", SetAttributes.nbtInt(4));
		damage.set("Operation", SetAttributes.nbtInt(0));
		damage.set("UUIDLeast", SetAttributes.nbtInt(894654));
		damage.set("UUIDMost", SetAttributes.nbtInt(2872));
		damage.set("Slot", SetAttributes.nbtString("mainhand"));

		NBTTagCompound atspeed = new NBTTagCompound();



		atspeed.set("AttributeName", SetAttributes.nbtString("generic.attackSpeed"));
		atspeed.set("Name", SetAttributes.nbtString("generic.attackSpeed"));
		atspeed.set("Amount", SetAttributes.nbtDouble(1021.6));
		atspeed.set("Operation", SetAttributes.nbtInt(0));
		atspeed.set("UUIDLeast", SetAttributes.nbtInt(894654));
		atspeed.set("UUIDMost", SetAttributes.nbtInt(2872));
		atspeed.set("Slot", SetAttributes.nbtString("mainhand"));

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
