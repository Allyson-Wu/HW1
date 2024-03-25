package glyph;

import java.util.ArrayList;

public class Composition extends Glyph{

    private ArrayList<Glyph> children;
    private Compositor compositor;
    private Window window;
    private int width;
    private int height;
    private int x, y;

    public Composition(Window window) {
        this.window = window;
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

    @Override 
    public void draw(Window window){
        for(Glyph child: children){
            child.draw(window);
        }
    }

    public void compose() {
        compositor.compose();
    }

    public ArrayList<Glyph> getchildren() {
        return children;
    }

    public void setSize(int w, int h) {
        width = w;
        height = h;
    }

    public int[] getSize() {
        int[] size = {width, height};
        return size;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setCoordinate(int x, int y, Glyph child) {}

    public int[] getCoordinate() {
        int[] coordinate = {x, y};
        return coordinate;
    }
}