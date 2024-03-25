package glyph;

import java.util.ArrayList;

public class Composition extends Glyph{

    private ArrayList<Glyph> children;
    private Compositor compositor;

    public Composition(Window window) {
        compositor = new SimpleCompositor(window);
        compositor.setComposition(this);
        children = new ArrayList<>();
    }

    @Override
    public void insert(Glyph glyph, int index) {
        children.add(index, glyph);
        glyph.setParent(this);
    }

    @Override
    public void remove(int index) {
        children.remove(index);
    }

    public void compose() {
        compositor.compose();
    }

    public ArrayList<Glyph> getchildren() {
        return children;
    }

    public void updateCoordinate(int x, int y, Glyph child) {};
}