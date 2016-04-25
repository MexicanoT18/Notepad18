/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notepad18.app;

import java.awt.Font;
import javax.swing.*;

/**
 *
 * @author Lucas
 * 
 * Trabalha com tudo relacionado ao texto. É um objeto TextArea.
 * 
 */
public class NotepadTextArea extends JTextPane{
    
    public NotepadTextArea(){
        super();
        //super("", 0,0, JTextArea.SCROLLBARS_VERTICAL_ONLY);
        
        this.setFont(new Font("Times New Roman", Font.BOLD, 12));
        
    }
    
    public void append (String s){
        setText (getText() + s);
    }
    
}
