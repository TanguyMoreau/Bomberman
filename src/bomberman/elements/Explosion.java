/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman.elements;

import bomberman.Board;
import bomberman.elements.geometry.Geometry;
import bomberman.elements.lite.ExplosionLite;
import java.util.Iterator;

/**
 *
 * @author grochette
 */
public class Explosion extends Indestructible {

    public Explosion(Board board, Geometry body) {
        super(board, body);
    }

    public void destroy() {
        for (Iterator<Bomber> i = this.getBoard().getBombers().iterator(); i.hasNext();) {
            Bomber aBomber = i.next();
            if (this.getBody().isInBall(aBomber.getBody())) {
                aBomber.loseHealth();
            }
        }
        for (Iterator<Brick> i = this.getBoard().getBricks().iterator(); i.hasNext();) {
            Brick aBrick = i.next();
            if (this.getBody().isInBall(aBrick.getBody())) {
                aBrick.loseHealth();
            }
        }
    }

    public ExplosionLite getExplosionLite() {
        return new ExplosionLite(this.getBody().getGeometryLite());
    }

}
