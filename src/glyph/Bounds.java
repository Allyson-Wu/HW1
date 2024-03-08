package glyph;

import java.awt.Point;

public class Bounds {

    private Point upperLeft;
    private int width;
    private int height;

    public Point point() {
        return upperLeft;
    }

    public int width() {
        return width;
    }

    public int height() {
        return height;
    }

    public void setArea(int width, int height) {
        this.width = width;
        this.height = height;
    }   

    public Bounds(Point upperLeft, int width, int height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }
}