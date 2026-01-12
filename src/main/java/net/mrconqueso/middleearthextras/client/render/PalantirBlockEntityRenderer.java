package net.mrconqueso.middleearthextras.client.render;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.render.*;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.mrconqueso.middleearthextras.block.entity.PalantirBlockEntity;
import org.joml.Matrix4f;

public class PalantirBlockEntityRenderer implements BlockEntityRenderer<PalantirBlockEntity> {

    public PalantirBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {
    }

    @Override
    public void render(PalantirBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        if (entity.getLinkedPos() != null) {
            // Generate the view texture
            int textureId = PalantirReflector.renderPalantirView(entity);

            if (textureId != -1) {
                matrices.push();

                // Draw the "screen" on the block faces
                // We'll draw a slightly smaller cube inside so it doesn't z-fight if there's a glass shell
                float size = 0.6f;
                float offset = (1.0f - size) / 2.0f;
                matrices.translate(offset, offset, offset);

                RenderSystem.setShader(GameRenderer::getPositionTexProgram);
                RenderSystem.setShaderTexture(0, textureId);
                RenderSystem.enableDepthTest();

                Matrix4f matrix = matrices.peek().getPositionMatrix();
                Tessellator tessellator = Tessellator.getInstance();
                BufferBuilder buffer = tessellator.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_TEXTURE);

                // Add vertices for a cube
                drawCube(matrix, buffer, size);

                // This will crash if drawCube adds 0 vertices, but drawCube below adds 24 vertices.
                BufferRenderer.drawWithGlobalProgram(buffer.end());
                
                matrices.pop();
            }
        }
    }

    private void drawCube(Matrix4f matrix, BufferBuilder buffer, float s) {
        // Front (South) - Flipped V (1->0, 0->1)
        buffer.vertex(matrix, 0, 0, s).texture(0, 0);
        buffer.vertex(matrix, s, 0, s).texture(1, 0);
        buffer.vertex(matrix, s, s, s).texture(1, 1);
        buffer.vertex(matrix, 0, s, s).texture(0, 1);

        // Back (North)
        buffer.vertex(matrix, s, 0, 0).texture(0, 0);
        buffer.vertex(matrix, 0, 0, 0).texture(1, 0);
        buffer.vertex(matrix, 0, s, 0).texture(1, 1);
        buffer.vertex(matrix, s, s, 0).texture(0, 1);

        // Right (East)
        buffer.vertex(matrix, s, 0, s).texture(0, 0);
        buffer.vertex(matrix, s, 0, 0).texture(1, 0);
        buffer.vertex(matrix, s, s, 0).texture(1, 1);
        buffer.vertex(matrix, s, s, s).texture(0, 1);

        // Left (West)
        buffer.vertex(matrix, 0, 0, 0).texture(0, 0);
        buffer.vertex(matrix, 0, 0, s).texture(1, 0);
        buffer.vertex(matrix, 0, s, s).texture(1, 1);
        buffer.vertex(matrix, 0, s, 0).texture(0, 1);

        // Top
        buffer.vertex(matrix, 0, s, 0).texture(0, 1);
        buffer.vertex(matrix, 0, s, s).texture(0, 0);
        buffer.vertex(matrix, s, s, s).texture(1, 0);
        buffer.vertex(matrix, s, s, 0).texture(1, 1);

        // Bottom
        buffer.vertex(matrix, 0, 0, s).texture(0, 1);
        buffer.vertex(matrix, 0, 0, 0).texture(0, 0);
        buffer.vertex(matrix, s, 0, 0).texture(1, 0);
        buffer.vertex(matrix, s, 0, s).texture(1, 1);
    }
}