package glyph;
import java.awt.Point;
import java.util.ArrayList;

import javax.naming.OperationNotSupportedException;

import window.Window;

//import javax.naming.OperationNotSupportedException;

public abstract class Glyph {

    private Glyph parent;
    private ArrayList<Glyph> children;
    private Bounds bounds = new Bounds(new Point(0,0), 0 ,0);  //upperLeft(x,y), width, height
    public abstract Point moveCursor(Point cursor, Glyph child);

    public void setParent(Glyph glyph) {
        this.parent = glyph;
        //System.out.println("Glyph.java setParent---------\n");
    }

    public Glyph getParent() {
        return parent;
    }

	public void setChildren(ArrayList<Glyph> children) {
		this.children = children;
	}

	public ArrayList<Glyph> getChildren() {
		return children;
	}

    // public abstract void draw(Window window);

    public void draw(Window window) {
        for(int i = 0; i < children.size(); i++) {
            if(children.get(i) != null) {
                children.get(i).draw(window);
            }
        }
    }
    public Bounds getBounds() {
        return bounds;
    }

	public void insert(Glyph glyph, int position) throws OperationNotSupportedException, IndexOutOfBoundsException {
        while(position > children.size()) { // fill missing spots with "null"
            children.add(children.size(), null);
        }
		children.add(position, glyph);
        //System.out.println("CompositeGlyph.java insert");
	}

    public void compose() {

    }
	public Glyph child(int position) throws OperationNotSupportedException, IndexOutOfBoundsException {
       
        if(position >= children.size() || position < 0) {
            throw new IndexOutOfBoundsException("IndexOutOfBoundsException caught: There's no child");
        }
        return children.get(position);
    }

    public abstract void setSize(Window window);
}