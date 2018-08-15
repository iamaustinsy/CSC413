/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphix;

import java.awt.image.BufferedImage;

/**
 *
 * @author iamaustinsy
 */
public class Assets 
{
    public static BufferedImage player1, player2, ground, brick1, brick2, bullet, shield, buff;
            
    public static void init()
    {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/Sprites/SpriteSheet.png"));
        
        //I tried to maintain the native size of the icon 
        ground = sheet.crop(0,0,319, 237);
        player1 = ImageLoader.loadImage("/Tank/Tank1.png");
        player2 = ImageLoader.loadImage("/Tank/Tank2.png");
        brick1 = sheet.crop(320, 0, 31, 30);
        brick2 = sheet.crop(320, 32, 31, 30);
        bullet = sheet.crop(320, 190, 25, 16);
        shield = ImageLoader.loadImage("/Weapons/Shield2.png");
        buff = ImageLoader.loadImage("/Weapons/Shield1.png");
    }
}
