/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game3;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {
    private Timer timer;
    
    private Circle craft;
    private Rect rectangle;
    private URL url = null;
    private final int DELAY = 10;
    private final int B_WIDTH = 350;
    private final int B_HEIGHT = 350;

    public Board() throws Exception {
       initBoard();
    }
    
    private void initBoard() throws Exception {
        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        craft = new Circle(40,300,30,30);
        rectangle = new Rect(50, 300,30,30);
        
        timer = new Timer(DELAY, this);
        timer.start();        
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }

    private void doDrawing(Graphics g) {
       Graphics2D g2d = (Graphics2D) g;
       g2d.setColor(Color.RED);
       g2d.fillOval(craft.getX(), craft.getY(), craft.getWidth(), craft.getHeight());
       g2d.drawRect(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        craft.move();
        rectangle.move();
        
        checkCollisions();
        repaint();  
    }
    
    
    public void checkCollisions() {
     Rectangle rCraft = craft.getBounds();
     Rectangle rAlien = rectangle.getBounds();
     
     if (rCraft.intersects(rAlien)) {
         try {
             //Necesidad de los hilos se va a evidenciar.
             url = new URL("file:ball.wav");
             AudioClip ac = Applet.newAudioClip(url);
             ac.play();
             
             System.out.println("Colision");
         
         } catch (MalformedURLException ex) {
             Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
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