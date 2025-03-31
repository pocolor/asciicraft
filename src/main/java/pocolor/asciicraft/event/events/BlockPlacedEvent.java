package pocolor.asciicraft.event.events;

import pocolor.asciicraft.event.Event;
import pocolor.asciicraft.game.block.Block;
import pocolor.asciicraft.game.world.Coordinates;

public class BlockPlacedEvent extends Event {
    private final Block block;
    private final Coordinates coordinates;

    public BlockPlacedEvent(Block block, Coordinates coordinates) {
        this.block = block;
        this.coordinates = coordinates;
    }

    public Block getBlock() {
        return this.block;
    }

    public Coordinates getCoordinates() {
        return this.coordinates;
    }
}
