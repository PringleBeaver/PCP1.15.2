package com.pringlebeaver.pcp;

import com.pringlebeaver.pcp.init.ModEntityTypes;
import com.pringlebeaver.pcp.init.items.ModItems;
import com.pringlebeaver.pcp.init.SoundInit;
import com.pringlebeaver.pcp.util.ModChecker;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("pcp")
public class PringlesCreaturePack
{
    private static final Logger LOGGER = LogManager.getLogger();

    public static final String MOD_ID = "pcp";

    final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

    public PringlesCreaturePack() {

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        ModEntityTypes.ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());

        SoundInit.SOUNDS.register(modEventBus);

        ModItems.init();

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {

    }

    private void doClientStuff(final FMLClientSetupEvent event)
    {
        
    }

    public static final ItemGroup PCPTAB = new ItemGroup("pcpTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.COOKED_TURKEY.get());
        }
    };

}
