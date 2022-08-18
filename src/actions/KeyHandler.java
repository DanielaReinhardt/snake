package src.actions;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import src.game.Dir;
import src.game.Snake;

public class KeyHandler implements KeyListener{

    @Override
    public void keyTyped(KeyEvent e){ //wenn eine Taste ein Zeichen eingibt

    }

    @Override
    public void keyPressed(KeyEvent e) { //wenn Taste gedrückt wird
        
        switch(e.getKeyCode()) {
            case KeyEvent.VK_UP: //wenn man auf die W-Taste (oben) drückt
                if(!Snake.waitToMove) {
                    Snake.head.setDir(Dir.UP);
                    //Snake.waitToMove = true; 
                }
                break;
            case KeyEvent.VK_LEFT: 
                if (!Snake.waitToMove) {
                    Snake.head.setDir(Dir.LEFT);
                    //Snake.waitToMove = true; // keine weiteren Eingaben bis er dann einmal nach oben gelaufen ist, falls
                                             // man wild die Tasten drückt
                }
                break;
            case KeyEvent.VK_DOWN: 
                if (!Snake.waitToMove) {
                    Snake.head.setDir(Dir.DOWN);
                    //Snake.waitToMove = true; 
                }
                break;
            case KeyEvent.VK_RIGHT: 
                if (!Snake.waitToMove) {
                    Snake.head.setDir(Dir.RIGHT);
                    //Snake.waitToMove = true; 
                }
                break;
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) { //beim Loslassen der Taste
        // TODO Auto-generated method stub
        
    }
    
}
