package pocolor.asciicraft.game;

import pocolor.asciicraft.game.loop.*;

public class Game {
    private final EventBus eventBus;
    private final GameLoop gameLoop;
    private final WorldGenerationLoop worldGenerationLoop;
    private final TerminalLoop terminalLoop;

    public Game() {
        this.eventBus = new EventBus();

        this.gameLoop = new GameLoop(this.eventBus);
        this.worldGenerationLoop = new WorldGenerationLoop(this.eventBus);
        this.terminalLoop = new TerminalLoop(this.eventBus);
    }

    public void start() {
        new Thread(this.gameLoop).start();
        new Thread(this.worldGenerationLoop).start();
        new Thread(this.terminalLoop).start();
    }

    public void stop() {
        this.gameLoop.stopRunning();
        this.worldGenerationLoop.stopRunning();
        this.terminalLoop.stopRunning();
    }
}
