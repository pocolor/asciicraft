package pocolor.asciicraft.game;

import pocolor.asciicraft.game.event.GameEvent;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class EventBus {
    private final ConcurrentHashMap<Class<? extends GameEvent>, List<EventListener<GameEvent>>> listeners;

    public EventBus() {
        this.listeners = new ConcurrentHashMap<>();
    }

    public void publish(GameEvent event) {
        List<EventListener<GameEvent>> listeners = this.listeners.getOrDefault(event.getClass(), Collections.emptyList());
        for (EventListener<GameEvent> listener : listeners) {
            listener.onEvent(event);
        }
    }

    public void subscribe(Class<? extends GameEvent> eventType, EventListener<GameEvent> listener) {
        this.listeners.computeIfAbsent(eventType, k -> new CopyOnWriteArrayList<>()).add(listener);
    }
}
