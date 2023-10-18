package com.quantumzizo.crossrecipes;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(CrossRecipes.MOD_ID)
public class CrossRecipes {
	public static final String MOD_ID = "crossrecipes";
	
	private static final Logger LOGGER = LogUtils.getLogger();
	
	public CrossRecipes() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		
		MinecraftForge.EVENT_BUS.register(this);
		modEventBus.addListener(this::commonSetup);
	}
	
	private void commonSetup(final FMLCommonSetupEvent event) {
		LOGGER.info("Yall thankful I was the one making these recipes.");
	}
}
