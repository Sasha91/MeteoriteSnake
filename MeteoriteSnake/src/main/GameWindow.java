/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import gameState.GameStateManager;
import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.window.VideoMode;
import org.jsfml.window.event.Event;

public class GameWindow extends RenderWindow {
    
    private final int height = 720;
    private final int width = height * 16/9;
    
    private GameStateManager gsm;
    
    public GameWindow(String title) {
        
        create(new VideoMode(width, height), title);
        
        gsm = new GameStateManager();
    }
    
    public void run() {
        Color clearColor = new Color(0, 0, 0, 255);
        
        gsm.pushMenuState(this);
        
        while(this.isOpen()) {
            
            gsm.update();
            
            this.clear(clearColor);
            
            gsm.draw();
            
            for(Event event : this.pollEvents()) {
                if(event.type == Event.Type.CLOSED)
                    this.close();
            }
        }
    }
    
}
