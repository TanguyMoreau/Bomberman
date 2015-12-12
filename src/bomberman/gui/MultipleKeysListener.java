/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 *
 * @author guillaume
 */
public class MultipleKeysListener implements KeyListener {

    private double x, y;
    private boolean dropTheBomb;

    public MultipleKeysListener() {
        super();
        this.x = 0;
        this.y = 0;
        this.dropTheBomb = false;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public boolean isDropTheBomb() {
        return dropTheBomb;
    }

    public void setDropTheBomb(boolean dropTheBomb) {
        this.dropTheBomb = dropTheBomb;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                this.y--;
                break;
            case KeyEvent.VK_DOWN:
                this.y++;
                break;
            case KeyEvent.VK_LEFT:
                this.x--;
                break;
            case KeyEvent.VK_RIGHT:
                this.x++;
                break;
            case KeyEvent.VK_SPACE:
                this.dropTheBomb=true;
                break;

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
