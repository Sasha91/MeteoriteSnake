package playerSnake;

import java.nio.file.Paths;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.window.Keyboard;
import org.jsfml.window.Keyboard.Key;
import org.jsfml.window.event.Event;
import org.jsfml.window.event.KeyEvent;
import playerSnake.Snake.Direction;
import weapons.offensive.Laser;

public class SnakeHead extends SnakePart {
    
    // Up, Down, Left, Right
    private final int[] rotation = {0, 180, 270, 90};
    private int resetRot = 0;
    
    public SnakeHead(RenderWindow window) {
        super(window);
        
        super.setTexture(Paths.get("res/snake/Head.png"));
        this.setHeadSprite();
        super.setWeapon(new Laser(window));
    }
    
    private void setHeadSprite() {
        super.setSprite();
        super.sprite.setOrigin(super.texture.getSize().x / 2, super.texture.getSize().y / 2);
        super.sprite.scale(2, 2);
        
        super.sprite.setPosition(200, 200);
        
        
    }
    
    @Override
    public void update(double elapsed) {
        super.weapon.update(elapsed);
        super.weapon.setSpritePos(super.sprite.getPosition().x, super.sprite.getPosition().y);
//        setDirection();
    }
    
    @Override
    public void draw() {
        window.draw(sprite);
        //super.weapon.draw();
    }
    
//    private void setDirection() {
//        
//        Key key;
//        
//        
//        if(super.window.pollEvent().type == Event.Type.KEY_PRESSED) {
//            key = KeyEvent.;
//        }
//        
//        if(Keyboard.isKeyPressed(Keyboard.Key.W) || Keyboard.isKeyPressed(Keyboard.Key.S) ||
//                
//                Keyboard.isKeyPressed(Keyboard.Key.A) || Keyboard.isKeyPressed(Keyboard.Key.D)) {
//            
//        }
//        if(Keyboard.isKeyPressed(Keyboard.Key.W)) {
//            super.sprite.setRotation(rotation[0]);
//            resetRot = rotation[0];
//        } else if(Keyboard.isKeyPressed(Keyboard.Key.S)) {
//            super.sprite.setRotation(rotation[0]);
//            resetRot = rotation[0];
//        } else if(Keyboard.isKeyPressed(Keyboard.Key.A)) {
//            super.sprite.setRotation(rotation[0]);
//            resetRot = rotation[0];
//        } else if(Keyboard.isKeyPressed(Keyboard.Key.D)) {
//            super.sprite.setRotation(rotation[0]);
//            resetRot = rotation[0];
//        }
//    }
}
