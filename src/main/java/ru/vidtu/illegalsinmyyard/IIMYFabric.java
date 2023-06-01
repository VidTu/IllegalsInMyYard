package ru.vidtu.illegalsinmyyard;

import net.fabricmc.api.ClientModInitializer;

/**
 * Main IllegalsInMyYard mod class for Fabric.
 *
 * @author VidTu
 */
public final class IIMYFabric implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		IIMY.LOGGER.info("Sometimes unpatching is better than patching...");
	}
}
