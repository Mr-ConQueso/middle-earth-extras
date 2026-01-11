package net.mrconqueso.middleearthextras.client.render;

import net.minecraft.client.gl.ShaderProgram;
import org.jetbrains.annotations.Nullable;

public class ModInternalShaders {

    private static ShaderProgram renderTypeWraithSwayShader;

    @Nullable
    public static ShaderProgram getRenderTypeWraithSwayShader() {
        return renderTypeWraithSwayShader;
    }

    public static void setRenderTypeWraithSwayShader(ShaderProgram shader) {
        renderTypeWraithSwayShader = shader;
    }
}