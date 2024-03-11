package glyph;

import java.awt.Point;
import window.Window;

// Character 類別是一個具體實現的 Glyph，代表了一個字符。
// 在字符建立時，其值會在建構子中被指定，而在 setSize 和 draw 方法中，它將利用 Window 介面提供的方法進行字符大小的計算和在指定的視窗上的繪製。
public class Character extends Glyph {  // 實作了 Glyph 抽象類別的一個具體類別，代表一個字符。
    
    private char character;  // 用來儲存字符的值。

    public void setSize(Window window) {  // 實作了抽象方法，用來設定字符的大小。
        // 在這裡，利用 Window 提供的方法計算字符的寬度和高度，並設定到 Bounds 物件中。

        int w = window.charWidth(this.character);
        int h = window.charHeight(this.character);

        getBounds().setArea(w, h); 
        //System.out.println("Character.java setSize");
    }

    public void draw(Window window) {  // 實作了抽象方法，用來在指定的 Window 上繪製字符。
        // 取得字符的座標，然後調用 window.drawCharacter 方法進行實際繪製。
        
        int x = getBounds().point().x;
        int y = getBounds().point().y;

        window.drawCharacter(character, x, y);
        //System.out.println("Character.java draw");
    }

    public Character(char character) {  // 建構子，接收一個字符作為參數。
        // 在建構過程中，初始化字符的值，設定父元素為 null，並初始化邊界框的左上角座標為 (0, 0)，寬度和高度則設為 0。
        
        this.character = character;
        setParent(null);
        getBounds().point().setLocation(new Point(0,0));
        getBounds().setArea(0, 0);
        //System.out.println("Character.java constructor");
    }

}