package com.fpghoti.classicswords.item;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import com.fpghoti.classicswords.util.Storage;

import net.minecraft.server.v1_12_R1.NBTTagCompound;

public class CItemType {

	public enum SwordType{
		WOOD,
		STONE,
		IRON,
		GOLD,
		DIAMOND
	}

	public static NBTTagCompound getSwordType(SwordType type) {
		switch (type) {
		case WOOD:
			return Storage.damagetag.get("wood");

		case STONE:
			return Storage.damagetag.get("stone");

		case IRON: 
			return Storage.damagetag.get("iron");
			
		case GOLD:
			return Storage.damagetag.get("gold");
			
		case DIAMOND:
			return Storage.damagetag.get("diamond");
			
		default:
			return null;
			
		}
	}
	
	public static short getSwordModel(SwordType type) {
		switch (type) {
		case WOOD:
			return (short)2;

		case STONE:
			return (short)3;

		case IRON: 
			return (short)4;
			
		case GOLD:
			return (short)5;
			
		case DIAMOND:
			return (short)1;
			
		default:
			return 2;
			
		}
	}
	
	
	public static short getSwordBlockModel(SwordType type) {
		switch (type) {
		case WOOD:
			return (short)7;

		case STONE:
			return (short)8;

		case IRON: 
			return (short)9;
			
		case GOLD:
			return (short)10;
			
		case DIAMOND:
			return (short)6;
			
		default:
			return 7;
			
		}
	}

	public static String getDefaultName(SwordType type) {
		switch (type) {
		case WOOD:
			return "Wooden Sword";

		case STONE:
			return "Stone Sword";

		case IRON: 
			return "Iron Sword";
			
		case GOLD:
			return "Golden Sword";
			
		case DIAMOND:
			return "Diamond Sword";
			
		default:
			return "ERROR";
			
		}
	}
	
	public static String getShortName(SwordType type) {
		switch (type) {
		case WOOD:
			return "wood";

		case STONE:
			return "stone";

		case IRON: 
			return "iron";
			
		case GOLD:
			return "gold";
			
		case DIAMOND:
			return "diamond";
			
		default:
			return "ERROR";
			
		}
	}
	
	public static Material getMaterial(SwordType type) {
		switch (type) {
		case WOOD:
			return Material.WOOD_SWORD;

		case STONE:
			return Material.STONE_SWORD;

		case IRON: 
			return Material.IRON_SWORD;
			
		case GOLD:
			return Material.GOLD_SWORD;
			
		case DIAMOND:
			return Material.DIAMOND_SWORD;
			
		default:
			return null;
			
		}
		
	}
	
	public static int getMaxDurability(SwordType type) {
		return getMaterial(type).getMaxDurability();
	}
	
	public static SwordType getSwordType(Material mat) {
		switch (mat) {
		case WOOD_SWORD:
			return SwordType.WOOD;

		case STONE_SWORD:
			return SwordType.STONE;

		case IRON_SWORD: 
			return SwordType.IRON;
			
		case GOLD_SWORD:
			return SwordType.GOLD;
			
		case DIAMOND_SWORD:
			return SwordType.DIAMOND;
			
		default:
			return null;
			
		}
		
	}
	
	
	
	public static Boolean isSword(Material mat) {
		return mat == Material.WOOD_SWORD || mat == Material.STONE_SWORD || mat == Material.IRON_SWORD || mat == Material.GOLD_SWORD || mat == Material.DIAMOND_SWORD;
	}
	
	
	public static SwordType getType(String shortname) {
		switch (shortname) {
		case "wood":
			return SwordType.WOOD;
			
		case "stone":
			return SwordType.STONE;
			
		case "iron":
			return SwordType.IRON;
			
		case "gold":
			return SwordType.GOLD;
			
		case "diamond":
			return SwordType.DIAMOND;
			
		default:
			return null;
		}
	}
}
