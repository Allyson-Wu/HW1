package glyph;

public class Character extends Glyph {

    private char character;

    public Character(char character) {
        this.character = character;
    }
    
    @Override
    public void draw(Window window) {
        window.drawCharacter(character, 0, 0); // 假設所有字符都在(0,0)處繪製
    }
}
