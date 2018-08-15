/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package State;

import Graphix.ImageLoader;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import tankwar.Game;
import tankwar.Handler;

/**
 *
 * @author iamaustinsy
 */
public class MenuState extends State
{
    public static BufferedImage background;
    
    public MenuState(Handler handler) //Constructor
    {
        super(handler);
    }

    @Override
    public void tick() 
    {
        if(handler.getMouseManager().isGameState())
        {
            State.setState(handler.getGame().gameState);
        }
        if(handler.getMouseManager().isQuitState())
        {
            System.exit(0);
        }
        //System.out.println(handler.getMouseManager().getMouseX() + "   " + handler.getMouseManager().getMouseY());
    }
    
    public Rectangle playButton = new Rectangle(500, 600, 200, 100);
    public Rectangle quitButton = new Rectangle(500, 700, 200, 100);
    
    
    
    @Override
    public void render(Graphics g) 
    {
        Graphics2D g2d = (Graphics2D) g;
        background = ImageLoader.loadImage("/Title/Title.png");
        g.drawImage(background, 0,0, null);
        Font fnt0 = new Font("arial", Font.BOLD, 50);
        g.setFont(fnt0);
        g.setColor(Color.black);
        g.drawString("Play", playButton.x + 50, playButton.y + 68);
        g2d.draw(playButton);
        g.drawString("Quit", quitButton.x + 50, quitButton.y + 68);
        g2d.draw(quitButton);
        
    }
    
}
