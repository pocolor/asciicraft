package pocolor.asciicraft.event.events;

import pocolor.asciicraft.event.Event;

public class UserTypedEvent extends Event {
    private final char typedChar;

    public UserTypedEvent(char typedChar) {
        this.typedChar = typedChar;
    }

    public char getTypedChar() {
        return this.typedChar;
    }
}
