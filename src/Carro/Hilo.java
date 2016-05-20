/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Carro;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego Chacon 
 */
public class Hilo implements Runnable{
    private Socket socket ; 
    DataInputStream entrada;
    DataOutputStream salida;
    private Carro personajePrincipal;
    private Tag tag; 
    
    public Hilo(Socket socket,Carro personajePrincipal, Tag tag) throws IOException{
      this.tag=tag;
      this.socket = socket;
      this.entrada = new DataInputStream(socket.getInputStream());
      this.salida = new DataOutputStream(this.socket.getOutputStream());
      this.personajePrincipal = personajePrincipal;
    }

    @Override
    public void run() {
        while(true){
            try {
                
                int recibi = this.entrada.readInt();
                
                switch (recibi) {
                case 1: 
                    this.tag.setX(this.tag.getX()-5);
                    this.personajePrincipal.setX(this.personajePrincipal.getX() - 5);
                    break;
                    
                case 2:
                    this.tag.setX(this.tag.getX()+5);
                    this.personajePrincipal.setX( this.personajePrincipal.getX() +5); break;
                    
                case 3: 
                    this.tag.setY(this.tag.getY()-5);
                    this.personajePrincipal.setY(this.personajePrincipal.getY() -5); break;
                    
                case 4:
                    this.tag.setY(this.tag.getY()+5);
                    this.personajePrincipal.setY( this.personajePrincipal.getY()+5); break;
              }
                
            } catch (IOException ex) {
                Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
            }
               
             
            
        }
    }
    
}
