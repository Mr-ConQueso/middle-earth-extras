#version 150

uniform sampler2D DiffuseSampler;

uniform vec2 OutSize;
uniform vec2 BlurDir;
uniform float Radius;

in vec2 texCoord;

out vec4 fragColor;

void main() {
    vec4 sum = vec4(0.0);
    float totalWeight = 0.0;

    vec2 texelSize = 1.0 / OutSize;
    vec2 step = BlurDir * texelSize;

    float r = floor(Radius);
    if (r < 1.0) {
        fragColor = texture(DiffuseSampler, texCoord);
        return;
    }

    // Basic triangle filter kernel
    for(float i = -r; i <= r; i += 1.0) {
        float weight = 1.0 - abs(i) / (r + 1.0);
        sum += texture(DiffuseSampler, texCoord + step * i) * weight;
        totalWeight += weight;
    }

    fragColor = sum / totalWeight;
}