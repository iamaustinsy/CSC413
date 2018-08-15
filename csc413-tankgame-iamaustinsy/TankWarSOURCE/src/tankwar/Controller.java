/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tankwar;

import static Entity.Creatures.Creature.DEFAULT_CREATURE_HEIGHT;
import static Entity.Creatures.Creature.DEFAULT_CREATURE_WIDTH;
import Entity.Creatures.Player.Bullet;
import Entity.Creatures.Player.Player;
import Entity.Entity;
import Entity.statics.Shield;
import Graphix.Assets;
import Tiles.Tile;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.LinkedList;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;

/**
 *
 * @author iamaustinsy
 */
//Class to fix for tomorrow might have to integrate second player beforehand
public class Controller 
{
    private LinkedList<Bullet> b = new LinkedList<Bullet>();
    private LinkedList<Rectangle>p1bullet = new LinkedList<Rectangle>();
    Rectangle bulletrec, temp;
    Bullet TempBullet;
    Graphics2D g2d;

    private Handler handler;
    private Game game;
    
    public Controller(Handler handler)
    {
        this.handler = handler;
        this.game = handler.getGame();
    }
    
    public void tick() 
    {
        for(int i = 0; i < b.size(); i++) 
        {
          TempBullet = b.get(i);
          bulletrec = new Rectangle((int)TempBullet.getX(), (int)TempBullet.getY(), 27, 8);
          temp = Player.getBounds();
            
          for(Entity e: handler.getWorld().getEntityManager().getEntities())
          {             
              
              if(e.equals(this))
              {
                  continue;
              }
              if(e.getCollisionBounds(Tile.TILEWIDTH,Tile.TILEHEIGHT).intersects(bulletrec))
              {
                  if(e.isSolid())
                  {
                    e.hurt(1);
                    removeBullet(TempBullet);
                    handler.getWorld().getEntityManager().getPlayer().addScore(10);
                  }
              }
              
          }
          
          TempBullet.tick();
          
        }
        
    }
    
    public void render(Graphics g)
    {
        for(int i = 0; i < b.size(); i++) 
        {
          TempBullet = b.get(i);
          //g.fillRect((int)bulletrec.getX(),(int) bulletrec.getY(), (int)bulletrec.getWidth(), (int)bulletrec.getHeight());
          AffineTransform rotation = AffineTransform.getTranslateInstance((int) (TempBullet.getX() - handler.getGameCamera().getXOffset() - 40), (int) TempBullet.getY() - handler.getGameCamera().getYOffset() - 40);
            rotation.rotate(Math.toRadians(TempBullet.getAngle()), 27 / 2, 8 / 2);
            Graphics2D graphic2D = (Graphics2D) g;
            graphic2D.drawImage(Assets.bullet, rotation, null);
          TempBullet.render(g);
        }
    }
    
    
    public void addBullet(Bullet block) 
    {
      b.add(block);
    }

    public void removeBullet(Bullet block) 
    {
      b.remove(block);
    }

    public void addBulletrec(Rectangle block)
    {
      p1bullet.add(block);
    }

    public void removeBulletrec(Rectangle block) 
    {
      p1bullet.remove(block);
    }

}
