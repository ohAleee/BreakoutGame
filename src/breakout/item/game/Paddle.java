package breakout.item.game;

import breakout.graphics.Gui;
import breakout.item.MovableItem;

import java.awt.*;

public class Paddle extends MovableItem {

    public Paddle(int width, int height, int x, int y, int v) {
        super(width, height, x, y, v, v);
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
        g.setColor(Color.ORANGE);
        g.fillRoundRect(x, y, width, height, 30, 30);
    }

}
