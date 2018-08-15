/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import static Entity.Creatures.Creature.DEFAULT_HEALTH;
import State.GameOver;
import State.State;
import java.awt.Graphics;
import java.awt.Rectangle;
import tankwar.Game;
import tankwar.Handler;

/**
 *
 * @author iamaustinsy
 */
public abstract class Entity 
{
    public static final int DEFAULT_HEALTH = 2;
    public static final int DEFAULT_HEALTH_PLAYER = 10;
    protected Handler handler;
    protected float x, y; //Float for smoother movement on screen
    protected int width, height;
    public static Rectangle bounds;
    protected int health;
    protected boolean active = true;
    protected int lives;
    
    public Entity(Handler handler, float x, float y, int width, int height)
    {
        this.handler = handler;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        health = DEFAULT_HEALTH;
        bounds = new Rectangle(0, 0, width, height);
    }
    
    public abstract void tick();

    public abstract void render(Graphics g);
    
    public abstract void die();
    
    public void hurt(int amt)
    {
        health -= amt;
        if(lives > 0 && health == 0)
        {
            lives--;
            health = DEFAULT_HEALTH_PLAYER;
            System.out.println("You have " + lives + " lives left!");
            x = 100;
            y = 100;
        }
        if(health <= 0)
        {
            active = false;
            die();
            
        }
    }
    
    public boolean checkEntityCollision(float xOffset, float yOffset)
    {
        for(Entity e: handler.getWorld().getEntityManager().getEntities())
        {
            if(e.equals(this))
            {
                continue;
            }
            if(e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset)))
            {
                return true;
            }
        }
        return false;
    }
    
    public Rectangle getCollisionBounds(float xOffset, float yOffset)
    {
        return new Rectangle((int) (x + bounds.x + xOffset), (int)(y + bounds.y + yOffset), bounds.width, bounds.height);
    }
    
    public static Rectangle getBounds()
    {
        return bounds;
    }
    
    public float getX()
    {
        return x;
    }
    public void setX(float x)
    {
        this.x = x;
    }
    public float getY()
    {
        return y;
    }
    public void setY(float y)
    {
        this.y = y;
    }
    public float getWidth()
    {
        return width;
    }
    public void setWidth(int width)
    {
        this.width = width;
    }
    public float getHeight()
    {
        return height;
    }
    public void setHeight(int height)
    {
        this.height = height;
    }
    public int getHealth()
    {
        return health;
    }
    public void setHealth(int health)
    {
        this.health = health;
    }
    public int getLives()
    {
        return lives;
    }
    public void setLives(int lives)
    {
        this.lives = lives;
    }
    public boolean isActive()
    {
        return active;
    }
    public void setActive(boolean active)
    {
        this.active = active;
    }
     public boolean isSolid()
    {
        return true;
    }
}
