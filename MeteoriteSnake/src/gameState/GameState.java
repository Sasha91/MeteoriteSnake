package gameState;

import controls.Controls;
import controls.MenuControls;
import org.jsfml.graphics.RenderWindow;

public abstract class GameState {
    
    protected GameStateManager gsm;
    protected RenderWindow window;
    protected Controls controls;
    
    protected double timerBegin;
    protected double timerEnd;
    protected double elapsed = 0;
    
    
    public GameState(GameStateManager gsm, RenderWindow window, Controls controls) {
        
        this.controls = controls;
        this.gsm = gsm;
        this.window = window;
    }
    
    public abstract void update();
    
    public abstract void draw();
    
    protected void setBeginTime() {
        timerBegin = System.currentTimeMillis();
    }
    
    protected void setEndTime() {
        timerEnd = System.currentTimeMillis();
    }
    
    protected void setElapsedTime() {
        elapsed = timerEnd - timerBegin;
    }
    
}
