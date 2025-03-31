package pocolor.asciicraft.event.events;

import pocolor.asciicraft.event.Event;

public class PlayerMovedEvent extends Event {
    public enum Direction {
        UP, DOWN, LEFT, RIGHT
    }

    private final Direction direction;

    public PlayerMovedEvent(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return this.direction;
    }
}
