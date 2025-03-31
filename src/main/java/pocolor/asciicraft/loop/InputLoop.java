package pocolor.asciicraft.loop;

import org.jline.utils.NonBlockingReader;
import pocolor.asciicraft.event.Event;
import pocolor.asciicraft.event.EventBus;
import pocolor.asciicraft.event.events.CommandRecievedEvent;

import java.io.IOException;

public class InputLoop extends Loop {
    private final NonBlockingReader reader;
    private final StringBuffer inputQueue;

    public InputLoop(EventBus eventBus, NonBlockingReader reader, StringBuffer inputQueue) {
        super(eventBus);

        this.reader = reader;
        this.inputQueue = inputQueue;
    }

    @Override
    public void run() {
        while (this.running) {
            try {
                if (this.reader.available() > 0) {
                    int c;
                    while ((c = this.reader.read(1)) != -1) {
                        char ch = (char) c;
                        switch (ch) {  // TODO(implement auto entered commands)
                            case '\n' -> {
                                this.eventBus.publish(new CommandRecievedEvent(this.inputQueue.toString()));
                                this.inputQueue.setLength(0);
                            }
                            case '\r' -> this.inputQueue.deleteCharAt(this.inputQueue.length() - 1);
                            default -> this.inputQueue.append(ch);
                        }
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void onEvent(Event event) {

    }
}
