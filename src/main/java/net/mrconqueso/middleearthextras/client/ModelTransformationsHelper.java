package net.mrconqueso.middleearthextras.client;

import net.minecraft.client.model.ModelPart;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;

public class ModelTransformationsHelper {

    public static void applyPartTransform(Matrix4f matrix, ModelPart part) {
        matrix.translate(part.pivotX / 16.0f, part.pivotY / 16.0f, part.pivotZ / 16.0f);

        if (part.roll != 0.0F || part.yaw != 0.0F || part.pitch != 0.0F) {
            matrix.rotate(RotationAxis.POSITIVE_Z.rotation(part.roll));
            matrix.rotate(RotationAxis.POSITIVE_Y.rotation(part.yaw));
            matrix.rotate(RotationAxis.POSITIVE_X.rotation(part.pitch));
        }

        if (part.xScale != 1.0F || part.yScale != 1.0F || part.zScale != 1.0F) {
            matrix.scale(part.xScale, part.yScale, part.zScale);
        }
    }

    public static Vec3d rotateVector(Vec3d vector, float angleDegrees) {
        // Minecraft yaw is inverted (positive yaw turns left).
        // Convert to radians and invert sign for standard rotation.
        return vector.rotateY((float) Math.toRadians(-angleDegrees));
    }
}
