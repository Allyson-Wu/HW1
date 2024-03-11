package glyph;

import java.awt.Point;

public class Bounds {  //Bounds 類別是一個用來表示邊界框的簡單類別，提供了取得和設定邊界框相關屬性的方法。

    private Point upperLeft;  // 用來儲存邊界框的左上角座標。
    private int width;        // 用來儲存邊界框的寬度。
    private int height;       // 用來儲存邊界框的高度。

    public Point point() {    // 取得邊界框的左上角座標。
        return upperLeft;
    }

    public int width() {      // 取得邊界框的寬度。
        return width;
    }

    public int height() {     // 取得邊界框的高度。
        return height;
    }

    public void setArea(int width, int height) {  // 設定邊界框的寬度和高度。
        this.width = width;
        this.height = height;
    }   

    public Bounds(Point upperLeft, int width, int height) {  // 建構子，用於初始化邊界框的屬性。
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }
}