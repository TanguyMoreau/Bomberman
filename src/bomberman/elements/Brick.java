/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman.elements;

import bomberman.Board;
import bomberman.elements.geometry.Geometry;
import bomberman.elements.lite.BrickLite;

/**
 *
 * @author grochette
 */
public class Brick extends Destructible {

    public Brick(Board board, Geometry body) {
        super(board, body, 1);
    }

    public BrickLite getBrickLite() {
        return new BrickLite(this.getBody().getGeometryLite(), this.getHealthPoints());
    }

}
