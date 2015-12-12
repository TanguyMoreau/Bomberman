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

    private int countdown;
    private boolean burst;

    public Explosion(Board board, Geometry body) {
        super(board, body);
        this.countdown=board.getTimeStep()*2;
        this.burst=false;
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
        this.burst=true;
    }

    public ExplosionLite getExplosionLite() {
        return new ExplosionLite(this.getBody().getGeometryLite());
    }

    public void tick() {
        this.countdown--;

    }

    public int getCountdown() {
        return countdown;
    }

    public void setCountdown(int countdown) {
        this.countdown = countdown;
    }

    public boolean isBurst() {
        return burst;
    }

    public void setBurst(boolean burst) {
        this.burst = burst;
    }
}
