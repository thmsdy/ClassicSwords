package com.fpghoti.classicswords.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import io.netty.util.internal.ConcurrentSet;
import net.minecraft.server.v1_13_R2.NBTTagCompound;

public class Storage {
	public static ConcurrentHashMap<String, Boolean> bools = new ConcurrentHashMap<>();
	public static HashMap<String, NBTTagCompound> damagetag = new HashMap<>();
	public static Set<Material> instabreaks = new HashSet<>();
	public static Set<Player> inInv = new HashSet<>();
	public static ConcurrentSet<Player> blockers = new ConcurrentSet<>();
	public static ConcurrentSet<Player> swingers = new ConcurrentSet<>();
	public static ConcurrentSet<Player> bswingers = new ConcurrentSet<>();
	public static Random random = new Random();
	public static Map<UUID, Long> regens = new HashMap<>();
	public static ConcurrentHashMap<Player, Player> recent = new ConcurrentHashMap<>();
	public static ConcurrentHashMap<Player, Double> recenthealth = new ConcurrentHashMap<>();
	public static ConcurrentSet<Player> kb = new ConcurrentSet<>();
	public static ConcurrentSet<Player> great = new ConcurrentSet<>();
	public static ConcurrentSet<Player> perfect = new ConcurrentSet<>();
}
