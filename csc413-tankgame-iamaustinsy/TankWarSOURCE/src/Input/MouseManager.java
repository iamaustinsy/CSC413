/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Input;

import State.State;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author iamaustinsy
 */
public class MouseManager implements MouseListener, MouseMotionListener
{
    private boolean leftPressed, rightPressed;
    private int mouseX, mouseY;
    public static boolean isGame = false;
    public static boolean isQuit = false;
    public MouseManager()
    {
        
    }
    
    //Getter
    public boolean isLeftPressed()
    {
        return leftPressed;
    }
    
    public boolean isRightPressed()
    {
        return rightPressed;
    }
    
    public int getMouseX()
    {
        return mouseX;
    }
    
    public int getMouseY()
    {
        return mouseY;
    }
    
    public boolean isGameState()
    {
        return isGame;
    }
    
    public boolean isQuitState()
    {
        return isQuit;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) 
    {
        /*
            public Rectangle playButton = new Rectangle(345, 350, 100, 50);
            public Rectangle quitButton = new Rectangle(345, 450, 100, 50);
            
        */
        
        int mx = e.getX();
        int my = e.getY();
        if(e.getButton() == MouseEvent.BUTTON1)
        {
            leftPressed = true;
        }
        else if(e.getButton() == MouseEvent.BUTTON3)
        {
            rightPressed = true;
        }
        if(mx >= 500 && mx <= 700)
        {
            if(my >= 600 && my <= 700)
            {
                isGame = true;
            }
        }
        
        if(mx >= 500 && mx <= 700)
        {
            if(my >= 700 && my <= 800)
            {
                isQuit = true;
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) 
    {
        if(e.getButton() == MouseEvent.BUTTON1)
        {
            leftPressed = false;
        }
        else if(e.getButton() == MouseEvent.BUTTON3)
        {
            rightPressed = false;
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }
}
