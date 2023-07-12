package com.johan.tostycraft;

import com.johan.tostycraft.item.TostyItems;
import com.mojang.logging.LogUtils;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(TostyCraft.MOD_ID)
public class TostyCraft
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "tostycraft";

    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    // Create DeferredRegister instances for items
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);

    public TostyCraft()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the common setup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register the DeferredRegister objects
        ITEMS.register(modEventBus);

        // Register TostycraftItems
        TostyItems.TOSTY_ITEMS.register(modEventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
    }
}
