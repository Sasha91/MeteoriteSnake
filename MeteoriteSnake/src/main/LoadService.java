
package main;

import java.io.IOException;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsfml.graphics.Texture;
import weapons.Weapon;

public class LoadService {
    public static void loadTexture(Path texPath, Texture texture) {
        
        try {
            texture.loadFromFile(texPath);
        } catch (IOException ex) {
            Logger.getLogger(Weapon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
