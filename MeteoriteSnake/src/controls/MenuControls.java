/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controls;

/**
 *
 * @author Anders
 */
public class MenuControls extends Controls {
    
    private int selection = 0;
    
    public MenuControls() {
        
    }
    
    public int getSelection() {
        return selection;
    }

    @Override
    public void checkMouseEvents() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void checkKeyboardEvents() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
