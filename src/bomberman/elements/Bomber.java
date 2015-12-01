/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman.elements;

import bomberman.Board;
import bomberman.elements.geometry.Coordinates;
import bomberman.elements.geometry.Geometry;
import bomberman.elements.properties.Properties;
import java.util.ArrayList;
import java.util.Objects;

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

        public Bomber(Board board,Geometry body, int healthPoints){
                super(board,body, healthPoints);
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
                this.getBody().getPosition().add(vector);
                ArrayList<Entity> blockingBodies=findBlockingBodies();
                if(blockingBodies.size()>0){
                        Geometry centerOfMass= new Geometry(blockingBodies);
                        Wall center=new Wall(board, centerOfMass);
                        this.getBody().getPosition().add(this.repelVector(center));                
                }
        }
        
        private Coordinates repelVector(Entity center){
                double xBomber=this.getBody().getPosition().getX(),yBomber=this.getBody().getPosition().getY();
                double xBlock=center.getBody().getPosition().getX(),yBlock=center.getBody().getPosition().getY();
                double repelDistance=this.getBody().getRadius()+center.getBody().getRadius()-Geometry.distanceInfinity(this.getBody().getPosition(), center.getBody().getPosition());
                return new Coordinates(repelDistance*(xBomber-xBlock), repelDistance*(yBomber-yBlock));
        }
        
        private ArrayList<Entity> findBlockingBodies(){
                Geometry bomberBody=this.getBody();
                ArrayList<Entity> blockingBodies=new ArrayList<>();
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

//        @Override
//        public int hashCode(){
//                int hash = 5+41*super.hashCode();
//                hash = 41 * hash + this.plantedBombs;
//                hash = 41 * hash + this.maxBombs;
//                hash = 41 * hash + (int) (Double.doubleToLongBits(this.blastRadius) ^ (Double.doubleToLongBits(this.blastRadius) >>> 32));
//                hash = 41 * hash + (int) (Double.doubleToLongBits(this.speed) ^ (Double.doubleToLongBits(this.speed) >>> 32));
//                return hash;
//        }
//
//        @Override
//        public boolean equals(Object obj){
//                if(obj == null){
//                        return false;
//                }
//                if(getClass() != obj.getClass()){
//                        return false;
//                }
//                if(!super.equals(obj)){
//                        return false;
//                }
//                final Bomber other = (Bomber) obj;
//                if(this.plantedBombs != other.plantedBombs){
//                        return false;
//                }
//                if(this.maxBombs != other.maxBombs){
//                        return false;
//                }
//                if(Double.doubleToLongBits(this.blastRadius) != Double.doubleToLongBits(other.blastRadius)){
//                        return false;
//                }
//                if(Double.doubleToLongBits(this.speed) != Double.doubleToLongBits(other.speed)){
//                        return false;
//                }
//                return true;
//        }

        @Override
        public String toString(){
                return "Bomber{"+getBody() + "plantedBombs=" + plantedBombs + ", maxBombs=" + maxBombs + ", blastRadius=" + blastRadius + ", speed=" + speed + '}';
        }

 
}
