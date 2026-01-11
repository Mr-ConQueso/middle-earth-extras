package net.mrconqueso.middleearthextras.entity.client.oliphaunt;

import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.EntityModelLoader;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.mrconqueso.middleearthextras.MiddleEarthExtras;
import net.mrconqueso.middleearthextras.entity.custom.OliphauntEntity;
import net.mrconqueso.middleearthextras.item.items.OliphauntArmorItem;

public class OliphauntArmorFeatureRenderer extends FeatureRenderer<OliphauntEntity, OliphauntModel<OliphauntEntity>> {

    private final Identifier ARMOR = Identifier.of(MiddleEarthExtras.MOD_ID, "textures/entities/oliphaunt/armor/armor.png");
    private final OliphauntModel<OliphauntEntity> model;

    public OliphauntArmorFeatureRenderer(FeatureRendererContext<OliphauntEntity, OliphauntModel<OliphauntEntity>> context, EntityModelLoader loader) {
        super(context);
        model = new OliphauntModel<>(loader.getModelPart(OliphauntModel.OLIPHAUNT_ARMOR));
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, OliphauntEntity entity, float limbSwing, float limbSwingAmount,
                       float partialTick, float ageInTicks, float netHeadYaw, float headPitch) {
        if (entity.hasArmorOn()) {
            ItemStack itemStack = entity.getBodyArmor();
            if (itemStack.getItem() instanceof OliphauntArmorItem armorItem) {
                (this.getContextModel()).copyStateTo(this.model);
                this.model.animateModel(entity, limbSwing, limbSwingAmount, partialTick);
                this.model.setAngles(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
                VertexConsumer vertexConsumer = vertexConsumers.getBuffer(RenderLayer.getEntityCutoutNoCull(ARMOR));
                this.model.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV);
                //this.renderDyed(matrices, vertexConsumers, light, entity, armorItem);
            }
        }
    }
}
