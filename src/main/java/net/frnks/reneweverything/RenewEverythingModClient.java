package net.frnks.reneweverything;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.frnks.reneweverything.block.ModBlocks;
import net.minecraft.client.render.RenderLayer;

public class RenewEverythingModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.IRON_CROP_BLOCK);
    }
}
