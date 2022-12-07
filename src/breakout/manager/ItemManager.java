package breakout.manager;

import breakout.item.game.Ball;
import breakout.item.game.Brick;
import breakout.item.game.Paddle;
import breakout.util.ImageUtil;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ItemManager {

    public static final BufferedImage PADDLE = ImageUtil.getImage(300, 50, "https://imgur.com/4Hqy72D.png");
    public static final BufferedImage BALL = ImageUtil.getImage(20, 20, "https://i.imgur.com/irrGXYX.png");
    public static final BufferedImage BRICK = ImageUtil.getImage(50, 50, "https://i.imgur.com/7mQcvCg.png");

    private final List<Brick> bricks = new ArrayList<>();
    private Paddle paddle;
    private Ball ball;
    private GameManager gameManager;

    public void init() {
        Random random = new Random();

        paddle = new Paddle(PADDLE, 10);
        ball = new Ball(BALL, this, random.nextInt(3) + 5, -(random.nextInt(5) + 4));

        initBricks();
    }

    public void reset() {
        bricks.clear();
    }

    private void initBricks() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                bricks.add(new Brick(BRICK, j * 90 + 30, i * 60 + 30));
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
