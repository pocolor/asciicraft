package pocolor.asciicraft.game.loop;

import pocolor.asciicraft.game.EventBus;
import pocolor.asciicraft.game.event.GameEvent;

public class WorldGenerationLoop extends Loop {
    public WorldGenerationLoop(EventBus eventBus) {
        super();

        // TODO(register to events)
    }

    @Override
    public void run() {
        while (this.running) {
            // do something
        }
    }

    @Override
    public void onEvent(GameEvent event) {

    }
}
