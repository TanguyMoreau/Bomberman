package bomberman.reseau;

import bomberman.ClientMain;
import bomberman.elements.lite.EntityLite;
import bomberman.elements.motion.Action;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;

/**
 *
 * @author tmoreau
 */
public class Client {
    
    InterfaceReseau myInterface;
    int position;
    private ArrayList<EntityLite> myDataBoard;
    private ClientMain thread;

    // Accesseurs
    public ArrayList<EntityLite> getMyDataBoard() {
        return myDataBoard;
    }
    public void setMyDataBoard(ArrayList<EntityLite> myDataBoard) {
        this.myDataBoard = myDataBoard;
    }
    public InterfaceReseau getMyInterface() {
        return myInterface;
    }
    public void setMyInterface(InterfaceReseau myInterface) {
        this.myInterface = myInterface;
    }
    public int getPosition() {
        return position;
    }
    public void setPosition(int position) {
        this.position = position;
    }

    public InterfaceReseau connectionToServer(String[] args) throws NotBoundException, RemoteException { 
        if (args.length > 0) {
            myInterface = (InterfaceReseau) LocateRegistry.getRegistry(args[0]).lookup("distantServer_02");
        } else {
            myInterface = (InterfaceReseau) LocateRegistry.getRegistry().lookup("distantServer_02");
        }
        return myInterface;
    }

    public void initialization() throws RemoteException { // Permet la génération dynamique des clients
        myInterface.addNew();
        myInterface.ListOfActionsAdd();
        this.position = myInterface.getActualPosition();
        myInterface.setActualPosition(this.position + 1);
    }

    public void sendDataToServer(Action myAction, int position) throws RemoteException {
        this.setMyDataBoard(myInterface.getDataBoard()); //Acquiert le nouveau board du serveur
        myInterface.setCoordinatesPos(position, myAction.getCoordinates()); // Envoie la nouvelle action du client
        myInterface.setDropTheBombPos(position, myAction.isDropTheBomb());
        myInterface.setDataSendPos(position, true); // Permet au serveur de savoir quand récupérer les nouvelles données
    }
    
    // Constructeur
    public Client(ClientMain thread) {
        this.thread = thread;
    }
}
