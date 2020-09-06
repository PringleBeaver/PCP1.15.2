package com.pringlebeaver.pcp.items;

import com.pringlebeaver.pcp.PringlesCreaturePack;
import com.pringlebeaver.pcp.entities.SeahorseEntity;
import com.pringlebeaver.pcp.init.ModEntityTypes;
import com.pringlebeaver.pcp.init.items.ModItems;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.command.arguments.NBTTagArgument;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.entity.passive.fish.TropicalFishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.FishBucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.stats.Stats;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.RegistryObject;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Supplier;

public class SeahorseBucketItem extends BucketItem {

    private final Supplier<EntityType<? extends AbstractFishEntity>> entityType;
    private int seahorseVariant;

    public SeahorseBucketItem(Supplier<EntityType<? extends AbstractFishEntity>> entityType, Supplier<? extends Fluid> supplier, Item.Properties builder, int Variant) {
        super(supplier, builder);
        this.entityType = entityType;
        seahorseVariant = Variant;
    }

    public void onLiquidPlaced(World worldIn, ItemStack p_203792_2_, BlockPos pos) {
        if (!worldIn.isRemote) {
            this.placeFish(worldIn, p_203792_2_, pos);
        }

    }

    private static Properties getProperties() {
        Properties properties = new Properties();
        properties.group(PringlesCreaturePack.PCPTAB);
        properties.maxStackSize(1);

        return properties;
    }


    protected void playEmptySound(@Nullable PlayerEntity player, IWorld worldIn, BlockPos pos) {
        worldIn.playSound(player, pos, SoundEvents.ITEM_BUCKET_EMPTY_FISH, SoundCategory.NEUTRAL, 1.0F, 1.0F);
    }

    private void placeFish(World worldIn, ItemStack stack, BlockPos pos) {
        Entity entity = this.entityType.get().spawn(worldIn, stack, (PlayerEntity) null, pos, SpawnReason.BUCKET, true, false);
        if (entity != null) {
            ((SeahorseEntity) entity).setFromBucket(true);
            ((SeahorseEntity) entity).setVariant(seahorseVariant);
        }

    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        final TextFormatting[] TEXT_FORMAT = new TextFormatting[]{TextFormatting.ITALIC, TextFormatting.GRAY};
        if (seahorseVariant == 0) {
            tooltip.add(new TranslationTextComponent("pcp.seahorse.variant.yellow").applyTextStyles(TEXT_FORMAT));
        } else if (seahorseVariant == 1) {
            tooltip.add(new TranslationTextComponent("pcp.seahorse.variant.red").applyTextStyles(TEXT_FORMAT));
        } else if (seahorseVariant == 2){
            tooltip.add(new TranslationTextComponent("pcp.seahorse.variant.black").applyTextStyles(TEXT_FORMAT));
        } else if (seahorseVariant == 3) {
            tooltip.add(new TranslationTextComponent("pcp.seahorse.variant.blue").applyTextStyles(TEXT_FORMAT));
        } else {
            tooltip.add(new TranslationTextComponent("pcp.seahorse.variant.purple").applyTextStyles(TEXT_FORMAT));
        }
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}