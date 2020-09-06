package com.pringlebeaver.pcp.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;

public class StuffedEffect extends Effect {
    public StuffedEffect() {
        super(EffectType.NEUTRAL, 12557429);
        addAttributesModifier(SharedMonsterAttributes.MOVEMENT_SPEED, "ca1687e2-ed71-11ea-adc1-0242ac120002", (double)-0.4F, AttributeModifier.Operation.MULTIPLY_TOTAL);
    }

    @Override
    public boolean isReady(int duration, int amplifier) {
        return true;
    }

    public void performEffect(LivingEntity entityLivingBaseIn, int amplifier) {
       ((PlayerEntity)entityLivingBaseIn).getFoodStats().setFoodSaturationLevel(5.0F);
        System.out.println(((PlayerEntity) entityLivingBaseIn).getFoodStats().getSaturationLevel());
        }


}

