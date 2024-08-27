package net.kyrushiqi.tutorialmod;

import net.fabricmc.api.ModInitializer;

import net.kyrushiqi.tutorialmod.item.ModItemGroups;
import net.kyrushiqi.tutorialmod.item.ModItems;
import org.slf4j.Logger; // interface -> the main user entry point of SLF4J API: https://www.slf4j.org
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorialmod"; // unique identifier for your mod, uppercase or spaces not allowed
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	/**
	 * This code runs as soon as Minecraft is in a mod-load-ready state.
	 * However, some things (like resources) may still be uninitialized.
	 * Proceed with mild caution.
	 */
	@Override
	public void onInitialize() {
		//LOGGER.info("Hello Fabric world!"); // Prints to console when game starts
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
	}
}