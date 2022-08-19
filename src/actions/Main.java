package src.actions;

import src.clocks.GameClock;
import src.gui.Gui;

public class Main {
    

    public static void main(String[] args) {
        Gui g = Gui.GuiInstance();
        GameClock gc = new GameClock();
        g.create();
        gc.start();
        //gc.run();
    }
}
// wenn nur eine Zeile/Statement in einer if-Anweisung kommt, dann kann man die 
//Curly-Brackets weglassen