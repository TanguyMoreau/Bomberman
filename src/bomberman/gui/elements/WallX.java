package bomberman.gui.elements;

import bomberman.gui.elements.geometry.GeometryX;
import java.awt.Image;

import javax.swing.ImageIcon;

/**
 *
 * @author ldebril
 */
public class WallX extends EntityX {

    /**
     * @param body
     * @param img
     */
    public WallX(GeometryX body, Image img) {
        super(body);
        this.img = img;
    }
}
