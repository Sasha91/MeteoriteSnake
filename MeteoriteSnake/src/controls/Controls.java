package controls;

import org.jsfml.window.Keyboard;
import org.jsfml.window.Mouse;
import org.jsfml.window.event.Event;

public abstract class Controls {
    
    protected enum InputType {
      mouseInput,
      keyboardInput
    };
    
    protected class keys {
        public InputType inputType;
        public Event.Type eventType;
        public Keyboard.Key keyCode;
        public Mouse.Button mouseButton;
    };
    
    public abstract void checkMouseEvents();
    public abstract void checkKeyboardEvents();
}
