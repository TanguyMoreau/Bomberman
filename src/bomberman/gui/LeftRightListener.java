package bomberman.gui;

import bomberman.elements.geometry.Coordinates;
import bomberman.elements.motion.Action;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class LeftRightListener implements KeyListener {

    private double x;

    public LeftRightListener() {
        // TODO Auto-generated constructor stub
        super();
        x = 0;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                x = x + 4;
                break;

            case KeyEvent.VK_LEFT:
                x = x - 4;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
