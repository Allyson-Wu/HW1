package glyph;

import java.awt.Point;
import window.Window;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;

public class Row extends Composition {  // 實作了 Composition 抽象類別，代表了一個水平的行元素。

    // 設定行元素的位置。
    public void setPosition(int x, int y) {  
        getBounds().point().setLocation(x, y);
    }

    // 實作了 Composition 中的抽象方法，用來設定調整後的邊界框。
    public void setAdjustedBounds(Point cursor) {  
        getBounds().setArea(cursor.x - getBounds().point().x, getBounds().height());
    }

    // 實作了 Composition 中的抽象方法，用來設定行元素的大小。計算行元素的寬度和高度，寬度為所有子元素寬度的總和，高度取所有子元素中最高的。
    public void setSize(Window window) {
        int width = 0;
        int height = 0;
    
        for (Glyph child : super.getChildren()) {
            width += child.getBounds().width();
            height = Math.max(height, child.getBounds().height());
        }
    
        getBounds().setArea(width, height);
    }

    // 實作了 Composition 中的方法，用來取得指定位置的子元素。
    public Glyph child(int position) throws OperationNotSupportedException, IndexOutOfBoundsException {
        return super.child(position);
    }

    // 實作了 Composition 中的抽象方法，用來移動游標的位置。
    public Point moveCursor(Point cursor, Glyph child) {
        int newX = child.getBounds().point().x + child.getBounds().width();
        cursor.x = newX;
        return cursor;
    }

    // 重寫了 Composition 中的 draw 方法，呼叫 super.draw(window)。
    public void draw(Window window) {
        super.draw(window);
    }

    // 建構子，接收一個 Compositor 作為參數。在建構過程中，設定父元素為 null，初始化邊界框的寬度和高度為 0，位置為 (0,0)，
    // 初始化子元素列表為空的 ArrayList，設定 compositor 並呼叫 compositor.setComposition(this)。
    public Row(Compositor compositor) {
        setParent(null);
        getBounds().setArea(0,0);
        Point point = new Point(0,0);
        getBounds().point().setLocation(point);
        setChildren(new ArrayList<Glyph>());
        setCompositor(compositor);
        getCompositor().setComposition(this);
        //System.out.println("Row.java constructor");
    }

}