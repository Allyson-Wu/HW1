package glyph;
import java.awt.Point;
import window.Window;

//import javax.naming.OperationNotSupportedException;

public abstract class Glyph {  //Glyph 類別提供了基本的 Glyph 功能，包括定義邊界框、父元素的管理以及在視窗上繪製的抽象方法。
    // 其他具體的 Glyph 類別可能會繼承自這個基類，並實作相應的繪製邏輯。

    private Glyph parent;
    private Bounds bounds = new Bounds(new Point(0,0), 0 ,0);  //upperLeft(x,y), width, height

    public void setParent(Glyph glyph) {  //取得該 Glyph 的父元素。
        this.parent = glyph;
        //System.out.println("Glyph.java setParent---------\n");
    }

    public Glyph getParent() {
        return parent;
    }

    public abstract void draw(Window window);  //抽象方法，子類別需實作以在指定的 Window 上繪製該 Glyph。
    public Bounds getBounds() {  //取得該 Glyph 的邊界框。
        return bounds;
    }

    public void compose() {

    }

    public abstract void setSize(Window window);  //抽象方法，子類別需實作以設定該 Glyph 在指定 Window 上的大小。
}