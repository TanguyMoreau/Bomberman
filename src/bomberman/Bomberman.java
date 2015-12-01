/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman;

import bomberman.elements.Bomber;
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
                Board board=new Board();
                Bomber a = new Bomber(board, new Geometry(1, 0, 0.5), 3);
                Bomber b= new Bomber(board, new Geometry(0,1,0.4), 3);
                //Wall c=
                
                board.getBombers().add(a);
                board.getBombers().add(b);
                
                System.out.println(a.getBody());
                System.out.println(b.getBody());
                System.out.println(a.getBody().collideWith(b.getBody()));
                System.out.println(b.getBody().collideWith(a.getBody()));
                System.out.println(a.equals(b));
                
                a.move(new Coordinates(-1, 0));
                b.move(new Coordinates(0,-1));
                
                System.out.println(a.getBody());
                System.out.println(b.getBody());
                System.out.println(a.getBody().collideWith(b.getBody()));
                System.out.println(b.getBody().collideWith(a.getBody()));
        }

}
