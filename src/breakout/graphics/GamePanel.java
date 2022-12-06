package breakout;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private final GameManager manager;

    public GamePanel(GameManager manager) {
        super();
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
