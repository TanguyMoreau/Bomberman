/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman.reseau;

import bomberman.elements.geometry.Coordinates;
import bomberman.elements.motion.Action;
import java.io.Serializable;

/**
 *
 * @author tmoreau
 */
public class InfoTransmited implements Serializable{

        private boolean dataSend;
        private boolean createNew;
        private Action myAction;

        public Action getMyAction(){
                return myAction;
        }

        public void setMyAction(Action myAction){
                this.myAction = myAction;
        }

        public boolean isCreateNew(){
                return createNew;
        }

        public void setCreateNew(boolean createNew){
                this.createNew = createNew;
        }

        public boolean isDataSend(){
                return dataSend;
        }

        public void setDataSend(boolean dataSend){
                this.dataSend = dataSend;
        }

        public InfoTransmited(){
                super();
                this.createNew = true;
                this.dataSend = true;
                Coordinates myCoordinates = new Coordinates();
                this.myAction = new Action(myCoordinates, false);

        }
}
