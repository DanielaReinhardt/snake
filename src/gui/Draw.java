package src.gui;

import src.game.Snake;
import javax.swing.*;

import java.awt.*;

public class Draw extends JLabel {
    Snake snake = new Snake();
    Point p;
    Integer score = snake.score();
    Gui gui = Gui.GuiInstance();

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);

        // draw Backgroud
        g.setColor(Color.LIGHT_GRAY); // Hintergrund
        g.fillRect(0, 0, gui.width, gui.height); // Hintergrund, damit er ausgefüllt wird

        // Draw Snake Tails
        g.setColor(new Color(51, 204, 51));
        for (int i = 0; i < Snake.tails.size(); i++) {
            p = Snake.ptc(Snake.tails.get(i).getX(), Snake.tails.get(i).getY());
            g.fillRect(p.x, p.y, 32, 32);
        }

        // Draw Snake Head
        g.setColor(new Color(0, 153, 0));
        p = Snake.ptc(Snake.head.getX(), Snake.head.getY());
        g.fillRect(p.x, p.y, 32, 32);

        // Draw Pickup
        g.setColor(new Color(204, 51, 0));
        p = Snake.ptc(Snake.pickup.getX(), Snake.pickup.getY());
        g.fillRect(p.x, p.y, 32, 32);

        // Draw Grid (Raster)
        g.setColor(Color.GRAY);
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                g.drawRect(i * 32 + gui.xoff, j * 32 + gui.yoff, 32, 32);
            }
        }

        // Draw Border
        g.setColor(Color.BLACK); // schwarzer Rand
        g.drawRect(gui.xoff, gui.yoff, 512, 512); // drawRect Umrandung im Gegensatz zu fillRect / 16x16 Felder bei
                                                  // Größe von 32x32px

        repaint(); // damit es neugezeichnet wird

        requestFocus();
    }
}
