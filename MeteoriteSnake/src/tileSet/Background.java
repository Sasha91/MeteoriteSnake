package tileSet;


import java.nio.file.Paths;
import main.LoadService;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;
import org.jsfml.system.Vector2f;

public class Background {
    
    private Texture texture;
    private Sprite[] background = new Sprite[2];
    private Vector2f direction;
    private RenderWindow window;
    private float x = 0;
    private float y = 0;
    
    public Background(String path, RenderWindow window, Vector2f direction) {
        texture = new Texture();

        this.window = window;
        this.direction = direction;
        
        LoadService.loadTexture(Paths.get(path), texture);
        
        setBackgroundTexture();
    }
    
    public void update() {
        x = (x + direction.x) % window.getSize().x;
        y = (y + direction.y) % window.getSize().y;
        setBackgroundPos();
    }
    
    public void draw(RenderWindow window) {
        window.draw(background[0]);
        
        if(x != 0) {
            
            window.draw(background[1]);
        }
        
            
    }
    
    private void setBackgroundTexture() {
        for(int i = 0; i < background.length; i++) {
            background[i] = new Sprite();
            background[i].setTexture(texture);
        }
    }
    
    private void setBackgroundPos() {
        background[0].setPosition(x, y);
        
        if((int)x < 0)
                background[1].setPosition(x + window.getSize().x, 0);
            else if((int)x > 0)
                background[1].setPosition(x - window.getSize().x, 0);
    }
}
