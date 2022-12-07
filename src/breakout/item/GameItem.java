package breakout.item;

import java.awt.*;

public abstract class GameItem {

    protected int width;
    protected int height;

    protected int x;
    protected int y;

    public GameItem(int width, int height, int x, int y) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
    }

    public boolean intersects(GameItem other) {
        return x < other.x + other.width && x + width > other.x && y < other.y + other.height && y + height > other.y;
    }

    public void remove() {
        width = 0;
        height = 0;
    }

    public abstract void paint(Graphics g);

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

}
