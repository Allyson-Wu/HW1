package glyph;
import java.awt.Point;
import javax.naming.OperationNotSupportedException;
import window.Window;


// Composition 類別是一個更高層次的複合元素，具有複雜的排版邏輯，並提供了方法來插入子元素、設定子元素的父元素、尋找根元素、
// 取得和設定 compositor 以及在指定的視窗上繪製元素等功能。
public abstract class Composition extends CompositeGlyph {
    
    private Compositor compositor;  // 用來儲存一個 Compositor 物件，可能是用來定義複合元素的排版邏輯。
    public abstract Point moveCursor(Point cursor, Glyph child);  // 抽象方法，子類別需實作，可能用來移動游標的位置。

    // 重寫 CompositeGlyph 中的 insert 方法，並在插入後設定子元素的父元素為 this，然後呼叫 findroot 方法。
    public void insert(Glyph glyph, int position) throws OperationNotSupportedException, IndexOutOfBoundsException {
        super.insert(glyph, position);
        glyph.setParent(this);
        findroot();
        //System.out.println("Composition.java insert");
    }

    // 尋找根元素的方法。從當前元素開始遞歸向上查找，直到找到根元素（沒有父元素），然後呼叫根元素的 compose 方法。
    public void findroot() {  
        boolean found = false;
        Glyph current = this;
        while(!found) {
            if (current.getParent() != null) {
                current = current.getParent();
            }
            else {
                current.compose();
                found = true;
            }
        }
    }

    // 取得 compositor 的方法。
    public Compositor getCompositor() {  
		return compositor;
	}
    
    // 設定 compositor 的方法。
    public void setCompositor(Compositor compositor) {  
        this.compositor = compositor;
    }
    
    // 重寫 CompositeGlyph 中的 draw 方法，呼叫 super.draw(window)。
    public void draw(Window window) {  
        super.draw(window);
    }

    // 實作了 CompositeGlyph 中的 compose 方法，呼叫 compositor.compose()。
    public void compose() {  
        compositor.compose();
    }

    // 抽象方法，子類別需實作，可能用來設定調整後的邊界框。
    public abstract void setAdjustedBounds(Point cursor);  

}