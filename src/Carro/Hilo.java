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
 * @author B106 PC-11
 */
public class Hilo implements Runnable{
    private Socket socket ; 
    DataInputStream entrada;
    DataOutputStream salida;
    private Carro personajePrincipal;
    
    public Hilo(Socket socket,Carro personajePrincipal) throws IOException{
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
                System.out.println("recibi"  + recibi);
                switch (recibi) {
                case 1: 
                    this.personajePrincipal.setX(this.personajePrincipal.getX() - 10 );
                    break;
                case 2: this.personajePrincipal.setX( this.personajePrincipal.getX() +10); break;
                case 3: this.personajePrincipal.setY(this.personajePrincipal.getY() -10); break;
                case 4: this.personajePrincipal.setY(10 + this.personajePrincipal.getY()); break;
              }
                
            } catch (IOException ex) {
                Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
            }
               
             
            
        }
    }
    
}
