#version 150

uniform sampler2D DiffuseSampler;
uniform sampler2D PrevSampler;
uniform vec3 Phosphor;

in vec2 texCoord;

out vec4 fragColor;

void main() {
    vec4 color = texture(DiffuseSampler, texCoord);
    vec4 prev = texture(PrevSampler, texCoord);
    fragColor = mix(color, prev, Phosphor.x);
}