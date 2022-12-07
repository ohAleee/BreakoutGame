package breakout.graphics;

import breakout.manager.ItemManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private final ItemManager items;

    public GamePanel(ItemManager items) {
        this.items = items;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        items.getBall().paint(g);
        items.getPaddle().paint(g);
        items.getBricks().forEach(brick -> brick.paint(g));
    }

}
