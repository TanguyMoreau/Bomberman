package bomberman.gui.elements;

import bomberman.gui.elements.geometry.GeometryX;
import java.awt.Image;

import javax.swing.ImageIcon;

/**
 *
 * @author ldebril
 */
public class BrickX extends EntityX {

    public BrickX(GeometryX body, Image img) {
        super(body);
        this.img = img;
    }
}
