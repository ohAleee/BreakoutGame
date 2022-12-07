package breakout.manager;

import breakout.graphics.Gui;
import breakout.item.game.Ball;
import breakout.item.game.Brick;
import breakout.item.game.Paddle;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameManager {

    private Thread thread;
    private final Paddle paddle;
    private final Ball ball;
    private final List<Brick> bricks = new ArrayList<>();

    public GameManager() {

        paddle = new Paddle(300, 50, Gui.WIDTH / 2 - 1 - 100, Gui.HEIGHT - 70, 10);
        ball = new Ball(this, 20, 20, Gui.WIDTH / 2, Gui.HEIGHT / 2, 3);

        int side = 50;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                bricks.add(new Brick(side, j * 90 + 30, i * 60 + 30));
            }

        }
    }

    public void start(Component component) {
        thread = new Thread(() -> {
            while (true) {

                ball.move();

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                component.repaint();
            }
        });
        thread.start();
    }

    public void stop() {
        thread.interrupt();
    }

    public List<Brick> getBricks() {
        return bricks;
    }

    public Ball getBall() {
        return ball;
    }

    public Paddle getPaddle() {
        return paddle;
    }
}
