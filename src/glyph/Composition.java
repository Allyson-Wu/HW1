package glyph;
import java.awt.Point;
import javax.naming.OperationNotSupportedException;
import window.Window;

public abstract class Composition extends CompositeGlyph {
    
    private Compositor compositor;
    
    public Composition(Window w) {
      compositor=new SimpleCompositor(w);
      compositor.setComposition(this);
      // initialize the inherited children array
    }

    public Compositor getCompositor() {
		return compositor;
	}
    
    public void setCompositor(Compositor compositor) {
        this.compositor = compositor;
    }

    public void compose() {
        compositor.compose();
    }

    public void setBounds(Point cursor);

}
