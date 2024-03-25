package glyph;

public class Rectangle extends Glyph {
    
    public Rectangle(int width, int height){
        super.setWidth(width);
        super.setHeight(height);
    }

    @Override
    public void draw(Window window) {
        int[] coordinate = getCoordinate();
        window.drawRectangle(coordinate[0], coordinate[1], getWidth(), getHeight());
    }
}
