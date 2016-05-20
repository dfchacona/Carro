/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Carro;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Diego Chacon 
 */
public class Tag {

    private int y;
    private int x;
    private String string;
    Color color;

    public Tag(int x, int y, String string) {
        this.y = y;
        this.x = x;
        this.string=string;
    }
    
    public void dibujar (Graphics g, Color color){
        
       g.setColor(color);
       g.drawString(string, x+40, y+10);
       
        
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
   
 
}
