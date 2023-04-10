package net.frnks.reneweverything.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLootTableProvider;
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
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.state.property.IntProperty;

public class ModLootTableGenerator extends FabricBlockLootTableProvider {
    public ModLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.IRON_CROP_BLOCK, CustomCropDrops(ModBlocks.IRON_CROP_BLOCK, Items.IRON_NUGGET, ModItems.IRON_SEEDS,
                1, 2,
                BlockStatePropertyLootCondition.builder(ModBlocks.IRON_CROP_BLOCK)
                        .properties(StatePredicate.Builder.create()
                                .exactMatch(IntProperty.of("age", 0, 7), 7))));
    }

    public LootTable.Builder CustomCropDrops(Block crop, Item product, Item seeds, float minProductDrop, float maxProductDrop, LootCondition.Builder condition) {
        return this.applyExplosionDecay(crop, LootTable.builder()
                .pool(LootPool.builder()
                        .with((ItemEntry.builder(product)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minProductDrop, maxProductDrop)))
                                .conditionally(condition))
                                .alternatively(ItemEntry.builder(seeds))))
                .pool(LootPool.builder()
                        .conditionally(condition)
                        .with(ItemEntry.builder(seeds)
                                .apply(ApplyBonusLootFunction.binomialWithBonusCount(Enchantments.FORTUNE, 0.5714286f, 3)))));

    }
}
