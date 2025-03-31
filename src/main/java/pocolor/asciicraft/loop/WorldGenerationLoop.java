package pocolor.asciicraft.loop;

import pocolor.asciicraft.event.EventBus;
import pocolor.asciicraft.event.Event;

public class WorldGenerationLoop extends Loop {
    public WorldGenerationLoop(EventBus eventBus) {
        super();

        // TODO(register to event)
    }

    @Override
    public void run() {
        while (this.running) {
            // do something
        }
    }

    @Override
    public void onEvent(Event event) {

    }
}
