package pocolor.asciicraft.event;

public interface EventListener <T extends Event>{
    void onEvent(T event);
}
