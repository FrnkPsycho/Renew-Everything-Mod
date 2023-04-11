package net.frnks.reneweverything.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.frnks.reneweverything.RenewEverythingMod;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block IRON_CROP_BLOCK = registerBlockWithoutItem("iron_crop_block", new IronCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT)));
    public static final Block COAL_CROP_BLOCK = registerBlockWithoutItem("coal_crop_block", new CoalCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT)));
    public static final Block GOLD_CROP_BLOCK = registerBlockWithoutItem("gold_crop_block", new GoldCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT)));
    public static final Block DIAMOND_CROP_BLOCK = registerBlockWithoutItem("diamond_crop_block", new DiamondCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT)));
    public static final Block NETHERITE_CROP_BLOCK = registerBlockWithoutItem("netherite_crop_block", new NetheriteCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT)));
    public static final Block COPPER_CROP_BLOCK = registerBlockWithoutItem("copper_crop_block", new CopperCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT)));
    public static final Block QUARTZ_CROP_BLOCK = registerBlockWithoutItem("quartz_crop_block", new QuartzCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT)));
    public static final Block EMERALD_CROP_BLOCK = registerBlockWithoutItem("emerald_crop_block", new EmeraldCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT)));
    public static final Block LAPIS_LAZULI_CROP_BLOCK = registerBlockWithoutItem("lapis_lazuli_crop_block", new LapisLazuliCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT)));

    public static Block registerBlock(String name, Block block, ItemGroup itemGroup) {
        registerBlockItem(name, block, itemGroup);
        return Registry.register(Registries.BLOCK, new Identifier(RenewEverythingMod.MOD_ID, name), block);
    }
    public static Block registerBlockWithoutItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(RenewEverythingMod.MOD_ID, name), block);
    }

    public static Item registerBlockItem(String name, Block block, ItemGroup group) {
        Item item = Registry.register(Registries.ITEM, new Identifier(RenewEverythingMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
        return item;
    }

    public static void load() {}
}

