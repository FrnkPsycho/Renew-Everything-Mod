package net.frnks.reneweverything.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.frnks.reneweverything.RenewEverythingMod;
import net.frnks.reneweverything.block.ModBlocks;
import net.frnks.reneweverything.item.food.DirtSnack;
import net.frnks.reneweverything.item.food.GeodeSnack;
import net.frnks.reneweverything.item.food.NetherrackSnack;
import net.frnks.reneweverything.item.food.RockSnack;
import net.frnks.reneweverything.item.ingredient.CopperNugget;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item COPPER_NUGGET = register("copper_nugget", new CopperNugget(new FabricItemSettings()), RenewEverythingMod.ITEM_GROUP);
    public static final Item DIRT_SNACK = register("dirt_snack", new DirtSnack(new FabricItemSettings().food(ModFoodComponents.DIRT_SNACK)), RenewEverythingMod.ITEM_GROUP);
    public static final Item ROCK_SNACK = register("rock_snack", new RockSnack(new FabricItemSettings().food(ModFoodComponents.ROCK_SNACK)), RenewEverythingMod.ITEM_GROUP);
    public static final Item GEODE_SNACK = register("geode_snack", new GeodeSnack(new FabricItemSettings().food(ModFoodComponents.ROCK_SNACK)), RenewEverythingMod.ITEM_GROUP);
    public static final Item NETHERRACK_SNACK = register("netherrack_snack", new NetherrackSnack(new FabricItemSettings().food(ModFoodComponents.ROCK_SNACK)), RenewEverythingMod.ITEM_GROUP);
    public static final Item COAL_SEEDS = register("coal_seeds", new AliasedBlockItem(ModBlocks.COAL_CROP_BLOCK, new FabricItemSettings()), RenewEverythingMod.ITEM_GROUP);
    public static final Item IRON_SEEDS = register("iron_seeds", new AliasedBlockItem(ModBlocks.IRON_CROP_BLOCK, new FabricItemSettings()), RenewEverythingMod.ITEM_GROUP);
    public static final Item COPPER_SEEDS = register("copper_seeds", new AliasedBlockItem(ModBlocks.COPPER_CROP_BLOCK, new FabricItemSettings()), RenewEverythingMod.ITEM_GROUP);
    public static final Item GOLD_SEEDS = register("gold_seeds", new AliasedBlockItem(ModBlocks.GOLD_CROP_BLOCK, new FabricItemSettings()), RenewEverythingMod.ITEM_GROUP);
    public static final Item EMERALD_SEEDS = register("emerald_seeds", new AliasedBlockItem(ModBlocks.EMERALD_CROP_BLOCK, new FabricItemSettings()), RenewEverythingMod.ITEM_GROUP);
    public static final Item LAPIS_LAZULI_SEEDS = register("lapis_lazuli_seeds", new AliasedBlockItem(ModBlocks.LAPIS_LAZULI_CROP_BLOCK, new FabricItemSettings()), RenewEverythingMod.ITEM_GROUP);
    public static final Item DIAMOND_SEEDS = register("diamond_seeds", new AliasedBlockItem(ModBlocks.DIAMOND_CROP_BLOCK, new FabricItemSettings()), RenewEverythingMod.ITEM_GROUP);
    public static final Item QUARTZ_SEEDS = register("quartz_seeds", new AliasedBlockItem(ModBlocks.QUARTZ_CROP_BLOCK, new FabricItemSettings()), RenewEverythingMod.ITEM_GROUP);
    public static final Item NETHERITE_SEEDS = register("netherite_seeds", new AliasedBlockItem(ModBlocks.NETHERITE_CROP_BLOCK, new FabricItemSettings()), RenewEverythingMod.ITEM_GROUP);
    public static Item register(String name, Item item, ItemGroup itemGroup) {
        Item registeredItem = Registry.register(Registries.ITEM, new Identifier(RenewEverythingMod.MOD_ID, name), item);
        ItemGroupEvents.modifyEntriesEvent(itemGroup).register(content -> content.add(registeredItem));
        return registeredItem;
    }
    public static void load() {}
}
