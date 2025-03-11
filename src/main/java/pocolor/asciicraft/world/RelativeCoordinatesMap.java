package pocolor.asciicraft.world;

import java.io.Serializable;

public class RelativeCoordinatesMap implements Serializable {
    private record Coordinate(int x, int y) implements Serializable {}

    private final Coordinate[][] coordsMap;

    public RelativeCoordinatesMap(int renderDistance) {
        this.coordsMap = new Coordinate[(renderDistance << 1) + 1][(renderDistance << 1) + 1];
        this.initCoords(renderDistance, (renderDistance + 1) * (renderDistance + 1));
    }

    private void initCoords(int renderDistance, int maxSquare) {
        for (int row = 0; row < this.coordsMap.length; row++) {
            for (int col = 0; col < this.coordsMap.length; col++) {
                int x = col - renderDistance;
                int y = renderDistance - row;

                if (x*x + y*y <= maxSquare) {
                    this.coordsMap[row][col] = new Coordinate(x, y);
                }
            }
        }
    }
}
