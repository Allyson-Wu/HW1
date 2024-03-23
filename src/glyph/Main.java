package glyph;

public class Main {
    public static void main(String[] args) throws Exception {
        
        Window window = new SwingWindow("Lexi Editor");
        Glyph cGlyph = new Character('a');
        //Glyph rGlyph = new Rectangle(20,20);
        window.setContents(cGlyph);
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