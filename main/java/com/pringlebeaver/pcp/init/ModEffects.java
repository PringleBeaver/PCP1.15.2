package com.pringlebeaver.pcp.init;

import com.pringlebeaver.pcp.PringlesCreaturePack;
import com.pringlebeaver.pcp.effects.StuffedEffect;
import net.minecraft.potion.Effect;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(
        bus = Mod.EventBusSubscriber.Bus.MOD
)
public class ModEffects {
    public static final DeferredRegister<Effect> EFFECTS;
    public static Effect STUFFED;

    public ModEffects() {
    }

    @SubscribeEvent
    public static void registerEffects(RegistryEvent.Register<Effect> event) {
        event.getRegistry().registerAll(new Effect[]{STUFFED});
    }

    static {
        EFFECTS = new DeferredRegister(ForgeRegistries.POTIONS, PringlesCreaturePack.MOD_ID);
        STUFFED = (Effect)(new StuffedEffect()).setRegistryName("stuffed");
    }
}