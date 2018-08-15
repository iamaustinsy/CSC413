/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity.statics;

import Graphix.Assets;
import Tiles.Tile;
import java.awt.Graphics;
import tankwar.Handler;

/**
 *
 * @author iamaustinsy
 */
public class Brick extends StaticEntity
{
    public Brick(Handler handler, float x, float y)
    {
        super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
    }
    
    public void tick()
    {
        
    }
    
    @Override
    public void die()
    {
        
    }
    
    public void render(Graphics g)
    {
        g.drawImage(Assets.brick2, (int) (x - handler.getGameCamera().getXOffset()),(int) (y - handler.getGameCamera().getYOffset()), width, height, null);
    }
}
