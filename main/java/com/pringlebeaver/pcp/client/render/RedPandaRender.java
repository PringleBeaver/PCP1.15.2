package com.pringlebeaver.pcp.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.pringlebeaver.pcp.PringlesCreaturePack;
import com.pringlebeaver.pcp.client.model.RedPandaModel;
import com.pringlebeaver.pcp.entities.RedPandaEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;


public class RedPandaRender extends MobRenderer<RedPandaEntity, RedPandaModel> {



    protected static final ResourceLocation TEXTURE = new ResourceLocation(PringlesCreaturePack.MOD_ID, "textures/entity/red_panda/red_panda.png");
    protected static final ResourceLocation KILIAN = new ResourceLocation(PringlesCreaturePack.MOD_ID, "textures/entity/red_panda/kilian.png");



    public RedPandaRender(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new RedPandaModel(), 0.5f);
    }

    @Override
    public void render(RedPandaEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        if (entityIn.isChild()) {
            this.getEntityModel().babyModel(true);
        }
        else {
            this.getEntityModel().babyModel(false);
        }

        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }

    @Override
    public ResourceLocation getEntityTexture(RedPandaEntity entity) {
        String s = TextFormatting.getTextWithoutFormattingCodes(entity.getName().getString());
        if (s != null && "Kilian".equals(s) || s != null && "kilian".equals(s)) {
            return KILIAN;
        } else {
            return TEXTURE;
        }
    }

    @Override
    protected void preRenderCallback(RedPandaEntity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        if (entitylivingbaseIn.isChild()) {
            matrixStackIn.scale(0.5F, 0.5F, 0.5F);
        }
        else {
            matrixStackIn.scale(1F, 1F, 1F);
        }

    }
}
