package com.pringlebeaver.pcp.items;

import com.pringlebeaver.pcp.PringlesCreaturePack;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;

public class AlwaysEdibleFoodItems extends Item {
    public AlwaysEdibleFoodItems(int hunger, float saturation, int effectDuration, int effectAmplifier , float effectProbability, Effect effect) {
        super(new Properties()
                .group(PringlesCreaturePack.PCPTAB)
                .food(new Food.Builder()
                        .effect(new EffectInstance(effect, effectDuration, effectAmplifier), effectProbability)
                        .hunger(hunger)
                        .saturation(saturation)
                        .setAlwaysEdible()
                        .build())

        );
    }
}
