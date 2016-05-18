/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game3;


import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class SwingTimerExample extends JFrame {

    public SwingTimerExample() throws Exception {
        initUI();
    }
    
    private void initUI() throws Exception {
        add(new Board());
        setResizable(false);
        pack();
        
        setTitle("Example");
        setLocationRelativeTo(null);        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        try {
            JFrame ex = new SwingTimerExample();                
            ex.setVisible(true);
        } catch (Exception ex1) {
            Logger.getLogger(SwingTimerExample.class.getName()).log(Level.SEVERE, null, ex1);
        }
         
    }
}