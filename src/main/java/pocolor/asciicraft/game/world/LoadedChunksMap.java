package pocolor.asciicraft.game.world;

import java.io.Serializable;
import java.util.LinkedList;

public class LoadedChunksMap implements Serializable {
    private final LinkedList<LinkedList<Chunk>> chunks;
    private int width;
    private int height;

    public LoadedChunksMap(int centerChunkX, int centerChunkY, int width, int height) {
        this.chunks = new LinkedList<>();

        this.setSize(width, height);
        this.initMap(centerChunkX, centerChunkY);
    }

    private void initMap(int centerChunkX, int centerChunkY) {
        for (int y = centerChunkY + (this.height >> 1); y >= this.height; y--) {
            LinkedList<Chunk> chunks = new LinkedList<>();
            this.chunks.add(chunks);

            for (int x = centerChunkX - (this.width >> 1); x <= this.width; x++) {
                chunks.add(this.loadChunk(x, y));
            }
        }
    }

    private Chunk loadChunk(int x, int y) {
        return null;  // TODO(implement loading chunks from files)
    }

    private void unloadChunk(Chunk chunk) {
        // TODO(implement saving chunks to files)
    }

    public void moveUp() {
        this.loadRowUp();
        this.unloadRowDown();
    }

    public void moveDown() {
        this.loadRowDown();
        this.unloadRowUp();
    }

    public void moveLeft() {
        this.loadColLeft();
        this.unloadColRight();
    }

    public void moveRight() {
        this.loadColRight();
        this.unloadColLeft();
    }

    private void setSize(int width, int height) {
        assert (width & height & 1) == 1;

        this.width = width;
        this.height = height;
    }

    public void updateSize(int width, int height) {
        final int w = this.width;
        final int h = this.height;

        this.setSize(width, height);

        final int dw = (w - width) >> 1;
        final int dh = (h - height) >> 1;

        if (dw > 0) {
            for (int i = 0; i < dw; i++) {
                this.loadColLeft();
                this.loadColRight();
            }
        } else if (dw < 0) {
            for (int i = dw; i < 0; i++) {
                this.unloadColLeft();
                this.unloadColRight();
            }
        }

        if (dh > 0) {
            for (int i = 0; i < dh; i++) {
                this.loadRowUp();
                this.loadRowDown();
            }
        } else if (dh < 0) {
            for (int i = dh; i < 0; i++) {
                this.unloadRowUp();
                this.unloadRowDown();
            }
        }
    }

    private void loadRowUp() {
        final Coordinates coordinates = this.chunks.getFirst().getFirst().getCoordinates();
        this.chunks.addFirst(this.loadRow(coordinates.x(), coordinates.y()));
    }

    private void loadRowDown() {
        final Coordinates coordinates = this.chunks.getLast().getFirst().getCoordinates();
        this.chunks.addLast(this.loadRow(coordinates.x(), coordinates.y()));
    }

    private LinkedList<Chunk> loadRow(int startX, int y) {
        LinkedList<Chunk> list = new LinkedList<>();
        for (int x = startX; x < startX + this.width; x++) {
            list.add(this.loadChunk(x, y));
        }
        return list;
    }

    private void loadColLeft() {
        final Coordinates coordinates = this.chunks.getFirst().getFirst().getCoordinates();
        int x = coordinates.x();
        int y = coordinates.y();

        for (LinkedList<Chunk> chunks : this.chunks) {
            chunks.addFirst(this.loadChunk(x, y--));
        }
    }

    private void loadColRight() {
        final Coordinates coordinates = this.chunks.getLast().getLast().getCoordinates();
        int x = coordinates.x();
        int y = coordinates.y();

        for (LinkedList<Chunk> chunks : this.chunks) {
            chunks.addLast(this.loadChunk(x, y--));
        }
    }

    private void unloadRowUp() {
        this.unloadRow(this.chunks.removeFirst());
    }

    private void unloadRowDown() {
        this.unloadRow(this.chunks.removeLast());
    }

    private void unloadRow(LinkedList<Chunk> chunks) {
        for (Chunk chunk : chunks) {
            this.unloadChunk(chunk);
        }
    }

    private void unloadColLeft() {
        for (LinkedList<Chunk> chunks : this.chunks) {
            this.unloadChunk(chunks.removeFirst());
        }
    }

    private void unloadColRight() {
        for (LinkedList<Chunk> chunks : this.chunks) {
            this.unloadChunk(chunks.removeLast());
        }
    }
}
