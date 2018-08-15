package Entity.Creatures.Player;

import Entity.Creatures.Creature;
import static Entity.Creatures.Creature.DEFAULT_CREATURE_HEIGHT;
import static Entity.Creatures.Creature.DEFAULT_CREATURE_WIDTH;
import Entity.Creatures.Player.Player;

import Entity.Entity;
import Graphix.Assets;
import Graphix.ImageLoader;
import Tiles.Tile;
import static Tiles.Tile.TILEHEIGHT;
import static Tiles.Tile.TILEWIDTH;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import tankwar.Handler;

/**
 *
 * @author iamaustinsy
 */
public class Bullet
{
    private int x;
    private int y;
    private int bulletx, bullety;
    private String ownerName;
    private double angle;
    private int damage;
    
    private BufferedImage image;
    AffineTransform transform;
    private Handler handler;
    Rectangle bulletrec;
    
    public Bullet(Handler handler, int x, int y, double angle)
    {
        this.x = x;
        this.y = y;
        this.angle = angle;
        damage = 1;
        bulletx = 27;
        bullety = 8;
        image = ImageLoader.loadImage("/Weapons/Rocket.png");
    }
    
 
    public void tick()
    {
        x += (12 * Math.cos(Math.toRadians(angle)));
        y += (12 * Math.sin(Math.toRadians(angle)));
        
    }

    
    public void render(Graphics g) 
    {
        
    }
    
    protected boolean collisionWithTile(int x, int y)
    {
        return handler.getWorld().getTile(x,y).isSolid();
    }
    
    public void setOwner(String name)
    {
        this.ownerName = name;
    }

    public String getOwners(){
        return this.ownerName;
    }
    
    public int getX()
    {
        return x;
    }
    
    public int getY()
    {
        
        return y;
    }
    public double getAngle()
    {
        return angle;
    }
    public void die() 
    {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
