package com.johan.tostycraft.tab;

import com.johan.tostycraft.TostyCraft;
import com.johan.tostycraft.item.TostyItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TostyCraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TostyTab {
    public static final CreativeModeTab TOSTY_TAB = new CreativeModeTab(TostyCraft.MOD_ID) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(TostyItems.TOSTY_TAB_ITEM.get());
        }
    };
}
