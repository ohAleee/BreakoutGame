package breakout.graphics;

import breakout.manager.ItemManager;
import breakout.util.ImageUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel {

    private static final BufferedImage BACKGROUND = ImageUtil.getImage(Gui.WIDTH, Gui.HEIGHT, "https://imgur.com/SfKzS1w.png");

    private final ItemManager items;

    public GamePanel(ItemManager items) {
        this.items = items;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(BACKGROUND, 0, 0, null);

        items.getBall().paint(g);
        items.getPaddle().paint(g);
        items.getBricks().forEach(brick -> brick.paint(g));
    }

}
