/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notepad18.app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import notepad18.buttons.NotepadMenu;

/**
 *
 * @author Lucas
 * 
 * Esta é a classe principal do Notepad. Ela também é o objeto JFrame de todo o programa.
 * Guarda instâncias das classes:
 *      NotepadMenu: trabalha com tudo relacionado aos menus
 *      NotepadTextArea: trabalha com tudo relacionado à área do texto.
 * 
 */
public class NotepadWindow extends JFrame{
    
    int HEIGHT = 640;
    int WIDTH = 480;
    
    private NotepadMenu menu = new NotepadMenu();
    private NotepadTextArea textArea = new NotepadTextArea();
    //private JScrollPane scrollArea;
    
    public NotepadWindow(){
        
        this.setSize(WIDTH, HEIGHT);
        this.setTitle("Notepad18");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout()); // the BorderLayout bit makes it fill it automatically
	this.getContentPane().add(textArea);
        
        menu.initialize(this);
        this.setMenuBar(menu);
    }
    
    public NotepadTextArea getTextArea(){
        return textArea;
    }
    
    public void close(){
        this.dispose();
    }
    
    public void resetText(){
        textArea.setText(new String());
    }
      
    public void whiteBackground(){
        textArea.setBackground(Color.white);
    }
    
    public void blackBackground(){
        textArea.setBackground(Color.black);
    }
    
    public void Font8(){
        textArea.setFont(new Font("Times New Roman", Font.BOLD, 8));
    }
    
    public void Font10(){
        textArea.setFont(new Font("Times New Roman", Font.BOLD, 10));
    }
    
    public void Font12(){
        textArea.setFont(new Font("Times New Roman", Font.BOLD, 12));
    }
    
    public void Font14(){
        textArea.setFont(new Font("Times New Roman", Font.BOLD, 14));
    }
    
    public void Font16(){
        textArea.setFont(new Font("Times New Roman", Font.BOLD, 16));
    }
    
    public void redFont(){
        textArea.setForeground(Color.red);
    }
    
    public void orangeFont(){
        textArea.setForeground(Color.orange);
    }
    
    public void yellowFont(){
        textArea.setForeground(Color.yellow);
    }
    
    public void greenFont(){
        textArea.setForeground(Color.green);
    }
    
    public void cyanFont(){
        textArea.setForeground(Color.cyan);
    }
    
    public void blueFont(){
        textArea.setForeground(Color.blue);
    }
    
    public void purpleFont(){
        textArea.setForeground(Color.magenta);
    }
    
    public void whiteFont(){
        textArea.setForeground(Color.white);
    }
    
    public void blackFont(){
        textArea.setForeground(Color.black);
    }
    
    public void customizationReset(){
        textArea.setBackground(Color.white);
        textArea.setFont(new Font("Times New Roman", Font.BOLD, 12));
        textArea.setForeground(Color.black);
    }
}
