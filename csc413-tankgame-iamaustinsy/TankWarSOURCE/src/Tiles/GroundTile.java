/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tiles;

import Graphix.Assets;
import static Tiles.Tile.TILEHEIGHT;
import static Tiles.Tile.TILEWIDTH;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author iamaustinsy
 */
public class GroundTile extends Tile
{
    
    public GroundTile(int id) 
    {
        super(Assets.ground, id);
    }
    
    @Override
    public void render(Graphics g, int x, int y)
    {
        g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
    }
    
}
