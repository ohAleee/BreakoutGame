package breakout;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Gui extends JFrame {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    public Gui() {
        super("Breakout");

        GameManager manager = new GameManager();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        GamePanel panel = new GamePanel(manager);
        panel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT -> manager.getPaddle().move(false);
                    case KeyEvent.VK_RIGHT -> manager.getPaddle().move(true);
                }
            }
        });
        add(panel);

        setVisible(true);

        manager.start();
    }

}
