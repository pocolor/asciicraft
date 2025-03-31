package pocolor.asciicraft.game.world;

import java.io.Serializable;

public class ChunkLayers implements Serializable {
    public enum ChunkLevel implements Serializable {
        TOP(0),
        MIDDLE(1),
        BOTTOM(2);

        private final int index;

        ChunkLevel(int index) {
            this.index = index;
        }
    }

    private final Layer[] layers;

    public ChunkLayers() {
        this.layers = new Layer[ChunkLevel.values().length];
        this.init();
    }

    private void init() {
        for (int i = 0; i < this.layers.length; i++) {
            this.layers[i] = new Layer();
        }
    }

    public Layer getLayer(ChunkLevel level) {
        return this.layers[level.index];
    }
}
