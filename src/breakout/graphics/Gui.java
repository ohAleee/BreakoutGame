package breakout.graphics;

import breakout.manager.GameManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Gui extends JFrame {

    public static final int WIDTH = 600;
    public static final int HEIGHT = 1000;

    public Gui() {
        super("Breakout");

        GameManager manager = new GameManager();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLayout(null);
        setLocationRelativeTo(null);

        GamePanel panel = new GamePanel(manager);
        panel.setBackground(Color.GRAY);
        panel.setSize(new Dimension(WIDTH, HEIGHT));
        panel.setFocusable(true);
        panel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT -> manager.getPaddle().move(false);
                    case KeyEvent.VK_RIGHT -> manager.getPaddle().move(true);
                }
            }
        });
        add(panel);

        setVisible(true);

        manager.start(panel);
    }

}
