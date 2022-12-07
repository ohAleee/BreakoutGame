package breakout.item.game;

import breakout.item.GameItem;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Brick extends GameItem {

    private final BufferedImage image;

    public Brick(BufferedImage image, int x, int y) {
        super(image.getWidth(), image.getHeight(), x, y);
        this.image = image;
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(image, x, y, width, height, null);
    }

}
