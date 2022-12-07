package breakout.item;

public abstract class MovableItem extends GameItem {

    protected int vx;
    protected int vy;

    public MovableItem(int width, int height, int vx, int vy) {
        super(width, height);
        this.vx = vx;
        this.vy = vy;
    }

    public MovableItem(int width, int height, int x, int y, int vx, int vy) {
        super(width, height, x, y);
        this.vx = vx;
        this.vy = vy;
    }

    public abstract void move();

    public int getVx() {
        return vx;
    }

    public int getVy() {
        return vy;
    }

}
