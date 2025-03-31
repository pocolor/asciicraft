package pocolor.asciicraft.event;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class EventBus {
    private final ConcurrentHashMap<Class<? extends Event>, List<EventListener<Event>>> listeners;

    public EventBus() {
        this.listeners = new ConcurrentHashMap<>();
    }

    public void publish(Event event) {
        List<EventListener<Event>> listeners = this.listeners.getOrDefault(event.getClass(), Collections.emptyList());
        for (EventListener<Event> listener : listeners) {
            listener.onEvent(event);
        }
    }

    public void subscribe(Class<? extends Event> eventType, EventListener<Event> listener) {
        this.listeners.computeIfAbsent(eventType, k -> new CopyOnWriteArrayList<>()).add(listener);
    }
}
