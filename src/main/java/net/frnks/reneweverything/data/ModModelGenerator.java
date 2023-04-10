package net.frnks.reneweverything.data;

import com.ibm.icu.text.Normalizer2;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.frnks.reneweverything.block.ModBlocks;
import net.frnks.reneweverything.item.ModItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;

public class ModModelGenerator extends FabricModelProvider {
    public ModModelGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerCrop(ModBlocks.COAL_CROP_BLOCK, Properties.AGE_3, 0, 1, 2, 3);
        blockStateModelGenerator.registerCrop(ModBlocks.IRON_CROP_BLOCK, Properties.AGE_7, 0, 1, 2, 3, 4, 5, 6, 7);
        blockStateModelGenerator.registerCrop(ModBlocks.GOLD_CROP_BLOCK, Properties.AGE_7, 0, 1, 2, 3, 4, 5, 6, 7);
        blockStateModelGenerator.registerCrop(ModBlocks.DIAMOND_CROP_BLOCK, Properties.AGE_7, 0, 1, 2, 3, 4, 5, 6, 7);
        blockStateModelGenerator.registerCrop(ModBlocks.NETHERITE_CROP_BLOCK, Properties.AGE_7, 0, 1, 2, 3, 4, 5, 6, 7);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.DIRT_SNACK, Models.GENERATED);
        itemModelGenerator.register(ModItems.ROCK_SNACK, Models.GENERATED);
//        itemModelGenerator.register(ModItems.IRON_SEEDS, Models.GENERATED);

    }
}
