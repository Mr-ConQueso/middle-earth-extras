package net.mrconqueso.middleearthextras.client.render;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.systems.VertexSorter;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.gl.SimpleFramebuffer;
import net.minecraft.client.option.GraphicsMode;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.Frustum;
import net.minecraft.util.math.Vec3d;
import net.mrconqueso.middleearthextras.block.entity.PalantirBlockEntity;
import net.mrconqueso.middleearthextras.mixin.client.mirror.WorldRendererAccessor;
import net.mrconqueso.middleearthextras.mixin.client.screenshake.CameraAccessor;
import org.joml.Matrix4f;
import org.joml.Matrix4fStack;
import org.joml.Quaternionf;

public class PalantirReflector {
    public static final int MAX_DEPTH = 2;
    private static final Framebuffer[] framebuffers = new Framebuffer[MAX_DEPTH];
    private static int renderDepth;

    public static boolean isDrawing() {
        return renderDepth > 0;
    }

    public static Framebuffer getFramebuffer() {
        if (!canDraw()) return null;
        return framebuffers[renderDepth - 1];
    }

    public static boolean canDraw() {
        boolean fabulous = MinecraftClient.getInstance().options.getGraphicsMode().getValue() == GraphicsMode.FABULOUS;
        return !fabulous && renderDepth < MAX_DEPTH;
    }

    public static void onResize(int width, int height) {
        for (int i = 0; i < framebuffers.length; i++) {
            if (framebuffers[i] != null) framebuffers[i].delete();
            framebuffers[i] = new SimpleFramebuffer(width, height, true, MinecraftClient.IS_SYSTEM_MAC);
        }
    }

    public static int renderPalantirView(PalantirBlockEntity palantir) {
        if (!canDraw()) return -1;
        if (palantir.getLinkedPos() == null) return -1;

        MinecraftClient client = MinecraftClient.getInstance();
        Camera camera = client.gameRenderer.getCamera();

        // Target settings
        Vec3d targetPos = Vec3d.ofCenter(palantir.getLinkedPos().pos()); // View from center of linked block

        // We want the view to look in the same direction the player is looking,
        // to create a "portal" window effect.
        float targetYaw = camera.getYaw();
        float targetPitch = camera.getPitch();

        try {
            // Save State
            Matrix4f prevProjMat = new Matrix4f(RenderSystem.getProjectionMatrix());
            Vec3d oldPos = camera.getPos();
            float oldCamYaw = camera.getYaw();
            float oldCamPitch = camera.getPitch();
            int oldFboWidth = client.getWindow().getFramebufferWidth();
            int oldFboHeight = client.getWindow().getFramebufferHeight();
            
            // Save old Frustum to prevent culling issues in main world after we return
            // Use Accessor
            Frustum oldFrustum = ((WorldRendererAccessor) client.worldRenderer).getFrustum();

            // Setup Camera for the "Other Side" using Accessor
            ((CameraAccessor) camera).invokeSetPos(targetPos.x, targetPos.y, targetPos.z);
            ((CameraAccessor) camera).invokeSetRotation(targetYaw, targetPitch);

            // Setup Matrices
            Matrix4f rotMat = new Matrix4f().rotate(camera.getRotation().conjugate(new Quaternionf()));
            Matrix4f projMat = client.gameRenderer.getBasicProjectionMatrix(client.options.getFov().getValue());
            client.worldRenderer.setupFrustum(camera.getPos(), rotMat, projMat);

            // Setup Framebuffer
            renderDepth++;
            if (framebuffers[renderDepth - 1] == null) {
                onResize(client.getWindow().getFramebufferWidth(), client.getWindow().getFramebufferHeight());
            }
            Framebuffer framebuffer = framebuffers[renderDepth - 1];

            framebuffer.clear(MinecraftClient.IS_SYSTEM_MAC);
            framebuffer.beginWrite(true);

            client.getWindow().setFramebufferWidth(framebuffer.textureWidth);
            client.getWindow().setFramebufferHeight(framebuffer.textureHeight);

            RenderSystem.viewport(0, 0, framebuffer.textureWidth, framebuffer.textureHeight);
            client.gameRenderer.loadProjectionMatrix(projMat);

            Matrix4fStack modelViewStack = RenderSystem.getModelViewStack();
            modelViewStack.pushMatrix();
            modelViewStack.identity();
            RenderSystem.applyModelViewMatrix();

            // Render World
            client.worldRenderer.render(client.getRenderTickCounter(), false, camera, client.gameRenderer, client.gameRenderer.getLightmapTextureManager(), rotMat, projMat);

            modelViewStack.popMatrix();
            RenderSystem.applyModelViewMatrix();

            renderDepth--;

            // Restore State
            client.getFramebuffer().beginWrite(false);
            
            // Restore Camera using Accessor
            ((CameraAccessor) camera).invokeSetPos(oldPos.x, oldPos.y, oldPos.z);
            ((CameraAccessor) camera).invokeSetRotation(oldCamYaw, oldCamPitch);
            
            // Restore Frustum using Accessor
            if (oldFrustum != null) {
                ((WorldRendererAccessor) client.worldRenderer).setFrustum(oldFrustum);
            }
        
            client.gameRenderer.loadProjectionMatrix(prevProjMat);
            RenderSystem.setProjectionMatrix(prevProjMat, VertexSorter.BY_Z);
            
            // RenderSystem.setModelViewMatrix(oldModelViewMat); // Removed: handled by push/pop above?
            // If we really need to restore exact matrix (e.g. if something inside render changed it without popping)
            // modelViewStack.set(oldModelViewMat); // This assumes we captured the stack state, but we only captured the matrix.
            // Since we wrapped the inner render in push/pop, the stack should be back to original state automatically.
            
            client.getWindow().setFramebufferWidth(oldFboWidth);
            client.getWindow().setFramebufferHeight(oldFboHeight);
            RenderSystem.viewport(0, 0, oldFboWidth, oldFboHeight);

            return framebuffer.getColorAttachment();

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}