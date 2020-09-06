package com.pringlebeaver.pcp.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.pringlebeaver.pcp.PringlesCreaturePack;
import com.pringlebeaver.pcp.client.model.SeahorseModel;
import com.pringlebeaver.pcp.entities.SeahorseEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.Vector3f;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.fish.CodEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;


public class SeahorseRender extends MobRenderer<SeahorseEntity, SeahorseModel> {



    protected static final ResourceLocation YELLOW = new ResourceLocation(PringlesCreaturePack.MOD_ID, "textures/entity/seahorse/yellow_seahorse.png");

    protected static final ResourceLocation RED = new ResourceLocation(PringlesCreaturePack.MOD_ID, "textures/entity/seahorse/red_seahorse.png");

    protected static final ResourceLocation BLACK = new ResourceLocation(PringlesCreaturePack.MOD_ID, "textures/entity/seahorse/black_seahorse.png");

    protected static final ResourceLocation BLUE = new ResourceLocation(PringlesCreaturePack.MOD_ID, "textures/entity/seahorse/blue_seahorse.png");

    protected static final ResourceLocation PURPLE = new ResourceLocation(PringlesCreaturePack.MOD_ID, "textures/entity/seahorse/purple_seahorse.png");


    public SeahorseRender(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new SeahorseModel(), 0.25f);
    }

    @Override
    public void render(SeahorseEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }

    @Override
    public ResourceLocation getEntityTexture(SeahorseEntity entity) {
        switch(entity.getVariant()) {
            case 0:
            default:
                return YELLOW;
            case 1:
                return RED;
            case 2:
                return BLACK;
            case 3:
                return BLUE;
            case 4:
                return PURPLE;
        }
    }

    protected void applyRotations(SeahorseEntity entityLiving, MatrixStack matrixStackIn, float ageInTicks, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, matrixStackIn, ageInTicks, rotationYaw, partialTicks);
        float f = 4.3F * MathHelper.sin(0.6F * ageInTicks);
        if (!entityLiving.isInWater()) {
            matrixStackIn.translate((double)0.1F, (double)0.1F, (double)-0.1F);
            matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90.0F));
        }

    }
}

