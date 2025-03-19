package pocolor.asciicraft.game.loop;

import pocolor.asciicraft.game.EventBus;
import pocolor.asciicraft.game.event.GameEvent;

public class GameLoop extends Loop {
    public GameLoop(EventBus eventBus) {
        super();
    }

    @Override
    public void run() {
        while (this.running) {
            tick();
        }
    }

    @Override
    public void onEvent(GameEvent event) {

    }

    private void tick() {
        //
    }
}
