package net.frnks.reneweverything;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.frnks.reneweverything.item.ModItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RenewEverythingMod implements ModInitializer {
	public static final String MOD_ID = "reneweverything";
	public static final Logger LOGGER = LoggerFactory.getLogger("reneweverything");
	public static final ItemGroup ITEM_GROUP = FabricItemGroup.builder(
			new Identifier(MOD_ID, "item_group"))
			.icon(() -> new ItemStack(ModItems.DIRT_SNACK))
			.build();

	@Override
	public void onInitialize() {
		ModItems.load();

		LOGGER.info("Hello Fabric world!");
	}
}
