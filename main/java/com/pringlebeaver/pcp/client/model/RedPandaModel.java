package com.pringlebeaver.pcp.client.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.pringlebeaver.pcp.entities.RedPandaEntity;
import com.sun.org.apache.xpath.internal.operations.Bool;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import software.bernie.geckolib.animation.model.AnimatedEntityModel;
import software.bernie.geckolib.animation.render.AnimatedModelRenderer;

import javax.annotation.Nullable;

public class RedPandaModel extends AnimatedEntityModel<RedPandaEntity> {

	private final AnimatedModelRenderer adult;
	private final AnimatedModelRenderer baby;
	private final AnimatedModelRenderer leg0;
	private final AnimatedModelRenderer leg1;
	private final AnimatedModelRenderer body;
	private final AnimatedModelRenderer hat;
	private final AnimatedModelRenderer head;
	private final AnimatedModelRenderer earL;
	private final AnimatedModelRenderer earR;
	private final AnimatedModelRenderer tail;
	private final AnimatedModelRenderer leg3;
	private final AnimatedModelRenderer leg2;
	private final AnimatedModelRenderer leg4;
	private final AnimatedModelRenderer leg5;
	private final AnimatedModelRenderer body2;
	private final AnimatedModelRenderer hat2;
	private final AnimatedModelRenderer head2;
	private final AnimatedModelRenderer earL2;
	private final AnimatedModelRenderer earR2;
	private final AnimatedModelRenderer tail2;
	private final AnimatedModelRenderer leg6;
	private final AnimatedModelRenderer leg7;


	public RedPandaModel() {
		textureWidth = 64;
		textureHeight = 64;
		adult = new AnimatedModelRenderer(this);
		adult.setRotationPoint(0.5F, 24.0F, -7.0F);

		adult.setModelRendererName("adult");
		this.registerModelRenderer(adult);

		leg0 = new AnimatedModelRenderer(this);
		leg0.setRotationPoint(-3.0F, -6.0F, 11.0F);
		adult.addChild(leg0);
		leg0.setTextureOffset(48, 0).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, -0.001F, false);
		leg0.setModelRendererName("leg0");
		this.registerModelRenderer(leg0);

		leg1 = new AnimatedModelRenderer(this);
		leg1.setRotationPoint(1.5F, -6.0F, 11.5F);
		adult.addChild(leg1);
		leg1.setTextureOffset(48, 0).addBox(-1.0F, 0.0F, -2.0F, 3.0F, 6.0F, 3.0F, -0.001F, false);
		leg1.setModelRendererName("leg1");
		this.registerModelRenderer(leg1);

		body = new AnimatedModelRenderer(this);
		body.setRotationPoint(-0.5F, -6.5F, 11.0F);
		adult.addChild(body);
		body.setTextureOffset(24, 13).addBox(-4.0F, -4.5F, -10.5F, 8.0F, 7.0F, 12.0F, 0.0F, false);
		body.setModelRendererName("body");
		this.registerModelRenderer(body);

		head = new AnimatedModelRenderer(this);
		head.setRotationPoint(0.0F, -0.5F, -9.5F);
		body.addChild(head);
		head.setTextureOffset(0, 0).addBox(-4.0F, -5.0F, -7.0F, 8.0F, 7.0F, 7.0F, 0.01F, false);
		head.setTextureOffset(0, 27).addBox(-2.0F, -1.0F, -9.0F, 4.0F, 3.0F, 2.0F, 0.01F, false);
		head.setModelRendererName("head");
		this.registerModelRenderer(head);

		hat = new AnimatedModelRenderer(this);
		hat.setRotationPoint(0.0F, -6.0F, -4.0F);
		head.addChild(hat);
		setRotationAngle(hat, 0.0F, -0.7854F, 0.0F);
		hat.setTextureOffset(0, 55).addBox(-3.0F, -1.5F, -3.0F, 6.0F, 3.0F, 6.0F, 0.0F, false);
		hat.setTextureOffset(0, 46).addBox(-3.0F, -1.5F, -3.0F, 6.0F, 3.0F, 6.0F, 0.25F, false);
		hat.setModelRendererName("hat");
		this.registerModelRenderer(hat);

		earL = new AnimatedModelRenderer(this);
		earL.setRotationPoint(4.0F, 0.0F, 3.0F);
		head.addChild(earL);
		setRotationAngle(earL, 0.0F, 0.0F, 0.4363F);
		earL.setTextureOffset(0, 23).addBox(-4.1131F, -6.0315F, -7.0F, 3.0F, 3.0F, 1.0F, 0.01F, true);
		earL.setModelRendererName("earL");
		this.registerModelRenderer(earL);

		earR = new AnimatedModelRenderer(this);
		earR.setRotationPoint(-4.0F, 0.0F, 3.0F);
		head.addChild(earR);
		setRotationAngle(earR, 0.0F, 0.0F, -0.4363F);
		earR.setTextureOffset(0, 23).addBox(1.1131F, -6.0315F, -7.0F, 3.0F, 3.0F, 1.0F, 0.01F, false);
		earR.setModelRendererName("earR");
		this.registerModelRenderer(earR);

		tail = new AnimatedModelRenderer(this);
		tail.setRotationPoint(0.0F, -2.5F, 1.5F);
		body.addChild(tail);
		setRotationAngle(tail, -0.4363F, 0.0F, 0.0F);
		tail.setTextureOffset(0, 32).addBox(-2.0F, -1.5468F, -0.2887F, 4.0F, 4.0F, 10.0F, 0.0F, false);
		tail.setModelRendererName("tail");
		this.registerModelRenderer(tail);

		leg3 = new AnimatedModelRenderer(this);
		leg3.setRotationPoint(-2.5F, 0.5F, -9.0F);
		body.addChild(leg3);
		leg3.setTextureOffset(48, 0).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, -0.001F, false);
		leg3.setModelRendererName("leg3");
		this.registerModelRenderer(leg3);

		leg2 = new AnimatedModelRenderer(this);
		leg2.setRotationPoint(2.5F, 0.5F, -9.0F);
		body.addChild(leg2);
		leg2.setTextureOffset(48, 0).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, -0.001F, false);
		leg2.setModelRendererName("leg2");
		this.registerModelRenderer(leg2);

		head2 = new AnimatedModelRenderer(this);
		head2.setRotationPoint(0.0F, 17.0F, -3.5F);
		head2.setTextureOffset(0, 0).addBox(-4.0F, -5.0F, -7.0F, 8.0F, 7.0F, 7.0F, 0.01F, false);
		head2.setTextureOffset(0, 27).addBox(-2.0F, -1.0F, -9.0F, 4.0F, 3.0F, 2.0F, 0.01F, false);
		head2.setModelRendererName("head2");
		this.registerModelRenderer(head2);

		hat2 = new AnimatedModelRenderer(this);
		hat2.setRotationPoint(0.0F, -6.0F, -4.0F);
		head2.addChild(hat2);
		setRotationAngle(hat2, 0.0F, -0.7854F, 0.0F);
		hat2.setTextureOffset(0, 55).addBox(-3.0F, -1.5F, -3.0F, 6.0F, 3.0F, 6.0F, 0.0F, false);
		hat2.setTextureOffset(0, 46).addBox(-3.0F, -1.5F, -3.0F, 6.0F, 3.0F, 6.0F, 0.25F, false);
		hat2.setModelRendererName("hat2");
		this.registerModelRenderer(hat2);

		earL2 = new AnimatedModelRenderer(this);
		earL2.setRotationPoint(4.0F, 0.0F, 3.0F);
		head2.addChild(earL2);
		setRotationAngle(earL2, 0.0F, 0.0F, 0.4363F);
		earL2.setTextureOffset(0, 23).addBox(-4.1131F, -6.0315F, -7.0F, 3.0F, 3.0F, 1.0F, 0.01F, true);
		earL2.setModelRendererName("earL2");
		this.registerModelRenderer(earL2);

		earR2 = new AnimatedModelRenderer(this);
		earR2.setRotationPoint(-4.0F, 0.0F, 3.0F);
		head2.addChild(earR2);
		setRotationAngle(earR2, 0.0F, 0.0F, -0.4363F);
		earR2.setTextureOffset(0, 23).addBox(1.1131F, -6.0315F, -7.0F, 3.0F, 3.0F, 1.0F, 0.01F, false);
		earR2.setModelRendererName("earR2");
		this.registerModelRenderer(earR2);

		baby = new AnimatedModelRenderer(this);
		baby.setRotationPoint(0.5F, 24.0F, -5.0F);

		baby.setModelRendererName("baby");
		this.registerModelRenderer(baby);

		leg4 = new AnimatedModelRenderer(this);
		leg4.setRotationPoint(-3.0F, -6.0F, 11.0F);
		baby.addChild(leg4);
		leg4.setTextureOffset(48, 0).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, -0.001F, false);
		leg4.setModelRendererName("leg4");
		this.registerModelRenderer(leg4);

		leg5 = new AnimatedModelRenderer(this);
		leg5.setRotationPoint(1.5F, -6.0F, 11.5F);
		baby.addChild(leg5);
		leg5.setTextureOffset(48, 0).addBox(-1.0F, 0.0F, -2.0F, 3.0F, 6.0F, 3.0F, -0.001F, false);
		leg5.setModelRendererName("leg5");
		this.registerModelRenderer(leg5);

		body2 = new AnimatedModelRenderer(this);
		body2.setRotationPoint(-0.5F, -6.5F, 11.0F);
		baby.addChild(body2);
		body2.setTextureOffset(24, 13).addBox(-4.0F, -4.5F, -10.5F, 8.0F, 7.0F, 12.0F, 0.0F, false);
		body2.setModelRendererName("body2");
		this.registerModelRenderer(body2);

		tail2 = new AnimatedModelRenderer(this);
		tail2.setRotationPoint(0.0F, -2.5F, 1.5F);
		body2.addChild(tail2);
		setRotationAngle(tail2, -0.4363F, 0.0F, 0.0F);
		tail2.setTextureOffset(0, 32).addBox(-2.0F, -1.5468F, -0.2887F, 4.0F, 4.0F, 10.0F, 0.0F, false);
		tail2.setModelRendererName("tail2");
		this.registerModelRenderer(tail2);

		leg6 = new AnimatedModelRenderer(this);
		leg6.setRotationPoint(-2.5F, 0.5F, -9.0F);
		body2.addChild(leg6);
		leg6.setTextureOffset(48, 0).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, -0.001F, false);
		leg6.setModelRendererName("leg6");
		this.registerModelRenderer(leg6);

		leg7 = new AnimatedModelRenderer(this);
		leg7.setRotationPoint(2.5F, 0.5F, -9.0F);
		body2.addChild(leg7);
		leg7.setTextureOffset(48, 0).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, -0.001F, false);
		leg7.setModelRendererName("leg7");
		this.registerModelRenderer(leg7);

		this.rootBones.add(adult);
		this.rootBones.add(head2);
		this.rootBones.add(baby);
	}

	protected Iterable<ModelRenderer> getHeadParts() {
		return ImmutableList.of(this.head);
	}

	protected Iterable<ModelRenderer> getBodyParts() {
		return ImmutableList.of(this.body, this.leg0, this.leg1, this.leg2, this.leg3, this.tail);
	}


	@Override
	public ResourceLocation getAnimationFileLocation() {
		return new ResourceLocation("pcp", "animations/red_panda.json");
	}


	@Override
	public void setLivingAnimations(RedPandaEntity entity, float limbSwing, float limbSwingAmount, float partialTick) {
		super.setLivingAnimations(entity, limbSwing, limbSwingAmount, partialTick);
		this.leg0.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.leg3.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.leg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.leg2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.tail.rotateAngleZ = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;

		this.leg5.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.leg7.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.leg4.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.leg6.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.tail2.rotateAngleZ = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;


	}

	@Override
	public void setRotationAngles(RedPandaEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		super.setRotationAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		this.head.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F);
		this.head.rotateAngleX = headPitch * ((float) Math.PI / 180F);
		this.head2.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F);
		this.head2.rotateAngleX = headPitch * ((float) Math.PI / 180F);
	}

	// baby and adult are the names of the root bones
	public void babyModel(Boolean isBaby) {

		if (isBaby) {
			this.baby.showModel = true;
			this.adult.showModel = false;
			this.head2.showModel = true;
		} else {
			this.baby.showModel = false;
			this.adult.showModel = true;
			this.head2.showModel = false;
		}

	}

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
		adult.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		baby.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);

		matrixStackIn.push();
		matrixStackIn.scale(1.5F, 1.5F, 1.5F);
		matrixStackIn.translate(0F, -0.35F, 0.075F);
		head2.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		matrixStackIn.pop();

	}
}