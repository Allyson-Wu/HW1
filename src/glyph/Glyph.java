package glyph;

abstract class Glyph {

    private Glyph parent;

    // 繪製Glyph在窗口上
    public void draw(Window window){};

    // 獲取Glyph的邊界
    //abstract void getBounds(Rect rect);

    // 檢查點是否與Glyph相交
    //public abstract boolean intersects(Point point);

    // 將子Glyph插入到特定位置
    public void insert(Glyph glyph, int index){};

    // 從Glyph中刪除指定的子Glyph
    public void remove(int index){};

    // 獲取Glyph的特定子Glyph
    //abstract Glyph getChild(int index);

    // 獲取Glyph的父Glyph
    public Glyph getParent() {
        return parent;
    }

    public void setParent(Glyph glyph) {
        this.parent = glyph;
    }

    abstract int getWidth();
    abstract int getHeight();

    public void setCoordinate(int x, int y) {}

    public void compose() {
        throw new UnsupportedOperationException("Unimplemented method 'compose'");
    }

}