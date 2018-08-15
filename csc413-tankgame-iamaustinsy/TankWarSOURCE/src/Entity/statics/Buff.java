/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity.statics;

import Entity.EntityManager;
import Graphix.Assets;
import Tiles.Tile;
import java.awt.Graphics;
import tankwar.Handler;

/**
 *
 * @author iamaustinsy
 */
public class Buff extends StaticEntity
{
    public Buff(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
    }

    @Override
    public void tick() 
    {
        
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.buff, (int) (x - handler.getGameCamera().getXOffset()),(int) (y - handler.getGameCamera().getYOffset()), width, height, null);
    }

    @Override
    public void die() {
        long newCD = EntityManager.getPlayer().getCD();
        newCD -= 200;
        EntityManager.getPlayer().setCD(newCD);
    }
    
}
