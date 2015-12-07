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

/**
 *
 * @author grochette
 */
public class Bomber extends Destructible{

        private int plantedBombs;

        /*bonuses */
        private int maxBombs;
        private double blastRadius;
        private double speed;

        public Bomber(Board board, Geometry body, int healthPoints){
                super(board, body, healthPoints);
                this.maxBombs = 1;
                this.plantedBombs = 0;
                this.blastRadius = 100;
                this.speed = 1;
        }

        public int getMaxBombs(){
                return maxBombs;
        }

        public void setMaxBombs(int maxBombs){
                this.maxBombs = maxBombs;
        }

        public int getPlantedBombs(){
                return plantedBombs;
        }

        public void setPlantedBombs(int plantedBombs){
                this.plantedBombs = plantedBombs;
        }

        public double getBlastRadius(){
                return blastRadius;
        }

        public void setBlastRadius(double blastRadius){
                this.blastRadius = blastRadius;
        }

        public double getSpeed(){
                return speed;
        }

        public void setSpeed(double speed){
                this.speed = speed;
        }

        public void plantBomb(){
                if(getPlantedBombs() < getMaxBombs()){
                        this.plantedBombs = this.plantedBombs + 1;
                        Bomb aBomb = new Bomb(this.getBoard(), this);
                        this.getBoard().getBombs().add(aBomb);
                }
        }

        public void move(Coordinates vector){
                this.getBody().updatePosition(vector);
                ArrayList<Entity> blockingBodies = findBlockingBodies();
                if(!blockingBodies.isEmpty()){
                        Geometry centerOfMass = new Geometry(blockingBodies);
                        this.getBody().repel(centerOfMass);
                        if(this.getBody().collideWith(centerOfMass)){
                                this.getBody().setPosition(this.getBody().getOldPosition());
                                this.move(new Coordinates(vector.getX() / 2, vector.getY() / 2));
                        }
                }

        }

        private ArrayList<Entity> findBlockingBodies(){
                Geometry bomberBody = this.getBody();
                ArrayList<Entity> blockingBodies = new ArrayList<>();
                for(Wall aWall : this.getBoard().getWalls()){
                        if(bomberBody.collideWith(aWall.getBody())){
                                blockingBodies.add(aWall);
                        }
                }
                for(Brick aBrick : this.getBoard().getBricks()){
                        if(bomberBody.collideWith(aBrick.getBody())){
                                blockingBodies.add(aBrick);
                        }
                }
                for(Bomber aBomber : this.getBoard().getBombers()){
                        if(!this.equals(aBomber)){
                                if(bomberBody.collideWith(aBomber.getBody())){
                                        blockingBodies.add(aBomber);
                                }
                        }
                }
                for(Bomb aBomb : this.getBoard().getBombs()){
                        if(bomberBody.collideWith(aBomb.getBody())){
                                blockingBodies.add(aBomb);
                        }
                }
                return blockingBodies;
        }

        @Override
        public void die(){
                this.getBoard().getBombers().remove(this);
        }

        @Override
        public String toString(){
                return "Bomber{" + getBody() + "plantedBombs=" + plantedBombs + ", maxBombs=" + maxBombs + ", blastRadius=" + blastRadius + ", speed=" + speed + '}';
        }
        
        public BomberLite getBomberLite(){
                return new BomberLite(this.getBody().getGeometryLite(), this.getHealthPoints());
        }
        
        public void act(Action action){
                this.move(action.getCoordinates());
                if(action.isDropTheBomb()){
                        this.plantBomb();
                }
                
        }
}
