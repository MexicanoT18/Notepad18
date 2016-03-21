/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notepad18.app;

import javax.swing.JFrame;

/**
 *
 * @author Lucas
 */
public class NotepadWindow extends JFrame{
    
    int HEIGHT = 640;
    int WIDTH = 480;
    int BUTTOM_HEIGHT = 50;
    
    public MainWindow(){
        
        this.setTitle("Notepad18");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
     //   this.setSize(0, 0, WIDTH, HEIGHT);
    }
    
}
