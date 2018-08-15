/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author iamaustinsy
 */
public class KeyManager implements KeyListener
{
    private boolean[] keys;
    public boolean p1up, p1down, p1left, p1right, p1shoot;
    public boolean p2up, p2down, p2left, p2right, p2shoot;
    public void tick()
    {
        p1up = keys[KeyEvent.VK_W];
        p1down = keys[KeyEvent.VK_S];
        p1left = keys[KeyEvent.VK_A];
        p1right = keys[KeyEvent.VK_D];
        p1shoot = keys[KeyEvent.VK_SPACE];
        
        
        p2up = keys[KeyEvent.VK_UP];
        p2down = keys[KeyEvent.VK_DOWN];
        p2left = keys[KeyEvent.VK_LEFT];
        p2right = keys[KeyEvent.VK_RIGHT];
        p2shoot = keys[KeyEvent.VK_ENTER];
        
    }
    
    public KeyManager()
    {
        keys = new boolean[256];
    }
    
    @Override
    public void keyTyped(KeyEvent e) 
    {
        
    }

    @Override
    public void keyPressed(KeyEvent e) 
    {
        keys[e.getKeyCode()] = true;
        System.out.println("Pressed");
    }

    @Override
    public void keyReleased(KeyEvent e) 
    {
        keys[e.getKeyCode()] = false;
    }
    
}
