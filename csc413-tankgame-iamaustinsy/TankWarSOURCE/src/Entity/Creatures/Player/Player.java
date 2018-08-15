/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity.Creatures.Player;

import Entity.Creatures.Creature;
import Graphix.Assets;
import Input.MouseManager;
import State.State;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import tankwar.Game;
import static tankwar.Game.c;
import tankwar.Handler;

/**
 *
 * @author iamaustinsy
 */


public class Player extends Creature
{
    //private ArrayList<Bullet> firedBullets = new ArrayList<Bullet>();
    private static long lastAttackTimer, attackCD = 300, attackTimer = attackCD;
    private int xPosY, yPosX;
    private static int Score;
    public Player(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
        
        bounds.x = 6;
        bounds.y = 11;
        bounds.width = 53;
        bounds.height = 44;
        health = 10;
        lives = 3;
        Score = 0;
    }

    @Override
    public void tick() 
    {
        getInput();
        move();
        
        handler.getGameCamera().centerOnEntity(this);
        System.out.println("Lives: " + lives);
        System.out.println("Health: " + health);
    }
    
    @Override
    public void die()
    {
        System.out.println("You Lose!");
        //System.exit(0);
        MouseManager.isGame = false;
        MouseManager.isQuit = false;
        State.setState(handler.getGame().gameOverState);
    }
    
    private void getInput()
    {
        x1Move = 0;
        y1Move = 0;
        x2Move = 0;
        y2Move = 0;
        attackTimer += System.currentTimeMillis() - lastAttackTimer;
        lastAttackTimer = System.currentTimeMillis();
        
        xPosY = (int)(101 * Math.cos(Math.toRadians(angle1)) + ( x - handler.getGameCamera().getXOffset() + (DEFAULT_CREATURE_WIDTH / 2)));
        yPosX = (int)(101 * Math.sin(Math.toRadians(angle1)) + ( y -handler.getGameCamera().getYOffset() + (DEFAULT_CREATURE_HEIGHT / 2)));
            
        if(handler.getKeyManager().p1up)
        {
            moveForwards();
        }
        if(handler.getKeyManager().p1down)
        {
            moveBackwards();
        }
        if(handler.getKeyManager().p1left)
        {
            rotateLeft();
        }
        if(handler.getKeyManager().p1right)
        {
            rotateRight();
        }
        if(handler.getKeyManager().p1shoot)
        {
            if(attackTimer < attackCD)
            {
                return;
            } 
            
            c.addBullet(new Bullet(handler, (int)(xPosY + handler.getGameCamera().getXOffset() + (DEFAULT_CREATURE_WIDTH / 2)), (int)(yPosX + handler.getGameCamera().getYOffset() + (DEFAULT_CREATURE_HEIGHT / 2)), angle1));
            
        }
        
        if(handler.getKeyManager().p2up)
        {
            moveForwards();
        }
        if(handler.getKeyManager().p2down)
        {
            moveBackwards();
        }
        if(handler.getKeyManager().p2left)
        {
            rotateLeft();
        }
        if(handler.getKeyManager().p2right)
        {
            rotateRight();
        }
        if(handler.getKeyManager().p2shoot)
        {
            if(attackTimer < attackCD)
            {
                return;
            } 
            
            c.addBullet(new Bullet(handler,(int) (x  - handler.getGameCamera().getXOffset() +  DEFAULT_CREATURE_WIDTH ), (int) (y - handler.getGameCamera().getYOffset() + DEFAULT_CREATURE_HEIGHT), angle1));
            
        }
        attackTimer = 0;
    }
    
    @Override
    public void render(Graphics g) 
    {

        AffineTransform rotation = AffineTransform.getTranslateInstance((int) (x - handler.getGameCamera().getXOffset()), (int) (y - handler.getGameCamera().getYOffset()));
        rotation.rotate(Math.toRadians(angle1), DEFAULT_CREATURE_WIDTH / 2, DEFAULT_CREATURE_HEIGHT / 2);
        Graphics2D graphic2D = (Graphics2D) g;
        graphic2D.drawImage(Assets.player1, rotation, null);
        
        
        //Cursor
        int newX = (int)(50 * Math.cos(Math.toRadians(angle1)) + ( x - handler.getGameCamera().getXOffset() + (DEFAULT_CREATURE_WIDTH / 2)));
        int newY = (int)(50 * Math.sin(Math.toRadians(angle1)) + ( y - handler.getGameCamera().getYOffset() + (DEFAULT_CREATURE_HEIGHT / 2)));
        
        //UI
        //g.drawOval(newX, newY, 10, 10);
        g.setColor(Color.red);
        g.fillRect((int)x  - (int)handler.getGameCamera().getXOffset() - 20, (int) (y - handler.getGameCamera().getYOffset() - 20), 10 * 10, 10);
        g.setColor(Color.green);
        g.fillRect((int)x  - (int)handler.getGameCamera().getXOffset() - 20, (int) (y - handler.getGameCamera().getYOffset() - 20), health * 10, 10);
        g.setColor(Color.blue);
        for(int i = 0; i < lives; i++)
        {
            g.fillOval((int)x  - (int)handler.getGameCamera().getXOffset() + (20 * i), (int) (y - handler.getGameCamera().getYOffset() - 40), 10, 10);
        }
        
    }
    
    private void rotateLeft()
    {
        angle1 -= 3;
    }
    private void rotateRight()
    {
        angle1 += 3;
    }
    private void moveBackwards() {
        vx1Move = (int) Math.round(r * Math.cos(Math.toRadians(angle1)));
        vy1Move = (int) Math.round(r * Math.sin(Math.toRadians(angle1)));
        x1Move -= vx1Move;
        y1Move -= vy1Move;
    }
    private void moveForwards()
    {
        vx1Move = (int) Math.round(r * Math.cos(Math.toRadians(angle1)));
        vy1Move = (int) Math.round(r * Math.sin(Math.toRadians(angle1)));
        x1Move += vx1Move;
        y1Move += vy1Move;
    }
    
    public static long getCD()
    {
        return attackCD;
    }
    public void setCD(long cd)
    {
        this.attackCD = cd;
        
    }
    public static int getScore()
    {
        return Score;
    }
    public void setScore(int score)
    {
        this.Score = score;
        
    }
    public void addScore(int score)
    {
        Score += score; 
    }
}
