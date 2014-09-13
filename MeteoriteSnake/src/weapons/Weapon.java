/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package weapons;


import org.jsfml.graphics.Texture;
import org.jsfml.graphics.Sprite;


/**
 *
 * @author Anders
 */
public abstract class Weapon {
    
    protected Texture projectileTexture;
    protected Sprite projectileSprite;
    protected Texture weaponTexture;
    protected Sprite weaponSprite;
    protected int spritesInSheet = 4;
    
    
    public Weapon() {
        projectileTexture = new Texture();
        projectileSprite = new Sprite();
        weaponTexture = new Texture();
        weaponSprite = new Sprite();
    }
    
    public void setSpritePos(float x, float y) {
        weaponSprite.setPosition(x, y);
    }
    
    public abstract void update(double elapsed);
    public abstract void draw();
    
}
