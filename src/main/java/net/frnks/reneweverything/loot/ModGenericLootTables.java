package net.frnks.reneweverything.loot;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.frnks.reneweverything.RenewEverythingMod;
import net.frnks.reneweverything.block.ModBlocks;
import net.frnks.reneweverything.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.Identifier;

import java.util.function.BiConsumer;

public class ModGenericLootTables extends SimpleFabricLootTableProvider {
    public ModGenericLootTables(FabricDataOutput output) {
        super(output, LootContextTypes.GENERIC);
    }
    @Override
    public void accept(BiConsumer<Identifier, LootTable.Builder> identifierBuilderBiConsumer) {
        identifierBuilderBiConsumer.accept(new Identifier(RenewEverythingMod.MOD_ID, "snacks/dirt_snack_loot"), LootTable.builder()
                .pool(LootPool.builder()
                        .with(ItemEntry.builder(Items.DEAD_BUSH).weight(5))
                        .with(ItemEntry.builder(Items.OAK_SAPLING).weight(100))
                        .with(ItemEntry.builder(Items.SPRUCE_SAPLING).weight(10))
                        .with(ItemEntry.builder(Items.BIRCH_SAPLING).weight(100))
                        .with(ItemEntry.builder(Items.ACACIA_SAPLING).weight(100))
                        .with(ItemEntry.builder(Items.JUNGLE_SAPLING).weight(10))
                        .with(ItemEntry.builder(Items.DARK_OAK_SAPLING).weight(10))
                                // TODO more drops from dirt snack
                )
        );
        identifierBuilderBiConsumer.accept(new Identifier(RenewEverythingMod.MOD_ID, "snacks/rock_snack_loot"), LootTable.builder()
                .pool(LootPool.builder()
                        .with(ItemEntry.builder(ModItems.COAL_SEEDS).weight(100))
                        .with(ItemEntry.builder(ModItems.IRON_SEEDS).weight(50))
                        .with(ItemEntry.builder(ModItems.COPPER_SEEDS).weight(50))
                        .with(ItemEntry.builder(ModItems.GOLD_SEEDS).weight(25))
                        .with(ItemEntry.builder(ModItems.DIAMOND_SEEDS).weight(5))
                        // TODO more drops from rock snack
                )
        );
        identifierBuilderBiConsumer.accept(new Identifier(RenewEverythingMod.MOD_ID, "snacks/geode_snack_loot"), LootTable.builder()
                .pool(LootPool.builder()
                        .with(ItemEntry.builder(Items.AMETHYST_SHARD).weight(100))
                        .with(ItemEntry.builder(Items.BUDDING_AMETHYST).weight(5))
                        .with(ItemEntry.builder(Items.AMETHYST_CLUSTER).weight(10))
                )
        );
        identifierBuilderBiConsumer.accept(new Identifier(RenewEverythingMod.MOD_ID, "snacks/netherrack_snack_loot"), LootTable.builder()
                .pool(LootPool.builder()
                        .with(ItemEntry.builder(Items.QUARTZ).weight(200))
                        .with(ItemEntry.builder(Items.NETHERITE_SCRAP).weight(10))
                        .with(ItemEntry.builder(ModItems.NETHERITE_SEEDS).weight(5))
                        .with(ItemEntry.builder(ModItems.QUARTZ_SEEDS).weight(50))
                )
        );
        identifierBuilderBiConsumer.accept(new Identifier(RenewEverythingMod.MOD_ID, "blocks/iron_crop_block"),
                OreCropDrops(ModBlocks.IRON_CROP_BLOCK, Items.IRON_NUGGET, ModItems.IRON_SEEDS,7, 1, 3));

        identifierBuilderBiConsumer.accept(new Identifier(RenewEverythingMod.MOD_ID, "blocks/copper_crop_block"),
                OreCropDrops(ModBlocks.COPPER_CROP_BLOCK, ModItems.COPPER_NUGGET, ModItems.COPPER_SEEDS, 7,2, 5));

        identifierBuilderBiConsumer.accept(new Identifier(RenewEverythingMod.MOD_ID, "blocks/gold_crop_block"),
                OreCropDrops(ModBlocks.GOLD_CROP_BLOCK, Items.GOLD_NUGGET, ModItems.GOLD_SEEDS, 7,1,3));

        identifierBuilderBiConsumer.accept(new Identifier(RenewEverythingMod.MOD_ID, "blocks/coal_crop_block"),
                OreCropDrops(ModBlocks.COAL_CROP_BLOCK, Items.COAL, ModItems.COAL_SEEDS,3, 1,2));

        identifierBuilderBiConsumer.accept(new Identifier(RenewEverythingMod.MOD_ID, "blocks/diamond_crop_block"),
                OreCropDrops(ModBlocks.DIAMOND_CROP_BLOCK, Items.DIAMOND, ModItems.DIAMOND_SEEDS, 7, 1, 2));

        identifierBuilderBiConsumer.accept(new Identifier(RenewEverythingMod.MOD_ID, "blocks/netherite_crop_block"),
                OreCropDrops(ModBlocks.NETHERITE_CROP_BLOCK, Items.NETHERITE_SCRAP, ModItems.NETHERITE_SEEDS,7, 1, 1));

        identifierBuilderBiConsumer.accept(new Identifier(RenewEverythingMod.MOD_ID, "blocks/quartz_crop_block"),
                OreCropDrops(ModBlocks.QUARTZ_CROP_BLOCK, Items.QUARTZ, ModItems.QUARTZ_SEEDS,7, 2, 4));

        identifierBuilderBiConsumer.accept(new Identifier(RenewEverythingMod.MOD_ID, "blocks/emerald_crop_block"),
                OreCropDrops(ModBlocks.EMERALD_CROP_BLOCK, Items.EMERALD, ModItems.EMERALD_SEEDS,7, 1, 1));

        identifierBuilderBiConsumer.accept(new Identifier(RenewEverythingMod.MOD_ID, "blocks/lapis_lazuli_crop_block"),
                OreCropDrops(ModBlocks.LAPIS_LAZULI_CROP_BLOCK, Items.LAPIS_LAZULI, ModItems.LAPIS_LAZULI_SEEDS,7, 2, 4));

    }

    public LootTable.Builder OreCropDrops(Block crop, Item product, Item seeds, int maxAge,  float minProductDrop, float maxProductDrop) {
        LootCondition.Builder condition = BlockStatePropertyLootCondition.builder(crop)
                .properties(StatePredicate.Builder.create().exactMatch(IntProperty.of("age", 0, maxAge), maxAge));
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
