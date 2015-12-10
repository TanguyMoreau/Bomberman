package bomberman.gui.elements;

import bomberman.elements.geometry.Coordinates;
import bomberman.gui.elements.geometry.GeometryX;
import java.awt.Image;

/**
 *
 * @author ldebril
 */
public class BomberX extends EntityX{

        private Coordinates coordinates;

        /**
         * @param body
         * @param img
         */
        public BomberX(GeometryX body, Image img){
                super(body);
                this.img = img;
        }
}
