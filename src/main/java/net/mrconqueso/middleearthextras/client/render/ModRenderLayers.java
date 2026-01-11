package net.mrconqueso.middleearthextras.client.render;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderPhase;
import net.minecraft.client.render.VertexFormat;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.util.Identifier;

public class ModRenderLayers extends RenderLayer {

    // Define the shader phase using our helper
    protected static final RenderPhase.ShaderProgram WRAITH_SWAY_SHADER = new RenderPhase.ShaderProgram(ModInternalShaders::getRenderTypeWraithSwayShader);

    public ModRenderLayers(String name, VertexFormat vertexFormat, VertexFormat.DrawMode drawMode, int expectedBufferSize, boolean hasCrumbling, boolean translucent, Runnable startAction, Runnable endAction) {
        super(name, vertexFormat, drawMode, expectedBufferSize, hasCrumbling, translucent, startAction, endAction);
    }

    public static RenderLayer getWraithSway(Identifier texture) {
        // Creates a composite render layer
        return RenderLayer.of(
                "wraith_sway",
                VertexFormats.POSITION_COLOR_TEXTURE_OVERLAY_LIGHT_NORMAL,
                VertexFormat.DrawMode.QUADS,
                256,
                true, // hasCrumbling
                true, // translucent
                RenderLayer.MultiPhaseParameters.builder()
                        .program(WRAITH_SWAY_SHADER) // Use our custom shader
                        .texture(new RenderPhase.Texture(texture, false, false))
                        .transparency(TRANSLUCENT_TRANSPARENCY)
                        .cull(DISABLE_CULLING)
                        .lightmap(ENABLE_LIGHTMAP)
                        .overlay(ENABLE_OVERLAY_COLOR)
                        .build(true)
        );
    }
}