package pocolor.asciicraft.game.player;

import java.io.Serializable;

public class Player implements Serializable {
    private final Inventory inventory;

    public Player() {
        this.inventory = new Inventory();
    }
}
