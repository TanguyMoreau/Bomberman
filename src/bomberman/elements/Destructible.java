/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman.elements;

import bomberman.Board;
import bomberman.elements.geometry.Geometry;

/**
 *
 * @author grochette
 */
public abstract class Destructible extends Entity {

    private int healthPoints;
    private boolean dead;

    public Destructible(Board board, Geometry body, int healthPoints) {
        super(board, body);
        this.healthPoints = healthPoints;
        this.dead=false;
    }

    public void loseHealth() {
        this.healthPoints--;
        if (this.healthPoints == 0) {
            this.dead=true;
        }
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }
    
    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    @Override
    public String toString() {
        return super.toString() + " healthPoints=" + healthPoints;
    }

}
