#version 150

uniform sampler2D DiffuseSampler;
uniform sampler2D DepthSampler; // Requires access to depth buffer

uniform vec2 OutSize;
uniform float FocusDistance; // Controlled by Scroll Wheel (e.g., 50 blocks, 200 blocks)
uniform float FocusRange;    // How "thick" the clear area is

in vec2 texCoord;
out vec4 fragColor;

// Helper to linearize depth (convert 0..1 to block distance)
float getLinearDepth(float depth) {
    float zNear = 0.05;
    float zFar  = 1000.0; // View distance
    return (2.0 * zNear) / (zFar + zNear - depth * (zFar - zNear));
}

void main() {
    vec4 color = texture(DiffuseSampler, texCoord);
    float depth = texture(DepthSampler, texCoord).r;

    // Convert raw depth to roughly "Blocks away"
    // (Note: Precise linearization depends on projection matrix, this is simplified)
    float linearDepth = getLinearDepth(depth) * 1000.0;

    // Calculate Blur Amount
    // 0.0 = Perfectly Clear, 1.0 = Max Blur
    float blur = smoothstep(FocusRange, FocusRange + 50.0, abs(linearDepth - FocusDistance));

    // Simple Box Blur (Cheap)
    // In production, use a separate Gaussian pass, but this demonstrates the logic
    if (blur > 0.01) {
        vec4 sum = vec4(0.0);
        float offset = blur * 0.005; // Blur radius
        sum += texture(DiffuseSampler, texCoord + vec2(offset, 0.0));
        sum += texture(DiffuseSampler, texCoord + vec2(-offset, 0.0));
        sum += texture(DiffuseSampler, texCoord + vec2(0.0, offset));
        sum += texture(DiffuseSampler, texCoord + vec2(0.0, -offset));
        fragColor = sum / 4.0;
    } else {
        fragColor = color;
    }
}