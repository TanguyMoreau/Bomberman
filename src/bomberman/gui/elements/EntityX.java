package bomberman.gui.elements;

import bomberman.gui.elements.geometry.GeometryX;
import java.awt.*;

/**
 *
 * @author ldebril
 */
public abstract class EntityX extends Component {

    protected GeometryX body;

    public EntityX(GeometryX body) {
        this.body = body;
    }

    public GeometryX getBody() {
        return body;
    }

    public void setBody(GeometryX body) {
        this.body = body;
    }

    public abstract void paint(Graphics g);

    /* (non-Javadoc)
     * @see java.awt.Component#toString()
     */
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return ("x = " + body.getPosition().getX() + " y = " + body.getPosition().getY());
    }
}
