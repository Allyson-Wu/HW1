package glyph;
import java.awt.Point;
import window.Window;

import javax.naming.OperationNotSupportedException;

abstract class Glyph {

    private Glyph parent;
    private Bounds bounds = new Bounds(new Point(0,0), 0 ,0);  //upperLeft(x,y), width, height

    public void setParent(Glyph glyph) {
        this.parent = glyph;
        //System.out.println("Glyph.java setParent---------\n");
    }

    public Glyph getParent() {
        return parent;
    }

    public abstract void draw(Window window);

    public Bounds getBounds() {
        return bounds;
    }

	public void insert(Glyph glyph, int position) throws OperationNotSupportedException, IndexOutOfBoundsException {
        while(position > children.size()) { // fill missing spots with "null"
            children.add(children.size(), null);
        }
		children.add(position, glyph);
	}

    public void remove() throws Exception {}

    public void compose() {}

    public abstract void setSize(Window window);
}