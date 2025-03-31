package pocolor.asciicraft.game.world;

import pocolor.asciicraft.game.block.Block;

import java.io.Serializable;

public class Layer implements Serializable {
    public enum LayerLevel implements Serializable {
        INTERACTIVE(0),
        VISUAL(1);

        private final int index;

        LayerLevel(int index) {
            this.index = index;
        }
    }

    private final Block[][][] blocks;
    private final int bound;

    public Layer() {
        this.blocks = new Block[LayerLevel.values().length][Chunk.SIZE][Chunk.SIZE];
        this.bound = Chunk.SIZE - 1;
    }

    public Block getBlock(LayerLevel level, Coordinates coordinates) {
        return this.blocks[level.index][coordinates.y()][coordinates.x()];
    }

    public Block[][] getBlockMatrix(LayerLevel level) {
        return this.blocks[level.index];
    }
}
