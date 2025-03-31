package pocolor.asciicraft.loop;

import pocolor.asciicraft.event.EventBus;
import pocolor.asciicraft.event.events.BlockPlacedEvent;
import pocolor.asciicraft.event.Event;
import pocolor.asciicraft.event.events.PlayerMovedEvent;

public class GameLoop extends Loop {
    public GameLoop(EventBus eventBus) {
        super();

        eventBus.subscribe(BlockPlacedEvent.class, this);
        eventBus.subscribe(PlayerMovedEvent.class, this);
    }

    @Override
    public void run() {
        while (this.running) {
            tick();
            try {
                Thread.sleep(100);
            } catch (InterruptedException ignored) {
            }
        }
    }

    @Override
    public void onEvent(Event event) {

    }

    private void tick() {
        //
    }
}
