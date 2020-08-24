package com.pringlebeaver.pcp.entities.goals;

import com.pringlebeaver.pcp.PringlesCreaturePack;
import com.pringlebeaver.pcp.entities.RedPandaEntity;
import net.minecraft.entity.CreatureEntity;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.pathfinding.Path;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.EnumSet;


public class RedPandaAttackGoal extends MeleeAttackGoal {

    protected final RedPandaEntity attacker;
    protected int attackTick;
    private final double speedTowardsTarget;
    private final boolean longMemory;
    Logger logger = LogManager.getLogger(PringlesCreaturePack.MOD_ID);
    private Path path;
    private int delayCounter;
    private double targetX;
    private double targetY;
    private double targetZ;
    protected final int attackInterval = 20;
    private long field_220720_k;
    private int failedPathFindingPenalty = 0;
    private boolean canPenalize = false;

    public RedPandaAttackGoal(RedPandaEntity creature, double speedIn, boolean useLongMemory) {

        super(creature, speedIn, useLongMemory);
        this.attacker = creature;
        this.speedTowardsTarget = speedIn;
        this.longMemory = useLongMemory;
        this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));



        }



    protected void checkAndPerformAttack(RedPandaEntity enemy, double distToEnemySqr) {


    }
}
