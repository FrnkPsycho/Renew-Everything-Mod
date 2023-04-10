package net.frnks.reneweverything.item.food;


import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.HungerManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class RockSnack extends Item {
    public RockSnack(Settings settings) {
        super(settings);
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 20;
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if ( user.isPlayer() ) {
            PlayerEntity player = (PlayerEntity) user;
            HungerManager hungerManager = player.getHungerManager();
            hungerManager.setFoodLevel(hungerManager.getFoodLevel() - 1);
            player.damage(player.getDamageSources().generic(), 1f);
            /*TODO make a custom damage sources*/
        }

        /* TODO give player seed item based on the loot table or else. */
        return super.finishUsing(stack, world, user);
    }
}
