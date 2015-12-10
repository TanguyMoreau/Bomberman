package bomberman.gui;

import bomberman.elements.geometry.Coordinates;
import bomberman.elements.motion.Action;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerListener implements KeyListener{

        /**
         * @param x
         * @param y
         */
        private Action action;
        private GameScreen g;

        /**
         *
         */
        public PlayerListener(GameScreen g){
                // TODO Auto-generated constructor stub
                super();
                action = new Action(new Coordinates(), false);
                this.g = g;

        }

        public Action getAction(){
                return this.action;
        }

        public void setAction(Action newAction){
                this.action = newAction;
        }

        @Override
        public void keyTyped(KeyEvent e){

        }

        @Override
        public void keyPressed(KeyEvent e){
                Coordinates c = this.action.getCoordinates();
                switch(e.getKeyCode()){
                        case KeyEvent.VK_RIGHT:
                                c.setX(c.getX() + 2);
                                break;

                        case KeyEvent.VK_LEFT:
                                c.setX(c.getX() - 2);
                                break;

                        case KeyEvent.VK_UP:
                                c.setY(c.getY() - 2);
                                break;

                        case KeyEvent.VK_DOWN:
                                c.setY(c.getY() + 2);
                                break;

                        case KeyEvent.VK_SPACE:
                                this.action.setDropTheBomb(true);
                                break;
                }
        }

        @Override
        public void keyReleased(KeyEvent e){

        }

}
