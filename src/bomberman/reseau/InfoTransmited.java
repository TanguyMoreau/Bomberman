package bomberman.reseau;

import bomberman.elements.geometry.Coordinates;
import bomberman.elements.motion.Action;
import java.io.Serializable;

/**
 *
 * @author tmoreau
 * 
 * Cet objet permet de stocker les différentes informations nécessaires à l'echange entre le client et le serveur.
 */
public class InfoTransmited implements Serializable {
    
    private boolean dataSend; // Permet l'échange des informations selon la boucle serveur
    private Action myAction; // Définit le comportement du client en jeu (ie du bomberman)

    // Accesseurs
    public Action getMyAction() {
        return myAction;
    }
    public void setMyAction(Action myAction) {
        this.myAction = myAction;
    }
    public boolean isDataSend() {
        return dataSend;
    }
    public void setDataSend(boolean dataSend) {
        this.dataSend = dataSend;
    }

    // Constructeur
    public InfoTransmited() {
        super();
        this.dataSend = true;
        Coordinates myCoordinates = new Coordinates();
        this.myAction = new Action(myCoordinates, false);

    }
}
