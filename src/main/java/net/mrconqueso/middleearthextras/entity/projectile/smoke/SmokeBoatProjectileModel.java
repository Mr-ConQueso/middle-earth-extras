package net.mrconqueso.middleearthextras.entity.projectile.smoke;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.mrconqueso.middleearthextras.MiddleEarthExtras;

public class SmokeBoatProjectileModel extends EntityModel<SmokeBoatProjectileEntity> {

    public static final EntityModelLayer SMOKE_BOAT = new EntityModelLayer(Identifier.of(MiddleEarthExtras.MOD_ID, "smoke_boat"), "main");

    // Made with Blockbench 4.11.2
    // Exported for Minecraft version 1.17+ for Yarn
    // Paste this class into your mod and generate all required imports

    private final ModelPart smoke_boat;

    public SmokeBoatProjectileModel(ModelPart root) {
        this.smoke_boat = root.getChild("smoke_boat");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData smoke_boat = modelPartData.addChild("smoke_boat", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData hull = smoke_boat.addChild("hull", ModelPartBuilder.create().uv(228, 108).cuboid(-4.0406F, -17.6075F, -40.0999F, 6.75F, 5.75F, 9.0F, new Dilation(0.0F))
                .uv(227, 68).cuboid(-2.7094F, -17.6075F, -40.0999F, 6.75F, 5.75F, 9.0F, new Dilation(0.0F))
                .uv(0, 36).cuboid(-13.0F, -7.5714F, -9.8909F, 26.0F, 5.0F, 21.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-7.0F, 5.4286F, -13.6409F, 14.0F, 5.0F, 29.75F, new Dilation(0.0F))
                .uv(0, 94).cuboid(-13.0F, -17.5714F, 17.1091F, 26.0F, 5.0F, 14.0F, new Dilation(0.0F))
                .uv(95, 45).cuboid(-13.0F, -26.5714F, 26.1091F, 26.0F, 9.0F, 8.0F, new Dilation(0.0F))
                .uv(220, 134).cuboid(-5.0F, -11.5714F, -29.3909F, 10.0F, 5.0F, 14.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -17.4286F, -0.1091F));

        ModelPartData cube_r1 = hull.addChild("cube_r1", ModelPartBuilder.create().uv(89, 0).cuboid(-13.0F, -2.5F, -10.5F, 26.0F, 5.0F, 17.75F, new Dilation(0.0F)), ModelTransform.of(0.0F, -10.0714F, 15.6091F, 1.0472F, 0.0F, 0.0F));

        ModelPartData cube_r2 = hull.addChild("cube_r2", ModelPartBuilder.create().uv(81, 94).cuboid(-13.0F, -2.5F, -7.0F, 26.0F, 5.0F, 14.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -5.3214F, -11.6409F, -0.6981F, 0.0F, 0.0F));

        ModelPartData cube_r3 = hull.addChild("cube_r3", ModelPartBuilder.create().uv(0, 205).cuboid(-9.0F, -6.0F, 6.0F, 18.0F, 5.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -8.0714F, 24.1091F, -2.4435F, 0.0F, 0.0F));

        ModelPartData cube_r4 = hull.addChild("cube_r4", ModelPartBuilder.create().uv(95, 24).cuboid(-11.0F, -2.5F, -7.0F, 22.0F, 5.0F, 15.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -8.0714F, 24.1091F, -1.9635F, 0.0F, 0.0F));

        ModelPartData cube_r5 = hull.addChild("cube_r5", ModelPartBuilder.create().uv(106, 114).cuboid(-6.0F, -4.5F, -17.0F, 12.0F, 5.0F, 20.25F, new Dilation(0.0F)), ModelTransform.of(0.0F, 7.9286F, -15.8909F, -0.6545F, 0.0F, 0.0F));

        ModelPartData cube_r6 = hull.addChild("cube_r6", ModelPartBuilder.create().uv(220, 154).cuboid(-5.0F, -4.5F, -11.0F, 10.0F, 5.0F, 11.25F, new Dilation(0.0F)), ModelTransform.of(0.0F, -2.4203F, -29.3779F, -1.2217F, 0.0F, 0.0F));

        ModelPartData cube_r7 = hull.addChild("cube_r7", ModelPartBuilder.create().uv(114, 208).cuboid(-4.75F, -9.75F, -4.5F, 6.0F, 5.0F, 18.0F, new Dilation(0.0F)), ModelTransform.of(17.1226F, -9.9434F, 20.5819F, 1.0033F, -0.1309F, 0.0019F));

        ModelPartData cube_r8 = hull.addChild("cube_r8", ModelPartBuilder.create().uv(163, 140).cuboid(-5.0F, -2.5F, 0.5F, 10.0F, 5.0F, 18.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -9.0714F, -29.8909F, 0.0F, 0.48F, 0.0F));

        ModelPartData cube_r9 = hull.addChild("cube_r9", ModelPartBuilder.create().uv(227, 20).cuboid(-13.0F, -2.75F, -20.5F, 6.0F, 5.0F, 10.0F, new Dilation(0.0F))
                .uv(59, 223).cuboid(-5.25F, -2.75F, -1.5F, 6.0F, 5.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(15.2906F, -14.1075F, -21.5999F, -0.0454F, 0.2175F, -0.0174F));

        ModelPartData cube_r10 = hull.addChild("cube_r10", ModelPartBuilder.create().uv(92, 232).cuboid(-4.5F, 0.5F, 2.75F, 6.0F, 5.0F, 8.25F, new Dilation(0.0F)), ModelTransform.of(16.107F, -18.7123F, -14.8004F, -0.7515F, 0.2186F, 0.0216F));

        ModelPartData cube_r11 = hull.addChild("cube_r11", ModelPartBuilder.create().uv(212, 208).cuboid(-7.0F, -2.5F, -11.0F, 5.0F, 5.0F, 18.0F, new Dilation(0.0F)), ModelTransform.of(11.2537F, -14.6726F, -29.3947F, -0.0637F, 0.9154F, -0.0278F));

        ModelPartData cube_r12 = hull.addChild("cube_r12", ModelPartBuilder.create().uv(106, 140).cuboid(-3.25F, -2.5F, -11.5F, 6.0F, 5.0F, 22.0F, new Dilation(0.0F)), ModelTransform.of(16.5F, -9.0714F, 0.6091F, 0.0437F, 0.0436F, 0.0019F));

        ModelPartData cube_r13 = hull.addChild("cube_r13", ModelPartBuilder.create().uv(57, 157).cuboid(-2.0F, 0.0F, -9.0F, 4.0F, 21.0F, 18.0F, new Dilation(0.0F)), ModelTransform.of(8.8456F, -26.4844F, 34.5588F, -1.0842F, -1.2991F, 1.0638F));

        ModelPartData cube_r14 = hull.addChild("cube_r14", ModelPartBuilder.create().uv(0, 114).cuboid(-3.0F, -14.5F, -11.0F, 6.0F, 22.0F, 20.0F, new Dilation(0.0F)), ModelTransform.of(15.3847F, -17.6376F, 24.6906F, 1.5708F, -0.1047F, 0.0175F));

        ModelPartData cube_r15 = hull.addChild("cube_r15", ModelPartBuilder.create().uv(170, 44).cuboid(-5.5F, 3.0F, -8.25F, 11.0F, 2.0F, 17.0F, new Dilation(0.0F)), ModelTransform.of(15.1462F, -2.7648F, 17.6583F, -0.5236F, 0.0F, 1.9199F));

        ModelPartData cube_r16 = hull.addChild("cube_r16", ModelPartBuilder.create().uv(0, 185).cuboid(-0.8373F, -0.4553F, -7.8299F, 11.0F, 2.0F, 17.0F, new Dilation(0.0F)), ModelTransform.of(9.9254F, 1.813F, 15.5333F, -0.4636F, 0.2527F, 2.3835F));

        ModelPartData cube_r17 = hull.addChild("cube_r17", ModelPartBuilder.create().uv(162, 94).cuboid(2.0F, -2.5F, -8.5F, 11.0F, 2.0F, 17.0F, new Dilation(0.0F)), ModelTransform.of(17.0F, -10.0714F, 0.6091F, -0.0436F, 0.0F, 1.9199F));

        ModelPartData cube_r18 = hull.addChild("cube_r18", ModelPartBuilder.create().uv(170, 24).cuboid(-3.5F, 5.75F, -8.5F, 11.0F, 2.0F, 17.0F, new Dilation(0.0F)), ModelTransform.of(15.843F, 9.4888F, 0.6745F, -0.0378F, 0.0218F, 2.443F));

        ModelPartData cube_r19 = hull.addChild("cube_r19", ModelPartBuilder.create().uv(0, 63).cuboid(-8.5F, 3.0F, -19.75F, 14.0F, 2.0F, 28.0F, new Dilation(0.0F)), ModelTransform.of(15.6462F, -2.7648F, -16.4402F, 0.5236F, 0.0F, 1.9199F));

        ModelPartData cube_r20 = hull.addChild("cube_r20", ModelPartBuilder.create().uv(147, 188).cuboid(-0.8373F, -0.4553F, -9.1701F, 11.0F, 2.0F, 17.0F, new Dilation(0.0F)), ModelTransform.of(10.4254F, 1.813F, -14.3152F, 0.4636F, -0.2527F, 2.3835F));

        ModelPartData cube_r21 = hull.addChild("cube_r21", ModelPartBuilder.create().uv(163, 208).cuboid(-1.25F, -9.75F, -4.5F, 6.0F, 5.0F, 18.0F, new Dilation(0.0F)), ModelTransform.of(-17.1226F, -9.9434F, 20.5819F, 1.0033F, 0.1309F, -0.0019F));

        ModelPartData cube_r22 = hull.addChild("cube_r22", ModelPartBuilder.create().uv(163, 164).cuboid(-5.0F, -2.5F, 0.5F, 10.0F, 5.0F, 18.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -9.0714F, -29.8909F, 0.0F, -0.48F, 0.0F));

        ModelPartData cube_r23 = hull.addChild("cube_r23", ModelPartBuilder.create().uv(227, 52).cuboid(7.0F, -2.75F, -20.5F, 6.0F, 5.0F, 10.0F, new Dilation(0.0F))
                .uv(227, 36).cuboid(-0.75F, -2.75F, -1.5F, 6.0F, 5.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(-15.2906F, -14.1075F, -21.5999F, -0.0454F, -0.2175F, 0.0174F));

        ModelPartData cube_r24 = hull.addChild("cube_r24", ModelPartBuilder.create().uv(121, 232).cuboid(-1.5F, 0.5F, 2.75F, 6.0F, 5.0F, 8.25F, new Dilation(0.0F)), ModelTransform.of(-16.107F, -18.7123F, -14.8004F, -0.7515F, -0.2186F, -0.0216F));

        ModelPartData cube_r25 = hull.addChild("cube_r25", ModelPartBuilder.create().uv(219, 84).cuboid(2.0F, -2.5F, -11.0F, 5.0F, 5.0F, 18.0F, new Dilation(0.0F)), ModelTransform.of(-11.2537F, -14.6726F, -29.3947F, -0.0637F, -0.9154F, 0.0278F));

        ModelPartData cube_r26 = hull.addChild("cube_r26", ModelPartBuilder.create().uv(0, 157).cuboid(-2.75F, -2.5F, -11.5F, 6.0F, 5.0F, 22.0F, new Dilation(0.0F)), ModelTransform.of(-16.5F, -9.0714F, 0.6091F, 0.0437F, -0.0436F, -0.0019F));

        ModelPartData cube_r27 = hull.addChild("cube_r27", ModelPartBuilder.create().uv(102, 168).cuboid(-2.0F, 0.0F, -9.0F, 4.0F, 21.0F, 18.0F, new Dilation(0.0F)), ModelTransform.of(-8.8456F, -26.4844F, 34.5588F, -1.0842F, 1.2991F, -1.0638F));

        ModelPartData cube_r28 = hull.addChild("cube_r28", ModelPartBuilder.create().uv(53, 114).cuboid(-3.0F, -14.5F, -11.0F, 6.0F, 22.0F, 20.0F, new Dilation(0.0F)), ModelTransform.of(-15.3847F, -17.6376F, 24.6906F, 1.5708F, 0.1047F, -0.0175F));

        ModelPartData cube_r29 = hull.addChild("cube_r29", ModelPartBuilder.create().uv(178, 0).cuboid(-5.5F, 3.0F, -8.25F, 11.0F, 2.0F, 17.0F, new Dilation(0.0F)), ModelTransform.of(-15.1462F, -2.7648F, 17.6583F, -0.5236F, 0.0F, -1.9199F));

        ModelPartData cube_r30 = hull.addChild("cube_r30", ModelPartBuilder.create().uv(204, 188).cuboid(-10.1627F, -0.4553F, -7.8299F, 11.0F, 2.0F, 17.0F, new Dilation(0.0F)), ModelTransform.of(-9.9254F, 1.813F, 15.5333F, -0.4636F, -0.2527F, -2.3835F));

        ModelPartData cube_r31 = hull.addChild("cube_r31", ModelPartBuilder.create().uv(171, 114).cuboid(-13.0F, -2.5F, -8.5F, 11.0F, 2.0F, 17.0F, new Dilation(0.0F)), ModelTransform.of(-17.0F, -10.0714F, 0.6091F, -0.0436F, 0.0F, -1.9199F));

        ModelPartData cube_r32 = hull.addChild("cube_r32", ModelPartBuilder.create().uv(170, 64).cuboid(-7.5F, 5.75F, -8.5F, 11.0F, 2.0F, 17.0F, new Dilation(0.0F)), ModelTransform.of(-15.843F, 9.4888F, 0.6745F, -0.0378F, -0.0218F, -2.443F));

        ModelPartData cube_r33 = hull.addChild("cube_r33", ModelPartBuilder.create().uv(85, 63).cuboid(-5.5F, 3.0F, -19.75F, 14.0F, 2.0F, 28.0F, new Dilation(0.0F)), ModelTransform.of(-15.6462F, -2.7648F, -16.4402F, 0.5236F, 0.0F, -1.9199F));

        ModelPartData cube_r34 = hull.addChild("cube_r34", ModelPartBuilder.create().uv(57, 203).cuboid(-10.1627F, -0.4553F, -9.1701F, 11.0F, 2.0F, 17.0F, new Dilation(0.0F)), ModelTransform.of(-10.4254F, 1.813F, -14.3152F, 0.4636F, 0.2527F, -2.3835F));

        ModelPartData mastil = hull.addChild("mastil", ModelPartBuilder.create().uv(21, 221).cuboid(-3.0F, -23.875F, -3.0F, 6.0F, 24.0F, 6.0F, new Dilation(0.0F))
                .uv(0, 221).cuboid(-2.4F, -56.875F, -2.4F, 4.8F, 33.0F, 4.8F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -7.6964F, 6.1091F));

        ModelPartData cube_r35 = mastil.addChild("cube_r35", ModelPartBuilder.create().uv(46, 223).cuboid(-1.3F, -19.0F, -1.3F, 2.6F, 38.0F, 2.6F, new Dilation(0.0F)), ModelTransform.of(0.0F, -48.875F, 0.0F, 0.0F, 0.0F, 1.5708F));

        ModelPartData sail = mastil.addChild("sail", ModelPartBuilder.create().uv(170, 84).cuboid(-9.0F, 14.63F, -5.4541F, 18.0F, 9.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -47.505F, -2.5459F));

        ModelPartData cube_r36 = sail.addChild("cube_r36", ModelPartBuilder.create().uv(150, 232).cuboid(0.0F, -17.6494F, -1.1504F, 9.0F, 15.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(8.75F, 17.435F, -4.8247F, -0.1745F, -0.3491F, 0.0F));

        ModelPartData cube_r37 = sail.addChild("cube_r37", ModelPartBuilder.create().uv(220, 171).cuboid(-9.0F, -14.75F, 0.0F, 18.0F, 15.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 14.38F, -5.4541F, -0.1745F, 0.0F, 0.0F));

        ModelPartData cube_r38 = sail.addChild("cube_r38", ModelPartBuilder.create().uv(169, 232).cuboid(-9.0F, -17.6494F, -1.1504F, 9.0F, 15.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-8.75F, 17.435F, -4.8247F, -0.1745F, 0.3491F, 0.0F));

        ModelPartData cube_r39 = sail.addChild("cube_r39", ModelPartBuilder.create().uv(188, 232).cuboid(-9.0F, -2.8051F, -0.6295F, 9.0F, 9.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-8.75F, 17.435F, -4.8247F, 0.0F, 0.3491F, 0.0F));

        ModelPartData cube_r40 = sail.addChild("cube_r40", ModelPartBuilder.create().uv(207, 232).cuboid(-9.0F, 6.1949F, -0.6295F, 9.0F, 8.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-8.75F, 17.435F, -4.8247F, 0.0F, 0.3491F, 0.0F));

        ModelPartData cube_r41 = sail.addChild("cube_r41", ModelPartBuilder.create().uv(57, 192).cuboid(-9.0F, -0.25F, 0.0F, 18.0F, 8.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 23.88F, -5.4541F, 0.0F, 0.0F, 0.0F));

        ModelPartData cube_r42 = sail.addChild("cube_r42", ModelPartBuilder.create().uv(92, 223).cuboid(0.0F, 6.1949F, -0.6295F, 9.0F, 8.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(8.75F, 17.435F, -4.8247F, 0.0F, -0.3491F, 0.0F));

        ModelPartData cube_r43 = sail.addChild("cube_r43", ModelPartBuilder.create().uv(228, 124).cuboid(0.0F, -2.8051F, -0.6295F, 9.0F, 9.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(8.75F, 17.435F, -4.8247F, 0.0F, -0.3491F, 0.0F));
        return TexturedModelData.of(modelData, 512, 512);
    }

    @Override
    public void setAngles(SmokeBoatProjectileEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.smoke_boat.traverse().forEach(ModelPart::resetTransform);
        this.animateModel(entity, limbSwing, limbSwingAmount, 2f);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
        smoke_boat.render(matrices, vertexConsumer, light, overlay, color);
    }
}
