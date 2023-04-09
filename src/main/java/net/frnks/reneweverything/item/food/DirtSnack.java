package net.frnks.reneweverything.item.food;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class DirtSnack extends Item {
    public DirtSnack(Settings settings) {
        super(settings);
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 10;
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        /* TODO
        *  give player seed item based on the loot table.
        * */
        return super.finishUsing(stack, world, user);
    }
}
