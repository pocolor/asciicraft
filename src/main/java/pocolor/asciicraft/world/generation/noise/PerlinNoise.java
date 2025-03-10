package pocolor.asciicraft.world.generation.noise;

import java.util.Random;

public class PerlinNoise extends Noise {
    private static final int[][] GRADIENTS = {
            {1, 1}, {1, -1}, {-1, 1}, {-1, -1},
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };

    public PerlinNoise(Random random, double scale, int bound) {
        super(random, scale, bound);
    }

    @Override
    public double noise(double x, double y) {
        x *= this.scale;
        y *= this.scale;

        int gridX = ((int) x) & this.bound;
        int gridY = ((int) y) & this.bound;
        int nextGridX = (gridX + 1) & this.bound;
        int nextGridY = (gridY + 1) & this.bound;

        double localX = x - (int) x;
        double localY = y - (int) y;
        double smoothedX = fade(localX);
        double smoothedY = fade(localY);

        int bottomLeftIndex = this.permutations.getAt(gridX + this.permutations.getAt(gridY));
        int bottomRightIndex = this.permutations.getAt(nextGridX + this.permutations.getAt(gridY));
        int topLeftIndex = this.permutations.getAt(gridX + this.permutations.getAt(nextGridY));
        int topRightIndex = this.permutations.getAt(nextGridX + this.permutations.getAt(nextGridY));

        double bottomLeftDot = dotProduct(bottomLeftIndex, localX, localY);
        double bottomRightDot = dotProduct(bottomRightIndex, localX - 1, localY);
        double topLeftDot = dotProduct(topLeftIndex, localX, localY - 1);
        double topRightDot = dotProduct(topRightIndex, localX - 1, localY - 1);

        double interpolationBottom = linearInterpolation(bottomLeftDot, bottomRightDot, smoothedX);
        double interpolationTop = linearInterpolation(topLeftDot, topRightDot, smoothedX);

        double interpolationYAxis = linearInterpolation(interpolationBottom, interpolationTop, smoothedY);

        return (interpolationYAxis + 1) / 2;  // normalize to range 0 to 1
    }

    private static double fade(double weight) {
        return weight * weight * weight * (weight * (weight * 6 - 15) + 10);
    }

    private static double dotProduct(int gradientIndex, double xOffset, double yOffset) {
        int[] gradient = GRADIENTS[gradientIndex & 7];
        return gradient[0] * xOffset + gradient[1] * yOffset;
    }

    private static double linearInterpolation(double start, double end, double weight) {
        return start + (end - start) * weight;
    }
}
