package net.frnks.reneweverything.entity.damage;

import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

public class ModDamageSources extends DamageSources {
    private final Registry<DamageType> registry;
    public static DirtSnackDamageSource dirtSnack = null;

    public ModDamageSources(DynamicRegistryManager registryManager) {
        super(registryManager);
        this.registry = registryManager.get(RegistryKeys.DAMAGE_TYPE);
        dirtSnack = (DirtSnackDamageSource) this.create(ModDamageTypes.DIRT_SNACK_DAMAGE);
    }

    public DamageSource create(RegistryKey<DamageType> key) {
        return new DamageSource(this.registry.entryOf(key));
    }

    public DirtSnackDamageSource dirtSnack() { return dirtSnack; }

    public static void load() {}

}
