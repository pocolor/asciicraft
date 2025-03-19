package pocolor.asciicraft.game.event;

public class PlayerMoveEvent extends GameEvent {
    public enum Direction {
        UP, DOWN, LEFT, RIGHT
    }

    private final Direction direction;

    public PlayerMoveEvent(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return this.direction;
    }
}
