/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game2;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;


public class Main extends JFrame {
    
    public Main() throws Exception {

        initUI();
    }

    private void initUI() throws Exception {
        add(new Board());
        setSize(1024, 512);
        setTitle("Game2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
         
    }    
    
    public static void main(String[] args) {
        try {
            Main ex = new Main();
            ex.setVisible(true);
        } catch (Exception ex1) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex1);
        }
     
    }
}