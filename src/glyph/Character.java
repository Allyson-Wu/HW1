package glyph;

import java.awt.Point;
import window.Window;

public class Character extends Glyph {
    
    private char character;

    public void setSize(Window window) {

        int w = window.charWidth(this.character);
        int h = window.charHeight(this.character);

        getBounds().setArea(w, h); 
        //System.out.println("Character.java setSize");
    }

    public void draw(Window window) {
        
        int x = getBounds().point().x;
        int y = getBounds().point().y;

        window.drawCharacter(character, x, y);
        //System.out.println("Character.java draw");
    }

    public Character(char character) {
        
        this.character = character;
        setParent(null);
        getBounds().point().setLocation(new Point(0,0));
        getBounds().setArea(0, 0);
        //System.out.println("Character.java constructor");
    }

}