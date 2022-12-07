package breakout.item.game;

import breakout.graphics.Gui;
import breakout.item.MovableItem;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Paddle extends MovableItem {

    private final BufferedImage image;

    public Paddle(BufferedImage image, int v) {
        super(image.getWidth(), image.getHeight(), (Gui.WIDTH - image.getWidth()) / 2, Gui.HEIGHT - image.getHeight() - 5, v, v);
        this.image = image;
    }

    @Override
    public void move() {
    }

    public void move(boolean right) {
        if (right) x += vx;
        else x -= vx;

        if (x < 0) x = 0;
        else if (x + width > Gui.WIDTH) x = Gui.WIDTH - width;
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(image, x, y, width, height, null);
    }

}
