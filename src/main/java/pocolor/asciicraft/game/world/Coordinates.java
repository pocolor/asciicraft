package pocolor.asciicraft.game.world;

public record Coordinates(int x, int y) {
    public static Coordinates of(int x, int y) {
        return new Coordinates(x, y);
    }
}
