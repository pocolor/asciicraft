package pocolor.asciicraft.world;

import pocolor.asciicraft.player.Player;

import java.io.Serializable;
import java.util.Random;

public class World implements Serializable {
    public static final int RENDER_DISTANCE = 5;  // in chunks

    private final int seed;
    private final Player player;
    private final ChunkMap chunkMap;

    public World(int seed) {
        this.seed = seed;
        this.player = new Player();

        Random random = new Random();
        this.chunkMap = new ChunkMap(random.nextInt(4001) - 2000, random.nextInt(4001) - 2000);
    }
}
