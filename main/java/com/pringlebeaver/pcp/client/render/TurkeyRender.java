package com.pringlebeaver.pcp.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.pringlebeaver.pcp.PringlesCreaturePack;
import com.pringlebeaver.pcp.client.model.TurkeyModel;
import com.pringlebeaver.pcp.entities.TurkeyEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;


public class TurkeyRender extends MobRenderer<TurkeyEntity, TurkeyModel> {



    protected static final ResourceLocation TEXTURE = new ResourceLocation(PringlesCreaturePack.MOD_ID, "textures/entity/turkey.png");



    public TurkeyRender(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new TurkeyModel(), 0.5f);
    }

    @Override
    public void render(TurkeyEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {

        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }

    @Override
    public ResourceLocation getEntityTexture(TurkeyEntity entity) {
            return TEXTURE;
    }

    @Override
    protected void preRenderCallback(TurkeyEntity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        if (entitylivingbaseIn.isChild()) {
            matrixStackIn.scale(0.5F, 0.5F, 0.5F);
        }
        else {
            matrixStackIn.scale(1F, 1F, 1F);
        }

    }

    @Override
    protected float handleRotationFloat(TurkeyEntity livingBase, float partialTicks) {
        float f = MathHelper.lerp(partialTicks, livingBase.oFlap, livingBase.wingRotation);
        float f1 = MathHelper.lerp(partialTicks, livingBase.oFlapSpeed, livingBase.destPos);
        return (MathHelper.sin(f) + 1.0F) * f1;
    }
}

