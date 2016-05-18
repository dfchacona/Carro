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
 * @author Estudiante
 */
public class Obstaculo {
    private int y;
    private int x;
    
    
    protected void dibujar (Graphics g){
        
        
        g.fillOval(x+200, y+300, 50, 50);
       g.drawRect(x+200, y+300, 50, 50);
        
    }
    public Rectangle obtenerRectangulo(){
            return new Rectangle(x+200, y+300, 50,50);
        }
    public void mover(){
        this.x+=1;
        
    }
}
