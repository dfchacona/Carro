/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarroCliente;

import Carro.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.*;

/**
 *
 * @author Diego Chacon 
 */
public class Carro {
    private int x; 
    private int y;
    DataOutputStream toServerX;
    DataOutputStream toServerY;

    public Carro(int x, int y) {
        this.x = x;
        this.y = y;
    }

    
     protected void dibujar (Graphics g){
        
      g.setColor(Color.red);
        g.fillOval(x+20, y+50, 20, 20);
        g.fillOval(x+60, y+50, 20, 20);
        g.setColor(Color.blue);
        g.fillRect(x+2, y+30, 100, 20);
        g.setColor(Color.blue);
        int [] puntosX= {x+20,x+40,x+60,x+80};
        int [] puntosY= {y+30, y+20, y+20,y+30};
        Polygon p= new Polygon(puntosX, puntosY, 4);
        g.setColor(Color.blue);
        g.fillPolygon(p);
        g.setColor(Color.black);
        
        g.drawOval(x+22,y+52, 16, 16);
        g.drawOval(x+62, y+52, 16, 16);
        
        
    }
      public void keyPressed(KeyEvent e) throws IOException {
        switch(e.getKeyCode()){
            case KeyEvent.VK_D: 
        this.x+=5;
        
        
        break;
        case KeyEvent.VK_A:
        this.x-=5;
        
           
        break;
        case KeyEvent.VK_W:
        this.y-=5;
        
      
        break;        
        case KeyEvent.VK_S:
        
        this.y+=5;
           
        break;
        }
      
    }
   

    public Rectangle obtenerRectangulo() {
        return new Rectangle(x+2, y+20, 100,50);
    }
   
}
