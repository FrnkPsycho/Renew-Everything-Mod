package net.frnks.reneweverything.data;

import net.frnks.reneweverything.RenewEverythingMod;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTagKeys {
    public static final TagKey<Item> SEED_SOURCE_FOODS = TagKey.of(RegistryKeys.ITEM, new Identifier(RenewEverythingMod.MOD_ID, "seed_source_foods"));
    public static final TagKey<Item> DIRT_SNACK_LOOTS = TagKey.of(RegistryKeys.ITEM, new Identifier(RenewEverythingMod.MOD_ID, "dirt_snack_loots"));
    public static final TagKey<Item> ROCK_SNACK_LOOTS = TagKey.of(RegistryKeys.ITEM, new Identifier(RenewEverythingMod.MOD_ID, "rock_snack_loots"));
    public static final TagKey<Item> NETHERRACK_SNACK_LOOTS = TagKey.of(RegistryKeys.ITEM, new Identifier(RenewEverythingMod.MOD_ID, "netherrack_snack_loots"));

}
