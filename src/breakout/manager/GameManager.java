package breakout;

import breakout.item.game.Ball;
import breakout.item.game.Brick;
import breakout.item.game.Paddle;

import java.util.ArrayList;
import java.util.List;

public class GameManager {

    private Thread thread;
    private final Paddle paddle;
    private final Ball ball;
    private final List<Brick> bricks = new ArrayList<>();

    public GameManager() {

        ball = new Ball(20, 20, Gui.WIDTH / 2, Gui.HEIGHT / 2, 4);
        paddle = new Paddle(200, 75, Gui.WIDTH / 2 - 1 - 100, Gui.HEIGHT - 10, 10);

        for (int i = 0; i < 10; i++) {
            bricks.add(new Brick(50, i*5+20, i%5));
        }

    }

    public void start() {
        thread = new Thread(() -> {
            while (true) {

                ball.move();

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


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
