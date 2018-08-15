/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphix;

import Entity.Entity;
import Tiles.Tile;
import tankwar.Game;
import tankwar.Handler;

/**
 *
 * @author iamaustinsy
 */
public class GameCamera 
{
    private float xOffset, yOffset;
    private Handler handler;
    public GameCamera(Handler handler, float xOffset, float yOffset)
    {
        this.handler = handler;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }
    
    public void checkBlankSpace()
    {
        if(xOffset < 0)
        {
            xOffset = 0;
        }
        else if(xOffset > handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth())
        {
            xOffset = handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth();
        }
        
        if(yOffset < 0)
        {
            yOffset = 0;
        }
        else if(yOffset > handler.getWorld().getHeight() * Tile.TILEHEIGHT - handler.getHeight())
        {
            yOffset = handler.getWorld().getHeight() * Tile.TILEHEIGHT - handler.getHeight();
        }
    }
    
    public void centerOnEntity(Entity e)
    {
        xOffset = e.getX() - handler.getWidth() / 2 + e.getWidth() / 2;
        yOffset = e.getY() - handler.getHeight() / 2 + e.getHeight() / 2;
        checkBlankSpace();
    }
    
    public void move(float xAmt, float yAmt)
    {
        xOffset += xAmt;
        yOffset += yAmt;
        checkBlankSpace();
    }
    
    public float getXOffset()
    {
        return xOffset;
    }
    public void setXOffset(int xOffset)
    {
        this.xOffset = xOffset;
    }
    public float getYOffset()
    {
        return yOffset;
    }
    public void setYOffset(float yOffset)
    {
        this.yOffset = yOffset;
    }
}
