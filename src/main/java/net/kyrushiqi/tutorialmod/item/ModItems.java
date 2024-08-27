package net.kyrushiqi.tutorialmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.kyrushiqi.tutorialmod.TutorialMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

// A helper class -> Registers all of our new items, so mc knows we added items.
public class ModItems {
    public static final Item RUBY = registerItem("ruby", new Item(new FabricItemSettings())); // Adds an item to mc, but not in game yet
    // name follows MOD_ID rules: no uppercases, no spaces
    public static final Item RAW_RUBY = registerItem("raw_ruby", new Item(new FabricItemSettings())); // Adds a second item to mc

    // Adding item to Creative mode tab, adding it to an item group in the creative mode tabs
    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(RUBY);
        entries.add(RAW_RUBY);
    }

    /**
     * Simplifies the registering of items.
     * Method accepts an instance of an item and a String identifier/id.
     * Method creates an item with the provided parameters and register it with the game's item registry.
     * @param name
     * @param item
     * @return Item
     */
    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(TutorialMod.MOD_ID, name), item);
    }

    public static void registerModItems(){ // helper method
        TutorialMod.LOGGER.info("Registering Mod Items for " + TutorialMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }
}
