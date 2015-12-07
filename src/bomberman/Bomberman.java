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
                Bomber a = new Bomber(board, new Geometry(1, 0, 0.3), 3);
                Bomber b = new Bomber(board, new Geometry(0, 1, 0.3), 3);
                Wall w = new Wall(board, new Geometry(0, 0, 0.1));
                board.getBombers().add(a);
                board.getBombers().add(b);
                board.getWalls().add(w);
                for(int i = 0; i < 10; i++){
                        try{
                                Thread.sleep(1000);
                        }
                        catch(InterruptedException ex){
                                Logger.getLogger(Bomberman.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        a.move(new Coordinates(-0.1, 0));
                        b.move(new Coordinates(0,-0.1));
                        System.out.println(a);
                        System.out.println(b);
                }
        }

}
