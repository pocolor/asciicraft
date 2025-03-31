package pocolor.asciicraft.game.world;

import java.io.Serializable;

public abstract class Chunk implements Serializable {
    public static final int SIZE = 1 << 4;

    protected final Coordinates coordinates;
    protected final ChunkLayers chunkLayers;
    protected final int bound;

    public Chunk(int x, int y) {
        this.coordinates = Coordinates.of(x, y);
        this.chunkLayers = new ChunkLayers();
        this.bound = SIZE - 1;
    }

    public Coordinates getCoordinates() {
        return this.coordinates;
    }
}
