package pocolor.asciicraft.game;

import pocolor.asciicraft.game.event.GameEvent;

public interface EventListener <T extends GameEvent>{
    void onEvent(T event);
}
