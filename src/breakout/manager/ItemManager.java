package breakout.manager;

import breakout.graphics.Gui;
import breakout.item.game.Ball;
import breakout.item.game.Brick;
import breakout.item.game.Paddle;

import java.util.ArrayList;
import java.util.List;

public class ItemManager {

    private final List<Brick> bricks = new ArrayList<>();
    private Paddle paddle;
    private Ball ball;
    private GameManager gameManager;

    public void init() {
        paddle = new Paddle(300, 50, Gui.WIDTH / 2 - 1 - 100, Gui.HEIGHT - 70, 10);
        ball = new Ball(this, 20, 20, Gui.WIDTH / 2, Gui.HEIGHT / 2, 5);

        initBricks();
    }

    public void reset() {
        bricks.clear();
    }

    private void initBricks() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                bricks.add(new Brick(50, j * 90 + 30, i * 60 + 30));
            }
        }
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

    public void setGameManager(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    public GameManager getGame() {
        return gameManager;
    }
}
