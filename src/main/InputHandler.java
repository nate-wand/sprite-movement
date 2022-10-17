package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener {

    public boolean leftPress, rightPress, jump;

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_A) {
            leftPress = true;
        }

        if(code == KeyEvent.VK_D) {
            rightPress = true;
        }

        if(code == KeyEvent.VK_SPACE) {
            jump = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_A) {
            leftPress = false;
        }

        if(code == KeyEvent.VK_D) {
            rightPress = false;
        }
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
    
}
