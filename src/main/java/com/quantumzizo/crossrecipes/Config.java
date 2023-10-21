package com.quantumzizo.crossrecipes;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class Config {
	public static ForgeConfigSpec CONFIG;
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	
	public static final String CATEGORY_COMPATIBILITY = "compatibility";
	public static ForgeConfigSpec.BooleanValue ENABLE_CREATE_PORTS;
	
	static {
		BUILDER.comment("Enabling/disabling of compatible mods.").push(CATEGORY_COMPATIBILITY);
		ENABLE_CREATE_PORTS = BUILDER.comment("Allows recipes ported to Create to be loaded.")
				.define("enableCreatePorts", true);
		BUILDER.pop();
		
		CONFIG = BUILDER.build();
	}
}