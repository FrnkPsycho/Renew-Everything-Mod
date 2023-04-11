package net.frnks.reneweverything.block;

import net.frnks.reneweverything.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.WorldView;

public class QuartzCropBlock extends CropBlock {

    public QuartzCropBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.QUARTZ_SEEDS;
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockState floor = world.getBlockState(pos.down());
        return !world.isSkyVisible(pos) && (floor.isOf(Blocks.NETHERRACK) || floor.isOf(Blocks.FARMLAND) || floor.isOf(Blocks.QUARTZ_BLOCK));
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        int i;
        int lightLevel = world.getBaseLightLevel(pos, 0);

        int speed = 5;
        // Speed up when light level belows or equals 7 which is hostile mobs' max spawn level.
        speed -= lightLevel <= 7 ? 2 : 0;
        if (world.getBlockState(pos.down()).isOf(Blocks.FARMLAND)) speed += 5;
        if (world.getBlockState(pos.down()).isOf(Blocks.QUARTZ_BLOCK)) speed -= 1;

        if ((i = this.getAge(state)) < this.getMaxAge() &&
                random.nextInt(speed) == 0) {
            world.setBlockState(pos, this.withAge(i + 1), Block.NOTIFY_LISTENERS);
        }
    }
}