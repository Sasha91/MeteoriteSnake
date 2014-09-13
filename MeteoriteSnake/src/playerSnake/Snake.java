package playerSnake;

import java.util.ArrayList;
import org.jsfml.graphics.RenderWindow;

public class Snake {
    private ArrayList<SnakePart> snake;
    private RenderWindow window;
        
    public enum Direction { up, down, left, right};
    
    public Snake(RenderWindow window) {
        
        this.window = window;
        snake = new ArrayList<>();
        
        createHead(window);
    }
    
    private void createHead(RenderWindow window) {
        snake.add(new SnakeHead(window));
    }
    
    public void update() {
        
        for(int i = 0; i < snake.size(); i++) {
            snake.get(i).update(elapsed);
        }
    }
    
    public void draw() {
        for(int i = 0; i < snake.size(); i++) {
            snake.get(i).draw();
        }
        
        
    }
    
    
}
