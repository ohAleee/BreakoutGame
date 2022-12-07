package breakout.manager;

import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class GameManager {

    private final ItemManager items;
    private final Timer timer = new Timer();
    private boolean running = false;

    public GameManager(ItemManager items) {
        this.items = items;
        init();
    }

    public void init() {
        items.init();
    }

    public void reset() {
        running = false;

        items.reset();
        init();
    }

    public void start() {
        running = true;
    }

    public void initThread(JPanel panel) {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (!running)
                    return;

                if (items.getBricks().isEmpty()) {
                    reset();
                    return;
                }

                items.getBall().move();
                panel.repaint();
            }
        }, 0, 10);
    }

    public boolean isRunning() {
        return running;
    }
}
