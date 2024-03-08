package glyph;
import window.Window;

import java.awt.Point;

public class Rectangle extends Glyph {

    public void setSize(Window window) {
 
    }

    public void draw(Window window) {
        
        int x = getBounds().point().x;
        int y = getBounds().point().y;
        int w = getBounds().width();
        int h = getBounds().height();

        window.drawRectangle(x, y, w, h);
        //System.out.println("Rectangle.java draw");
    }

    public Rectangle(int w, int h) {

        setParent(null);
		getBounds().point().setLocation(new Point(0,0));
        getBounds().setArea(w, h);
        //System.out.println("Rectangle.java constructor");
    }

}