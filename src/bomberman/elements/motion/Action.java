/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman.elements.motion;

import bomberman.elements.geometry.Coordinates;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author grochette
 */
public class Action implements Serializable {

    private Coordinates coordinates;
    private boolean dropTheBomb;

    public Action(Coordinates coordinates, boolean dropTheBomb) {
        this.coordinates = coordinates;
        this.dropTheBomb = dropTheBomb;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public boolean isDropTheBomb() {
        return dropTheBomb;
    }

    public void setDropTheBomb(boolean dropTheBomb) {
        this.dropTheBomb = dropTheBomb;
    }

    @Override
    public String toString() {
        return "Action{" + "coordinates=" + coordinates + ", dropTheBomb=" + dropTheBomb + '}';
    }
}
