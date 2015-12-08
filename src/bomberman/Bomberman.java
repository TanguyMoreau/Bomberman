/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman;

import bomberman.elements.Bomber;
import bomberman.elements.Wall;
import bomberman.elements.geometry.Coordinates;
import bomberman.elements.geometry.Geometry;
import bomberman.elements.lite.EntityLite;
import bomberman.elements.motion.Action;
import bomberman.utils.WallReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author grochette
 */
public class Bomberman{

        /**
         * @param args the command line arguments
         */
        public static void main(String[] args){
                Board board = new Board();
                board.setWalls(WallReader.defaultFile(board));
                //System.out.println(board.getWalls());
                Bomber a = new Bomber(board, new Geometry(40, 40, 5), 3);
                //Bomber b = new Bomber(board, new Geometry(0, 1, 0.3), 3);
                board.getBombers().add(a);
                //board.getBombers().add(b);
                board.run();
        }

}
