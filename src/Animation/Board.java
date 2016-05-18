package Animation;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
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

public class Board extends JPanel  implements ActionListener {

    private final int B_WIDTH = 250;
    private final int B_HEIGHT = 200;
    private final int INITIAL_X = 0;
    private final int INITIAL_Y = 0;
    private final int DELAY = 25;
    private int dx;
    private int dy;
    private URL url = null;
    private Timer timer;
    private int x, y;

    public Board() {
        initBoard();
    }

    private void initBoard() {
       addKeyListener(new THandle());
       setFocusable(true);
       setBackground(Color.WHITE);
       setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
       setDoubleBuffered(true);
 
        x = INITIAL_X;
        y = INITIAL_Y;
        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    private void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.RED);
        x += dx;
        y += dy;
        g2d.fillOval(x, y, 30, 30);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        y = 100;

        if(x <= 0){
          x = 0;
        }
            
        if (x > B_WIDTH) {
            x = B_WIDTH;
        }
        repaint();
    }

    private class THandle extends KeyAdapter {

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
            try {
                dy = -100;
                url = new URL("file:ball.wav");
                AudioClip ac = Applet.newAudioClip(url);
                ac.play();
                
                
            } catch (MalformedURLException ex) {
                Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 5;
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
}