package com.quantumzizo.crossrecipes;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class Config {
	public static ForgeConfigSpec CONFIG;
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	
	public static final String CATEGORY_BALANCING = "balancing";
	public static ForgeConfigSpec.BooleanValue ENABLE_INCONSISTENT_PORTS;
	
	public static final String CATEGORY_COMPATIBILITY = "compatibility";
	public static ForgeConfigSpec.BooleanValue ENABLE_CREATE_PORTS;
	public static ForgeConfigSpec.BooleanValue ENABLE_MEKANISM_PORTS;
	
	static {
		BUILDER.comment("Settings that impact the balancing of the recipes ported.").push(CATEGORY_BALANCING);
		ENABLE_INCONSISTENT_PORTS = BUILDER.comment("Allows ported recipes that aren't exactly the same as the original to be loaded. "
				+ "E.g. A recipe that has a chance factor being stripped of that randomization in the porting process, "
				+ "or a ported recipe using a different machine because there are no replicas of the original in the mod its ported to.")
				.define("enableInconsistentPorts", true);
		BUILDER.pop();
		
		BUILDER.comment("Enabling/disabling of compatible mods.").push(CATEGORY_COMPATIBILITY);
		ENABLE_CREATE_PORTS = BUILDER.comment("Allows recipes ported to Create to be loaded.")
				.define("enableCreatePorts", true);
		ENABLE_MEKANISM_PORTS = BUILDER.comment("Allows recipes ported to Mekanism to be loaded.")
				.define("enableMekanismPorts", true);
		BUILDER.pop();
		
		CONFIG = BUILDER.build();
	}
}