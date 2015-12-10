package bomberman.gui;

import bomberman.elements.geometry.Coordinates;
import bomberman.elements.motion.Action;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SpaceListener implements KeyListener {

    private boolean isDropTheBomb;

    public SpaceListener() {
        // TODO Auto-generated constructor stub
        super();
        isDropTheBomb=false;

    }

    public boolean isIsDropTheBomb() {
        return isDropTheBomb;
    }

    public void setIsDropTheBomb(boolean isDropTheBomb) {
        this.isDropTheBomb = isDropTheBomb;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_SPACE:
                isDropTheBomb=true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
