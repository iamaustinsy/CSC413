/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tiles;

import Graphix.Assets;
import static Tiles.Tile.TILEHEIGHT;
import static Tiles.Tile.TILEWIDTH;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author iamaustinsy
 */
public class Brick2 extends Tile
{
    
    public Brick2(int id) {
        super(Assets.brick2, id);
    }

    @Override
    public boolean isSolid()
    {
        return true;
    }
}
