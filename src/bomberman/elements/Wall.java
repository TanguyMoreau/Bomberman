/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman.elements;

import bomberman.Board;
import bomberman.elements.geometry.Geometry;
import bomberman.elements.lite.WallLite;

/**
 *
 * @author grochette
 */
public class Wall extends Indestructible{

        public Wall(Board board, Geometry body){
                super(board, body);
        }
        
        public WallLite getWallLite(){
                return new WallLite(this.getBody().getGeometryLite());
        }

}
