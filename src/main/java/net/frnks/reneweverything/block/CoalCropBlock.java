package net.frnks.reneweverything.block;

import net.frnks.reneweverything.item.ModItems;
import net.minecraft.block.*;
import net.minecraft.item.ItemConvertible;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;

public class CoalCropBlock extends CropBlock {
    public static final IntProperty AGE = Properties.AGE_3;
    private static final VoxelShape[] AGE_TO_SHAPE = new VoxelShape[]{
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D),
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D),
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D),
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
    };

    public CoalCropBlock(Settings settings) {
        super(settings);
    }
    @Override
    public int getMaxAge() {
        return 3;
    }
    @Override
    public IntProperty getAgeProperty() {
        return AGE;
    }
    @Override
    public void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }
    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.COAL_SEEDS;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return AGE_TO_SHAPE[state.get(this.getAgeProperty())];
    }
    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return !world.isSkyVisible(pos) && world.getBlockState(pos.down()).isOf(Blocks.COAL_BLOCK);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        int i;
        int lightLevel = world.getBaseLightLevel(pos, 0);

        int speed = 4;
        // Speed up when light level belows or equals 7 which is hostile mobs' max spawn level.
        speed -= lightLevel <= 7 ? 2 : 0;

        if ((i = this.getAge(state)) < this.getMaxAge() &&
                random.nextInt(speed) == 0) {
            world.setBlockState(pos, this.withAge(i + 1), Block.NOTIFY_LISTENERS);
        }
    }
}