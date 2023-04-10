package net.frnks.reneweverything.block;

import net.frnks.reneweverything.item.ModItems;
import net.minecraft.block.*;
import net.minecraft.item.ItemConvertible;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;

public class GoldCropBlock extends CropBlock {
//    private static final VoxelShape[] AGE_TO_SHAPE = new VoxelShape[]{
//            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D),
//            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 3.0D, 16.0D),
//            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D),
//            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 5.0D, 16.0D),
//            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D),
//            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 7.0D, 16.0D),
//            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D),
//            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 9.0D, 16.0D)
//    };

    public GoldCropBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.GOLD_SEEDS;
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return !world.isSkyVisible(pos) && (world.getBlockState(pos.down()).isOf(Blocks.GOLD_BLOCK) || world.getBlockState(pos.down()).isOf(Blocks.FARMLAND));
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        int i;
        int lightLevel = world.getBaseLightLevel(pos, 0);

        int speed = 6;
        // Speed up when light level belows or equals 7 which is hostile mobs' max spawn level.
        speed -= lightLevel <= 7 ? 2 : 0;
        if (world.getBlockState(pos.down()).isOf(Blocks.FARMLAND)) speed += 5;

        if ((i = this.getAge(state)) < this.getMaxAge() &&
                random.nextInt(speed) == 0) {
            world.setBlockState(pos, this.withAge(i + 1), Block.NOTIFY_LISTENERS);
        }
    }
}