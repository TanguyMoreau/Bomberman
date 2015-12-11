/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman.elements.geometry;

import bomberman.Board;
import bomberman.elements.Bomb;
import bomberman.elements.Bomber;
import bomberman.elements.Brick;
import bomberman.elements.Entity;
import bomberman.elements.Wall;
import bomberman.elements.lite.geometry.GeometryLite;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author grochette
 */
public class Geometry {

    private Coordinates position;
    private double radius;
    private Coordinates oldPosition;
    private Coordinates direction;

    public Coordinates getPosition() {
        return position;
    }

    public void setPosition(Coordinates position) {
        this.position = position;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Coordinates getOldPosition() {
        return oldPosition;
    }

    public void setOldPosition(Coordinates oldPosition) {
        this.oldPosition = oldPosition;
    }

    public Coordinates getDirection() {
        return direction;
    }

    public void setDirection(Coordinates direction) {
        this.direction = direction;
    }

    public Geometry() {
        this.position = new Coordinates();
        this.radius = 0;
    }

    public Geometry(double x, double y, double radius) {
        this.position = new Coordinates(x, y);
        this.oldPosition = this.position;
        this.radius = radius;
    }

    public Geometry(Coordinates position, double radius) {
        this.position = position;
        this.radius = radius;
    }

    public Geometry(ArrayList<Entity> blockingBodies) {
        this.position = new Coordinates(blockingBodies);
        double r = 0;
        for (Entity e : blockingBodies) {
            if (e.getBody().getRadius() > r) {
                r = e.getBody().getRadius();
            }
        }
        this.radius = r;
    }

    public static double distanceInfinity(Coordinates a, Coordinates b) {
        return Math.max(Math.abs(a.getX() - b.getX()), Math.abs(a.getY() - b.getY()));
//                return Math.sqrt((a.getX()-b.getX())*(a.getX()-b.getX())+(a.getY()-b.getY())*(a.getY()-b.getY()));
    }

    public boolean isInBall(Geometry g) {
        return (distanceInfinity(g.getPosition(), this.position) <= this.radius);
    }

    public boolean collideWith(Geometry g) {
        return (distanceInfinity(g.getPosition(), this.position) <= this.radius + g.getRadius());
    }

    public void updatePosition(Coordinates vector) {
        this.oldPosition = this.position;
        Coordinates newPosition = new Coordinates(this.position.getX(), this.position.getY());
        newPosition.add(vector);
        this.setPosition(newPosition);
        updateDirection();
    }

    public void updateDirection() {
        double dX = (position.getX() - oldPosition.getX());
        double dY = (position.getY() - oldPosition.getY());
        if (dX == 0 && dY == 0) {

        } else {
            this.direction = new Coordinates(dX, dY);
        }
    }
    
    public void correctPosition(Board board){
        ArrayList<Entity> blockingBodies = findBlockingBodies(board);
        System.out.println(blockingBodies);
        if (!blockingBodies.isEmpty()) {
            Geometry centerOfMass = new Geometry(blockingBodies);
            this.repel(centerOfMass);
            if (this.collideWith(centerOfMass)) {
                //System.out.println("!");
                this.setPosition(this.getOldPosition());
                //this.move(new Coordinates(-vector.getX() / 8.0, -vector.getY() / 8.0));
            }
        }
    }
    
    
    private ArrayList<Entity> findBlockingBodies(Board board) {
        Geometry bomberBody = this;
        ArrayList<Entity> blockingBodies = new ArrayList<>();
        for (Wall aWall : board.getWalls()) {
            if (bomberBody.collideWith(aWall.getBody())) {
                blockingBodies.add(aWall);
            }
        }
        for (Brick aBrick : board.getBricks()) {
            if (bomberBody.collideWith(aBrick.getBody())) {
                blockingBodies.add(aBrick);
            }
        }
        for (Bomber aBomber : board.getBombers()) {
            if (!this.equals(aBomber.getBody())) {
                if (bomberBody.collideWith(aBomber.getBody())) {
                    blockingBodies.add(aBomber);
                }
            }
        }
        for (Bomb aBomb : board.getBombs()) {
            if (bomberBody.collideWith(aBomb.getBody())) {
                blockingBodies.add(aBomb);
            }
        }
        return blockingBodies;
    }

    public void repel(Geometry centerOfMass) {
        double xBomber = this.getPosition().getX();
        double yBomber = this.getPosition().getY();
        double xBlock = centerOfMass.getPosition().getX();
        double yBlock = centerOfMass.getPosition().getY();
        double repelDistance = this.getRadius() + centerOfMass.getRadius() - Geometry.distanceInfinity(this.getPosition(), centerOfMass.getPosition());
        repelDistance = repelDistance / 16.0;
        Coordinates repelVector = new Coordinates(repelDistance * (xBomber - xBlock), repelDistance * (yBomber - yBlock));
        this.position.add(repelVector);
    }

    @Override
    public String toString() {
        return "Geometry{" + "position=" + position + ", radius=" + radius /*+ ", oldPosition=" + oldPosition + ", direction=" + direction + '}'*/;
    }

    public GeometryLite getGeometryLite() {
        return new GeometryLite(this.position, this.radius);
    }
}
