package pocolor.asciicraft.world;

import java.io.Serializable;
import java.util.LinkedList;

public class ChunkMap implements Serializable {
    private final LinkedList<LinkedList<Chunk>> chunks;

    public ChunkMap(int playerSpawnX, int playerSpawnY) {
        this.chunks = new LinkedList<>();

        int chunkSpawnX = playerSpawnX / Chunk.CHUNK_SIZE;
        int chunkSpawnY = playerSpawnY / Chunk.CHUNK_SIZE;

        for (int y = 0; y < World.RENDER_DISTANCE << 1; y++) {
            LinkedList<Chunk> ch = new LinkedList<>();
            this.chunks.add(ch);

            for (int x = 0; x < World.RENDER_DISTANCE << 1; x++) {
                int chunkX = 0;
//                ch.add(new Chunk());
            }
        }
    }
}
