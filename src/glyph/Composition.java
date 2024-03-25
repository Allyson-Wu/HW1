package glyph;

import java.util.ArrayList;

public class Composition extends Glyph{

    private ArrayList<Glyph> children;
    private Compositor compositor;
    private int width;
    private int height;

    public Composition(Window window) {
        compositor = new SimpleCompositor(window);
        compositor.setComposition(this);
        children = new ArrayList<>();
    }

    @Override
    public void insert(Glyph glyph, int index) {
        children.add(index, glyph);
        glyph.setParent(this);
        // compose();
    }

    @Override
    public void remove(int index) {
        children.remove(index);
        // compose();
    }

    public void compose() {
        compositor.compose();
    }

    public ArrayList<Glyph> getchildren() {
        return children;
    }

    // public void setSize(int w, int h) {
    //     width = w;
    //     height = h;
    // }

    // public int[] getSize() {
    //     int[] size = {width, height};
    //     return size;
    // }

    public void updateCoordinate(int x, int y, Glyph child) {};
}