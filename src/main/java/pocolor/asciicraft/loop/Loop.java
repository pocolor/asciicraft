package pocolor.asciicraft.loop;

import pocolor.asciicraft.event.EventBus;
import pocolor.asciicraft.event.EventListener;
import pocolor.asciicraft.event.Event;

public abstract class Loop implements Runnable, EventListener<Event> {
    protected final EventBus eventBus;
    protected volatile boolean running;

    protected Loop(EventBus eventBus) {
        this.eventBus = eventBus;
        this.running = true;
    }

    public void stopRunning() {
        this.running = false;
    }
}
