package breakout.item;

import java.awt.*;

public class Paddle extends MovableItem {

    public Paddle(int width, int height, int x, int y, int v) {
        super(width, height, x, y, v, v);
    }

    @Override
    public void move(int panelWidth, int panelHeight) {}

    public void move(int panelWidth, boolean right) {
        if (right) x += vx;
        else x -= vx;

        if (x < 0) x = 0;
        else if (x + width > panelWidth) x = panelWidth - width;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRoundRect(x, y, width, height, 30, 30);
    }

}
