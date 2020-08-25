package com.pringlebeaver.pcp.init.items;

import com.pringlebeaver.pcp.PringlesCreaturePack;
import com.pringlebeaver.pcp.init.ModEntityTypes;
import com.pringlebeaver.pcp.items.FoodItems;
import com.pringlebeaver.pcp.items.ModSpawnEggItems;
import javafx.util.Builder;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    // Null Effects

    public static final Effect NONE = null;

    // Registeries

    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, PringlesCreaturePack.MOD_ID);

    public static  void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    // Misc Items

    public static final RegistryObject<TurkeyEggItem> TURKEY_EGG = ITEMS.register("turkey_egg", () -> new TurkeyEggItem((new Item.Properties().maxStackSize(16).group(PringlesCreaturePack.PCPTAB))));


    // Food
    //public static final Food TURKEY_FOOD = (new Food.Builder()).hunger(2).saturation(0.3F).effect(new EffectInstance(Effects.HUNGER, 600, 0), 0.3F).meat().build();

    public static final RegistryObject<Item> TURKEY = ITEMS.register("turkey", () -> new FoodItems(3, 1.4f, 600, 0, 0.3f, Effects.HUNGER));

    public static final RegistryObject<Item> COOKED_TURKEY = ITEMS.register("cooked_turkey", () -> new FoodItems(7, 7.5f, 0, 0, 0f, NONE));

    public static final RegistryObject<Item> STUFFED_TURKEY = ITEMS.register("stuffed_turkey", () -> new FoodItems(16, 16f, 600, 0, 1f, Effects.SLOWNESS));


    // Spawn Eggs
    public static final RegistryObject<ModSpawnEggItems> RED_PANDA_SPAWN_EGG = ITEMS.register("red_panda_spawn_egg", () -> new ModSpawnEggItems(ModEntityTypes.RED_PANDA, 0xcf5534, 0x4b1e11, new Item.Properties().group(PringlesCreaturePack.PCPTAB)));

    public static final RegistryObject<ModSpawnEggItems> TURKEY_SPAWN_EGG = ITEMS.register("turkey_spawn_egg", () -> new ModSpawnEggItems(ModEntityTypes.TURKEY, 0x533526, 0x71adc1, new Item.Properties().group(PringlesCreaturePack.PCPTAB)));
}
