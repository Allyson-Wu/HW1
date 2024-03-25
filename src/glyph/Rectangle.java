package glyph;

public class Rectangle extends Glyph {

    private int width;
    private int height;
    private int x, y;
    
    public Rectangle(int width, int height){
        this.width = width;
        this.height = height;
    }

    public void setCoordinate(int x, int y) {
        this.x = x;
        this.y = y;
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

    @Override
    public void draw(Window window) {
        window.drawRectangle(x, y, width, height);
    }
}
