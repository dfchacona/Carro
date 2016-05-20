/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Carro;

import java.awt.Dimension;
import java.io.IOException;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Diego Chacon 
 */
public class Main {
        public static void main(String[] args) throws IOException, InterruptedException {
        JFrame frame = new JFrame();
        frame.setTitle("Carro");
        frame.setSize(new Dimension(500, 500));
        frame.setLocationRelativeTo(null);
        frame.add(new Tablero());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
