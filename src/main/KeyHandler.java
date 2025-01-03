package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {


    public boolean upPressed;
    public boolean downPressed;
    public boolean leftPressed;
    public boolean rightPressed;

    //notebook
    public boolean nPressed;

    //npc
    public boolean iPressed;


    public KeyHandler() {
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == 87) {
            this.upPressed = true;
        }
        if (code == 73)
        {
            this.iPressed = true;
        }

        if (code == 83) {
            this.downPressed = true;
        }

        if (code == 65) {
            this.leftPressed = true;
        }

        if (code == 68) {
            this.rightPressed = true;
        }

        if (code == 78)
        {
            this.nPressed = true;
        }

    }

    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == 87) {
            this.upPressed = false;
        }

        if (code == 83) {
            this.downPressed = false;
        }

        if (code == 65) {
            this.leftPressed = false;
        }

        if (code == 68) {
            this.rightPressed = false;
        }
        if (code == 78) {
            this.nPressed = false;
        }
        if (code == 73)
        {
            this.iPressed = false;
        }

    }
}
