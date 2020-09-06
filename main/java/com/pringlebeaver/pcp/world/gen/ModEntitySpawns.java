package com.pringlebeaver.pcp.world.gen;

import com.markus1002.autumnity.common.world.biome.MapleForestBiome;
import com.markus1002.autumnity.core.Autumnity;
import com.markus1002.autumnity.core.registry.ModBiomes;
import com.pringlebeaver.pcp.PringlesCreaturePack;
import com.pringlebeaver.pcp.init.ModEntityTypes;
import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.common.BiomeDictionary;
import static net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = PringlesCreaturePack.MOD_ID , bus = Mod.EventBusSubscriber.Bus.MOD)

public class ModEntitySpawns {
    @SubscribeEvent
    public static void spawnEntities(FMLLoadCompleteEvent event) {

        for (Biome biome : ForgeRegistries.BIOMES) {

            if (biome.getCategory() == Biome.Category.NETHER) {

            } else if (biome.getCategory() == Biome.Category.THEEND) {

            } else {
                // Red Panda
                if (biome == Biomes.BAMBOO_JUNGLE || biome == Biomes.BAMBOO_JUNGLE_HILLS) {
                    biome.getSpawns(EntityClassification.CREATURE)
                            .add(new Biome.SpawnListEntry(ModEntityTypes.RED_PANDA.get(), 20, 1, 2));

                }
                // Seahorse
                if (biome == Biomes.WARM_OCEAN) {
                    biome.getSpawns(EntityClassification.WATER_CREATURE)
                            .add(new Biome.SpawnListEntry(ModEntityTypes.SEAHORSE.get(), 15, 2, 3));

                }

                // Turkey
                if (biome == Biomes.FOREST || biome == Biomes.WOODED_HILLS || biome == Biomes.DARK_FOREST || biome == Biomes.DARK_FOREST_HILLS) {
                    biome.getSpawns(EntityClassification.CREATURE)
                            .add(new Biome.SpawnListEntry(ModEntityTypes.TURKEY.get(), 10, 1, 4));
                }

                if (biome == ModBiomes.MAPLE_FOREST.get() || biome == ModBiomes.MAPLE_FOREST_HILLS.get() || biome == ModBiomes.PUMPKIN_FIELDS.get()) {
                    biome.getSpawns(EntityClassification.CREATURE)
                            .add(new Biome.SpawnListEntry(ModEntityTypes.TURKEY.get(), 25, 1, 4));
                }

            }

        }
    }
}

