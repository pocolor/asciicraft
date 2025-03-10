package pocolor.asciicraft.world.generation.noise;

import java.util.Random;

public abstract class Noise {
    protected final Permutations permutations;
    protected final double scale;
    protected final int bound;

    public Noise(Random random, double scale, int bound) {
        this.permutations = new Permutations(bound, random);
        this.scale = scale;
        this.bound = bound - 1;
    }

    public abstract double noise(double x, double y);
}
