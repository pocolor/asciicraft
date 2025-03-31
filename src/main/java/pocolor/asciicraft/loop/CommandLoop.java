package pocolor.asciicraft.loop;

import pocolor.asciicraft.event.Event;
import pocolor.asciicraft.event.EventBus;
import pocolor.asciicraft.event.events.CommandRecievedEvent;

public class CommandLoop extends Loop {
    public CommandLoop(EventBus eventBus) {
        super();

        eventBus.subscribe(CommandRecievedEvent.class, this);
    }
    @Override
    public void run() {

    }

    @Override
    public void onEvent(Event event) {

    }
}
