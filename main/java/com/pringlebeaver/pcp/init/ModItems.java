package com.pringlebeaver.pcp.init;

import com.pringlebeaver.pcp.PringlesCreaturePack;
import com.pringlebeaver.pcp.items.ModSpawnEggItems;
import net.minecraft.client.tutorial.Tutorial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {



    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, PringlesCreaturePack.MOD_ID);

    public static  void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    // Spawn Eggs
    public static final RegistryObject<ModSpawnEggItems> RED_PANDA_SPAWN_EGG = ITEMS.register("red_panda_spawn_egg", () -> new ModSpawnEggItems(ModEntityTypes.RED_PANDA, 0xcf5534, 0x4b1e11, new Item.Properties().group(PringlesCreaturePack.TAB)));

    public static final RegistryObject<ModSpawnEggItems> TURKEY_SPAWN_EGG = ITEMS.register("turkey_spawn_egg", () -> new ModSpawnEggItems(ModEntityTypes.TURKEY, 0x533526, 0x71adc1, new Item.Properties().group(PringlesCreaturePack.TAB)));
}
