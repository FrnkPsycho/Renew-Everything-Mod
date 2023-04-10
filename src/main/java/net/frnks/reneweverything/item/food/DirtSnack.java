package net.frnks.reneweverything.item.food;


import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.HungerManager;
import net.minecraft.entity.player.PlayerEntity;
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
        if ( user.isPlayer() ) {
            PlayerEntity player = (PlayerEntity) user;
            HungerManager hungerManager = player.getHungerManager();
            if ( hungerManager.getFoodLevel() > 0 ) {
                hungerManager.setFoodLevel(hungerManager.getFoodLevel() - 1);
            }
            else if ( hungerManager.getFoodLevel() <= 0 ) {
                player.damage(player.getDamageSources().generic(), 1f);
                /*TODO make a custom damage sources*/
//                player.damage(ModDamageSources.dirtSnack, 1f);
//                player.damage(new DirtSnackDamageSource(world.getRegistryManager().get(RegistryKeys.DAMAGE_TYPE).entryOf(ModDamageTypes.DIRT_SNACK_DAMAGE)), 1f);
//                player.damage(ModDamageSources.DIRT_SNACK, 1f);
            }
        }
        /* TODO give player seed item based on the loot table or else. */
        return super.finishUsing(stack, world, user);
    }
}
