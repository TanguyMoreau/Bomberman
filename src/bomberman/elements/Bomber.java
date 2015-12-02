/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman.elements;

import bomberman.Board;
import bomberman.elements.geometry.Coordinates;
import bomberman.elements.geometry.Geometry;
import java.util.ArrayList;
import java.util.Objects;
import jdk.nashorn.internal.codegen.CompilerConstants;

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
                        Bomb aBomb = new Bomb(board, this);
                        board.getBombs().add(aBomb);
                }
        }

        public void move(Coordinates vector){
                this.body.updatePosition(vector);
                ArrayList<Entity> blockingBodies = findBlockingBodies();
                if(!blockingBodies.isEmpty()){
                        Geometry centerOfMass = new Geometry(blockingBodies);
                        this.body.repel(centerOfMass);
                        if(this.body.collideWith(centerOfMass)){
                                this.body.setPosition(this.body.getOldPosition());
                                this.move(new Coordinates(-vector.getX() / 2, -vector.getY() / 2));
                        }
                }

        }

        private ArrayList<Entity> findBlockingBodies(){
                Geometry bomberBody = this.getBody();
                ArrayList<Entity> blockingBodies = new ArrayList<>();
                for(Wall aWall : board.getWalls()){
                        if(bomberBody.collideWith(aWall.getBody())){
                                blockingBodies.add(aWall);
                        }
                }
                for(Brick aBrick : board.getBricks()){
                        if(bomberBody.collideWith(aBrick.getBody())){
                                blockingBodies.add(aBrick);
                        }
                }
                for(Bomber aBomber : board.getBombers()){
                        if(!this.equals(aBomber)){
                                if(bomberBody.collideWith(aBomber.getBody())){
                                        blockingBodies.add(aBomber);
                                }
                        }
                }
                for(Bomb aBomb : board.getBombs()){
                        if(bomberBody.collideWith(aBomb.getBody())){
                                blockingBodies.add(aBomb);
                        }
                }
                return blockingBodies;
        }

        @Override
        public String toString(){
                return "Bomber{" + getBody() + "plantedBombs=" + plantedBombs + ", maxBombs=" + maxBombs + ", blastRadius=" + blastRadius + ", speed=" + speed + '}';
        }

}
