package src.gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import src.actions.KeyHandler;
import src.clocks.GameClock;
import src.game.Snake;

public class Gui {

    // Singleton Pattern:
    // sicherstellen, dass die Gui nur einmal instanziert werden kann
    private static Gui guiInstance;

    public static Gui GuiInstance() {
        if (guiInstance == null)
            guiInstance = new Gui();
        return guiInstance;
    }

    private Gui (){

    }

    Snake snake = new Snake();
    private JFrame jf = new JFrame();
    private Draw d;
    // Siehe:
    // https://stackoverflow.com/questions/852631/java-swing-how-to-show-a-panel-on-top-of-another-panel#852792
    private JLayeredPane layeredPane = new JLayeredPane();
    private JPanel scorePanel = new JPanel();
    private ScoreLabel scoreLabel = new ScoreLabel();
    

    public int width = 800, height = 600; // größe des Fensters, könnte man auch private machen
    public int xoff = 130, yoff = 20; // Spielfeld in etwa in der Mitte des Fensters, zum Verwenden in der
    // Draw-Klasse
    private JButton button = new JButton ("Start");

    public void create() {
        // Titel
        jf.setTitle("Snake");
        jf.setSize(width, height);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // schließt wenn man auf das rote x drückt
        jf.setLocationRelativeTo(null); // man startet das Fenster beim Hauptbildschirm in der Mitte
        // jf.setLayout(null); // nicht unbedingt wichtig hier; wenn man Button bspw auf
        // gewisse Positionen setzten will, dann muss man Layout auf null setzen sonst
        // werden Dinge selbst angereiht
        jf.setResizable(false); // nicht in Größe veränderbar, dann keine Skalierung erforderlich
        jf.addKeyListener(new KeyHandler());
        jf.setFocusable(true);
        jf.add(layeredPane);
      

        d = new Draw();
        d.setBounds(0, 0, width, height);
        d.setVisible(true); // macht das Spielfeld sichtbar.
        layeredPane.add(d, 0, 0); // Draw dem JLayeredPane hinzufügen

        scoreLabel.setText("Current score: " + snake.score());
        scoreLabel.setVisible(true);

        scorePanel.setSize(150, 60);
        scorePanel.add(scoreLabel);
        scorePanel.setBackground(new Color(255, 255, 255, 127));
        scorePanel.setVisible(true);
        scorePanel.add(button); //vermutlich selbst Keylistener, daher steuerung nicht mehr möglich
        layeredPane.add(scorePanel, 1, 0);
        

        // Zu guter Letzt
        jf.requestFocus(); // zum Hinzufügen der Tastatureingabe
        jf.setVisible(true);
    }

    private class ScoreLabel extends JLabel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            setText("Current score: " + snake.score());
            repaint();
        }
    }

   public void addButtonAction() {
       button.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               GameClock gc = new GameClock();
              // System.exit(0); //Fenster schließt sich damit
               // gc.run(); geht nicht weil while-Schleife sich verheddert
              }
            
           
        });
   }

}
