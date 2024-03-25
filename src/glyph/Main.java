package glyph;

public class Main {
    public static void main(String[] args) throws Exception {
        
        Window window = new SwingWindow("Lexi Editor");
        Glyph Row1 = new Row(window);
        Glyph Rct1 = new Rectangle(50, 40);
        Glyph Rct2 = new Rectangle(30, 20);
        Glyph Char1 = new Character('x');

        Row1.insert(Rct1, 0);
        Row1.insert(Char1, 1);
        Row1.insert(Rct2, 2);
    
        // window.setContents(Row1);

        // Row1.remove(0);
        // window.setContents(Row1);

        Glyph Col1 = new Column(window);
        Col1.insert(Rct1, 0);
        Col1.insert(Char1, 1);
        Col1.insert(Rct2, 2);

        Col1.insert(Row1, 3);

        window.setContents(Col1);



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