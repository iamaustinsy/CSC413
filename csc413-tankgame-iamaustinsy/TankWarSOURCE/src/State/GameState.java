/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package State;

import Entity.Creatures.Player.Player;
import Entity.statics.Brick;
import Graphix.Assets;
import Tiles.Tile;
import World.World;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import tankwar.Game;
import tankwar.Handler;

/**
 *
 * @author iamaustinsy
 */
public class GameState extends State
{
    private Player player;
    private World world;
    
    
    public GameState(Handler handler) //Constructor
    {
        super(handler);
        world = new World(handler, "Resources/worlds/world2.txt");
        handler.setWorld(world);    
    }
    
    @Override
    public void tick() 
    {
        world.tick();     
    }

    @Override
    public void render(Graphics g) 
    {
        world.render(g);   
        Font fnt0 = new Font("arial", Font.BOLD, 75);
        g.setFont(fnt0);
        g.setColor(Color.white);
        g.drawString("Score", handler.getWidth() - 375, 100);
        String score = Integer.toString(player.getScore());
        g.drawString(score, handler.getWidth() - 130, 100);
    }
    
}
