/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Carro;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import javax.swing.*;

/**
 *
 * @author Estudiante
 */
public class Carro {
    private int x; 
    private int y;
    
    
     protected void dibujar (Graphics g){
        
        g.setColor(Color.red);
        g.fillOval(x+50, y+125, 50, 50);
        g.fillOval(x+150, y+125, 50, 50);
        g.setColor(Color.blue);
        g.fillRect(x+5, y+75, 250, 50);
        g.setColor(Color.blue);
        int [] puntosX= {x+50,x+100,x+150,x+200};
        int [] puntosY= {y+75, y+50, y+50,y+75};
        Polygon p= new Polygon(puntosX, puntosY, 4);
        g.setColor(Color.blue);
        g.fillPolygon(p);
        g.setColor(Color.black);
        
        g.drawOval(x+55,y+130, 40, 40);
        g.drawOval(x+155, y+130, 40, 40);
        g.drawRect(x+5,y+50,250,125);
        
    }
      
   

    public Rectangle obtenerRectangulo() {
        return new Rectangle(x+5, y+50, 250,125);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void mover() {
       
    }

   
}
