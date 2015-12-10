package bomberman.reseau;

import bomberman.elements.geometry.Coordinates;
import bomberman.elements.lite.EntityLite;
import bomberman.elements.motion.Action;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author tmoreau
 */
public class InterfaceReseauImpl extends UnicastRemoteObject implements InterfaceReseau{

        /**
         * @param args the command line arguments
         */
        private ArrayList<EntityLite> dataBoard;
        private ArrayList<Action> listOfActions;
        private final ArrayList<InfoTransmited> infoFromClients;
        private int actualPosition;

        public ArrayList<EntityLite> getDataBoard() throws RemoteException{
                return dataBoard;
        }

        public void setDataBoard(ArrayList<EntityLite> dataBoard){
                this.dataBoard = dataBoard;
        }

        public ArrayList<Action> getListOfActions(){
                return listOfActions;
        }

        public void setListOfActions(ArrayList<Action> listOfActions){
                this.listOfActions = listOfActions;
        }

        public int getActualPosition() throws RemoteException{
                return actualPosition;
        }

        public void setActualPosition(int actualPosition){
                this.actualPosition = actualPosition;
        }

        public ArrayList<InfoTransmited> getInfoFromClients(){
                return infoFromClients;
        }

        public InfoTransmited getInfoFromClientsPos(int pos){
                return this.infoFromClients.get(pos);
        }

        public void setInfoFromClientsPos(int pos, InfoTransmited myInfo) throws RemoteException{
                this.infoFromClients.set(pos, myInfo);
        }

        public void setCoordinatesPos(int pos, Coordinates myCoordinates) throws RemoteException{
                this.infoFromClients.get(pos).getMyAction().setCoordinates(myCoordinates);
        }

        public void setCreateNewPos(int pos, boolean aBool) throws RemoteException{
                this.infoFromClients.get(pos).setCreateNew(aBool);
        }

        public void setDataSendPos(int pos, boolean aBool) throws RemoteException{
                this.infoFromClients.get(pos).setDataSend(aBool);
        }

        public void setDropTheBombPos(int pos, boolean aBool) throws RemoteException{
                this.infoFromClients.get(pos).getMyAction().setDropTheBomb(aBool);
        }

        public void ListOfActionsAdd() throws RemoteException{
                this.getListOfActions().add(null);
        }

        public Action ListOfActionsPos(int pos) throws RemoteException{
                return listOfActions.get(pos);
        }

        public void setCoordinatesPos(int pos, Action myAction) throws RemoteException{
                this.ListOfActionsPos(pos).setCoordinates(myAction.getCoordinates());
        }

        public void setDropTheBombPos(int pos, Action myAction) throws RemoteException{
                this.ListOfActionsPos(pos).setDropTheBomb(myAction.isDropTheBomb());
        }

        public void addNew() throws RemoteException{
                InfoTransmited newInfoTransmited = new InfoTransmited();
                infoFromClients.add(newInfoTransmited);
        }

        public InterfaceReseauImpl() throws RemoteException{
                this.listOfActions = new ArrayList();
                this.infoFromClients = new ArrayList();
                this.dataBoard = new ArrayList();
                this.actualPosition = 0;
        }
}
