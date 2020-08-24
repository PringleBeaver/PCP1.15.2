package com.pringlebeaver.pcp.world.gen;

import com.pringlebeaver.pcp.PringlesCreaturePack;
import com.pringlebeaver.pcp.init.ModEntityTypes;
import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = PringlesCreaturePack.MOD_ID , bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEntitySpawns {
    @SubscribeEvent
    public static void spawnEntities(FMLLoadCompleteEvent event) {
        for (Biome biome : ForgeRegistries.BIOMES)

            if (biome.getCategory() == Biome.Category.NETHER) {

            } else if (biome.getCategory() == Biome.Category.THEEND) {

            } else {
                // Red Panda
                if (biome == Biomes.BAMBOO_JUNGLE || biome == Biomes.BAMBOO_JUNGLE_HILLS) {
                    biome.getSpawns(EntityClassification.CREATURE)
                            .add(new Biome.SpawnListEntry(ModEntityTypes.RED_PANDA.get(), 20, 1, 2));
                }

            }

    }
}
