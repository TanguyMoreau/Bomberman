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
                Bomber a = new Bomber(board, new Geometry(1, 0, 0.5), 3);
                //Bomber b = new Bomber(board, new Geometry(0, 1, 0.4), 3);
                Wall w = new Wall(board, new Geometry(0, 0, 0.1));
                board.getWalls().add(w);
                for(int i = 0; i < 10; i++){
                        a.move(new Coordinates(-0.1, 0));
                        System.out.println(a);
                        System.out.println(a.getBody().collideWith(w.getBody()));
                }
        }

}
