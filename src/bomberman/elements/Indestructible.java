/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman.elements;

import bomberman.Board;
import bomberman.elements.geometry.Geometry;

/**
 *
 * @author grochette
 */
public abstract class Indestructible extends Entity {

    public Indestructible(Board board, Geometry body) {
        super(board, body);
    }

}
