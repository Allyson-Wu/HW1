package glyph;
import java.awt.Point;
import javax.naming.OperationNotSupportedException;
import window.Window;

public abstract class Composition extends CompositeGlyph {
    
    private Compositor compositor;
    
    // public Composition(Window w) {
    //   compositor=new SimpleCompositor(w)
    //   compositor.setComposition(this);
    //   // initialize the inherited children array
    // }

    public void insert(Glyph glyph, int position) throws OperationNotSupportedException, IndexOutOfBoundsException {
        super.insert(glyph, position);
        glyph.setParent(this);
        findroot();
        //System.out.println("Composition.java insert");
    }

    public void findroot() {
        boolean found = false;
        Glyph current = this;
        while(!found) {
            if (current.getParent() != null) {
                current = current.getParent();
            }
            else {
                current.compose();
                found = true;
            }
        }
    }

    public Compositor getCompositor() {
		return compositor;
	}
    
    public void setCompositor(Compositor compositor) {
        this.compositor = compositor;
    }
    
    public void draw(Window window) {
        super.draw(window);
    }

    public void compose() {
        compositor.compose();
    }

    public abstract void setAdjustedBounds(Point cursor);

}
