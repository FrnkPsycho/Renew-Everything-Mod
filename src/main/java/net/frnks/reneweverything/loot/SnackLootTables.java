package net.frnks.reneweverything.loot;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.frnks.reneweverything.RenewEverythingMod;
import net.frnks.reneweverything.item.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContextType;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.util.Identifier;

import java.util.function.BiConsumer;

public class SnackLootTables extends SimpleFabricLootTableProvider {
    public SnackLootTables(FabricDataOutput output) {
        super(output, LootContextTypes.GENERIC);
    }
    @Override
    public void accept(BiConsumer<Identifier, LootTable.Builder> identifierBuilderBiConsumer) {

    }
}
