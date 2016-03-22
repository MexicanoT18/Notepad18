/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notepad18.app;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import notepad18.buttons.NotepadMenu;

/**
 *
 * @author Lucas
 */
public class NotepadWindow extends JFrame{
    
    int HEIGHT = 640;
    int WIDTH = 480;
    int BUTTOM_HEIGHT = 50;
    
    private NotepadMenu menu = new NotepadMenu();
    private NotepadTextArea textArea = new NotepadTextArea();
    
    public NotepadWindow(){
        
        this.setSize(WIDTH, HEIGHT);
        this.setTitle("Notepad18");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout()); // the BorderLayout bit makes it fill it automatically
	this.getContentPane().add(textArea);
        
        
        
        menu = new NotepadMenu();
        menu.initialize(this);
        this.setMenuBar(menu);
    }
    
    public NotepadTextArea getTextArea(){
        return textArea;
    }
    
    public void close(){
        this.dispose();
    }
    
}
