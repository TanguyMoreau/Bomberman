/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman.elements.geometry;

import bomberman.elements.Entity;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author grochette
 */
public class Geometry{

        private Coordinates position;
        private double radius;
        private Coordinates oldPosition;
        private Coordinates direction;

        public Coordinates getPosition(){
                return position;
        }

        public void setPosition(Coordinates position){
                this.position = position;
        }

        public double getRadius(){
                return radius;
        }

        public void setRadius(double radius){
                this.radius = radius;
        }

        public Coordinates getOldPosition(){
                return oldPosition;
        }

        public void setOldPosition(Coordinates oldPosition){
                this.oldPosition = oldPosition;
        }

        public Coordinates getDirection(){
                return direction;
        }

        public void setDirection(Coordinates direction){
                this.direction = direction;
        }

        public Geometry(){
                this.position = new Coordinates();
                this.radius = 0;
//                this.oldPosition = new Coordinates();
//                updateDirection();
        }

        public Geometry(double x, double y, double radius){
                this.position = new Coordinates(x, y);
                this.oldPosition = this.position;
//                this.radius=radius;
//                updateDirection();
        }

        public Geometry(Coordinates position, double radius){
                this.position = position;
                this.radius = radius;
//                this.oldPosition = position;
//                updateDirection();
        }

        public Geometry(ArrayList<Entity> blockingBodies){
                this.position = new Coordinates(blockingBodies);
                double r = 0;
                for(Entity e : blockingBodies){
                        if(e.getBody().getRadius() > r){
                                r = e.getBody().getRadius();
                        }
                }
                this.radius = r;
//                this.oldPosition=this.position;
//                updateDirection();
        }

        public static double distanceInfinity(Coordinates a, Coordinates b){
                return Math.max(Math.abs(a.getX() - b.getX()), Math.abs(a.getY() - b.getY()));
        }

        public boolean isInBall(Geometry g){
                return (distanceInfinity(g.getPosition(), this.position) <= this.radius);
        }

        public boolean collideWith(Geometry g){
                return (distanceInfinity(g.getPosition(), this.position) <= this.radius + g.getRadius());
        }

        public void updatePosition(Coordinates vector){
                this.oldPosition = this.position;
                this.position.add(vector);
        }

        public void updateDirection(){
                double dX = (position.getX() - oldPosition.getX());
                double dY = (position.getX() - oldPosition.getY());
                this.direction = new Coordinates(dX, dY);
        }

        public void repel(Geometry centerOfMass){
                double xBomber = this.getPosition().getX();
                double yBomber = this.getPosition().getY();
                double xBlock = centerOfMass.getPosition().getX();
                double yBlock = centerOfMass.getPosition().getY();
                double repelDistance = this.getRadius() + centerOfMass.getRadius() - Geometry.distanceInfinity(this.getPosition(), centerOfMass.getPosition());
                Coordinates repelVector=new Coordinates(repelDistance * (xBomber - xBlock), repelDistance * (yBomber - yBlock));
                this.position.add(repelVector);
        }

        private Coordinates repelVector(Entity center){
                
                return new Coordinates();
        }

        @Override
        public String toString(){
                return "Geometry{" + "position=" + position + ", radius=" + radius + ", oldPosition=" + oldPosition + ", direction=" + direction + '}';
        }

}
