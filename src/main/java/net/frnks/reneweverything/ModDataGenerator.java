package net.frnks.reneweverything;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.frnks.reneweverything.data.*;
import net.frnks.reneweverything.entity.damage.ModDamageTypes;
import net.frnks.reneweverything.loot.OreCropLootTables;
import net.frnks.reneweverything.loot.SnackLootTables;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class ModDataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(ModItemTagGenerator::new);
        pack.addProvider(ModRecipeGenerator::new);
        pack.addProvider(ModAdvancementGenerator::new);
        pack.addProvider(ModLootTableGenerator::new);
        pack.addProvider(OreCropLootTables::new);
//        pack.addProvider(SnackLootTables::new);
        pack.addProvider(ModModelGenerator::new);
    }

    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
        registryBuilder.addRegistry(RegistryKeys.DAMAGE_TYPE, ModDamageTypes::bootstrap);
    }
}
