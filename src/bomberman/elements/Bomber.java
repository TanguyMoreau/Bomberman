/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman.elements;

import bomberman.Board;
import bomberman.elements.geometry.Coordinates;
import bomberman.elements.geometry.Geometry;
import bomberman.elements.lite.BomberLite;
import bomberman.elements.motion.Action;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author grochette
 */
public class Bomber extends Destructible {

    private int plantedBombs;

    /*bonuses */
    private int maxBombs;
    private double blastRadius;
    private double speed;

    public Bomber(Board board, Geometry body, int healthPoints) {
        super(board, body, healthPoints);
        this.maxBombs = 3;
        this.plantedBombs = 0;
        this.blastRadius = 100;
        this.speed = 1;
    }

    public int getMaxBombs() {
        return maxBombs;
    }

    public void setMaxBombs(int maxBombs) {
        this.maxBombs = maxBombs;
    }

    public int getPlantedBombs() {
        return plantedBombs;
    }

    public void setPlantedBombs(int plantedBombs) {
        this.plantedBombs = plantedBombs;
    }

    public double getBlastRadius() {
        return blastRadius;
    }

    public void setBlastRadius(double blastRadius) {
        this.blastRadius = blastRadius;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void plantBomb() {
        if (getPlantedBombs() < getMaxBombs()) {
            this.plantedBombs = this.plantedBombs + 1;
            Bomb aBomb = new Bomb(this.getBoard(), this);
            //resoudre collision de la bombe
            this.getBoard().getBombs().add(aBomb);
        }
    }

    public void move(Coordinates vector) {
        //Geometry somebody=this.getBody();
        this.getBody().updatePosition(vector);
        this.getBody().correctPosition(this.getBoard());

    }


    @Override
    public String toString() {
        return super.toString() + " plantedBombs=" + plantedBombs + ", maxBombs=" + maxBombs;
    }

    public BomberLite getBomberLite() {
        return new BomberLite(this.getBody().getGeometryLite(), this.getHealthPoints());
    }

    public void act(Action action) {
        this.move(action.getCoordinates());
        if (action.isDropTheBomb()) {
            this.plantBomb();
        }
    }

    public void giveBackBomb() {
        if (this.plantedBombs > 0) {
            this.plantedBombs--;
        }
    }
}
