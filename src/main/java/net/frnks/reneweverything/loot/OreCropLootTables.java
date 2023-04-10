package net.frnks.reneweverything.loot;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.frnks.reneweverything.RenewEverythingMod;
import net.frnks.reneweverything.block.ModBlocks;
import net.frnks.reneweverything.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.context.LootContextType;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.Identifier;

import java.util.function.BiConsumer;

public class OreCropLootTables extends SimpleFabricLootTableProvider {
    public OreCropLootTables(FabricDataOutput output) {
        super(output, LootContextTypes.GENERIC);
    }
    @Override
    public void accept(BiConsumer<Identifier, LootTable.Builder> identifierBuilderBiConsumer) {
        identifierBuilderBiConsumer.accept(new Identifier(RenewEverythingMod.MOD_ID, "snacks/dirt_snack_loot"), LootTable.builder()
                .pool(LootPool.builder()
                        .with(ItemEntry.builder(Items.DEAD_BUSH).weight(1))
                        .with(ItemEntry.builder(Items.OAK_SAPLING).weight(10))
                        .with(ItemEntry.builder(Items.SPRUCE_SAPLING).weight(2))
                        .with(ItemEntry.builder(Items.BIRCH_SAPLING).weight(10))
                        .with(ItemEntry.builder(Items.ACACIA_SAPLING).weight(10))
                        .with(ItemEntry.builder(Items.JUNGLE_SAPLING).weight(2))
                        .with(ItemEntry.builder(Items.DARK_OAK_SAPLING).weight(2))
                                // TODO more drops from dirt snack
                )
        );
        identifierBuilderBiConsumer.accept(new Identifier(RenewEverythingMod.MOD_ID, "crops/iron_crop_loot"),
                OreCropDrops(ModBlocks.IRON_CROP_BLOCK, Items.IRON_NUGGET, ModItems.IRON_SEEDS, 1, 3));

        identifierBuilderBiConsumer.accept(new Identifier(RenewEverythingMod.MOD_ID, "crops/gold_crop_loot"),
                OreCropDrops(ModBlocks.GOLD_CROP_BLOCK, Items.GOLD_NUGGET, ModItems.GOLD_SEEDS, 1,3));

        identifierBuilderBiConsumer.accept(new Identifier(RenewEverythingMod.MOD_ID, "crops/coal_crop_loot"),
                OreCropDrops(ModBlocks.COAL_CROP_BLOCK, Items.COAL, ModItems.COAL_SEEDS, 1,2));

        identifierBuilderBiConsumer.accept(new Identifier(RenewEverythingMod.MOD_ID, "crops/diamond_crop_loot"),
                OreCropDrops(ModBlocks.DIAMOND_CROP_BLOCK, Items.DIAMOND, ModItems.DIAMOND_SEEDS, 1, 2));

        identifierBuilderBiConsumer.accept(new Identifier(RenewEverythingMod.MOD_ID, "crops/netherite_crop_loot"),
                OreCropDrops(ModBlocks.NETHERITE_CROP_BLOCK, Items.NETHERITE_SCRAP, ModItems.NETHERITE_SEEDS, 1, 1));
    }

    public LootTable.Builder OreCropDrops(Block crop, Item product, Item seeds, float minProductDrop, float maxProductDrop) {
        LootCondition.Builder condition = BlockStatePropertyLootCondition.builder(crop)
                .properties(StatePredicate.Builder.create().exactMatch(IntProperty.of("age", 0, 7), 7));
        return LootTable.builder()
                .pool(LootPool.builder()
                        .with((ItemEntry.builder(product)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minProductDrop, maxProductDrop)))
                                .conditionally(condition))
                                .alternatively(ItemEntry.builder(seeds))))
                .pool(LootPool.builder()
                        .conditionally(condition)
                        .with(ItemEntry.builder(seeds)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 3)))
                                .apply(ApplyBonusLootFunction.binomialWithBonusCount(Enchantments.FORTUNE, 0.5714286f, 3))));

    }
}
