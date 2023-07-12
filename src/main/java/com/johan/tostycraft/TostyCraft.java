package com.johan.tostycraft;

import com.johan.tostycraft.item.TostyItems;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(TostyCraft.MOD_ID)
public class TostyCraft
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "tostycraft";

    // Create DeferredRegister instances for items
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);

    public TostyCraft()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the DeferredRegister objects
        ITEMS.register(modEventBus);

        // Register TostycraftItems
        TostyItems.TOSTY_ITEMS.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    // Add a listener for the event that fires when a player smelts
    // a water bucket, to give them an empty bucket back
    @SubscribeEvent
    public void onItemSmelted(PlayerEvent.ItemSmeltedEvent event)
    {
        // Check if the item smelted was a salt item
        if (event.getSmelting().getItem() == TostyItems.SALT_ITEM.get())
        {
            // Create a new item stack with a bucket
            ItemStack itemStack = new ItemStack(Items.BUCKET); // Create a new item stack with a bucket

            // Check if the player has room in their inventory
            if (hasSpaceForEmptyBucket(event.getPlayer())) {
                // Add the bucket to the player's inventory
                event.getPlayer().getInventory().add(itemStack);
            } else {
                // Drop the bucket in the world
                event.getPlayer().drop(itemStack, false);
            }
        }
    }

    public boolean hasSpaceForEmptyBucket(Player player) {
        for (ItemStack itemStack : player.getInventory().items) {
            if (itemStack.getItem() == Items.BUCKET || itemStack.isEmpty()) {
                return true;
            }
        }

        return false;
    }
}
