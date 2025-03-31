package pocolor.asciicraft.event.events;

import pocolor.asciicraft.event.Event;

public class CommandRecievedEvent extends Event {
    private final String command;

    public CommandRecievedEvent(String command) {
        this.command = command;
    }

    public String getCommand() {
        return this.command;
    }
}
