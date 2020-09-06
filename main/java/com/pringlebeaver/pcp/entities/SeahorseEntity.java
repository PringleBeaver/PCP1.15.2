package com.pringlebeaver.pcp.entities;

import com.pringlebeaver.pcp.init.items.ModItems;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.RabbitEntity;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import software.bernie.geckolib.animation.builder.AnimationBuilder;
import software.bernie.geckolib.animation.controller.AnimationController;
import software.bernie.geckolib.animation.controller.EntityAnimationController;
import software.bernie.geckolib.entity.IAnimatedEntity;
import software.bernie.geckolib.event.AnimationTestEvent;
import software.bernie.geckolib.manager.EntityAnimationManager;

import javax.annotation.Nullable;

public class SeahorseEntity extends AbstractFishEntity implements IAnimatedEntity {

    private static final DataParameter<Integer> SEAHORSE_TYPE = EntityDataManager.createKey(SeahorseEntity.class, DataSerializers.VARINT);

    private EntityAnimationManager manager = new EntityAnimationManager();
    private AnimationController controller = new EntityAnimationController(this, "animationController", 20, this::animationPredicate);

    public SeahorseEntity(EntityType<? extends AbstractFishEntity> type, World worldIn) {
        super(type, worldIn);
        registerAnimationControllers();
    }

    protected void registerData() {
        super.registerData();
        this.dataManager.register(SEAHORSE_TYPE, 0);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new PanicGoal(this, 1.0D));
        this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, PlayerEntity.class, 2.0F, 1.0D, 1.0D, EntityPredicates.NOT_SPECTATING::test));
        this.goalSelector.addGoal(2, new SwimGoal(this));
        this.goalSelector.addGoal(3, new LookAtGoal(this, PlayerEntity.class, 3));
        this.goalSelector.addGoal(4, new LookRandomlyGoal(this));

    }

    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2D);
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(6.0D);

    }

    @Nullable
    public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
        this.setVariant(this.rand.nextInt(5));
        return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
    }

    public void setVariant(int variantIn) {
        this.dataManager.set(SEAHORSE_TYPE, variantIn);
    }

    public int getVariant() {
        return (this.dataManager.get(SEAHORSE_TYPE));
    }
    // Set NBT
    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        compound.putInt("Type", this.getVariant());
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        this.setVariant(compound.getInt("Type"));
    }

    public Entity spawn(World worldIn, ItemStack p_205357_2_, PlayerEntity playerEntity, BlockPos pos, SpawnReason bucket, boolean b, boolean b1) {
        return this;
    }


    static class SwimGoal extends RandomSwimmingGoal {
        private final SeahorseEntity fish;

        public SwimGoal(SeahorseEntity fish) {
            super(fish, 1.0D, 40);
            this.fish = fish;
        }
    }


    @Override
    protected ItemStack getFishBucket() {
        switch(getVariant()) {
            case 0:
            default:
                return new ItemStack(ModItems.YELLOW_SEAHORSE_BUCKET.get());
            case 1:
                return new ItemStack(ModItems.RED_SEAHORSE_BUCKET.get());
            case 2:
                return new ItemStack(ModItems.BLACK_SEAHORSE_BUCKET.get());
            case 3:
                return new ItemStack(ModItems.BLUE_SEAHORSE_BUCKET.get());
            case 4:
                return new ItemStack(ModItems.PURPLE_SEAHORSE_BUCKET.get());
        }

    }

    @Override
    protected SoundEvent getFlopSound() {
        return SoundEvents.ENTITY_COD_FLOP;
    }

    private void registerAnimationControllers() {
        manager.addAnimationController(controller);
    }

    public EntityAnimationManager getAnimationManager() {
        return manager;
    }

    private <E extends SeahorseEntity> boolean animationPredicate(AnimationTestEvent<E> event) {
        if (this.isInWater() && this.isAlive()) {
            controller.setAnimation(new AnimationBuilder().addAnimation("animation.pcp.idle", true));
            return true;
        } else {
            return false;
        }

    }
}
