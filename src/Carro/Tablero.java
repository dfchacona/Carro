/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Carro;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.*;

/**
 *
 * @author Estudiante
 */
public class Tablero extends JPanel implements ActionListener{
    
    private Timer timer;
    Carro c1;
    Carro c2= new Carro();
    Obstaculo o1= new Obstaculo();
    private ServerSocket serverSocket ;
    private Socket carro1 ;
    private Socket carro2;
    
    
    public Tablero() throws IOException, InterruptedException{
            this.c1 = new Carro();
            this.c2= new Carro();
            this.serverSocket = new ServerSocket(8000);
            
            
            carro1=this.serverSocket.accept();
            carro2=this.serverSocket.accept();
            System.out.println("Acepte un cliente");
            Thread proceso = new Thread(new Hilo(carro1,c1));
            Thread proceso2 = new Thread(new Hilo(carro2,c2));
            proceso.start();
            proceso2.start();
            this.timer = new Timer(50, this);
            this.timer.start();
       
       
    }
    
     protected void paintComponent (Graphics g){
        super.paintComponent(g);
        c1.dibujar(g);
        c2.dibujar(g);
        
        
    }
   

    @Override
    public void actionPerformed(ActionEvent e){
       
       repaint();
       
       
    }

    public void validarColisiones(){
        Rectangle r1= this.c1.obtenerRectangulo();
        Rectangle r2= this.o1.obtenerRectangulo();
        if(r1.intersects(r2)){
            JOptionPane.showMessageDialog(null, "Colision");
        }
    }
}
