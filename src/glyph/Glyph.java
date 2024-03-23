package glyph;

import org.w3c.dom.css.Rect;

abstract class Glyph {

    // 繪製Glyph在窗口上
    abstract void draw(Window window);

    // 獲取Glyph的邊界
    //abstract void getBounds(Rect rect);

    // 檢查點是否與Glyph相交
    //public abstract boolean intersects(Point point);

    // 將子Glyph插入到特定位置
    void insert(Glyph glyph, int index){}

    // 從Glyph中刪除指定的子Glyph
    void remove(Glyph glyph){}

    // 獲取Glyph的特定子Glyph
    //abstract Glyph getChild(int index);

    // 獲取Glyph的父Glyph
    //abstract Glyph getParent();
    
}

// textbook provided:
// abstract class Glyph {
//     void draw(Window window);
//     void bounds(Rect rect);
//     boolean intersects(Point point);
//     void insert(Glyph glyph, int index);
//     void remove(Glyph glyph);
//     Glyph child(int index);
//     Glyph parent();
// }