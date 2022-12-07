package breakout.item.game;

import breakout.graphics.Gui;
import breakout.item.MovableItem;
import breakout.manager.GameManager;

import java.awt.*;

public class Ball extends MovableItem {

    private final GameManager manager;

    public Ball(GameManager manager, int width, int height, int x, int y, int v) {
        super(width, height, x, y, v, v);
        this.manager = manager;
    }

    @Override
    public void move() {

        if (x + vx < 0 || x + vx + width > Gui.WIDTH)
            vx = -vx;

        if (y + vy < 0)
            vy = -vy;

        x += vx;
        y += vy;

        for (Brick brick : manager.getBricks()) {
            if (intersects(brick)) {
                vy = -vy;
                manager.getBricks().remove(brick);
                break;
            }
        }

        if (!intersects(manager.getPaddle())) {
            if (y + height > Gui.HEIGHT) {
                remove();
                System.out.println("Game Over");
            }
            return;
        }

        if (y + height > manager.getPaddle().getY()) {
            vy = -vy;
        }

    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.PINK);
        g.fillRoundRect(x, y, width, height, 30, 30);
    }

}
