package net.frnks.reneweverything.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.frnks.reneweverything.RenewEverythingMod;
import net.frnks.reneweverything.item.food.DirtSnack;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item DIRT_SNACK = register("dirt_snack", new DirtSnack(new FabricItemSettings().food(ModFoodComponents.DIRT_SNACK)), RenewEverythingMod.ITEM_GROUP);
    public static Item register(String name, Item item, ItemGroup itemGroup) {
        Item registeredItem = Registry.register(Registries.ITEM, new Identifier(RenewEverythingMod.MOD_ID, name), item);
        ItemGroupEvents.modifyEntriesEvent(itemGroup).register(content -> content.add(registeredItem));
        return registeredItem;
    }
    public static void load() {}
}
