package glyph;
import java.util.ArrayList;
import javax.naming.OperationNotSupportedException;
import window.Window;

// 實作了 Glyph 抽象類別，代表一個複合元素，即包含子元素的元素。
public abstract class CompositeGlyph extends Glyph {  
    
    // 用來儲存子元素的列表。
    private ArrayList<Glyph> children;  

    // 插入一個子元素到指定的位置。
	public void insert(Glyph glyph, int position) throws OperationNotSupportedException, IndexOutOfBoundsException {
        //在插入前，檢查位置是否超出列表範圍，如果超出，則將中間的位置補充為 null。
        while(position > children.size()) { // fill missing spots with "null"
            children.add(children.size(), null);
        }
		children.add(position, glyph);
        //System.out.println("CompositeGlyph.java insert");
	}

    // 取得子元素列表。
	public ArrayList<Glyph> getChildren() {  
		return children;
	}

    // 設定子元素列表。
	public void setChildren(ArrayList<Glyph> children) {  
		this.children = children;
	}

	public Glyph child(int position) throws OperationNotSupportedException, IndexOutOfBoundsException {
        // 取得指定位置的子元素。如果位置不存在，則拋出 IndexOutOfBoundsException。
       
        if(position >= children.size() || position < 0) {
            throw new IndexOutOfBoundsException("IndexOutOfBoundsException caught: There's no child");
        }
        return children.get(position);
    }

    // 實作了 Glyph 中的抽象方法，用來在指定的 Window 上繪製複合元素。
    public void draw(Window window) {  
        // 遍歷子元素列表，對每個非空的子元素調用其 draw 方法。
        for(int i = 0; i < children.size(); i++) {
            if(children.get(i) != null) {
                children.get(i).draw(window);
            }
        }
    }
}