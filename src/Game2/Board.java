/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game2;


import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Board extends JPanel implements ActionListener {

    private Timer timer;
    private Craft craft;
    private Alien alien;
    private Coin coin;
    private final int DELAY = 10;
    private Image background;
    

    public Board() throws Exception {
       initBoard();
        
    }
    
    private void initBoard() throws Exception {
        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        craft = new Craft(40,300);
        alien = new Alien(40,300);
        coin = new Coin(60, 200);
             
        timer = new Timer(DELAY, this);
        timer.start();        
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
      
        Graphics2D g2d = (Graphics2D) g;
        ImageIcon ii = new ImageIcon("fondo.png");
        Image bardejov = ii.getImage();
        g2d.drawImage(bardejov, 0, 0, null);
     
        int w = bardejov.getWidth(this);
        int h =  bardejov.getHeight(this);
        setPreferredSize(new Dimension(w, h));   
       
        doDrawing(g);
        Toolkit.getDefaultToolkit().sync();
    }

    private void doDrawing(Graphics g) {
        //Dibujando el Craft
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(craft.getImage(), craft.getX(), craft.getY(), this);   
        
        //Dibujando el alien
        g2d.drawImage(alien.getImage(), alien.getX(), alien.getY(), this);   
        
        if(coin != null)
        g2d.drawImage(this.coin.getImage(), this.coin.getX(), this.coin.getY(), this);   
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        craft.move();
        updateAliends();
        checkCollisions();
        updateCoin();
        repaint();  
    }

    public void updateAliends(){
       if (alien.isVisible()) {
            alien.move();
        }
    }
    
     public void updateCoin(){
        if(coin != null) 
       if (this.coin.isVisible()) {
            this.coin.move();
        }else{
         this.coin = null;
       }
    }
    
    public void checkCollisions() {

     Rectangle rCraft = craft.getBounds();
     Rectangle rAlien = alien.getBounds();
     
     if (rCraft.intersects(rAlien)) {
          System.out.println("Han colisionado .....");
      }
     
      if(coin != null){
      Rectangle moneda = this.coin.getBounds();
         if(rCraft.intersects(moneda)){
             System.out.println("A colisionado con la moneda");
             this.coin.setVisible(false);
         }
      }
    }
    
    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            craft.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            craft.keyPressed(e);
        }
    }
}