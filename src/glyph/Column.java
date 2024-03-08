package glyph;
import java.awt.Point;
import window.Window;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;

public class Column extends Composition {

    public void setAdjustedBounds(Point cursor_pos) {
        getBounds().setArea(getBounds().width(), cursor_pos.y - getBounds().point().y);
    }

    public void setSize(Window window) {
        
        int width = 0;
        int height = 0;

        Glyph child = getChildren().get(0);
        try {
            for (int i = 0; ; i++) {
                int childWidth = child.getBounds().width();
                width = Math.max(width, childWidth);
                height += child.getBounds().height(); 
                child = this.child(i);
            }
        }        
        catch (Exception e) {
            getBounds().setArea(width, height);
        }
        //System.out.println("Column.java setSize");
    }

    public Point moveCursor(Point cursor_pos, Glyph child) {
        cursor_pos.y = child.getBounds().point().y + child.getBounds().height();
        return cursor_pos;
    }

    public Column(Compositor compositor) {
        getBounds().setArea(0,0);
        Point point = new Point(0,0);
        getBounds().point().setLocation(point);
        setChildren(new ArrayList<Glyph>());
        setCompositor(compositor);
        getCompositor().setComposition(this);
        //System.out.println("Column.java constructor");
    }

}