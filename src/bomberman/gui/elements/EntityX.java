package bomberman.gui.elements;

import bomberman.gui.elements.geometry.GeometryX;
import java.awt.*;

/**
 *
 * @author ldebril
 */
public abstract class EntityX extends Component{

        protected GeometryX body;
        protected Image img;

        /**
         * @param body
         */
        public EntityX(GeometryX body){
                this.body = body;
        }

        public GeometryX getBody(){
                return body;
        }

        public void setBody(GeometryX body){
                this.body = body;
        }

        public void paint(Graphics g){
                // TODO Auto-generated method stub
                super.paint(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.drawImage(img, (int) Math.round(body.getPosition().getX()), (int) Math.round(body.getPosition().getY()), this);
                g2.finalize();
        }

        /* (non-Javadoc)
         * @see java.awt.Component#toString()
         */
        @Override
        public String toString(){
                // TODO Auto-generated method stub
                return ("x = " + body.getPosition().getX() + " y = " + body.getPosition().getY());
        }

        public Image getImg(){
                return img;
        }

        public void setImg(Image img){
                this.img = img;
        }
}
