package glyph;

public class Character extends Glyph {

    private char character;
    private int width;
    private int height;
    private int x, y;

    public Character(char character) {
        this.character = character;
    }

    public void setCoordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    
    @Override
    public void draw(Window window) {
        width = window.charWidth(this.character);
        height = window.charHeight(this.character);
        window.drawCharacter(character, x, y);
    }
}
