/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman.elements.geometry;

import bomberman.elements.Entity;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author grochette
 */
public class Coordinates implements Serializable {

    private double x, y;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Coordinates(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Coordinates() {
        this.x = 0;
        this.y = 0;
    }

    public Coordinates(ArrayList<Entity> blockingBodies) {
        //returns a midpoint of all blocking bodies
        this.x = 0;
        this.y = 0;
        for (Entity e : blockingBodies) {
            Coordinates c = e.getBody().getPosition();
            this.x = this.x + c.getX();
            this.y = this.y + c.getY();
        }
        try {
            double n = blockingBodies.size();
            this.x = this.x / n;
            this.y = this.y / n;
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
    }

    public void add(Coordinates coordinates) {
        this.x = this.x + coordinates.getX();
        this.y = this.y + coordinates.getY();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.x) ^ (Double.doubleToLongBits(this.x) >>> 32));
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.y) ^ (Double.doubleToLongBits(this.y) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Coordinates other = (Coordinates) obj;
        if (Double.doubleToLongBits(this.x) != Double.doubleToLongBits(other.x)) {
            return false;
        }
        if (Double.doubleToLongBits(this.y) != Double.doubleToLongBits(other.y)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Coordinates{" + "x=" + x + ", y=" + y + '}';
    }
}
