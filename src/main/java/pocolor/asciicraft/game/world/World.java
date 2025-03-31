package pocolor.asciicraft.game.world;

import pocolor.asciicraft.game.player.Player;
import pocolor.asciicraft.game.world.nether.Nether;
import pocolor.asciicraft.game.world.overworld.Overworld;

import java.io.Serializable;

public class World implements Serializable {
    private final int seed;
    private final Player player;

    private Overworld overworld;
    private Nether nether;

    public World(int seed) {
        this.seed = seed;
        this.player = new Player();
    }
}
