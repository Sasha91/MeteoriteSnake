package gameState;

import controls.MenuControls;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsfml.graphics.Color;
import org.jsfml.graphics.Font;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Text;
import org.jsfml.system.Vector2f;
import tileSet.Background;

public class MenuState extends GameState {
    
    private Background background;
    private Text[] options = new Text[3];
    private int selection = 0;
    
    public MenuState(GameStateManager gsm, RenderWindow window) {
        super(gsm, window, new MenuControls());

        background = new Background("res/backgrounds/menu/MenuBG.png", window, new Vector2f(-0.2f, 0.0f));
        
        setMenuText();
    }

    @Override
    public void update() {
        super.setBeginTime();
        background.update();
    }

    @Override
    public void draw() {
        background.draw(window);
        
        for(int i = 0; i < options.length; i++) {
            if(selection == i)
                options[i].setColor(Color.RED);
            else
                options[i].setColor(Color.BLACK);
            
            window.draw(options[i]);
        }
        
        super.window.display();
        
        super.setEndTime();
        super.setElapsedTime();
    }
    
    private void setMenuText() {
        try {
            String[] texts = {"Play", "Options", "Exit"};
            
            Font font = new Font();
            font.loadFromFile(Paths.get("res/fonts/menu/Menufont.TTF"));
            
            for(int i = 0; i < options.length; i++) {
                options[i] = new Text();
                options[i].setFont(font);
                options[i].setString(texts[i]);
                options[i].setCharacterSize(32);
                options[i].setOrigin(options[i].getGlobalBounds().width / 2, options[i].getGlobalBounds().height/2);
                options[i].setPosition(window.getSize().x / 2, window.getSize().y / 3 + i * 150);
            }
        } catch (IOException ex) {
            Logger.getLogger(MenuState.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
