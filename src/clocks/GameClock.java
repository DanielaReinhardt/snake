package src.clocks;

import src.actions.Collision;
import src.game.Snake;


public class GameClock extends Thread{
    public boolean running = true;
    public static boolean restartRequest;
    
    //hier nicht unbedingt Singleton-Pattern erforderlich,
    //da die Snake immer wieder neu generiert wird (nach Tod)
    Snake snake = new Snake();

       
    public void run(){
        if(restartRequest = true){
        while(running){
            try{
                
                sleep(50);
                snake.move();
                Snake.waitToMove = false;
                Collision.collidePickUp();
                if(Collision.collideSelf()){
                    snake.score();
                    sleep(2000);
                    Snake.tails.clear();
                    
                }
                if(Collision.collideWall()){
                    snake.score();
                    sleep(2000); // damit der Score kurz sichtbar ist....
                    Snake.tails.clear();
                    Snake.head.setX(7);
                    Snake.head.setY(7);
                    
                                    
                   
                    
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            

            
        }
        
        }
        
    }
    
    
    
    }



