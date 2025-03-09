package pocolor.asciicraft.world.generation.noise;

import java.util.Random;

public abstract class Noise {
    protected final Permutations permutations;

    public Noise(Random random) {
        this.permutations = new Permutations(8, random);  // FIXME(number of permutations probably shouldn't be a constant)
    }

    public abstract double noise(double x, double y);
}
