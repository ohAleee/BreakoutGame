package breakout.item;

import java.awt.*;

public class Brick extends GameItem {

    public Brick(int side, int x, int y) {
        super(side, side, x, y);
    }

    @Override
    public void remove() {
        super.remove();

        // TODO
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);
    }

}
