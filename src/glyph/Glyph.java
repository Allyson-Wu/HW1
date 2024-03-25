package glyph;

abstract class Glyph {

    private int width;
    private int height;
    private int x, y;
    private Glyph parent;

    // 繪製Glyph在窗口上
    public void draw(Window window){};

    // 將子Glyph插入到特定位置
    public void insert(Glyph glyph, int index){};

    // 從Glyph中刪除指定的子Glyph
    public void remove(int index){};

    // 獲取Glyph的父Glyph
    public Glyph getParent() {
        return parent;
    }

    public void setParent(Glyph glyph) {
        this.parent = glyph;
    }

    public void setWidth(int w) {
        width = w;
    }

    public void setHeight(int h) {
        height = h;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setCoordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int[] getCoordinate() {
        int[] coordinate = {x, y};
        return coordinate;
    }

    public void compose() {
        throw new UnsupportedOperationException("Unimplemented method 'compose'");
    }

}