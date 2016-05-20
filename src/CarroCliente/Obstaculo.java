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

/**
 *
 * @author Diego Chacon 
 */
public class Obstaculo {
    private int y;
    private int x;

    public Obstaculo(int x, int y) {
        this.y = y;
        this.x = x;
    }

    
    
    
    public void dibujar (Graphics g){
        
        
       g.fillOval(x+40, y+50, 10, 10);
      
        
    }
    public Rectangle obtenerRectangulo(){
            return new Rectangle(x+40, y+50, 10,10);
        }
    public void mover(){
        this.x+=1;
        
    }
}
