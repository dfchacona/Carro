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
      
   

    public Rectangle obtenerRectangulo() {
        return new Rectangle(x+2, y+20,100,50);
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
