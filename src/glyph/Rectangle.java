package glyph;

public class Rectangle extends Glyph {

    private int w = 10;
    private int h = 10;

    
    public Rectangle(int w, int h){
        this.w = w;
        this.h = h;
    }

    @Override
    public void draw(Window window) {
        window.drawRectangle(10,10, w, h); // 假設所有字符都在(0,0)處繪製
    }
}
