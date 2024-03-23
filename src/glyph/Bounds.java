package glyph;

public class Bounds {

    private int x, y, width, height;

    public Bounds(int x,int y,int w,int h) {
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
    }
    
    public int x() {
        return x;
    }
    public int y() {
        return y;
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
}
