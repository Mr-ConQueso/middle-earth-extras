package net.mrconqueso.middleearthextras.mixin.client;

import net.jukoz.me.datageneration.VariantsModelProvider;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.mrconqueso.middleearthextras.item.items.MagicPipeItem;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ItemRenderer.class)
public class ItemRendererMixin {

    @Debug(export = true)
    @ModifyVariable(method = "renderItem(Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/render/model/json/ModelTransformationMode;ZLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;IILnet/minecraft/client/render/model/BakedModel;)V",
            at = @At("HEAD"), ordinal = 0, argsOnly = true)
    private BakedModel renderItem(BakedModel model, ItemStack stack, ModelTransformationMode renderMode, boolean leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        if (renderMode == ModelTransformationMode.GUI || renderMode == ModelTransformationMode.GROUND || renderMode == ModelTransformationMode.FIXED) {

            if (stack.getItem() instanceof MagicPipeItem item) {
                Identifier identifier = VariantsModelProvider.getInventoryModelIdentifierVariant(item);
                BakedModel flatModel = MinecraftClient.getInstance().getBakedModelManager().getModel(identifier);
                if (flatModel == null) return model;
                return flatModel;
            }
        }
        return model;
    }
}
