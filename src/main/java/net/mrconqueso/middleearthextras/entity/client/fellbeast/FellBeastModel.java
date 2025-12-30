package net.mrconqueso.middleearthextras.entity.client.fellbeast;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.mrconqueso.middleearthextras.MiddleEarthExtras;
import net.mrconqueso.middleearthextras.entity.custom.FellBeastEntity;

public class FellBeastModel<T extends FellBeastEntity> extends SinglePartEntityModel<T> {

    public static final EntityModelLayer FELL_BEAST = new EntityModelLayer(Identifier.of(MiddleEarthExtras.MOD_ID, "fell_beast"), "main");

    // Made with Blockbench 4.11.2
    // Exported for Minecraft version 1.17+ for Yarn
    // Paste this class into your mod and generate all required imports

    private final ModelPart fell_beast;
    private final ModelPart saddle;
    private final ModelPart head;

    public FellBeastModel(ModelPart root) {
        this.fell_beast = root.getChild("fell_beast");
        this.saddle = this.fell_beast.getChild("body").getChild("saddle");
        this.head = this.fell_beast.getChild("body")
                .getChild("spine_1").getChild("spine_2").getChild("spine_3").getChild("spine_4")
                .getChild("head");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData fell_beast = modelPartData.addChild("fell_beast", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData body = fell_beast.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -30.8338F, 4.9048F));

        ModelPartData cube_r1 = body.addChild("cube_r1", ModelPartBuilder.create().uv(43, 175).cuboid(-8.0F, -19.0F, -0.25F, 0.0F, 6.0F, 30.0F, new Dilation(0.0F))
                .uv(0, 205).cuboid(-15.0F, -13.0F, 15.75F, 14.0F, 13.0F, 14.0F, new Dilation(0.0F))
                .uv(102, 139).cuboid(-18.0F, -13.0F, -16.25F, 20.0F, 18.0F, 32.0F, new Dilation(0.0F)), ModelTransform.of(8.0F, 3.8338F, -4.9048F, -0.0873F, 0.0F, 0.0F));

        ModelPartData cube_r2 = body.addChild("cube_r2", ModelPartBuilder.create().uv(224, 243).cuboid(-6.0F, -5.0F, -1.0F, 12.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -4.7519F, -22.7244F, -0.0873F, 0.0F, 0.0F));

        ModelPartData saddle = body.addChild("saddle", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -10.5755F, -10.755F));

        ModelPartData cube_r3 = saddle.addChild("cube_r3", ModelPartBuilder.create().uv(0, 170).cuboid(-18.5F, -14.0F, -15.25F, 21.0F, 19.5F, 15.0F, new Dilation(0.0F)), ModelTransform.of(8.0F, 14.4093F, 5.8501F, -0.0873F, 0.0F, 0.0F));

        ModelPartData tail_1 = body.addChild("tail_1", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -1.4385F, 25.2718F));

        ModelPartData cube_r4 = tail_1.addChild("cube_r4", ModelPartBuilder.create().uv(160, 235).cuboid(0.0F, -11.25F, -8.0F, 0.0F, 6.0F, 15.0F, new Dilation(0.0F))
                .uv(212, 170).cuboid(-5.0F, -5.25F, -8.0F, 10.0F, 10.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 2.0F, 7.0F, -0.1745F, 0.0F, 0.0F));

        ModelPartData tail_2 = tail_1.addChild("tail_2", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 3.0255F, 14.8665F));

        ModelPartData cube_r5 = tail_2.addChild("cube_r5", ModelPartBuilder.create().uv(102, 231).cuboid(0.0F, -8.5F, -8.5F, 0.0F, 6.0F, 15.0F, new Dilation(0.0F))
                .uv(126, 220).cuboid(-4.0F, -2.5F, -8.5F, 8.0F, 8.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.0F, 6.5F, -0.3054F, 0.0F, 0.0F));

        ModelPartData tail_3 = tail_2.addChild("tail_3", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 4.8397F, 12.9473F));

        ModelPartData cube_r6 = tail_3.addChild("cube_r6", ModelPartBuilder.create().uv(192, 235).cuboid(0.0F, -8.5F, -7.5F, 0.0F, 6.0F, 15.0F, new Dilation(0.0F))
                .uv(72, 224).cuboid(-3.0F, -2.5F, -7.5F, 6.0F, 6.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.5F, 5.5F, -0.3927F, 0.0F, 0.0F));

        ModelPartData tail_4 = tail_3.addChild("tail_4", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 4.3195F, 12.243F));

        ModelPartData cube_r7 = tail_4.addChild("cube_r7", ModelPartBuilder.create().uv(230, 115).cuboid(-3.0F, -4.0F, -6.5F, 6.0F, 6.0F, 14.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 3.0F, 6.0F, -0.2618F, 0.0F, 0.0F));

        ModelPartData tail_5 = tail_4.addChild("tail_5", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 4.321F, 13.5236F));

        ModelPartData cube_r8 = tail_5.addChild("cube_r8", ModelPartBuilder.create().uv(227, 91).cuboid(-3.0F, -3.0F, -7.0F, 6.0F, 6.0F, 14.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.5F, 7.0F, -0.0873F, 0.0F, 0.0F));

        ModelPartData tail_6 = tail_5.addChild("tail_6", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.7202F, 13.9467F));

        ModelPartData cube_r9 = tail_6.addChild("cube_r9", ModelPartBuilder.create().uv(0, 139).cuboid(0.0F, -9.0F, -6.5F, 0.0F, 18.0F, 13.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0228F, 6.4569F, 0.0F, 0.0F, 1.5708F));

        ModelPartData cube_r10 = tail_6.addChild("cube_r10", ModelPartBuilder.create().uv(141, -1).cuboid(0.0F, -9.0F, -6.5F, 0.0F, 18.0F, 13.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0228F, 6.4569F, 0.0436F, 0.0F, 0.0F));

        ModelPartData cube_r11 = tail_6.addChild("cube_r11", ModelPartBuilder.create().uv(92, 140).cuboid(-3.0F, -4.0F, -7.0F, 6.0F, 6.0F, 14.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.0F, 7.0F, 0.0436F, 0.0F, 0.0F));

        ModelPartData spine_1 = body.addChild("spine_1", ModelPartBuilder.create().uv(241, 200).cuboid(-4.0F, -4.0F, -8.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F))
                .uv(121, 221).cuboid(0.0F, -10.0F, -8.0F, 0.0F, 6.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -5.1662F, -22.9048F));

        ModelPartData spine_2 = spine_1.addChild("spine_2", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -0.1523F, -7.7948F));

        ModelPartData cube_r12 = spine_2.addChild("cube_r12", ModelPartBuilder.create().uv(121, 221).cuboid(0.0F, -3.0F, -4.0F, 0.0F, 6.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -6.5765F, -4.5304F, 0.0873F, 0.0F, 0.0F));

        ModelPartData cube_r13 = spine_2.addChild("cube_r13", ModelPartBuilder.create().uv(241, 200).cuboid(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.4053F, -3.9546F, 0.0873F, 0.0F, 0.0F));

        ModelPartData spine_3 = spine_2.addChild("spine_3", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.1953F, -7.926F));

        ModelPartData cube_r14 = spine_3.addChild("cube_r14", ModelPartBuilder.create().uv(121, 221).cuboid(0.0F, -9.75F, -4.0F, 0.0F, 6.0F, 8.0F, new Dilation(0.0F))
                .uv(241, 200).cuboid(-4.0F, -3.75F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.0F, -4.0F, 0.1745F, 0.0F, 0.0F));

        ModelPartData spine_4 = spine_3.addChild("spine_4", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 1.6354F, -7.8351F));

        ModelPartData cube_r15 = spine_4.addChild("cube_r15", ModelPartBuilder.create().uv(121, 221).cuboid(0.0F, -9.5F, -4.0F, 0.0F, 6.0F, 8.0F, new Dilation(0.0F))
                .uv(241, 200).cuboid(-4.0F, -3.5F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.0F, -4.0F, 0.2618F, 0.0F, 0.0F));

        ModelPartData head = spine_4.addChild("head", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 1.7365F, -7.8481F));

        ModelPartData cube_r16 = head.addChild("cube_r16", ModelPartBuilder.create().uv(112, 116).cuboid(-5.0F, -3.75F, 4.0F, 10.0F, 10.0F, 2.0F, new Dilation(0.0F))
                .uv(212, 227).cuboid(-5.0F, -3.75F, -8.0F, 10.0F, 4.0F, 12.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.0F, -6.0F, 0.2618F, 0.0F, 0.0F));

        ModelPartData jaw = head.addChild("jaw", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 2.0887F, 0.4269F));

        ModelPartData cube_r17 = jaw.addChild("cube_r17", ModelPartBuilder.create().uv(18, 261).cuboid(-5.0F, -2.5F, -4.0F, 10.0F, 2.0F, 11.0F, new Dilation(0.0F))
                .uv(204, 208).cuboid(-6.0F, -0.5F, -5.0F, 12.0F, 6.0F, 13.0F, new Dilation(0.0F))
                .uv(77, 177).cuboid(0.0F, 5.5F, -2.0F, 0.0F, 6.0F, 12.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 4.5F, -7.0F, 0.8727F, 0.0F, 0.0F));

        ModelPartData wing_left = fell_beast.addChild("wing_left", ModelPartBuilder.create(), ModelTransform.pivot(8.0F, -37.5F, -10.75F));

        ModelPartData wing_left_1 = wing_left.addChild("wing_left_1", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData cube_r18 = wing_left_1.addChild("cube_r18", ModelPartBuilder.create().uv(114, 200).cuboid(-17.0F, -0.5F, -1.75F, 34.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(31.32F, 5.0217F, 18.4917F, 0.0873F, 1.4839F, 0.2617F));

        ModelPartData cube_r19 = wing_left_1.addChild("cube_r19", ModelPartBuilder.create().uv(112, 189).cuboid(-17.0F, -2.0F, -1.5F, 34.0F, 4.0F, 6.0F, new Dilation(0.0F))
                .uv(141, 0).cuboid(-17.0F, 0.0F, 4.5F, 31.0F, 1.0F, 30.0F, new Dilation(0.0F)), ModelTransform.of(17.0449F, 2.9164F, 0.0F, 0.0F, -0.0873F, 0.1745F));

        ModelPartData wing_left_2 = wing_left_1.addChild("wing_left_2", ModelPartBuilder.create(), ModelTransform.pivot(33.0615F, 5.7512F, 1.5631F));

        ModelPartData cube_r20 = wing_left_2.addChild("cube_r20", ModelPartBuilder.create().uv(141, 36).cuboid(-27.0F, -1.0F, -1.5F, 52.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(34.0689F, 12.3045F, 0.3621F, -3.1416F, 1.309F, -2.7925F));

        ModelPartData cube_r21 = wing_left_2.addChild("cube_r21", ModelPartBuilder.create().uv(174, 164).cuboid(-21.0F, -1.0F, 0.0F, 38.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(12.6821F, 4.5203F, -13.5631F, 0.0F, 0.6981F, 0.3491F));

        ModelPartData cube_r22 = wing_left_2.addChild("cube_r22", ModelPartBuilder.create().uv(0, 0).cuboid(-29.0F, 0.0F, -23.25F, 47.0F, 0.0F, 45.0F, new Dilation(0.0F)), ModelTransform.of(14.0F, 5.0F, 13.0F, 0.0F, -1.309F, 0.3491F));

        ModelPartData wing_left_3 = wing_left_2.addChild("wing_left_3", ModelPartBuilder.create(), ModelTransform.pivot(27.9385F, 9.7488F, -23.8131F));

        ModelPartData cube_r23 = wing_left_3.addChild("cube_r23", ModelPartBuilder.create().uv(174, 154).cuboid(-23.0F, -1.0F, -1.5F, 52.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(19.7455F, 7.5112F, 20.2928F, -3.1416F, 0.7854F, -2.7925F));

        ModelPartData cube_r24 = wing_left_3.addChild("cube_r24", ModelPartBuilder.create().uv(114, 114).cuboid(-23.0F, 0.0F, -10.0F, 46.0F, 0.0F, 24.0F, new Dilation(0.0F)), ModelTransform.of(11.0774F, 4.3562F, 27.1508F, 0.0F, -0.7854F, 0.3491F));

        ModelPartData wing_left_4 = wing_left_3.addChild("wing_left_4", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData cube_r25 = wing_left_4.addChild("cube_r25", ModelPartBuilder.create().uv(174, 159).cuboid(-22.0F, -1.0F, -1.5F, 52.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(27.0546F, 10.1714F, 6.8578F, -3.1416F, 0.2618F, -2.7925F));

        ModelPartData cube_r26 = wing_left_4.addChild("cube_r26", ModelPartBuilder.create().uv(115, 92).cuboid(-21.5F, 0.0F, -5.25F, 45.0F, 0.0F, 22.0F, new Dilation(0.0F)), ModelTransform.of(22.7931F, 8.6204F, 12.8047F, 0.0F, -0.2618F, 0.3491F));

        ModelPartData wing_left_5 = wing_left_4.addChild("wing_left_5", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, -2.0F));

        ModelPartData cube_r27 = wing_left_5.addChild("cube_r27", ModelPartBuilder.create().uv(141, 31).cuboid(-26.0F, -1.0F, -1.75F, 52.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(22.9133F, 8.6641F, -4.114F, 0.0F, 0.1745F, 0.3491F));

        ModelPartData cube_r28 = wing_left_5.addChild("cube_r28", ModelPartBuilder.create().uv(141, 46).cuboid(-23.0F, 0.0F, -7.5F, 46.0F, 0.0F, 19.0F, new Dilation(0.0F)), ModelTransform.of(27.0124F, 10.1561F, 3.8433F, 0.0F, 0.1745F, 0.3491F));

        ModelPartData left_hand = wing_left_3.addChild("left_hand", ModelPartBuilder.create(), ModelTransform.pivot(-2.1044F, -0.0776F, -0.4469F));

        ModelPartData cube_r29 = left_hand.addChild("cube_r29", ModelPartBuilder.create().uv(20, 34).cuboid(-3.0F, -2.0F, -1.25F, 6.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-0.1849F, -0.4313F, -0.5164F, 0.0F, 1.2217F, 0.3491F));

        ModelPartData left_claw = left_hand.addChild("left_claw", ModelPartBuilder.create(), ModelTransform.pivot(1.5227F, 0.1902F, -2.7401F));

        ModelPartData cube_r30 = left_claw.addChild("cube_r30", ModelPartBuilder.create().uv(0, 80).cuboid(-4.0F, -2.0F, -1.0F, 7.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-0.342F, 0.9397F, -3.5F, 0.0F, 1.5708F, 0.3491F));

        ModelPartData wing_right = fell_beast.addChild("wing_right", ModelPartBuilder.create(), ModelTransform.pivot(-8.0F, -37.5F, -10.75F));

        ModelPartData wing_right_1 = wing_right.addChild("wing_right_1", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData cube_r31 = wing_right_1.addChild("cube_r31", ModelPartBuilder.create().uv(114, 200).mirrored().cuboid(-17.0F, -0.5F, -1.75F, 34.0F, 2.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-31.32F, 5.0217F, 18.4917F, 0.0873F, -1.4839F, -0.2617F));

        ModelPartData cube_r32 = wing_right_1.addChild("cube_r32", ModelPartBuilder.create().uv(112, 189).mirrored().cuboid(-17.0F, -2.0F, -1.5F, 34.0F, 4.0F, 6.0F, new Dilation(0.0F)).mirrored(false)
                .uv(141, 0).mirrored().cuboid(-14.0F, 0.0F, 4.5F, 31.0F, 1.0F, 30.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-17.0449F, 2.9164F, 0.0F, 0.0F, 0.0873F, -0.1745F));

        ModelPartData wing_right_2 = wing_right_1.addChild("wing_right_2", ModelPartBuilder.create(), ModelTransform.pivot(-33.0615F, 5.7512F, 1.5631F));

        ModelPartData cube_r33 = wing_right_2.addChild("cube_r33", ModelPartBuilder.create().uv(141, 36).mirrored().cuboid(-25.0F, -1.0F, -1.5F, 52.0F, 2.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-34.0689F, 12.3045F, 0.3621F, -3.1416F, -1.309F, 2.7925F));

        ModelPartData cube_r34 = wing_right_2.addChild("cube_r34", ModelPartBuilder.create().uv(174, 164).mirrored().cuboid(-17.0F, -1.0F, 0.0F, 38.0F, 2.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-12.6821F, 4.5203F, -13.5631F, 0.0F, -0.6981F, -0.3491F));

        ModelPartData cube_r35 = wing_right_2.addChild("cube_r35", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-18.0F, 0.0F, -23.25F, 47.0F, 0.0F, 45.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-14.0F, 5.0F, 13.0F, 0.0F, 1.309F, -0.3491F));

        ModelPartData wing_right_3 = wing_right_2.addChild("wing_right_3", ModelPartBuilder.create(), ModelTransform.pivot(-27.9385F, 9.7488F, -23.8131F));

        ModelPartData cube_r36 = wing_right_3.addChild("cube_r36", ModelPartBuilder.create().uv(174, 154).mirrored().cuboid(-29.0F, -1.0F, -1.5F, 52.0F, 2.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-19.7455F, 7.5112F, 20.2928F, -3.1416F, -0.7854F, 2.7925F));

        ModelPartData cube_r37 = wing_right_3.addChild("cube_r37", ModelPartBuilder.create().uv(114, 114).mirrored().cuboid(-23.0F, 0.0F, -10.0F, 46.0F, 0.0F, 24.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-11.0774F, 4.3562F, 27.1508F, 0.0F, 0.7854F, -0.3491F));

        ModelPartData wing_right_4 = wing_right_3.addChild("wing_right_4", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData cube_r38 = wing_right_4.addChild("cube_r38", ModelPartBuilder.create().uv(174, 159).mirrored().cuboid(-30.0F, -1.0F, -1.5F, 52.0F, 2.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-27.0546F, 10.1714F, 6.8578F, -3.1416F, -0.2618F, 2.7925F));

        ModelPartData cube_r39 = wing_right_4.addChild("cube_r39", ModelPartBuilder.create().uv(115, 92).mirrored().cuboid(-23.5F, 0.0F, -5.25F, 45.0F, 0.0F, 22.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-22.7931F, 8.6204F, 12.8047F, 0.0F, 0.2618F, -0.3491F));

        ModelPartData wing_right_5 = wing_right_4.addChild("wing_right_5", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, -2.0F));

        ModelPartData cube_r40 = wing_right_5.addChild("cube_r40", ModelPartBuilder.create().uv(141, 31).mirrored().cuboid(-26.0F, -1.0F, -1.75F, 52.0F, 2.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-22.9133F, 8.6641F, -4.114F, 0.0F, -0.1745F, -0.3491F));

        ModelPartData cube_r41 = wing_right_5.addChild("cube_r41", ModelPartBuilder.create().uv(141, 46).mirrored().cuboid(-23.0F, 0.0F, -7.5F, 46.0F, 0.0F, 19.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-27.0124F, 10.1561F, 3.8433F, 0.0F, -0.1745F, -0.3491F));

        ModelPartData right_hand = wing_right_3.addChild("right_hand", ModelPartBuilder.create(), ModelTransform.pivot(2.1044F, -0.0776F, -0.4469F));

        ModelPartData cube_r42 = right_hand.addChild("cube_r42", ModelPartBuilder.create().uv(20, 34).mirrored().cuboid(-3.0F, -2.0F, -1.25F, 6.0F, 4.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.1849F, -0.4313F, -0.5164F, 0.0F, -1.2217F, -0.3491F));

        ModelPartData right_claw = right_hand.addChild("right_claw", ModelPartBuilder.create(), ModelTransform.pivot(-1.5227F, 0.1902F, -2.7401F));

        ModelPartData cube_r43 = right_claw.addChild("cube_r43", ModelPartBuilder.create().uv(0, 80).mirrored().cuboid(-3.0F, -2.0F, -1.0F, 7.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.342F, 0.9397F, -3.5F, 0.0F, -1.5708F, -0.3491F));

        ModelPartData leg_left = fell_beast.addChild("leg_left", ModelPartBuilder.create(), ModelTransform.pivot(6.5F, -28.7099F, 18.4428F));

        ModelPartData cube_r44 = leg_left.addChild("cube_r44", ModelPartBuilder.create().uv(0, 46).cuboid(-4.75F, -10.0F, -7.0F, 8.0F, 20.0F, 14.0F, new Dilation(0.0F)), ModelTransform.of(3.5F, 4.4599F, -2.3758F, -0.5214F, -0.0058F, -0.0974F));

        ModelPartData lower_leg_left = leg_left.addChild("lower_leg_left", ModelPartBuilder.create(), ModelTransform.pivot(3.5F, 11.8302F, -0.9315F));

        ModelPartData cube_r45 = lower_leg_left.addChild("cube_r45", ModelPartBuilder.create().uv(172, 208).cuboid(-3.0F, -4.0F, -10.0F, 6.0F, 8.0F, 20.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 6.0F, -3.0F, -2.2636F, 0.0112F, -0.1228F));

        ModelPartData foot_left = lower_leg_left.addChild("foot_left", ModelPartBuilder.create(), ModelTransform.pivot(1.0F, 13.7779F, -8.5429F));

        ModelPartData cube_r46 = foot_left.addChild("cube_r46", ModelPartBuilder.create().uv(30, 0).cuboid(-1.0F, -2.5F, -4.5F, 2.0F, 9.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.0214F, 4.1904F, 0.8727F, 0.0F, 0.0F));

        ModelPartData cube_r47 = foot_left.addChild("cube_r47", ModelPartBuilder.create().uv(68, 246).cuboid(-1.5F, -15.0F, 3.0F, 3.0F, 18.0F, 6.0F, new Dilation(0.0F))
                .uv(68, 246).cuboid(-8.5F, -15.0F, 3.0F, 3.0F, 18.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(3.5F, -5.8981F, -11.2185F, -1.5708F, 0.0F, 0.0F));

        ModelPartData leg_right = fell_beast.addChild("leg_right", ModelPartBuilder.create(), ModelTransform.pivot(-6.5F, -28.7099F, 18.4428F));

        ModelPartData cube_r48 = leg_right.addChild("cube_r48", ModelPartBuilder.create().uv(0, 46).mirrored().cuboid(-3.25F, -10.0F, -7.0F, 8.0F, 20.0F, 14.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-3.5F, 4.4599F, -2.3758F, -0.5214F, 0.0058F, 0.0974F));

        ModelPartData lower_leg_right = leg_right.addChild("lower_leg_right", ModelPartBuilder.create(), ModelTransform.pivot(-3.5F, 11.8302F, -0.9315F));

        ModelPartData cube_r49 = lower_leg_right.addChild("cube_r49", ModelPartBuilder.create().uv(172, 208).mirrored().cuboid(-3.0F, -4.0F, -10.0F, 6.0F, 8.0F, 20.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 6.0F, -3.0F, -2.2636F, -0.0112F, 0.1228F));

        ModelPartData foot_right = lower_leg_right.addChild("foot_right", ModelPartBuilder.create(), ModelTransform.pivot(-1.0F, 13.7779F, -8.5429F));

        ModelPartData cube_r50 = foot_right.addChild("cube_r50", ModelPartBuilder.create().uv(30, 0).mirrored().cuboid(-1.0F, -2.5F, -4.5F, 2.0F, 9.0F, 5.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, -0.0214F, 4.1904F, 0.8727F, 0.0F, 0.0F));

        ModelPartData cube_r51 = foot_right.addChild("cube_r51", ModelPartBuilder.create().uv(68, 246).mirrored().cuboid(-1.5F, -15.0F, 3.0F, 3.0F, 18.0F, 6.0F, new Dilation(0.0F)).mirrored(false)
                .uv(68, 246).mirrored().cuboid(5.5F, -15.0F, 3.0F, 3.0F, 18.0F, 6.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-3.5F, -5.8981F, -11.2185F, -1.5708F, 0.0F, 0.0F));
        return TexturedModelData.of(modelData, 512, 512);
    }

    @Override
    public void setAngles(FellBeastEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngles(netHeadYaw, headPitch);

        this.animateMovement(FellBeastAnimations.WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.updateAnimation(entity.idleAnimationState, FellBeastAnimations.IDLE, ageInTicks, 1f);
    }

    private void setHeadAngles(float headYaw, float headPitch) {
        headYaw = MathHelper.clamp(headYaw, -30.0f, 30.0f);
        headPitch = MathHelper.clamp(headPitch, -25.0f, 45.0f);

        float magicNumber = 0.017453292F;

        this.head.yaw = headYaw * magicNumber;
        this.head.pitch = headPitch * magicNumber;
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
        fell_beast.render(matrices, vertexConsumer, light, overlay, color);
    }

    @Override
    public ModelPart getPart() {
        return fell_beast;
    }
}
