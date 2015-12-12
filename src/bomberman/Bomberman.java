/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman;

import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author grochette
 */
public class Bomberman {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            int numberOfPlayers = Integer.parseInt(args[0]);
            Board board = new Board(numberOfPlayers);

            System.out.println("Veuillez connecter " + numberOfPlayers + " client(s)");
            board.setMyInterfaceImpl(board.installingConnection(args));
            board.waitingForPlayers(numberOfPlayers);
            board.buildDefault();
            System.out.println(board);
            board.run();
        } catch (RemoteException ex) {
            Logger.getLogger(Bomberman.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
