package pocolor.asciicraft.game;

import pocolor.asciicraft.event.EventBus;
import pocolor.asciicraft.loop.WorldGenerationLoop;
import pocolor.asciicraft.loop.GameLoop;

public class Game {
    private final EventBus eventBus;
    private final GameLoop gameLoop;
    private final WorldGenerationLoop worldGenerationLoop;

    public Game(EventBus eventBus) {
        this.eventBus = eventBus;

        this.gameLoop = new GameLoop(this.eventBus);
        this.worldGenerationLoop = new WorldGenerationLoop(this.eventBus);
    }

    public void start() {
        new Thread(this.gameLoop).start();
        new Thread(this.worldGenerationLoop).start();
    }

    public void stop() {
        this.gameLoop.stopRunning();
        this.worldGenerationLoop.stopRunning();
    }
}
