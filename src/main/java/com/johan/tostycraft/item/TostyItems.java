package com.johan.tostycraft.item;

import com.johan.tostycraft.TostyCraft;
import com.johan.tostycraft.tab.TostyTab;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TostyItems {
    // Create a deferred register for items
    public static final DeferredRegister<Item> TOSTY_ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TostyCraft.MOD_ID);

    // Register Tab Item
    public static final RegistryObject<Item> TOSTY_TAB_ITEM =
            TOSTY_ITEMS.register("tosty_tab_item",
                    () -> new Item(new Item.Properties()));

    // Register necessary items to craft TostycraftItems
    public static final RegistryObject<Item> CHEESE_ITEM =
            TOSTY_ITEMS.register("cheese_item",
                    () -> new Item(new Item.Properties()
                            .tab(TostyTab.TOSTY_TAB)
                            .food(new FoodProperties.Builder()
                                    .nutrition(4)
                                    .saturationMod(3f)
                                    .build()
                            )
                    ));

    public static final RegistryObject<Item> SALT_ITEM =
            TOSTY_ITEMS.register("salt_item",
                    () -> new Item(new Item.Properties()
                            .tab(TostyTab.TOSTY_TAB)
                            .food(new FoodProperties.Builder()
                                    .nutrition(1)
                                    .saturationMod(0f)
                                    .effect(() -> new MobEffectInstance(MobEffects.POISON, 50, 1), 0.5f)
                                    .build()
                            )
                    ));

    // Register TostycraftItems
    public static final RegistryObject<Item> PAPIOLAS_ITEM =
            TOSTY_ITEMS.register("papiolas_item",
                () -> new Item(new Item.Properties()
                        .tab(TostyTab.TOSTY_TAB)
                        .food(new FoodProperties.Builder()
                                .nutrition(7)
                                .saturationMod(5f)
                                .build()
                        )
                ));

    public static final RegistryObject<Item> TRONADITAS_ITEM =
            TOSTY_ITEMS.register("tronaditas_item",
                () -> new Item(new Item.Properties()
                        .tab(TostyTab.TOSTY_TAB)
                        .food(new FoodProperties.Builder()
                                .nutrition(5)
                                .saturationMod(6f)
                                .build()
                        )
                ));

    public static final RegistryObject<Item> QUESITOS_ITEM =
            TOSTY_ITEMS.register("quesitos_item",
                () -> new Item(new Item.Properties()
                        .tab(TostyTab.TOSTY_TAB)
                        .food(new FoodProperties.Builder()
                                .nutrition(5)
                                .saturationMod(5f)
                                .build()
                        )
                ));

    public static final RegistryObject<Item> CHIRRULITOS_ITEM =
            TOSTY_ITEMS.register("chirrulitos_item",
                () -> new Item(new Item.Properties()
                        .tab(TostyTab.TOSTY_TAB)
                        .food(new FoodProperties.Builder()
                                .nutrition(6)
                                .saturationMod(6f)
                                .build()
                        )
                ));

    public static final RegistryObject<Item> BOLITAS_QUESO_ITEM =
            TOSTY_ITEMS.register("bolitas_queso_item",
                () -> new Item(new Item.Properties()
                        .tab(TostyTab.TOSTY_TAB)
                        .food(new FoodProperties.Builder()
                                .nutrition(7)
                                .saturationMod(7f)
                                .build()
                        )
                ));
}
