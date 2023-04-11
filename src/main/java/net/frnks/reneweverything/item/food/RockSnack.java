package net.frnks.reneweverything.item.food;


import net.frnks.reneweverything.RenewEverythingMod;
import net.frnks.reneweverything.loot.ModLootGenerator;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.HungerManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootManager;
import net.minecraft.loot.LootTable;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.command.CommandManager;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class RockSnack extends Item {
    public RockSnack(Settings settings) {
        super(settings);
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 5;
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
            }

            if ( !world.isClient ) {
                MinecraftServer server = world.getServer();
                CommandManager commandManager = server.getCommandManager();
                LootManager lootManager = server.getLootManager();
                LootTable lootTable = lootManager.getTable(new Identifier(RenewEverythingMod.MOD_ID, "snacks/rock_snack_loot"));
                ItemStack itemStack = ModLootGenerator.generateLootFromLootTable(lootTable, server);
                player.giveItemStack(itemStack);
            }

        }
        /* TODO give player seed item based on the loot table or else. */
        return super.finishUsing(stack, world, user);
    }
}
