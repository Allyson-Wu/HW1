package glyph;

import window.Window;
import java.awt.Point;
import javax.naming.OperationNotSupportedException;

public class SimpleCompositor implements Compositor {

    private Window window;
    private Composition composition;

    // 實作了 Compositor 介面中的方法，用來設定要進行排版的 Composition 物件。
    public void setComposition(Composition composition) {
        this.composition = composition;
    }

    // 實作了 Compositor 介面中的方法，用來執行排版的邏輯。它使用一個游標（cursor）來遍歷元素，計算每個元素的大小、位置，並移動游標。
    // 在遍歷過程中，也調用了 composition.setAdjustedBounds(cursor) 和 composition.setSize(window) 方法，以便調整元素的邊界框和大小。
    public void compose() {

        // create cursor based on parent
        Point cursor = composition.getBounds().point();
        Glyph child = null;
        Glyph startingPoint = null;
        int position = 0;

        boolean out = false;
        while(!out) {
            try {
                if(composition.child(position) != null) {
                    child = composition.child(position);
                    if (startingPoint == null) {
                        startingPoint = child;
                    }
                    child.setSize(window); 
                    
                    Bounds bounds = child.getBounds();
                    Point point = bounds.point();
                    point.setLocation(cursor.x, cursor.y); 
                    composition.child(position).compose();
                    cursor = composition.moveCursor(cursor, child);
                }
                composition.setAdjustedBounds(cursor);
                composition.setSize(window);

            }
            catch (OperationNotSupportedException exception) {
                System.out.println("OperationNotSupportedException caught: " + exception.getMessage());
            }
            catch (IndexOutOfBoundsException exception) {
                out = true;
                //System.out.println("IndexOutOfBoundsException caught: " + exception.getMessage());
            }
            position++;
        }
        // ask parent to adjust itself, based on cursor
        if (startingPoint != null) {
            composition.getBounds().point().setLocation(startingPoint.getBounds().point());
        }

    }

    // 建構子，接收一個 Window 作為參數，用來初始化 window 成員變數。
    public SimpleCompositor(Window window) {
        this.window = window;
        //System.out.println("SimpleCompositor.java constructor");
    }
}