package bomberman.gui.elements;

import bomberman.gui.elements.geometry.GeometryX;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author ldebril
 */
public class BombX extends EntityX {

    private static Image img = new ImageIcon("resources/BombImg.png").getImage();

    public BombX(GeometryX body) {
        super(body);
    }

    @Override
    public void paint(Graphics g) {
        //super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(img, (int) Math.round(body.getPosition().getX()-body.getRadius()), (int) Math.round(body.getPosition().getY()-body.getRadius()), this);
        g2.finalize();
    }

}
