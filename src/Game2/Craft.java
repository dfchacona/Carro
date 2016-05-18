/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game2;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class Craft extends Sprite{

    private int dx;
    private int dy;
    private String[] walk;
    private int posWalk;
    
    /**
     *
     */
    public Craft(int x, int y) throws Exception {
        super(x, y);
        
        this.walk = new String[4];
        this.posWalk = 0;
        this.walk[0] = "walk/walk01";
        this.walk[1] = "walk/walk02";
        this.walk[2] = "walk/walk03";
        this.walk[3] = "walk/walk04";
        
        initCraft();
    }
    
    private void initCraft() throws Exception {
        loadImage("smasher//stand//stand01.png");
         getImageDimensions();
     }


    public void move() {
        loadImage("smasher//stand//stand01.png");
        y = 300;
     
        try {
           Thread.sleep(40);
        } catch (InterruptedException ex) {
              Logger.getLogger(Craft.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       if(dx > 0){
         loadImage("smasher//" + this.walk[this.posWalk] + ".png");
         
          if(this.posWalk ==3)
              this.posWalk =0;
          else
              this.posWalk++;
       
       }
        
       x += dx;
       y += dy;
        
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return image;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_SPACE) {
            System.out.println("VK_SPACE"); //Se  va usar posteriormente 
        }
        
        if (key == KeyEvent.VK_LEFT) {
            dx = -5;
        }

        if (key == KeyEvent.VK_RIGHT) {
           dx = 5;
          
        }

        if (key == KeyEvent.VK_UP) {
            dy = -200;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 1;
        }
    }

    public void keyReleased(KeyEvent e) {
    
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }
}