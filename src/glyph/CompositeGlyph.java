package glyph;

import java.util.ArrayList;

import javax.naming.OperationNotSupportedException;

public class CompositeGlyph extends Glyph {

    private ArrayList<Glyph> children = new ArrayList<>();
    
    @Override
    public void insert(Glyph glyph, int position)/* throws OperationNotSupportedException, IndexOutOfBoundsException*/{

        // while(position > children.size()) { // fill missing spots with "null"
        //     children.add(children.size(), null);
        // }
        // glyph.setParent(this);
		// children.add(position, glyph);
    }
    
    @Override 
    public void draw(Window window){
        for(int i = 0; i < children.size(); i++) {
            if(children.get(i) != null) {
                children.get(i).draw(window);
            }
        }
    }
}
