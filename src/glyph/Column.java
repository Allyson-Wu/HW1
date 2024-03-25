package glyph;

public class Column extends Composition{
    public Column(Window window){
        super(window);
    }

    public void draw(Window window){
        super.compose();
    }

    public void updateCoordinate(int x, int y, Glyph child) {
        int tempX = x;
        int tempY = y + child.getHeight();;
        super.setCoordinate(tempX, tempY);
    }
}
