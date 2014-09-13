/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package weapons.offensive;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jsfml.graphics.*;
import org.jsfml.window.Mouse;
import weapons.Weapon;
import main.LoadService;

public class Laser extends Weapon {
    private float currentAngle;
    private float prevAngle = 0;
    private float length;
    private final RenderWindow window;
    
    private Texture[] impactTextures;
    private Sprite[] impactSprites;
    
    private int impactFrame = 0;
    private double impactFrameElapsed = 0;
    private int impactFrameTime = 50;
    
    
    public Laser(RenderWindow window) {
        
        super();
        this.window = window;
        
        impactTextures = new Texture[spritesInSheet];
        impactSprites = new Sprite[spritesInSheet];
        
        String source = "res/weapons/laser/";
        
        setWeaponTexture(Paths.get(source + "Laserlvl1.png"));
        setWeaponSprite();
        
        setProjectileTexture(Paths.get(source + "LaserBeam.png"));
        setProjectileSprite();
        
        setImpactTextures(Paths.get(source + "LaserImpact.png"));
        setImpactSprites();
        
    }
    
    @Override
    public void setSpritePos(float x, float y) {
        super.weaponSprite.setPosition(x, y);
        super.projectileSprite.setPosition(x, y);
    }
    
    public void update(double elapsed) {
        impactFrameElapsed += elapsed;
        if(impactFrameElapsed >= impactFrameTime) {
            impactFrame = impactFrame + 1 < impactSprites.length - 1 ? impactFrame + 1: 0; 
            impactFrameElapsed = 0;
        }
    }
    
    public void draw() {
        
        impactSprites[impactFrame].setPosition(Mouse.getPosition(window).x, Mouse.getPosition(window).y);
        
        setAngle(impactSprites[impactFrame]);
        setLength();
        window.draw(super.projectileSprite);
        window.draw(super.weaponSprite);
        window.draw(impactSprites[impactFrame]);
    }
    
    private void setAngle(Transformable trans) {
        
        //Reset rotation
        trans.rotate(-prevAngle);
        super.projectileSprite.rotate(-prevAngle);
        super.weaponSprite.rotate(-prevAngle);
        //Calculate angle to rotate
        currentAngle = (float)Math.atan2(Mouse.getPosition(window).y - super.projectileSprite.getPosition().y,
                                        Mouse.getPosition(window).x - super.projectileSprite.getPosition().x);
        currentAngle = currentAngle * (float)(180 / Math.PI);
        
        if(currentAngle < 0)
            currentAngle = 360 + currentAngle;
        
        // set new rotation
        trans.rotate(currentAngle);
        super.projectileSprite.rotate(currentAngle);
        super.weaponSprite.rotate(currentAngle);
        //Store the rotation for resetting on next call
        prevAngle = currentAngle;
 
    }
    
    private void setLength() {
        
        length = (float)Math.sqrt(Math.pow(Mouse.getPosition(window).x - super.projectileSprite.getPosition().x, 2) + 
                        Math.pow(Mouse.getPosition(window).y - super.projectileSprite.getPosition().y, 2));
        
        super.projectileSprite.setTextureRect(new IntRect(0, 0, (int)length, 
                        super.projectileSprite.getTexture().getSize().y)); 
    }
    
    private void setWeaponTexture(Path path) {
        LoadService.loadTexture(path, super.weaponTexture);
    }
    
    private void setWeaponSprite() {
        super.weaponSprite.setTexture(super.weaponTexture);
        super.weaponSprite.setOrigin(super.weaponTexture.getSize().x / 2, super.weaponTexture.getSize().y / 2);
        super.weaponSprite.setScale(2, 2);
        //super.weaponSprite.setPosition(window.getSize().x / 2, window.getSize().y / 2);
        super.weaponSprite.rotate(90);
    }
    
    private void setProjectileTexture(Path path) {
         // load beam texture
        LoadService.loadTexture(path, super.projectileTexture);
        super.projectileTexture.setRepeated(true);
    }
    
    private void setProjectileSprite() {
        
        super.projectileSprite.setPosition(super.weaponSprite.getPosition().x, super.weaponSprite.getPosition().y);
        super.projectileSprite.setTexture(super.projectileTexture);
        super.projectileSprite.setScale(1, 1.5f);
        super.projectileSprite.setOrigin(0, super.projectileSprite.getTexture().getSize().y / 2);
    }
    
    private void setImpactTextures(Path path) {
        int imageSize = 16;

        for(int i = 0; i < 4; i++) {
            impactTextures[i] = new Texture();
            try {
                impactTextures[i].loadFromFile(path, new IntRect(i * imageSize, 0, imageSize, imageSize));
                //impactTextures[i].setRepeated(true);
            } catch (IOException ex) {
                Logger.getLogger(Laser.class.getName()).log(Level.SEVERE, null, ex);
            }  
        }
    }
    
    private void setImpactSprites() {
        for(int i = 0; i < impactSprites.length; i++) {
            
            impactSprites[i] = new Sprite();
            impactSprites[i].setTexture(impactTextures[i]);
            impactSprites[i].setOrigin(impactSprites[i].getTexture().getSize().x / 2, impactSprites[i].getTexture().getSize().y / 2);
            impactSprites[i].scale(2, 2);
        }
    }
}
