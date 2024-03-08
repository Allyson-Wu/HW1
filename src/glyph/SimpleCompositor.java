package glyph;

import window.Window;
import java.awt.Point;
import javax.naming.OperationNotSupportedException;

public class SimpleCompositor implements Compositor {

    private Window window;
    private Composition composition;

    public void setComposition(Composition composition) {
        this.composition = composition;
    }

    public void compose() {

        // create cursor based on parent
        Point cursor = composition.getBounds().point();
        Glyph child = null;
        Glyph startingPoint = null;
        int position = 0;

        boolean out = false;
        while(!out) {
            try {
                if(composition.child(position) != null) {
                    child = composition.child(position);
                    if (startingPoint == null) {
                        startingPoint = child;
                    }
                    child.setSize(window); 
                    
                    Bounds bounds = child.getBounds();
                    Point point = bounds.point();
                    point.setLocation(cursor.x, cursor.y); 
                    composition.child(position).compose();
                    cursor = composition.moveCursor(cursor, child);
                }
                composition.setAdjustedBounds(cursor);
                composition.setSize(window);

            }
            catch (OperationNotSupportedException exception) {
                System.out.println("OperationNotSupportedException caught: " + exception.getMessage());
            }
            catch (IndexOutOfBoundsException exception) {
                out = true;
                System.out.println("IndexOutOfBoundsException caught: " + exception.getMessage());
            }
            position++;
        }
        // ask parent to adjust itself, based on cursor
        if (startingPoint != null) {
            composition.getBounds().point().setLocation(startingPoint.getBounds().point());
        }

    }

    public SimpleCompositor(Window window) {
        this.window = window;
        //System.out.println("SimpleCompositor.java constructor");
    }
}