#version 150

in vec3 Position;
in vec4 Color;
in vec2 UV0;
in ivec2 UV1;
in ivec2 UV2;
in vec3 Normal;

uniform sampler2D Sampler1;
uniform sampler2D Sampler2;

uniform mat4 ModelViewMat;
uniform mat4 ProjMat;
uniform float GameTime;
uniform vec3 Light0_Direction;
uniform vec3 Light1_Direction;

out float vertexDistance;
out vec4 vertexColor;
out vec2 texCoord0;
out vec2 texCoord1;
out vec2 texCoord2;
out vec4 normal;

void main() {
    vec3 pos = Position;

    // --- Sway Logic ---
    // GameTime * speed + offset based on Y height
    float speed = 3000.0;
    float amplitude = 0.08;
    float frequency = 3.0;

    // Apply sine wave to X axis
    // Multiply by pos.y so the feet (y=0) don't move, but the head does.
    float sway = sin(GameTime * speed + pos.y * frequency) * amplitude * max(0.0, pos.y);
    pos.x += sway;
    // ------------------

    gl_Position = ProjMat * ModelViewMat * vec4(pos, 1.0);

    vertexDistance = length((ModelViewMat * vec4(pos, 1.0)).xyz);

    // Apply lightmap (Sampler2) to the vertex color
    vertexColor = Color * texelFetch(Sampler2, UV2 / 16, 0);

    texCoord0 = UV0;
    texCoord1 = UV1; // Overlay texture
    texCoord2 = UV2;
    normal = ProjMat * ModelViewMat * vec4(Normal, 0.0);
}