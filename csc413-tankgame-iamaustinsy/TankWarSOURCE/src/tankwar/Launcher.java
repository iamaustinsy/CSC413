/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tankwar;

import Display.Display;

/**
 *
 * @author iamaustinsy
 */
public class Launcher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        Game game = new Game("Tank War!", 1100, 1100);
        game.start();
    }
    
}
