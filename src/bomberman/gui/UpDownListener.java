package bomberman.gui;

import bomberman.elements.geometry.Coordinates;
import bomberman.elements.motion.Action;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class UpDownListener implements KeyListener {


    private double y;

    public UpDownListener() {
        // TODO Auto-generated constructor stub
        super();
        y=0;


    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                y=y-2;
                break;

            case KeyEvent.VK_DOWN:
                y=y+2;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
