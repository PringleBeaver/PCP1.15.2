package com.pringlebeaver.pcp.items;

import com.pringlebeaver.pcp.PringlesCreaturePack;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;

public class FoodItems extends Item {
    public FoodItems(int hunger, float saturation, int effectDuration, int effectAmplifier ,float effectProbability, Effect effect) {
        super(new Item.Properties()
                .group(PringlesCreaturePack.PCPTAB)
                .food(new Food.Builder()
                        .effect(new EffectInstance(effect, effectDuration, effectAmplifier), effectProbability)
                        .hunger(hunger)
                        .saturation(saturation)
                        .build())

        );
    }
}
