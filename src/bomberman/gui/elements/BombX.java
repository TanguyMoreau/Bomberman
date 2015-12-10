package bomberman.gui.elements;

import bomberman.gui.elements.geometry.GeometryX;
import java.awt.Image;

/**
 *
 * @author ldebril
 */
public class BombX extends EntityX {

    /**
     * @param body
     * @param img
     */
    public BombX(GeometryX body, Image img) {
        super(body);
        this.img = img;
    }
}
