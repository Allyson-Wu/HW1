package glyph;

public class Character extends Glyph {

    private char character;

    public Character(char character) {
        this.character = character;
    }

    @Override
    public void draw(Window window) {
        int[] coordinate = getCoordinate();
        setWidth(window.charWidth(character));
        setHeight(window.charHeight(character));
        window.drawCharacter(character, coordinate[0], coordinate[1]);
    }
}
