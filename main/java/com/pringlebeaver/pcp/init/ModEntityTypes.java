package com.pringlebeaver.pcp.init;

import com.pringlebeaver.pcp.PringlesCreaturePack;
import com.pringlebeaver.pcp.entities.RedPandaEntity;
import com.pringlebeaver.pcp.entities.TurkeyEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {

    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.ENTITIES, PringlesCreaturePack.MOD_ID);

    // Entity Types

    public static final RegistryObject<EntityType<RedPandaEntity>> RED_PANDA = ENTITY_TYPES.register("red_panda",
            () -> EntityType.Builder.create(RedPandaEntity::new, EntityClassification.CREATURE)
            .size(0.8f,0.75f)
            .build(new ResourceLocation(PringlesCreaturePack.MOD_ID, "ped_panda").toString()));

    public static final RegistryObject<EntityType<TurkeyEntity>> TURKEY = ENTITY_TYPES.register("turkey",
            () -> EntityType.Builder.create(TurkeyEntity::new, EntityClassification.CREATURE)
                    .size(0.8f,0.75f)
                    .build(new ResourceLocation(PringlesCreaturePack.MOD_ID, "turkey").toString()));
}
