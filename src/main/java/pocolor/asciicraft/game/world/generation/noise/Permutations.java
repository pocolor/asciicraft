package pocolor.asciicraft.game.world.generation.noise;

import java.util.Random;

public class Permutations {
    private final int[] permutations;
    private final int bound;
    
    public Permutations(int bound, Random random) {
        this.permutations = createPermutations(bound, random);
        this.bound = this.permutations.length - 1;
    }
    
    public int getAt(int index) {
        return this.permutations[index & this.bound];
    }
    
    private static int[] createPermutations(int length, Random random) {
        int[] permutations = new int[length];
        
        for (int i = 0; i < length; i++) {
            permutations[i] = i;
        }
        
        shuffle(permutations, random);
        
        return permutations;
    }
    
    private static void shuffle(int[] permutations, Random random) {
        for (int i = permutations.length - 1; i > 0; i--) {
            swap(permutations, i, random.nextInt(i));
        }
    }
    
    private static void swap(int[] permutations, int index1, int index2) {
        int temp = permutations[index1];
        permutations[index1] = permutations[index2];
        permutations[index2] = temp;
    }
}
