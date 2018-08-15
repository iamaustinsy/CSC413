/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package State;

import java.awt.Graphics;
import tankwar.Game;
import tankwar.Handler;

/**
 *
 * @author iamaustinsy
 */
public abstract class State 
{
    private static State currentState = null;
    
    public static void setState(State state)
    {
        currentState = state;
    }
    
    public static State getState()
    {
        return currentState;
    }
    
    //Class
    protected Handler handler;
    
    public State(Handler handler)
    {
        this.handler = handler;
    }
    
    public abstract void tick();
    
    public abstract void render(Graphics g);
}
