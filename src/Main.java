import window.*;
import glyph.*;
import javax.naming.OperationNotSupportedException;
import glyph.Character;

public class Main {
    public static void main(String[] args) {
        drawLexi();
    }

    public static void drawLexi() {
        
        // create objects
        Window sw = new SwingWindow("Lexi");
        SimpleCompositor col1_sc = new SimpleCompositor(sw);
        SimpleCompositor row1_sc = new SimpleCompositor(sw);
        SimpleCompositor row2_sc = new SimpleCompositor(sw);
        SimpleCompositor row3_sc = new SimpleCompositor(sw);
        SimpleCompositor row4_sc = new SimpleCompositor(sw);
        SimpleCompositor row5_sc = new SimpleCompositor(sw);
        Column col1 = new Column(col1_sc);
        Row row1 = new Row(row1_sc);
        Row row2 = new Row(row2_sc);
        Row row3 = new Row(row3_sc);
        Row row4 = new Row(row4_sc);
        Row row5 = new Row(row5_sc);
        Glyph X1 = new Character('X');
        Glyph X2 = new Character('X');
        Glyph X3 = new Character('X');
        Glyph X4 = new Character('X');
        Glyph X5 = new Character('X');
        Glyph O1 = new Character('O');
        Glyph O2 = new Character('O');
        Glyph O3 = new Character('O');
        Glyph O4 = new Character('O');
        Glyph rect1 = new Rectangle(2, 14);
        Glyph rect2 = new Rectangle(2, 14);
        Glyph rect3 = new Rectangle(30, 2);
        Glyph rect4 = new Rectangle(2, 14);
        Glyph rect5 = new Rectangle(2, 14);
        Glyph rect6 = new Rectangle(30, 2);
        Glyph rect7 = new Rectangle(2, 14);
        Glyph rect8 = new Rectangle(2, 14);

        // compose objects
        try {
            col1.insert(row1, 0);
            row1.insert(X1, 0);
            row1.insert(rect1, 1);
            row1.insert(X2, 2);
            row1.insert(rect2, 3);
            row1.insert(O1, 4);

            col1.insert(row2, 0);
            row2.insert(rect3,0);

            col1.insert(row3, 0);
            row3.insert(X3, 0);
            row3.insert(rect4, 1);
            row3.insert(O2, 2);
            row3.insert(rect5, 3);
            row3.insert(X4, 4);

            col1.insert(row4, 0);
            row4.insert(rect6,0);

            col1.insert(row5, 0);
            row5.insert(O3, 0);
            row5.insert(rect7, 1);
            row5.insert(X5, 2);
            row5.insert(rect8, 3);
            row5.insert(O4, 4);
        }
        catch (OperationNotSupportedException exception) {
            System.out.println("OperationNotSupportedException caught: " + exception.getMessage());
        }
        sw.setContents(col1);
    }
}