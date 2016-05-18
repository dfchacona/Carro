/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarroCliente;

import Carro.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Estudiante
 */
public class Tablero extends JPanel implements ActionListener, KeyListener{
    
    private Timer timer;
    Carro c1= new Carro();
    Carro c2= new Carro();
    Obstaculo o1= new Obstaculo();
    private Socket cliente ;
    private DataInputStream entrada;
    private DataOutputStream salida;
    
    
    
    public Tablero() throws IOException{
        this.timer= new Timer(50, this);
        this.setFocusable(true);
        
        addKeyListener(this);
        cliente=new Socket("localhost",8000);
        System.out.println("Me conecte a un servidor");
        
        this.salida = new DataOutputStream(cliente.getOutputStream());
        this.timer.start();
    }
    
     protected void paintComponent (Graphics g){
        super.paintComponent(g);
        c1.dibujar(g);
        
        
    }
   

    @Override
    public void actionPerformed(ActionEvent e){
      
       repaint();
       
       
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
       int codigo=-1;
        try {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_SPACE) {
            codigo=1;
        }

        if (key == KeyEvent.VK_A) {
            codigo=1;
        }

        if (key == KeyEvent.VK_D) {
           codigo=2;
        }

        if (key == KeyEvent.VK_W) {
           codigo=3;
        }

        if (key == KeyEvent.VK_S) {
           codigo=4;
        }
        
         this.c1.keyPressed(e);
         this.salida.writeInt(codigo);
         this.salida.flush();
       repaint();
    }   catch (IOException ex) {
            Logger.getLogger(Tablero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    public void validarColisiones(){
        Rectangle r1= this.c1.obtenerRectangulo();
        Rectangle r2= this.o1.obtenerRectangulo();
        if(r1.intersects(r2)){
            JOptionPane.showMessageDialog(null, "Colision");
        }
    }
}
