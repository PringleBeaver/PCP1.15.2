package com.pringlebeaver.pcp.entities;

import com.pringlebeaver.pcp.PringlesCreaturePack;
import com.pringlebeaver.pcp.entities.goals.RedPandaAttackGoal;
import com.pringlebeaver.pcp.init.ModEntityTypes;
import com.pringlebeaver.pcp.init.SoundInit;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;

import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.monster.CaveSpiderEntity;
import net.minecraft.entity.monster.EndermiteEntity;
import net.minecraft.entity.monster.SilverfishEntity;
import net.minecraft.entity.monster.SpiderEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib.animation.builder.AnimationBuilder;
import software.bernie.geckolib.animation.controller.AnimationController;
import software.bernie.geckolib.animation.controller.EntityAnimationController;
import software.bernie.geckolib.entity.IAnimatedEntity;
import software.bernie.geckolib.event.AnimationTestEvent;
import software.bernie.geckolib.manager.EntityAnimationManager;

import javax.annotation.Nullable;


public class RedPandaEntity extends AnimalEntity implements IAnimatedEntity {

    private int attackTimer;
    Logger logger = LogManager.getLogger(PringlesCreaturePack.MOD_ID);
    public static final Ingredient TEMPTATION_ITEMS = Ingredient.fromItems(Items.BAMBOO);


    private EntityAnimationManager manager = new EntityAnimationManager();
    private AnimationController controller = new EntityAnimationController(this, "animationController", 20, this::animationPredicate);

    public static DataParameter<Boolean> IS_ATTACKING = EntityDataManager.createKey(RedPandaEntity.class, DataSerializers.BOOLEAN);

    @Override
    protected void registerData() {
        super.registerData();
        this.dataManager.register(IS_ATTACKING, false);
    }

    public RedPandaEntity(EntityType<? extends AnimalEntity> type, World worldIn) {
        super(type, worldIn);
        registerAnimationControllers();

    }


    // Goals

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(6, new PanicGoal(this, 2.0d));
        this.goalSelector.addGoal(7, new BreedGoal(this, 1.0d));
        this.goalSelector.addGoal(8, new TemptGoal(this, 1.5d, TEMPTATION_ITEMS, false));
        this.goalSelector.addGoal(9, new FollowParentGoal(this, 1.0d));
        this.goalSelector.addGoal(10, new WaterAvoidingRandomWalkingGoal(this, 1.0d));
        this.goalSelector.addGoal(11, new LookAtGoal(this, PlayerEntity.class, 8.0f));
        this.goalSelector.addGoal(12, new LookAtGoal(this, RedPandaEntity.class, 8.0f));
        this.goalSelector.addGoal(13, new LookRandomlyGoal(this));


        // Attacking
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, SpiderEntity.class, false));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, CaveSpiderEntity.class, false));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, SilverfishEntity.class, false));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, EndermiteEntity.class, false));
        this.goalSelector.addGoal(1, new RedPandaAttackGoal(this, 1.5D, false));

    }


    // Sounds




    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundInit.RED_PANDA_AMBIENT.get();
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundInit.RED_PANDA_HURT.get();
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.ENTITY_WOLF_STEP, 0.15F,1.0F);
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundInit.RED_PANDA_DEATH.get();
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        return super.attackEntityFrom(source, amount);

    }

    private float func_226517_es_() {
        return (float)this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getValue();
    }

    //Attack


    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        return super.attackEntityAsMob(entityIn);
    }

    public void setAttacking(boolean bool){
        dataManager.set(IS_ATTACKING, bool);
        LOGGER.debug(this.dataManager.get(IS_ATTACKING));
    }

    public boolean getAttacking(){
        return dataManager.get(IS_ATTACKING);
    }

    // Other
    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.getItem() == Items.BAMBOO;
    }


    @Override
    protected int getExperiencePoints(PlayerEntity player) {
        return 0;
    }

    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2D);
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
        this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(6.0f);

    }

    @Nullable
    @Override
    public AnimalEntity createChild(AgeableEntity ageable) {
        return ModEntityTypes.RED_PANDA.get().create(this.world);
    }
    @Override
    public EntityAnimationManager getAnimationManager() {
        return manager;
    }

    private <E extends RedPandaEntity> boolean animationPredicate(AnimationTestEvent<E> event) {
        boolean attacking = this.getAttacking();
         if (attacking) {
           controller.setAnimation(new AnimationBuilder().addAnimation("animation.pcp.attack"));
          return true;
     } else {
        return false;

     }

    }



    private void registerAnimationControllers() {
        manager.addAnimationController(controller);

    }

}
