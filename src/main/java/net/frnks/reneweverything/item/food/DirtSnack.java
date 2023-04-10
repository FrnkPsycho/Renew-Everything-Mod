package net.frnks.reneweverything.item.food;


import com.mojang.brigadier.ParseResults;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.frnks.reneweverything.RenewEverythingMod;
import net.minecraft.data.server.loottable.LootTableProvider;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.entity.player.HungerManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootManager;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.context.LootContextParameters;
import net.minecraft.loot.context.LootContextType;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.command.CommandManager;
import net.minecraft.util.Identifier;
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

            MinecraftServer server = world.getServer();
            CommandManager commandManager = server.getCommandManager();
            LootManager lootManager = server.getLootManager();
            LootTable lootTable = lootManager.getTable(new Identifier(RenewEverythingMod.MOD_ID, "snacks/dirt_snack_loot"));
            LootContext.Builder builder = new LootContext.Builder(server.getOverworld())
                    .optionalParameter(LootContextParameters.THIS_ENTITY, player)
                    .parameter(LootContextParameters.ORIGIN, player.getPos());
            ObjectArrayList<ItemStack> itemStacks = lootTable.generateLoot(builder.build(LootContextTypes.CHEST));
            if ( !itemStacks.isEmpty() ) {
                ItemStack itemStack = itemStacks.get(0);
                player.giveItemStack(itemStack);
            }
//            world.getServer().getCommandManager().executeWithPrefix(world.getServer().getCommandSource().withEntity(player), "/loot "+player.getName());
//            commandManager.executeWithPrefix(server.getCommandSource().withEntity(player))
        }
        /* TODO give player seed item based on the loot table or else. */
        return super.finishUsing(stack, world, user);
    }
}
