package pocolor.asciicraft.console;

import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import pocolor.asciicraft.event.EventBus;
import pocolor.asciicraft.loop.CommandLoop;
import pocolor.asciicraft.loop.InputLoop;
import pocolor.asciicraft.loop.OutputLoop;

import java.io.IOException;

public final class Console {
    private final Terminal terminal;

    private final InputLoop inputLoop;
    private final OutputLoop outputLoop;
    private final CommandLoop commandLoop;

    public Console(EventBus eventBus) throws IOException {
        this.terminal = TerminalBuilder.builder().system(true).jansi(true).name("AsciiCraft").build();

        final StringBuffer inputQueue = new StringBuffer();
        this.inputLoop = new InputLoop(eventBus, this.terminal.reader(), inputQueue);
        this.outputLoop = new OutputLoop(eventBus, this.terminal.writer(), inputQueue);
        this.commandLoop = new CommandLoop(eventBus);

        Thread.ofVirtual().start(this.inputLoop);
        Thread.ofVirtual().start(this.outputLoop);
        Thread.ofVirtual().start(this.commandLoop);
    }
}
