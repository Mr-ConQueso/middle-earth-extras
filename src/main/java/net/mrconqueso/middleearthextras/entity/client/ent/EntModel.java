package net.mrconqueso.middleearthextras.entity.client.ent;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.mrconqueso.middleearthextras.MiddleEarthExtras;
import net.mrconqueso.middleearthextras.entity.custom.EntEntity;

public class EntModel<T extends EntEntity> extends SinglePartEntityModel<T> {

    public static final EntityModelLayer ENT = new EntityModelLayer(Identifier.of(MiddleEarthExtras.MOD_ID, "ent"), "main");

    // Made with Blockbench 4.11.2
    // Exported for Minecraft version 1.17+ for Yarn
    // Paste this class into your mod and generate all required imports

    private final ModelPart ent;
    private final ModelPart head;

    public EntModel(ModelPart root) {
        this.ent = root.getChild("ent");
        this.head = this.ent.getChild("head");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData ent = modelPartData.addChild("ent", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData shoulder_right = ent.addChild("shoulder_right", ModelPartBuilder.create(), ModelTransform.pivot(-12.4156F, -82.2002F, -0.8948F));

        ModelPartData _gltfNode_1036_r1 = shoulder_right.addChild("_gltfNode_1036_r1", ModelPartBuilder.create().uv(337, 504).cuboid(-2.3F, -5.9F, 0.1F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-12.5969F, 1.0074F, 0.1172F, 0.0F, 0.0F, 3.1416F));

        ModelPartData _gltfNode_1034_r1 = shoulder_right.addChild("_gltfNode_1034_r1", ModelPartBuilder.create().uv(370, 473).cuboid(4.1678F, 3.0893F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-10.0146F, 3.5683F, 0.1172F, 0.0F, 0.0F, -2.9234F));

        ModelPartData _gltfNode_1032_r1 = shoulder_right.addChild("_gltfNode_1032_r1", ModelPartBuilder.create().uv(394, 317).cuboid(-8.9998F, 0.499F, -7.5005F, 10.0F, 0.001F, 11.0236F, new Dilation(0.0F)), ModelTransform.of(-6.6659F, -2.5381F, 0.7698F, -1.5708F, 0.0F, -1.6144F));

        ModelPartData _gltfNode_1030_r1 = shoulder_right.addChild("_gltfNode_1030_r1", ModelPartBuilder.create().uv(425, 307).cuboid(-0.9998F, -0.5F, -3.4769F, 2.0F, 1.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-6.6659F, -2.5381F, 0.2698F, -1.5708F, 0.0F, -1.6144F));

        ModelPartData _gltfNode_1020_r1 = shoulder_right.addChild("_gltfNode_1020_r1", ModelPartBuilder.create().uv(175, 190).cuboid(0.0F, -0.5F, -7.0F, 1.0F, 1.0F, 7.0F, new Dilation(0.0F))
                .uv(123, 199).cuboid(7.0001F, -0.4999F, 2.9996F, 2.0F, 1.0F, 5.0F, new Dilation(0.0F))
                .uv(148, 177).cuboid(7.0001F, -0.4999F, -2.0004F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(-9.84F, -10.4232F, 0.2698F, -1.5708F, 0.0F, -0.0873F));

        ModelPartData _gltfNode_1028_r1 = shoulder_right.addChild("_gltfNode_1028_r1", ModelPartBuilder.create().uv(143, 264).cuboid(0.0001F, -0.4999F, -4.0002F, 1.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-10.1625F, -2.3854F, 0.2698F, -1.5708F, 0.0F, -0.7854F));

        ModelPartData _gltfNode_1014_r1 = shoulder_right.addChild("_gltfNode_1014_r1", ModelPartBuilder.create().uv(0, 184).cuboid(-1.9998F, -0.9998F, -15.0006F, 2.0F, 2.0F, 7.0F, new Dilation(0.0F))
                .uv(19, 177).cuboid(-3.9998F, -0.9998F, -8.0006F, 4.0F, 2.0F, 7.9921F, new Dilation(0.0F)), ModelTransform.of(2.2934F, -1.5474F, 0.2698F, -1.5708F, 0.0F, -0.8727F));

        ModelPartData arm_right = shoulder_right.addChild("arm_right", ModelPartBuilder.create(), ModelTransform.pivot(-0.0048F, 6.7178F, 0.2723F));

        ModelPartData _gltfNode_1016_r1 = arm_right.addChild("_gltfNode_1016_r1", ModelPartBuilder.create().uv(184, 115).cuboid(1.0F, -4.5F, -6.0F, 7.0F, 5.0F, 3.0F, new Dilation(0.0F))
                .uv(0, 156).cuboid(-2.9918F, -3.9998F, -5.0002F, 18.9921F, 4.0F, 4.0F, new Dilation(0.0F))
                .uv(0, 144).cuboid(-10.0154F, -5.0077F, -3.0002F, 20.0F, 6.0F, 5.0079F, new Dilation(0.0F)), ModelTransform.of(-1.5594F, 7.295F, -2.0025F, -1.5708F, 0.0F, -1.2654F));

        ModelPartData forarm_right = arm_right.addChild("forarm_right", ModelPartBuilder.create(), ModelTransform.pivot(-6.0825F, 18.0423F, 4.3355F));

        ModelPartData _gltfNode_1054_r1 = forarm_right.addChild("_gltfNode_1054_r1", ModelPartBuilder.create().uv(370, 491).cuboid(-0.1F, -4.9F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(1.3405F, -3.6969F, 4.1048F, -1.9443F, -0.8582F, -1.0929F));

        ModelPartData _gltfNode_1052_r1 = forarm_right.addChild("_gltfNode_1052_r1", ModelPartBuilder.create().uv(71, 40).cuboid(1.0001F, -1.9999F, -5.0002F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F))
                .uv(57, 193).cuboid(1.0001F, -1.9999F, -2.0002F, 2.0F, 1.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(1.17F, -6.7636F, 4.026F, -3.1416F, 1.4399F, -1.2654F));

        ModelPartData _gltfNode_1048_r1 = forarm_right.addChild("_gltfNode_1048_r1", ModelPartBuilder.create().uv(165, 264).cuboid(-0.9999F, -1.9999F, -10.0003F, 1.0F, 1.0F, 4.0F, new Dilation(0.0F))
                .uv(191, 32).cuboid(-1.9999F, -1.9999F, -6.0003F, 2.0F, 1.0F, 6.0157F, new Dilation(0.0F)), ModelTransform.of(0.9574F, -6.0892F, 3.3189F, -3.1416F, 0.7854F, -1.2654F));

        ModelPartData _gltfNode_1040_r1 = forarm_right.addChild("_gltfNode_1040_r1", ModelPartBuilder.create().uv(187, 6).cuboid(-0.9998F, -2.4999F, -10.0002F, 3.0F, 2.0F, 6.0F, new Dilation(0.0F))
                .uv(67, 182).cuboid(0.0F, -3.0F, -7.0F, 3.0F, 3.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-1.5942F, 2.0033F, -2.338F, -3.1416F, 0.7854F, -1.2654F));

        ModelPartData _gltfNode_1042_r1 = forarm_right.addChild("_gltfNode_1042_r1", ModelPartBuilder.create().uv(158, 190).cuboid(5.9846F, -3.9998F, -3.0002F, 4.0F, 4.9921F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-1.491F, 8.327F, -6.338F, -1.5708F, 0.0F, -1.2654F));

        ModelPartData _gltfNode_1060_r1 = forarm_right.addChild("_gltfNode_1060_r1", ModelPartBuilder.create().uv(414, 484).cuboid(-0.3333F, -4.3181F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-10.7184F, -1.3978F, -4.4906F, 0.0F, 0.0F, -1.2654F));

        ModelPartData _gltfNode_1064_r1 = forarm_right.addChild("_gltfNode_1064_r1", ModelPartBuilder.create().uv(359, 503).cuboid(5.4831F, 25.0491F, 0.3F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-6.5096F, -23.7528F, -4.4906F, 0.0F, 0.0F, 0.2182F));

        ModelPartData _gltfNode_1062_r1 = forarm_right.addChild("_gltfNode_1062_r1", ModelPartBuilder.create().uv(348, 474).cuboid(-0.5F, -5.1F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-9.9226F, 15.6784F, -4.4906F, 0.5819F, 0.2755F, -1.074F));

        ModelPartData _gltfNode_1058_r1 = forarm_right.addChild("_gltfNode_1058_r1", ModelPartBuilder.create().uv(319, 336).cuboid(-15.0F, -2.001F, -12.0F, 27.0F, 0.001F, 10.0F, new Dilation(0.0F)), ModelTransform.of(-3.6475F, 11.8412F, -6.338F, -1.5708F, 0.0F, -1.2654F));

        ModelPartData _gltfNode_1056_r1 = forarm_right.addChild("_gltfNode_1056_r1", ModelPartBuilder.create().uv(0, 135).cuboid(-14.9918F, -3.9998F, -3.0002F, 24.9763F, 4.9921F, 3.0079F, new Dilation(0.0F)), ModelTransform.of(-2.6938F, 12.1419F, -6.338F, -1.5708F, 0.0F, -1.2654F));

        ModelPartData hand_right = forarm_right.addChild("hand_right", ModelPartBuilder.create(), ModelTransform.pivot(-8.6353F, 27.9085F, -5.3564F));

        ModelPartData _gltfNode_1078_r1 = hand_right.addChild("_gltfNode_1078_r1", ModelPartBuilder.create().uv(193, 169).cuboid(-2.9918F, 0.0002F, -3.0002F, 5.9842F, 2.0F, 3.0079F, new Dilation(0.0F)), ModelTransform.of(-0.2861F, 7.0288F, -0.743F, -1.5708F, -0.0873F, -1.6581F));

        ModelPartData _gltfNode_1084_r1 = hand_right.addChild("_gltfNode_1084_r1", ModelPartBuilder.create().uv(199, 138).cuboid(-7.9997F, 0.0002F, -3.0002F, 5.0079F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(264, 193).cuboid(-3.9999F, 0.5001F, -4.0002F, 3.0F, 1.0F, 2.0F, new Dilation(0.0F))
                .uv(162, 170).cuboid(-14.0F, 0.999F, -4.0F, 11.0F, 0.001F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-1.8944F, 6.4263F, -0.6783F, -1.5373F, -0.0806F, -2.0521F));

        ModelPartData _gltfNode_1068_r1 = hand_right.addChild("_gltfNode_1068_r1", ModelPartBuilder.create().uv(189, 96).cuboid(-2.9918F, -1.9998F, -3.0002F, 6.9921F, 2.0F, 3.0079F, new Dilation(0.0F)), ModelTransform.of(-0.5976F, 7.9122F, -0.4778F, -1.5708F, 0.0F, -1.6565F));

        ModelPartData _gltfNode_1074_r1 = hand_right.addChild("_gltfNode_1074_r1", ModelPartBuilder.create().uv(264, 185).cuboid(-3.9998F, -1.4999F, -4.0002F, 3.0F, 1.0F, 2.0F, new Dilation(0.0F))
                .uv(0, 200).cuboid(-7.9997F, -1.9998F, -3.0002F, 5.0079F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(168, 141).cuboid(-13.9991F, -1.001F, -4.0003F, 11.0F, 0.001F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-2.2051F, 7.3043F, -0.4778F, -1.5708F, 0.0F, -2.0492F));

        ModelPartData _gltfNode_1066_r1 = hand_right.addChild("_gltfNode_1066_r1", ModelPartBuilder.create().uv(181, 151).cuboid(2.9924F, -5.0077F, -3.0002F, 6.9921F, 7.0079F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-1.5761F, 8.0763F, -0.9816F, -1.5708F, 0.0F, -1.2654F));

        ModelPartData _gltfNode_1100_r1 = hand_right.addChild("_gltfNode_1100_r1", ModelPartBuilder.create().uv(199, 88).cuboid(-7.4496F, -0.8605F, 3.1591F, 7.0F, 6.0F, 0.001F, new Dilation(0.0F))
                .uv(91, 193).cuboid(-1.4497F, 1.1395F, 2.1591F, 6.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-1.3225F, 6.847F, -4.794F, -0.4605F, -0.2512F, -2.0428F));

        ModelPartData _gltfNode_1088_r1 = hand_right.addChild("_gltfNode_1088_r1", ModelPartBuilder.create().uv(19, 194).cuboid(-2.9918F, -1.9998F, -3.0002F, 5.9842F, 2.0F, 3.0079F, new Dilation(0.0F)), ModelTransform.of(-0.2861F, 7.0288F, 1.7799F, -1.5708F, 0.0873F, -1.6581F));

        ModelPartData _gltfNode_1094_r1 = hand_right.addChild("_gltfNode_1094_r1", ModelPartBuilder.create().uv(259, 160).cuboid(-3.9998F, -1.4999F, -4.0002F, 3.0F, 1.0F, 2.0F, new Dilation(0.0F))
                .uv(199, 143).cuboid(-7.9997F, -1.9998F, -3.0002F, 5.0079F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(168, 131).cuboid(-13.9992F, -1.001F, -4.0003F, 11.0F, 0.001F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-1.8944F, 6.4263F, 1.7151F, -1.6043F, 0.0806F, -2.0521F));

        ModelPartData shoulder_left = ent.addChild("shoulder_left", ModelPartBuilder.create().uv(190, 102).cuboid(-7.2155F, -14.284F, -2.1082F, 8.0F, 9.0F, 0.001F, new Dilation(0.0F)), ModelTransform.pivot(12.2155F, -75.716F, 1.1082F));

        ModelPartData _gltfNode_939_r1 = shoulder_left.addChild("_gltfNode_939_r1", ModelPartBuilder.create().uv(400, 289).cuboid(-9.0F, -2.001F, -7.0F, 8.0F, 0.001F, 7.0F, new Dilation(0.0F)), ModelTransform.of(7.4866F, 5.7243F, -3.7332F, -1.5708F, 0.0F, 1.2654F));

        ModelPartData _gltfNode_941_r1 = shoulder_left.addChild("_gltfNode_941_r1", ModelPartBuilder.create().uv(496, 316).cuboid(-4.6157F, -4.5051F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(10.2147F, -2.9159F, -1.8857F, 0.0F, 0.0F, 1.9199F));

        ModelPartData _gltfNode_943_r1 = shoulder_left.addChild("_gltfNode_943_r1", ModelPartBuilder.create().uv(359, 497).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(11.0652F, 3.1071F, -1.8857F, 0.0F, 0.0F, -2.9234F));

        ModelPartData _gltfNode_937_r1 = shoulder_left.addChild("_gltfNode_937_r1", ModelPartBuilder.create().uv(190, 112).cuboid(-5.9712F, -0.5F, -0.0007F, 7.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(7.2721F, -19.8971F, -1.7332F, -1.5708F, 0.0F, 1.6581F));

        ModelPartData _gltfNode_445_r1 = shoulder_left.addChild("_gltfNode_445_r1", ModelPartBuilder.create().uv(15, 200).cuboid(9.0035F, -3.0995F, -1.0002F, 5.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(171, 184).cuboid(-0.0123F, -3.0995F, -1.0002F, 9.0158F, 3.0079F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.7259F, -10.9139F, -1.1082F, 0.0F, 0.0F, -0.9599F));

        ModelPartData _gltfNode_933_r1 = shoulder_left.addChild("_gltfNode_933_r1", ModelPartBuilder.create().uv(108, 203).cuboid(-5.9929F, -1.0F, -0.4645F, 6.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(10.5705F, -10.7662F, -2.2332F, -1.5708F, 0.7854F, 2.8362F));

        ModelPartData _gltfNode_927_r1 = shoulder_left.addChild("_gltfNode_927_r1", ModelPartBuilder.create().uv(199, 124).cuboid(-5.8929F, -0.5F, -2.1645F, 6.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(4.7331F, -9.6597F, -1.7332F, -1.5708F, 0.0F, 2.8362F));

        ModelPartData _gltfNode_925_r1 = shoulder_left.addChild("_gltfNode_925_r1", ModelPartBuilder.create().uv(193, 40).cuboid(-0.5F, -1.0F, -6.6F, 6.0F, 2.0F, 3.0F, new Dilation(0.0F))
                .uv(156, 96).cuboid(-7.5F, -1.0F, -1.6F, 12.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(1.2705F, -10.665F, -1.7332F, -1.5708F, 0.0F, 2.0508F));

        ModelPartData _gltfNode_931_r1 = shoulder_left.addChild("_gltfNode_931_r1", ModelPartBuilder.create().uv(162, 53).cuboid(-17.4282F, -0.9999F, -0.1859F, 9.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(187, 58).cuboid(-8.4282F, -0.9999F, -0.1859F, 9.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(5.79F, -16.2841F, -1.7332F, -1.5708F, 0.0F, 2.4435F));

        ModelPartData _gltfNode_441_r1 = shoulder_left.addChild("_gltfNode_441_r1", ModelPartBuilder.create().uv(44, 173).cuboid(0.0007F, -3.9997F, -2.0003F, 9.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-7.9767F, -8.4572F, -1.1082F, 0.0F, 0.0F, -0.1745F));

        ModelPartData _gltfNode_921_r1 = shoulder_left.addChild("_gltfNode_921_r1", ModelPartBuilder.create().uv(156, 85).cuboid(-16.0F, -4.0F, -6.0F, 15.0F, 4.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(1.7643F, 7.5286F, -3.7332F, -1.5708F, 0.0F, 1.2654F));

        ModelPartData _gltfNode_949_r1 = shoulder_left.addChild("_gltfNode_949_r1", ModelPartBuilder.create().uv(154, 264).cuboid(0.0001F, -1.9999F, -10.0003F, 1.0F, 1.0F, 4.0F, new Dilation(0.0F))
                .uv(191, 24).cuboid(0.0001F, -1.9999F, -6.0003F, 2.0F, 1.0F, 6.0157F, new Dilation(0.0F)), ModelTransform.of(5.33F, 12.1867F, 5.9237F, -3.1416F, -0.7854F, 1.2654F));

        ModelPartData _gltfNode_955_r1 = shoulder_left.addChild("_gltfNode_955_r1", ModelPartBuilder.create().uv(187, 15).cuboid(-1.9999F, -2.4999F, -10.0002F, 3.0F, 2.0F, 6.0F, new Dilation(0.0F))
                .uv(88, 182).cuboid(-3.0F, -3.0F, -7.0F, 3.0F, 3.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(7.8816F, 20.2793F, 0.2668F, -3.1416F, -0.7854F, 1.2654F));

        ModelPartData _gltfNode_953_r1 = shoulder_left.addChild("_gltfNode_953_r1", ModelPartBuilder.create().uv(216, 146).cuboid(-1.9999F, -1.9999F, -5.0002F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F))
                .uv(74, 193).cuboid(-2.9999F, -1.9999F, -2.0002F, 2.0F, 1.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(5.1174F, 11.5123F, 6.6308F, -3.1416F, -1.4399F, 1.2654F));

        ModelPartData arm_left = shoulder_left.addChild("arm_left", ModelPartBuilder.create(), ModelTransform.pivot(-0.4391F, 0.575F, 7.0644F));

        ModelPartData _gltfNode_961_r1 = arm_left.addChild("_gltfNode_961_r1", ModelPartBuilder.create().uv(348, 492).cuboid(-4.8996F, -4.8996F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(5.3861F, 14.004F, -0.3548F, -1.9443F, 0.8582F, 1.0929F));

        ModelPartData _gltfNode_959_r1 = arm_left.addChild("_gltfNode_959_r1", ModelPartBuilder.create().uv(282, 486).cuboid(-4.8996F, -4.8996F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(2.3861F, 6.004F, 5.6452F, -1.3019F, -0.7001F, 1.1667F));

        ModelPartData _gltfNode_935_r1 = arm_left.addChild("_gltfNode_935_r1", ModelPartBuilder.create().uv(139, 103).cuboid(-10.0154F, -5.0077F, -3.0002F, 20.0F, 6.0F, 5.0079F, new Dilation(0.0F)), ModelTransform.of(2.2034F, 6.9535F, -10.7976F, -1.5708F, 0.0F, 1.2654F));

        ModelPartData forearm_left = arm_left.addChild("forearm_left", ModelPartBuilder.create(), ModelTransform.pivot(6.4424F, 17.6801F, -9.4407F));

        ModelPartData _gltfNode_969_r1 = forearm_left.addChild("_gltfNode_969_r1", ModelPartBuilder.create().uv(469, 461).cuboid(-4.5F, -5.1F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(10.2067F, 15.6992F, 0.4905F, 0.5819F, -0.2755F, 1.074F));

        ModelPartData _gltfNode_967_r1 = forearm_left.addChild("_gltfNode_967_r1", ModelPartBuilder.create().uv(436, 486).cuboid(-4.6667F, -4.3181F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(11.0026F, -1.3769F, 0.4905F, 0.0F, 0.0F, 1.2654F));

        ModelPartData _gltfNode_965_r1 = forearm_left.addChild("_gltfNode_965_r1", ModelPartBuilder.create().uv(319, 325).cuboid(-12.0F, -2.001F, -12.0F, 27.0F, 0.001F, 10.0F, new Dilation(0.0F)), ModelTransform.of(3.9317F, 11.862F, -1.3569F, -1.5708F, 0.0F, 1.2654F));

        ModelPartData _gltfNode_957_r1 = forearm_left.addChild("_gltfNode_957_r1", ModelPartBuilder.create().uv(141, 190).cuboid(-10.0154F, -3.9998F, -3.0002F, 4.0F, 4.9921F, 4.0F, new Dilation(0.0F)), ModelTransform.of(1.7751F, 8.3479F, -1.3569F, -1.5708F, 0.0F, 1.2654F));

        ModelPartData _gltfNode_963_r1 = forearm_left.addChild("_gltfNode_963_r1", ModelPartBuilder.create().uv(127, 117).cuboid(-10.0154F, -3.9998F, -3.0002F, 25.0078F, 4.9921F, 3.0079F, new Dilation(0.0F)), ModelTransform.of(2.9779F, 12.1627F, -1.3569F, -1.5708F, 0.0F, 1.2654F));

        ModelPartData hand_left = forearm_left.addChild("hand_left", ModelPartBuilder.create(), ModelTransform.pivot(8.9189F, 27.9288F, -0.3753F));

        ModelPartData _gltfNode_999_r1 = hand_left.addChild("_gltfNode_999_r1", ModelPartBuilder.create().uv(187, 264).cuboid(1.0001F, -1.4999F, -4.0002F, 3.0F, 1.0F, 2.0F, new Dilation(0.0F))
                .uv(199, 133).cuboid(2.9925F, -1.9998F, -3.0002F, 5.0079F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(168, 126).cuboid(3.0008F, -1.001F, -4.0003F, 11.0F, 0.001F, 4.0F, new Dilation(0.0F)), ModelTransform.of(1.8949F, 6.4267F, 1.7151F, -1.6043F, -0.0806F, 2.0521F));

        ModelPartData _gltfNode_993_r1 = hand_left.addChild("_gltfNode_993_r1", ModelPartBuilder.create().uv(0, 194).cuboid(-2.9918F, -1.9998F, -3.0002F, 5.9842F, 2.0F, 3.0079F, new Dilation(0.0F)), ModelTransform.of(0.2866F, 7.0293F, 1.7799F, -1.5708F, -0.0873F, 1.6581F));

        ModelPartData _gltfNode_989_r1 = hand_left.addChild("_gltfNode_989_r1", ModelPartBuilder.create().uv(264, 189).cuboid(1.0001F, 0.5001F, -4.0002F, 3.0F, 1.0F, 2.0F, new Dilation(0.0F))
                .uv(199, 128).cuboid(2.9925F, 0.0002F, -3.0002F, 5.0079F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(168, 146).cuboid(3.0F, 0.999F, -4.0F, 11.0F, 0.001F, 4.0F, new Dilation(0.0F)), ModelTransform.of(1.8949F, 6.4267F, -0.6783F, -1.5373F, 0.0806F, 2.0521F));

        ModelPartData _gltfNode_983_r1 = hand_left.addChild("_gltfNode_983_r1", ModelPartBuilder.create().uv(193, 46).cuboid(-2.9918F, 0.0002F, -3.0002F, 5.9842F, 2.0F, 3.0079F, new Dilation(0.0F)), ModelTransform.of(0.2866F, 7.0293F, -0.7431F, -1.5708F, 0.0873F, 1.6581F));

        ModelPartData _gltfNode_979_r1 = hand_left.addChild("_gltfNode_979_r1", ModelPartBuilder.create().uv(264, 216).cuboid(1.0001F, -1.4999F, -4.0002F, 3.0F, 1.0F, 2.0F, new Dilation(0.0F))
                .uv(175, 199).cuboid(2.9924F, -1.9998F, -3.0002F, 5.0079F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(168, 136).cuboid(3.0008F, -1.001F, -4.0003F, 11.0F, 0.001F, 4.0F, new Dilation(0.0F)), ModelTransform.of(2.2056F, 7.3048F, -0.4778F, -1.5708F, 0.0F, 2.0492F));

        ModelPartData _gltfNode_973_r1 = hand_left.addChild("_gltfNode_973_r1", ModelPartBuilder.create().uv(19, 188).cuboid(-3.9997F, -1.9998F, -3.0002F, 6.9921F, 2.0F, 3.0079F, new Dilation(0.0F)), ModelTransform.of(0.5981F, 7.9127F, -0.4778F, -1.5708F, 0.0F, 1.6565F));

        ModelPartData _gltfNode_971_r1 = hand_left.addChild("_gltfNode_971_r1", ModelPartBuilder.create().uv(125, 177).cuboid(-10.0154F, -5.0077F, -3.0002F, 7.0236F, 7.0079F, 4.0F, new Dilation(0.0F)), ModelTransform.of(1.5766F, 8.0768F, -0.9816F, -1.5708F, 0.0F, 1.2654F));

        ModelPartData _gltfNode_1005_r1 = hand_left.addChild("_gltfNode_1005_r1", ModelPartBuilder.create().uv(199, 81).cuboid(0.4497F, -0.8605F, 3.1591F, 7.0F, 6.0F, 0.001F, new Dilation(0.0F))
                .uv(194, 182).cuboid(-4.5504F, 1.1395F, 2.1591F, 6.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(1.323F, 6.8475F, -4.794F, -0.4605F, 0.2512F, 2.0428F));

        ModelPartData leg_right = ent.addChild("leg_right", ModelPartBuilder.create().uv(57, 143).cuboid(-3.1667F, -1.1667F, -5.0F, 7.0F, 19.0F, 10.0F, new Dilation(0.0F))
                .uv(127, 151).cuboid(-4.1667F, 17.8333F, -5.0F, 8.0F, 16.0F, 9.0F, new Dilation(0.0F))
                .uv(0, 102).cuboid(-5.1667F, 33.8334F, -5.0F, 10.0F, 20.0F, 11.0F, new Dilation(0.0F)), ModelTransform.pivot(-5.8333F, -53.8333F, -0.2F));

        ModelPartData leg_left = ent.addChild("leg_left", ModelPartBuilder.create().uv(43, 103).cuboid(-4.8333F, 33.8334F, -5.0F, 10.0F, 20.0F, 11.0F, new Dilation(0.0F))
                .uv(152, 0).cuboid(-3.8333F, 17.8333F, -5.0F, 8.0F, 16.0F, 9.0F, new Dilation(0.0F))
                .uv(92, 143).cuboid(-3.8333F, -1.1667F, -5.0F, 7.0F, 19.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(5.8333F, -53.8333F, -0.2F));

        ModelPartData body = ent.addChild("body", ModelPartBuilder.create().uv(127, 126).cuboid(-4.9995F, -13.6532F, -5.0005F, 10.0F, 13.9843F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0003F, -56.3306F, -0.0003F));

        ModelPartData chest = body.addChild("chest", ModelPartBuilder.create(), ModelTransform.pivot(-0.0003F, -15.6694F, 0.0003F));

        ModelPartData _gltfNode_17_r1 = chest.addChild("_gltfNode_17_r1", ModelPartBuilder.create().uv(81, 56).cuboid(-10.0F, -6.0F, -6.0F, 20.0F, 12.0F, 12.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

        ModelPartData pelvis = body.addChild("pelvis", ModelPartBuilder.create().uv(162, 26).cuboid(-2.0F, -1.25F, -5.0F, 4.0F, 8.0F, 10.0F, new Dilation(0.0F))
                .uv(86, 103).cuboid(-8.0F, -4.25F, -5.0F, 16.0F, 3.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(-0.0003F, 4.5806F, 0.0003F));

        ModelPartData head = ent.addChild("head", ModelPartBuilder.create().uv(146, 56).cuboid(-4.7962F, 0.615F, -5.8341F, 10.0F, 6.0F, 10.0F, new Dilation(0.0F))
                .uv(86, 117).cuboid(-4.797F, -14.3855F, -5.8333F, 10.0F, 15.0F, 10.0F, new Dilation(0.0F))
                .uv(146, 73).cuboid(-0.897F, -7.4855F, -7.9333F, 2.2F, 5.2F, 2.2F, new Dilation(0.0F))
                .uv(187, 53).cuboid(-4.797F, -7.3855F, -6.8333F, 10.0F, 3.0F, 1.0F, new Dilation(0.0F))
                .uv(109, 182).cuboid(-2.797F, -25.3855F, -5.8333F, 6.0F, 11.0F, 1.0F, new Dilation(0.0F))
                .uv(108, 195).cuboid(-2.797F, -20.3855F, 3.1667F, 6.0F, 6.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-0.203F, -80.6145F, 0.8333F));

        ModelPartData _gltfNode_453_r1 = head.addChild("_gltfNode_453_r1", ModelPartBuilder.create().uv(153, 200).cuboid(9.0034F, -3.0996F, -1.0001F, 5.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(181, 163).cuboid(-0.0123F, -3.0996F, -1.0001F, 9.0158F, 3.0079F, 2.0F, new Dilation(0.0F)), ModelTransform.of(6.1024F, -7.1083F, 9.3207F, 1.0956F, -0.3931F, -1.0708F));

        ModelPartData _gltfNode_109_r1 = head.addChild("_gltfNode_109_r1", ModelPartBuilder.create().uv(187, 0).cuboid(-0.0123F, -3.0996F, -1.0002F, 9.0157F, 3.0079F, 2.0F, new Dilation(0.0F))
                .uv(51, 201).cuboid(9.0034F, -3.0996F, -1.0002F, 5.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(12.303F, -12.9855F, -0.8333F, 0.0F, 0.0F, -1.3526F));

        ModelPartData _gltfNode_107_r1 = head.addChild("_gltfNode_107_r1", ModelPartBuilder.create().uv(71, 173).cuboid(0.0007F, -3.9997F, -2.0003F, 9.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(5.203F, -7.3855F, -0.8333F, 0.0F, 0.0F, -0.5672F));

        ModelPartData _gltfNode_55_r1 = head.addChild("_gltfNode_55_r1", ModelPartBuilder.create().uv(192, 198).cuboid(-3.0F, 1.5F, -3.0F, 6.0F, 3.0F, 2.0F, new Dilation(0.0F))
                .uv(44, 168).cuboid(-2.0F, 4.5F, -3.0F, 4.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.203F, 9.1145F, -5.8333F, -0.3054F, 0.0F, 0.0F));

        ModelPartData _gltfNode_51_r1 = head.addChild("_gltfNode_51_r1", ModelPartBuilder.create().uv(44, 182).cuboid(-3.9999F, -3.4999F, -2.0002F, 8.0F, 5.0F, 3.0079F, new Dilation(0.0F))
                .uv(19, 165).cuboid(-3.9999F, 1.5001F, -2.9923F, 8.0F, 7.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.203F, 2.1145F, -5.8333F, -0.3054F, 0.0F, 0.0F));

        ModelPartData _gltfNode_845_r1 = head.addChild("_gltfNode_845_r1", ModelPartBuilder.create().uv(176, 264).cuboid(-0.4998F, -0.8999F, -1.0002F, 3.0F, 1.0F, 2.0F, new Dilation(0.0F))
                .uv(260, 114).cuboid(-0.4998F, -0.8999F, -0.0002F, 3.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(14.2149F, -24.3439F, -1.8333F, 0.0F, 0.0F, -0.3927F));

        ModelPartData _gltfNode_615_r1 = head.addChild("_gltfNode_615_r1", ModelPartBuilder.create().uv(138, 200).cuboid(-14.0184F, -3.0996F, -1.0001F, 5.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(148, 184).cuboid(-9.0184F, -3.0996F, -1.0001F, 9.0158F, 3.0079F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-5.6964F, -7.1083F, 9.3207F, 1.0956F, 0.3931F, 1.0708F));

        ModelPartData _gltfNode_37_r1 = head.addChild("_gltfNode_37_r1", ModelPartBuilder.create().uv(205, 121).cuboid(-1.4999F, -0.7999F, 8.5099F, 3.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(75, 201).cuboid(-1.4999F, -7.7999F, 8.5099F, 3.0F, 8.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 165).cuboid(0.5001F, -9.7999F, 0.5099F, 1.0F, 10.0F, 8.0F, new Dilation(0.0F))
                .uv(47, 156).cuboid(-1.4999F, -9.7999F, -0.4901F, 3.0F, 10.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(3.703F, -14.3855F, -5.3333F, 0.0F, 0.0F, 0.1309F));

        ModelPartData _gltfNode_617_r1 = head.addChild("_gltfNode_617_r1", ModelPartBuilder.create().uv(57, 138).cuboid(-6.499F, -0.4999F, -0.5001F, 13.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-8.6722F, -16.8563F, 12.67F, 1.0873F, 0.5215F, 1.3443F));

        ModelPartData _gltfNode_613_r1 = head.addChild("_gltfNode_613_r1", ModelPartBuilder.create().uv(162, 175).cuboid(-8.9993F, -3.9997F, -2.0003F, 9.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-1.797F, -7.3855F, 1.1667F, 0.0F, 1.1345F, -0.3054F));

        ModelPartData _gltfNode_455_r1 = head.addChild("_gltfNode_455_r1", ModelPartBuilder.create().uv(57, 135).cuboid(-6.499F, -0.4999F, -0.5001F, 13.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(9.0782F, -16.8563F, 12.67F, 1.0873F, -0.5215F, -1.3443F));

        ModelPartData _gltfNode_449_r1 = head.addChild("_gltfNode_449_r1", ModelPartBuilder.create().uv(98, 173).cuboid(0.0007F, -3.9997F, -2.0003F, 9.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(2.203F, -7.3855F, 1.1667F, 0.0F, -1.1345F, 0.3054F));

        ModelPartData _gltfNode_284_r1 = head.addChild("_gltfNode_284_r1", ModelPartBuilder.create().uv(199, 148).cuboid(-6.9428F, -1.0113F, -0.5F, 7.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-11.1787F, -19.6882F, -0.3333F, 0.0F, 0.0F, 1.3526F));

        ModelPartData _gltfNode_282_r1 = head.addChild("_gltfNode_282_r1", ModelPartBuilder.create().uv(30, 200).cuboid(-18.0F, -5.0F, -1.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(84, 204).cuboid(-20.9999F, -0.9999F, -1.0001F, 6.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(51, 144).cuboid(-15.9999F, -5.9999F, -1.0001F, 1.0F, 5.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.5603F, -4.5482F, 0.1667F, 0.0F, 0.0F, 0.7418F));

        ModelPartData _gltfNode_276_r1 = head.addChild("_gltfNode_276_r1", ModelPartBuilder.create().uv(91, 199).cuboid(-6.0F, -2.0F, -1.0F, 6.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-9.9576F, -10.6055F, -0.8333F, -0.0012F, 0.0491F, 1.1766F));

        ModelPartData _gltfNode_274_r1 = head.addChild("_gltfNode_274_r1", ModelPartBuilder.create().uv(189, 175).cuboid(-11.0F, -4.0F, -2.0F, 6.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-0.5603F, -4.5482F, -0.8333F, 0.0F, 0.0F, 0.3927F));

        ModelPartData _gltfNode_29_r1 = head.addChild("_gltfNode_29_r1", ModelPartBuilder.create().uv(71, 28).cuboid(-1.4999F, -9.7999F, -0.4901F, 3.0F, 10.0F, 1.0F, new Dilation(0.0F))
                .uv(162, 151).cuboid(-1.4999F, -9.7999F, 0.5099F, 1.0F, 10.0F, 8.0F, new Dilation(0.0F))
                .uv(66, 201).cuboid(-1.4999F, -7.7999F, 8.5099F, 3.0F, 8.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-3.297F, -14.3855F, -5.3333F, 0.0F, 0.0F, -0.1309F));

        ModelPartData beard = head.addChild("beard", ModelPartBuilder.create(), ModelTransform.pivot(0.2038F, 4.9428F, -9.9208F));

        ModelPartData _gltfNode_89_r1 = beard.addChild("_gltfNode_89_r1", ModelPartBuilder.create().uv(304, 497).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(3.2941F, -3.1653F, 2.2875F, -0.0908F, 0.2007F, 1.6591F));

        ModelPartData _gltfNode_87_r1 = beard.addChild("_gltfNode_87_r1", ModelPartBuilder.create().uv(271, 488).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(3.2941F, -2.3653F, 0.7875F, -0.4151F, 0.4886F, 1.7446F));

        ModelPartData _gltfNode_85_r1 = beard.addChild("_gltfNode_85_r1", ModelPartBuilder.create().uv(494, 280).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(0.0044F, 2.8347F, 0.0875F, 0.2194F, -0.2143F, -2.7289F));

        ModelPartData _gltfNode_83_r1 = beard.addChild("_gltfNode_83_r1", ModelPartBuilder.create().uv(271, 500).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-0.0059F, 2.8347F, 0.0875F, 0.2194F, 0.2143F, 2.7289F));

        ModelPartData _gltfNode_81_r1 = beard.addChild("_gltfNode_81_r1", ModelPartBuilder.create().uv(359, 473).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-0.0059F, 4.8347F, 0.0875F, 0.2194F, 0.2143F, 2.3799F));

        ModelPartData _gltfNode_79_r1 = beard.addChild("_gltfNode_79_r1", ModelPartBuilder.create().uv(468, 419).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-0.0059F, 7.9347F, 0.1875F, 0.0F, 0.0F, 2.3562F));

        ModelPartData _gltfNode_77_r1 = beard.addChild("_gltfNode_77_r1", ModelPartBuilder.create().uv(491, 485).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(4.5044F, 2.7347F, 0.3875F, 0.0556F, -0.1186F, -1.7923F));

        ModelPartData _gltfNode_75_r1 = beard.addChild("_gltfNode_75_r1", ModelPartBuilder.create().uv(491, 479).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-4.5059F, 2.7347F, 0.3875F, 0.0556F, 0.1186F, 1.7923F));

        ModelPartData _gltfNode_73_r1 = beard.addChild("_gltfNode_73_r1", ModelPartBuilder.create().uv(238, 503).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(2.4941F, 5.7347F, 0.3875F, 0.0F, 0.0F, 2.2253F));

        ModelPartData _gltfNode_71_r1 = beard.addChild("_gltfNode_71_r1", ModelPartBuilder.create().uv(425, 502).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-2.4956F, 5.7347F, 0.3875F, 0.0F, 0.0F, -2.2253F));

        ModelPartData _gltfNode_69_r1 = beard.addChild("_gltfNode_69_r1", ModelPartBuilder.create().uv(482, 424).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(1.4044F, -0.7653F, 0.3875F, 0.4481F, -0.3114F, -2.4534F));

        ModelPartData _gltfNode_67_r1 = beard.addChild("_gltfNode_67_r1", ModelPartBuilder.create().uv(293, 491).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-0.5956F, -1.6653F, 0.5875F, 0.2853F, -0.412F, -2.0869F));

        ModelPartData _gltfNode_65_r1 = beard.addChild("_gltfNode_65_r1", ModelPartBuilder.create().uv(249, 491).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(1.4941F, 1.7347F, -0.3125F, 0.2853F, 0.412F, 2.0869F));

        ModelPartData _gltfNode_63_r1 = beard.addChild("_gltfNode_63_r1", ModelPartBuilder.create().uv(260, 491).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-1.4956F, 1.7347F, -0.3125F, 0.2853F, -0.412F, -2.0869F));

        ModelPartData _gltfNode_61_r1 = beard.addChild("_gltfNode_61_r1", ModelPartBuilder.create().uv(425, 490).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(3.7941F, 0.4347F, 1.8875F, 0.0328F, 0.5485F, 1.9259F));

        ModelPartData _gltfNode_59_r1 = beard.addChild("_gltfNode_59_r1", ModelPartBuilder.create().uv(293, 497).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-3.2956F, -3.1653F, 2.2875F, -0.0908F, -0.2007F, -1.6591F));

        ModelPartData _gltfNode_57_r1 = beard.addChild("_gltfNode_57_r1", ModelPartBuilder.create().uv(481, 328).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-3.2956F, -2.3653F, 0.7875F, -0.4151F, -0.4886F, -1.7446F));

        ModelPartData _gltfNode_49_r1 = beard.addChild("_gltfNode_49_r1", ModelPartBuilder.create().uv(414, 490).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-3.7956F, 0.4347F, 1.8875F, 0.0328F, -0.5485F, -1.9259F));

        ModelPartData brows = head.addChild("brows", ModelPartBuilder.create().uv(362, 433).cuboid(-13.1819F, -5.353F, 4.1603F, 8.0F, 9.0F, 0.001F, new Dilation(0.0F)), ModelTransform.pivot(0.3849F, -4.0325F, -5.9936F));

        ModelPartData _gltfNode_271_r1 = brows.addChild("_gltfNode_271_r1", ModelPartBuilder.create().uv(437, 316).cuboid(-0.9941F, -6.9044F, -0.0646F, 6.0F, 8.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-1.2755F, 0.675F, -0.5915F, 0.2302F, 0.1589F, 3.1051F));

        ModelPartData _gltfNode_269_r1 = brows.addChild("_gltfNode_269_r1", ModelPartBuilder.create().uv(276, 443).cuboid(-5.0059F, -6.9044F, -0.0646F, 6.0F, 8.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(0.9117F, 0.675F, -0.5915F, 0.2302F, -0.1589F, -3.1051F));

        ModelPartData _gltfNode_105_r1 = brows.addChild("_gltfNode_105_r1", ModelPartBuilder.create().uv(432, 466).cuboid(-2.4996F, -2.4996F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-7.896F, 1.3995F, 0.0273F, 0.3695F, 0.3272F, 0.1238F));

        ModelPartData _gltfNode_103_r1 = brows.addChild("_gltfNode_103_r1", ModelPartBuilder.create().uv(483, 443).cuboid(-2.4996F, -2.4996F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(6.5322F, -1.8004F, -0.0727F, 0.3185F, -0.3035F, -2.4053F));

        ModelPartData _gltfNode_101_r1 = brows.addChild("_gltfNode_101_r1", ModelPartBuilder.create().uv(492, 292).cuboid(-2.4996F, -2.4996F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(9.5322F, -1.2005F, -0.0727F, 0.3361F, -0.2071F, -1.0388F));

        ModelPartData _gltfNode_99_r1 = brows.addChild("_gltfNode_99_r1", ModelPartBuilder.create().uv(421, 466).cuboid(-2.4996F, -2.4996F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(7.5322F, 1.3995F, 0.0273F, 0.3695F, -0.3272F, -0.1238F));

        ModelPartData _gltfNode_97_r1 = brows.addChild("_gltfNode_97_r1", ModelPartBuilder.create().uv(483, 411).cuboid(-2.4996F, -2.4996F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-6.896F, -1.8004F, -0.0727F, 0.3185F, 0.3035F, 2.4053F));

        ModelPartData _gltfNode_95_r1 = brows.addChild("_gltfNode_95_r1", ModelPartBuilder.create().uv(282, 498).cuboid(-2.4996F, -2.4996F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-9.896F, -1.2005F, -0.0727F, 0.3361F, 0.2071F, 1.0388F));

        ModelPartData _gltfNode_93_r1 = brows.addChild("_gltfNode_93_r1", ModelPartBuilder.create().uv(430, 434).cuboid(-1.0F, -3.5F, 0.0F, 8.0F, 7.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(2.8181F, -2.553F, -0.3397F, 0.0F, 0.0F, 0.3491F));

        ModelPartData _gltfNode_31_r1 = brows.addChild("_gltfNode_31_r1", ModelPartBuilder.create().uv(278, 435).cuboid(-7.0F, -3.5F, 0.0F, 8.0F, 7.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-3.1819F, -2.553F, -0.3397F, 0.0F, 0.0F, -0.3491F));

        ModelPartData leaves = head.addChild("leaves", ModelPartBuilder.create(), ModelTransform.pivot(0.2469F, -14.8555F, 9.1608F));

        ModelPartData _gltfNode_1038_r1 = leaves.addChild("_gltfNode_1038_r1", ModelPartBuilder.create().uv(464, 449).cuboid(-1.0151F, -4.1264F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-24.9564F, 7.4771F, -10.7717F, 0.0F, 0.0F, -0.7854F));

        ModelPartData _gltfNode_915_r1 = leaves.addChild("_gltfNode_915_r1", ModelPartBuilder.create().uv(491, 430).cuboid(-4.6157F, -4.5051F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(21.3986F, -12.6554F, -11.1941F, 1.201F, 0.7882F, -2.2103F));

        ModelPartData _gltfNode_913_r1 = leaves.addChild("_gltfNode_913_r1", ModelPartBuilder.create().uv(487, 467).cuboid(-4.6157F, -4.5051F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(23.3362F, -18.8114F, -14.1941F, 0.1379F, 0.2886F, 3.1264F));

        ModelPartData _gltfNode_911_r1 = leaves.addChild("_gltfNode_911_r1", ModelPartBuilder.create().uv(370, 497).cuboid(-4.6157F, -4.5051F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(22.462F, -14.6973F, -6.0941F, -2.334F, -0.0574F, -1.7827F));

        ModelPartData _gltfNode_909_r1 = leaves.addChild("_gltfNode_909_r1", ModelPartBuilder.create().uv(487, 356).cuboid(-4.6157F, -4.5051F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(23.9532F, -20.88F, -18.9941F, 3.0298F, 0.4894F, -2.2143F));

        ModelPartData _gltfNode_907_r1 = leaves.addChild("_gltfNode_907_r1", ModelPartBuilder.create().uv(487, 350).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(21.2986F, -12.4822F, -18.9941F, 3.0298F, 0.4894F, -2.2143F));

        ModelPartData _gltfNode_905_r1 = leaves.addChild("_gltfNode_905_r1", ModelPartBuilder.create().uv(392, 502).cuboid(-4.6157F, -4.5051F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(21.7986F, -13.3482F, -8.9941F, 3.0298F, 0.4894F, -2.6943F));

        ModelPartData _gltfNode_903_r1 = leaves.addChild("_gltfNode_903_r1", ModelPartBuilder.create().uv(447, 492).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(24.8166F, -22.5755F, -12.9941F, -2.6015F, 0.168F, -1.9286F));

        ModelPartData _gltfNode_901_r1 = leaves.addChild("_gltfNode_901_r1", ModelPartBuilder.create().uv(489, 334).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(23.8362F, -19.6774F, -6.9941F, -2.334F, -0.0574F, -1.9136F));

        ModelPartData _gltfNode_898_r1 = leaves.addChild("_gltfNode_898_r1", ModelPartBuilder.create().uv(501, 415).cuboid(-0.606F, -3.9543F, -0.8042F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(7.7263F, -12.8465F, -10.5941F, 1.201F, -0.7882F, 1.2503F));

        ModelPartData _gltfNode_896_r1 = leaves.addChild("_gltfNode_896_r1", ModelPartBuilder.create().uv(468, 268).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(1.5723F, -14.7902F, -13.5941F, 0.1379F, -0.2886F, 2.1969F));

        ModelPartData _gltfNode_894_r1 = leaves.addChild("_gltfNode_894_r1", ModelPartBuilder.create().uv(474, 381).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(5.4438F, -13.1466F, -5.4941F, -2.334F, 0.0574F, 0.8228F));

        ModelPartData _gltfNode_892_r1 = leaves.addChild("_gltfNode_892_r1", ModelPartBuilder.create().uv(326, 474).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-0.4761F, -15.4714F, -18.3941F, 3.0298F, -0.4894F, 1.2544F));

        ModelPartData _gltfNode_890_r1 = leaves.addChild("_gltfNode_890_r1", ModelPartBuilder.create().uv(337, 474).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(7.9255F, -12.829F, -18.3941F, 3.0298F, -0.4894F, 1.2544F));

        ModelPartData _gltfNode_888_r1 = leaves.addChild("_gltfNode_888_r1", ModelPartBuilder.create().uv(304, 491).cuboid(-0.3835F, -4.5051F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(6.9294F, -12.9162F, -8.3941F, 3.0298F, -0.4894F, 1.7344F));

        ModelPartData _gltfNode_886_r1 = leaves.addChild("_gltfNode_886_r1", ModelPartBuilder.create().uv(467, 349).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-2.3602F, -15.7366F, -12.3941F, -2.6015F, -0.168F, 0.9687F));

        ModelPartData _gltfNode_884_r1 = leaves.addChild("_gltfNode_884_r1", ModelPartBuilder.create().uv(472, 412).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(0.5761F, -14.8774F, -6.3941F, -2.334F, 0.0574F, 0.9537F));

        ModelPartData _gltfNode_881_r1 = leaves.addChild("_gltfNode_881_r1", ModelPartBuilder.create().uv(249, 485).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-0.9239F, -25.9774F, -18.3941F, 3.0298F, -0.4894F, 2.7379F));

        ModelPartData _gltfNode_879_r1 = leaves.addChild("_gltfNode_879_r1", ModelPartBuilder.create().uv(477, 250).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-0.8239F, -27.8774F, -12.3941F, -2.6015F, -0.168F, 2.4522F));

        ModelPartData _gltfNode_877_r1 = leaves.addChild("_gltfNode_877_r1", ModelPartBuilder.create().uv(238, 485).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-2.8239F, -17.3774F, -18.3941F, 3.0298F, -0.4894F, 2.7379F));

        ModelPartData _gltfNode_875_r1 = leaves.addChild("_gltfNode_875_r1", ModelPartBuilder.create().uv(488, 262).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-2.8239F, -18.3774F, -8.3941F, 3.0298F, -0.4894F, -3.0653F));

        ModelPartData _gltfNode_873_r1 = leaves.addChild("_gltfNode_873_r1", ModelPartBuilder.create().uv(403, 490).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-2.7239F, -19.8774F, -5.4941F, -2.334F, 0.0574F, 2.3063F));

        ModelPartData _gltfNode_871_r1 = leaves.addChild("_gltfNode_871_r1", ModelPartBuilder.create().uv(486, 403).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-2.8239F, -17.5774F, -10.5941F, 1.201F, -0.7882F, 2.7339F));

        ModelPartData _gltfNode_869_r1 = leaves.addChild("_gltfNode_869_r1", ModelPartBuilder.create().uv(425, 484).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-1.4239F, -23.8774F, -13.5941F, 0.1379F, -0.2886F, -2.6028F));

        ModelPartData _gltfNode_867_r1 = leaves.addChild("_gltfNode_867_r1", ModelPartBuilder.create().uv(315, 487).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-1.4239F, -24.8774F, -6.3941F, -2.334F, 0.0574F, 2.4372F));

        ModelPartData _gltfNode_865_r1 = leaves.addChild("_gltfNode_865_r1", ModelPartBuilder.create().uv(282, 480).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(0.0761F, -24.8774F, -0.9941F, -0.2178F, -0.2332F, -2.2125F));

        ModelPartData _gltfNode_863_r1 = leaves.addChild("_gltfNode_863_r1", ModelPartBuilder.create().uv(483, 310).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(3.0761F, -23.3774F, -0.9941F, -0.0275F, -0.3166F, -2.8883F));

        ModelPartData _gltfNode_861_r1 = leaves.addChild("_gltfNode_861_r1", ModelPartBuilder.create().uv(483, 304).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(8.0761F, -13.8774F, -0.9941F, -0.0275F, -0.3166F, -2.8883F));

        ModelPartData _gltfNode_859_r1 = leaves.addChild("_gltfNode_859_r1", ModelPartBuilder.create().uv(475, 449).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(14.5362F, -12.4774F, -0.9941F, -0.5207F, 0.0751F, -2.7509F));

        ModelPartData _gltfNode_857_r1 = leaves.addChild("_gltfNode_857_r1", ModelPartBuilder.create().uv(460, 425).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-2.8239F, -16.5774F, -0.9941F, -0.0552F, 0.0198F, -2.8909F));

        ModelPartData _gltfNode_855_r1 = leaves.addChild("_gltfNode_855_r1", ModelPartBuilder.create().uv(238, 479).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(18.8362F, -13.3774F, -0.9941F, -0.2865F, 0.1761F, -3.0563F));

        ModelPartData _gltfNode_853_r1 = leaves.addChild("_gltfNode_853_r1", ModelPartBuilder.create().uv(370, 479).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(6.3362F, -20.2774F, -0.9941F, -0.2178F, 0.2332F, 2.2125F));

        ModelPartData _gltfNode_851_r1 = leaves.addChild("_gltfNode_851_r1", ModelPartBuilder.create().uv(474, 322).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(15.3362F, -20.1774F, -0.9941F, -0.2178F, 0.2332F, 2.2125F));

        ModelPartData _gltfNode_849_r1 = leaves.addChild("_gltfNode_849_r1", ModelPartBuilder.create().uv(493, 423).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(2.5761F, -17.2774F, -0.9941F, 0.0582F, -0.3125F, 3.1196F));

        ModelPartData _gltfNode_847_r1 = leaves.addChild("_gltfNode_847_r1", ModelPartBuilder.create().uv(499, 256).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(9.3362F, -14.5774F, -0.9941F, 0.0135F, 0.3203F, -2.8441F));

        ModelPartData _gltfNode_843_r1 = leaves.addChild("_gltfNode_843_r1", ModelPartBuilder.create().uv(486, 449).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(19.0362F, -16.7774F, -0.9941F, -0.4825F, 0.4001F, 2.6728F));

        ModelPartData _gltfNode_841_r1 = leaves.addChild("_gltfNode_841_r1", ModelPartBuilder.create().uv(475, 399).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(4.5761F, -23.7774F, -0.9941F, -0.2993F, -0.1081F, -1.7419F));

        ModelPartData _gltfNode_839_r1 = leaves.addChild("_gltfNode_839_r1", ModelPartBuilder.create().uv(359, 491).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(22.1362F, -21.8774F, -0.9941F, -0.2277F, 0.2235F, 2.1689F));

        ModelPartData _gltfNode_837_r1 = leaves.addChild("_gltfNode_837_r1", ModelPartBuilder.create().uv(475, 393).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(1.2761F, -28.5774F, -0.9941F, -0.2993F, -0.1081F, -1.7419F));

        ModelPartData _gltfNode_835_r1 = leaves.addChild("_gltfNode_835_r1", ModelPartBuilder.create().uv(315, 481).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(9.3362F, -26.7774F, -0.9941F, -0.2993F, 0.1081F, 1.7419F));

        ModelPartData _gltfNode_832_r1 = leaves.addChild("_gltfNode_832_r1", ModelPartBuilder.create().uv(472, 443).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(18.8362F, -13.3774F, -19.9941F, 0.2865F, -0.1761F, -3.0563F));

        ModelPartData _gltfNode_830_r1 = leaves.addChild("_gltfNode_830_r1", ModelPartBuilder.create().uv(469, 480).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(1.2761F, -28.5774F, -19.9941F, 0.2993F, 0.1081F, -1.7419F));

        ModelPartData _gltfNode_828_r1 = leaves.addChild("_gltfNode_828_r1", ModelPartBuilder.create().uv(485, 322).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(22.1362F, -21.8774F, -19.9941F, 0.2277F, -0.2235F, 2.1689F));

        ModelPartData _gltfNode_826_r1 = leaves.addChild("_gltfNode_826_r1", ModelPartBuilder.create().uv(499, 250).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(9.3362F, -14.5774F, -19.9941F, -0.0135F, -0.3203F, -2.8441F));

        ModelPartData _gltfNode_824_r1 = leaves.addChild("_gltfNode_824_r1", ModelPartBuilder.create().uv(315, 499).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(2.5761F, -17.2774F, -19.9941F, -0.0582F, 0.3125F, 3.1196F));

        ModelPartData _gltfNode_822_r1 = leaves.addChild("_gltfNode_822_r1", ModelPartBuilder.create().uv(474, 316).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(15.3362F, -20.1774F, -19.9941F, 0.2178F, -0.2332F, 2.2125F));

        ModelPartData _gltfNode_820_r1 = leaves.addChild("_gltfNode_820_r1", ModelPartBuilder.create().uv(458, 480).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(4.5761F, -23.7774F, -19.9941F, 0.2993F, 0.1081F, -1.7419F));

        ModelPartData _gltfNode_818_r1 = leaves.addChild("_gltfNode_818_r1", ModelPartBuilder.create().uv(447, 480).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(9.3362F, -26.7774F, -19.9941F, 0.2993F, -0.1081F, 1.7419F));

        ModelPartData _gltfNode_816_r1 = leaves.addChild("_gltfNode_816_r1", ModelPartBuilder.create().uv(410, 466).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-2.8239F, -16.5774F, -19.9941F, 0.0552F, -0.0198F, -2.8909F));

        ModelPartData _gltfNode_814_r1 = leaves.addChild("_gltfNode_814_r1", ModelPartBuilder.create().uv(475, 405).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(14.5362F, -12.4774F, -19.9941F, 0.5207F, -0.0751F, -2.7509F));

        ModelPartData _gltfNode_812_r1 = leaves.addChild("_gltfNode_812_r1", ModelPartBuilder.create().uv(483, 286).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(8.0761F, -13.8774F, -19.9941F, 0.0275F, 0.3166F, -2.8883F));

        ModelPartData _gltfNode_810_r1 = leaves.addChild("_gltfNode_810_r1", ModelPartBuilder.create().uv(436, 492).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(19.0362F, -16.7774F, -19.9941F, 0.4825F, -0.4001F, 2.6728F));

        ModelPartData _gltfNode_808_r1 = leaves.addChild("_gltfNode_808_r1", ModelPartBuilder.create().uv(483, 280).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(3.0761F, -23.3774F, -19.9941F, 0.0275F, 0.3166F, -2.8883F));

        ModelPartData _gltfNode_806_r1 = leaves.addChild("_gltfNode_806_r1", ModelPartBuilder.create().uv(359, 479).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(6.3362F, -20.2774F, -19.9941F, 0.2178F, -0.2332F, 2.2125F));

        ModelPartData _gltfNode_804_r1 = leaves.addChild("_gltfNode_804_r1", ModelPartBuilder.create().uv(304, 479).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(0.0761F, -24.8774F, -19.9941F, 0.2178F, 0.2332F, -2.2125F));

        ModelPartData _gltfNode_799_r1 = leaves.addChild("_gltfNode_799_r1", ModelPartBuilder.create().uv(485, 316).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(7.1362F, -28.8774F, -13.2941F, -2.1694F, -0.7707F, 3.0507F));

        ModelPartData _gltfNode_797_r1 = leaves.addChild("_gltfNode_797_r1", ModelPartBuilder.create().uv(238, 491).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(13.7362F, -27.2774F, -14.7941F, 1.0544F, 0.5287F, 2.6711F));

        ModelPartData _gltfNode_795_r1 = leaves.addChild("_gltfNode_795_r1", ModelPartBuilder.create().uv(474, 375).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(13.7362F, -27.2774F, -12.1941F, -2.1029F, -0.0877F, 2.9168F));

        ModelPartData _gltfNode_793_r1 = leaves.addChild("_gltfNode_793_r1", ModelPartBuilder.create().uv(455, 256).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(7.5761F, -28.2774F, -12.7941F, -1.8748F, 0.411F, -2.4931F));

        ModelPartData _gltfNode_791_r1 = leaves.addChild("_gltfNode_791_r1", ModelPartBuilder.create().uv(455, 262).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(23.5761F, -25.2774F, -9.4941F, -1.8748F, 0.411F, -2.4931F));

        ModelPartData _gltfNode_789_r1 = leaves.addChild("_gltfNode_789_r1", ModelPartBuilder.create().uv(348, 498).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(9.2761F, -28.3774F, -4.3941F, -1.589F, 0.865F, -2.5795F));

        ModelPartData _gltfNode_787_r1 = leaves.addChild("_gltfNode_787_r1", ModelPartBuilder.create().uv(326, 486).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(9.2761F, -28.3774F, -16.2941F, 2.1598F, 0.3234F, -2.7684F));

        ModelPartData _gltfNode_785_r1 = leaves.addChild("_gltfNode_785_r1", ModelPartBuilder.create().uv(490, 268).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(3.2762F, -29.6774F, -14.0941F, 1.8748F, -0.411F, -2.7549F));

        ModelPartData _gltfNode_783_r1 = leaves.addChild("_gltfNode_783_r1", ModelPartBuilder.create().uv(489, 340).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(3.2762F, -29.6774F, -5.8941F, -1.8748F, 0.411F, -2.7549F));

        ModelPartData _gltfNode_781_r1 = leaves.addChild("_gltfNode_781_r1", ModelPartBuilder.create().uv(491, 461).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(18.3362F, -25.7774F, -5.1941F, -1.6752F, -0.2641F, 2.5721F));

        ModelPartData _gltfNode_779_r1 = leaves.addChild("_gltfNode_779_r1", ModelPartBuilder.create().uv(491, 436).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(18.3362F, -25.7774F, -18.2941F, 1.6752F, 0.2641F, 2.5721F));

        ModelPartData _gltfNode_777_r1 = leaves.addChild("_gltfNode_777_r1", ModelPartBuilder.create().uv(0, 0).cuboid(13.003F, -19.0919F, -10.0F, 16.0F, 26.0001F, 19.0F, new Dilation(0.0F)), ModelTransform.of(12.0561F, 1.87F, -9.9941F, 0.0F, 0.0F, -1.3526F));

        ModelPartData _gltfNode_773_r1 = leaves.addChild("_gltfNode_773_r1", ModelPartBuilder.create().uv(450, 444).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-14.0844F, -16.0943F, 9.9302F, -2.8363F, -0.8812F, -2.3564F));

        ModelPartData _gltfNode_771_r1 = leaves.addChild("_gltfNode_771_r1", ModelPartBuilder.create().uv(238, 461).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-22.1655F, -14.361F, 7.5448F, -2.3036F, -0.4013F, 2.6953F));

        ModelPartData _gltfNode_769_r1 = leaves.addChild("_gltfNode_769_r1", ModelPartBuilder.create().uv(315, 493).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-6.5473F, -16.7437F, 12.8001F, -1.953F, 0.3501F, 2.8677F));

        ModelPartData _gltfNode_767_r1 = leaves.addChild("_gltfNode_767_r1", ModelPartBuilder.create().uv(443, 468).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-12.2463F, -9.8145F, 14.9233F, -2.2387F, 0.1068F, 2.2733F));

        ModelPartData _gltfNode_765_r1 = leaves.addChild("_gltfNode_765_r1", ModelPartBuilder.create().uv(377, 467).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-22.7353F, -10.157F, 10.0985F, -2.272F, -0.3026F, 2.6037F));

        ModelPartData _gltfNode_763_r1 = leaves.addChild("_gltfNode_763_r1", ModelPartBuilder.create().uv(260, 479).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-18.3928F, -4.8786F, 15.5212F, 2.2528F, 1.2456F, 0.1085F));

        ModelPartData _gltfNode_761_r1 = leaves.addChild("_gltfNode_761_r1", ModelPartBuilder.create().uv(481, 292).cuboid(-0.3835F, -4.5051F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-6.749F, -19.9794F, 10.554F, -2.996F, -1.4114F, -2.3522F));

        ModelPartData _gltfNode_759_r1 = leaves.addChild("_gltfNode_759_r1", ModelPartBuilder.create().uv(337, 480).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-18.2585F, -13.2548F, 9.9945F, -2.3008F, -1.3555F, 3.1392F));

        ModelPartData _gltfNode_757_r1 = leaves.addChild("_gltfNode_757_r1", ModelPartBuilder.create().uv(444, 307).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-13.2936F, -19.4104F, 8.3214F, 2.381F, -0.8396F, -2.0508F));

        ModelPartData _gltfNode_755_r1 = leaves.addChild("_gltfNode_755_r1", ModelPartBuilder.create().uv(425, 460).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-8.9779F, -6.4676F, 10.3996F, -2.8529F, 0.7288F, 0.448F));

        ModelPartData _gltfNode_753_r1 = leaves.addChild("_gltfNode_753_r1", ModelPartBuilder.create().uv(458, 486).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-2.741F, -11.7904F, 9.5833F, -2.3908F, -0.7423F, -2.4829F));

        ModelPartData _gltfNode_751_r1 = leaves.addChild("_gltfNode_751_r1", ModelPartBuilder.create().uv(447, 462).cuboid(-0.3835F, -4.5051F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-15.9336F, 2.723F, 8.3628F, -2.8161F, 0.7835F, 0.9938F));

        ModelPartData _gltfNode_749_r1 = leaves.addChild("_gltfNode_749_r1", ModelPartBuilder.create().uv(476, 473).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-11.79F, -8.949F, 15.1886F, -1.6943F, 0.0397F, 2.1412F));

        ModelPartData _gltfNode_747_r1 = leaves.addChild("_gltfNode_747_r1", ModelPartBuilder.create().uv(472, 280).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-16.0966F, -2.0193F, 12.805F, -1.4569F, 0.207F, 1.6756F));

        ModelPartData _gltfNode_745_r1 = leaves.addChild("_gltfNode_745_r1", ModelPartBuilder.create().uv(461, 286).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(0.1429F, -10.9974F, 6.2585F, -3.0974F, -0.7894F, -2.2069F));

        ModelPartData _gltfNode_743_r1 = leaves.addChild("_gltfNode_743_r1", ModelPartBuilder.create().uv(238, 467).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-6.709F, -5.9633F, 7.8922F, -2.9682F, -0.6904F, -1.8669F));

        ModelPartData _gltfNode_741_r1 = leaves.addChild("_gltfNode_741_r1", ModelPartBuilder.create().uv(271, 452).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-7.8957F, -10.6455F, 13.2053F, -2.6602F, -0.7601F, -2.2613F));

        ModelPartData _gltfNode_739_r1 = leaves.addChild("_gltfNode_739_r1", ModelPartBuilder.create().uv(480, 485).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-5.8863F, -12.4417F, 13.0159F, -1.753F, -0.2295F, 2.7369F));

        ModelPartData _gltfNode_737_r1 = leaves.addChild("_gltfNode_737_r1", ModelPartBuilder.create().uv(355, 456).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-10.1552F, -8.7985F, 13.5747F, -1.9254F, 0.5021F, 1.6653F));

        ModelPartData _gltfNode_735_r1 = leaves.addChild("_gltfNode_735_r1", ModelPartBuilder.create().uv(442, 401).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-11.9563F, -0.7527F, 7.9159F, -2.2936F, 0.7702F, 0.8767F));

        ModelPartData _gltfNode_733_r1 = leaves.addChild("_gltfNode_733_r1", ModelPartBuilder.create().uv(446, 419).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-3.8311F, -9.3143F, 8.326F, -2.5674F, -0.7537F, -2.1F));

        ModelPartData _gltfNode_731_r1 = leaves.addChild("_gltfNode_731_r1", ModelPartBuilder.create().uv(333, 456).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-13.669F, -3.3589F, 11.8241F, -1.9064F, 0.6655F, 1.3772F));

        ModelPartData _gltfNode_729_r1 = leaves.addChild("_gltfNode_729_r1", ModelPartBuilder.create().uv(457, 419).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-15.9375F, 1.0992F, 9.8369F, -1.671F, 0.4748F, 1.7217F));

        ModelPartData _gltfNode_727_r1 = leaves.addChild("_gltfNode_727_r1", ModelPartBuilder.create().uv(403, 460).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-1.4852F, -14.7334F, 11.1136F, -2.1434F, -0.7498F, -2.6356F));

        ModelPartData _gltfNode_725_r1 = leaves.addChild("_gltfNode_725_r1", ModelPartBuilder.create().uv(403, 484).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-17.6142F, -2.3512F, 14.4773F, -2.2731F, -0.1851F, 1.6631F));

        ModelPartData _gltfNode_723_r1 = leaves.addChild("_gltfNode_723_r1", ModelPartBuilder.create().uv(399, 472).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-17.9943F, -15.5024F, 0.4238F, 2.2093F, 1.0042F, 0.3069F));

        ModelPartData _gltfNode_721_r1 = leaves.addChild("_gltfNode_721_r1", ModelPartBuilder.create().uv(436, 480).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-11.7575F, -20.8252F, -0.3925F, 2.6467F, -1.0605F, -2.5486F));

        ModelPartData _gltfNode_719_r1 = leaves.addChild("_gltfNode_719_r1", ModelPartBuilder.create().uv(466, 298).cuboid(-0.3835F, -4.5051F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-24.9501F, -6.3117F, -1.613F, -3.0863F, 1.0033F, 1.0612F));

        ModelPartData _gltfNode_717_r1 = leaves.addChild("_gltfNode_717_r1", ModelPartBuilder.create().uv(477, 262).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-20.8064F, -17.9838F, 5.2128F, -2.7768F, 0.2192F, 2.3707F));

        ModelPartData _gltfNode_715_r1 = leaves.addChild("_gltfNode_715_r1", ModelPartBuilder.create().uv(293, 485).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-25.113F, -11.0541F, 2.8292F, -3.1095F, 0.705F, 2.2909F));

        ModelPartData _gltfNode_713_r1 = leaves.addChild("_gltfNode_713_r1", ModelPartBuilder.create().uv(461, 443).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-8.8736F, -20.0322F, -3.7173F, 2.8241F, -1.0111F, -2.158F));

        ModelPartData _gltfNode_711_r1 = leaves.addChild("_gltfNode_711_r1", ModelPartBuilder.create().uv(399, 466).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-15.7254F, -14.998F, -2.0836F, 2.0659F, -0.952F, -1.6819F));

        ModelPartData _gltfNode_709_r1 = leaves.addChild("_gltfNode_709_r1", ModelPartBuilder.create().uv(444, 256).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-16.9121F, -19.6802F, 3.2295F, 2.4767F, -1.0485F, -2.2185F));

        ModelPartData _gltfNode_707_r1 = leaves.addChild("_gltfNode_707_r1", ModelPartBuilder.create().uv(472, 310).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-14.9027F, -21.4765F, 3.0401F, -2.7907F, -0.4172F, 2.5038F));

        ModelPartData _gltfNode_705_r1 = leaves.addChild("_gltfNode_705_r1", ModelPartBuilder.create().uv(454, 364).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-19.1716F, -17.8332F, 3.5989F, -2.9018F, 0.7195F, 1.9002F));

        ModelPartData _gltfNode_703_r1 = leaves.addChild("_gltfNode_703_r1", ModelPartBuilder.create().uv(449, 425).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-20.9728F, -9.7875F, -2.0599F, 2.4669F, 1.039F, 0.9143F));

        ModelPartData _gltfNode_701_r1 = leaves.addChild("_gltfNode_701_r1", ModelPartBuilder.create().uv(387, 449).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-12.8476F, -18.3491F, -1.6498F, 2.0838F, -1.0159F, -1.9983F));

        ModelPartData _gltfNode_699_r1 = leaves.addChild("_gltfNode_699_r1", ModelPartBuilder.create().uv(249, 461).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-22.6854F, -12.3937F, 1.8483F, 2.9599F, 0.8996F, 1.5682F));

        ModelPartData _gltfNode_697_r1 = leaves.addChild("_gltfNode_697_r1", ModelPartBuilder.create().uv(421, 472).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-24.9539F, -7.9356F, -0.1389F, -3.1034F, 0.6723F, 1.9414F));

        ModelPartData _gltfNode_695_r1 = leaves.addChild("_gltfNode_695_r1", ModelPartBuilder.create().uv(450, 313).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-10.5017F, -23.7682F, 1.1378F, 2.6732F, -1.0104F, -2.7462F));

        ModelPartData _gltfNode_693_r1 = leaves.addChild("_gltfNode_693_r1", ModelPartBuilder.create().uv(271, 494).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-26.6307F, -11.386F, 4.5015F, -1.9986F, 0.6013F, 2.7696F));

        ModelPartData _gltfNode_691_r1 = leaves.addChild("_gltfNode_691_r1", ModelPartBuilder.create().uv(479, 418).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-1.6195F, -17.5107F, 4.981F, -2.3831F, -0.558F, 2.8668F));

        ModelPartData _gltfNode_689_r1 = leaves.addChild("_gltfNode_689_r1", ModelPartBuilder.create().uv(366, 467).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-2.5615F, -19.5226F, 10.9025F, -2.272F, -0.3026F, 2.6037F));

        ModelPartData _gltfNode_687_r1 = leaves.addChild("_gltfNode_687_r1", ModelPartBuilder.create().uv(476, 361).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-7.5707F, -24.542F, 5.3604F, -2.1326F, -0.987F, 2.3452F));

        ModelPartData _gltfNode_685_r1 = leaves.addChild("_gltfNode_685_r1", ModelPartBuilder.create().uv(377, 461).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-5.3444F, -22.3112F, 7.8235F, -2.3087F, -0.3546F, 1.9314F));

        ModelPartData _gltfNode_683_r1 = leaves.addChild("_gltfNode_683_r1", ModelPartBuilder.create().uv(381, 484).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-3.5462F, -20.1533F, 7.4918F, -2.1593F, -0.7816F, 2.2042F));

        ModelPartData _gltfNode_681_r1 = leaves.addChild("_gltfNode_681_r1", ModelPartBuilder.create().uv(465, 357).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-3.7173F, -19.2567F, 0.3387F, -2.5449F, -0.9713F, 2.939F));

        ModelPartData _gltfNode_679_r1 = leaves.addChild("_gltfNode_679_r1", ModelPartBuilder.create().uv(466, 250).cuboid(-4.6157F, -4.5051F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-1.1059F, -17.886F, 11.3524F, -2.5781F, -0.7429F, -2.8285F));

        ModelPartData _gltfNode_677_r1 = leaves.addChild("_gltfNode_677_r1", ModelPartBuilder.create().uv(333, 462).cuboid(-4.6157F, -4.5051F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-2.0476F, -17.5836F, 2.1861F, 2.8039F, -0.973F, -2.418F));

        ModelPartData _gltfNode_675_r1 = leaves.addChild("_gltfNode_675_r1", ModelPartBuilder.create().uv(311, 455).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-5.7295F, -21.451F, -0.727F, -2.6468F, -0.3212F, 2.8113F));

        ModelPartData _gltfNode_673_r1 = leaves.addChild("_gltfNode_673_r1", ModelPartBuilder.create().uv(355, 462).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-4.5308F, -20.7839F, 4.0811F, -2.6319F, -0.767F, 2.6505F));

        ModelPartData _gltfNode_671_r1 = leaves.addChild("_gltfNode_671_r1", ModelPartBuilder.create().uv(359, 485).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(1.0778F, -14.2738F, 4.4834F, 1.6985F, -1.1382F, -0.9222F));

        ModelPartData _gltfNode_669_r1 = leaves.addChild("_gltfNode_669_r1", ModelPartBuilder.create().uv(348, 486).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-19.9667F, -1.8522F, 7.3825F, -2.2943F, 0.376F, 2.0436F));

        ModelPartData _gltfNode_667_r1 = leaves.addChild("_gltfNode_667_r1", ModelPartBuilder.create().uv(348, 468).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-20.9088F, -3.8642F, 13.304F, -2.2387F, 0.1068F, 2.2733F));

        ModelPartData _gltfNode_665_r1 = leaves.addChild("_gltfNode_665_r1", ModelPartBuilder.create().uv(485, 373).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-25.9179F, -8.8836F, 7.7619F, -2.1577F, 0.7891F, 2.5054F));

        ModelPartData _gltfNode_663_r1 = leaves.addChild("_gltfNode_663_r1", ModelPartBuilder.create().uv(454, 474).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-23.6916F, -6.6528F, 10.2251F, -2.4056F, 0.1794F, 2.9131F));

        ModelPartData _gltfNode_661_r1 = leaves.addChild("_gltfNode_661_r1", ModelPartBuilder.create().uv(337, 492).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-21.8934F, -4.4949F, 9.8933F, -2.2135F, 0.5876F, 2.6315F));

        ModelPartData _gltfNode_659_r1 = leaves.addChild("_gltfNode_659_r1", ModelPartBuilder.create().uv(271, 476).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-22.0645F, -3.5983F, 2.7402F, -2.4089F, 0.7923F, 2.0366F));

        ModelPartData _gltfNode_657_r1 = leaves.addChild("_gltfNode_657_r1", ModelPartBuilder.create().uv(461, 280).cuboid(-0.3835F, -4.5051F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-19.4531F, -2.2276F, 13.7539F, -2.3691F, 0.6275F, 1.5483F));

        ModelPartData _gltfNode_655_r1 = leaves.addChild("_gltfNode_655_r1", ModelPartBuilder.create().uv(463, 382).cuboid(-0.3835F, -4.5051F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-20.3948F, -1.9252F, 4.5876F, 3.1314F, 0.9187F, 1.2715F));

        ModelPartData _gltfNode_653_r1 = leaves.addChild("_gltfNode_653_r1", ModelPartBuilder.create().uv(431, 454).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-24.0767F, -5.7926F, 1.6745F, -2.5736F, 0.1359F, 2.0755F));

        ModelPartData _gltfNode_651_r1 = leaves.addChild("_gltfNode_651_r1", ModelPartBuilder.create().uv(282, 474).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-22.8781F, -5.1255F, 6.4826F, -2.5818F, 0.5724F, 2.251F));

        ModelPartData _gltfNode_649_r1 = leaves.addChild("_gltfNode_649_r1", ModelPartBuilder.create().uv(478, 338).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-17.2694F, 1.3846F, 6.8849F, 1.8754F, 1.3285F, -0.3231F));

        ModelPartData _gltfNode_647_r1 = leaves.addChild("_gltfNode_647_r1", ModelPartBuilder.create().uv(289, 450).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-1.9972F, -10.7702F, 4.5767F, 2.612F, -0.7763F, -1.6592F));

        ModelPartData _gltfNode_645_r1 = leaves.addChild("_gltfNode_645_r1", ModelPartBuilder.create().uv(392, 490).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-1.4363F, -14.1405F, 2.5751F, 1.7878F, -0.8479F, -0.8847F));

        ModelPartData _gltfNode_643_r1 = leaves.addChild("_gltfNode_643_r1", ModelPartBuilder.create().uv(409, 454).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-5.9777F, -10.2646F, 3.1695F, 2.877F, -0.8789F, -2.0169F));

        ModelPartData _gltfNode_641_r1 = leaves.addChild("_gltfNode_641_r1", ModelPartBuilder.create().uv(443, 359).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-13.608F, -0.861F, 6.0964F, 2.8658F, 0.8763F, 0.4336F));

        ModelPartData _gltfNode_639_r1 = leaves.addChild("_gltfNode_639_r1", ModelPartBuilder.create().uv(249, 449).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-10.6561F, -3.3803F, 5.7101F, 2.8658F, 0.8763F, 0.4336F));

        ModelPartData _gltfNode_637_r1 = leaves.addChild("_gltfNode_637_r1", ModelPartBuilder.create().uv(448, 244).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-7.7731F, -4.7047F, 6.0902F, 3.0223F, 0.5949F, 0.5093F));

        ModelPartData _gltfNode_635_r1 = leaves.addChild("_gltfNode_635_r1", ModelPartBuilder.create().uv(467, 343).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-5.3578F, -7.9021F, 5.0166F, 2.4262F, 0.6167F, -0.1972F));

        ModelPartData _gltfNode_633_r1 = leaves.addChild("_gltfNode_633_r1", ModelPartBuilder.create().uv(315, 475).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-11.3686F, -6.903F, 3.0488F, 2.5886F, 0.9759F, 0.268F));

        ModelPartData _gltfNode_631_r1 = leaves.addChild("_gltfNode_631_r1", ModelPartBuilder.create().uv(474, 369).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-15.1086F, -7.8419F, 0.7837F, 2.6039F, 0.7714F, 0.0788F));

        ModelPartData _gltfNode_629_r1 = leaves.addChild("_gltfNode_629_r1", ModelPartBuilder.create().uv(463, 370).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-9.8103F, -12.3637F, 0.0902F, 2.2504F, 0.2016F, -0.624F));

        ModelPartData _gltfNode_627_r1 = leaves.addChild("_gltfNode_627_r1", ModelPartBuilder.create().uv(480, 437).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-17.2857F, -0.6138F, 4.6496F, 1.8572F, 1.0423F, -0.4718F));

        ModelPartData _gltfNode_625_r1 = leaves.addChild("_gltfNode_625_r1", ModelPartBuilder.create().uv(448, 339).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-12.7443F, -4.4896F, 4.0552F, -3.092F, 0.9064F, 0.8494F));

        ModelPartData _gltfNode_623_r1 = leaves.addChild("_gltfNode_623_r1", ModelPartBuilder.create().uv(480, 461).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-17.5907F, -19.6078F, 6.0508F, -1.6871F, 0.1576F, 2.9315F));

        ModelPartData _gltfNode_621_r1 = leaves.addChild("_gltfNode_621_r1", ModelPartBuilder.create().uv(71, 0).cuboid(10.7879F, -74.6716F, 0.0F, 24.0F, 11.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(32.2215F, 13.7915F, -45.3482F, -2.2381F, -0.0992F, 2.4351F));

        ModelPartData _gltfNode_609_r1 = leaves.addChild("_gltfNode_609_r1", ModelPartBuilder.create().uv(322, 457).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(13.9966F, -16.0943F, 9.9302F, -2.8363F, 0.8812F, 2.3564F));

        ModelPartData _gltfNode_607_r1 = leaves.addChild("_gltfNode_607_r1", ModelPartBuilder.create().uv(436, 460).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(22.0778F, -14.361F, 7.5448F, -2.3036F, 0.4013F, -2.6953F));

        ModelPartData _gltfNode_605_r1 = leaves.addChild("_gltfNode_605_r1", ModelPartBuilder.create().uv(469, 492).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(6.4596F, -16.7437F, 12.8001F, -1.953F, -0.3501F, -2.8677F));

        ModelPartData _gltfNode_603_r1 = leaves.addChild("_gltfNode_603_r1", ModelPartBuilder.create().uv(337, 468).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(12.1585F, -9.8145F, 14.9233F, -2.2387F, -0.1068F, -2.2733F));

        ModelPartData _gltfNode_601_r1 = leaves.addChild("_gltfNode_601_r1", ModelPartBuilder.create().uv(461, 413).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(22.6476F, -10.157F, 10.0985F, -2.272F, 0.3026F, -2.6037F));

        ModelPartData _gltfNode_599_r1 = leaves.addChild("_gltfNode_599_r1", ModelPartBuilder.create().uv(249, 479).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(18.305F, -4.8786F, 15.5212F, 2.2528F, -1.2456F, -0.1085F));

        ModelPartData _gltfNode_597_r1 = leaves.addChild("_gltfNode_597_r1", ModelPartBuilder.create().uv(481, 244).cuboid(-4.6157F, -4.5051F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(6.6613F, -19.9794F, 10.554F, -2.996F, 1.4114F, 2.3522F));

        ModelPartData _gltfNode_595_r1 = leaves.addChild("_gltfNode_595_r1", ModelPartBuilder.create().uv(326, 480).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(18.1707F, -13.2548F, 9.9945F, -2.3008F, 1.3555F, -3.1392F));

        ModelPartData _gltfNode_593_r1 = leaves.addChild("_gltfNode_593_r1", ModelPartBuilder.create().uv(337, 450).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(13.2059F, -19.4104F, 8.3214F, 2.381F, 0.8396F, 2.0508F));

        ModelPartData _gltfNode_591_r1 = leaves.addChild("_gltfNode_591_r1", ModelPartBuilder.create().uv(414, 460).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(8.8901F, -6.4676F, 10.3996F, -2.8529F, -0.7288F, -0.448F));

        ModelPartData _gltfNode_589_r1 = leaves.addChild("_gltfNode_589_r1", ModelPartBuilder.create().uv(469, 486).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(2.6533F, -11.7904F, 9.5833F, -2.3908F, 0.7423F, 2.4829F));

        ModelPartData _gltfNode_587_r1 = leaves.addChild("_gltfNode_587_r1", ModelPartBuilder.create().uv(457, 268).cuboid(-4.6157F, -4.5051F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(15.8459F, 2.723F, 8.3628F, -2.8161F, -0.7835F, -0.9938F));

        ModelPartData _gltfNode_585_r1 = leaves.addChild("_gltfNode_585_r1", ModelPartBuilder.create().uv(476, 467).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(11.7022F, -8.949F, 15.1886F, -1.6943F, -0.0397F, -2.1412F));

        ModelPartData _gltfNode_583_r1 = leaves.addChild("_gltfNode_583_r1", ModelPartBuilder.create().uv(471, 425).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(16.0088F, -2.0193F, 12.805F, -1.4569F, -0.207F, -1.6756F));

        ModelPartData _gltfNode_581_r1 = leaves.addChild("_gltfNode_581_r1", ModelPartBuilder.create().uv(293, 467).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-0.2306F, -10.9974F, 6.2585F, -3.0974F, 0.7894F, 2.2069F));

        ModelPartData _gltfNode_579_r1 = leaves.addChild("_gltfNode_579_r1", ModelPartBuilder.create().uv(249, 467).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(6.6212F, -5.9633F, 7.8922F, -2.9682F, 0.6904F, 1.8669F));

        ModelPartData _gltfNode_577_r1 = leaves.addChild("_gltfNode_577_r1", ModelPartBuilder.create().uv(446, 274).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(7.8079F, -10.6455F, 13.2053F, -2.6602F, 0.7601F, 2.2613F));

        ModelPartData _gltfNode_575_r1 = leaves.addChild("_gltfNode_575_r1", ModelPartBuilder.create().uv(480, 479).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(5.7986F, -12.4417F, 13.0159F, -1.753F, 0.2295F, -2.7369F));

        ModelPartData _gltfNode_573_r1 = leaves.addChild("_gltfNode_573_r1", ModelPartBuilder.create().uv(344, 456).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(10.0674F, -8.7985F, 13.5747F, -1.9254F, -0.5021F, -1.6653F));

        ModelPartData _gltfNode_571_r1 = leaves.addChild("_gltfNode_571_r1", ModelPartBuilder.create().uv(442, 395).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(11.8686F, -0.7527F, 7.9159F, -2.2936F, -0.7702F, -0.8767F));

        ModelPartData _gltfNode_569_r1 = leaves.addChild("_gltfNode_569_r1", ModelPartBuilder.create().uv(447, 432).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(3.7434F, -9.3143F, 8.326F, -2.5674F, 0.7537F, 2.1F));

        ModelPartData _gltfNode_567_r1 = leaves.addChild("_gltfNode_567_r1", ModelPartBuilder.create().uv(450, 319).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(13.5812F, -3.3589F, 11.8241F, -1.9064F, -0.6655F, -1.3772F));

        ModelPartData _gltfNode_565_r1 = leaves.addChild("_gltfNode_565_r1", ModelPartBuilder.create().uv(315, 463).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(15.8498F, 1.0992F, 9.8369F, -1.671F, -0.4748F, -1.7217F));

        ModelPartData _gltfNode_563_r1 = leaves.addChild("_gltfNode_563_r1", ModelPartBuilder.create().uv(392, 460).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(1.3975F, -14.7334F, 11.1136F, -2.1434F, 0.7498F, 2.6356F));

        ModelPartData _gltfNode_561_r1 = leaves.addChild("_gltfNode_561_r1", ModelPartBuilder.create().uv(392, 484).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(17.5265F, -2.3512F, 14.4773F, -2.2731F, 0.1851F, -1.6631F));

        ModelPartData _gltfNode_559_r1 = leaves.addChild("_gltfNode_559_r1", ModelPartBuilder.create().uv(388, 472).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(17.9066F, -15.5024F, 0.4238F, 2.2093F, -1.0042F, -0.3069F));

        ModelPartData _gltfNode_557_r1 = leaves.addChild("_gltfNode_557_r1", ModelPartBuilder.create().uv(474, 387).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(11.6698F, -20.8252F, -0.3925F, 2.6467F, 1.0605F, 2.5486F));

        ModelPartData _gltfNode_555_r1 = leaves.addChild("_gltfNode_555_r1", ModelPartBuilder.create().uv(466, 262).cuboid(-4.6157F, -4.5051F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(24.8623F, -6.3117F, -1.613F, -3.0863F, -1.0033F, -1.0612F));

        ModelPartData _gltfNode_553_r1 = leaves.addChild("_gltfNode_553_r1", ModelPartBuilder.create().uv(477, 256).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(20.7187F, -17.9838F, 5.2128F, -2.7768F, -0.2192F, -2.3707F));

        ModelPartData _gltfNode_551_r1 = leaves.addChild("_gltfNode_551_r1", ModelPartBuilder.create().uv(479, 274).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(25.0253F, -11.0541F, 2.8292F, -3.1095F, -0.705F, -2.2909F));

        ModelPartData _gltfNode_549_r1 = leaves.addChild("_gltfNode_549_r1", ModelPartBuilder.create().uv(282, 468).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(8.7858F, -20.0322F, -3.7173F, 2.8241F, 1.0111F, 2.158F));

        ModelPartData _gltfNode_547_r1 = leaves.addChild("_gltfNode_547_r1", ModelPartBuilder.create().uv(388, 466).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(15.6377F, -14.998F, -2.0836F, 2.0659F, 0.952F, 1.6819F));

        ModelPartData _gltfNode_545_r1 = leaves.addChild("_gltfNode_545_r1", ModelPartBuilder.create().uv(444, 250).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(16.8244F, -19.6802F, 3.2295F, 2.4767F, 1.0485F, 2.2185F));

        ModelPartData _gltfNode_543_r1 = leaves.addChild("_gltfNode_543_r1", ModelPartBuilder.create().uv(472, 304).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(14.815F, -21.4765F, 3.0401F, -2.7907F, 0.4172F, -2.5038F));

        ModelPartData _gltfNode_541_r1 = leaves.addChild("_gltfNode_541_r1", ModelPartBuilder.create().uv(454, 358).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(19.0839F, -17.8332F, 3.5989F, -2.9018F, -0.7195F, -1.9002F));

        ModelPartData _gltfNode_539_r1 = leaves.addChild("_gltfNode_539_r1", ModelPartBuilder.create().uv(381, 455).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(20.885F, -9.7875F, -2.0599F, 2.4669F, -1.039F, -0.9143F));

        ModelPartData _gltfNode_537_r1 = leaves.addChild("_gltfNode_537_r1", ModelPartBuilder.create().uv(376, 449).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(12.7598F, -18.3491F, -1.6498F, 2.0838F, 1.0159F, 1.9983F));

        ModelPartData _gltfNode_535_r1 = leaves.addChild("_gltfNode_535_r1", ModelPartBuilder.create().uv(455, 250).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(22.5977F, -12.3937F, 1.8483F, 2.9599F, -0.8996F, -1.5682F));

        ModelPartData _gltfNode_533_r1 = leaves.addChild("_gltfNode_533_r1", ModelPartBuilder.create().uv(410, 472).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(24.8662F, -7.9356F, -0.1389F, -3.1034F, -0.6723F, -1.9414F));

        ModelPartData _gltfNode_531_r1 = leaves.addChild("_gltfNode_531_r1", ModelPartBuilder.create().uv(282, 456).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(10.4139F, -23.7682F, 1.1378F, 2.6732F, 1.0104F, 2.7462F));

        ModelPartData _gltfNode_529_r1 = leaves.addChild("_gltfNode_529_r1", ModelPartBuilder.create().uv(488, 298).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(26.543F, -11.386F, 4.5015F, -1.9986F, -0.6013F, -2.7696F));

        ModelPartData _gltfNode_527_r1 = leaves.addChild("_gltfNode_527_r1", ModelPartBuilder.create().uv(370, 485).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(1.5317F, -17.5107F, 4.981F, -2.3831F, 0.558F, -2.8668F));

        ModelPartData _gltfNode_525_r1 = leaves.addChild("_gltfNode_525_r1", ModelPartBuilder.create().uv(461, 314).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(2.4738F, -19.5226F, 10.9025F, -2.272F, 0.3026F, -2.6037F));

        ModelPartData _gltfNode_523_r1 = leaves.addChild("_gltfNode_523_r1", ModelPartBuilder.create().uv(476, 355).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(7.4829F, -24.542F, 5.3604F, -2.1326F, 0.987F, -2.3452F));

        ModelPartData _gltfNode_521_r1 = leaves.addChild("_gltfNode_521_r1", ModelPartBuilder.create().uv(366, 461).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(5.2567F, -22.3112F, 7.8235F, -2.3087F, 0.3546F, -1.9314F));

        ModelPartData _gltfNode_519_r1 = leaves.addChild("_gltfNode_519_r1", ModelPartBuilder.create().uv(478, 344).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(3.4585F, -20.1533F, 7.4918F, -2.1593F, 0.7816F, -2.2042F));

        ModelPartData _gltfNode_517_r1 = leaves.addChild("_gltfNode_517_r1", ModelPartBuilder.create().uv(464, 455).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(3.6295F, -19.2567F, 0.3387F, -2.5449F, 0.9713F, -2.939F));

        ModelPartData _gltfNode_515_r1 = leaves.addChild("_gltfNode_515_r1", ModelPartBuilder.create().uv(466, 256).cuboid(-0.3835F, -4.5051F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(1.0181F, -17.886F, 11.3524F, -2.5781F, 0.7429F, 2.8285F));

        ModelPartData _gltfNode_513_r1 = leaves.addChild("_gltfNode_513_r1", ModelPartBuilder.create().uv(282, 462).cuboid(-0.3835F, -4.5051F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(1.9598F, -17.5836F, 2.1861F, 2.8039F, 0.973F, 2.418F));

        ModelPartData _gltfNode_511_r1 = leaves.addChild("_gltfNode_511_r1", ModelPartBuilder.create().uv(300, 455).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(5.6418F, -21.451F, -0.727F, -2.6468F, 0.3212F, -2.8113F));

        ModelPartData _gltfNode_509_r1 = leaves.addChild("_gltfNode_509_r1", ModelPartBuilder.create().uv(456, 351).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(4.4431F, -20.7839F, 4.0811F, -2.6319F, 0.767F, -2.6505F));

        ModelPartData _gltfNode_507_r1 = leaves.addChild("_gltfNode_507_r1", ModelPartBuilder.create().uv(304, 485).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-1.1656F, -14.2738F, 4.4834F, 1.6985F, 1.1382F, 0.9222F));

        ModelPartData _gltfNode_505_r1 = leaves.addChild("_gltfNode_505_r1", ModelPartBuilder.create().uv(337, 486).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(19.879F, -1.8522F, 7.3825F, -2.2943F, -0.376F, -2.0436F));

        ModelPartData _gltfNode_503_r1 = leaves.addChild("_gltfNode_503_r1", ModelPartBuilder.create().uv(326, 468).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(20.821F, -3.8642F, 13.304F, -2.2387F, -0.1068F, -2.2733F));

        ModelPartData _gltfNode_501_r1 = leaves.addChild("_gltfNode_501_r1", ModelPartBuilder.create().uv(485, 367).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(25.8302F, -8.8836F, 7.7619F, -2.1577F, -0.7891F, -2.5054F));

        ModelPartData _gltfNode_499_r1 = leaves.addChild("_gltfNode_499_r1", ModelPartBuilder.create().uv(443, 474).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(23.6039F, -6.6528F, 10.2251F, -2.4056F, -0.1794F, -2.9131F));

        ModelPartData _gltfNode_497_r1 = leaves.addChild("_gltfNode_497_r1", ModelPartBuilder.create().uv(326, 492).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(21.8057F, -4.4949F, 9.8933F, -2.2135F, -0.5876F, -2.6315F));

        ModelPartData _gltfNode_495_r1 = leaves.addChild("_gltfNode_495_r1", ModelPartBuilder.create().uv(470, 244).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(21.9768F, -3.5983F, 2.7402F, -2.4089F, -0.7923F, -2.0366F));

        ModelPartData _gltfNode_493_r1 = leaves.addChild("_gltfNode_493_r1", ModelPartBuilder.create().uv(260, 467).cuboid(-4.6157F, -4.5051F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(19.3654F, -2.2276F, 13.7539F, -2.3691F, -0.6275F, -1.5483F));

        ModelPartData _gltfNode_491_r1 = leaves.addChild("_gltfNode_491_r1", ModelPartBuilder.create().uv(463, 388).cuboid(-4.6157F, -4.5051F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(20.3071F, -1.9252F, 4.5876F, 3.1314F, -0.9187F, -1.2715F));

        ModelPartData _gltfNode_489_r1 = leaves.addChild("_gltfNode_489_r1", ModelPartBuilder.create().uv(420, 454).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(23.989F, -5.7926F, 1.6745F, -2.5736F, -0.1359F, -2.0755F));

        ModelPartData _gltfNode_487_r1 = leaves.addChild("_gltfNode_487_r1", ModelPartBuilder.create().uv(468, 274).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(22.7903F, -5.1255F, 6.4826F, -2.5818F, -0.5724F, -2.251F));

        ModelPartData _gltfNode_485_r1 = leaves.addChild("_gltfNode_485_r1", ModelPartBuilder.create().uv(477, 298).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(17.1817F, 1.3846F, 6.8849F, 1.8754F, -1.3285F, 0.3231F));

        ModelPartData _gltfNode_483_r1 = leaves.addChild("_gltfNode_483_r1", ModelPartBuilder.create().uv(444, 262).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(1.9094F, -10.7702F, 4.5767F, 2.612F, 0.7763F, 1.6592F));

        ModelPartData _gltfNode_481_r1 = leaves.addChild("_gltfNode_481_r1", ModelPartBuilder.create().uv(381, 490).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(1.3485F, -14.1405F, 2.5751F, 1.7878F, 0.8479F, 0.8847F));

        ModelPartData _gltfNode_479_r1 = leaves.addChild("_gltfNode_479_r1", ModelPartBuilder.create().uv(398, 454).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(5.8899F, -10.2646F, 3.1695F, 2.877F, 0.8789F, 2.0169F));

        ModelPartData _gltfNode_477_r1 = leaves.addChild("_gltfNode_477_r1", ModelPartBuilder.create().uv(260, 449).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(13.5203F, -0.861F, 6.0964F, 2.8658F, -0.8763F, -0.4336F));

        ModelPartData _gltfNode_475_r1 = leaves.addChild("_gltfNode_475_r1", ModelPartBuilder.create().uv(238, 449).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(10.5683F, -3.3803F, 5.7101F, 2.8658F, -0.8763F, -0.4336F));

        ModelPartData _gltfNode_473_r1 = leaves.addChild("_gltfNode_473_r1", ModelPartBuilder.create().uv(447, 438).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(7.6854F, -4.7047F, 6.0902F, 3.0223F, -0.5949F, -0.5093F));

        ModelPartData _gltfNode_471_r1 = leaves.addChild("_gltfNode_471_r1", ModelPartBuilder.create().uv(304, 473).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(5.27F, -7.9021F, 5.0166F, 2.4262F, -0.6167F, 0.1972F));

        ModelPartData _gltfNode_469_r1 = leaves.addChild("_gltfNode_469_r1", ModelPartBuilder.create().uv(465, 474).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(11.2808F, -6.903F, 3.0488F, 2.5886F, -0.9759F, -0.268F));

        ModelPartData _gltfNode_467_r1 = leaves.addChild("_gltfNode_467_r1", ModelPartBuilder.create().uv(348, 480).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(15.0209F, -7.8419F, 0.7837F, 2.6039F, -0.7714F, -0.0788F));

        ModelPartData _gltfNode_465_r1 = leaves.addChild("_gltfNode_465_r1", ModelPartBuilder.create().uv(463, 376).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(9.7226F, -12.3637F, 0.0902F, 2.2504F, -0.2016F, 0.624F));

        ModelPartData _gltfNode_463_r1 = leaves.addChild("_gltfNode_463_r1", ModelPartBuilder.create().uv(480, 431).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(17.198F, -0.6138F, 4.6496F, 1.8572F, -1.0423F, 0.4718F));

        ModelPartData _gltfNode_461_r1 = leaves.addChild("_gltfNode_461_r1", ModelPartBuilder.create().uv(448, 296).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(12.6566F, -4.4896F, 4.0552F, -3.092F, -0.9064F, -0.8494F));

        ModelPartData _gltfNode_459_r1 = leaves.addChild("_gltfNode_459_r1", ModelPartBuilder.create().uv(447, 486).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(17.503F, -19.6078F, 6.0508F, -1.6871F, -0.1576F, -2.9315F));

        ModelPartData _gltfNode_457_r1 = leaves.addChild("_gltfNode_457_r1", ModelPartBuilder.create().uv(0, 74).cuboid(-34.7859F, -74.6708F, -0.0013F, 24.0F, 11.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(-32.3092F, 13.7915F, -45.3482F, -2.2381F, 0.0992F, -2.4351F));

        ModelPartData _gltfNode_438_r1 = leaves.addChild("_gltfNode_438_r1", ModelPartBuilder.create().uv(450, 413).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-16.9922F, -19.4699F, -9.5941F, 0.3043F, 0.0262F, 1.0512F));

        ModelPartData _gltfNode_436_r1 = leaves.addChild("_gltfNode_436_r1", ModelPartBuilder.create().uv(238, 455).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-23.4593F, -16.7911F, -4.5941F, 0.0F, 0.0F, 0.0F));

        ModelPartData _gltfNode_434_r1 = leaves.addChild("_gltfNode_434_r1", ModelPartBuilder.create().uv(293, 479).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-11.5968F, -21.7047F, -15.1941F, 0.1938F, 0.6099F, -0.5037F));

        ModelPartData _gltfNode_432_r1 = leaves.addChild("_gltfNode_432_r1", ModelPartBuilder.create().uv(453, 401).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-19.9117F, -18.2606F, -17.1941F, 0.0F, 0.0F, -0.6545F));

        ModelPartData _gltfNode_430_r1 = leaves.addChild("_gltfNode_430_r1", ModelPartBuilder.create().uv(453, 395).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-26.6005F, -15.49F, -8.1941F, 0.0F, 0.0F, -0.1309F));

        ModelPartData _gltfNode_428_r1 = leaves.addChild("_gltfNode_428_r1", ModelPartBuilder.create().uv(465, 468).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-27.2104F, -15.2374F, -16.8941F, -0.3231F, 0.3979F, -2.3087F));

        ModelPartData _gltfNode_426_r1 = leaves.addChild("_gltfNode_426_r1", ModelPartBuilder.create().uv(472, 286).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-9.6012F, -22.5314F, -11.8941F, 0.1483F, -0.504F, 1.0526F));

        ModelPartData _gltfNode_424_r1 = leaves.addChild("_gltfNode_424_r1", ModelPartBuilder.create().uv(465, 363).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-21.6116F, -17.5565F, -8.8941F, 0.1483F, -0.504F, 0.878F));

        ModelPartData _gltfNode_422_r1 = leaves.addChild("_gltfNode_422_r1", ModelPartBuilder.create().uv(370, 455).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-14.3895F, -20.7644F, -7.1941F, -0.5219F, 0.0436F, 1.2537F));

        ModelPartData _gltfNode_420_r1 = leaves.addChild("_gltfNode_420_r1", ModelPartBuilder.create().uv(344, 462).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-16.7603F, -12.6386F, -18.0941F, 0.5562F, -0.1448F, -2.3425F));

        ModelPartData _gltfNode_418_r1 = leaves.addChild("_gltfNode_418_r1", ModelPartBuilder.create().uv(479, 268).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-9.1476F, -15.7919F, -18.0941F, 0.6489F, 0.1603F, 0.9568F));

        ModelPartData _gltfNode_416_r1 = leaves.addChild("_gltfNode_416_r1", ModelPartBuilder.create().uv(463, 326).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-25.3923F, -4.7336F, -18.0941F, 0.1616F, -0.1118F, -1.9423F));

        ModelPartData _gltfNode_414_r1 = leaves.addChild("_gltfNode_414_r1", ModelPartBuilder.create().uv(464, 406).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-19.9803F, -17.7992F, -18.0941F, 0.5562F, -0.1448F, -0.6844F));

        ModelPartData _gltfNode_412_r1 = leaves.addChild("_gltfNode_412_r1", ModelPartBuilder.create().uv(260, 473).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-25.3787F, -11.2336F, -18.0941F, 0.9697F, -0.3675F, -1.138F));

        ModelPartData _gltfNode_410_r1 = leaves.addChild("_gltfNode_410_r1", ModelPartBuilder.create().uv(315, 469).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-5.7691F, -12.8618F, -18.0941F, 0.1616F, 0.1118F, 1.1569F));

        ModelPartData _gltfNode_408_r1 = leaves.addChild("_gltfNode_408_r1", ModelPartBuilder.create().uv(458, 437).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-14.0972F, -10.4945F, -18.0941F, 0.5562F, 0.1448F, 1.4262F));

        ModelPartData _gltfNode_406_r1 = leaves.addChild("_gltfNode_406_r1", ModelPartBuilder.create().uv(359, 450).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-15.2978F, -17.574F, -18.0941F, 0.5562F, 0.1448F, 1.1208F));

        ModelPartData _gltfNode_404_r1 = leaves.addChild("_gltfNode_404_r1", ModelPartBuilder.create().uv(464, 394).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-12.8415F, -18.6996F, -18.0941F, 0.5562F, 0.1448F, -0.101F));

        ModelPartData _gltfNode_402_r1 = leaves.addChild("_gltfNode_402_r1", ModelPartBuilder.create().uv(450, 286).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-18.0522F, -16.5413F, -18.0941F, 0.5562F, -0.1448F, -1.3389F));

        ModelPartData _gltfNode_400_r1 = leaves.addChild("_gltfNode_400_r1", ModelPartBuilder.create().uv(446, 268).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-20.534F, -6.8542F, -18.0941F, 0.7763F, -0.1349F, -2.0242F));

        ModelPartData _gltfNode_398_r1 = leaves.addChild("_gltfNode_398_r1", ModelPartBuilder.create().uv(445, 346).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-10.5455F, -13.1564F, -18.0941F, 0.7763F, 0.1349F, 1.2388F));

        ModelPartData _gltfNode_396_r1 = leaves.addChild("_gltfNode_396_r1", ModelPartBuilder.create().uv(452, 325).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-22.4474F, -11.4736F, -18.0941F, 0.7763F, -0.1349F, -1.6315F));

        ModelPartData _gltfNode_394_r1 = leaves.addChild("_gltfNode_394_r1", ModelPartBuilder.create().uv(304, 461).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-25.3261F, -6.9257F, -18.0941F, 0.7763F, -0.1349F, -1.2825F));

        ModelPartData _gltfNode_392_r1 = leaves.addChild("_gltfNode_392_r1", ModelPartBuilder.create().uv(452, 372).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-7.5333F, -18.9501F, -18.0941F, 0.7763F, 0.1349F, 0.8461F));

        ModelPartData _gltfNode_390_r1 = leaves.addChild("_gltfNode_390_r1", ModelPartBuilder.create().uv(271, 482).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-27.1603F, -12.6604F, -18.0941F, 0.0F, -0.6545F, -0.829F));

        ModelPartData _gltfNode_388_r1 = leaves.addChild("_gltfNode_388_r1", ModelPartBuilder.create().uv(456, 345).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-16.7603F, -12.6386F, -1.8941F, -0.5562F, 0.1448F, -2.3425F));

        ModelPartData _gltfNode_386_r1 = leaves.addChild("_gltfNode_386_r1", ModelPartBuilder.create().uv(260, 485).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-9.1476F, -15.7919F, -1.8941F, -0.6489F, -0.1603F, 0.9568F));

        ModelPartData _gltfNode_384_r1 = leaves.addChild("_gltfNode_384_r1", ModelPartBuilder.create().uv(463, 320).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-25.3923F, -4.7336F, -1.8941F, -0.1616F, 0.1118F, -1.9423F));

        ModelPartData _gltfNode_382_r1 = leaves.addChild("_gltfNode_382_r1", ModelPartBuilder.create().uv(464, 400).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-19.9803F, -17.7992F, -1.8941F, -0.5562F, 0.1448F, -0.6844F));

        ModelPartData _gltfNode_380_r1 = leaves.addChild("_gltfNode_380_r1", ModelPartBuilder.create().uv(249, 473).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-25.3787F, -11.2336F, -1.8941F, -0.9697F, 0.3675F, -1.138F));

        ModelPartData _gltfNode_378_r1 = leaves.addChild("_gltfNode_378_r1", ModelPartBuilder.create().uv(454, 468).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-5.7691F, -12.8618F, -1.8941F, -0.1616F, -0.1118F, 1.1569F));

        ModelPartData _gltfNode_376_r1 = leaves.addChild("_gltfNode_376_r1", ModelPartBuilder.create().uv(458, 431).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-14.0972F, -10.4945F, -1.8941F, -0.5562F, -0.1448F, 1.4262F));

        ModelPartData _gltfNode_374_r1 = leaves.addChild("_gltfNode_374_r1", ModelPartBuilder.create().uv(348, 450).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-15.2978F, -17.574F, -1.8941F, -0.5562F, -0.1448F, 1.1208F));

        ModelPartData _gltfNode_372_r1 = leaves.addChild("_gltfNode_372_r1", ModelPartBuilder.create().uv(271, 470).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-12.8415F, -18.6996F, -1.8941F, -0.5562F, -0.1448F, -0.101F));

        ModelPartData _gltfNode_370_r1 = leaves.addChild("_gltfNode_370_r1", ModelPartBuilder.create().uv(450, 280).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-18.0522F, -16.5413F, -1.8941F, -0.5562F, 0.1448F, -1.3389F));

        ModelPartData _gltfNode_368_r1 = leaves.addChild("_gltfNode_368_r1", ModelPartBuilder.create().uv(445, 352).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-20.534F, -6.8542F, -1.8941F, -0.7763F, 0.1349F, -2.0242F));

        ModelPartData _gltfNode_366_r1 = leaves.addChild("_gltfNode_366_r1", ModelPartBuilder.create().uv(322, 451).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-10.5455F, -13.1564F, -1.8941F, -0.7763F, -0.1349F, 1.2388F));

        ModelPartData _gltfNode_364_r1 = leaves.addChild("_gltfNode_364_r1", ModelPartBuilder.create().uv(271, 458).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-22.4474F, -11.4736F, -1.8941F, -0.7763F, 0.1349F, -1.6315F));

        ModelPartData _gltfNode_362_r1 = leaves.addChild("_gltfNode_362_r1", ModelPartBuilder.create().uv(455, 302).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-25.3261F, -6.9257F, -1.8941F, -0.7763F, 0.1349F, -1.2825F));

        ModelPartData _gltfNode_360_r1 = leaves.addChild("_gltfNode_360_r1", ModelPartBuilder.create().uv(452, 331).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-7.5333F, -18.9501F, -1.8941F, -0.7763F, -0.1349F, 0.8461F));

        ModelPartData _gltfNode_358_r1 = leaves.addChild("_gltfNode_358_r1", ModelPartBuilder.create().uv(475, 455).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-27.1603F, -12.6604F, -1.8941F, 0.0F, 0.6545F, -0.829F));

        ModelPartData _gltfNode_356_r1 = leaves.addChild("_gltfNode_356_r1", ModelPartBuilder.create().uv(403, 478).cuboid(-0.3835F, -4.5051F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-4.1455F, -16.7814F, -12.6941F, 0.0F, 0.0F, 0.2182F));

        ModelPartData _gltfNode_354_r1 = leaves.addChild("_gltfNode_354_r1", ModelPartBuilder.create().uv(453, 407).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-6.4417F, -22.3247F, -14.6941F, 0.0F, 0.0F, -0.1309F));

        ModelPartData _gltfNode_352_r1 = leaves.addChild("_gltfNode_352_r1", ModelPartBuilder.create().uv(470, 332).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-6.4417F, -22.3247F, -5.6941F, -0.1634F, -0.5457F, 0.3513F));

        ModelPartData _gltfNode_350_r1 = leaves.addChild("_gltfNode_350_r1", ModelPartBuilder.create().uv(453, 456).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-6.4417F, -22.3247F, -9.6941F, -0.1634F, -0.5457F, -0.4778F));

        ModelPartData _gltfNode_348_r1 = leaves.addChild("_gltfNode_348_r1", ModelPartBuilder.create().uv(414, 478).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-5.6763F, -20.477F, -11.6941F, -0.1634F, -0.5457F, 0.0895F));

        ModelPartData _gltfNode_346_r1 = leaves.addChild("_gltfNode_346_r1", ModelPartBuilder.create().uv(459, 292).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-3.3802F, -14.9337F, -7.6941F, -0.1545F, -0.2673F, 0.5414F));

        ModelPartData _gltfNode_344_r1 = leaves.addChild("_gltfNode_344_r1", ModelPartBuilder.create().uv(304, 467).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-6.059F, -21.4008F, -16.6941F, 0.1942F, 0.1001F, 0.7079F));

        ModelPartData _gltfNode_342_r1 = leaves.addChild("_gltfNode_342_r1", ModelPartBuilder.create().uv(458, 462).cuboid(-0.3835F, -4.5051F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-3.3802F, -14.9337F, -10.6941F, -0.3873F, -0.0665F, 1.0166F));

        ModelPartData _gltfNode_340_r1 = leaves.addChild("_gltfNode_340_r1", ModelPartBuilder.create().uv(442, 407).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-3.7629F, -15.8576F, -4.6941F, -0.301F, 0.134F, 0.016F));

        ModelPartData _gltfNode_338_r1 = leaves.addChild("_gltfNode_338_r1", ModelPartBuilder.create().uv(260, 461).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-4.9109F, -18.6292F, -8.6941F, -0.388F, -0.2665F, 0.2561F));

        ModelPartData _gltfNode_336_r1 = leaves.addChild("_gltfNode_336_r1", ModelPartBuilder.create().uv(238, 473).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-2.9975F, -14.0098F, -15.6941F, -0.3007F, -0.5395F, 1.5572F));

        ModelPartData _gltfNode_334_r1 = leaves.addChild("_gltfNode_334_r1", ModelPartBuilder.create().uv(392, 478).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-26.5403F, -7.5052F, -12.6941F, 0.0F, 0.0F, -1.0036F));

        ModelPartData _gltfNode_332_r1 = leaves.addChild("_gltfNode_332_r1", ModelPartBuilder.create().uv(452, 384).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-28.8364F, -13.0485F, -14.6941F, 0.0F, 0.0F, -0.6545F));

        ModelPartData _gltfNode_330_r1 = leaves.addChild("_gltfNode_330_r1", ModelPartBuilder.create().uv(470, 292).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-28.8364F, -13.0485F, -5.6941F, -0.1634F, 0.5457F, -1.1367F));

        ModelPartData _gltfNode_328_r1 = leaves.addChild("_gltfNode_328_r1", ModelPartBuilder.create().uv(453, 450).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-28.8364F, -13.0485F, -9.6941F, -0.1634F, 0.5457F, -0.3076F));

        ModelPartData _gltfNode_326_r1 = leaves.addChild("_gltfNode_326_r1", ModelPartBuilder.create().uv(425, 478).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-28.071F, -11.2007F, -11.6941F, -0.1634F, 0.5457F, -0.8749F));

        ModelPartData _gltfNode_324_r1 = leaves.addChild("_gltfNode_324_r1", ModelPartBuilder.create().uv(459, 337).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-25.7749F, -5.6574F, -7.6941F, -0.1545F, 0.2673F, -1.3268F));

        ModelPartData _gltfNode_322_r1 = leaves.addChild("_gltfNode_322_r1", ModelPartBuilder.create().uv(461, 308).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-28.4537F, -12.1246F, -16.6941F, 0.1942F, -0.1001F, -1.4933F));

        ModelPartData _gltfNode_320_r1 = leaves.addChild("_gltfNode_320_r1", ModelPartBuilder.create().uv(459, 244).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-25.7749F, -5.6574F, -10.6941F, -0.3873F, 0.0665F, -1.802F));

        ModelPartData _gltfNode_318_r1 = leaves.addChild("_gltfNode_318_r1", ModelPartBuilder.create().uv(406, 448).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-26.1576F, -6.5813F, -4.6941F, -0.301F, -0.134F, -0.8014F));

        ModelPartData _gltfNode_316_r1 = leaves.addChild("_gltfNode_316_r1", ModelPartBuilder.create().uv(293, 461).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-27.3057F, -9.353F, -8.6941F, -0.388F, 0.2665F, -1.0415F));

        ModelPartData _gltfNode_314_r1 = leaves.addChild("_gltfNode_314_r1", ModelPartBuilder.create().uv(432, 472).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-25.3923F, -4.7336F, -15.6941F, -0.3007F, 0.5395F, -2.3426F));

        ModelPartData _gltfNode_312_r1 = leaves.addChild("_gltfNode_312_r1", ModelPartBuilder.create().uv(439, 448).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-6.9795F, -11.6027F, -15.9941F, 0.0F, 0.0F, 1.5272F));

        ModelPartData _gltfNode_310_r1 = leaves.addChild("_gltfNode_310_r1", ModelPartBuilder.create().uv(469, 431).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-4.3926F, -12.6743F, -13.1941F, -0.3198F, -0.422F, 1.858F));

        ModelPartData _gltfNode_308_r1 = leaves.addChild("_gltfNode_308_r1", ModelPartBuilder.create().uv(260, 455).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-9.9359F, -10.3781F, -13.1941F, 0.0F, 0.0F, 1.2654F));

        ModelPartData _gltfNode_306_r1 = leaves.addChild("_gltfNode_306_r1", ModelPartBuilder.create().uv(428, 448).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-21.1517F, -5.7324F, -15.9941F, 0.0F, 0.0F, -2.3126F));

        ModelPartData _gltfNode_304_r1 = leaves.addChild("_gltfNode_304_r1", ModelPartBuilder.create().uv(417, 448).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-17.5486F, -7.2249F, -15.9941F, 0.0F, 0.0F, -2.3126F));

        ModelPartData _gltfNode_302_r1 = leaves.addChild("_gltfNode_302_r1", ModelPartBuilder.create().uv(442, 454).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-14.7769F, -8.3729F, -17.0941F, 0.1074F, -0.2865F, -2.3281F));

        ModelPartData _gltfNode_300_r1 = leaves.addChild("_gltfNode_300_r1", ModelPartBuilder.create().uv(271, 464).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-11.0814F, -9.9036F, -15.9941F, 0.0F, 0.0F, -2.8362F));

        ModelPartData _gltfNode_298_r1 = leaves.addChild("_gltfNode_298_r1", ModelPartBuilder.create().uv(293, 473).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-15.7008F, -7.9902F, -11.9941F, -0.1485F, 0.1268F, -2.3733F));

        ModelPartData _gltfNode_296_r1 = leaves.addChild("_gltfNode_296_r1", ModelPartBuilder.create().uv(381, 478).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-17.5486F, -7.2249F, -7.9941F, 0.0F, 0.0F, -2.5744F));

        ModelPartData _gltfNode_294_r1 = leaves.addChild("_gltfNode_294_r1", ModelPartBuilder.create().uv(452, 378).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-11.0814F, -9.9036F, -7.9941F, 0.0F, 0.0F, 2.8798F));

        ModelPartData _gltfNode_292_r1 = leaves.addChild("_gltfNode_292_r1", ModelPartBuilder.create().uv(469, 437).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-23.7386F, -4.6609F, -13.1941F, -0.3198F, 0.422F, -2.6434F));

        ModelPartData _gltfNode_290_r1 = leaves.addChild("_gltfNode_290_r1", ModelPartBuilder.create().uv(249, 455).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-18.1953F, -6.957F, -13.1941F, 0.0F, 0.0F, -2.0508F));

        ModelPartData _gltfNode_288_r1 = leaves.addChild("_gltfNode_288_r1", ModelPartBuilder.create().uv(457, 274).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-16.9922F, -19.4699F, -3.2941F, 0.5692F, 0.5462F, -0.2744F));

        ModelPartData _gltfNode_286_r1 = leaves.addChild("_gltfNode_286_r1", ModelPartBuilder.create().uv(0, 46).cuboid(-34.7859F, -74.6708F, -0.0013F, 24.0F, 11.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(31.1788F, 41.3748F, -17.9941F, 0.0F, 0.0F, -0.3927F));

        ModelPartData _gltfNode_266_r1 = leaves.addChild("_gltfNode_266_r1", ModelPartBuilder.create().uv(238, 497).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-6.9276F, -8.9198F, 4.6338F, -2.2216F, -1.1661F, -0.7704F));

        ModelPartData _gltfNode_264_r1 = leaves.addChild("_gltfNode_264_r1", ModelPartBuilder.create().uv(315, 505).cuboid(-4.6157F, -4.5051F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-1.8276F, -8.1264F, 5.2426F, -1.2505F, -1.2958F, -2.0552F));

        ModelPartData _gltfNode_262_r1 = leaves.addChild("_gltfNode_262_r1", ModelPartBuilder.create().uv(480, 503).cuboid(-4.6157F, -4.5051F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-5.8276F, -12.0932F, 2.1988F, 1.5708F, -1.3526F, 1.5708F));

        ModelPartData _gltfNode_260_r1 = leaves.addChild("_gltfNode_260_r1", ModelPartBuilder.create().uv(494, 286).cuboid(-4.6157F, -4.5051F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(2.1724F, -12.0932F, 2.1988F, 1.5708F, -0.7854F, 1.5708F));

        ModelPartData _gltfNode_258_r1 = leaves.addChild("_gltfNode_258_r1", ModelPartBuilder.create().uv(500, 340).cuboid(-4.6157F, -4.5051F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(2.1724F, -6.5397F, 6.4601F, -1.5708F, -1.5272F, -1.5708F));

        ModelPartData _gltfNode_256_r1 = leaves.addChild("_gltfNode_256_r1", ModelPartBuilder.create().uv(488, 250).cuboid(-4.6157F, -4.5051F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-5.8276F, -6.5397F, 6.4601F, -1.5708F, -1.2654F, -1.5708F));

        ModelPartData _gltfNode_254_r1 = leaves.addChild("_gltfNode_254_r1", ModelPartBuilder.create().uv(491, 497).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-3.0276F, -13.0769F, 1.4439F, 1.5708F, 0.829F, 1.5708F));

        ModelPartData _gltfNode_252_r1 = leaves.addChild("_gltfNode_252_r1", ModelPartBuilder.create().uv(498, 352).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-3.0276F, -17.837F, -2.2086F, 1.1527F, 0.2153F, 1.1382F));

        ModelPartData _gltfNode_250_r1 = leaves.addChild("_gltfNode_250_r1", ModelPartBuilder.create().uv(488, 256).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-5.8276F, -15.6156F, -0.5041F, 1.5708F, 0.5672F, 1.5708F));

        ModelPartData _gltfNode_248_r1 = leaves.addChild("_gltfNode_248_r1", ModelPartBuilder.create().uv(487, 473).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-5.8276F, -3.4456F, 8.8342F, -1.5708F, -1.2654F, -1.5708F));

        ModelPartData _gltfNode_246_r1 = leaves.addChild("_gltfNode_246_r1", ModelPartBuilder.create().uv(498, 346).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-3.0276F, -1.2242F, 10.5388F, -0.2578F, -1.1481F, 3.085F));

        ModelPartData _gltfNode_244_r1 = leaves.addChild("_gltfNode_244_r1", ModelPartBuilder.create().uv(491, 491).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-3.0276F, -5.9844F, 6.8862F, -1.5708F, -1.0036F, -1.5708F));

        ModelPartData _gltfNode_242_r1 = leaves.addChild("_gltfNode_242_r1", ModelPartBuilder.create().uv(496, 374).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-5.5276F, -19.6912F, -2.749F, 0.9732F, 0.4545F, 0.9622F));

        ModelPartData _gltfNode_240_r1 = leaves.addChild("_gltfNode_240_r1", ModelPartBuilder.create().uv(458, 498).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(1.4724F, -22.735F, 1.2177F, -1.1933F, 1.1955F, -0.7693F));

        ModelPartData _gltfNode_238_r1 = leaves.addChild("_gltfNode_238_r1", ModelPartBuilder.create().uv(486, 391).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(5.4724F, -20.9087F, -1.1623F, -2.1074F, 1.0473F, -1.8412F));

        ModelPartData _gltfNode_236_r1 = leaves.addChild("_gltfNode_236_r1", ModelPartBuilder.create().uv(497, 398).cuboid(-0.3835F, -4.5051F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-0.5276F, -20.2999F, -1.9557F, 1.0604F, 1.0737F, 1.431F));

        ModelPartData _gltfNode_234_r1 = leaves.addChild("_gltfNode_234_r1", ModelPartBuilder.create().uv(491, 503).cuboid(-0.3835F, -4.5051F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-6.5276F, -24.5613F, 3.5978F, 2.2571F, 1.3613F, 2.0722F));

        ModelPartData _gltfNode_232_r1 = leaves.addChild("_gltfNode_232_r1", ModelPartBuilder.create().uv(370, 503).cuboid(-0.3835F, -4.5051F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(2.4724F, -20.2999F, -1.9557F, -0.0872F, 1.3029F, 0.0649F));

        ModelPartData _gltfNode_230_r1 = leaves.addChild("_gltfNode_230_r1", ModelPartBuilder.create().uv(469, 504).cuboid(-0.3835F, -4.5051F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-1.5276F, -23.9525F, 2.8044F, -0.8926F, 0.8875F, -0.6059F));

        ModelPartData _gltfNode_228_r1 = leaves.addChild("_gltfNode_228_r1", ModelPartBuilder.create().uv(260, 497).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(0.4724F, -25.17F, 4.3911F, -1.4135F, 0.479F, -0.9462F));

        ModelPartData _gltfNode_226_r1 = leaves.addChild("_gltfNode_226_r1", ModelPartBuilder.create().uv(497, 454).cuboid(-0.3835F, -4.5051F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(4.4724F, -25.17F, 4.3911F, -0.487F, 1.0012F, -0.2753F));

        ModelPartData _gltfNode_224_r1 = leaves.addChild("_gltfNode_224_r1", ModelPartBuilder.create().uv(494, 304).cuboid(-0.3835F, -4.5051F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-4.5276F, -25.17F, 4.3911F, -1.5708F, 0.9163F, -1.5708F));

        ModelPartData _gltfNode_222_r1 = leaves.addChild("_gltfNode_222_r1", ModelPartBuilder.create().uv(501, 268).cuboid(-0.3835F, -4.5051F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-2.5276F, -21.5174F, -0.369F, -1.5708F, 1.2654F, -1.5708F));

        ModelPartData _gltfNode_220_r1 = leaves.addChild("_gltfNode_220_r1", ModelPartBuilder.create().uv(497, 386).cuboid(-4.6157F, -4.5051F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(2.4724F, -1.0691F, 12.8006F, -1.6496F, -0.2694F, -1.8483F));

        ModelPartData _gltfNode_218_r1 = leaves.addChild("_gltfNode_218_r1", ModelPartBuilder.create().uv(498, 473).cuboid(-4.6157F, -4.5051F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-1.5276F, -4.7217F, 17.5607F, -1.8243F, 0.1471F, -2.1231F));

        ModelPartData _gltfNode_216_r1 = leaves.addChild("_gltfNode_216_r1", ModelPartBuilder.create().uv(249, 497).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(0.4724F, -5.9392F, 19.1474F, -2.1764F, 0.614F, -2.2587F));

        ModelPartData _gltfNode_214_r1 = leaves.addChild("_gltfNode_214_r1", ModelPartBuilder.create().uv(497, 448).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(4.4724F, -5.9392F, 19.1474F, -1.6877F, -0.0764F, -2.1182F));

        ModelPartData _gltfNode_212_r1 = leaves.addChild("_gltfNode_212_r1", ModelPartBuilder.create().uv(282, 504).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-6.5276F, -5.3304F, 18.3541F, -1.4244F, -0.4437F, -1.4599F));

        ModelPartData _gltfNode_210_r1 = leaves.addChild("_gltfNode_210_r1", ModelPartBuilder.create().uv(494, 442).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-4.5276F, -5.9392F, 19.1474F, -1.5708F, 0.3927F, -1.5708F));

        ModelPartData _gltfNode_208_r1 = leaves.addChild("_gltfNode_208_r1", ModelPartBuilder.create().uv(469, 498).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(1.4724F, -3.5041F, 15.974F, -1.9602F, 0.0055F, -1.8373F));

        ModelPartData _gltfNode_206_r1 = leaves.addChild("_gltfNode_206_r1", ModelPartBuilder.create().uv(486, 397).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(5.4724F, -1.6779F, 13.594F, -1.8383F, 0.2436F, -1.4327F));

        ModelPartData _gltfNode_204_r1 = leaves.addChild("_gltfNode_204_r1", ModelPartBuilder.create().uv(496, 368).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-5.5276F, -0.4603F, 12.0073F, -0.8035F, -0.9714F, -2.7153F));

        ModelPartData _gltfNode_202_r1 = leaves.addChild("_gltfNode_202_r1", ModelPartBuilder.create().uv(497, 392).cuboid(-4.6157F, -4.5051F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-0.5276F, -1.0691F, 12.8006F, -1.8957F, -0.7527F, -1.662F));

        ModelPartData _gltfNode_200_r1 = leaves.addChild("_gltfNode_200_r1", ModelPartBuilder.create().uv(501, 274).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-2.5276F, -2.2866F, 14.3873F, -1.5708F, 0.0436F, -1.5708F));

        ModelPartData _gltfNode_198_r1 = leaves.addChild("_gltfNode_198_r1", ModelPartBuilder.create().uv(499, 298).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-7.9276F, -6.4411F, 17.5018F, -1.4366F, 0.1726F, -0.9047F));

        ModelPartData _gltfNode_196_r1 = leaves.addChild("_gltfNode_196_r1", ModelPartBuilder.create().uv(392, 496).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-7.9276F, -21.7016F, 3.6492F, 2.7296F, 1.2221F, 1.9753F));

        ModelPartData _gltfNode_194_r1 = leaves.addChild("_gltfNode_194_r1", ModelPartBuilder.create().uv(337, 498).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-7.9276F, -2.3919F, 13.0461F, -0.8267F, -0.2331F, -1.4322F));

        ModelPartData _gltfNode_192_r1 = leaves.addChild("_gltfNode_192_r1", ModelPartBuilder.create().uv(414, 496).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-7.9276F, -7.7698F, 12.8269F, -0.8832F, -0.5783F, -1.4095F));

        ModelPartData _gltfNode_190_r1 = leaves.addChild("_gltfNode_190_r1", ModelPartBuilder.create().uv(480, 491).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-7.9276F, -15.1781F, 3.361F, 2.5007F, 0.8452F, 1.7748F));

        ModelPartData _gltfNode_188_r1 = leaves.addChild("_gltfNode_188_r1", ModelPartBuilder.create().uv(282, 492).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-7.9276F, -4.726F, 8.8602F, -0.9911F, -0.9637F, -1.3329F));

        ModelPartData _gltfNode_186_r1 = leaves.addChild("_gltfNode_186_r1", ModelPartBuilder.create().uv(381, 496).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-7.9276F, -14.3562F, 11.5544F, -1.0579F, -0.2886F, -1.4197F));

        ModelPartData _gltfNode_184_r1 = leaves.addChild("_gltfNode_184_r1", ModelPartBuilder.create().uv(249, 503).cuboid(-0.3835F, -4.5051F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-7.9276F, -18.8306F, 8.1211F, -1.2122F, 0.9319F, -1.8152F));

        ModelPartData _gltfNode_182_r1 = leaves.addChild("_gltfNode_182_r1", ModelPartBuilder.create().uv(486, 455).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-7.9276F, -16.6277F, 9.6854F, 2.3361F, 0.9584F, 1.8245F));

        ModelPartData _gltfNode_180_r1 = leaves.addChild("_gltfNode_180_r1", ModelPartBuilder.create().uv(381, 502).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-7.9276F, -11.097F, 5.1059F, 2.2404F, 0.66F, 1.7545F));

        ModelPartData _gltfNode_178_r1 = leaves.addChild("_gltfNode_178_r1", ModelPartBuilder.create().uv(447, 504).cuboid(-0.3835F, -4.5051F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-7.9276F, -17.3111F, -0.9228F, 1.8832F, 0.9291F, 1.7584F));

        ModelPartData _gltfNode_176_r1 = leaves.addChild("_gltfNode_176_r1", ModelPartBuilder.create().uv(447, 498).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-7.9276F, -6.0963F, 15.2455F, -0.6338F, -0.0847F, -1.2019F));

        ModelPartData _gltfNode_174_r1 = leaves.addChild("_gltfNode_174_r1", ModelPartBuilder.create().uv(293, 503).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-7.9276F, -14.4815F, 13.8532F, -0.9599F, 0.3588F, -1.4161F));

        ModelPartData _gltfNode_172_r1 = leaves.addChild("_gltfNode_172_r1", ModelPartBuilder.create().uv(458, 504).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-7.9276F, -0.4603F, 12.0073F, -1.5476F, -0.8873F, -1.3931F));

        ModelPartData _gltfNode_170_r1 = leaves.addChild("_gltfNode_170_r1", ModelPartBuilder.create().uv(271, 506).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-7.9276F, -18.1594F, 3.4682F, 2.5521F, 1.1107F, 1.9385F));

        ModelPartData _gltfNode_168_r1 = leaves.addChild("_gltfNode_168_r1", ModelPartBuilder.create().uv(496, 362).cuboid(-4.6157F, -4.5051F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-7.9276F, -11.6223F, 8.4843F, -1.4866F, -1.2604F, -1.0787F));

        ModelPartData _gltfNode_166_r1 = leaves.addChild("_gltfNode_166_r1", ModelPartBuilder.create().uv(496, 380).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(8.2724F, -11.097F, 5.1059F, 0.9012F, 0.66F, 1.3871F));

        ModelPartData _gltfNode_164_r1 = leaves.addChild("_gltfNode_164_r1", ModelPartBuilder.create().uv(326, 498).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(8.2724F, -2.3919F, 13.0461F, -2.3149F, -0.2331F, -1.7094F));

        ModelPartData _gltfNode_162_r1 = leaves.addChild("_gltfNode_162_r1", ModelPartBuilder.create().uv(485, 379).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(8.2724F, -4.726F, 8.8602F, -2.1505F, -0.9637F, -1.8087F));

        ModelPartData _gltfNode_160_r1 = leaves.addChild("_gltfNode_160_r1", ModelPartBuilder.create().uv(348, 504).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(8.2724F, -0.4603F, 12.0073F, -1.594F, -0.8873F, -1.7485F));

        ModelPartData _gltfNode_158_r1 = leaves.addChild("_gltfNode_158_r1", ModelPartBuilder.create().uv(500, 334).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(8.2724F, -18.1594F, 3.4682F, 0.5895F, 1.1107F, 1.203F));

        ModelPartData _gltfNode_156_r1 = leaves.addChild("_gltfNode_156_r1", ModelPartBuilder.create().uv(436, 504).cuboid(-0.3835F, -4.5051F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(8.2724F, -17.3111F, -0.9228F, 1.2584F, 0.9291F, 1.3832F));

        ModelPartData _gltfNode_154_r1 = leaves.addChild("_gltfNode_154_r1", ModelPartBuilder.create().uv(436, 498).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(8.2724F, -6.0963F, 15.2455F, -2.5078F, -0.0847F, -1.9396F));

        ModelPartData _gltfNode_152_r1 = leaves.addChild("_gltfNode_152_r1", ModelPartBuilder.create().uv(304, 503).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(8.2724F, -14.4815F, 13.8532F, -2.1817F, 0.3588F, -1.7255F));

        ModelPartData _gltfNode_150_r1 = leaves.addChild("_gltfNode_150_r1", ModelPartBuilder.create().uv(496, 322).cuboid(-4.6157F, -4.5051F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(8.2724F, -11.6223F, 8.4843F, -1.655F, -1.2604F, -2.0629F));

        ModelPartData _gltfNode_148_r1 = leaves.addChild("_gltfNode_148_r1", ModelPartBuilder.create().uv(458, 492).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(8.2724F, -16.6277F, 9.6854F, 0.8055F, 0.9584F, 1.3171F));

        ModelPartData _gltfNode_146_r1 = leaves.addChild("_gltfNode_146_r1", ModelPartBuilder.create().uv(260, 503).cuboid(-0.3835F, -4.5051F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(8.2724F, -18.8306F, 8.1211F, -1.9294F, 0.9319F, -1.3264F));

        ModelPartData _gltfNode_144_r1 = leaves.addChild("_gltfNode_144_r1", ModelPartBuilder.create().uv(490, 274).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(8.2724F, -14.3562F, 11.5544F, -2.0837F, -0.2886F, -1.7219F));

        ModelPartData _gltfNode_142_r1 = leaves.addChild("_gltfNode_142_r1", ModelPartBuilder.create().uv(485, 385).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(8.2724F, -15.1781F, 3.361F, 0.6409F, 0.8452F, 1.3668F));

        ModelPartData _gltfNode_140_r1 = leaves.addChild("_gltfNode_140_r1", ModelPartBuilder.create().uv(490, 417).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(8.2724F, -7.7698F, 12.8269F, -2.2584F, -0.5783F, -1.7321F));

        ModelPartData _gltfNode_138_r1 = leaves.addChild("_gltfNode_138_r1", ModelPartBuilder.create().uv(403, 496).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(8.2724F, -21.7016F, 3.6492F, 0.412F, 1.2221F, 1.1663F));

        ModelPartData _gltfNode_136_r1 = leaves.addChild("_gltfNode_136_r1", ModelPartBuilder.create().uv(326, 504).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-5.0276F, -22.0555F, 8.5456F, -1.7102F, 0.4378F, -2.2555F));

        ModelPartData _gltfNode_134_r1 = leaves.addChild("_gltfNode_134_r1", ModelPartBuilder.create().uv(494, 409).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-7.0276F, -14.9153F, 14.0245F, -1.5708F, 0.3927F, -1.5708F));

        ModelPartData _gltfNode_132_r1 = leaves.addChild("_gltfNode_132_r1", ModelPartBuilder.create().uv(414, 502).cuboid(-0.3835F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-6.7276F, -8.6478F, 18.8337F, -1.0129F, -1.072F, -2.5147F));

        ModelPartData _gltfNode_130_r1 = leaves.addChild("_gltfNode_130_r1", ModelPartBuilder.create().uv(498, 467).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(-1.7276F, -23.7692F, 7.2307F, 1.0286F, 0.8571F, 0.741F));

        ModelPartData _gltfNode_128_r1 = leaves.addChild("_gltfNode_128_r1", ModelPartBuilder.create().uv(403, 502).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(1.2724F, -13.4556F, 15.1446F, 0.8021F, 0.9635F, 0.5616F));

        ModelPartData _gltfNode_126_r1 = leaves.addChild("_gltfNode_126_r1", ModelPartBuilder.create().uv(492, 244).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(6.8724F, -17.4224F, 12.1007F, -1.4704F, 0.6392F, -2.2747F));

        ModelPartData _gltfNode_124_r1 = leaves.addChild("_gltfNode_124_r1", ModelPartBuilder.create().uv(425, 496).cuboid(-4.6157F, -4.5051F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(2.9724F, -19.8449F, 10.494F, 1.0975F, 0.8396F, 1.6361F));

        ModelPartData _gltfNode_122_r1 = leaves.addChild("_gltfNode_122_r1", ModelPartBuilder.create().uv(492, 328).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(0.5724F, -17.4224F, 12.1007F, 1.9201F, 1.0426F, 1.6228F));

        ModelPartData _gltfNode_120_r1 = leaves.addChild("_gltfNode_120_r1", ModelPartBuilder.create().uv(480, 497).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(5.5724F, -11.8689F, 16.3621F, -1.5708F, 1.0472F, -1.5708F));

        ModelPartData _gltfNode_118_r1 = leaves.addChild("_gltfNode_118_r1", ModelPartBuilder.create().uv(494, 310).cuboid(-4.6157F, -4.5051F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(1.9724F, -9.1715F, 18.4319F, -1.5708F, 0.9163F, -1.5708F));

        ModelPartData _gltfNode_116_r1 = leaves.addChild("_gltfNode_116_r1", ModelPartBuilder.create().uv(499, 262).cuboid(-4.6157F, -4.5052F, 0.0F, 5.0F, 5.0F, 0.001F, new Dilation(0.0F)), ModelTransform.of(8.2724F, -6.4411F, 17.5018F, -1.7049F, 0.1726F, -2.2369F));

        ModelPartData _gltfNode_114_r1 = leaves.addChild("_gltfNode_114_r1", ModelPartBuilder.create().uv(81, 28).cuboid(-34.7859F, -74.6707F, -0.0013F, 23.9999F, 11.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(-7.8276F, 11.1852F, -60.0389F, -1.5708F, 0.6545F, -1.5708F));
        return TexturedModelData.of(modelData, 512, 512);
    }

    @Override
    public void setAngles(EntEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngles(netHeadYaw, headPitch);

        this.animateMovement(EntAnimations.WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.updateAnimation(entity.idleAnimationState, EntAnimations.IDLE, ageInTicks, 1f);
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
        ent.render(matrices, vertexConsumer, light, overlay, color);
    }

    @Override
    public ModelPart getPart() {
        return ent;
    }
}
