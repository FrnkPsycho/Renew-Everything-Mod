package net.frnks.reneweverything.block;

import net.frnks.reneweverything.item.ModItems;
import net.minecraft.block.*;
import net.minecraft.item.ItemConvertible;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;

public class IronCropBlock extends CropBlock {
    private static final VoxelShape[] AGE_TO_SHAPE = new VoxelShape[]{
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D),
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 3.0D, 16.0D),
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D),
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 5.0D, 16.0D),
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D),
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 7.0D, 16.0D),
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D),
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 9.0D, 16.0D)
    };

    public IronCropBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.IRON_SEEDS;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return AGE_TO_SHAPE[state.get(this.getAgeProperty())];
    }

//    @Override
//    public boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
//        return floor.isOf(Blocks.IRON_BLOCK) && ;
//    }

    //    @Override
//    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
//        int lightLevel = world.getBaseLightLevel(pos, 0);
//        System.out.println(pos + ": " + lightLevel);
//        return lightLevel < 10;
//    }
//    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return !world.isSkyVisible(pos) && world.getBlockState(pos.down()).isOf(Blocks.IRON_BLOCK);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        int i;
        BlockState floor = world.getBlockState(pos.down());
        int lightLevel = world.getBaseLightLevel(pos, 0);

        int speed = 1;
        if (floor.isOf(Blocks.IRON_BLOCK)) speed = 5;
//        else if (floor.isIn(BlockTags.STONE_ORE_REPLACEABLES)) speed = 3;

        // Speed up when light level belows or equals 7 which is hostile mobs' max spawn level.
        speed += lightLevel <= 7 ? 5 : 0;

        if ((i = this.getAge(state)) < this.getMaxAge() &&
                random.nextInt(25 / speed) == 0) {
            world.setBlockState(pos, this.withAge(i + 1), Block.NOTIFY_LISTENERS);
        }
    }
}