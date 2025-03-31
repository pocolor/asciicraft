package pocolor.asciicraft.loop;

import pocolor.asciicraft.event.EventBus;
import pocolor.asciicraft.event.Event;

import java.io.PrintWriter;

public class OutputLoop extends Loop {
    private final PrintWriter writer;
    private final StringBuffer inputQueue;

    public OutputLoop(EventBus eventBus, PrintWriter writer, StringBuffer inputQueue) {
        super(eventBus);

        this.writer = writer;
        this.inputQueue = inputQueue;
    }

    @Override
    public void run() {
        while (this.running) {
            //
        }
    }

    @Override
    public void onEvent(Event event) {

    }
}
