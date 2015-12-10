/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman;

import bomberman.reseau.Client;
import bomberman.elements.geometry.Coordinates;
import bomberman.elements.motion.Action;
import bomberman.gui.GameScreen;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tmoreau
 */
public class ClientMain {

    private Client client;
    private GameScreen window;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public GameScreen getWindow() {
        return window;
    }

    public void setWindow(GameScreen window) {
        this.window = window;
    }

    public static void main(String[] args) throws RemoteException, NotBoundException {
        ClientMain c = new ClientMain(args);
        c.getWindow().pack();
        c.getWindow().requestFocus();
        c.getWindow().setVisible(true);
        Random r = new Random();
        while (true) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(ClientMain.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (c.getClient().getMyInterface().getInfoFromClientsPos(c.getClient().getPosition()).isDataSend() == false) {
                Action newAction = new Action(new Coordinates(c.getWindow().getlRL().getX(), c.getWindow().getuDL().getY()), c.getWindow().getsL().isIsDropTheBomb());
                c.getWindow().getuDL().setY(0);
                c.getWindow().getlRL().setX(0);
                c.getWindow().getsL().setIsDropTheBomb(false);

                try {
                    c.getClient().sendDataToServer(c.getClient().getMyInterface(), newAction, c.getClient().getPosition());
                } catch (RemoteException ex) {
                    Logger.getLogger(ClientMain.class.getName()).log(Level.SEVERE, null, ex);
                }
                c.getWindow().getMainCenter().convertList(c.getClient().getMyDataBoard());
                c.getWindow().getMainCenter().repaint();
            }
        }
    }

    public ClientMain(String[] args) throws NotBoundException, RemoteException {
        super();
        this.window = new GameScreen();
        this.client = new Client(this);
        client.connectionToServer(args);
        client.initialization(client.getMyInterface());
    }

}
