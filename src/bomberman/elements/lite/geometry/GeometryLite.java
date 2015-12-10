/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman.elements.lite.geometry;

import bomberman.elements.geometry.Coordinates;
import java.io.Serializable;

/**
 *
 * @author grochette
 */
public class GeometryLite implements Serializable {

    private Coordinates position;
    private double radius;

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

    public GeometryLite() {
        this.position = new Coordinates();
        this.radius = 0;
    }

    public GeometryLite(double x, double y, double radius) {
        this.position = new Coordinates(x, y);
        this.radius = radius;
    }

    public GeometryLite(Coordinates position, double radius) {
        this.position = position;
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Geometry{" + "position=" + position + ", radius=" + radius + "}";
    }
}
