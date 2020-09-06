package com.pringlebeaver.pcp.entities;

import com.pringlebeaver.pcp.PringlesCreaturePack;
import com.pringlebeaver.pcp.entities.goals.GrassForageGoal;
import com.pringlebeaver.pcp.init.ModEntityTypes;
import com.pringlebeaver.pcp.init.SoundInit;
import com.pringlebeaver.pcp.init.items.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.pattern.BlockStateMatcher;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.storage.loot.LootParameterSets;
import net.minecraft.world.storage.loot.LootParameters;
import net.minecraft.world.storage.loot.LootTable;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import software.bernie.geckolib.GeckoLib;
import software.bernie.geckolib.animation.builder.AnimationBuilder;
import software.bernie.geckolib.animation.controller.AnimationController;
import software.bernie.geckolib.animation.controller.EntityAnimationController;
import software.bernie.geckolib.entity.IAnimatedEntity;
import software.bernie.geckolib.event.AnimationTestEvent;
import software.bernie.geckolib.event.CustomInstructionKeyframeEvent;
import software.bernie.geckolib.event.SoundKeyframeEvent;
import software.bernie.geckolib.manager.EntityAnimationManager;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.Random;
import java.util.function.Predicate;

public class TurkeyEntity extends ChickenEntity implements IAnimatedEntity {


    private static final Ingredient TEMPTATION_ITEMS = Ingredient.fromItems(Items.WHEAT_SEEDS, Items.MELON_SEEDS, Items.PUMPKIN_SEEDS, Items.BEETROOT_SEEDS);
    private GrassForageGoal grassForageGoal;
    private int turkeyTimer;
    private int peckTimer;
    private EntityAnimationManager manager = new EntityAnimationManager();
    private AnimationController controller = new EntityAnimationController(this, "animationController", 20, this::animationPredicate);
    private static final ResourceLocation TURKEY_FORAGE = new ResourceLocation(PringlesCreaturePack.MOD_ID, "entities/turkey_forage");


    public TurkeyEntity(EntityType<? extends ChickenEntity> type, World worldIn) {
        super(type, worldIn);
        registerAnimationControllers();

    }

    @Nullable
    @Override
    public ChickenEntity createChild(AgeableEntity ageable) {
        return ModEntityTypes.TURKEY.get().create(this.world);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();

        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.4D));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.0D, false, TEMPTATION_ITEMS));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.1D));
        this.goalSelector.addGoal(6, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(7, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
    }

    // Sounds


    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundInit.TURKEY_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundInit.TURKEY_DEATH.get();
    }

    @Override
    protected SoundEvent getAmbientSound() {
        if (this.rand.nextInt(3) > 1) {
            return SoundInit.TURKEY_AMBIENT.get();
        } else {
            return null;
        }
    }

    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(8.0D);
    }


    public void livingTick() {
        if (this.world.isRemote) {
            this.turkeyTimer = Math.max(0, this.turkeyTimer - 1);
        }
        super.livingTick();
    }


    @Nullable
    @Override
    public ItemEntity entityDropItem(IItemProvider itemIn, int offset) {
        return super.entityDropItem(ModItems.TURKEY_EGG.get(), 0);
    }

    @Override
    public EntityAnimationManager getAnimationManager() {
        return manager;
    }


    private <E extends Entity> boolean animationPredicate(AnimationTestEvent<E> eAnimationTestEvent) {
        return false;
    }

    private void registerAnimationControllers() {
        manager.addAnimationController(controller);
    }
}