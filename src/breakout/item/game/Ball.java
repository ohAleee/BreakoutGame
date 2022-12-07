package breakout.item.game;

import breakout.graphics.Gui;
import breakout.item.MovableItem;
import breakout.manager.ItemManager;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Ball extends MovableItem {

    private final ItemManager manager;
    private final BufferedImage image;

    public Ball(BufferedImage image, ItemManager manager, int vx, int vy) {
        super(image.getWidth(), image.getHeight(), (Gui.WIDTH - image.getWidth()) / 2, (Gui.HEIGHT - image.getHeight()) / 2, vx, vy);
        this.manager = manager;
        this.image = image;
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
                manager.getGame().reset();
            }
            return;
        }

        if (y + height > manager.getPaddle().getY()) {
            vy = -vy;
        }

    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(image, x, y, width, height, null);
    }

}
