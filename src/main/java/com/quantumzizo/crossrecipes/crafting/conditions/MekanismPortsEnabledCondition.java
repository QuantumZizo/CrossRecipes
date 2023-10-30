package com.quantumzizo.crossrecipes.crafting.conditions;

import com.google.gson.JsonObject;
import com.quantumzizo.crossrecipes.Config;
import com.quantumzizo.crossrecipes.CrossRecipes;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class MekanismPortsEnabledCondition implements ICondition{
	private final ResourceLocation location;
	
	public MekanismPortsEnabledCondition(ResourceLocation location) {
		this.location = location;
	}
	
	@Override
	public ResourceLocation getID() {
		return this.location;
	}

	@Override
	public boolean test(IContext context) {
		return Config.ENABLE_MEKANISM_PORTS.get();
	}
	
	public static class Serializer implements IConditionSerializer<MekanismPortsEnabledCondition> {
		private final ResourceLocation location;
		
		public Serializer() {
			this.location = new ResourceLocation(CrossRecipes.MOD_ID, "mekanism_ports_enabled");
		}
		
		@Override
		public void write(JsonObject json, MekanismPortsEnabledCondition value) {
		}

		@Override
		public MekanismPortsEnabledCondition read(JsonObject json) {
			return new MekanismPortsEnabledCondition(this.location);
		}

		@Override
		public ResourceLocation getID() {
			return this.location;
		}
	}
}
