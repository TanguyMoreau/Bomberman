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
        private Coordinates speed;

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

        public Coordinates getSpeed(){
                return speed;
        }

        public void setSpeed(Coordinates speed){
                this.speed = speed;
        }

        public Geometry(){
                this.position = new Coordinates();
                this.radius = 0;
                this.oldPosition = new Coordinates();
                updateSpeed(1);
        }
        
        public Geometry(double x, double y, double radius){
                this.position=new Coordinates(x, y);
                this.oldPosition=this.position;
                this.radius=radius;
                updateSpeed(1);
        }

        public Geometry(Coordinates position, double radius){
                this.position = position;
                this.radius = radius;
                this.oldPosition = position;
                updateSpeed(1);
        }
        
        public Geometry(ArrayList<Entity> blockingBodies){
                this.position=new Coordinates(blockingBodies);
                double r=0;
                for(Entity e: blockingBodies){
                        if(e.getBody().getRadius()>r){
                                r=e.getBody().getRadius();
                        }
                }
                this.radius=r;
                this.oldPosition=this.position;
                updateSpeed(1);
        }

        public static double distanceInfinity(Coordinates a, Coordinates b){
                return Math.max(Math.abs(a.getX() - b.getX()), Math.abs(a.getY() - b.getY()));
        }

        public boolean isInBall(Geometry g){
                return (distanceInfinity(g.getPosition(), this.position) <= this.radius);
        }
        
        public boolean collideWith(Geometry g){
                return(distanceInfinity(g.getPosition(), this.position)<=this.radius+g.getRadius());
        }

        public void updatePosition(Coordinates newPosition){
                this.oldPosition = this.position;
                this.position = newPosition;
        }

        public void updateSpeed(double dt){
                double sX = 0;
                double sY = 0;
                try{
                        sX = (position.getX() - oldPosition.getX()) / dt;
                        sY = (position.getX() - oldPosition.getY()) / dt;
                }
                catch(ArithmeticException ex){

                }
                this.speed = new Coordinates(sX, sY);
        }

        @Override
        public int hashCode(){
                int hash = 5;
                hash = 59 * hash + Objects.hashCode(this.position);
                hash = 59 * hash + (int) (Double.doubleToLongBits(this.radius) ^ (Double.doubleToLongBits(this.radius) >>> 32));
                hash = 59 * hash + Objects.hashCode(this.oldPosition);
                hash = 59 * hash + Objects.hashCode(this.speed);
                return hash;
        }

        @Override
        public boolean equals(Object obj){
                if(obj == null){
                        return false;
                }
                if(getClass() != obj.getClass()){
                        return false;
                }
                final Geometry other = (Geometry) obj;
                if(!Objects.equals(this.position, other.position)){
                        return false;
                }
                if(Double.doubleToLongBits(this.radius) != Double.doubleToLongBits(other.radius)){
                        return false;
                }
                if(!Objects.equals(this.oldPosition, other.oldPosition)){
                        return false;
                }
                if(!Objects.equals(this.speed, other.speed)){
                        return false;
                }
                return true;
        }

        @Override
        public String toString(){
                return "Geometry{" + "position=" + position + ", radius=" + radius + ", oldPosition=" + oldPosition + ", speed=" + speed + '}';
        }
}
