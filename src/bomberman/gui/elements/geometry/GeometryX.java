package bomberman.gui.elements.geometry;

import bomberman.elements.geometry.Coordinates;
import bomberman.elements.lite.geometry.GeometryLite;

public class GeometryX {

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

    public GeometryX() {
        this.position = new Coordinates();
        this.radius = 0;
    }

    public GeometryX(double x, double y, double radius) {
        this.position = new Coordinates(x, y);
        this.radius = radius;
    }

    public GeometryX(Coordinates position, double radius) {
        this.position = position;
        this.radius = radius;
    }

    public GeometryX(GeometryLite geometryLite) {
        this.position = new Coordinates(geometryLite.getPosition().getX(), geometryLite.getPosition().getY());
        this.radius = geometryLite.getRadius();
    }
}
