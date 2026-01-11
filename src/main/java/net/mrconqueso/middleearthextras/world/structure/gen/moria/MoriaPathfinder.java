package net.mrconqueso.middleearthextras.world.structure.gen.moria;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;

import java.util.ArrayList;
import java.util.List;

public class MoriaPathfinder {

    public record MoriaNode(BlockPos pos, String templateName) {}

    /**
     * Calculates the path from Start to End, but only returns the nodes within the specified range fraction.
     * @param start The starting position (e.g., West Gate)
     * @param end The ending position (e.g., East Gate)
     * @param seed Random seed
     * @param rangeStart Fraction 0.0 to 1.0 (Start of segment to generate)
     * @param rangeEnd Fraction 0.0 to 1.0 (End of segment to generate)
     */
    public static List<MoriaNode> calculatePathSegment(BlockPos start, BlockPos end, long seed, double rangeStart, double rangeEnd) {
        List<MoriaNode> fullSpine = new ArrayList<>();
        Random random = Random.create(seed);

        // 1. Waypoints
        BlockPos midpoint = new BlockPos(
                (start.getX() + end.getX()) / 2,
                Math.min(start.getY(), end.getY()) - 20, // Dip down into the earth
                (start.getZ() + end.getZ()) / 2
        );

        // 2. Generate Full Path (Conceptually)
        // Leg 1: Start -> Midpoint
        generateLeg(fullSpine, start, midpoint, "hallway", random);

        // Midpoint Feature
        fullSpine.add(new MoriaNode(midpoint, "bridge_khazad_dum"));

        // Leg 2: Midpoint -> End
        generateLeg(fullSpine, midpoint, end, "hallway", random);

        // 3. Filter by Range
        int totalNodes = fullSpine.size();
        int startIndex = (int) (totalNodes * rangeStart);
        int endIndex = (int) (totalNodes * rangeEnd);

        // Clamp
        startIndex = MathHelper.clamp(startIndex, 0, totalNodes);
        endIndex = MathHelper.clamp(endIndex, 0, totalNodes);

        if (startIndex >= endIndex) return new ArrayList<>();

        return fullSpine.subList(startIndex, endIndex);
    }

    private static void generateLeg(List<MoriaNode> spine, BlockPos from, BlockPos to, String type, Random random) {
        int steps = 30; // Granularity of the path

        for (int i = 0; i < steps; i++) {
            double progress = (double) i / steps;

            // Lerp base position
            int x = (int) MathHelper.lerp(progress, from.getX(), to.getX());
            int y = (int) MathHelper.lerp(progress, from.getY(), to.getY());
            int z = (int) MathHelper.lerp(progress, from.getZ(), to.getZ());

            // Add Noise
            // We use the coordinates themselves to seed randomness for stability if re-calculated?
            // No, 'random' state is passed through.

            int wiggleX = random.nextInt(20) - 10;
            int wiggleY = random.nextInt(10) - 5;
            int wiggleZ = random.nextInt(20) - 10;

            spine.add(new MoriaNode(new BlockPos(x + wiggleX, y + wiggleY, z + wiggleZ), type));
        }
    }
}