package glyph;

public class Main {
    public static void main(String[] args) throws Exception {
        
        Window window = new SwingWindow("Lexi Editor");
        Composition cGlyph = new Row(window);
        Glyph Rct1 = new Rectangle(10, 20);
        Glyph Rct2 = new Rectangle(5, 20);
        Glyph Rct3 = new Rectangle(10, 10);
        cGlyph.insert(Rct1, 0);
        cGlyph.insert(Rct2, 1);
        cGlyph.insert(Rct3, 2);

        window.setContents(cGlyph);

        //Glyph rGlyph = new Rectangle(20,20);
        //window.setContents(rGlyph);

    }
}


// public class Main2 {
//     public static void main(String[] args) {
//         // 初始化 Glyph 物件和文檔結構
//         Glyph document = new Column();
//         Glyph row1 = new Row();
//         Glyph row2 = new Row();
        
//         // 將字符、矩形等添加到行和列中
//         row1.add(new Character('a'));
//         row1.add(new Rectangle(50, 50));
//         // ...
        
//         document.add(row1);
//         document.add(row2);
        
//         // 設置 Compositor
//         Compositor compositor = new SimpleCompositor();
//         document.setCompositor(compositor);
        
//         // 創建 SwingWindow 並設置其內容
//         Window window = new SwingWindow("Lexi Editor");
//         window.setContents(document);
//     }
// }