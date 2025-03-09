package pocolor.asciicraft.world;

import pocolor.asciicraft.block.Block;

import java.io.Serializable;

public class Chunk implements Serializable {
    public static final int CHUNK_SIZE = 16;

    private final Block[][][] blocks;

    public Chunk() {
        this.blocks = new Block[CHUNK_SIZE][CHUNK_SIZE][2];
    }
}
