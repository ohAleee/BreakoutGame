package breakout.item;

import java.awt.*;

public class Ball extends MovableItem {

    public Ball(int width, int height, int x, int y, int v) {
        super(width, height, x, y, v, v);
    }

    @Override
    public void move(int panelWidth, int panelHeight) {
        x += vx;
        y += vy;

        if (x < 0) x = 0;
        else if (x + width > panelWidth) x = panelWidth - width;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRoundRect(x, y, width, height, 30, 30);
    }

}
