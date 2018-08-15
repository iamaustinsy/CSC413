/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity.statics;

import Entity.Creatures.Player.Player;
import Entity.EntityManager;
import Graphix.Assets;
import Tiles.Tile;
import java.awt.Graphics;
import tankwar.Handler;

/**
 *
 * @author iamaustinsy
 */
public class Shield extends StaticEntity
{
    public Shield(Handler handler, float x, float y)
    {
        super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
    }
    
    public void tick()
    {
        
    }
    
    @Override
    public void die()
    {
        int newLife = EntityManager.getPlayer().getLives();
        newLife++;
        EntityManager.getPlayer().setLives(newLife);
    }
    
    public void render(Graphics g)
    {
        g.drawImage(Assets.shield, (int) (x - handler.getGameCamera().getXOffset()),(int) (y - handler.getGameCamera().getYOffset()), width, height, null);
    }
    
}
