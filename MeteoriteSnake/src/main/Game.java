package main;

import org.jsfml.graphics.*;
import org.jsfml.window.VideoMode;
import org.jsfml.window.event.Event;
import playerSnake.Snake;

public class Game {
    
    public static void main(String[] args) {
        
        GameWindow gameWindow = new GameWindow("Meteorite Snake");
        
        gameWindow.setFramerateLimit(60);
        gameWindow.run();
    }
    

    
    
}
