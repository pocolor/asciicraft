package pocolor.asciicraft.world;

import pocolor.asciicraft.block.Block;

import java.io.Serializable;

public class Chunk implements Serializable {
    public static final int CHUNK_SIZE = 16;

    private final int x;
    private final int y;
    private final Block[][][] blocks;

    public Chunk(int x, int y) {
        this.blocks = new Block[CHUNK_SIZE][CHUNK_SIZE][2];
        this.x = x;
        this.y = y;
    }
}
