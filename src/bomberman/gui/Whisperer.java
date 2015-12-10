package bomberman.gui;

import bomberman.elements.geometry.Coordinates;
import bomberman.elements.motion.Action;
import java.util.TimerTask;

public class Whisperer extends TimerTask{

        PlayerListener l;

        /**
         * @param args
         */
        public static void main(String[] args){
                // TODO Auto-generated method stub
        }

        /**
         * @param l
         */
        public Whisperer(PlayerListener l){
                super();
                this.l = l;
        }

        @Override
        public void run(){
                l.getAction();
                // get action in sendDataToServer
                l.setAction(new Action(new Coordinates(), false));
        }

}
