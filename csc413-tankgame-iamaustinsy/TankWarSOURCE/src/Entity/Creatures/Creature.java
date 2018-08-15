/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity.Creatures;

import Entity.Entity;
import Tiles.Tile;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import tankwar.Game;
import tankwar.Handler;

/**
 *
 * @author iamaustinsy
 */
public abstract class Creature extends Entity 
{    
    //Movement speed can be scaled up/down <----HERE
    public static final float DEFAULT_SPEED = 3.0f;
    public static final int DEFAULT_CREATURE_WIDTH = 60;
    public static final int DEFAULT_CREATURE_HEIGHT = 60;
            
    
    protected float speed;
    protected float x1Move, y1Move;
    protected float vx1Move, vy1Move;
    protected short angle1;
    
    protected float x2Move, y2Move;
    protected float vx2Move, vy2Move;
    protected short angle2;
    
    
    protected final int r = 6;
    
    public Creature(Handler handler,float x, float y, int width, int height) 
    {
        super(handler, x, y, width, height);
        speed = DEFAULT_SPEED;
        x1Move = 0;
        y1Move = 0;
        vx1Move = 0;
        vy1Move = 0;
        angle1 = 0;
        
        x2Move = 0;
        y2Move = 0;
        vx2Move = 0;
        vy2Move = 0;
        angle2 = 1;
    }
    
    public void move()
    {
        if(!checkEntityCollision(x1Move, 0f))
        {
            moveX1();
        }
        
        if(!checkEntityCollision(0f, y1Move))
        {
            moveY1();
        }
        
        if(!checkEntityCollision(x2Move, 0f))
        {
            moveX2();
        }
        
        if(!checkEntityCollision(0f, y2Move))
        {
            moveY2();
        }
        //checkBorder();
    }
    
    public void moveX1()
    {
        if(x1Move > 0)
        {
            int tx = (int) (x + x1Move + bounds.x + bounds.width) / Tile.TILEWIDTH;
			
            if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
		!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT))
            {
		x += x1Move;
            }
            else
            {
                x = tx * Tile.TILEWIDTH - bounds.x - bounds.width - 1;
            }
        }
        else if(x1Move < 0)
        {
            int tx = (int) (x + x1Move + bounds.x) / Tile.TILEWIDTH;
			
            if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
                    !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT))
            {
                x += x1Move;
            }
            else
            {
                x = tx * Tile.TILEWIDTH + Tile.TILEWIDTH - bounds.x;
            }
        }
    }
    
    public void moveX2()
    {
        if(x2Move > 0)
        {
            int tx = (int) (x + x2Move + bounds.x + bounds.width) / Tile.TILEWIDTH;
			
            if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
		!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT))
            {
		x += x2Move;
            }
            else
            {
                x = tx * Tile.TILEWIDTH - bounds.x - bounds.width - 1;
            }
        }
        else if(x2Move < 0)
        {
            int tx = (int) (x + x2Move + bounds.x) / Tile.TILEWIDTH;
			
            if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
                    !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT))
            {
                x += x2Move;
            }
            else
            {
                x = tx * Tile.TILEWIDTH + Tile.TILEWIDTH - bounds.x;
            }
        }
    }
    
    public void moveY1()
    {
        if(y1Move < 0)
        {
            int ty = (int) (y + y1Move + bounds.y) / Tile.TILEHEIGHT;
			
            if(!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
		!collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty))
            {
                y += y1Move;
            }
            else
            {
                y = ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y;
            }
        }else if(y1Move > 0)
        {
            int ty = (int) (y + y1Move + bounds.y + bounds.height) / Tile.TILEHEIGHT;

            if(!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
                !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty))
            {
                y += y1Move;
            }
            else
            {
                y = ty * Tile.TILEHEIGHT - bounds.y - bounds.height - 1;
            }
        }
    }
    
    public void moveY2()
    {
        if(y2Move < 0)
        {
            int ty = (int) (y + y2Move + bounds.y) / Tile.TILEHEIGHT;
			
            if(!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
		!collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty))
            {
                y += y2Move;
            }
            else
            {
                y = ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y;
            }
        }else if(y2Move > 0)
        {
            int ty = (int) (y + y2Move + bounds.y + bounds.height) / Tile.TILEHEIGHT;

            if(!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
                !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty))
            {
                y += y2Move;
            }
            else
            {
                y = ty * Tile.TILEHEIGHT - bounds.y - bounds.height - 1;
            }
        }
    }
    
    protected boolean collisionWithTile(int x, int y)
    {
        return handler.getWorld().getTile(x,y).isSolid();
    }
    private void checkBorder()
    {
        if(x < 50)
        {
            x = 50;
        }
        if(x >= 960)
        {
            x = 960;
        }
        if(y < 50)
        {
            y = 50;
        }
        if(y >= 960)
        {
            y = 960;
        }
    }
    
    //Getters/Setters
    
    public int getHealth()
    {
        return health;
    }
    public void setHealth(int health)
    {
        this.health = health;
    }
    public float getSpeed()
    {
        return speed;
    }
    public void setSpeed(float speed)
    {
        this.speed = speed;
    }
    public float getX1Move()
    {
        return x1Move;
    }
    public void setX1Move(int xMove)
    {
        this.x1Move = xMove;
    }
    public float getY1Move()
    {
        return y1Move;
    }
    public void setY1Move(float yMove)
    {
        this.y1Move = yMove;
    }
    public float getVX1Move()
    {
        return vx1Move;
    }
    public void setVX1Move(int vxMove)
    {
        this.vx1Move = vxMove;
    }
    public float getVY1Move()
    {
        return vy1Move;
    }
    public void setVY1Move(float vyMove)
    {
        this.vy1Move = vyMove;
    }
    public float getAngle1()
    {
        return angle1;
    }
    public void setAngle1(short angle)
    {
        this.angle1 = angle;
    }
    public float getX2Move()
    {
        return x2Move;
    }
    public void setX2Move(int xMove)
    {
        this.x2Move = xMove;
    }
    public float getY2Move()
    {
        return y2Move;
    }
    public void setY2Move(float yMove)
    {
        this.y2Move = yMove;
    }
    public float getVX2Move()
    {
        return vx2Move;
    }
    public void setVX2Move(int vxMove)
    {
        this.vx2Move = vxMove;
    }
    public float getVY2Move()
    {
        return vy2Move;
    }
    public void setVY2Move(float vyMove)
    {
        this.vy2Move = vyMove;
    }
    public float getAngle2()
    {
        return angle2;
    }
    public void setAngle2(short angle)
    {
        this.angle2 = angle;
    }
}
