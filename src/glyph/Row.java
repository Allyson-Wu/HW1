package glyph;

public class Row extends Composition {
    
    public Row(Window window){
        super(window);
    }

    public void draw(Window window){
        super.compose();
    }

    public void updateCoordinate(int x, int y, Glyph child) {
        int tempX = x + child.getWidth();
        int tempY = y;
        super.setCoordinate(tempX, tempY);
    }
}
