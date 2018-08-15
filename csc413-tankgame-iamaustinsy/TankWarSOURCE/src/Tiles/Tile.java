/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author iamaustinsy
 */
public class Tile 
{
    public static Tile[] tiles = new Tile[256];
    public static Tile groundTile = new GroundTile(0);
    public static Tile brick1Tile = new Brick1(1); //Hardened Brick that will not break
    public static Tile brick2Tile = new Brick2(2); //Normal Brick that will be breakable
    
    
    public static final int TILEWIDTH = 60, TILEHEIGHT = 60;
    
    protected BufferedImage texture;
    protected final int id;
    
    public Tile(BufferedImage texture, int id)
    {
        this.texture = texture;
        this.id = id;
        
        tiles[id] = this;     
    }
    
    public void tick()
    {
        
    }
    
    public void render(Graphics g, int x, int y)
    {
        g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
    }
    
    //Collision
    public boolean isSolid()
    {
        return false;
    }
    
    public int getID()
    {
        return id;
    }

    
    
}
