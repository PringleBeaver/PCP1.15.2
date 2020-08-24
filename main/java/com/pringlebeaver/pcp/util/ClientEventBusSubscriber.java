package com.pringlebeaver.pcp.util;

import com.pringlebeaver.pcp.PringlesCreaturePack;
import com.pringlebeaver.pcp.client.render.RedPandaRender;
import com.pringlebeaver.pcp.client.render.TurkeyRender;
import com.pringlebeaver.pcp.init.ModEntityTypes;
import com.pringlebeaver.pcp.items.ModSpawnEggItems;
import net.minecraft.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = PringlesCreaturePack.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.RED_PANDA.get(), RedPandaRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.TURKEY.get(),TurkeyRender::new);
    }

    @SubscribeEvent
    public static void onRegisterEntities(final RegistryEvent.Register<EntityType<?>> event) {
        ModSpawnEggItems.initSpawnEggs();
    }
}
