package net.frnks.reneweverything;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RenewEverythingMod implements ModInitializer {
	public static final String MOD_ID = "reneweverything";
	public static final Logger LOGGER = LoggerFactory.getLogger("reneweverything");

	@Override
	public void onInitialize() {

		LOGGER.info("Hello Fabric world!");
	}
}
