/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman.reseau;

import bomberman.elements.geometry.Coordinates;
import bomberman.elements.lite.EntityLite;
import bomberman.elements.motion.Action;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author tmoreau
 */
public interface InterfaceReseau extends Remote {

    public Action ListOfActionsPos(int pos) throws RemoteException;

    public ArrayList<Action> getListOfActions() throws RemoteException;

    public void ListOfActionsAdd() throws RemoteException;

    public void setCoordinatesPos(int pos, Action myAction) throws RemoteException;

    public void setDropTheBombPos(int pos, Action myAction) throws RemoteException;

    public ArrayList<EntityLite> getDataBoard() throws RemoteException;

    public InfoTransmited getInfoFromClientsPos(int pos) throws RemoteException;

    public void setInfoFromClientsPos(int pos, InfoTransmited myInfo) throws RemoteException;

    public ArrayList<InfoTransmited> getInfoFromClients() throws RemoteException;

    public void addNew() throws RemoteException;

    public int getActualPosition() throws RemoteException;

    public void setCreateNewPos(int pos, boolean aBool) throws RemoteException;

    public void setDataSendPos(int pos, boolean aBool) throws RemoteException;

    public void setCoordinatesPos(int pos, Coordinates myCoordinates) throws RemoteException;

    public void setDropTheBombPos(int pos, boolean aBool) throws RemoteException;
}
