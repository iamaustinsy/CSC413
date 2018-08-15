/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tankwar;

import Display.Display;
import Graphix.Assets;
import Graphix.GameCamera;
import Graphix.ImageLoader;
import Input.KeyManager;
import Input.MouseManager;
import State.GameOver;
import State.GameState;
import State.MenuState;
import State.State;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

/**
 *
 * @author iamaustinsy
 */
public class Game implements Runnable
{
    private Display display;
    private int width, height;
    public String title;
    
    private boolean isRunning = false;
    private Thread thread;
    
    private BufferStrategy bs;
    private Graphics g;
    
    //States
    public State gameState;
    public State menuState;
    public State gameOverState;
    
    //Input
    private KeyManager keyManager;
    private MouseManager mouseManager;
    
    //Camera 
    private GameCamera gameCamera;
    
    //Handler
    private Handler handler;
    
    public static Controller c;
    
    public Game(String title, int width, int height)
    {
        this.width = width;
        this.height = height;
        this.title = title;
        keyManager = new KeyManager();
        mouseManager = new MouseManager();
    }
    
    private void init()
    {      
        display = new Display(title, height, width);
        display.getFrame().addKeyListener(keyManager);
        display.getFrame().addMouseListener(mouseManager);
        display.getFrame().addMouseMotionListener(mouseManager);
        display.getCanvas().addMouseListener(mouseManager);
        display.getCanvas().addMouseMotionListener(mouseManager);
        Assets.init();
        
        handler = new Handler(this);
        gameCamera = new GameCamera(handler, 0, 0);
        c = new Controller(handler);
        
        gameState = new GameState(handler);
        menuState = new MenuState(handler);
        gameOverState = new GameOver(handler);
        
        State.setState(menuState);
        music();
    }
    
    private void update()
    {
        keyManager.tick();
        if(State.getState() != null)
        {
            State.getState().tick();
        }
        c.tick();
    }
    
    private void render()
    {
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null)
        {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        //Clear screen
        g.clearRect(0, 0, width, height);
        //Draw to canvas here
        
        if(State.getState() != null)
        {
            State.getState().render(g);
        }
        c.render(g);

        //End
        bs.show();
        g.dispose();
    }
    
    public void run()
    {
        init();
        
        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;
        
        while(isRunning)
        {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += (now - lastTime);
            lastTime = now;
            
            if(delta >= 1)
            {
                update();
                render();
                ticks++;
                delta--;
            }
            
            if(timer >= 1000000000)
            {
                System.out.println("Ticks and Frames: " + ticks);
                ticks = 0;
                timer = 0;
            }
        }
        
        stop();
    }
    
    public static void music() 
    {  
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("Resources\\Sound\\Music.wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch(Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }  
    
    public KeyManager getKeyManager()
    {
        return keyManager;
    }
    
    public MouseManager getMouseManager()
    {
        return mouseManager;
    }
    
    public GameCamera getGameCamera()
    {
        return gameCamera;
    }
    
    public int getWidth()
    {
        return width;
    }
    
    public int getHeight()
    {
        return height;
    }
    
    public synchronized void start()
    {
        if(isRunning)//Make sure the code doesn't re-initialize while running
        {
            return;
        }
        isRunning = true;
        thread = new Thread(this);
        thread.start();
    }
    
    public synchronized void stop()
    {
        if(!isRunning)
        {
            return;
        }
        isRunning = false;
        try 
        {
            thread.join();
        } catch (InterruptedException ex) 
        {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
