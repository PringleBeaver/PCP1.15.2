package com.pringlebeaver.pcp.client.model;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.pringlebeaver.pcp.PringlesCreaturePack;
import com.pringlebeaver.pcp.entities.SeahorseEntity;
import com.pringlebeaver.pcp.entities.TurkeyEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import software.bernie.geckolib.animation.model.AnimatedEntityModel;
import software.bernie.geckolib.animation.render.AnimatedModelRenderer;

public class SeahorseModel extends AnimatedEntityModel<SeahorseEntity> {

    private final AnimatedModelRenderer body;
    private final AnimatedModelRenderer fin;
    private final AnimatedModelRenderer tailbase;
    private final AnimatedModelRenderer head;
    private final AnimatedModelRenderer tail;
    private final AnimatedModelRenderer tail2;

    public SeahorseModel()
    {
        textureWidth = 32;
        textureHeight = 32;
        body = new AnimatedModelRenderer(this);
        body.setRotationPoint(0.5F, 16.5F, 0.5F);
        body.setTextureOffset(0, 0).addBox(-2.0F, 0.3966F, -0.9478F, 3.0F, 4.0F, 3.0F, 0.0F, false);
        body.setModelRendererName("body");
        this.registerModelRenderer(body);

        fin = new AnimatedModelRenderer(this);
        fin.setRotationPoint(-0.5F, 2.9F, 2.0F);
        body.addChild(fin);
        fin.setTextureOffset(0, 10).addBox(0.0F, -1.5F, 0.0F, 0.0F, 3.0F, 2.0F, 0.0F, false);
        fin.setModelRendererName("fin");
        this.registerModelRenderer(fin);

        tailbase = new AnimatedModelRenderer(this);
        tailbase.setRotationPoint(-0.5F, 4.0F, 0.7F);
        body.addChild(tailbase);
        setRotationAngle(tailbase, -0.2618F, 0.0F, 0.0F);
        tailbase.setTextureOffset(10, 5).addBox(-1.0F, 0.1053F, -1.1066F, 2.0F, 2.0F, 2.0F, 0.0F, false);
        tailbase.setModelRendererName("tailbase");
        this.registerModelRenderer(tailbase);

        head = new AnimatedModelRenderer(this);
        head.setRotationPoint(0.0F, 17.5F, 0.9F);
        setRotationAngle(head, 0.3054F, 0.0F, 0.0F);
        head.setTextureOffset(0, 7).addBox(-1.0F, -3.9537F, -1.6993F, 2.0F, 2.0F, 3.0F, 0.0F, false);
        head.setTextureOffset(9, 0).addBox(-0.5F, -2.9547F, -3.1993F, 1.0F, 1.0F, 2.0F, 0.0F, false);
        head.setTextureOffset(8, 10).addBox(-1.0F, -1.9537F, -0.6993F, 2.0F, 3.0F, 2.0F, 0.0F, false);
        head.setTextureOffset(24, 0).addBox(0.0F, -4.9528F, -1.6918F, 0.0F, 4.0F, 4.0F, 0.0F, false);
        head.setModelRendererName("head");
        this.registerModelRenderer(head);

        tail = new AnimatedModelRenderer(this);
        tail.setRotationPoint(0.0F, 22.5F, 1.0F);
        setRotationAngle(tail, -1.0036F, 0.0F, 0.0F);
        tail.setTextureOffset(4, 12).addBox(-0.5F, 0.0F, -0.8F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        tail.setModelRendererName("tail");
        this.registerModelRenderer(tail);

        tail2 = new AnimatedModelRenderer(this);
        tail2.setRotationPoint(0.0F, 2.0F, 0.1F);
        tail.addChild(tail2);
        setRotationAngle(tail2, -0.8727F, 0.0F, 0.0F);
        tail2.setTextureOffset(15, 0).addBox(0.001F, -0.0843F, -1.9463F, 0.0F, 2.0F, 2.0F, 0.0F, false);
        tail2.setModelRendererName("tail2");
        this.registerModelRenderer(tail2);

        this.rootBones.add(body);
        this.rootBones.add(head);
        this.rootBones.add(tail);
    }


    public void setRotationAngles(SeahorseEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        setLivingAnimations(entityIn, limbSwing, limbSwingAmount, ageInTicks);
        //this.head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
        this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        body.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        head.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        tail.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        matrixStackIn.push();
        matrixStackIn.pop();

    }


    @Override
    public ResourceLocation getAnimationFileLocation()
    {
        return new ResourceLocation("pcp", "animations/seahorse.json");
    }
}