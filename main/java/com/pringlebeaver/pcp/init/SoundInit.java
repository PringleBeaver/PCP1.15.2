package com.pringlebeaver.pcp.init;

import com.pringlebeaver.pcp.PringlesCreaturePack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SoundInit {

    public static final DeferredRegister<SoundEvent> SOUNDS = new DeferredRegister<>(ForgeRegistries.SOUND_EVENTS, PringlesCreaturePack.MOD_ID);

    public static final RegistryObject<SoundEvent> RED_PANDA_AMBIENT = SOUNDS.register("entity.red_panda.ambient", () -> new SoundEvent(new ResourceLocation(PringlesCreaturePack.MOD_ID, "entity.red_panda.ambient" )));

    public static final RegistryObject<SoundEvent> RED_PANDA_HURT = SOUNDS.register("entity.red_panda.hurt", () -> new SoundEvent(new ResourceLocation(PringlesCreaturePack.MOD_ID, "entity.red_panda.hurt" )));

    public static final RegistryObject<SoundEvent> RED_PANDA_DEATH = SOUNDS.register("entity.red_panda.death", () -> new SoundEvent(new ResourceLocation(PringlesCreaturePack.MOD_ID, "entity.red_panda.death" )));

    public static final RegistryObject<SoundEvent> TURKEY_HURT = SOUNDS.register("entity.turkey.hurt", () -> new SoundEvent(new ResourceLocation(PringlesCreaturePack.MOD_ID, "entity.turkey.hurt" )));

    public static final RegistryObject<SoundEvent> TURKEY_DEATH = SOUNDS.register("entity.turkey.death", () -> new SoundEvent(new ResourceLocation(PringlesCreaturePack.MOD_ID, "entity.turkey.death" )));

    public static final RegistryObject<SoundEvent> TURKEY_AMBIENT = SOUNDS.register("entity.turkey.ambient", () -> new SoundEvent(new ResourceLocation(PringlesCreaturePack.MOD_ID, "entity.turkey.ambient" )));

}

