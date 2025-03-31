package pocolor.asciicraft;

import pocolor.asciicraft.console.Console;
import pocolor.asciicraft.event.EventBus;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        EventBus eventBus = new EventBus();

        try {
            Console console = new Console(eventBus);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}