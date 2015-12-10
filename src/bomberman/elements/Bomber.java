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
public class Bomber extends Destructible{
        private int plantedBombs;

        /*bonuses */
        private int maxBombs;
        private double blastRadius;
        private double speed;

        public Bomber(Board board, Geometry body, int healthPoints){
                super(board, body, healthPoints);
                this.maxBombs = 3;
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
                        Coordinates c = new Coordinates(this.getBody().getPosition().getX() -2*this.getBody().getDirection().getX(), this.getBody().getPosition().getY() -2*this.getBody().getDirection().getY());
                        Geometry oldBody = new Geometry(c, this.getBody().getRadius());
                        Bomb aBomb = new Bomb(this.getBoard(), this, oldBody);
                        this.getBoard().getBombs().add(aBomb);
                        System.out.println(this);
                        System.out.println(this.getBoard().getBombs());
                }
        }

        public void move(Coordinates vector){
                this.getBody().updatePosition(vector);
                ArrayList<Entity> blockingBodies = findBlockingBodies();
//            System.out.println(blockingBodies);
                if(!blockingBodies.isEmpty()){
                        Geometry centerOfMass = new Geometry(blockingBodies);
                        this.getBody().repel(centerOfMass);
                        if(this.getBody().collideWith(centerOfMass)){
                                //System.out.println("!");
                                //this.getBody().setPosition(this.getBody().getOldPosition());
                                this.move(new Coordinates(-vector.getX() / 8.0, -vector.getY() / 8.0));
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
                return super.toString()+ " plantedBombs=" + plantedBombs + ", maxBombs=" + maxBombs ;
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
        
        public void giveBackBomb(){
                if(this.plantedBombs>0){
                        this.plantedBombs--;
                }
        }
}
