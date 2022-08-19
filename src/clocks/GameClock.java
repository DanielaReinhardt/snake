package src.clocks;

import src.actions.Collision;
import src.game.Snake;

public class GameClock extends Thread {
    public boolean running = true;
    public static boolean restartRequested;

    // hier nicht unbedingt Singleton-Pattern erforderlich,
    // da die Snake immer wieder neu generiert wird (nach Tod)
    Snake snake = new Snake();
    public void run() {
        while (running) {
            try {
                sleep(50);
                snake.move();
                Snake.waitToMove = false;
                Collision.collidePickUp();
                if (Collision.collideSelf()) {
                    snake.score();
                    sleep(2000);
                    Snake.reset();
                }
                if (Collision.collideWall()) {
                    snake.score();
                    sleep(2000); // damit der Score kurz sichtbar ist....
                    Snake.reset();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
