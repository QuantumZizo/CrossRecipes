package com.quantumzizo.crossrecipes.crafting.conditions;

import com.google.gson.JsonObject;
import com.quantumzizo.crossrecipes.Config;
import com.quantumzizo.crossrecipes.CrossRecipes;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class InconsistentPortsEnabledCondition implements ICondition{
	private final ResourceLocation location;
	
	public InconsistentPortsEnabledCondition(ResourceLocation location) {
		this.location = location;
	}
	
	@Override
	public ResourceLocation getID() {
		return this.location;
	}

	@Override
	public boolean test(IContext context) {
		return Config.ENABLE_INCONSISTENT_PORTS.get();
	}
	
	public static class Serializer implements IConditionSerializer<InconsistentPortsEnabledCondition> {
		private final ResourceLocation location;
		
		public Serializer() {
			this.location = new ResourceLocation(CrossRecipes.MOD_ID, "inconsistent_ports_enabled");
		}
		
		@Override
		public void write(JsonObject json, InconsistentPortsEnabledCondition value) {
		}

		@Override
		public InconsistentPortsEnabledCondition read(JsonObject json) {
			return new InconsistentPortsEnabledCondition(this.location);
		}

		@Override
		public ResourceLocation getID() {
			return this.location;
		}
	}
}
