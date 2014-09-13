package gameState;

import java.util.Stack;
import org.jsfml.graphics.RenderWindow;

public class GameStateManager {
    
    private Stack<GameState> gameStates;
    
    public GameStateManager() {
        
        gameStates = new Stack<>();
    }
    
    public void pushMenuState(RenderWindow window) {
        gameStates.push(new MenuState(this, window));
    }
    
    public void update() {
        gameStates.peek().update();
    }
    
    public void draw() {
        gameStates.peek().draw();
    }
}
