package net.frnks.reneweverything.entity.damage;

import net.frnks.reneweverything.RenewEverythingMod;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.registry.*;
import net.minecraft.util.Identifier;

public class ModDamageTypes implements DamageTypes {
    public static final RegistryKey<DamageType> DIRT_SNACK_DAMAGE = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier(RenewEverythingMod.MOD_ID, "dirt_snack"));

    public static void bootstrap(Registerable<DamageType> damageTypeRegisterable) {
        damageTypeRegisterable.register(DIRT_SNACK_DAMAGE, new DamageType("dirtSnack", 0f));
    }
    public static void load() {}

}
