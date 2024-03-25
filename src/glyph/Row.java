package glyph;

public class Row extends Composition {

    private int width;
    private int height;
    private int x, y;

    public Row(Window window){
        super(window);
        width = 0;
        height = 0;
    }

    public void draw(Window window){
        super.compose();
    }

    public void setCoordinate(int x, int y, Glyph child) {
        this.x = x + child.getWidth();
        this.y = y;
        width += child.getWidth();
        height = Math.max(height, child.getHeight());
    }

    public int[] getCoordinate() {
        int[] coordinate = {x, y};
        return coordinate;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
