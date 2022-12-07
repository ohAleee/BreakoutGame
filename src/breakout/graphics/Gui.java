package breakout.graphics;

import breakout.manager.GameManager;
import breakout.manager.ItemManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Gui extends JFrame {

    public static final int WIDTH = 600;
    public static final int HEIGHT = 1000;

    public Gui() {
        super("Breakout");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLayout(null);
        setLocationRelativeTo(null);

        ItemManager items = new ItemManager();
        GameManager game = new GameManager(items);
        items.setGameManager(game);

        GamePanel panel = new GamePanel(items);
        panel.setBackground(Color.GRAY);
        panel.setSize(getMaximumSize());
        panel.setFocusable(true);
        panel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_SPACE -> {
                        if (game.isRunning()) game.reset();
                        else game.start();
                    }
                    case KeyEvent.VK_LEFT -> items.getPaddle().move(false);
                    case KeyEvent.VK_RIGHT -> items.getPaddle().move(true);
                }
            }
        });
        add(panel);

        game.initThread(panel);

        setVisible(true);
    }

}
