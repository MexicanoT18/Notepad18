/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notepad18.app;

import java.awt.Font;
import java.awt.TextArea;

/**
 *
 * @author Lucas
 * 
 * Trabalha com tudo relacionado ao texto. É um objeto TextArea.
 * 
 */
public class NotepadTextArea extends TextArea{
    
    public NotepadTextArea(){
        
        super("", 0,0, TextArea.SCROLLBARS_VERTICAL_ONLY);
        
        this.setFont(new Font("Century Gothic", Font.BOLD, 12));
        
    }
    
}
