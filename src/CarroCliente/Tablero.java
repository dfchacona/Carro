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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Diego Chacon 
 */
public class Tablero extends JPanel implements ActionListener, KeyListener{
    
    private Timer timer;
    Carro c1= new Carro(10,30);
    ArrayList <Obstaculo> obstaculos;
    
    private Socket cliente ;
    private DataInputStream entrada;
    private DataOutputStream salida;
    
    
    
    public Tablero() throws IOException{
        this.timer= new Timer(50, this);
        this.setFocusable(true);
        this.obstaculos = new ArrayList();
        this.obstaculos.add(new Obstaculo(100,100));
        this.obstaculos.add(new Obstaculo(150,150));
        this.obstaculos.add(new Obstaculo(250,90));
        this.obstaculos.add(new Obstaculo(300,250));
        this.obstaculos.add(new Obstaculo(130,400));
        addKeyListener(this);
        cliente=new Socket("localhost",8000);
        System.out.println("Me conecte a un servidor");
        
        this.salida = new DataOutputStream(cliente.getOutputStream());
        this.entrada= new DataInputStream(cliente.getInputStream());
        this.timer.start();
        
    }
    
     protected void paintComponent (Graphics g){
        super.paintComponent(g);
        for(Obstaculo o1: obstaculos){
            o1.dibujar(g);
        }
        c1.dibujar(g);
        
        
        
    }
   

    @Override
    public void actionPerformed(ActionEvent e){
       validarColisiones();
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
    public void validarColisiones() {
        ArrayList <Obstaculo> copia = (ArrayList <Obstaculo>) this.obstaculos.clone();
        Rectangle r1= this.c1.obtenerRectangulo();
        for(Obstaculo o1 : obstaculos){
           Rectangle RecCir = o1.obtenerRectangulo();
           if(r1.intersects(RecCir)){
               copia.remove(o1);
               
           }
           this.obstaculos=copia;   
           
    }

 
   
}
}
