#version 150

uniform sampler2D DiffuseSampler;
uniform vec2 OutSize;

in vec2 texCoord;

out vec4 fragColor;

void main() {
    vec4 color = texture(DiffuseSampler, texCoord);

    // 1. Grayscale (Luminance)
    float gray = dot(color.rgb, vec3(0.299, 0.587, 0.114));

    // 2. High Contrast (Wraith world is harsh)
    // Formula: (color - 0.5) * contrast + 0.5
    float contrast = 1.5;
    vec3 highContrast = vec3((gray - 0.5) * contrast + 0.5);

    // 3. Ghostly Blur / Vignette
    // We darken the edges to simulate tunnel vision
    vec2 uv = texCoord * (1.0 - texCoord.yx);
    float vignette = uv.x * uv.y * 15.0;
    vignette = pow(vignette, 0.25); // Soften the curve

    // 4. Mix slightly with a cold blue tint
    vec3 coldTint = vec3(0.8, 0.9, 1.0);
    vec3 finalColor = highContrast * vignette * coldTint;

    fragColor = vec4(finalColor, 1.0);
}