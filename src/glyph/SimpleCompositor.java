package glyph;

import java.util.ArrayList;

public class SimpleCompositor implements Compositor {

    private Window window;
    private Composition composition;
    private ArrayList<Glyph> children;

    public SimpleCompositor(Window window) {
        this.window = window;
    }

    public void setComposition(Composition composition) {
        this.composition = composition;
    }

    public void compose() {
        // if (composition.getParent() != null) {
        //     composition.getParent().compose();
        //     return;
        // }

        children = composition.getchildren();

        for(Glyph child: children) {
            int[] coordinates = composition.getCoordinate();
            child.setCoordinate(coordinates[0], coordinates[1]);
            child.draw(window);
            composition.updateCoordinate(coordinates[0], coordinates[1], child);
        }

    }
}