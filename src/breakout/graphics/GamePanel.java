package breakout.graphics;

import breakout.manager.GameManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private final GameManager manager;

    public GamePanel(GameManager manager) {
        this.manager = manager;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        manager.getBall().paint(g);
        manager.getPaddle().paint(g);
        manager.getBricks().forEach(brick -> brick.paint(g));
    }

}
