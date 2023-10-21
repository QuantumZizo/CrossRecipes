package com.quantumzizo.crossrecipes.crafting.conditions;

import com.google.gson.JsonObject;
import com.quantumzizo.crossrecipes.Config;
import com.quantumzizo.crossrecipes.CrossRecipes;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class CreatePortsEnabledCondition implements ICondition{
	private final ResourceLocation location;
	
	public CreatePortsEnabledCondition(ResourceLocation location) {
		this.location = location;
	}
	
	@Override
	public ResourceLocation getID() {
		return this.location;
	}

	@Override
	public boolean test(IContext context) {
		return Config.ENABLE_CREATE_PORTS.get();
	}
	
	public static class Serializer implements IConditionSerializer<CreatePortsEnabledCondition> {
		private final ResourceLocation location;
		
		public Serializer() {
			this.location = new ResourceLocation(CrossRecipes.MOD_ID, "create_ports_enabled");
		}
		
		@Override
		public void write(JsonObject json, CreatePortsEnabledCondition value) {
		}

		@Override
		public CreatePortsEnabledCondition read(JsonObject json) {
			return new CreatePortsEnabledCondition(this.location);
		}

		@Override
		public ResourceLocation getID() {
			return this.location;
		}
	}
}
