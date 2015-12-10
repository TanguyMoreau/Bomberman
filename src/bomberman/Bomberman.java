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
import java.rmi.RemoteException;
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
                try{
                        Board board = new Board();
                        int a = Integer.parseInt(args[0]);
                        args[0] = null;
                        board.setMyInterfaceImpl(board.installingConnection(args));
                        board.waitingForPlayers(a);
                        //System.out.println(board.getBombers());
                        board.buildDefault();
                        Bomber b = board.getBombers().get(0);
                        b.setBody(new Geometry(48, 48, 10));
                        b.setHealthPoints(3);

                        //System.out.println(board.getWalls());
                        //Bomber a = new Bomber(board, , 3);
                        //Bomber b = new Bomber(board, new Geometry(0, 1, 0.3), 3);
                        //board.getBombers().add(a);
                        //board.getBombers().add(b);
                        board.run();
                }
                catch(RemoteException ex){
                        Logger.getLogger(Bomberman.class.getName()).log(Level.SEVERE, null, ex);
                }
        }

}
