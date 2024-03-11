package glyph;
import window.Window;

import java.awt.Point;

// Rectangle 類別是一個具體實現的 Glyph，代表了一個矩形。
// 在矩形建立時，其大小會在建構子中被指定，而在 draw 方法中，它將利用 Window 介面提供的方法在指定的視窗上繪製矩形。
public class Rectangle extends Glyph {  // 實作了 Glyph 抽象類別的一個具體類別，代表一個矩形。

    public void setSize(Window window) {  // 實作了抽象方法，但內容是空的。因為矩形的大小在建構子中已經設定，不需要特別調整。
 
    }

    public void draw(Window window) {
        // 實作了抽象方法，用來在指定的 Window 上繪製矩形。
        // 取得矩形的座標和大小，然後調用 window.drawRectangle 方法進行實際繪製。
        
        int x = getBounds().point().x;
        int y = getBounds().point().y;
        int w = getBounds().width();
        int h = getBounds().height();

        window.drawRectangle(x, y, w, h);
        //System.out.println("Rectangle.java draw");
    }

    public Rectangle(int w, int h) {  // 建構子，接收矩形的寬度和高度作為參數。
        // 在建構過程中，設定父元素為 null，並初始化邊界框的左上角座標為 (0, 0)，寬度和高度分別為傳入的參數。

        setParent(null);
		getBounds().point().setLocation(new Point(0,0));
        getBounds().setArea(w, h);
        //System.out.println("Rectangle.java constructor");
    }

}