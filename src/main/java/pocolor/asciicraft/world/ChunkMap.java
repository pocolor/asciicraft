package pocolor.asciicraft.world;

import java.io.Serializable;
import java.util.LinkedList;

public class ChunkMap implements Serializable {
    private final LinkedList<LinkedList<Chunk>> chunks;

    public ChunkMap() {
        this.chunks = new LinkedList<>();

        for (int i = 0; i < World.RENDER_DISTANCE; i++) {
            this.chunks.add(new LinkedList<>());
        }
    }
}
