package net.mrconqueso.middleearthextras.compat.accesories;

import io.wispforest.accessories.api.client.AccessoryRenderer;
import io.wispforest.accessories.api.client.SimpleAccessoryRenderer;
import io.wispforest.accessories.api.slot.SlotReference;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RotationAxis;

public class RingAccesoryRenderer implements SimpleAccessoryRenderer {

    @Override
    public <M extends LivingEntity> void align(ItemStack stack, SlotReference reference, EntityModel<M> model, MatrixStack matrices) {
        if (model instanceof BipedEntityModel armModel) {
            // Align to right arm
            AccessoryRenderer.transformToModelPart(matrices, armModel.rightArm, 0, 0, 0);

            // Fine-tune position for a ring on a finger
            // Adjust these values as needed based on testing
            matrices.translate(0, 0.65, 0);
            matrices.scale(0.4f, 0.4f, 0.4f);
            matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(90));
        }
    }

    @Override
    public <M extends LivingEntity> void render(ItemStack stack, SlotReference reference, MatrixStack matrices, EntityModel<M> model, VertexConsumerProvider multiBufferSource, int light, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {

        align(stack, reference, model, matrices);
        MinecraftClient.getInstance().getItemRenderer().renderItem(
                stack,
                ModelTransformationMode.FIXED,
                light,
                OverlayTexture.DEFAULT_UV,
                matrices,
                multiBufferSource,
                reference.entity().getWorld(),
                0
        );
    }
}
