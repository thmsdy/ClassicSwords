package com.fpghoti.classicswords.item;

import java.lang.reflect.Constructor;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_15_R1.inventory.CraftItemStack;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;

import com.fpghoti.classicswords.item.CItemType.SwordType;
import com.fpghoti.classicswords.util.Storage;

import net.minecraft.server.v1_15_R1.NBTTagCompound;
import net.minecraft.server.v1_15_R1.NBTTagList;

public class ClassicSword {

	public static ItemStack toShield(ItemStack old, SwordType type) {

		String name;

		ItemStack csword = new ItemStack(Material.SHIELD, 1);
		
		ItemMeta meta = csword.getItemMeta();
		((Damageable)meta).setDamage(CItemType.getSwordModel(type));
		
		if(old.hasItemMeta()) {
			ItemMeta ometa = old.getItemMeta();
			if(ometa.hasDisplayName()) {
				name = ometa.getDisplayName();
			}else {
				name = CItemType.getDefaultName(type);
			}

			if(ometa.hasLore()) {
				meta.setLore(ometa.getLore());
			}
		}else {
			name = CItemType.getDefaultName(type);
		}
		meta.setUnbreakable(true);
		meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		meta.setDisplayName(name);
		csword.setItemMeta(meta);
		net.minecraft.server.v1_15_R1.ItemStack nmsStack = CraftItemStack.asNMSCopy(csword);
		NBTTagCompound compound = (nmsStack.hasTag()) ? nmsStack.getTag() : new NBTTagCompound();
		NBTTagList modifiers = new NBTTagList();
		NBTTagCompound damage = CItemType.getSwordType(type);

		NBTTagCompound atspeed = new NBTTagCompound();

		atspeed.set("AttributeName", SetAttributes.nbtString("generic.attackSpeed"));
		atspeed.set("Name", SetAttributes.nbtString("generic.attackSpeed"));
		atspeed.set("Amount", SetAttributes.nbtDouble(1021.6));
		atspeed.set("Operation", SetAttributes.nbtInt(0));
		atspeed.set("UUIDLeast", SetAttributes.nbtInt(894654));
		atspeed.set("UUIDMost", SetAttributes.nbtInt(2872));
		atspeed.set("Slot", SetAttributes.nbtString("mainhand"));

		NBTTagCompound cstag = new NBTTagCompound();

		//int dur = old.getType().getMaxDurability() - old.getDurability();
		int dur = old.getType().getMaxDurability() - ((Damageable)old.getItemMeta()).getDamage();
		
		cstag.set("Durability", SetAttributes.nbtInt(dur));
		cstag.set("Type", SetAttributes.nbtString(CItemType.getShortName(type)));

		modifiers.add(damage);
		modifiers.add(atspeed);
		compound.set("AttributeModifiers", modifiers);
		compound.set("ClassicSwords", cstag);
		nmsStack.setTag(compound);
		csword = CraftItemStack.asBukkitCopy(nmsStack);
		if(old.getEnchantments() != null) {
			csword.addUnsafeEnchantments(old.getEnchantments());
		}

		return csword;
	}

	public static ItemStack toBlockShield(ItemStack old, SwordType type) {

		if(isCShield(old)) {
			String name;

			ItemStack csword = new ItemStack(Material.SHIELD, 1);

			ItemMeta meta = csword.getItemMeta();
			((Damageable)meta).setDamage(CItemType.getSwordBlockModel(type));
			
			if(old.hasItemMeta()) {
				ItemMeta ometa = old.getItemMeta();
				if(ometa.hasDisplayName()) {
					name = ometa.getDisplayName();
				}else {
					name = CItemType.getDefaultName(type);
				}

				if(ometa.hasLore()) {
					meta.setLore(ometa.getLore());
				}
			}else {
				name = CItemType.getDefaultName(type);
			}
			meta.setUnbreakable(true);
			meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
			meta.setDisplayName(name);
			csword.setItemMeta(meta);
			net.minecraft.server.v1_15_R1.ItemStack nmsStack = CraftItemStack.asNMSCopy(csword);
			NBTTagCompound compound = (nmsStack.hasTag()) ? nmsStack.getTag() : new NBTTagCompound();
			NBTTagList modifiers = new NBTTagList();
			NBTTagCompound damage = CItemType.getSwordType(type);

			NBTTagCompound atspeed = new NBTTagCompound();

			atspeed.set("AttributeName", SetAttributes.nbtString("generic.attackSpeed"));
			atspeed.set("Name", SetAttributes.nbtString("generic.attackSpeed"));
			atspeed.set("Amount", SetAttributes.nbtDouble(1021.6));
			atspeed.set("Operation", SetAttributes.nbtInt(0));
			atspeed.set("UUIDLeast", SetAttributes.nbtInt(894654));
			atspeed.set("UUIDMost", SetAttributes.nbtInt(2872));
			atspeed.set("Slot", SetAttributes.nbtString("mainhand"));

			NBTTagCompound cstag = new NBTTagCompound();

			int dur = getCShieldDurability(old);
			cstag.set("Durability", SetAttributes.nbtInt(dur));
			cstag.set("Type", SetAttributes.nbtString(CItemType.getShortName(type)));

			NBTTagCompound blocktag = new NBTTagCompound();
			blocktag.set("BlockHit", SetAttributes.nbtString("BlockHit"));

			modifiers.add(damage);
			modifiers.add(atspeed);
			compound.set("AttributeModifiers", modifiers);
			compound.set("ClassicSwords", cstag);
			compound.set("BlockHit", blocktag);
			nmsStack.setTag(compound);
			csword = CraftItemStack.asBukkitCopy(nmsStack);
			if(old.getEnchantments() != null) {
				csword.addUnsafeEnchantments(old.getEnchantments());
			}

			return csword;
		}else {
			return null;
		}

	}

	public static ItemStack blockToShield(ItemStack old, SwordType type) {

		if(isCBlockShield(old)) {

			String name;

			ItemStack csword = new ItemStack(Material.SHIELD, 1);

			ItemMeta meta = csword.getItemMeta();	
			((Damageable)meta).setDamage(CItemType.getSwordModel(type));
			
			if(old.hasItemMeta()) {
				ItemMeta ometa = old.getItemMeta();
				if(ometa.hasDisplayName()) {
					name = ometa.getDisplayName();
				}else {
					name = CItemType.getDefaultName(type);
				}

				if(ometa.hasLore()) {
					meta.setLore(ometa.getLore());
				}
			}else {
				name = CItemType.getDefaultName(type);
			}
			meta.setUnbreakable(true);
			meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
			meta.setDisplayName(name);
			csword.setItemMeta(meta);
			net.minecraft.server.v1_15_R1.ItemStack nmsStack = CraftItemStack.asNMSCopy(csword);
			NBTTagCompound compound = (nmsStack.hasTag()) ? nmsStack.getTag() : new NBTTagCompound();
			NBTTagList modifiers = new NBTTagList();
			NBTTagCompound damage = CItemType.getSwordType(type);

			NBTTagCompound atspeed = new NBTTagCompound();

			atspeed.set("AttributeName", SetAttributes.nbtString("generic.attackSpeed"));
			atspeed.set("Name", SetAttributes.nbtString("generic.attackSpeed"));
			atspeed.set("Amount", SetAttributes.nbtDouble(1021.6));
			atspeed.set("Operation", SetAttributes.nbtInt(0));
			atspeed.set("UUIDLeast", SetAttributes.nbtInt(894654));
			atspeed.set("UUIDMost", SetAttributes.nbtInt(2872));
			atspeed.set("Slot", SetAttributes.nbtString("mainhand"));

			NBTTagCompound cstag = new NBTTagCompound();

			int dur = getCShieldDurability(old);
			cstag.set("Durability", SetAttributes.nbtInt(dur));
			cstag.set("Type", SetAttributes.nbtString(CItemType.getShortName(type)));


			modifiers.add(damage);
			modifiers.add(atspeed);
			compound.set("AttributeModifiers", modifiers);
			compound.set("ClassicSwords", cstag);
			nmsStack.setTag(compound);
			csword = CraftItemStack.asBukkitCopy(nmsStack);
			if(old.getEnchantments() != null) {
				csword.addUnsafeEnchantments(old.getEnchantments());
			}

			return csword;
		}else {
			return null;
		}

	}

	public static ItemStack toSword(ItemStack old, SwordType type) {

		String name;

		ItemStack csword = new ItemStack(CItemType.getMaterial(type), 1);
		if(old.getEnchantments() != null) {
			csword.addUnsafeEnchantments(old.getEnchantments());
		}
		ItemMeta meta = csword.getItemMeta();
		if(old.hasItemMeta()) {
			ItemMeta ometa = old.getItemMeta();
			if(ometa.hasDisplayName()) {
				name = ometa.getDisplayName();
			}else {
				name = CItemType.getDefaultName(type);
			}

			if(ometa.hasLore()) {
				meta.setLore(ometa.getLore());
			}
		}else {
			name = CItemType.getDefaultName(type);
		}
		meta.setUnbreakable(false);
		meta.setDisplayName(name);
		csword.setItemMeta(meta);
		net.minecraft.server.v1_15_R1.ItemStack nmsStack = CraftItemStack.asNMSCopy(csword);
		NBTTagCompound compound = (nmsStack.hasTag()) ? nmsStack.getTag() : new NBTTagCompound();
		NBTTagList modifiers = new NBTTagList();
		NBTTagCompound damage = CItemType.getSwordType(type);

		NBTTagCompound atspeed = new NBTTagCompound();

		atspeed.set("AttributeName", SetAttributes.nbtString("generic.attackSpeed"));
		atspeed.set("Name", SetAttributes.nbtString("generic.attackSpeed"));
		atspeed.set("Amount", SetAttributes.nbtDouble(1021.6));
		atspeed.set("Operation", SetAttributes.nbtInt(0));
		atspeed.set("UUIDLeast", SetAttributes.nbtInt(894654));
		atspeed.set("UUIDMost", SetAttributes.nbtInt(2872));
		atspeed.set("Slot", SetAttributes.nbtString("mainhand"));

		NBTTagCompound cstag = new NBTTagCompound();


		modifiers.add(damage);
		modifiers.add(atspeed);
		compound.set("AttributeModifiers", modifiers);
		compound.set("ClassicSwords", cstag);
		nmsStack.setTag(compound);
		csword = CraftItemStack.asBukkitCopy(nmsStack);

		//csword.setDurability((short)(csword.getType().getMaxDurability() - (short)((int)getCShieldDurability(old))));
		((Damageable)csword.getItemMeta()).setDamage(csword.getType().getMaxDurability() - ((int)getCShieldDurability(old)));

		return csword;
	}

	public static Boolean isCShield(ItemStack item) {
		if(item == null) {
			return false;
		}
		if(item.getType() != Material.SHIELD) {
			return false;
		}
		net.minecraft.server.v1_15_R1.ItemStack nms = CraftItemStack.asNMSCopy(item);
		if(!nms.hasTag() || nms.getTag() == null) {
			return false;
		}
		if(nms.getTag().hasKey("ClassicSwords")) {
			return true;
		}else {
			return false;
		}
	}

	public static Boolean isCBlockShield(ItemStack item) {
		net.minecraft.server.v1_15_R1.ItemStack nms = CraftItemStack.asNMSCopy(item);
		return nms.getTag() != null && isCShield(item) && nms.getTag().hasKey("ClassicSwords");
	}

	public static Boolean isBlocking(Player p) {
		return Storage.blockers.contains(p);
	}

	public static Boolean isCSword(ItemStack item) {
		if(!(item.getType() == Material.WOODEN_SWORD || item.getType() == Material.STONE_SWORD ||item.getType() == Material.IRON_SWORD || item.getType() == Material.GOLDEN_SWORD || item.getType() == Material.DIAMOND_SWORD)) {
			return false;
		}
		net.minecraft.server.v1_15_R1.ItemStack nms = CraftItemStack.asNMSCopy(item);
		if(!nms.hasTag() || nms.getTag() == null) {
			return false;
		}
		if(nms.getTag().hasKey("ClassicSwords")) {
			return true;
		}else {
			return false;
		}
	}

	public static Boolean isCItem(ItemStack item) {
		return isCSword(item) || isCShield(item);
	}

	public static Integer getCShieldDurability(ItemStack item) {
		if(!isCItem(item)) {
			return null;
		}else {
			NBTTagCompound cstag = getCSTag(item);
			int dur = cstag.getInt("Durability");
			return dur;
		}
	}

	public static String getCShieldShortName(ItemStack item) {
		if(!isCItem(item)) {
			return null;
		}else {
			NBTTagCompound cstag = getCSTag(item);
			String name = cstag.getString("Type");
			return name;
		}
	}

	public static void blockToShieldInv(Inventory inv) {
		for(int i = 0; i < inv.getSize()-1; i++){
			ItemStack item = inv.getItem(i);
			if(item != null && isCBlockShield(item)) {
				ItemStack newitem = blockToShield(item, CItemType.getType(getCShieldShortName(item)));
				inv.setItem(i, newitem);
			}
		}
	}

	public static void toShieldInv(Inventory inv) {
		for(int i = 0; i < inv.getSize()-1; i++){
			ItemStack item = inv.getItem(i);
			if(item != null && CItemType.isSword(item.getType())) {
				ItemStack newitem = toShield(item, CItemType.getSwordType(item.getType()));
				inv.setItem(i, newitem);
			}
		}
	}

	public static void toSwordInv(Inventory inv) {
		for(int i = 0; i < inv.getSize()-1; i++){
			ItemStack item = inv.getItem(i);
			if(isCShield(item)) {
				ItemStack newitem = toSword(item, CItemType.getType(getCShieldShortName(item)));
				inv.setItem(i, newitem);
			}
		}
	}

	public static Boolean hasOpenInv(Player p) {
		return Storage.inInv.contains(p);
	}

	



	public static void setCShieldDurability(Player p, ItemStack item, Integer dur) {
		if(isCItem(item)) {
			Boolean skip = false;
			if(item.containsEnchantment(Enchantment.DURABILITY)) {
				int level = item.getEnchantmentLevel(Enchantment.DURABILITY);
				int chance = (100/(level+1));
				int result = Storage.random.nextInt(101);
				skip = result > chance;
			}
			if(!skip) {
				NBTTagCompound cstag = getCSTag(item);
				cstag.set("Durability", SetAttributes.nbtInt(dur));
				p.getInventory().setItemInMainHand(updateCSTag(item, cstag));
			}
		}
	}

	public static NBTTagCompound getCSTag(ItemStack item) {
		if(!isCItem(item)) {
			return null;
		}else {
			net.minecraft.server.v1_15_R1.ItemStack nms = CraftItemStack.asNMSCopy(item);
			NBTTagCompound cstag = (NBTTagCompound) nms.getTag().get("ClassicSwords");
			return cstag;
		}
	}

	public static ItemStack updateCSTag(ItemStack item, NBTTagCompound tag) {
		if(isCItem(item)) {
			net.minecraft.server.v1_15_R1.ItemStack nms = CraftItemStack.asNMSCopy(item);
			nms.getTag().set("ClassicSwords", tag);
			return CraftItemStack.asBukkitCopy(nms);
		}else {
			return null;
		}
	}

	public static void breakHeldItem(Player p) {
		p.getInventory().setItemInMainHand(new ItemStack(Material.AIR));
		p.playSound(p.getLocation(), Sound.ENTITY_ITEM_BREAK, 10.0F, 1.0F);
	}

	public static void damageCItem(Player p, ItemStack item, int amount) {
		int dur = ClassicSword.getCShieldDurability(item);
		dur = dur - amount;
		if(dur <= 0) {
			sendActionbar(p, ChatColor.YELLOW + "Durability: 0");
			breakHeldItem(p);
		}else {
			if(isCItem(item)) {
				sendActionbar(p, ChatColor.YELLOW + "Durability: " + dur);
				setCShieldDurability(p, item, dur);
			}
		}
	}


	//BY KNOAPP ON SPIGOT

	public static void sendActionbar(Player player, String msg) {
		try {
			Constructor<?> constructor = getNMSClass("PacketPlayOutChat").getConstructor(getNMSClass("IChatBaseComponent"), getNMSClass("ChatMessageType"));

			Object icbc = getNMSClass("IChatBaseComponent").getDeclaredClasses()[0].getMethod("a", String.class).invoke(null, "{\"text\":\"" + msg + "\"}");
			Object packet = constructor.newInstance(icbc, getNMSClass("ChatMessageType").getEnumConstants()[2]);
			Object entityPlayer= player.getClass().getMethod("getHandle").invoke(player);
			Object playerConnection = entityPlayer.getClass().getField("playerConnection").get(entityPlayer);

			playerConnection.getClass().getMethod("sendPacket", getNMSClass("Packet")).invoke(playerConnection, packet);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Class<?> getNMSClass(String name) {
		try {
			return Class.forName("net.minecraft.server." + getVersion() + "." + name);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String getVersion() {
		return Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
	}

	//////////////////////////////////////////////////////////

}
