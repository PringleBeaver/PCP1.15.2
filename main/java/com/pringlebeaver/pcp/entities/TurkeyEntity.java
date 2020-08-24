package com.pringlebeaver.pcp.entities;

import com.pringlebeaver.pcp.entities.goals.GrassForageGoal;
import com.pringlebeaver.pcp.init.ModEntityTypes;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import software.bernie.geckolib.animation.controller.AnimationController;
import software.bernie.geckolib.animation.controller.EntityAnimationController;
import software.bernie.geckolib.entity.IAnimatedEntity;
import software.bernie.geckolib.event.AnimationTestEvent;
import software.bernie.geckolib.manager.EntityAnimationManager;

import javax.annotation.Nullable;

public class TurkeyEntity extends ChickenEntity implements IAnimatedEntity {


    private static final Ingredient TEMPTATION_ITEMS = Ingredient.fromItems(Items.WHEAT_SEEDS, Items.MELON_SEEDS, Items.PUMPKIN_SEEDS, Items.BEETROOT_SEEDS);
    private GrassForageGoal grassForageGoal;
    private int turkeyTimer;
    private EntityAnimationManager manager = new EntityAnimationManager();
    private AnimationController controller = new EntityAnimationController(this, "animationController", 20, this::animationPredicate);


    public TurkeyEntity(EntityType<? extends ChickenEntity> type, World worldIn) {
        super(type, worldIn);
        registerAnimationControllers();

    }

    private void registerAnimationControllers() {
    }

    @Nullable
    @Override
    public ChickenEntity createChild(AgeableEntity ageable) {
        return ModEntityTypes.TURKEY.get().create(this.world);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        grassForageGoal = new GrassForageGoal(this);
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.4D));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.0D, false, TEMPTATION_ITEMS));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.1D));
        this.goalSelector.addGoal(5, new GrassForageGoal(this));
        this.goalSelector.addGoal(6, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(7, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
    }

    @Override
    protected void updateAITasks() {
        this.turkeyTimer = this.grassForageGoal.getEatingGrassTimer();
        super.updateAITasks();
    }

    public void livingTick() {
        if (this.world.isRemote) {
            this.turkeyTimer = Math.max(0, this.turkeyTimer - 1);
        }

        super.livingTick();
    }

    @OnlyIn(Dist.CLIENT)
    public void HandleStatusUpdate(byte id) {
        if (id == 10) {
            turkeyTimer = 200;
        } else {
            super.handleStatusUpdate(id);
        }

    }

    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(8.0D);
    }


    @Override
    public EntityAnimationManager getAnimationManager() {
        return manager;
    }

    private <E extends Entity> boolean animationPredicate(AnimationTestEvent<E> eAnimationTestEvent) {
        return false;
    }
}
