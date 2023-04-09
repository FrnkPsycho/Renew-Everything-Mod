package net.frnks.reneweverything;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.frnks.reneweverything.data.ModAdvancementGenerator;
import net.frnks.reneweverything.data.ModItemTagGenerator;
import net.frnks.reneweverything.data.ModLootTableGenerator;
import net.frnks.reneweverything.data.ModRecipeGenerator;

public class ModDataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(ModItemTagGenerator::new);
        pack.addProvider(ModRecipeGenerator::new);
        pack.addProvider(ModAdvancementGenerator::new);
        pack.addProvider(ModLootTableGenerator::new);
    }
}
