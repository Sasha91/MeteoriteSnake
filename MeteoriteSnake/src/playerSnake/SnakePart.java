package playerSnake;

import java.nio.file.Path;
import main.LoadService;
import org.jsfml.graphics.*;
import weapons.Weapon;

public abstract class SnakePart {
    protected Texture texture;
    protected Sprite sprite;
    protected Weapon weapon;
    
    protected RenderWindow window;
    
    public SnakePart(RenderWindow window) {
        
        this.window = window;
        
        texture = new Texture();
        sprite = new Sprite();   
    }
    
    protected void setTexture(Path path) {
        LoadService.loadTexture(path, texture);
    }
    
    protected void setSprite() {
        sprite.setTexture(texture);
    }
    
    protected void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
    
    public void setSpritePos(float x, float y) {
        sprite.setPosition(x, y);
    }
    
    public abstract void update(double elapsed);
    public abstract void draw();
}
