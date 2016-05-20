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
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author Diego Chacon 
 */
public class Tablero extends JPanel implements ActionListener{
    
    private Timer timer;
    Carro c1;
    Carro c2;
    private  ArrayList<Obstaculo> obstaculos;
    private ServerSocket serverSocket ;
    private Socket carro1 ;
    private Socket carro2;
    private int puntajeJug1=0;
    private int puntajeJug2=0;
    private Tag tagJ1; 
    private Tag tagJ2; 
    private int puntosPorJugar=5;
    
    
    public Tablero() throws IOException, InterruptedException{
      
            this.c1 = new Carro(10,30);
            this.c2= new Carro(10,30);
            tagJ1= new Tag(10, 30, "J1");
            tagJ2= new Tag(10, 30, "J2");
            this.serverSocket = new ServerSocket(8000);
            this.obstaculos = new ArrayList();
            this.obstaculos.add(new Obstaculo(100,100));
            this.obstaculos.add(new Obstaculo(150,150));
            this.obstaculos.add(new Obstaculo(250,90));
            this.obstaculos.add(new Obstaculo(300,250));
            this.obstaculos.add(new Obstaculo(130,400));
            
            carro1=this.serverSocket.accept();
            System.out.println("Jugador 1 listo");
            carro2=this.serverSocket.accept();
            System.out.println("Jugador 2 listo");
            Thread proceso1 = new Thread(new Hilo(carro1, c1, tagJ1));
            Thread proceso2 = new Thread(new Hilo(carro2, c2, tagJ2));
            proceso1.start();
            proceso2.start();
            this.timer = new Timer(50, this);
            this.timer.start();
            
       
    }
    
    @Override
     protected void paintComponent (Graphics g){
        super.paintComponent(g);
        this.c1.dibujar(g);
        this.c2.dibujar(g);
        this.tagJ1.dibujar(g, Color.BLUE);
        this.tagJ2.dibujar(g, Color.RED);
        for(Obstaculo o1: obstaculos){
            g.setColor(Color.YELLOW);
            o1.dibujar(g);
        }
        g.setColor(Color.BLUE);
        g.drawString("Puntaje J1:" + puntajeJug1, 10, 10);
        
        g.setColor(Color.RED);
        g.drawString("Puntaje J2:" + puntajeJug2, 150, 10);
    }
   

    @Override
    public void actionPerformed(ActionEvent e){
       validarColisiones();
       repaint();
       if(this.puntosPorJugar==0){
           if(puntajeJug1>puntajeJug2){
               JOptionPane.showMessageDialog(null, "JUGADOR 1 GANA");
               JOptionPane.showConfirmDialog(null, "Desea Jugar de nuevo?");
           }else{
               JOptionPane.showMessageDialog(null, "JUGADOR 2 GANA");
           
       
       
    }}}

    public void validarColisiones(){
        ArrayList <Obstaculo> copia = (ArrayList <Obstaculo>) this.obstaculos.clone();
        Rectangle r1= this.c1.obtenerRectangulo();
        Rectangle r2= this.c2.obtenerRectangulo();
        for(Obstaculo o1 : obstaculos){
           Rectangle RecCir = o1.obtenerRectangulo();
           if(r1.intersects(RecCir)){
               
               copia.remove(o1);
               this.puntajeJug1++;
               this.puntosPorJugar--;
           }  
           if(r2.intersects(RecCir)){
               
               copia.remove(o1);
               this.puntajeJug2++;
               this.puntosPorJugar--;
           }    
           }
           this.obstaculos=copia;
    }
    
}

