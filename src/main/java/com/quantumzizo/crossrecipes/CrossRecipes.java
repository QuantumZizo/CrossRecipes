package com.quantumzizo.crossrecipes;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;
import com.quantumzizo.crossrecipes.crafting.conditions.CreatePortsEnabledCondition;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig.Type;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(CrossRecipes.MOD_ID)
public class CrossRecipes {
	public static final String MOD_ID = "crossrecipes";
	
	private static final Logger LOGGER = LogUtils.getLogger();
	
	public CrossRecipes() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		
		ModLoadingContext.get().registerConfig(Type.COMMON, Config.CONFIG, "crossrecipes.toml");
		
		MinecraftForge.EVENT_BUS.register(this);
		
		modEventBus.addListener(this::commonSetup);
	}
	
	private void commonSetup(final FMLCommonSetupEvent event) {
		CraftingHelper.register(new CreatePortsEnabledCondition.Serializer());
		
		LOGGER.info("Yall thankful I was the one making these recipes.");
	}
}
