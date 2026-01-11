package net.mrconqueso.middleearthextras.entity.client.ringwraith;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.mrconqueso.middleearthextras.MiddleEarthExtras;
import net.mrconqueso.middleearthextras.effect.ModEffects;
import net.mrconqueso.middleearthextras.entity.client.ModEntityModelLayers;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.mrconqueso.middleearthextras.MiddleEarthExtras;
import net.mrconqueso.middleearthextras.effect.ModEffects;
import net.mrconqueso.middleearthextras.entity.client.ModEntityModelLayers;
import net.mrconqueso.middleearthextras.entity.custom.RingWraithEntity;
import net.mrconqueso.middleearthextras.item.ModEquipmentItems;

import java.util.HashMap;
import java.util.Map;

public class RingWraithHumanRenderer extends BipedEntityRenderer<RingWraithEntity, RingWraithHumanModel<RingWraithEntity>> {
    public RingWraithHumanRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new RingWraithHumanModel<>(ctx.getPart(ModEntityModelLayers.HUMAN)), 0.5f);
        this.addFeature(new ArmorFeatureRenderer<>(this, new RingWraithHumanModel(ctx.getPart(EntityModelLayers.PLAYER_INNER_ARMOR)),
                new RingWraithHumanModel(ctx.getPart(EntityModelLayers.PLAYER_OUTER_ARMOR)), ctx.getModelManager()));

    }

    @Override
    public Identifier getTexture(RingWraithEntity entity) {
        return Identifier.of(MiddleEarthExtras.MOD_ID, "textures/entity/ring_wraith/ring_wraith.png");
    }

    @Override
    public void render(RingWraithEntity entity, float entityYaw, float partialTick, MatrixStack poseStack,
                       VertexConsumerProvider bufferSource, int packedLight) {

        poseStack.scale(0.95f, 0.95f, 0.95f);

        MinecraftClient client = MinecraftClient.getInstance();
        boolean viewerHasSight = client.player != null && client.player.hasStatusEffect(ModEffects.UNSEEN_FORM);

        // Store original visibility state
        boolean wasVisible = this.model.head.visible;
        
        // Map to store original items to restore them later
        Map<EquipmentSlot, ItemStack> originalEquipment = new HashMap<>();

        if (!viewerHasSight) {
            // Case 1: Normal Player looking at Wraith
            // Hides the body, shows the floating black robes
            this.model.setVisible(false);
            this.model.hat.visible = false;
        } else {
            // Case 2: Wraith Player looking at Wraith
            // Shows the body, but swaps the armor to the "True Form" (e.g. Ancient King Armor)
            
            // 1. Save original equipment
            for (EquipmentSlot slot : EquipmentSlot.values()) {
                if (slot.getType() == EquipmentSlot.Type.HUMANOID_ARMOR) {
                    originalEquipment.put(slot, entity.getEquippedStack(slot));
                }
            }

            // 2. Swap to "Ghost/King" Armor temporarily
            // REPLACE THESE with your actual ModItems for the true form
            // Example: ModEquipmentItems.GHOST_HELMET
            entity.equipStack(EquipmentSlot.HEAD, ModEquipmentItems.NAZGUL_HELMET.getDefaultStack());
            entity.equipStack(EquipmentSlot.CHEST, ModEquipmentItems.NAZGUL_CHESTPLATE.getDefaultStack());
            entity.equipStack(EquipmentSlot.LEGS, ModEquipmentItems.NAZGUL_LEGGINGS.getDefaultStack());
            entity.equipStack(EquipmentSlot.FEET, ModEquipmentItems.NAZGUL_BOOTS.getDefaultStack());
        }

        // Render with whatever state we set up
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);

        // RESTORE STATE
        if (!viewerHasSight) {
            this.model.setVisible(wasVisible);
        } else {
            // Restore original black robes
            for (Map.Entry<EquipmentSlot, ItemStack> entry : originalEquipment.entrySet()) {
                entity.equipStack(entry.getKey(), entry.getValue());
            }
        }
    }
}