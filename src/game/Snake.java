package src.game;

import static src.gui.Gui.GuiInstance;
import java.awt.*;
import java.util.ArrayList;

public class Snake {

    public static boolean waitToMove = false;

    public static Head head = new Head(7, 7);
    public static ArrayList<Tail> tails = new ArrayList<>();

    public static void reset() {
        head.setX(7);
        head.setY(7);
        tails.clear();
    }

    public static Pickup pickup = new Pickup();

    public static void addTail() {
        if (tails.size() < 1) {
            tails.add(new Tail(head.getX(), head.getY()));
        } else {
            tails.add(new Tail(tails.get(tails.size() - 1).x, tails.get(tails.size() - 1).y));
        }
    }

    // am besten nicht static die nächsten 3,,,
    public Integer score() {
        int score = tails.size();

        return score;
    }

    public void move() {
        // Move Tails

        if (tails.size() >= 2) {
            for (int i = tails.size() - 1; i >= 1; i--) {
                if (tails.get(i).isWait()) {
                    tails.get(i).setWait(false);
                } else {
                    tails.get(i).setX(tails.get(i - 1).getX());
                    tails.get(i).setY(tails.get(i - 1).getY());
                }
            }
        }
        // Move first Tail to head
        if (tails.size() >= 1) {
            if (tails.get(0).isWait()) {
                tails.get(0).setWait(false);
            } else {
                tails.get(0).setX(head.getX());
                tails.get(0).setY(head.getY());
            }
        }

        // Move head

        switch (head.getDir()) {
            case RIGHT:
                head.setX(head.getX() + 1);
                break;
            case LEFT:
                head.setX(head.getX() - 1);
                break;
            case UP:
                head.setY(head.getY() - 1); // Y wird andersrum gezählt
                break;
            case DOWN:
                head.setY(head.getY() + 1);
                break;
        }

    }

    // Position to Coordinates
    public static Point ptc(int x, int y) {
        Point p = new Point(0, 0); // Point ist in standard-libary awt (siehe Import)
        p.x = x * 32 + GuiInstance().xoff;
        p.y = y * 32 + GuiInstance().yoff;

        return p;

        // static bei Utility_Methoden
    }

}
