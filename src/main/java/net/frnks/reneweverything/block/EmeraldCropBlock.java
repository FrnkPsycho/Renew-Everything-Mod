package net.frnks.reneweverything.block;

import net.frnks.reneweverything.data.GrowSpeedConstants;
import net.frnks.reneweverything.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class EmeraldCropBlock extends CropBlock {
    public EmeraldCropBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.EMERALD_SEEDS;
    }


    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        // Can't grow with vanilla bonemeal
        return false;
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockState floor = world.getBlockState(pos.down());
        return !world.isSkyVisible(pos) && (floor.isOf(Blocks.EMERALD_BLOCK) || floor.isOf(Blocks.FARMLAND));
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if ( world.isClient && hand == Hand.MAIN_HAND) {
            ItemStack handItem = player.getHandItems().iterator().next();
            // TODO make a custom bonemeal-like item/itemtag to grow it
        }
        return ActionResult.FAIL;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        int i;
        int lightLevel = world.getBaseLightLevel(pos, 0);

        int speed = GrowSpeedConstants.SLOW;
        // Speed up when light level belows or equals 7 which is hostile mobs' max spawn level.
        speed -= lightLevel <= 7 ? 2 : 0;
        if (world.getBlockState(pos.down()).isOf(Blocks.FARMLAND)) speed += 5;

        if ((i = this.getAge(state)) < this.getMaxAge() &&
                random.nextInt(speed) == 0) {
            world.setBlockState(pos, this.withAge(i + 1), Block.NOTIFY_LISTENERS);
        }
    }
}