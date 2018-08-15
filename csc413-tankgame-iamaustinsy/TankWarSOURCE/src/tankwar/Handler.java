/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tankwar;

import Graphix.GameCamera;
import Input.KeyManager;
import Input.MouseManager;
import World.World;

/**
 *
 * @author iamaustinsy
 */
public class Handler 
{
    private Game game;
    private World world;
    
    public Handler(Game game)
    {
        this.game = game;
    }
    
    public int getWidth()
    {
        return game.getWidth();
    }
    
    public int getHeight()
    {
        return game.getHeight();
    }
    
    public GameCamera getGameCamera()
    {
        return game.getGameCamera();
    }
    
    public KeyManager getKeyManager()
    {
        return game.getKeyManager();
    }
    
    public MouseManager getMouseManager()
    {
        return game.getMouseManager();
    }
    
    public Game getGame()
    {
        return game;
    }
    
    public void setGame(Game game)
    {
        this.game = game;
    }
    
    public World getWorld()
    {
        return world;
    }
    
    public void setWorld(World world)
    {
        this.world = world;
    }
}
