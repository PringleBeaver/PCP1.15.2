package com.pringlebeaver.pcp.client.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.pringlebeaver.pcp.entities.TurkeyEntity;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import software.bernie.geckolib.animation.model.AnimatedEntityModel;
import software.bernie.geckolib.animation.render.AnimatedModelRenderer;

public class TurkeyModel extends AnimatedEntityModel<TurkeyEntity> {

    private final AnimatedModelRenderer body;
    private final AnimatedModelRenderer leg1;
    private final AnimatedModelRenderer leg0;
    private final AnimatedModelRenderer head;
    private final AnimatedModelRenderer beard;
    private final AnimatedModelRenderer tail;
    private final AnimatedModelRenderer wing0;
    private final AnimatedModelRenderer wing1;
    private final AnimatedModelRenderer headbaby;
    private final AnimatedModelRenderer beard2;

    public TurkeyModel()
    {
        textureWidth = 64;
        textureHeight = 64;
        body = new AnimatedModelRenderer(this);
        body.setRotationPoint(0.0F, 19.0F, -4.0F);
        body.setTextureOffset(0, 41).addBox(-5.0F, -4.0F, -1.0F, 10.0F, 6.0F, 10.0F, 0.0F, false);
        body.setModelRendererName("body");
        this.registerModelRenderer(body);

        leg1 = new AnimatedModelRenderer(this);
        leg1.setRotationPoint(2.0F, 2.0F, 4.0F);
        body.addChild(leg1);
        leg1.setTextureOffset(45, 10).addBox(0.0F, -4.0F, 0.0F, 1.0F, 7.0F, 0.0F, 0.0F, false);
        leg1.setTextureOffset(40, 17).addBox(-1.0F, 3.0F, -2.0F, 3.0F, 0.0F, 4.0F, 0.0F, false);
        leg1.setModelRendererName("leg1");
        this.registerModelRenderer(leg1);

        leg0 = new AnimatedModelRenderer(this);
        leg0.setRotationPoint(-2.0F, 2.0F, 4.0F);
        body.addChild(leg0);
        leg0.setTextureOffset(45, 10).addBox(-1.0F, -4.0F, 0.0F, 1.0F, 7.0F, 0.0F, 0.0F, false);
        leg0.setTextureOffset(40, 17).addBox(-2.0F, 3.0F, -2.0F, 3.0F, 0.0F, 4.0F, 0.0F, false);
        leg0.setModelRendererName("leg0");
        this.registerModelRenderer(leg0);

        head = new AnimatedModelRenderer(this);
        head.setRotationPoint(0.0F, -1.0F, -1.0F);
        body.addChild(head);
        head.setTextureOffset(0, 0).addBox(-2.0F, -10.0F, -2.0F, 4.0F, 10.0F, 3.0F, 0.0F, false);
        head.setTextureOffset(0, 14).addBox(-2.0F, -8.0F, -4.0F, 4.0F, 2.0F, 2.0F, 0.0F, false);
        head.setModelRendererName("head");
        this.registerModelRenderer(head);

        beard = new AnimatedModelRenderer(this);
        beard.setRotationPoint(0.0F, -5.0F, -2.0F);
        head.addChild(beard);
        setRotationAngle(beard, -0.0873F, 0.0F, 0.0F);
        beard.setTextureOffset(14, 5).addBox(-1.0F, -1.9962F, -1.0872F, 2.0F, 5.0F, 2.0F, 0.0F, false);
        beard.setModelRendererName("beard");
        this.registerModelRenderer(beard);

        tail = new AnimatedModelRenderer(this);
        tail.setRotationPoint(0.0F, -2.0F, 8.0F);
        body.addChild(tail);
        setRotationAngle(tail, -0.48F, 0.0F, 0.0F);
        tail.setTextureOffset(0, 18).addBox(-7.0F, -9.0F, 0.0F, 14.0F, 9.0F, 0.0F, 0.0F, false);
        tail.setModelRendererName("tail");
        this.registerModelRenderer(tail);

        wing0 = new AnimatedModelRenderer(this);
        wing0.setRotationPoint(-5.0F, -3.0F, 2.0F);
        body.addChild(wing0);
        wing0.setTextureOffset(16, 31).addBox(-1.0F, 0.0F, -2.0F, 1.0F, 4.0F, 6.0F, 0.0F, false);
        wing0.setModelRendererName("wing0");
        this.registerModelRenderer(wing0);

        wing1 = new AnimatedModelRenderer(this);
        wing1.setRotationPoint(5.0F, -3.0F, 2.0F);
        body.addChild(wing1);
        wing1.setTextureOffset(16, 31).addBox(0.0F, 0.0F, -2.0F, 1.0F, 4.0F, 6.0F, 0.0F, false);
        wing1.setModelRendererName("wing1");
        this.registerModelRenderer(wing1);

        headbaby = new AnimatedModelRenderer(this);
        headbaby.setRotationPoint(0.0F, 18.0F, -5.0F);
        headbaby.setTextureOffset(0, 0).addBox(-2.0F, -10.0F, -2.0F, 4.0F, 10.0F, 3.0F, 0.0F, false);
        headbaby.setTextureOffset(0, 14).addBox(-2.0F, -8.0F, -4.0F, 4.0F, 2.0F, 2.0F, 0.0F, false);
        headbaby.setModelRendererName("headbaby");
        this.registerModelRenderer(headbaby);

        beard2 = new AnimatedModelRenderer(this);
        beard2.setRotationPoint(0.0F, -5.0F, -2.0F);
        headbaby.addChild(beard2);
        setRotationAngle(beard2, -0.0873F, 0.0F, 0.0F);
        beard2.setTextureOffset(14, 5).addBox(-1.0F, -1.9962F, -1.0872F, 2.0F, 5.0F, 2.0F, 0.0F, false);
        beard2.setModelRendererName("beard2");
        this.registerModelRenderer(beard2);

        this.rootBones.add(body);
        this.rootBones.add(headbaby);
    }

    public void setRotationAngles(TurkeyEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
        this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
        this.headbaby.rotateAngleX = headPitch * ((float)Math.PI / 180F);
        this.headbaby.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
        this.leg0.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.wing0.rotateAngleZ = ageInTicks;
        this.wing1.rotateAngleZ = -ageInTicks;
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        body.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        matrixStackIn.push();
        matrixStackIn.scale(1.5F, 1.5F, 1.5F);
        matrixStackIn.translate(0F, -0.35F, 0.075F);
        headbaby.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        matrixStackIn.pop();


    }

    public void babyModel(Boolean isBaby) {

        if (isBaby) {
            this.headbaby.showModel = true;
            this.head.showModel = false;
        } else {
            this.head.showModel = true;
            this.headbaby.showModel = false;
        }

    }

    @Override
    public ResourceLocation getAnimationFileLocation()
    {
        return new ResourceLocation("pcp", "animations/turkey.json");
    }
}

