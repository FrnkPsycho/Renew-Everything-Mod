package net.frnks.reneweverything.loot;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.context.LootContextParameters;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.server.MinecraftServer;

public class ModLootGenerator {
    public static ItemStack generateLootFromLootTable(LootTable lootTable, MinecraftServer server) {
        LootContext.Builder builder = new LootContext.Builder(server.getOverworld());
        ObjectArrayList<ItemStack> itemStacks = lootTable.generateLoot(builder.build(LootContextTypes.EMPTY));
        if ( !itemStacks.isEmpty() ) {
            return itemStacks.get(0);
        }
        else return new ItemStack(Items.AIR);
    }
}
