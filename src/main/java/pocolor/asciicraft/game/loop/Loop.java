package pocolor.asciicraft.game.loop;

import pocolor.asciicraft.game.EventListener;
import pocolor.asciicraft.game.event.GameEvent;

public abstract class Loop implements Runnable, EventListener<GameEvent> {
    protected volatile boolean running;

    public Loop() {
        this.running = true;
    }

    public void stopRunning() {
        this.running = false;
    }
}
