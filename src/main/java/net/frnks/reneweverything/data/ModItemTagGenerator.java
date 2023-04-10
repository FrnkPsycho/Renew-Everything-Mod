package net.frnks.reneweverything.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.frnks.reneweverything.item.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.*;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends FabricTagProvider<Item> {
    public ModItemTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, RegistryKeys.ITEM, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ModTagKeys.SEED_SOURCE_FOODS)
                .add(ModItems.DIRT_SNACK)
                .add(ModItems.ROCK_SNACK);
        getOrCreateTagBuilder(ModTagKeys.DIRT_SNACK_LOOTS)
                .add(Items.DEAD_BUSH)
                .addOptionalTag(ItemTags.SAPLINGS);
        // TODO more dirt snack loots
        getOrCreateTagBuilder(ModTagKeys.ROCK_SNACK_LOOTS)
                .add(ModItems.COAL_SEEDS)
                .add(ModItems.IRON_SEEDS)
                .add(ModItems.GOLD_SEEDS)
                .add(ModItems.DIAMOND_SEEDS);
        getOrCreateTagBuilder(ModTagKeys.NETHERRACK_SNACK_LOOTS)
                .add(ModItems.NETHERITE_SEEDS);
    }
}
