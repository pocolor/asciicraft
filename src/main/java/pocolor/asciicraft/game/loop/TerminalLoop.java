package pocolor.asciicraft.game.loop;

import pocolor.asciicraft.game.EventBus;
import pocolor.asciicraft.game.event.GameEvent;

public class TerminalLoop extends Loop {
    public TerminalLoop(EventBus eventBus) {
        super();
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
