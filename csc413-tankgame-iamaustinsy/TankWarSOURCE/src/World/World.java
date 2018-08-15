/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package World;

import Entity.Creatures.Player.Player;
import Entity.EntityManager;
import Entity.statics.Brick;
import Entity.statics.BrickUnbreakable;
import Entity.statics.Buff;
import Entity.statics.Shield;
import Tiles.Tile;
import Util.Utils;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import tankwar.Game;
import tankwar.Handler;

/**
 *
 * @author iamaustinsy
 */
public class World 
{
    private Handler handler;
    private static int width, height;
    private int spawnX, spawnY;
    private int[][] tiles;
    
    private EntityManager entityManager;
    private Game game;
    public World(Handler handler, String path)
    {
        this.handler = handler;
        game = handler.getGame();
        entityManager = new EntityManager(handler, new Player(handler, 100, 100));
        
        createObstacles();
        
        loadWorld(path);
        
        entityManager.getPlayer().setX(spawnX);
        entityManager.getPlayer().setY(spawnY);
    }
    
    public void tick()
    {
        entityManager.tick();
    }
    
    public void render(Graphics g)
    {
        int xStart = (int) Math.max(0, handler.getGameCamera().getXOffset() / Tile.TILEWIDTH);
        int xEnd = (int) Math.min(width, (handler.getGameCamera().getXOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
        int yStart = (int) Math.max(0, handler.getGameCamera().getYOffset() / Tile.TILEHEIGHT);
        int yEnd = (int) Math.min(height, (handler.getGameCamera().getYOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);
        
        for(int y = yStart; y < yEnd; y++)
        {
            for(int x = xStart; x < xEnd; x++)
            {
                getTile(x,y).render(g,(int) (x * Tile.TILEWIDTH - handler.getGameCamera().getXOffset()), (int) (y * Tile.TILEHEIGHT - handler.getGameCamera().getYOffset()));
            }
        }
        
        //Entity
        entityManager.render(g);
        
        
    }
    
    public void createObstacles()
    {
        for(int i = 0; i < 2400; i += Tile.TILEWIDTH)
        {
             entityManager.addEntity(new BrickUnbreakable(handler, i, 0));
        }
        for(int i = 0; i < 2400; i += Tile.TILEHEIGHT)
        {
             entityManager.addEntity(new BrickUnbreakable(handler, 0, i));
        }
        for(int i = 0; i < 2400; i += Tile.TILEWIDTH)
        {
             entityManager.addEntity(new BrickUnbreakable(handler, i, 2280));
        }
        for(int i = 0; i < 2400; i += Tile.TILEHEIGHT)
        {
             entityManager.addEntity(new BrickUnbreakable(handler, 2340, i));
        }
        
        
        for(int i = 400; i < 1500; i += Tile.TILEHEIGHT)
        {
             entityManager.addEntity(new BrickUnbreakable(handler, 1800, i));
        }
        for(int i = 200; i < 1000; i += Tile.TILEWIDTH)
        {
             entityManager.addEntity(new BrickUnbreakable(handler, i, 2100));
        }
        for(int i = 1600; i < 2280; i += Tile.TILEHEIGHT)
        {
             entityManager.addEntity(new BrickUnbreakable(handler, i, 2200));
        }
        
        for(int i = 180; i < 880; i += Tile.TILEHEIGHT)
        {
             entityManager.addEntity(new Brick(handler, 300, i));
        }
        for(int i = 500; i < 1000; i += Tile.TILEWIDTH)
        {
             entityManager.addEntity(new Brick(handler, 600, i));
        }
        
        for(int i = 500; i < 1000; i += Tile.TILEWIDTH)
        {
             entityManager.addEntity(new Brick(handler, 900, i));
        }
        for(int i = 60; i < 300; i += Tile.TILEWIDTH)
        {
             entityManager.addEntity(new Brick(handler, 1000 + i, 1000 ));
        }
        for(int i = 60; i < 800; i += Tile.TILEWIDTH)
        {
             entityManager.addEntity(new Brick(handler, 200 + i, 1200));
        }
        
        for(int i = 500; i < 1000; i += Tile.TILEWIDTH)
        {
             entityManager.addEntity(new Brick(handler, 900, i));
        }
        entityManager.addEntity(new Shield(handler, 500, 500));
        entityManager.addEntity(new Buff(handler, 500, 70));
    }
    
    public Tile getTile(int x, int y)
    {
        if(x < 0 || y < 0 || x >= width || y >= height)
        {
            return Tile.groundTile;
        }
        
        Tile t = Tile.tiles[tiles[x][y]];
        if(t == null)
        {
            return Tile.groundTile;
        }
        return t;
    }
    
    private void loadWorld(String path)
    {
        String file = Utils.loadFileAsString(path);
        String[] tokens = file.split("\\s+");
        width = Utils.parseInt(tokens[0]);
        height = Utils.parseInt(tokens[1]);
        spawnX = Utils.parseInt(tokens[2]);
        spawnY = Utils.parseInt(tokens[3]);
        
        tiles = new int[width][height];
        for(int y = 0; y < height; y++)
        {
            for(int x = 0; x < width; x++)
            {
                tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
            }
        }
    }
    
    public static int getWidth()
    {
        return width;
    }
    public static int getHeight()
    {
        return height;
    }
    
    public EntityManager getEntityManager()
    {
        return entityManager;
    }
}
